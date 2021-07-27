/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2021

 Last modified 26-07-21 20:14
 */

package cl.figonzal.evaluatool.evalua.evalua7.modulo3.adaptacionFragments

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
import cl.figonzal.evaluatool.databinding.FragmentMotivacionE7M3Binding
import cl.figonzal.evaluatool.resolvers.evalua7.modulo3.MotivacionFragmentE7M3Resolver
import cl.figonzal.evaluatool.resolvers.evalua7.modulo3.MotivacionFragmentE7M3Resolver.Companion.DESVIACION
import cl.figonzal.evaluatool.resolvers.evalua7.modulo3.MotivacionFragmentE7M3Resolver.Companion.MEDIA
import cl.figonzal.evaluatool.utilities.*
import com.google.android.material.progressindicator.LinearProgressIndicator
import com.google.android.material.textfield.TextInputEditText
import timber.log.Timber

class MotivacionFragmentE7M3 : Fragment() {

    companion object {
        fun newInstance(): MotivacionFragmentE7M3 {
            return MotivacionFragmentE7M3()
        }
    }

    private var binding: FragmentMotivacionE7M3Binding? = null

    private lateinit var etAprobadasT1: TextInputEditText
    private var aprobadasT1 = 0

    //TextView para Subtotales
    private lateinit var tvSubTotalT1: TextView

    //Tetview para total
    private lateinit var tvPdTotal: TextView
    private lateinit var tvPdCorregido: TextView
    private lateinit var tvPercentil: TextView
    private lateinit var tvNivel: TextView
    private lateinit var progressBar: LinearProgressIndicator
    private lateinit var tvDesviacionCalculada: TextView

    private val resolver by lazy {
        MotivacionFragmentE7M3Resolver()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentMotivacionE7M3Binding.inflate(inflater, container, false)

        initResources(binding!!)
        return binding!!.root
    }


    private fun initResources(binding: FragmentMotivacionE7M3Binding) {

        with(binding, {
            //Promedio y desviacion
            //TetView desviacion y media
            cardViewConstantes.tvMediaValue.text = MEDIA.toString()
            cardViewConstantes.tvDesviacionValue.text = DESVIACION.toString()

            //TAREA 1
            tvSubTotalT1 = tvPdSubtotalT1
            this@MotivacionFragmentE7M3.etAprobadasT1 = etAprobadasT1

            //TOTAL
            this@MotivacionFragmentE7M3.tvPdTotal = tvPdTotalValue
            tvPdCorregido = cardViewFinal.tvPdTotalCorregidoValue
            tvPercentil = cardViewFinal.tvPercentilValue
            tvNivel = cardViewFinal.tvNivelObtenidoValue
            tvDesviacionCalculada = cardViewFinal.tvDesviacionCalculadaValue

            progressBar = cardViewFinal.progressBar
            progressBar.max = resolver.perc.first()[1] as Int

            cardViewFinal.ivHelpPdCorregido.setOnClickListener {

                Timber.d(getString(R.string.DIALOGO_AYUDA_MSG_ABIERTO))
                requireActivity().alertDialogPdCorregido()
            }
            EvaluaUtils.configurarTextoBaremo(
                parentFragmentManager, tablaBaremo.tvBaremo, resolver.perc, getString(
                    R.string.TOOLBAR_MOTIVACION
                )
            )
        }).also {
            textWatcherTarea1(getString(R.string.TAREA_1))
        }
    }

    private fun textWatcherTarea1(tarea: String) {

        etAprobadasT1.run {
            addTextChangedListener(object : TextWatcher {

                override fun beforeTextChanged(
                    s: CharSequence,
                    start: Int,
                    count: Int,
                    after: Int
                ) {
                    resolver.totalPdTarea1 = 0.0
                }

                override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}

                override fun afterTextChanged(s: Editable) {

                    when {
                        s.isEmpty() -> aprobadasT1 = 0
                        s.isNotEmpty() -> aprobadasT1 = text.toString().toInt()
                    }
                    with(
                        resolver.calculateTask(
                            nTarea = 1,
                            aprobadas = aprobadasT1
                        ), {
                            resolver.totalPdTarea1 = this
                            tvSubTotalT1.text = requireActivity().formatSubTotalPoints(tarea, this)
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
            val pdCorregido = correctPD(perc, getTotal().toInt())
            tvPdCorregido.text = requireActivity().formatResult(
                R.string.POINTS_SIMPLE_FORMAT,
                pdCorregido.toDouble()
            )

            //Calculate desviation
            tvDesviacionCalculada.text =
                EvaluaUtils.calcularDesviacion2(MEDIA, DESVIACION, pdCorregido, reverse = true)

            //Calculate Percentile
            val percentile = EvaluaUtils.calculatePercentile(perc, pdCorregido, reverse = true)
            tvPercentil.text = percentile.toString()

            when {
                Build.VERSION.SDK_INT >= Build.VERSION_CODES.N -> progressBar.setProgressCompat(
                    percentile,
                    true
                )
                else -> progressBar.progress = percentile
            }

            //Calculate student level
            tvNivel.text = EvaluaUtils.calcularNivel(percentile)
        }
    }
}