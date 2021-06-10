/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2021

 Last modified 09-06-21 20:39
 */
package cl.figonzal.evaluatool.evalua.evalua2.modulo3.adaptacionFragments

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
import cl.figonzal.evaluatool.baremosTables.conductaProSocialFragmentE2M3Baremo
import cl.figonzal.evaluatool.databinding.FragmentConductaProSocialE2M3Binding
import cl.figonzal.evaluatool.interfaces.EvaluaInterface
import cl.figonzal.evaluatool.utilidades.Utils
import cl.figonzal.evaluatool.utilidades.logInfo
import cl.figonzal.evaluatool.utilidades.setSubTotalPoints
import cl.figonzal.evaluatool.utilidades.showHelperDialog
import com.google.android.material.progressindicator.LinearProgressIndicator
import com.google.android.material.textfield.TextInputEditText
import java.util.*

class ConductaProSocialFragmentE2M3 : Fragment(), EvaluaInterface {

    companion object {
        private const val DESVIACION = 3.69
        private const val MEDIA = 26.12
        fun newInstance(): ConductaProSocialFragmentE2M3 {
            return ConductaProSocialFragmentE2M3()
        }
    }

    private var binding: FragmentConductaProSocialE2M3Binding? = null
    private val perc = conductaProSocialFragmentE2M3Baremo()

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
    private lateinit var progressBar: LinearProgressIndicator
    private lateinit var tvDesviacionCalculada: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentConductaProSocialE2M3Binding.inflate(inflater, container, false)

        initResources(binding!!)
        return binding!!.root
    }


    private fun initResources(binding: FragmentConductaProSocialE2M3Binding) {

        with(binding, {

            //Promedio y desviacion
            //TetView desviacion y media
            cardViewConstantes.tvMediaValue.text = MEDIA.toString()
            cardViewConstantes.tvDesviacionValue.text = DESVIACION.toString()

            //TAREA 1
            tvSubTotalT1 = tvPdSubtotalT1
            this@ConductaProSocialFragmentE2M3.etAprobadasT1 = etAprobadasT1

            //TOTAL
            this@ConductaProSocialFragmentE2M3.tvPdTotal = tvPdTotalValue
            tvPdCorregido = cardViewFinal.tvPdTotalCorregidoValue
            tvPercentil = cardViewFinal.tvPercentilValue
            tvNivel = cardViewFinal.tvNivelObtenidoValue
            tvDesviacionCalculada = cardViewFinal.tvDesviacionCalculadaValue

            progressBar = binding.cardViewFinal.progressBar
            progressBar.max = perc.first()[1] as Int

            cardViewFinal.ivHelpPdCorregido.setOnClickListener {

                requireActivity().logInfo(R.string.DIALOGO_AYUDA_MSG_ABIERTO)
                requireActivity().showHelperDialog(parentFragmentManager)
            }
            Utils.configurarTextoBaremo(
                parentFragmentManager,
                tablaBaremo.tvBaremo,
                perc,
                getString(R.string.TOOLBAR_CONDUCTAS_PROSOCIALES)
            )

        }).also {
            textWatcherTarea1()
        }

    }

    private fun textWatcherTarea1() {

        with(etAprobadasT1) {
            addTextChangedListener(object : TextWatcher {

                override fun beforeTextChanged(
                    s: CharSequence,
                    start: Int,
                    count: Int,
                    after: Int
                ) {
                    subtotalPdT1 = 0.0
                }

                override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}

                override fun afterTextChanged(s: Editable) {

                    when {
                        s.isEmpty() -> aprobadasT1 = 0
                        s.isNotEmpty() -> aprobadasT1 = text.toString().toInt()
                    }
                    subtotalPdT1 = calculateTask(
                        0,
                        tvSubTotalT1,
                        context.getString(R.string.TAREA_1),
                        aprobadasT1,
                        0,
                        0
                    )
                    calculateResult()
                }
            })
        }
    }

    override fun calculateTask(
        nTarea: Int,
        tvSubTotal: TextView,
        tarea: String,
        aprobadas: Int,
        omitidas: Int,
        reprobadas: Int
    ): Double {
        var total = aprobadas.toDouble()
        if (total < 0) total = 0.0

        tvSubTotal.text = requireActivity().setSubTotalPoints(tarea, total)
        return total
    }

    override fun calculateResult() {

        with(subtotalPdT1, {
            tvPdTotal.text = String.format(getString(R.string.POINTS_SIMPLE_FORMAT), this)

            val pdCorregido = correctPD(perc, this.toInt())
            tvPdCorregido.text =
                String.format(getString(R.string.POINTS_SIMPLE_FORMAT), pdCorregido)

            tvDesviacionCalculada.text =
                Utils.calcularDesviacion(MEDIA, DESVIACION, pdCorregido, false).toString()

            with(calculatePercentile(pdCorregido), {
                tvPercentil.text = this.toString()

                when {
                    Build.VERSION.SDK_INT >= Build.VERSION_CODES.N -> progressBar.setProgressCompat(
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
            pdTotal > perc.first()[0] as Int -> return perc.first()[1] as Int
            pdTotal < perc.last()[0] as Int -> return perc.last()[1] as Int
            else -> perc.forEach { item ->
                if (pdTotal == item.first()) return item[1] as Int
            }
        }
        //Percentil no encontrado
        requireActivity().logInfo(R.string.TAG_PERCENTIL_CALCULADO, R.string.PERCENTIL_NULO)
        return -1
    }

    override fun correctPD(perc: Array<Array<Any>>, pdActual: Int): Int {
        when {
            pdActual > perc.first()[0] as Int -> return perc.first()[0] as Int
            pdActual < perc.last()[0] as Int -> return perc.last()[0] as Int
            else -> perc.forEach { item ->
                when {
                    pdActual == item.first() -> return item.first() as Int
                    pdActual - 1 == item.first() -> return item.first() as Int
                    pdActual - 2 == item.first() -> return item.first() as Int
                    pdActual - 3 == item.first() -> return item.first() as Int
                    pdActual - 4 == item.first() -> return item.first() as Int
                }
            }
        }
        requireActivity().logInfo(R.string.TAG_PD_CORREGIDO, R.string.PD_NULO)
        return -1
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}