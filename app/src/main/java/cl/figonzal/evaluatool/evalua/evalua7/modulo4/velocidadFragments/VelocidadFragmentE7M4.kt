/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2021

 Last modified 17-04-21 22:25
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
import cl.figonzal.evaluatool.dialogs.CorregidoDialogFragment
import cl.figonzal.evaluatool.interfaces.EvaluaInterface
import cl.figonzal.evaluatool.utilidades.Utils
import com.google.android.material.textfield.TextInputEditText
import timber.log.Timber

class VelocidadFragmentE7M4 : Fragment(), EvaluaInterface {

    companion object {
        private const val DESVIACION = 68.21
        private const val MEDIA = 257.12

        fun newInstance(): VelocidadFragmentE7M4 {
            return VelocidadFragmentE7M4()
        }
    }

    private lateinit var binding: FragmentVelocidadE7M4Binding
    private val perc = arrayOf(
            arrayOf(100, 99),
            arrayOf(121, 97),
            arrayOf(135, 95),
            arrayOf(150, 90),
            arrayOf(160, 85),
            arrayOf(170, 80),
            arrayOf(180, 75),
            arrayOf(190, 70),
            arrayOf(210, 65),
            arrayOf(220, 60),
            arrayOf(240, 55),
            arrayOf(250, 50),
            arrayOf(260, 40),
            arrayOf(280, 30),
            arrayOf(300, 20),
            arrayOf(340, 10),
            arrayOf(500, 5)
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

        instanciarRecursosInterfaz(binding)
        textWatcherTarea1()
        return binding.root
    }

    private fun instanciarRecursosInterfaz(binding: FragmentVelocidadE7M4Binding) {

        binding.cardViewConstantes.tvMediaValue.text = MEDIA.toString()
        binding.cardViewConstantes.tvDesviacionValue.text = DESVIACION.toString()

        //SUBTOTALES
        tvSubTotalT1 = binding.tvPdSubtotalT1
        etSegundosT1 = binding.etSegundosT1

        //TOTALES
        tvPdTotal = binding.tvPdTotalValue
        tvPdCorregido = binding.cardViewFinal.tvPdTotalCorregidoValue
        tvPercentil = binding.cardViewFinal.tvPercentilValue
        tvNivel = binding.cardViewFinal.tvNivelObtenidoValue
        tvDesviacionCalculada = binding.cardViewFinal.tvDesviacionCalculadaValue

        progressBar = binding.cardViewFinal.progressBar
        progressBar.max = perc[0][1]

        val ivCorregido = binding.cardViewFinal.ivHelpPdCorregido
        ivCorregido.setOnClickListener {

            Timber.i(getString(R.string.DIALOGO_AYUDA_MSG_ABIERTO))

            val dialogFragment = CorregidoDialogFragment()
            dialogFragment.isCancelable = false
            dialogFragment.show(requireFragmentManager(), getString(R.string.DIALOGO_AYUDA))
        }

        val tvBaremo = binding.tablaBaremo.tvBaremo
        Utils.configurarTextoBaremo(requireFragmentManager(), tvBaremo, perc, getString(R.string.TOOLBAR_VELOCIDAD))

    }

    private fun textWatcherTarea1() {

        etSegundosT1.addTextChangedListener(object : TextWatcher {

            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
                totalPdT1 = 0.0
            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(s: Editable) {

                if (s.isEmpty()) {
                    segundosT1 = 0
                } else if (s.isNotEmpty()) {
                    segundosT1 = etSegundosT1.text.toString().toInt()
                }
                totalPdT1 = calcularTarea(null, tvSubTotalT1, "Tarea 1: ", segundosT1, null, null)
                calcularResultado()
            }
        })
    }

    override fun calcularTarea(n_tarea: Int?, tv_sub_total: TextView, tarea: String, aprobadas: Int?, omitidas: Int?, reprobadas: Int?): Double {
        tv_sub_total.text = String.format("%s%s seg", tarea, aprobadas)
        return aprobadas!!.toDouble()
    }

    override fun calcularResultado() {

        val totalPd: Double = totalPdT1
        tvPdTotal.text = String.format("%s seg", totalPd)

        val pdCorregido = corregirPD(perc, totalPd)
        tvPdCorregido.text = String.format("%s seg", pdCorregido)

        val percentil = calcularPercentil(pdCorregido)
        tvPercentil.text = percentil.toString()

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            progressBar.setProgress(percentil, true)
        } else {
            progressBar.progress = percentil
        }

        val nivel = Utils.calcularNivel(percentil)
        tvNivel.text = nivel

        val desviacion = Utils.calcularDesviacion(MEDIA, DESVIACION, pdCorregido, true)
        tvDesviacionCalculada.text = desviacion.toString()
    }

    override fun calcularPercentil(pd_total: Double): Int {
        when {
            pd_total < perc[0][0] -> {
                return perc[0][1]
            }
            pd_total > perc[perc.size - 1][0] -> {
                return perc[perc.size - 1][1]
            }
            else -> {
                for (item in perc) {
                    if (pd_total <= item[0]) {
                        return item[1]
                    }
                }
            }
        }
        //Percentil no encontrado
        Timber.i("%s%s", getString(R.string.TAG_PERCENTIL_CALCULADO), getString(R.string.PERCENTIL_NULO))
        return -1
    }

    override fun corregirPD(perc: Array<Array<Int>>, pd_actual: Double): Double {
        when {
            pd_actual < perc[0][0] -> {
                return perc[0][0].toDouble()
            }
            pd_actual > perc[perc.size - 1][0] -> {
                return perc[perc.size - 1][0].toDouble()
            }
            else -> {
                for (item in perc) {
                    if (pd_actual <= item[0]) {
                        return item[0].toDouble()
                    }
                }
            }
        }
        Timber.i("%s%s", getString(R.string.TAG_PD_CORREGIDO), getString(R.string.PD_NULO))
        return (-1).toDouble()
    }


}