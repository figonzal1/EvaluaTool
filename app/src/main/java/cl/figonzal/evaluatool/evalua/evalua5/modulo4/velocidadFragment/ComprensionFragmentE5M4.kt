/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2020

 Last modified 27-11-20 1:08
 */
package cl.figonzal.evaluatool.evalua.evalua5.modulo4.velocidadFragment

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

class ComprensionFragmentE5M4 : Fragment(), EvaluaInterface {

    companion object {
        private const val DESVIACION = 3.71
        private const val MEDIA = 4.91

        @JvmStatic
        fun newInstance(): ComprensionFragmentE5M4 {
            return ComprensionFragmentE5M4()
        }
    }

    private val perc = arrayOf(
            arrayOf(15, 99),
            arrayOf(14, 97),
            arrayOf(13, 95),
            arrayOf(12, 93),
            arrayOf(11, 90),
            arrayOf(10, 85),
            arrayOf(9, 80),
            arrayOf(8, 75),
            arrayOf(7, 70),
            arrayOf(6, 65),
            arrayOf(5, 55),
            arrayOf(4, 45),
            arrayOf(3, 40),
            arrayOf(2, 20),
            arrayOf(1, 10),
            arrayOf(0, 5)
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
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val v = inflater.inflate(R.layout.fragment_comprension_e5_m4, container, false)
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
        etOmitidasT1 = v.findViewById(R.id.et_omitidas_t1)
        etReprobadasT1 = v.findViewById(R.id.et_reprobadas_t1)

        //TOTAL
        tvPdTotal = v.findViewById(R.id.tv_pd_total_value)
        tvPdCorregido = v.findViewById(R.id.tv_pd_total_corregido_value)
        tvNivelComprension = v.findViewById(R.id.tv_nivel_comprension_value)
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
        EvaluaUtils.configurarTextoBaremo(requireFragmentManager(), tvBaremo, perc, getString(R.string.TOOLBAR_COMPRENSION))

    }

    /**
     * Funcion encargada de la logica de los TextWatcher de la tarea 1
     */
    private fun textWatcherTarea1() {

        etAprobadasT1.addTextChangedListener(object : TextWatcher {

            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
                totalPdT1 = 0.0
            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(s: Editable) {

                if (s.isEmpty()) {
                    aprobadasT1 = 0
                } else if (s.isNotEmpty()) {
                    aprobadasT1 = etAprobadasT1.text.toString().toInt()
                }
                totalPdT1 = calcularTarea(null, tvSubTotalT1, "Tarea 1: ", aprobadasT1, omitidasT1, reprobadasT1)
                calcularResultado()
            }
        })

        etOmitidasT1.addTextChangedListener(object : TextWatcher {

            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
                totalPdT1 = 0.0
            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(s: Editable) {

                if (s.isEmpty()) {
                    omitidasT1 = 0
                } else if (s.isNotEmpty()) {
                    omitidasT1 = etOmitidasT1.text.toString().toInt()
                }
                totalPdT1 = calcularTarea(null, tvSubTotalT1, "Tarea 1: ", aprobadasT1, omitidasT1, reprobadasT1)
                calcularResultado()
            }
        })

        etReprobadasT1.addTextChangedListener(object : TextWatcher {

            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
                totalPdT1 = 0.0
            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(s: Editable) {

                if (s.isEmpty()) {
                    reprobadasT1 = 0
                } else if (s.isNotEmpty()) {
                    reprobadasT1 = etReprobadasT1.text.toString().toInt()
                }
                totalPdT1 = calcularTarea(null, tvSubTotalT1, "Tarea 1: ", aprobadasT1, omitidasT1, reprobadasT1)
                calcularResultado()
            }
        })
    }

    override fun calcularTarea(n_tarea: Int?, tv_sub_total: TextView, tarea: String, aprobadas: Int?, omitidas: Int?, reprobadas: Int?): Double {
        var total = aprobadas!! - (omitidas!! + reprobadas!!)
        if (total < 0) {
            total = 0
        }
        tv_sub_total.text = String.format(Locale.US, "%s%d pts", tarea, total)
        return total.toDouble()
    }

    override fun calcularResultado() {
        val totalPd: Double = totalPdT1
        tvPdTotal.text = String.format(Locale.US, "%s pts", totalPd)

        val pdCorregido = corregirPD(perc, totalPd)
        tvPdCorregido.text = String.format("%s pts", pdCorregido)

        val comprension = calcularComprension(pdCorregido)
        tvNivelComprension.text = comprension

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
            pd_actual > this.perc[0][0] -> {
                return this.perc[0][0].toDouble()
            }
            pd_actual < this.perc[this.perc.size - 1][0] -> {
                return this.perc[this.perc.size - 1][0].toDouble()
            }
            else -> {
                for (item in this.perc) {
                    if (pd_actual == item[0].toDouble()) {
                        return item[0].toDouble()
                    }
                }
            }
        }
        Timber.i("%s%s", getString(R.string.TAG_PD_CORREGIDO), getString(R.string.PD_NULO))
        return (-1).toDouble()
    }

    private fun calcularComprension(pd_actual: Double): String? {
        when (pd_actual) {
            in 0.0..2.0 -> {
                return "Muy Baja"
            }
            in 3.0..4.0 -> {
                return "Baja"
            }
            in 5.0..6.0 -> {
                return "Media"
            }
            in 7.0..10.0 -> {
                return "Alta"
            }
            in 11.0..15.0 -> {
                return "Muy Alta"
            }

            //Percentil no encontrado
            else -> {
                Timber.i("%s%s", getString(R.string.TAG_COMPRENSION_CALCULADA), getString(R.string.COMPRENSION_NULA))
                return null
            }
        }

    }


}