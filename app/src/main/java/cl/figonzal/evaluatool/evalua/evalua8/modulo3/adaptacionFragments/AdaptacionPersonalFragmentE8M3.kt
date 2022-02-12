/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2021

 Last modified 27-07-21 17:59
 */

package cl.figonzal.evaluatool.evalua.evalua8.modulo3.adaptacionFragments

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
import cl.figonzal.evaluatool.databinding.FragmentAdaptacionPersonalE8M3Binding
import cl.figonzal.evaluatool.resolvers.evalua8.modulo3.AdaptacionPersonalFragmentE8M3Resolver
import cl.figonzal.evaluatool.resolvers.evalua8.modulo3.AdaptacionPersonalFragmentE8M3Resolver.Companion.MEAN
import cl.figonzal.evaluatool.utilities.EvaluaUtils
import cl.figonzal.evaluatool.utilities.EvaluaUtils.configurarTextoBaremo
import cl.figonzal.evaluatool.utilities.formatResult
import cl.figonzal.evaluatool.utilities.formatSubTotalPoints
import cl.figonzal.evaluatool.utilities.setAlertDialogCorregido
import com.google.android.material.progressindicator.LinearProgressIndicator
import com.google.android.material.textfield.TextInputEditText

class AdaptacionPersonalFragmentE8M3 : Fragment() {

    companion object {
        fun newInstance(): AdaptacionPersonalFragmentE8M3 {
            return AdaptacionPersonalFragmentE8M3()
        }
    }

    private var binding: FragmentAdaptacionPersonalE8M3Binding? = null

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

    private val resolver by lazy {
        AdaptacionPersonalFragmentE8M3Resolver()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentAdaptacionPersonalE8M3Binding.inflate(inflater, container, false)

        initResources(binding!!)
        return binding!!.root
    }

    private fun initResources(binding: FragmentAdaptacionPersonalE8M3Binding) {

        with(binding) {
            //Promedio y desviacion
            //TetView desviacion y media
            tvMediaValue.text = MEAN.toString()

            //TAREA 1
            tvSubTotalT1 = tvPdSubtotalT1
            this@AdaptacionPersonalFragmentE8M3.etApprovedT1 = etAprobadasT1

            //TOTAL
            this@AdaptacionPersonalFragmentE8M3.tvPdTotal = tvPdTotalValue
            tvPdCorrected = tvPdTotalCorregidoValue
            this@AdaptacionPersonalFragmentE8M3.tvPercentile = tvPercentilValue
            tvLevel = tvNivelObtenidoValue

            this@AdaptacionPersonalFragmentE8M3.progressBar = progressBar
            progressBar.max = resolver.perc.first()[1] as Int

            requireActivity().setAlertDialogCorregido(ivHelpPdCorregido)

            configurarTextoBaremo(
                parentFragmentManager,
                tablaBaremo.tvBaremo,
                resolver,
                getString(R.string.TOOLBAR_ADAP_PERSONAL)
            )
        }.also {
            textWatcherTask1(getString(R.string.TAREA_1))
        }
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
                requireActivity().formatResult(R.string.POINTS_SIMPLE_FORMAT, getTotal())

            //Correct total pd based on Baremo Table
            val pdCorrected = correctPD(perc, getTotal().toInt())
            tvPdCorrected.text = requireActivity().formatResult(
                R.string.POINTS_SIMPLE_FORMAT,
                pdCorrected.toDouble()
            )

            //Calculate Percentile
            val percentile = EvaluaUtils.calculatePercentile(perc, pdCorrected, reverse = true)
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