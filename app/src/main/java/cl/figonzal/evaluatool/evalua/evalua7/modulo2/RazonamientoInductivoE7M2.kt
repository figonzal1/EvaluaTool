/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2020

 Last modified 29-11-20 14:47
 */
package cl.figonzal.evaluatool.evalua.evalua7.modulo2

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
import java.util.*
import kotlin.math.floor

class RazonamientoInductivoE7M2 : AppCompatActivity(), EvaluaInterface {

    companion object {
        private const val DESVIACION = 7.06
        private const val MEDIA = 19.72
    }

    //PD,PC CHILE
    private val perc = arrayOf(
            arrayOf(46, 99),
            arrayOf(44, 98),
            arrayOf(42, 97),
            arrayOf(40, 96),
            arrayOf(38, 95),
            arrayOf(36, 92),
            arrayOf(34, 90),
            arrayOf(32, 85),
            arrayOf(30, 80),
            arrayOf(28, 75),
            arrayOf(26, 65),
            arrayOf(24, 60),
            arrayOf(22, 55),
            arrayOf(20, 50),
            arrayOf(18, 45),
            arrayOf(16, 40),
            arrayOf(14, 35),
            arrayOf(12, 30),
            arrayOf(10, 25),
            arrayOf(8, 20),
            arrayOf(6, 10),
            arrayOf(4, 5),
            arrayOf(2, 1)
    )

    //TAREA 1
    private lateinit var etAprobadasT1: TextInputEditText
    private lateinit var etReprobadasT1: TextInputEditText
    private lateinit var tvSubTotalT1: TextView
    private var aprobadasT1 = 0
    private var reprobadasT1 = 0
    private var subtotalPdT1 = 0.0

    //TAREA 2
    private lateinit var etAprobadasT2: TextInputEditText
    private lateinit var etReprobadasT2: TextInputEditText
    private lateinit var tvSubTotalT2: TextView
    private var aprobadasT2 = 0
    private var reprobadasT2 = 0
    private var subtotalPdT2 = 0.0

    //TAREA 3
    private lateinit var etAprobadasT3: TextInputEditText
    private lateinit var etReprobadasT3: TextInputEditText
    private lateinit var tvSubTotalT3: TextView
    private var aprobadasT3 = 0
    private var reprobadasT3 = 0
    private var subtotalPdT3 = 0.0

    //TAREA 4
    private lateinit var etAprobadasT4: TextInputEditText
    private lateinit var etReprobadasT4: TextInputEditText
    private lateinit var tvSubTotalT4: TextView
    private var aprobadasT4 = 0
    private var reprobadasT4 = 0
    private var subtotalPdT4 = 0.0

    //TAREA 5
    private lateinit var etAprobadasT5: TextInputEditText
    private lateinit var etReprobadasT5: TextInputEditText
    private lateinit var tvSubTotalT5: TextView
    private var aprobadasT5 = 0
    private var reprobadasT5 = 0
    private var subtotalPdT5 = 0.0

