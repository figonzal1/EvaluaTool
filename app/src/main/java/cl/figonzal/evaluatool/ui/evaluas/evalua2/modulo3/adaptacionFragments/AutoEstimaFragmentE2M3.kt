/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2022

 Last modified 18-06-22 22:00
 */
package cl.figonzal.evaluatool.ui.evaluas.evalua2.modulo3.adaptacionFragments

import android.os.Build
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import cl.figonzal.evaluatool.R
import cl.figonzal.evaluatool.databinding.FragmentAutoEstimaE2M3Binding
import cl.figonzal.evaluatool.domain.resolvers.evalua2.modulo3.AutoEstimaFragmentE2M3Resolver
import cl.figonzal.evaluatool.domain.resolvers.evalua2.modulo3.AutoEstimaFragmentE2M3Resolver.Companion.DEVIATION
import cl.figonzal.evaluatool.domain.resolvers.evalua2.modulo3.AutoEstimaFragmentE2M3Resolver.Companion.MEDIA
import cl.figonzal.evaluatool.utils.EvaluaUtils
import cl.figonzal.evaluatool.utils.EvaluaUtils.configurarTextoBaremo
import cl.figonzal.evaluatool.utils.formatResult
import cl.figonzal.evaluatool.utils.formatSubTotalPoints
import cl.figonzal.evaluatool.utils.setAlertDialogCorregido
import com.google.android.material.progressindicator.LinearProgressIndicator
import com.google.android.material.textfield.TextInputEditText

class AutoEstimaFragmentE2M3 : Fragment() {

    companion object {
        fun newInstance(): AutoEstimaFragmentE2M3 {
            return AutoEstimaFragmentE2M3()
        }
    }

    private var binding: FragmentAutoEstimaE2M3Binding? = null

    private lateinit var etApprovedT1: TextInputEditText
    private var approvedT1 = 0

    //TextView para Subtotales
    private lateinit var tvSubTotalT1: TextView

    //Tetview para total
    private lateinit var tvPdTotal: TextView
    private lateinit var tvPdCorrected: TextView
    private lateinit var tvPercentile: TextView
    private lateinit var tvLevel: TextView
    private lateinit var progressBar: LinearProgressIndicator
    private lateinit var tvCalculatedDeviation: TextView

    private val resolver by lazy {
        AutoEstimaFragmentE2M3Resolver()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentAutoEstimaE2M3Binding.inflate(inflater, container, false)

        initResources(binding!!)
        return binding!!.root
    }

    private fun initResources(binding: FragmentAutoEstimaE2M3Binding) {

        with(binding) {
            //Promedio y desviacion
            //TetView desviacion y media
            cardViewConstantes.tvMediaValue.text = MEDIA.toString()
            cardViewConstantes.tvDesviacionValue.text = DEVIATION.toString()

            //TAREA 1
            tvSubTotalT1 = tvPdSubtotalT1
            this@AutoEstimaFragmentE2M3.etApprovedT1 = etAprobadasT1

            //TOTAL
            this@AutoEstimaFragmentE2M3.tvPdTotal = tvPdTotalValue
            tvPdCorrected = cardViewFinal.tvPdTotalCorregidoValue
            tvPercentile = cardViewFinal.tvPercentilValue
            tvLevel = cardViewFinal.tvNivelObtenidoValue
            tvCalculatedDeviation = cardViewFinal.tvDesviacionCalculadaValue

            progressBar = binding.cardViewFinal.progressBar
            progressBar.max = resolver.percentile.first()[1].toInt()

            cardViewFinal.ivHelpPdCorregido.setAlertDialogCorregido()

            configurarTextoBaremo(
                parentFragmentManager,
                tablaBaremo.tvBaremo,
                resolver,
                getString(R.string.TOOLBAR_AUTOESTIMA)
            )
        }.also { textWatcherTask1(getString(R.string.TAREA_1)) }
    }

    private fun textWatcherTask1(task: String) {

        etApprovedT1.run {
            addTextChangedListener(object : TextWatcher {

                override fun beforeTextChanged(
                    s: CharSequence,
                    start: Int,
                    count: Int,
                    after: Int
                ) {
                    resolver.totalPdTask1 = 0.0
                }

                override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}

                override fun afterTextChanged(s: Editable) {

                    when {
                        s.isEmpty() -> approvedT1 = 0
                        s.isNotEmpty() -> approvedT1 = text.toString().toInt()
                    }
                    with(
                        resolver.calculateTask(
                            nTask = 1,
                            approved = approvedT1
                        )
                    ) {
                        resolver.totalPdTask1 = this
                        tvSubTotalT1.text = requireActivity().formatSubTotalPoints(task, this)
                    }
                    calculateResult()
                }
            })
        }
    }

    private fun calculateResult() {

        //Calculate Total PD
        resolver.run {

            tvPdTotal.text =
                requireActivity().formatResult(R.string.POINTS_SIMPLE_FORMAT, getTotalPD())

            //Correct total pd based on Baremo Table
            val pdCorrected = correctPD(percentile, getTotalPD().toInt())
            tvPdCorrected.text = requireActivity().formatResult(
                R.string.POINTS_SIMPLE_FORMAT,
                pdCorrected.toDouble()
            )

            //Calculate desviation
            tvCalculatedDeviation.text =
                EvaluaUtils.calcularDesviacion2(MEDIA, DEVIATION, pdCorrected)

            //Calculate Percentile
            val percentile = EvaluaUtils.calculatePercentile(percentile, pdCorrected)
            tvPercentile.text = percentile.toString()

            when {
                Build.VERSION.SDK_INT >= Build.VERSION_CODES.N -> progressBar.setProgressCompat(
                    percentile,
                    true
                )
                else -> progressBar.progress = percentile
            }

            //Calculate student level
            tvLevel.text = EvaluaUtils.calcularNivel(percentile)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}