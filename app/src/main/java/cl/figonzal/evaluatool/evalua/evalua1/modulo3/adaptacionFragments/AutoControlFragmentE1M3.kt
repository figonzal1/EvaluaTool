/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2021

 Last modified 26-02-21 19:05
 */
package cl.figonzal.evaluatool.evalua.evalua1.modulo3.adaptacionFragments

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
import cl.figonzal.evaluatool.databinding.FragmentAutoControlE1M3Binding
import cl.figonzal.evaluatool.dialogs.CorregidoDialogFragment
import cl.figonzal.evaluatool.interfaces.EvaluaInterface
import cl.figonzal.evaluatool.utilidades.EvaluaUtils
import com.google.android.material.textfield.TextInputEditText
import timber.log.Timber
import java.util.*

class AutoControlFragmentE1M3 : Fragment(), EvaluaInterface {

    companion object {
        private const val DESVIACION = 5.06
        private const val MEDIA = 22.24

        fun newInstance(): AutoControlFragmentE1M3 {
            return AutoControlFragmentE1M3()
        }
    }

    private var binding: FragmentAutoControlE1M3Binding? = null

    //PD,PC CHILE
    private val perc = arrayOf(
            arrayOf(30, 99),
            arrayOf(29, 90),
            arrayOf(28, 80),
            arrayOf(26, 70),
            arrayOf(24, 60),
            arrayOf(22, 50),
            arrayOf(20, 40),
            arrayOf(16, 30),
            arrayOf(15, 20),
            arrayOf(10, 10),
            arrayOf(8, 5)
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

        binding = FragmentAutoControlE1M3Binding.inflate(inflater, container, false)

        instanciarRecursosInterfaz(binding!!)
        textWatcherTarea1()

        return binding!!.root
    }

    /**
     * Funcion encargada de instanciar los recursos de la interfaz gráfica
     */
    private fun instanciarRecursosInterfaz(binding: FragmentAutoControlE1M3Binding) {

        //Promedio y desviacion
        //TetView desviacion y media
        binding.cardViewConstantes.tvMediaValue.text = MEDIA.toString()
        binding.cardViewConstantes.tvDesviacionValue.text = DESVIACION.toString()

        //TAREA 1
        tvSubTotalT1 = binding.tvPdSubtotalT1
        etAprobadasT1 = binding.etAprobadasT1

        //TOTAL
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
        EvaluaUtils.configurarTextoBaremo(requireFragmentManager(), tvBaremo, perc, getString(R.string.TOOLBAR_AUTOCONTROL))

    }

    /**
     * Funcion encargada de la logica de los TextWatcher de la tarea 1
     */
    private fun textWatcherTarea1() {

        etAprobadasT1.addTextChangedListener(object : TextWatcher {

            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
                subtotalPdT1 = 0.0
            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(s: Editable) {

                if (s.isEmpty()) {
                    aprobadasT1 = 0
                } else if (s.isNotEmpty()) {
                    aprobadasT1 = etAprobadasT1.text.toString().toInt()
                }
                subtotalPdT1 = calcularTarea(null, tvSubTotalT1, "Tarea 1: ", aprobadasT1, null, null)
                calcularResultado()
            }
        })
    }

    override fun calcularTarea(n_tarea: Int?, tv_sub_total: TextView, tarea: String, aprobadas: Int?, omitidas: Int?, reprobadas: Int?): Double {
        var total = aprobadas!!
        if (total < 0) {
            total = 0
        }
        tv_sub_total.text = String.format(Locale.US, "%s%d pts", tarea, total)
        return total.toDouble()
    }

    override fun calcularResultado() {

        //TOTALES
        val totalPd: Double = subtotalPdT1
        tvPdTotal.text = String.format(Locale.US, "%s pts", totalPd)

        val pdCorregido = corregirPD(perc, totalPd)
        tvPdCorregido.text = String.format("%s pts", pdCorregido)

        val percentil = calcularPercentil(pdCorregido)
        tvPercentil.text = percentil.toString()

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            progressBar.setProgress(percentil, true)
        } else {
            progressBar.progress = percentil
        }

        val nivel = EvaluaUtils.calcularNivel(percentil)
        tvNivel.text = nivel

        val desviacion = EvaluaUtils.calcularDesviacion(MEDIA, DESVIACION, pdCorregido, false)
        tvDesviacionCalculada.text = desviacion.toString()
    }

    override fun calcularPercentil(pd_total: Double): Int {
        when {
            pd_total > perc[0][0] -> {
                return perc[0][1]
            }
            pd_total < perc[perc.size - 1][0] -> {
                return perc[perc.size - 1][1]
            }
            else -> {
                for (item in perc) {
                    if (pd_total.toInt() == item[0]) {
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
            pd_actual > perc[0][0] -> {
                return perc[0][0].toDouble()
            }
            pd_actual < perc[perc.size - 1][0] -> {
                return perc[perc.size - 1][0].toDouble()
            }
            else -> {
                for (item in perc) {
                    when {
                        pd_actual == item[0].toDouble() -> {
                            return item[0].toDouble()
                        }
                        pd_actual - 1 == item[0].toDouble() -> {
                            return item[0].toDouble()
                        }
                        pd_actual - 2 == item[0].toDouble() -> {
                            return item[0].toDouble()
                        }
                        pd_actual - 3 == item[0].toDouble() -> {
                            return item[0].toDouble()
                        }
                        pd_actual - 4 == item[0].toDouble() -> {
                            return item[0].toDouble()
                        }
                        pd_actual - 5 == item[0].toDouble() -> {
                            return item[0].toDouble()
                        }
                    }
                }
            }
        }
        Timber.i("%s%s", getString(R.string.TAG_PD_CORREGIDO), getString(R.string.PD_NULO))
        return (-1).toDouble()
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}