/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2021

 Last modified 26-02-21 19:05
 */
package cl.figonzal.evaluatool.evalua.evalua1.modulo1

import android.os.Build
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.MenuItem
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import cl.figonzal.evaluatool.R
import cl.figonzal.evaluatool.databinding.ActivityMemoriaAtencionE1M1Binding
import cl.figonzal.evaluatool.dialogs.CorregidoDialogFragment
import cl.figonzal.evaluatool.interfaces.EvaluaInterface
import cl.figonzal.evaluatool.utilidades.EvaluaUtils
import com.google.android.material.textfield.TextInputEditText
import timber.log.Timber
import java.util.*
import kotlin.math.floor

class MemoriaAtencionE1M1 : AppCompatActivity(), EvaluaInterface {

    companion object {
        private const val DESVIACION = 12.90
        private const val MEDIA = 49.39
    }

    private lateinit var binding: ActivityMemoriaAtencionE1M1Binding
    private val perc = arrayOf(
            arrayOf(68, 99),
            arrayOf(67, 97),
            arrayOf(66, 95),
            arrayOf(65, 93),
            arrayOf(64, 90),
            arrayOf(63, 87),
            arrayOf(62, 85),
            arrayOf(61, 80),
            arrayOf(60, 75),
            arrayOf(59, 72),
            arrayOf(58, 70),
            arrayOf(57, 65),
            arrayOf(56, 62),
            arrayOf(55, 60),
            arrayOf(54, 57),
            arrayOf(53, 55),
            arrayOf(52, 52),
            arrayOf(51, 50),
            arrayOf(50, 47),
            arrayOf(49, 45),
            arrayOf(48, 43),
            arrayOf(47, 40),
            arrayOf(46, 37),
            arrayOf(45, 35),
            arrayOf(44, 32),
            arrayOf(43, 30),
            arrayOf(40, 25),
            arrayOf(37, 20),
            arrayOf(34, 15),
            arrayOf(31, 10),
            arrayOf(28, 7),
            arrayOf(25, 5),
            arrayOf(22, 1)
    )

    //TAREA 1
    private lateinit var etAprobadasT1: TextInputEditText
    private lateinit var etOmitidasT1: TextInputEditText
    private lateinit var etReprobadasT1: TextInputEditText
    private var aprobadasT1 = 0
    private var omitidasT1 = 0
    private var reprobadasT1 = 0

    //TAREA 2
    private lateinit var etAprobadasT2: TextInputEditText
    private lateinit var etOmitidasT2: TextInputEditText
    private lateinit var etReprobadasT2: TextInputEditText
    private var aprobadasT2 = 0
    private var omitidasT2 = 0
    private var reprobadasT2 = 0

    //TAREA 3
    private lateinit var etAprobadasT3: TextInputEditText
    private lateinit var etOmitidasT3: TextInputEditText
    private lateinit var etReprobadasT3: TextInputEditText
    private var aprobadasT3 = 0
    private var omitidasT3 = 0
    private var reprobadasT3 = 0

    //SUBTOTALES
    private lateinit var tvSubTotalT1: TextView
    private lateinit var tvSubTotalT2: TextView
    private lateinit var tvSubTotalT3: TextView
    private var subtotalPdT1 = 0.0
    private var subtotalPdT2 = 0.0
    private var subtotalPdT3 = 0.0

    //Totales
    private lateinit var tvPdTotal: TextView
    private lateinit var tvPdCorregido: TextView
    private lateinit var tvPercentil: TextView
    private lateinit var tvNivel: TextView
    private lateinit var tvDesviacionCalculada: TextView

