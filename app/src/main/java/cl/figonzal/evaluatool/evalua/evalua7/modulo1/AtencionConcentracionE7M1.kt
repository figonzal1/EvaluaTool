/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2020

 Last modified 27-11-20 1:07
 */
package cl.figonzal.evaluatool.evalua.evalua7.modulo1

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

class AtencionConcentracionE7M1 : AppCompatActivity(), EvaluaInterface {

    companion object {
        private const val DESVIACION = 28.04
        private const val MEDIA = 115.68
    }

    private val perc = arrayOf(
            arrayOf(192, 99),
            arrayOf(191, 99),
            arrayOf(190, 99),
            arrayOf(189, 99),
            arrayOf(188, 99),
            arrayOf(187, 99),
            arrayOf(186, 99),
            arrayOf(185, 99),

            arrayOf(184, 95),
            arrayOf(183, 95),
            arrayOf(182, 95),
            arrayOf(181, 95),
            arrayOf(180, 95),

            arrayOf(179, 90),
            arrayOf(178, 90),
            arrayOf(177, 90),
            arrayOf(176, 90),
            arrayOf(175, 90),

            arrayOf(174, 87),
            arrayOf(173, 87),
            arrayOf(172, 87),
            arrayOf(171, 87),
            arrayOf(170, 87),

            arrayOf(169, 85),
            arrayOf(168, 85),
            arrayOf(167, 85),
            arrayOf(166, 85),
            arrayOf(165, 85),

            arrayOf(164, 80),
            arrayOf(163, 80),
            arrayOf(162, 80),
            arrayOf(161, 80),
            arrayOf(160, 80),

            arrayOf(159, 78),
            arrayOf(158, 78),
            arrayOf(157, 78),
            arrayOf(156, 78),
            arrayOf(155, 78),

            arrayOf(154, 75),
            arrayOf(153, 75),
            arrayOf(152, 75),
            arrayOf(151, 75),
            arrayOf(150, 75),

            arrayOf(149, 72),
            arrayOf(148, 72),
            arrayOf(147, 72),
            arrayOf(146, 72),
            arrayOf(145, 72),

            arrayOf(144, 70),
            arrayOf(143, 70),
            arrayOf(142, 70),
            arrayOf(141, 70),
            arrayOf(140, 70),

            arrayOf(139, 65),
            arrayOf(138, 65),
            arrayOf(137, 65),
            arrayOf(136, 65),
            arrayOf(135, 65),

            arrayOf(134, 63),
            arrayOf(133, 63),
            arrayOf(132, 63),
            arrayOf(131, 63),
            arrayOf(130, 63),

            arrayOf(129, 60),
            arrayOf(128, 60),
            arrayOf(127, 60),
            arrayOf(126, 60),
            arrayOf(125, 60),

            arrayOf(124, 55),
            arrayOf(123, 55),
            arrayOf(122, 55),
            arrayOf(121, 55),
            arrayOf(120, 55),

            arrayOf(119, 50),
            arrayOf(118, 50),
            arrayOf(117, 50),
            arrayOf(116, 50),
            arrayOf(115, 50),

            arrayOf(114, 45),
            arrayOf(113, 45),
            arrayOf(112, 45),
            arrayOf(111, 45),
            arrayOf(110, 45),

            arrayOf(109, 40),
            arrayOf(108, 40),
            arrayOf(107, 40),
            arrayOf(106, 40),
            arrayOf(105, 40),

            arrayOf(104, 35),
            arrayOf(103, 35),
            arrayOf(102, 35),
            arrayOf(101, 35),
            arrayOf(100, 35),

            arrayOf(99, 30),
            arrayOf(98, 30),
            arrayOf(97, 30),
            arrayOf(96, 30),
            arrayOf(95, 30),

            arrayOf(94, 25),
            arrayOf(93, 25),
            arrayOf(92, 25),
            arrayOf(91, 25),
            arrayOf(90, 25),

            arrayOf(89, 18),
            arrayOf(88, 18),
            arrayOf(87, 18),
            arrayOf(86, 18),
            arrayOf(85, 18),

            arrayOf(84, 15),
            arrayOf(83, 15),
            arrayOf(82, 15),
            arrayOf(81, 15),
            arrayOf(80, 15),

            arrayOf(79, 12),
            arrayOf(78, 12),
            arrayOf(77, 12),
            arrayOf(76, 12),
            arrayOf(75, 12),

            arrayOf(74, 10),
            arrayOf(73, 10),
            arrayOf(72, 10),
            arrayOf(71, 10),
            arrayOf(70, 10),

            arrayOf(69, 9),
            arrayOf(68, 9),
            arrayOf(67, 9),
            arrayOf(66, 9),
            arrayOf(65, 9),

            arrayOf(64, 7),
            arrayOf(63, 7),
            arrayOf(62, 7),
            arrayOf(61, 7),
            arrayOf(60, 7),

            arrayOf(59, 5),
            arrayOf(58, 5),
            arrayOf(57, 5),
            arrayOf(56, 5),
            arrayOf(55, 5),

            arrayOf(54, 3),
            arrayOf(53, 3),
            arrayOf(52, 3),
            arrayOf(51, 3),
            arrayOf(50, 3),

            arrayOf(49, 1),
            arrayOf(48, 1),
            arrayOf(47, 1),
            arrayOf(46, 1),
            arrayOf(45, 1)
    )

