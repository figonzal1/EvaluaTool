/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2021

 Last modified 27-07-21 17:59
 */

package cl.figonzal.evaluatool.evalua.evalua6.modulo3.adaptacionFragments

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
import cl.figonzal.evaluatool.databinding.FragmentAutoControlE6M3Binding
import cl.figonzal.evaluatool.resolvers.evalua6.modulo3.AutoControlFragmentE6M3Resolver
import cl.figonzal.evaluatool.resolvers.evalua6.modulo3.AutoControlFragmentE6M3Resolver.Companion.DEVIATION
import cl.figonzal.evaluatool.resolvers.evalua6.modulo3.AutoControlFragmentE6M3Resolver.Companion.MEAN
import cl.figonzal.evaluatool.utilities.*
import cl.figonzal.evaluatool.utilities.EvaluaUtils.configurarTextoBaremo
import com.google.android.material.progressindicator.LinearProgressIndicator
import com.google.android.material.textfield.TextInputEditText

class AutoControlFragmentE6M3 : Fragment() {


    companion object {
        fun newInstance(): AutoControlFragmentE6M3 {
            return AutoControlFragmentE6M3()
        }
    }

    private var binding: FragmentAutoControlE6M3Binding? = null

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
        AutoControlFragmentE6M3Resolver()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentAutoControlE6M3Binding.inflate(inflater, container, false)

        initResources(binding!!)
        return binding!!.root
    }


    private fun initResources(binding: FragmentAutoControlE6M3Binding) {

        with(binding, {
            //Promedio y desviacion
            //TetView desviacion y media
            cardViewConstantes.tvMediaValue.text = MEAN.toString()
            cardViewConstantes.tvDesviacionValue.text = DEVIATION.toString()

            //TAREA 1
            tvSubTotalT1 = tvPdSubtotalT1
            this@AutoControlFragmentE6M3.etApprovedT1 = etAprobadasT1

            //TOTAL
            this@AutoControlFragmentE6M3.tvPdTotal = tvPdTotalValue
            tvPdCorrected = cardViewFinal.tvPdTotalCorregidoValue
            tvPercentile = cardViewFinal.tvPercentilValue
            tvLevel = cardViewFinal.tvNivelObtenidoValue
            tvCalculatedDeviation = cardViewFinal.tvDesviacionCalculadaValue

            progressBar = cardViewFinal.progressBar
            progressBar.max = resolver.perc.first()[1] as Int

            requireActivity().setAlertDialogCorregido(cardViewFinal.ivHelpPdCorregido)

            configurarTextoBaremo(
                parentFragmentManager,
                tablaBaremo.tvBaremo,
                resolver,
                getString(R.string.TOOLBAR_AUTOCONTROL)
            )
        }).also {
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
                        ), {
                            resolver.totalPdTask1 = this
                            tvSubTotalT1.text = requireActivity().formatSubTotalPoints(task, this)
                        })
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

            //Calculate desviation
            tvCalculatedDeviation.text =
                EvaluaUtils.calcularDesviacion2(MEAN, DEVIATION, pdCorrected, reverse = true)

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