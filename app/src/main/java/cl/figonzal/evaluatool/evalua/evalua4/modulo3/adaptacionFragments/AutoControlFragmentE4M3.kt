/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2021

 Last modified 30-04-21 22:11
 */
package cl.figonzal.evaluatool.evalua.evalua4.modulo3.adaptacionFragments

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
import cl.figonzal.evaluatool.databinding.FragmentAutoControlE4M3Binding
import cl.figonzal.evaluatool.dialogs.CorregidoDialogFragment
import cl.figonzal.evaluatool.interfaces.EvaluaInterface
import cl.figonzal.evaluatool.utilidades.Utils
import cl.figonzal.evaluatool.utilidades.logInfo
import com.google.android.material.textfield.TextInputEditText
import java.util.*

class AutoControlFragmentE4M3 : Fragment(), EvaluaInterface {

    companion object {
        private const val DESVIACION = 2.43
        private const val MEDIA = 3.37

        @JvmStatic
        fun newInstance(): AutoControlFragmentE4M3 {
            return AutoControlFragmentE4M3()
        }
    }

    private var binding: FragmentAutoControlE4M3Binding? = null
    private val perc = listOf(
            0 to 99,
            1 to 95,
            2 to 80,
            3 to 70,
            4 to 60,
            5 to 50,
            6 to 40,
            7 to 35,
            8 to 25,
            9 to 20,
            10 to 15,
            11 to 10,
            12 to 7,
            13 to 5,
            14 to 3,
            15 to 1
    )

    private lateinit var etAprobadasT1: TextInputEditText
    private var aprobadasT1 = 0
    private var subtotalPdT1 = 0.0

    //TextView para Subtotales
    private lateinit var tvSubTotalT1: TextView

    //Tetview para total
    private lateinit var tvPdTotal: TextView
    private lateinit var tvPdCorregido: TextView
    private lateinit var tvPercentil: TextView
    private lateinit var tvNivel: TextView
    private lateinit var progressBar: ProgressBar
    private lateinit var tvDesviacionCalculada: TextView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        binding = FragmentAutoControlE4M3Binding.inflate(inflater, container, false)

        initResources(binding!!)
        return binding!!.root
    }


    private fun initResources(binding: FragmentAutoControlE4M3Binding) {

        with(binding, {
            //Promedio y desviacion
            //TetView desviacion y media
            cardViewConstantes.tvMediaValue.text = MEDIA.toString()
            cardViewConstantes.tvDesviacionValue.text = DESVIACION.toString()

            //TAREA 1
            tvSubTotalT1 = tvPdSubtotalT1
            this@AutoControlFragmentE4M3.etAprobadasT1 = etAprobadasT1

            //TOTAL
            this@AutoControlFragmentE4M3.tvPdTotal = tvPdTotalValue
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
            Utils.configurarTextoBaremo(requireFragmentManager(), tablaBaremo.tvBaremo, perc, getString(R.string.TOOLBAR_AUTOCONTROL))
        }).run {
            textWatcherTarea1()
        }
    }

    private fun textWatcherTarea1() {

        with(etAprobadasT1) {
            addTextChangedListener(object : TextWatcher {

                override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
                    subtotalPdT1 = 0.0
                }

                override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}

                override fun afterTextChanged(s: Editable) {

                    when {
                        s.isEmpty() -> aprobadasT1 = 0
                        s.isNotEmpty() -> aprobadasT1 = text.toString().toInt()
                    }
                    subtotalPdT1 = calculateTask(null, tvSubTotalT1, context.getString(R.string.TAREA_1), aprobadasT1, null, null)
                    calculateResult()
                }
            })
        }
    }

    override fun calculateTask(nTarea: Int?, tvSubTotal: TextView, tarea: String, aprobadas: Int?, omitidas: Int?, reprobadas: Int?): Double {
        var total = aprobadas!!
        if (total < 0) {
            total = 0
        }
        tvSubTotal.text = String.format(Locale.US, "%s%d pts", tarea, total)
        return total.toDouble()
    }

    override fun calculateResult() {


        with(subtotalPdT1, {
            tvPdTotal.text = String.format(Locale.US, "%s pts", this)

            val pdCorregido = correctPD(perc, this)
            tvPdCorregido.text = String.format("%s pts", pdCorregido)

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
                if (pdTotal.toInt() == item.first) return item.second
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
                when {
                    pdActual == item.first.toDouble() -> return item.first.toDouble()
                    pdActual + 1 == item.first.toDouble() -> return item.first.toDouble()
                    pdActual + 2 == item.first.toDouble() -> return item.first.toDouble()
                }
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