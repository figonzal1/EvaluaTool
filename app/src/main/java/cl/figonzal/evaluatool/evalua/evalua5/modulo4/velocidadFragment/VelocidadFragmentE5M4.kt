/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2021

 Last modified 17-03-21 19:46
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
import cl.figonzal.evaluatool.utilidades.EvaluaUtils
import com.google.android.material.textfield.TextInputEditText
import timber.log.Timber

class VelocidadFragmentE5M4 : Fragment(), EvaluaInterface {

    companion object {
        private const val DESVIACION = 28.62
        private const val MEDIA = 93.61

        @JvmStatic
        fun newInstance(): VelocidadFragmentE5M4 {
            return VelocidadFragmentE5M4()
        }
    }

    private lateinit var binding: FragmentVelocidadE5M4Binding
    private val perc = arrayOf(
            arrayOf(45, 99),
            arrayOf(50, 95),
            arrayOf(55, 90),
            arrayOf(60, 85),
            arrayOf(65, 75),
            arrayOf(70, 70),
            arrayOf(75, 65),
            arrayOf(80, 60),
            arrayOf(85, 55),
            arrayOf(90, 50),
            arrayOf(95, 45),
            arrayOf(100, 35),
            arrayOf(105, 30),
            arrayOf(110, 25),
            arrayOf(115, 20),
            arrayOf(120, 15),
            arrayOf(125, 13),
            arrayOf(130, 10),
            arrayOf(135, 7),
            arrayOf(140, 5),
            arrayOf(145, 3),
            arrayOf(150, 1)
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
        instanciarRecursosInterfaz(binding)
        textWatcherTarea1()
        return binding.root
    }

    private fun instanciarRecursosInterfaz(binding: FragmentVelocidadE5M4Binding) {

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
        EvaluaUtils.configurarTextoBaremo(requireFragmentManager(), tvBaremo, perc, getString(R.string.TOOLBAR_VELOCIDAD))

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

        val nivel = EvaluaUtils.calcularNivel(percentil)
        tvNivel.text = nivel

        val desviacion = EvaluaUtils.calcularDesviacion(MEDIA, DESVIACION, pdCorregido, true)
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