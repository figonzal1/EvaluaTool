/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2021

 Last modified 03-05-21 1:46
 */
package cl.figonzal.evaluatool.evalua.evalua7.modulo4.velocidadFragments

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
import cl.figonzal.evaluatool.databinding.FragmentVelocidadE7M4Binding
import cl.figonzal.evaluatool.interfaces.EvaluaInterface
import cl.figonzal.evaluatool.utilidades.Utils
import cl.figonzal.evaluatool.utilidades.logInfo
import cl.figonzal.evaluatool.utilidades.showHelperDialog
import com.google.android.material.textfield.TextInputEditText

class VelocidadFragmentE7M4 : Fragment(), EvaluaInterface {

    companion object {
        private const val DESVIACION = 68.21
        private const val MEDIA = 257.12

        fun newInstance(): VelocidadFragmentE7M4 {
            return VelocidadFragmentE7M4()
        }
    }

    private var binding: FragmentVelocidadE7M4Binding? = null
    private val perc = listOf(
            100 to 99,
            121 to 97,
            135 to 95,
            150 to 90,
            160 to 85,
            170 to 80,
            180 to 75,
            190 to 70,
            210 to 65,
            220 to 60,
            240 to 55,
            250 to 50,
            260 to 40,
            280 to 30,
            300 to 20,
            340 to 10,
            500 to 5
    )

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

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        binding = FragmentVelocidadE7M4Binding.inflate(inflater, container, false)

        initResources(binding!!)
        return binding!!.root
    }

    private fun initResources(binding: FragmentVelocidadE7M4Binding) {

        with(binding, {
            cardViewConstantes.tvMediaValue.text = MEDIA.toString()
            cardViewConstantes.tvDesviacionValue.text = DESVIACION.toString()

            //SUBTOTALES
            tvSubTotalT1 = tvPdSubtotalT1
            this@VelocidadFragmentE7M4.etSegundosT1 = etSegundosT1

            //TOTALES
            this@VelocidadFragmentE7M4.tvPdTotal = tvPdTotalValue
            tvPdCorregido = cardViewFinal.tvPdTotalCorregidoValue
            tvPercentil = cardViewFinal.tvPercentilValue
            tvNivel = cardViewFinal.tvNivelObtenidoValue
            tvDesviacionCalculada = cardViewFinal.tvDesviacionCalculadaValue

            progressBar = cardViewFinal.progressBar
            progressBar.max = perc[0].second

            cardViewFinal.ivHelpPdCorregido.setOnClickListener {

                requireActivity().logInfo(R.string.DIALOGO_AYUDA_MSG_ABIERTO)
                requireActivity().showHelperDialog(requireFragmentManager())
            }

            Utils.configurarTextoBaremo(requireFragmentManager(), tablaBaremo.tvBaremo, perc, getString(R.string.TOOLBAR_VELOCIDAD))
        }).run {
            textWatcherTarea1()
        }
    }

    private fun textWatcherTarea1() {

        with(etSegundosT1) {
            addTextChangedListener(object : TextWatcher {

                override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
                    totalPdT1 = 0.0
                }

                override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}

                override fun afterTextChanged(s: Editable) {

                    when {
                        s.isEmpty() -> segundosT1 = 0
                        s.isNotEmpty() -> segundosT1 = text.toString().toInt()
                    }
                    totalPdT1 = calculateTask(null, tvSubTotalT1, context.getString(R.string.TAREA_1), segundosT1, null, null)
                    calculateResult()
                }
            })
        }
    }

    override fun calculateTask(nTarea: Int?, tvSubTotal: TextView, tarea: String, aprobadas: Int?, omitidas: Int?, reprobadas: Int?): Double {
        tvSubTotal.text = String.format(getString(R.string.SEG_FORMAT), tarea, aprobadas)
        return aprobadas!!.toDouble()
    }

    override fun calculateResult() {

        with(totalPdT1, {
            tvPdTotal.text = String.format(getString(R.string.SEG_SIMPLE_FORMAT), this)

            val pdCorregido = correctPD(perc, this)
            tvPdCorregido.text = String.format(getString(R.string.SEG_SIMPLE_FORMAT), pdCorregido)

            tvDesviacionCalculada.text = Utils.calcularDesviacion(MEDIA, DESVIACION, pdCorregido, true).toString()

            with(calculatePercentile(pdCorregido), {
                tvPercentil.text = this.toString()

                when {
                    Build.VERSION.SDK_INT >= Build.VERSION_CODES.N -> progressBar.setProgress(this, true)
                    else -> progressBar.progress = this
                }
                tvNivel.text = Utils.calcularNivel(this)
            })
        })
    }

    override fun calculatePercentile(pdTotal: Double): Int {
        when {
            pdTotal < perc[0].first -> return perc[0].second
            pdTotal > perc[perc.size - 1].first -> return perc[perc.size - 1].second
            else -> perc.forEach { item ->
                if (pdTotal <= item.first) return item.second
            }
        }
        //Percentil no encontrado
        requireActivity().logInfo(R.string.TAG_PERCENTIL_CALCULADO, R.string.PERCENTIL_NULO)
        return -1
    }

    override fun correctPD(perc: List<Pair<Int, Int>>, pdActual: Double): Double {
        when {
            pdActual < perc[0].first -> return perc[0].first.toDouble()
            pdActual > perc[perc.size - 1].first -> return perc[perc.size - 1].first.toDouble()
            else -> perc.forEach { item ->
                if (pdActual <= item.first) return item.first.toDouble()
            }
        }
        requireActivity().logInfo(R.string.TAG_PD_CORREGIDO, R.string.PD_NULO)
        return (-1).toDouble()
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}