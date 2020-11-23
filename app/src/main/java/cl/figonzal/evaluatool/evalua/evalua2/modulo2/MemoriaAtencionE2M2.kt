/*
 *
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE', which is part of this source code package
 *
 * Autor: Felipe González
 * Email: felipe.gonzalezalarcon94@gmail.com
 *
 * Copyright (c) 2020
 *
 * Last modified 16-11-20 16:54
 */
package cl.figonzal.evaluatool.evalua.evalua2.modulo2

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
import cl.figonzal.evaluatool.utilidades.Utilidades
import com.google.android.material.textfield.TextInputEditText
import timber.log.Timber
import java.util.*
import kotlin.math.floor

class MemoriaAtencionE2M2 : AppCompatActivity(), EvaluaInterface {

    companion object {
        private const val DESVIACION = 13.04
        private const val MEDIA = 59.35
    }

    private val perc = arrayOf(
            arrayOf(88, 99),
            arrayOf(87, 99),
            arrayOf(86, 99),
            arrayOf(85, 99),
            arrayOf(84, 99),
            arrayOf(83, 99),
            arrayOf(82, 99),
            arrayOf(81, 99),
            arrayOf(80, 95),
            arrayOf(79, 95),
            arrayOf(78, 95),
            arrayOf(77, 95),
            arrayOf(76, 95),
            arrayOf(75, 85),
            arrayOf(74, 85),
            arrayOf(73, 85),
            arrayOf(72, 85),
            arrayOf(71, 85),
            arrayOf(70, 75),
            arrayOf(69, 75),
            arrayOf(68, 75),
            arrayOf(67, 75),
            arrayOf(66, 75),
            arrayOf(65, 65),
            arrayOf(64, 65),
            arrayOf(63, 65),
            arrayOf(62, 65),
            arrayOf(61, 65),
            arrayOf(60, 50),
            arrayOf(59, 50),
            arrayOf(58, 50),
            arrayOf(57, 50),
            arrayOf(56, 50),
            arrayOf(55, 45),
            arrayOf(54, 45),
            arrayOf(53, 45),
            arrayOf(52, 45),
            arrayOf(51, 45),
            arrayOf(50, 35),
            arrayOf(49, 35),
            arrayOf(48, 35),
            arrayOf(47, 35),
            arrayOf(46, 35),
            arrayOf(45, 30),
            arrayOf(44, 30),
            arrayOf(43, 30),
            arrayOf(42, 30),
            arrayOf(41, 30),
            arrayOf(40, 20),
            arrayOf(39, 20),
            arrayOf(38, 20),
            arrayOf(37, 20),
            arrayOf(36, 20),
            arrayOf(35, 15),
            arrayOf(34, 15),
            arrayOf(33, 15),
            arrayOf(32, 15),
            arrayOf(31, 15),
            arrayOf(30, 10),
            arrayOf(29, 10),
            arrayOf(27, 10),
            arrayOf(26, 10),
            arrayOf(25, 7),
            arrayOf(24, 7),
            arrayOf(23, 7),
            arrayOf(22, 7),
            arrayOf(21, 7),
            arrayOf(20, 5),
            arrayOf(19, 5),
            arrayOf(18, 5),
            arrayOf(17, 5),
            arrayOf(16, 5),
            arrayOf(15, 3),
            arrayOf(14, 3),
            arrayOf(13, 3),
            arrayOf(12, 3),
            arrayOf(11, 3),
            arrayOf(10, 1),
            arrayOf(9, 1),
            arrayOf(8, 1),
            arrayOf(7, 1),
            arrayOf(6, 1)
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

    //TAREA 4
    private lateinit var etAprobadasT4: TextInputEditText
    private lateinit var etOmitidasT4: TextInputEditText
    private lateinit var etReprobadasT4: TextInputEditText
    private var aprobadasT4 = 0
    private var omitidasT4 = 0
    private var reprobadasT4 = 0

    //TAREA 5
    private lateinit var etAprobadasT5: TextInputEditText
    private lateinit var etOmitidasT5: TextInputEditText
    private lateinit var etReprobadasT5: TextInputEditText
    private var aprobadasT5 = 0
    private var omitidasT5 = 0
    private var reprobadasT5 = 0

    //TAREA 6
    private lateinit var etAprobadasT6: TextInputEditText
    private lateinit var etOmitidasT6: TextInputEditText
    private lateinit var etReprobadasT6: TextInputEditText
    private var aprobadasT6 = 0
    private var omitidasT6 = 0
    private var reprobadasT6 = 0

    //SUBTOTALES
    private lateinit var tvSubTotalT1: TextView
    private lateinit var tvSubTotalT2: TextView
    private lateinit var tvSubTotalT3: TextView
    private lateinit var tvSubTotalT4: TextView
    private lateinit var tvSubTotalT5: TextView
    private lateinit var tvSubTotalT6: TextView
    private var subtotalPdT1 = 0.0
    private var subtotalPdT2 = 0.0
    private var subtotalPdT3 = 0.0
    private var subtotalPdT4 = 0.0
    private var subtotalPdT5 = 0.0
    private var subtotalPdT6 = 0.0

    //TOTAL
    private lateinit var tvPdTotal: TextView
    private lateinit var tvPdCorregido: TextView
    private lateinit var tvPercentil: TextView
    private lateinit var tvNivel: TextView
    private lateinit var tvDesviacionCalculada: TextView
    private lateinit var progressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_memoria_atencion_e2_m2)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        toolbar.setTitleTextColor(resources.getColor(R.color.colorOnPrimary, theme))
        setSupportActionBar(toolbar)

