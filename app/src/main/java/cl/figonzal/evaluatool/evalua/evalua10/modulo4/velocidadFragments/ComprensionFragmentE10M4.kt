/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2021

 Last modified 12-07-21 16:21
 */

package cl.figonzal.evaluatool.evalua.evalua10.modulo4.velocidadFragments

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
import cl.figonzal.evaluatool.databinding.FragmentComprensionE10M4Binding
import cl.figonzal.evaluatool.resolvers.evalua10.modulo4.ComprensionFragmentE10M4Resolver
import cl.figonzal.evaluatool.resolvers.evalua10.modulo4.ComprensionFragmentE10M4Resolver.Companion.DESVIACION
import cl.figonzal.evaluatool.resolvers.evalua10.modulo4.ComprensionFragmentE10M4Resolver.Companion.MEDIA
import cl.figonzal.evaluatool.utilidades.*
import com.google.android.material.progressindicator.LinearProgressIndicator
import com.google.android.material.textfield.TextInputEditText

class ComprensionFragmentE10M4 : Fragment() {

    companion object {
        fun newInstance(): ComprensionFragmentE10M4 {
            return ComprensionFragmentE10M4()
        }
    }

    private var binding: FragmentComprensionE10M4Binding? = null

    private lateinit var etAprobadasT1: TextInputEditText
    private lateinit var etOmitidasT1: TextInputEditText
    private lateinit var etReprobadasT1: TextInputEditText
    private var aprobadasT1 = 0
    private var omitidasT1 = 0
    private var reprobadasT1 = 0

    //TextView para Subtotales
    private lateinit var tvSubTotalT1: TextView

    //Tetview para total
    private lateinit var tvPdTotal: TextView
    private lateinit var tvPdCorregido: TextView
    private lateinit var tvNivelComprension: TextView
    private lateinit var tvPercentil: TextView
    private lateinit var tvNivel: TextView
    private lateinit var progressBar: LinearProgressIndicator
    private lateinit var tvDesviacionCalculada: TextView

    private val resolver by lazy {
        ComprensionFragmentE10M4Resolver()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentComprensionE10M4Binding.inflate(inflater, container, false)

        initResources(binding!!)
        return binding!!.root
    }


    private fun initResources(binding: FragmentComprensionE10M4Binding) {

        with(binding, {
            //Promedio y desviacion
            //TetView desviacion y media
            cardViewConstantes.tvMediaValue.text = MEDIA.toString()
            cardViewConstantes.tvDesviacionValue.text = DESVIACION.toString()

            //TAREA 1
            tvSubTotalT1 = tvPdSubtotalT1
            this@ComprensionFragmentE10M4.etAprobadasT1 = etAprobadasT1
            this@ComprensionFragmentE10M4.etOmitidasT1 = etOmitidasT1
            this@ComprensionFragmentE10M4.etReprobadasT1 = etReprobadasT1

            //TOTAL
            this@ComprensionFragmentE10M4.tvPdTotal = tvPdTotalValue
            tvPdCorregido = tvPdTotalCorregidoValue
            this@ComprensionFragmentE10M4.tvNivelComprension = tvNivelComprensionValue
            this@ComprensionFragmentE10M4.tvPercentil = tvPercentilValue
            tvNivel = tvNivelObtenidoValue
            this@ComprensionFragmentE10M4.tvDesviacionCalculada = tvDesviacionCalculadaValue

            this@ComprensionFragmentE10M4.progressBar = progressBar
            progressBar.max = resolver.perc.first()[1] as Int

            ivHelpPdCorregido.setOnClickListener {

                requireActivity().logInfo(R.string.DIALOGO_AYUDA_MSG_ABIERTO)
                requireActivity().alertDialogPdCorregido()
            }

            Utils.configurarTextoBaremo(
                parentFragmentManager,
                tablaBaremo.tvBaremo,
                resolver.perc,
                getString(R.string.TOOLBAR_COMPRENSION)
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
                            aprobadas = aprobadasT1,
                            omitidas = omitidasT1,
                            reprobadas = reprobadasT1
                        ), {
                            resolver.totalPdTarea1 = this
                            tvSubTotalT1.text = requireActivity().formatSubTotalPoints(tarea, this)
                        })
                    calculateResult()
                }
            })
        }

        etOmitidasT1.run {
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
                        s.isEmpty() -> omitidasT1 = 0
                        s.isNotEmpty() -> omitidasT1 = text.toString().toInt()
                    }
                    with(
                        resolver.calculateTask(
                            nTarea = 1,
                            aprobadas = aprobadasT1,
                            omitidas = omitidasT1,
                            reprobadas = reprobadasT1
                        ), {
                            resolver.totalPdTarea1 = this
                            tvSubTotalT1.text = requireActivity().formatSubTotalPoints(tarea, this)
                        })
                    calculateResult()
                }
            })
        }

        etReprobadasT1.run {
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
                        s.isEmpty() -> reprobadasT1 = 0
                        s.isNotEmpty() -> reprobadasT1 = text.toString().toInt()
                    }
                    with(
                        resolver.calculateTask(
                            nTarea = 1,
                            aprobadas = aprobadasT1,
                            omitidas = omitidasT1,
                            reprobadas = reprobadasT1
                        ), {
                            resolver.totalPdTarea1 = this
                            tvSubTotalT1.text = requireActivity().formatSubTotalPoints(tarea, this)
                        })
                    calculateResult()
                }
            })
        }
    }

    private fun calcularComprension(pd_actual: Int): String {
        return when (pd_actual) {
            in 0..2 -> getString(R.string.COMPRENSION_MUY_BAJA)
            in 3..4 -> getString(R.string.COMPRENSION_BAJA)
            in 5..6 -> getString(R.string.COMPRENSION_MEDIA)
            in 7..10 -> getString(R.string.COMPRENSION_ALTA)
            in 11..15 -> getString(R.string.COMPRENSION_MUY_ALTA)
            else -> {
                requireActivity().logInfo(
                    R.string.TAG_COMPRENSION_CALCULADA,
                    R.string.COMPRENSION_NULA
                )
                ""
            }
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

            val comprension = calcularComprension(pdCorregido)
            tvNivelComprension.text = comprension

            //Calculate desviation
            tvDesviacionCalculada.text =
                Utils.calcularDesviacion2(MEDIA, DESVIACION, pdCorregido)

            //Calculate Percentile
            val percentile = Utils.calculatePercentile(perc, pdCorregido)
            tvPercentil.text = percentile.toString()

            when {
                Build.VERSION.SDK_INT >= Build.VERSION_CODES.N -> progressBar.setProgressCompat(
                    percentile,
                    true
                )
                else -> progressBar.progress = percentile
            }

            //Calculate student level
            tvNivel.text = Utils.calcularNivel(percentile)
        }
    }
}