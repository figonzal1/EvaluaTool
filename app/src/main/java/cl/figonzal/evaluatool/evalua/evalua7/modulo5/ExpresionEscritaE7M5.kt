/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2020

 Last modified 27-11-20 1:07
 */
package cl.figonzal.evaluatool.evalua.evalua7.modulo5

import android.os.Build
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.MenuItem
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import cl.figonzal.evaluatool.R
import cl.figonzal.evaluatool.dialogs.CorregidoDialogFragment
import cl.figonzal.evaluatool.interfaces.EvaluaInterface
import cl.figonzal.evaluatool.utilidades.EvaluaUtils
import com.google.android.material.textfield.TextInputEditText
import timber.log.Timber
import kotlin.math.floor

class ExpresionEscritaE7M5 : AppCompatActivity(), EvaluaInterface {

    companion object {
        private const val DESVIACION = 0.843
        private const val MEDIA = 2.45
    }

    private val perc = arrayOf(
            arrayOf(5, 10),
            arrayOf(4, 30),
            arrayOf(3, 50),
            arrayOf(2, 70),
            arrayOf(1, 90)
    )

    //TAREA 1
    private lateinit var etAprobadasT1: TextInputEditText
    private var aprobadasT1 = 0

    //SUBTOTALES
    private lateinit var tvSubTotalT1: TextView
    private var totalPdT1 = 0.0

    //TOTAL
    private lateinit var tvPdTotal: TextView
    private lateinit var tvPdCorregido: TextView
    private lateinit var tvPercentil: TextView
    private lateinit var tvNivel: TextView
    private lateinit var tvDesviacionCalculada: TextView
    private lateinit var progressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_expresion_escrita_e7_m5)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        toolbar.setTitleTextColor(resources.getColor(R.color.colorOnPrimary, theme))
        setSupportActionBar(toolbar)

        val actionBar = supportActionBar!!
        actionBar.setDisplayHomeAsUpEnabled(true)
        actionBar.setHomeAsUpIndicator(R.drawable.ic_arrow_back_white_24dp)
        actionBar.title = getString(R.string.TOOLBAR_EXPRESION_ESCRITA)

        instanciarRecursosInterfaz()
        textWatcherTarea1()
    }

    private fun instanciarRecursosInterfaz() {

        val tvMedia = findViewById<TextView>(R.id.tv_media_value)
        val tvDesviacion = findViewById<TextView>(R.id.tv_desviacion_value)
        tvMedia.text = MEDIA.toString()
        tvDesviacion.text = DESVIACION.toString()

        //SUBTOTALES
        tvSubTotalT1 = findViewById(R.id.tv_pd_subtotal_t1)
        etAprobadasT1 = findViewById(R.id.et_aprobadas_t1)

        //TOTALES
        tvPdTotal = findViewById(R.id.tv_pd_total_value)
        tvPdCorregido = findViewById(R.id.tv_pd_total_corregido_value)
        tvPercentil = findViewById(R.id.tv_percentil_value)
        tvNivel = findViewById(R.id.tv_nivel_obtenido_value)
        tvDesviacionCalculada = findViewById(R.id.tv_desviacion_calculada_value)

        progressBar = findViewById(R.id.progressBar)
        progressBar.max = perc[perc.size - 1][1]

        val ivCorregido = findViewById<ImageView>(R.id.iv_help_pd_corregido)
        ivCorregido.setOnClickListener {

            Timber.i(getString(R.string.DIALOGO_AYUDA_MSG_ABIERTO))

            val dialogFragment = CorregidoDialogFragment()
            dialogFragment.isCancelable = false
            dialogFragment.show(supportFragmentManager, getString(R.string.DIALOGO_AYUDA))
        }

        val tvBaremo = findViewById<TextView>(R.id.tvBaremo)
        EvaluaUtils.configurarTextoBaremo(supportFragmentManager, tvBaremo, perc, getString(R.string.TOOLBAR_EXPRESION_ESCRITA))

    }

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
                totalPdT1 = calcularTarea(null, tvSubTotalT1, "Tarea 1: ", aprobadasT1, null, null)
                calcularResultado()
            }
        })
    }

    override fun calcularTarea(n_tarea: Int?, tv_sub_total: TextView, tarea: String, aprobadas: Int?, omitidas: Int?, reprobadas: Int?): Double {
        //FORMULA PARA RAZONAMIENTO DEDUCTIVO
        var total = aprobadas!!.toDouble()
        //Aproximacion piso
        total = floor(total)
        if (total < 0) {
            total = 0.0
        }
        tv_sub_total.text = String.format("%s%s pts", tarea, total)
        return total
    }

    override fun calcularResultado() {

        //TOTALES
        val totalPd: Double = totalPdT1
        tvPdTotal.text = String.format("%s pts", totalPd)

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
        //Excepcion pd_actual 0 sera pd
        if (pd_actual > perc[0][0] || pd_actual <= 0) {
            return perc[0][0].toDouble()
        } else if (pd_actual < perc[perc.size - 1][0]) {
            return perc[perc.size - 1][0].toDouble()
        } else {
            //Verificar si pd_actual esta en la lista
            for (item in perc) {
                if (pd_actual == item[0].toDouble()) {
                    return item[0].toDouble()
                }
            }
        }
        Timber.i("%s%s", getString(R.string.TAG_PD_CORREGIDO), getString(R.string.PD_NULO))
        return (-1).toDouble()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if (item.itemId == android.R.id.home) {
            Timber.i(getString(R.string.ACTIVIDAD_CERRADA))
            finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }


}