        val actionBar = supportActionBar!!
        actionBar.setDisplayHomeAsUpEnabled(true)
        actionBar.setHomeAsUpIndicator(R.drawable.ic_arrow_back_white_24dp)
        actionBar.title = getString(R.string.TOOLBAR_MEMORIA_ATENCION)

        instanciarRecursosInterfaz()
        textWatcherTarea1()
        textWatcherTarea2()
        textWatcherTarea3()
        textWatcherTarea4()
        textWatcherTarea5()
        textWatcherTarea6()
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

        //TAREA 3
        tvSubTotalT3 = findViewById(R.id.tv_pd_subtotal_t3)
        etAprobadasT3 = findViewById(R.id.et_aprobadas_t3)
        etOmitidasT3 = findViewById(R.id.et_omitidas_t3)
        etReprobadasT3 = findViewById(R.id.et_reprobadas_t3)

        //TAREA 4
        tvSubTotalT4 = findViewById(R.id.tv_pd_subtotal_t4)
        etAprobadasT4 = findViewById(R.id.et_aprobadas_t4)
        etOmitidasT4 = findViewById(R.id.et_omitidas_t4)
        etReprobadasT4 = findViewById(R.id.et_reprobadas_t4)

        //TAREA 5
        tvSubTotalT5 = findViewById(R.id.tv_pd_subtotal_t5)
        etAprobadasT5 = findViewById(R.id.et_aprobadas_t5)
        etOmitidasT5 = findViewById(R.id.et_omitidas_t5)
        etReprobadasT5 = findViewById(R.id.et_reprobadas_t5)

