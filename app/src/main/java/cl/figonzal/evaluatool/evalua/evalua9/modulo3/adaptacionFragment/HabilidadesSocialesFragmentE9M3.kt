/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2021

 Last modified 26-07-21 20:23
 */

package cl.figonzal.evaluatool.evalua.evalua9.modulo3.adaptacionFragment

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
import cl.figonzal.evaluatool.databinding.FragmentHabilidadesSocialesE9M3Binding
import cl.figonzal.evaluatool.resolvers.evalua9.modulo3.HabilidadesSocialesFragmentE9M3Resolver
import cl.figonzal.evaluatool.resolvers.evalua9.modulo3.HabilidadesSocialesFragmentE9M3Resolver.Companion.MEDIA
import cl.figonzal.evaluatool.utilities.*
import com.google.android.material.progressindicator.LinearProgressIndicator
import com.google.android.material.textfield.TextInputEditText
import timber.log.Timber

class HabilidadesSocialesFragmentE9M3 : Fragment() {

    companion object {
        fun newInstance(): HabilidadesSocialesFragmentE9M3 {
            return HabilidadesSocialesFragmentE9M3()
        }
    }

    private var binding: FragmentHabilidadesSocialesE9M3Binding? = null

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

    private val resolver by lazy {
        HabilidadesSocialesFragmentE9M3Resolver()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentHabilidadesSocialesE9M3Binding.inflate(inflater, container, false)

        initResources(binding!!)
        return binding!!.root
    }

    private fun initResources(binding: FragmentHabilidadesSocialesE9M3Binding) {

        with(binding, {
            //Promedio y desviacion
            //TetView desviacion y media
            tvMediaValue.text = MEDIA.toString()

            //TAREA 1
            tvSubTotalT1 = tvPdSubtotalT1
            this@HabilidadesSocialesFragmentE9M3.etAprobadasT1 = etAprobadasT1

            //TOTAL
            this@HabilidadesSocialesFragmentE9M3.tvPdTotal = tvPdTotalValue
            tvPdCorregido = tvPdTotalCorregidoValue
            this@HabilidadesSocialesFragmentE9M3.tvPercentil = tvPercentilValue
            tvNivel = tvNivelObtenidoValue

            this@HabilidadesSocialesFragmentE9M3.progressBar = progressBar
            progressBar.max = resolver.perc.first()[1] as Int

            ivHelpPdCorregido.setOnClickListener {

                Timber.d(getString(R.string.DIALOGO_AYUDA_MSG_ABIERTO))
                requireActivity().alertDialogPdCorregido()
            }
            EvaluaUtils.configurarTextoBaremo(
                parentFragmentManager,
                tablaBaremo.tvBaremo,
                resolver.perc,
                getString(R.string.TOOLBAR_HAB_SOCIALES)
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

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}