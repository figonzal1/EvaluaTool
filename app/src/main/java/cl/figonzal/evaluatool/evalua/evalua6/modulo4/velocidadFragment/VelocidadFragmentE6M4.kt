/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2021

 Last modified 14-05-21 18:53
 */

package cl.figonzal.evaluatool.evalua.evalua6.modulo4.velocidadFragment

import android.os.Build
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import androidx.fragment.app.Fragment
import cl.figonzal.evaluatool.R
import cl.figonzal.evaluatool.baremosTables.velocidadFragmentE6M4Baremo
import cl.figonzal.evaluatool.databinding.FragmentVelocidadE6M4Binding
import cl.figonzal.evaluatool.interfaces.EvaluaInterface
import cl.figonzal.evaluatool.utilidades.Utils
import cl.figonzal.evaluatool.utilidades.logInfo
import cl.figonzal.evaluatool.utilidades.showHelperDialog
import com.google.android.material.textfield.TextInputEditText

class VelocidadFragmentE6M4 : Fragment(), EvaluaInterface {

    companion object {
        private const val DESVIACION = 46.59
        private const val MEDIA = 157.82

        fun newInstance(): VelocidadFragmentE6M4 {
            return VelocidadFragmentE6M4()
        }
    }

    private var binding: FragmentVelocidadE6M4Binding? = null
    private val perc = velocidadFragmentE6M4Baremo()

    //TAREA 1
    private lateinit var etSegundosT1: TextInputEditText
    private var segundosT1 = 0

    //SUBTOTALES
    private lateinit var tvSubTotalT1: TextView
    private var totalPdT1 = 0.0

    //TOTALES
    private lateinit var tvPdTotal: TextView
    private lateinit var tvPdCorregido: TextView
    private lateinit var tvPercentil: TextView
    private lateinit var tvNivel: TextView
    private lateinit var tvDesviacionCalculada: TextView
    private lateinit var progressBar: ProgressBar

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentVelocidadE6M4Binding.inflate(inflater, container, false)

        initResources(binding!!)
        return binding!!.root
    }

    private fun initResources(binding: FragmentVelocidadE6M4Binding) {

        with(binding, {
            cardViewConstantes.tvMediaValue.text = MEDIA.toString()
            cardViewConstantes.tvDesviacionValue.text = DESVIACION.toString()

            //SUBTOTALES
            tvSubTotalT1 = tvPdSubtotalT1
            this@VelocidadFragmentE6M4.etSegundosT1 = etSegundosT1

            //TOTALES
            this@VelocidadFragmentE6M4.tvPdTotal = tvPdTotalValue
            tvPdCorregido = cardViewFinal.tvPdTotalCorregidoValue
            tvPercentil = cardViewFinal.tvPercentilValue
            tvNivel = cardViewFinal.tvNivelObtenidoValue
            tvDesviacionCalculada = cardViewFinal.tvDesviacionCalculadaValue

            progressBar = cardViewFinal.progressBar
            progressBar.max = perc.first()[1] as Int

            cardViewFinal.ivHelpPdCorregido.setOnClickListener {

                requireActivity().logInfo(R.string.DIALOGO_AYUDA_MSG_ABIERTO)
                requireActivity().showHelperDialog(requireFragmentManager())
            }
            Utils.configurarTextoBaremo(
                requireFragmentManager(),
                tablaBaremo.tvBaremo,
                perc,
                getString(R.string.TOOLBAR_VELOCIDAD)
            )
        }).also {
            textWatcherTarea1()
        }
    }

    private fun textWatcherTarea1() {

        with(etSegundosT1) {
            addTextChangedListener(object : TextWatcher {

                override fun beforeTextChanged(
                    s: CharSequence,
                    start: Int,
                    count: Int,
                    after: Int
                ) {
                    totalPdT1 = 0.0
                }

                override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}

                override fun afterTextChanged(s: Editable) {

                    when {
                        s.isEmpty() -> segundosT1 = 0
                        s.isNotEmpty() -> segundosT1 = text.toString().toInt()
                    }
                    totalPdT1 = calculateTask(
                        null,
                        tvSubTotalT1,
                        context.getString(R.string.TAREA_1),
                        segundosT1,
                        null,
                        null
                    )
                    calculateResult()
                }
            })
        }
    }

    override fun calculateTask(
        nTarea: Int?,
        tvSubTotal: TextView,
        tarea: String,
        aprobadas: Int?,
        omitidas: Int?,
        reprobadas: Int?
    ): Double {
        tvSubTotal.text = String.format(getString(R.string.SEG_FORMAT), tarea, aprobadas)
        return aprobadas!!.toDouble()
    }

    override fun calculateResult() {

        with(totalPdT1, {
            tvPdTotal.text = String.format(getString(R.string.SEG_SIMPLE_FORMAT), this)

            val pdCorregido = correctPD(perc, this.toInt())
            tvPdCorregido.text = String.format(getString(R.string.SEG_SIMPLE_FORMAT), pdCorregido)

            tvDesviacionCalculada.text =
                Utils.calcularDesviacion(MEDIA, DESVIACION, pdCorregido, true).toString()

            with(calculatePercentile(pdCorregido), {
                tvPercentil.text = this.toString()

                when {
                    Build.VERSION.SDK_INT >= Build.VERSION_CODES.N -> progressBar.setProgress(
                        this,
                        true
                    )
                    else -> progressBar.progress = this
                }

                tvNivel.text = Utils.calcularNivel(this)
            })
        })
    }

    override fun calculatePercentile(pdTotal: Int): Int {
        when {
            pdTotal < perc.first()[0] as Int -> return perc.first()[1] as Int
            pdTotal > perc.last()[0] as Int -> return perc.last()[1] as Int
            else -> perc.forEach { item ->
                if (pdTotal <= item.first() as Int) return item[1] as Int
            }
        }
        //Percentil no encontrado
        requireActivity().logInfo(R.string.TAG_PERCENTIL_CALCULADO, R.string.PERCENTIL_NULO)
        return -1
    }

    override fun correctPD(perc: Array<Array<Any>>, pdActual: Int): Int {
        when {
            pdActual < perc.first()[0] as Int -> return perc.first()[0] as Int
            pdActual > perc.last()[0] as Int -> return perc.last()[0] as Int
            else -> perc.forEach { item ->
                if (pdActual <= item.first() as Int) return item.first() as Int
            }
        }
        requireActivity().logInfo(R.string.TAG_PD_CORREGIDO, R.string.PD_NULO)
        return -1
    }

}