    //Tetview para total
    private lateinit var tvPdTotal: TextView
    private lateinit var tvPdCorregido: TextView
    private lateinit var tvPercentil: TextView
    private lateinit var tvNivel: TextView
    private lateinit var tvDesviacionCalculada: TextView
    private lateinit var progressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_razonamiento_inductivo_e7_m2)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        val actionBar = supportActionBar!!
        actionBar.setDisplayHomeAsUpEnabled(true)
        actionBar.setHomeAsUpIndicator(R.drawable.ic_arrow_back_white_24dp)
        actionBar.title = getString(R.string.TOOLBAR_RAZON_INDUCTIVO)

        instanciarRecursosInterfaz()
        textWatcherTarea1()
        textWatcherTarea2()
        textWatcherTarea3()
        textWatcherTarea4()
        textWatcherTarea5()
    }

    /**
     * Funcion encargada de instanciar los recursos de la interfaz gráfica
     */
    private fun instanciarRecursosInterfaz() {

        //Promedio y desviacion
        val tvMedia = findViewById<TextView>(R.id.tv_media_value)
        val tvDesviacion = findViewById<TextView>(R.id.tv_desviacion_value)
        tvMedia.text = MEDIA.toString()
        tvDesviacion.text = DESVIACION.toString()

        //TAREA 1
        tvSubTotalT1 = findViewById(R.id.tv_pd_subtotal_t1)
        etAprobadasT1 = findViewById(R.id.et_aprobadas_t1)
        etReprobadasT1 = findViewById(R.id.et_reprobadas_t1)

        //TAREA 2
        tvSubTotalT2 = findViewById(R.id.tv_pd_subtotal_t2)
        etAprobadasT2 = findViewById(R.id.et_aprobadas_t2)
        etReprobadasT2 = findViewById(R.id.et_reprobadas_t2)

        //TAREA 3
        tvSubTotalT3 = findViewById(R.id.tv_pd_subtotal_t3)
        etAprobadasT3 = findViewById(R.id.et_aprobadas_t3)
        etReprobadasT3 = findViewById(R.id.et_reprobadas_t3)

        //TAREA 4
        tvSubTotalT4 = findViewById(R.id.tv_pd_subtotal_t4)
        etAprobadasT4 = findViewById(R.id.et_aprobadas_t4)
        etReprobadasT4 = findViewById(R.id.et_reprobadas_t4)

        //TAREA 5
        tvSubTotalT5 = findViewById(R.id.tv_pd_subtotal_t5)
        etAprobadasT5 = findViewById(R.id.et_aprobadas_t5)
        etReprobadasT5 = findViewById(R.id.et_reprobadas_t5)

        //TOTAL
        tvPdTotal = findViewById(R.id.tv_pd_total_value)
        tvPdCorregido = findViewById(R.id.tv_pd_total_corregido_value)
        tvPercentil = findViewById(R.id.tv_percentil_value)
        tvNivel = findViewById(R.id.tv_nivel_obtenido_value)
        tvDesviacionCalculada = findViewById(R.id.tv_desviacion_calculada_value)

        progressBar = findViewById(R.id.progressBar)
        progressBar.max = perc[0][1]

        val ivCorregido = findViewById<ImageView>(R.id.iv_help_pd_corregido)
        ivCorregido.setOnClickListener {

            Timber.i(getString(R.string.DIALOGO_AYUDA_MSG_ABIERTO))

            val dialogFragment = CorregidoDialogFragment()
            dialogFragment.isCancelable = false
            dialogFragment.show(supportFragmentManager, getString(R.string.DIALOGO_AYUDA))
        }

        val tvBaremo = findViewById<TextView>(R.id.tvBaremo)
        EvaluaUtils.configurarTextoBaremo(supportFragmentManager, tvBaremo, perc, getString(R.string.TOOLBAR_RAZON_INDUCTIVO))

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
                subtotalPdT1 = calcularTarea(null, tvSubTotalT1, "Tarea 1: ", aprobadasT1, null, reprobadasT1)
                calcularResultado()
            }
        })

        etReprobadasT1.addTextChangedListener(object : TextWatcher {

            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
                subtotalPdT1 = 0.0
            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(s: Editable) {

                if (s.isEmpty()) {
                    reprobadasT1 = 0
                } else if (s.isNotEmpty()) {
                    reprobadasT1 = etReprobadasT1.text.toString().toInt()
                }
                subtotalPdT1 = calcularTarea(null, tvSubTotalT1, "Tarea 1: ", aprobadasT1, null, reprobadasT1)
                calcularResultado()
            }
        })
    }

    /**
     * Funcion encargada de la logica de los TextWatcher de la tarea 2
     */
    private fun textWatcherTarea2() {

        etAprobadasT2.addTextChangedListener(object : TextWatcher {

            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
                subtotalPdT2 = 0.0
            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(s: Editable) {

                if (s.isEmpty()) {
                    aprobadasT2 = 0
                } else if (s.isNotEmpty()) {
                    aprobadasT2 = etAprobadasT2.text.toString().toInt()
                }
                subtotalPdT2 = calcularTarea(null, tvSubTotalT2, "Tarea 2: ", aprobadasT2, null, reprobadasT2)
                calcularResultado()
            }
        })

        etReprobadasT2.addTextChangedListener(object : TextWatcher {

            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
                subtotalPdT2 = 0.0
            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(s: Editable) {

                if (s.isEmpty()) {
                    reprobadasT2 = 0
                } else if (s.isNotEmpty()) {
                    reprobadasT2 = etReprobadasT2.text.toString().toInt()
                }
                subtotalPdT2 = calcularTarea(null, tvSubTotalT2, "Tarea 2: ", aprobadasT2, null, reprobadasT2)
                calcularResultado()
            }
        })
    }

    /**
     * Funcion encargada de la logica de los TextWatcher de la tarea 3
     */
    private fun textWatcherTarea3() {

        etAprobadasT3.addTextChangedListener(object : TextWatcher {

            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
                subtotalPdT3 = 0.0
            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(s: Editable) {

                if (s.isEmpty()) {
                    aprobadasT3 = 0
                } else if (s.isNotEmpty()) {
                    aprobadasT3 = etAprobadasT3.text.toString().toInt()
                }
                subtotalPdT3 = calcularTarea(null, tvSubTotalT3, "Tarea 3: ", aprobadasT3, null, reprobadasT3)
                calcularResultado()
            }
        })

        etReprobadasT3.addTextChangedListener(object : TextWatcher {

            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
                subtotalPdT3 = 0.0
            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(s: Editable) {

                if (s.isEmpty()) {
                    reprobadasT3 = 0
                } else if (s.isNotEmpty()) {
                    reprobadasT3 = etReprobadasT3.text.toString().toInt()
                }
                subtotalPdT3 = calcularTarea(null, tvSubTotalT3, "Tarea 3: ", aprobadasT3, null, reprobadasT3)
                calcularResultado()
            }
        })
    }

    /**
     * Funcion encargada de la logica de los TextWatcher de la tarea 4
     */
    private fun textWatcherTarea4() {

        etAprobadasT4.addTextChangedListener(object : TextWatcher {

            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
                subtotalPdT4 = 0.0
            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(s: Editable) {

                if (s.isEmpty()) {
                    aprobadasT4 = 0
                } else if (s.isNotEmpty()) {
                    aprobadasT4 = etAprobadasT4.text.toString().toInt()
                }
                subtotalPdT4 = calcularTarea(null, tvSubTotalT4, "Tarea 4: ", aprobadasT4, null, reprobadasT4)
                calcularResultado()
            }
        })

        etReprobadasT4.addTextChangedListener(object : TextWatcher {

            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
                subtotalPdT4 = 0.0
            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(s: Editable) {

                if (s.isEmpty()) {
                    reprobadasT4 = 0
                } else if (s.isNotEmpty()) {
                    reprobadasT4 = etReprobadasT4.text.toString().toInt()
                }
                subtotalPdT4 = calcularTarea(null, tvSubTotalT4, "Tarea 4: ", aprobadasT4, null, reprobadasT4)
                calcularResultado()
            }
        })
    }

    /**
     * Funcion encargada de la logica de los TextWatcher de la tarea 5
     */
    private fun textWatcherTarea5() {

        etAprobadasT5.addTextChangedListener(object : TextWatcher {

            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
                subtotalPdT5 = 0.0
            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(s: Editable) {

                if (s.isEmpty()) {
                    aprobadasT5 = 0
                } else if (s.isNotEmpty()) {
                    aprobadasT5 = etAprobadasT5.text.toString().toInt()
                }
                subtotalPdT5 = calcularTarea(null, tvSubTotalT5, "Tarea 5: ", aprobadasT5, null, reprobadasT5)
                calcularResultado()
            }
        })

        etReprobadasT5.addTextChangedListener(object : TextWatcher {

            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
                subtotalPdT5 = 0.0
            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(s: Editable) {

                if (s.isEmpty()) {
                    reprobadasT5 = 0
                } else if (s.isNotEmpty()) {
                    reprobadasT5 = etReprobadasT5.text.toString().toInt()
                }
                subtotalPdT5 = calcularTarea(null, tvSubTotalT5, "Tarea 5: ", aprobadasT5, null, reprobadasT5)
                calcularResultado()
            }
        })
    }

    override fun calcularTarea(n_tarea: Int?, tv_sub_total: TextView, tarea: String, aprobadas: Int?, omitidas: Int?, reprobadas: Int?): Double {
        var total = aprobadas!! - reprobadas!! / 4.0
        total = floor(total)
        if (total < 0) {
            total = 0.0
        }
        tv_sub_total.text = String.format(Locale.US, "%s%s pts", tarea, total)
        return total
    }

    override fun calcularResultado() {

        val totalPd: Double = subtotalPdT1 + subtotalPdT2 + subtotalPdT3 + subtotalPdT4 + subtotalPdT5
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

        //Limite superior
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
            pd_actual < 0 -> {
                return 0.0
            }
            pd_actual > perc[0][0] -> {
                return perc[0][0].toDouble()
            }
            pd_actual < perc[perc.size - 1][0] -> {
                return perc[perc.size - 1][0].toDouble()
            }
            else -> {
                //Verificar si pd_actual esta en la lista
                for (item in perc) {
                    if (pd_actual == item[0].toDouble()) {
                        return item[0].toDouble()
                    } else if (pd_actual - 1 == item[0].toDouble()) {
                        return item[0].toDouble()
                    }
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