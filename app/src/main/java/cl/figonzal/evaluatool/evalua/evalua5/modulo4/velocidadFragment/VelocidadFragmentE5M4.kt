/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2021

 Last modified 01-05-21 22:13
 */
package cl.figonzal.evaluatool.evalua.evalua5.modulo4.velocidadFragment

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
import cl.figonzal.evaluatool.databinding.FragmentVelocidadE5M4Binding
import cl.figonzal.evaluatool.dialogs.CorregidoDialogFragment
import cl.figonzal.evaluatool.interfaces.EvaluaInterface
import cl.figonzal.evaluatool.utilidades.Utils
import cl.figonzal.evaluatool.utilidades.logInfo
import com.google.android.material.textfield.TextInputEditText

class VelocidadFragmentE5M4 : Fragment(), EvaluaInterface {

    companion object {
        private const val DESVIACION = 28.62
        private const val MEDIA = 93.61

        fun newInstance(): VelocidadFragmentE5M4 {
            return VelocidadFragmentE5M4()
        }
    }

    private var binding: FragmentVelocidadE5M4Binding? = null
    private val perc = listOf(
            45 to 99,
            50 to 95,
            55 to 90,
            60 to 85,
            65 to 75,
            70 to 70,
            75 to 65,
            80 to 60,
            85 to 55,
            90 to 50,
            95 to 45,
            100 to 35,
            105 to 30,
            110 to 25,
            115 to 20,
            120 to 15,
            125 to 13,
            130 to 10,
            135 to 7,
            140 to 5,
            145 to 3,
            150 to 1
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
        // Inflate the layout for this fragment
        binding = FragmentVelocidadE5M4Binding.inflate(inflater, container, false)

        initResources(binding!!)
        return binding!!.root
    }

    private fun initResources(binding: FragmentVelocidadE5M4Binding) {

        with(binding, {
            cardViewConstantes.tvMediaValue.text = MEDIA.toString()
            cardViewConstantes.tvDesviacionValue.text = DESVIACION.toString()

            //SUBTOTALES
            tvSubTotalT1 = tvPdSubtotalT1
            this@VelocidadFragmentE5M4.etSegundosT1 = etSegundosT1

            //TOTALES
            this@VelocidadFragmentE5M4.tvPdTotal = tvPdTotalValue
            tvPdCorregido = cardViewFinal.tvPdTotalCorregidoValue
            tvPercentil = cardViewFinal.tvPercentilValue
            tvNivel = cardViewFinal.tvNivelObtenidoValue
            tvDesviacionCalculada = cardViewFinal.tvDesviacionCalculadaValue

            progressBar = cardViewFinal.progressBar
            progressBar.max = perc[0].second

            cardViewFinal.ivHelpPdCorregido.setOnClickListener {

                requireActivity().logInfo(R.string.DIALOGO_AYUDA_MSG_ABIERTO)

                CorregidoDialogFragment().apply {
                    isCancelable = false
                    show(requireFragmentManager(), getString(R.string.DIALOGO_AYUDA))
                }
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
        tvSubTotal.text = String.format("%s%s seg", tarea, aprobadas)
        return aprobadas!!.toDouble()
    }

    override fun calculateResult() {

        with(totalPdT1, {
            tvPdTotal.text = String.format("%s seg", this)

            val pdCorregido = correctPD(perc, this)
            tvPdCorregido.text = String.format("%s seg", pdCorregido)

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

}