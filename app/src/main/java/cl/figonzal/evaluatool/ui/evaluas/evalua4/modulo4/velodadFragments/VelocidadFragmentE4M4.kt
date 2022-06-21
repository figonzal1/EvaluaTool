/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2022

 Last modified 21-06-22 17:16
 */
package cl.figonzal.evaluatool.ui.evaluas.evalua4.modulo4.velodadFragments

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
import cl.figonzal.evaluatool.databinding.FragmentVelocidadE4M4Binding
import cl.figonzal.evaluatool.domain.resolvers.evalua4.modulo4.VelocidadFragmentE4M4Resolver
import cl.figonzal.evaluatool.domain.resolvers.evalua4.modulo4.VelocidadFragmentE4M4Resolver.Companion.DEVIATION
import cl.figonzal.evaluatool.domain.resolvers.evalua4.modulo4.VelocidadFragmentE4M4Resolver.Companion.MEAN
import cl.figonzal.evaluatool.utils.EvaluaUtils
import cl.figonzal.evaluatool.utils.EvaluaUtils.configBaremoText
import cl.figonzal.evaluatool.utils.formatResult
import cl.figonzal.evaluatool.utils.formatSubTotalPoints
import cl.figonzal.evaluatool.utils.setAlertDialogCorregido
import com.google.android.material.progressindicator.LinearProgressIndicator
import com.google.android.material.textfield.TextInputEditText
import org.koin.android.ext.android.inject

class VelocidadFragmentE4M4 : Fragment() {

    companion object {
        fun newInstance(): VelocidadFragmentE4M4 {
            return VelocidadFragmentE4M4()
        }
    }

    private var _binding: FragmentVelocidadE4M4Binding? = null
    private val binding get() = _binding!!

    //TAREA 1
    private lateinit var etSecondsT1: TextInputEditText
    private var secondsT1 = 0

    //SUBTOTALES
    private lateinit var tvSubTotalT1: TextView

    //TOTALES
    private lateinit var tvPdTotal: TextView
    private lateinit var tvPdCorrected: TextView
    private lateinit var tvPercentile: TextView
    private lateinit var tvLevel: TextView
    private lateinit var tvCalculatedDeviation: TextView
    private lateinit var progressBar: LinearProgressIndicator

    private val resolver: VelocidadFragmentE4M4Resolver by inject()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentVelocidadE4M4Binding.inflate(inflater, container, false)

        initResources(binding)
        return binding.root
    }

    private fun initResources(binding: FragmentVelocidadE4M4Binding) {

        with(binding) {
            cardViewConstantes.tvMediaValue.text = MEAN.toString()
            cardViewConstantes.tvDesviacionValue.text = DEVIATION.toString()

            //SUBTOTALES
            tvSubTotalT1 = tvPdSubtotalT1
            this@VelocidadFragmentE4M4.etSecondsT1 = etSegundosT1

            //TOTALES
            this@VelocidadFragmentE4M4.tvPdTotal = tvPdTotalValue
            tvPdCorrected = cardViewFinal.tvPdTotalCorregidoValue
            tvPercentile = cardViewFinal.tvPercentilValue
            tvLevel = cardViewFinal.tvNivelObtenidoValue
            tvCalculatedDeviation = cardViewFinal.tvDesviacionCalculadaValue

            this@VelocidadFragmentE4M4.progressBar = cardViewFinal.progressBar
            progressBar.max = resolver.percentile.first()[1].toInt()

            cardViewFinal.ivHelpPdCorregido.setAlertDialogCorregido()

            configBaremoText(
                parentFragmentManager,
                tablaBaremo.tvBaremo,
                resolver,
                getString(R.string.TOOLBAR_VELOCIDAD)
            )
        }.also {
            textWatcherTask1(getString(R.string.TAREA_1))
        }
    }

    private fun textWatcherTask1(task: String) {

        etSecondsT1.run {
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
                        s.isEmpty() -> secondsT1 = 0
                        s.isNotEmpty() -> secondsT1 = text.toString().toInt()
                    }
                    with(
                        resolver.calculateTask(
                            nTask = 1,
                            approved = secondsT1
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
                EvaluaUtils.calculateDeviation(MEAN, DEVIATION, pdCorrected, reverse = true)

            //Calculate Percentile
            val percentile =
                EvaluaUtils.calculatePercentile(percentile, pdCorrected, reverse = true)
            tvPercentile.text = percentile.toString()

            when {
                Build.VERSION.SDK_INT >= Build.VERSION_CODES.N -> progressBar.setProgressCompat(
                    percentile,
                    true
                )
                else -> progressBar.progress = percentile
            }

            //Calculate student level
            tvLevel.text = EvaluaUtils.calculateStudentLevel(percentile)
        }
    }
}