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
import cl.figonzal.evaluatool.databinding.FragmentComprensionE5M4Binding
import cl.figonzal.evaluatool.dialogs.CorregidoDialogFragment
import cl.figonzal.evaluatool.interfaces.EvaluaInterface
import cl.figonzal.evaluatool.utilidades.Utils
import cl.figonzal.evaluatool.utilidades.logInfo
import com.google.android.material.textfield.TextInputEditText
import java.util.*

class ComprensionFragmentE5M4 : Fragment(), EvaluaInterface {

    companion object {
        private const val DESVIACION = 3.71
        private const val MEDIA = 4.91

        fun newInstance(): ComprensionFragmentE5M4 {
            return ComprensionFragmentE5M4()
        }
    }

    private var binding: FragmentComprensionE5M4Binding? = null
    private val perc = listOf(
            15 to 99,
            14 to 97,
            13 to 95,
            12 to 93,
            11 to 90,
            10 to 85,
            9 to 80,
            8 to 75,
            7 to 70,
            6 to 65,
            5 to 55,
            4 to 45,
            3 to 40,
            2 to 20,
            1 to 10,
            0 to 5
    )

    private lateinit var etAprobadasT1: TextInputEditText
    private lateinit var etOmitidasT1: TextInputEditText
    private lateinit var etReprobadasT1: TextInputEditText
    private var aprobadasT1 = 0
    private var omitidasT1 = 0
    private var reprobadasT1 = 0
    private var totalPdT1 = 0.0

    //TextView para Subtotales
    private lateinit var tvSubTotalT1: TextView

    //Tetview para total
    private lateinit var tvPdTotal: TextView
    private lateinit var tvPdCorregido: TextView
    private lateinit var tvNivelComprension: TextView
    private lateinit var tvPercentil: TextView
    private lateinit var tvNivel: TextView
    private lateinit var progressBar: ProgressBar
    private lateinit var tvDesviacionCalculada: TextView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        // Inflate the layout for this fragment
        binding = FragmentComprensionE5M4Binding.inflate(inflater, container, false)

