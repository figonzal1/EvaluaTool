/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2022

 Last modified 19-06-22 02:56
 */
package cl.figonzal.evaluatool.ui.evaluas.evalua7.modulo4.velocidadFragments

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
import cl.figonzal.evaluatool.databinding.FragmentComprensionE7M4Binding
import cl.figonzal.evaluatool.domain.resolvers.evalua7.modulo4.ComprensionFragmentE7M4Resolver
import cl.figonzal.evaluatool.domain.resolvers.evalua7.modulo4.ComprensionFragmentE7M4Resolver.Companion.DEVIATION
import cl.figonzal.evaluatool.domain.resolvers.evalua7.modulo4.ComprensionFragmentE7M4Resolver.Companion.MEAN
import cl.figonzal.evaluatool.utils.EvaluaUtils
import cl.figonzal.evaluatool.utils.EvaluaUtils.configurarTextoBaremo
import cl.figonzal.evaluatool.utils.formatResult
import cl.figonzal.evaluatool.utils.formatSubTotalPoints
import cl.figonzal.evaluatool.utils.setAlertDialogCorregido
import com.google.android.material.progressindicator.LinearProgressIndicator
import com.google.android.material.textfield.TextInputEditText
import timber.log.Timber

class ComprensionFragmentE7M4 : Fragment() {

    companion object {
        fun newInstance(): ComprensionFragmentE7M4 {
            return ComprensionFragmentE7M4()
        }
    }

    private var _binding: FragmentComprensionE7M4Binding? = null
    private val binding get() = _binding!!

    private lateinit var etApprovedT1: TextInputEditText
    private lateinit var etOmittedT1: TextInputEditText
    private lateinit var etReprobateT1: TextInputEditText
    private var approvedT1 = 0
    private var omittedT1 = 0
    private var reprobateT1 = 0

    //TextView para Subtotales
    private lateinit var tvSubTotalT1: TextView

    //Tetview para total
    private lateinit var tvPdTotal: TextView
    private lateinit var tvPdCorrected: TextView
    private lateinit var tvComprehensionLevel: TextView
    private lateinit var tvPercentile: TextView
    private lateinit var tvLevel: TextView
    private lateinit var progressBar: LinearProgressIndicator
    private lateinit var tvCalculatedDeviation: TextView

    private val resolver by lazy {
        ComprensionFragmentE7M4Resolver()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentComprensionE7M4Binding.inflate(inflater, container, false)

        initResources(binding)
        return binding.root
    }


    private fun initResources(binding: FragmentComprensionE7M4Binding) {

        with(binding) {
            //Promedio y desviacion
            //TetView desviacion y media
            cardViewConstantes.tvMediaValue.text = MEAN.toString()
            cardViewConstantes.tvDesviacionValue.text = DEVIATION.toString()

            //TAREA 1
            tvSubTotalT1 = tvPdSubtotalT1
            this@ComprensionFragmentE7M4.etApprovedT1 = etAprobadasT1
            this@ComprensionFragmentE7M4.etOmittedT1 = etOmitidasT1
            this@ComprensionFragmentE7M4.etReprobateT1 = etReprobadasT1

            //TOTAL
            this@ComprensionFragmentE7M4.tvPdTotal = tvPdTotalValue
            tvPdCorrected = tvPdTotalCorregidoValue
            this@ComprensionFragmentE7M4.tvComprehensionLevel = tvNivelComprensionValue
            this@ComprensionFragmentE7M4.tvPercentile = tvPercentilValue
            tvLevel = tvNivelObtenidoValue
            this@ComprensionFragmentE7M4.tvCalculatedDeviation = tvDesviacionCalculadaValue

            this@ComprensionFragmentE7M4.progressBar = progressBar
            progressBar.max = resolver.percentile.first()[1].toInt()

            ivHelpPdCorregido.setAlertDialogCorregido()

            configurarTextoBaremo(
                parentFragmentManager,
                tablaBaremo.tvBaremo,
                resolver,
                getString(R.string.TOOLBAR_COMPRENSION)
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
                            approved = approvedT1,
                            omitted = omittedT1,
                            reprobate = reprobateT1
                        )
                    ) {
                        resolver.totalPdTask1 = this
                        tvSubTotalT1.text = requireActivity().formatSubTotalPoints(task, this)
                    }
                    calculateResult()
                }
            })
        }

        etOmittedT1.run {
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
                        s.isEmpty() -> omittedT1 = 0
                        s.isNotEmpty() -> omittedT1 = text.toString().toInt()
                    }
                    with(
                        resolver.calculateTask(
                            nTask = 1,
                            approved = approvedT1,
                            omitted = omittedT1,
                            reprobate = reprobateT1
                        )
                    ) {
                        resolver.totalPdTask1 = this
                        tvSubTotalT1.text = requireActivity().formatSubTotalPoints(task, this)
                    }
                    calculateResult()
                }
            })
        }

        etReprobateT1.run {
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
                        s.isEmpty() -> reprobateT1 = 0
                        s.isNotEmpty() -> reprobateT1 = text.toString().toInt()
                    }
                    with(
                        resolver.calculateTask(
                            nTask = 1,
                            approved = approvedT1,
                            omitted = omittedT1,
                            reprobate = reprobateT1
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

    private fun calculateComprehension(pdCurrent: Int): String {
        return when (pdCurrent) {
            in 0..2 -> getString(R.string.COMPRENSION_MUY_BAJA)
            in 3..4 -> getString(R.string.COMPRENSION_BAJA)
            in 5..6 -> getString(R.string.COMPRENSION_MEDIA)
            in 7..10 -> getString(R.string.COMPRENSION_ALTA)
            in 11..15 -> getString(R.string.COMPRENSION_MUY_ALTA)
            else -> {
                Timber.d(
                    getString(
                        R.string.COMPRENSION_NULA
                    )
                )
                ""
            }
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

            val comprehension = calculateComprehension(pdCorrected)
            tvComprehensionLevel.text = comprehension

            //Calculate desviation
            tvCalculatedDeviation.text =
                EvaluaUtils.calcularDesviacion2(MEAN, DEVIATION, pdCorrected)

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

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}