    private lateinit var etAprobadasT1: TextInputEditText
    private lateinit var etOmitidasT1: TextInputEditText
    private lateinit var etReprobadasT1: TextInputEditText
    private lateinit var etAprobadasT2: TextInputEditText
    private lateinit var etOmitidasT2: TextInputEditText
    private lateinit var etReprobadasT2: TextInputEditText

    //TextView para Subtotales
    private lateinit var tvSubTotalT1: TextView
    private lateinit var tvSubTotalT2: TextView

    //Parciales Tarea 1
    private var aprobadasT1 = 0
    private var omitidasT1 = 0
    private var reprobadasT1 = 0

    //Parciales para Tarea 2
    private var aprobadasT2 = 0
    private var omitidasT2 = 0
    private var reprobadasT2 = 0

    //Tetview para total
    private lateinit var tvPdTotal: TextView
    private lateinit var tvPdCorregido: TextView
    private lateinit var tvPercentil: TextView
    private lateinit var tvNivel: TextView
    private lateinit var progressBar: ProgressBar
    private lateinit var tvDesviacionCalculada: TextView

    private var totalPdTarea1 = 0.0
    private var totalPdTarea2 = 0.0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_atencion_concentracion_e7_m1)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        toolbar.setTitleTextColor(resources.getColor(R.color.colorOnPrimary, theme))
        setSupportActionBar(toolbar)

        val actionBar = supportActionBar!!
        actionBar.setDisplayHomeAsUpEnabled(true)
        actionBar.setHomeAsUpIndicator(R.drawable.ic_arrow_back_white_24dp)
        actionBar.title = getString(R.string.TOOLBAR_ATENCION_CONCENTRACION)

        instanciarRecursosInterfaz()
        textWatcherTarea1()
        textWatcherTarea2()
    }

    /**
     * Funcion encargada de la logica de los TextWatcher de la tarea 1
     */
    private fun textWatcherTarea1() {

        etAprobadasT1.addTextChangedListener(object : TextWatcher {

            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
                totalPdTarea1 = 0.0
            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(s: Editable) {

                if (s.isEmpty()) {
                    aprobadasT1 = 0
                } else if (s.isNotEmpty()) {
                    aprobadasT1 = etAprobadasT1.text.toString().toInt()
                }
                totalPdTarea1 = calcularTarea(null, tvSubTotalT1, "Tarea 1: ", aprobadasT1, omitidasT1, reprobadasT1)
                calcularResultado()
            }
        })

        etOmitidasT1.addTextChangedListener(object : TextWatcher {

            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
                totalPdTarea1 = 0.0
            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(s: Editable) {

                if (s.isEmpty()) {
                    omitidasT1 = 0
                } else if (s.isNotEmpty()) {
                    omitidasT1 = etOmitidasT1.text.toString().toInt()
                }
                totalPdTarea1 = calcularTarea(null, tvSubTotalT1, "Tarea 1: ", aprobadasT1, omitidasT1, reprobadasT1)
                calcularResultado()
            }
        })

        etReprobadasT1.addTextChangedListener(object : TextWatcher {

            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
                totalPdTarea1 = 0.0
            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(s: Editable) {

                if (s.isEmpty()) {
                    reprobadasT1 = 0
                } else if (s.isNotEmpty()) {
                    reprobadasT1 = etReprobadasT1.text.toString().toInt()
                }
                totalPdTarea1 = calcularTarea(null, tvSubTotalT1, "Tarea 1: ", aprobadasT1, omitidasT1, reprobadasT1)
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
                totalPdTarea2 = 0.0
            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(s: Editable) {

                if (s.isEmpty()) {
                    aprobadasT2 = 0
                } else if (s.isNotEmpty()) {
                    aprobadasT2 = etAprobadasT2.text.toString().toInt()
                }
                totalPdTarea2 = calcularTarea(null, tvSubTotalT2, "Tarea 2: ", aprobadasT2, omitidasT2, reprobadasT2)
                calcularResultado()
            }
        })

        etOmitidasT2.addTextChangedListener(object : TextWatcher {

            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
                totalPdTarea2 = 0.0
            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(s: Editable) {

                if (s.isEmpty()) {
                    omitidasT2 = 0
                } else if (s.isNotEmpty()) {
                    omitidasT2 = etOmitidasT2.text.toString().toInt()
                }
                totalPdTarea2 = calcularTarea(null, tvSubTotalT2, "Tarea 2: ", aprobadasT2, omitidasT2, reprobadasT2)
                calcularResultado()
            }
        })
        etReprobadasT2.addTextChangedListener(object : TextWatcher {

            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
                totalPdTarea2 = 0.0
            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(s: Editable) {

                if (s.isEmpty()) {
                    reprobadasT2 = 0
                } else if (s.isNotEmpty()) {
                    reprobadasT2 = etReprobadasT2.text.toString().toInt()
                }
                totalPdTarea2 = calcularTarea(null, tvSubTotalT2, "Tarea 2: ", aprobadasT2, omitidasT2, reprobadasT2)
                calcularResultado()
            }
        })
    }

    /**
     * Funcion encargada de instanciar los recursos de la interfaz gráfica
     */
    private fun instanciarRecursosInterfaz() {

        //Promedio y desviacion
        //TetView desviacion y media
        val tvMedia = findViewById<TextView>(R.id.tv_media_value)
        val tvDesviacion = findViewById<TextView>(R.id.tv_desviacion_value)
        tvMedia.text = MEDIA.toString()
        tvDesviacion.text = DESVIACION.toString()

        //TAREA 1
        tvSubTotalT1 = findViewById(R.id.tv_pd_subtotal_t1)
        etAprobadasT1 = findViewById(R.id.et_aprobadas_t1)
        etOmitidasT1 = findViewById(R.id.et_omitidas_t1)
        etReprobadasT1 = findViewById(R.id.et_reprobadas_t1)

        //TAREA 2
        tvSubTotalT2 = findViewById(R.id.tv_pd_subtotal_t2)
        etAprobadasT2 = findViewById(R.id.et_aprobadas_t2)
        etOmitidasT2 = findViewById(R.id.et_omitidas_t2)
        etReprobadasT2 = findViewById(R.id.et_reprobadas_t2)

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
        EvaluaUtils.configurarTextoBaremo(supportFragmentManager, tvBaremo, perc, getString(R.string.TOOLBAR_ATENCION_CONCENTRACION))

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

        val totalPd = totalPdTarea1 + totalPdTarea2
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
        //Si el alumno sobrepasa tabla retornar percentil maximo
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
                    when (pd_actual) {
                        item[0].toDouble() -> {
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