/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2020

 Last modified 27-11-20 1:07
 */
package cl.figonzal.evaluatool.evalua.evalua3.modulo3.adaptacionFragments

import android.os.Build
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.fragment.app.Fragment
import cl.figonzal.evaluatool.R
import cl.figonzal.evaluatool.dialogs.CorregidoDialogFragment
import cl.figonzal.evaluatool.interfaces.EvaluaInterface
import cl.figonzal.evaluatool.utilidades.EvaluaUtils
import com.google.android.material.textfield.TextInputEditText
import timber.log.Timber
import java.util.*

class AutoControlFragmentE3M3 : Fragment(), EvaluaInterface {

    companion object {
        private const val DESVIACION = 3.49
        private const val MEDIA = 4.02
        fun newInstance(): AutoControlFragmentE3M3 {
            return AutoControlFragmentE3M3()
        }
    }

    private val perc = arrayOf(
            arrayOf(0, 99),
            arrayOf(1, 85),
            arrayOf(2, 75),
            arrayOf(3, 65),
            arrayOf(4, 60),
            arrayOf(5, 55),
            arrayOf(6, 50),
            arrayOf(7, 45),
            arrayOf(8, 40),
            arrayOf(9, 35),
            arrayOf(10, 32),
            arrayOf(12, 25),
            arrayOf(14, 15),
            arrayOf(16, 10),
            arrayOf(18, 5),
            arrayOf(20, 1)
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
                              savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.fragment_auto_control_e3_m3, container, false)

        instanciarRecursosInterfaz(v)
        textWatcherTarea1()
        return v
    }

    /**
     * Funcion encargada de instanciar los recursos de la interfaz gráfica
     */
    private fun instanciarRecursosInterfaz(v: View) {

        //Promedio y desviacion
        //TetView desviacion y media
        val tvMedia = v.findViewById<TextView>(R.id.tv_media_value)
        val tvDesviacion = v.findViewById<TextView>(R.id.tv_desviacion_value)
        tvMedia.text = MEDIA.toString()
        tvDesviacion.text = DESVIACION.toString()

        //TAREA 1
        tvSubTotalT1 = v.findViewById(R.id.tv_pd_subtotal_t1)
        etAprobadasT1 = v.findViewById(R.id.et_aprobadas_t1)

        //TOTAL
        tvPdTotal = v.findViewById(R.id.tv_pd_total_value)
        tvPdCorregido = v.findViewById(R.id.tv_pd_total_corregido_value)
        tvPercentil = v.findViewById(R.id.tv_percentil_value)
        tvNivel = v.findViewById(R.id.tv_nivel_obtenido_value)
        tvDesviacionCalculada = v.findViewById(R.id.tv_desviacion_calculada_value)

        progressBar = v.findViewById(R.id.progressBar)
        progressBar.max = perc[0][1]

        val ivCorregido = v.findViewById<ImageView>(R.id.iv_help_pd_corregido)
        ivCorregido.setOnClickListener {

            Timber.i(getString(R.string.DIALOGO_AYUDA_MSG_ABIERTO))

            val dialogFragment = CorregidoDialogFragment()
            dialogFragment.isCancelable = false
            dialogFragment.show(requireFragmentManager(), getString(R.string.DIALOGO_AYUDA))
        }

        val tvBaremo = v.findViewById<TextView>(R.id.tvBaremo)
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
            pd_actual < perc[0][0] -> {
                return perc[0][0].toDouble()
            }
            pd_actual > perc[perc.size - 1][0] -> {
                return perc[perc.size - 1][0].toDouble()
            }
            else -> {
                for (item in perc) {
                    when {
                        pd_actual == item[0].toDouble() -> {
                            return item[0].toDouble()
                        }
                        pd_actual + 1 == item[0].toDouble() -> {
                            return item[0].toDouble()
                        }
                        pd_actual + 2 == item[0].toDouble() -> {
                            return item[0].toDouble()
                        }
                    }
                }
            }
        }
        Timber.i("%s%s", getString(R.string.TAG_PD_CORREGIDO), getString(R.string.PD_NULO))
        return (-1).toDouble()
    }
}