        initResources(binding!!)
        return binding!!.root
    }


    private fun initResources(binding: FragmentComprensionE5M4Binding) {

        with(binding, {
            //Promedio y desviacion
            //TetView desviacion y media
            binding.cardViewConstantes.tvMediaValue.text = MEDIA.toString()
            binding.cardViewConstantes.tvDesviacionValue.text = DESVIACION.toString()

            //TAREA 1
            tvSubTotalT1 = tvPdSubtotalT1
            this@ComprensionFragmentE5M4.etAprobadasT1 = etAprobadasT1
            this@ComprensionFragmentE5M4.etOmitidasT1 = etOmitidasT1
            this@ComprensionFragmentE5M4.etReprobadasT1 = etReprobadasT1

            //TOTAL
            this@ComprensionFragmentE5M4.tvPdTotal = tvPdTotalValue
            tvPdCorregido = tvPdTotalCorregidoValue
            this@ComprensionFragmentE5M4.tvNivelComprension = tvNivelComprensionValue
            this@ComprensionFragmentE5M4.tvPercentil = tvPercentilValue
            tvNivel = tvNivelObtenidoValue
            this@ComprensionFragmentE5M4.tvDesviacionCalculada = tvDesviacionCalculadaValue

            this@ComprensionFragmentE5M4.progressBar = progressBar
            progressBar.max = perc[0].second

            ivHelpPdCorregido.setOnClickListener {

                requireActivity().logInfo(R.string.DIALOGO_AYUDA_MSG_ABIERTO)

                CorregidoDialogFragment().apply {
                    isCancelable = false
                    show(requireFragmentManager(), getString(R.string.DIALOGO_AYUDA))
                }
            }
            Utils.configurarTextoBaremo(requireFragmentManager(), tablaBaremo.tvBaremo, perc, getString(R.string.TOOLBAR_COMPRENSION))
        }).run {
            textWatcherTarea1()
        }
    }

    private fun textWatcherTarea1() {

        with(etAprobadasT1) {
            addTextChangedListener(object : TextWatcher {

                override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
                    totalPdT1 = 0.0
                }

                override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}

                override fun afterTextChanged(s: Editable) {

                    when {
                        s.isEmpty() -> aprobadasT1 = 0
                        s.isNotEmpty() -> aprobadasT1 = text.toString().toInt()
                    }
                    totalPdT1 = calculateTask(null, tvSubTotalT1, context.getString(R.string.TAREA_1), aprobadasT1, omitidasT1, reprobadasT1)
                    calculateResult()
                }
            })
        }

        with(etOmitidasT1) {
            addTextChangedListener(object : TextWatcher {

                override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
                    totalPdT1 = 0.0
                }

                override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}

                override fun afterTextChanged(s: Editable) {

                    when {
                        s.isEmpty() -> omitidasT1 = 0
                        s.isNotEmpty() -> omitidasT1 = text.toString().toInt()
                    }
                    totalPdT1 = calculateTask(null, tvSubTotalT1, context.getString(R.string.TAREA_1), aprobadasT1, omitidasT1, reprobadasT1)
                    calculateResult()
                }
            })
        }

        with(etReprobadasT1) {
            addTextChangedListener(object : TextWatcher {

                override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
                    totalPdT1 = 0.0
                }

                override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}

                override fun afterTextChanged(s: Editable) {

                    when {
                        s.isEmpty() -> reprobadasT1 = 0
                        s.isNotEmpty() -> reprobadasT1 = text.toString().toInt()
                    }
                    totalPdT1 = calculateTask(null, tvSubTotalT1, context.getString(R.string.TAREA_1), aprobadasT1, omitidasT1, reprobadasT1)
                    calculateResult()
                }
            })
        }
    }

    override fun calculateTask(nTarea: Int?, tvSubTotal: TextView, tarea: String, aprobadas: Int?, omitidas: Int?, reprobadas: Int?): Double {
        var total = aprobadas!! - (omitidas!! + reprobadas!!)
        if (total < 0) {
            total = 0
        }
        tvSubTotal.text = String.format(Locale.US, "%s%d pts", tarea, total)
        return total.toDouble()
    }

    override fun calculateResult() {
        with(totalPdT1, {
            tvPdTotal.text = String.format(Locale.US, "%s pts", this)

            val pdCorregido = correctPD(perc, this)
            tvPdCorregido.text = String.format("%s pts", pdCorregido)

            val comprension = calcularComprension(pdCorregido)
            tvNivelComprension.text = comprension

            tvDesviacionCalculada.text = Utils.calcularDesviacion(MEDIA, DESVIACION, pdCorregido, false).toString()

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
            pdTotal > perc[0].first -> return perc[0].second
            pdTotal < perc[perc.size - 1].first -> return perc[perc.size - 1].second
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
            pdActual > this.perc[0].first -> return this.perc[0].first.toDouble()
            pdActual < this.perc[this.perc.size - 1].first -> return this.perc[this.perc.size - 1].first.toDouble()
            else -> this.perc.forEach { item ->
                if (pdActual == item.first.toDouble()) return item.first.toDouble()
            }
        }
        requireActivity().logInfo(R.string.TAG_PD_CORREGIDO, R.string.PD_NULO)
        return (-1).toDouble()
    }

    private fun calcularComprension(pd_actual: Double): String? {
        return when (pd_actual) {
            in 0.0..2.0 -> getString(R.string.COMPRENSION_MUY_BAJA)
            in 3.0..4.0 -> getString(R.string.COMPRENSION_BAJA)
            in 5.0..6.0 -> getString(R.string.COMPRENSION_MEDIA)
            in 7.0..10.0 -> getString(R.string.COMPRENSION_ALTA)
            in 11.0..15.0 -> getString(R.string.COMPRENSION_MUY_ALTA)

            else -> {
                requireActivity().logInfo(R.string.TAG_COMPRENSION_CALCULADA, R.string.COMPRENSION_NULA)
                null
            }
        }
    }


    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}