    private lateinit var progressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMemoriaAtencionE1M1Binding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.include.toolbar)

        val actionBar = supportActionBar!!
        actionBar.setDisplayHomeAsUpEnabled(true)
        actionBar.setHomeAsUpIndicator(R.drawable.ic_arrow_back_white_24dp)
        actionBar.title = getString(R.string.TOOLBAR_MEMORIA_ATENCION)

        instanciarRecursosInterfaz()
        textWatcherTarea1()
        textWatcherTarea2()
        textWatcherTarea3()
    }

    /**
     * Funcion encargada de instanciar los recursos de la interfaz gráfica
     */
    private fun instanciarRecursosInterfaz() {

        //Promedio y desviacion
        //TetView desviacion y media
        val tvMedia = binding.cardViewConstantes.tvMediaValue
        val tvDesviacion = binding.cardViewConstantes.tvDesviacionValue
        tvMedia.text = MEDIA.toString()
        tvDesviacion.text = DESVIACION.toString()

        //TAREA 1
        tvSubTotalT1 = binding.tvPdSubtotalT1
        etAprobadasT1 = binding.etAprobadasT1
        etOmitidasT1 = binding.etOmitidasT1
        etReprobadasT1 = binding.etReprobadasT1

        //TAREA 2
        tvSubTotalT2 = binding.tvPdSubtotalT2
        etAprobadasT2 = binding.etAprobadasT2
        etOmitidasT2 = binding.etOmitidasT2
        etReprobadasT2 = binding.etReprobadasT2

        //TAREA 3
        tvSubTotalT3 = binding.tvPdSubtotalT3
        etAprobadasT3 = binding.etAprobadasT3
        etOmitidasT3 = binding.etOmitidasT3
        etReprobadasT3 = binding.etReprobadasT3

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
            dialogFragment.show(supportFragmentManager, getString(R.string.DIALOGO_AYUDA))
        }

        val tvBaremo = binding.tablaBaremo.tvBaremo
        EvaluaUtils.configurarTextoBaremo(supportFragmentManager, tvBaremo, perc, getString(R.string.TOOLBAR_MEMORIA_ATENCION))
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
                subtotalPdT1 = calcularTarea(null, tvSubTotalT1, "Tarea 1: ", aprobadasT1, omitidasT1, reprobadasT1)
                calcularResultado()
            }
        })

        etOmitidasT1.addTextChangedListener(object : TextWatcher {

            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
                subtotalPdT1 = 0.0
            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(s: Editable) {

                if (s.isEmpty()) {
                    omitidasT1 = 0
                } else if (s.isNotEmpty()) {
                    omitidasT1 = etOmitidasT1.text.toString().toInt()
                }
                subtotalPdT1 = calcularTarea(null, tvSubTotalT1, "Tarea 1: ", aprobadasT1, omitidasT1, reprobadasT1)
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
                subtotalPdT1 = calcularTarea(null, tvSubTotalT1, "Tarea 1: ", aprobadasT1, omitidasT1, reprobadasT1)
                calcularResultado()
            }
        })
    }

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
                    aprobadasT2 = Objects.requireNonNull(etAprobadasT2.text).toString().toInt()
                }
                subtotalPdT2 = calcularTarea(null, tvSubTotalT2, "Tarea 2: ", aprobadasT2, omitidasT2, reprobadasT2)
                calcularResultado()
            }
        })

        etOmitidasT2.addTextChangedListener(object : TextWatcher {

            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
                subtotalPdT2 = 0.0
            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(s: Editable) {

                if (s.isEmpty()) {
                    omitidasT2 = 0
                } else if (s.isNotEmpty()) {
                    omitidasT2 = etOmitidasT2.text.toString().toInt()
                }
                subtotalPdT2 = calcularTarea(null, tvSubTotalT2, "Tarea 2: ", aprobadasT2, omitidasT2, reprobadasT2)
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
                    reprobadasT2 = Objects.requireNonNull(etReprobadasT2.text).toString().toInt()
                }
                subtotalPdT2 = calcularTarea(null, tvSubTotalT2, "Tarea 2: ", aprobadasT2, omitidasT2, reprobadasT2)
                calcularResultado()
            }
        })
    }

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
                    aprobadasT3 = Objects.requireNonNull(etAprobadasT3.text).toString().toInt()
                }
                subtotalPdT3 = calcularTarea(null, tvSubTotalT3, "Tarea 3: ", aprobadasT3, omitidasT3, reprobadasT3)
                calcularResultado()
            }
        })

        etOmitidasT3.addTextChangedListener(object : TextWatcher {

            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
                subtotalPdT3 = 0.0
            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(s: Editable) {

                if (s.isEmpty()) {
                    omitidasT3 = 0
                } else if (s.isNotEmpty()) {
                    omitidasT3 = Objects.requireNonNull(etOmitidasT3.text).toString().toInt()
                }
                subtotalPdT3 = calcularTarea(null, tvSubTotalT3, "Tarea 3: ", aprobadasT3, omitidasT3, reprobadasT3)
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
                    reprobadasT3 = Objects.requireNonNull(etReprobadasT3.text).toString().toInt()
                }
                subtotalPdT3 = calcularTarea(null, tvSubTotalT3, "Tarea 3: ", aprobadasT3, omitidasT3, reprobadasT3)
                calcularResultado()
            }
        })
    }

    override fun calcularTarea(n_tarea: Int?, tv_sub_total: TextView, tarea: String, aprobadas: Int?, omitidas: Int?, reprobadas: Int?): Double {
        var total: Double
        total = floor(aprobadas!! - (reprobadas!! + omitidas!!).toDouble())

        if (total < 0) {
            total = 0.0
        }

        tv_sub_total.text = String.format(Locale.US, "%s%s pts", tarea, total)
        return total
    }

    override fun calcularResultado() {

        //TOTALES
        val totalPd: Double = subtotalPdT1 + subtotalPdT2 + subtotalPdT3
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