        //TAREA 6
        tvSubTotalT6 = findViewById(R.id.tv_pd_subtotal_t6)
        etAprobadasT6 = findViewById(R.id.et_aprobadas_t6)
        etOmitidasT6 = findViewById(R.id.et_omitidas_t6)
        etReprobadasT6 = findViewById(R.id.et_reprobadas_t6)

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
        Utilidades.configurarTextoBaremo(supportFragmentManager, tvBaremo, perc, getString(R.string.TOOLBAR_MEMORIA_ATENCION))

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
                    aprobadasT2 = etAprobadasT2.text.toString().toInt()
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
                    reprobadasT2 = etReprobadasT2.text.toString().toInt()
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
                    aprobadasT3 = etAprobadasT3.text.toString().toInt()
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
                    omitidasT3 = etOmitidasT3.text.toString().toInt()
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
                    reprobadasT3 = etReprobadasT3.text.toString().toInt()
                }
                subtotalPdT3 = calcularTarea(null, tvSubTotalT3, "Tarea 3: ", aprobadasT3, omitidasT3, reprobadasT3)
                calcularResultado()
            }
        })
    }

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
                subtotalPdT4 = calcularTarea(null, tvSubTotalT4, "Tarea 4: ", aprobadasT4, omitidasT4, reprobadasT4)
                calcularResultado()
            }
        })

        etOmitidasT4.addTextChangedListener(object : TextWatcher {

            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
                subtotalPdT4 = 0.0
            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(s: Editable) {

                if (s.isEmpty()) {
                    omitidasT4 = 0
                } else if (s.isNotEmpty()) {
                    omitidasT4 = etOmitidasT4.text.toString().toInt()
                }
                subtotalPdT4 = calcularTarea(null, tvSubTotalT4, "Tarea 4: ", aprobadasT4, omitidasT4, reprobadasT4)
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
                subtotalPdT4 = calcularTarea(null, tvSubTotalT4, "Tarea 4: ", aprobadasT4, omitidasT4, reprobadasT4)
                calcularResultado()
            }
        })
    }

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
                subtotalPdT5 = calcularTarea(null, tvSubTotalT5, "Tarea 5: ", aprobadasT5, omitidasT5, reprobadasT5)
                calcularResultado()
            }
        })

        etOmitidasT5.addTextChangedListener(object : TextWatcher {

            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
                subtotalPdT5 = 0.0
            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(s: Editable) {

                if (s.isEmpty()) {
                    omitidasT5 = 0
                } else if (s.isNotEmpty()) {
                    omitidasT5 = etOmitidasT5.text.toString().toInt()
                }
                subtotalPdT5 = calcularTarea(null, tvSubTotalT5, "Tarea 5: ", aprobadasT5, omitidasT5, reprobadasT5)
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
                subtotalPdT5 = calcularTarea(null, tvSubTotalT5, "Tarea 5: ", aprobadasT5, omitidasT5, reprobadasT5)
                calcularResultado()
            }
        })
    }

    private fun textWatcherTarea6() {

        etAprobadasT6.addTextChangedListener(object : TextWatcher {

            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
                subtotalPdT6 = 0.0
            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(s: Editable) {

                if (s.isEmpty()) {
                    aprobadasT6 = 0
                } else if (s.isNotEmpty()) {
                    aprobadasT6 = etAprobadasT6.text.toString().toInt()
                }
                subtotalPdT6 = calcularTarea(null, tvSubTotalT6, "Tarea 6: ", aprobadasT6, omitidasT6, reprobadasT6)
                calcularResultado()
            }
        })
        etOmitidasT6.addTextChangedListener(object : TextWatcher {

            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
                subtotalPdT6 = 0.0
            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(s: Editable) {

                if (s.isEmpty()) {
                    omitidasT6 = 0
                } else if (s.isNotEmpty()) {
                    omitidasT6 = etOmitidasT6.text.toString().toInt()
                }
                subtotalPdT6 = calcularTarea(null, tvSubTotalT6, "Tarea 6: ", aprobadasT6, omitidasT6, reprobadasT6)
                calcularResultado()
            }
        })

        etReprobadasT6.addTextChangedListener(object : TextWatcher {

            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
                subtotalPdT6 = 0.0
            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(s: Editable) {

                if (s.isEmpty()) {
                    reprobadasT6 = 0
                } else if (s.isNotEmpty()) {
                    reprobadasT6 = etReprobadasT6.text.toString().toInt()
                }
                subtotalPdT6 = calcularTarea(null, tvSubTotalT6, "Tarea 6: ", aprobadasT6, omitidasT6, reprobadasT6)
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
        val totalPd: Double = subtotalPdT1 + subtotalPdT2 + subtotalPdT3 + subtotalPdT4 + subtotalPdT5 + subtotalPdT6
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

        val nivel = Utilidades.calcularNivel(percentil)
        tvNivel.text = nivel

        val desviacion = Utilidades.calcularDesviacion(MEDIA, DESVIACION, pdCorregido, false)
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