/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2021

 Last modified 14-07-21 20:35
 */

package cl.figonzal.evaluatool.evalua.evalua9.modulo2

import android.os.Build
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.MenuItem
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import cl.figonzal.evaluatool.R
import cl.figonzal.evaluatool.databinding.ActivityRazonamientoEspacialE9M2Binding
import cl.figonzal.evaluatool.resolvers.evalua9.modulo2.RazonamientoEspacialE9M2Resolver
import cl.figonzal.evaluatool.resolvers.evalua9.modulo2.RazonamientoEspacialE9M2Resolver.Companion.DESVIACION
import cl.figonzal.evaluatool.resolvers.evalua9.modulo2.RazonamientoEspacialE9M2Resolver.Companion.MEDIA
import cl.figonzal.evaluatool.utilidades.*
import com.google.android.material.progressindicator.LinearProgressIndicator
import com.google.android.material.textfield.TextInputEditText

class RazonamientoEspacialE9M2 : AppCompatActivity() {

    private lateinit var binding: ActivityRazonamientoEspacialE9M2Binding

    //TAREA 1
    private lateinit var etAprobadasT11: TextInputEditText
    private lateinit var etReprobadasT11: TextInputEditText
    private lateinit var etAprobadasT12: TextInputEditText
    private lateinit var etReprobadasT12: TextInputEditText
    private var aprobadasT11 = 0
    private var reprobadasT11 = 0
    private var aprobadasT12 = 0
    private var reprobadasT12 = 0
    private var subTotalPdT11 = 0.0
    private var subTotalPdT12 = 0.0

    //TAREA 2
    private lateinit var etAprobadasT2: TextInputEditText
    private lateinit var etReprobadasT2: TextInputEditText
    private var aprobadasT2 = 0
    private var reprobadasT2 = 0

    //SUBTOTALES
    private lateinit var tvSubTotalT1: TextView
    private lateinit var tvSubTotalT2: TextView

    //TOTALES
    private lateinit var tvPdTotal: TextView
    private lateinit var tvPdCorregido: TextView
    private lateinit var tvPercentil: TextView
    private lateinit var tvNivel: TextView
    private lateinit var tvDesviacionCalculada: TextView
    private lateinit var progressBar: LinearProgressIndicator

    private val resolver by lazy {
        RazonamientoEspacialE9M2Resolver()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRazonamientoEspacialE9M2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        configActionBar(R.string.TOOLBAR_RAZON_ESPACIAL, binding.includeToolbar.materialToolbar)

        initResources()
    }

    /**
     * Funcion encargada de instanciar los recursos de la interfaz gráfica
     */
    private fun initResources() {

        with(binding, {
            cardViewConstantes.tvMediaValue.text = MEDIA.toString()
            cardViewConstantes.tvDesviacionValue.text = DESVIACION.toString()

            //TAREA 1
            tvSubTotalT1 = tvPdSubtotalT1
            this@RazonamientoEspacialE9M2.etAprobadasT11 = etAprobadasT11
            this@RazonamientoEspacialE9M2.etReprobadasT11 = etReprobadasT11
            this@RazonamientoEspacialE9M2.etAprobadasT12 = etAprobadasT12
            this@RazonamientoEspacialE9M2.etReprobadasT12 = etReprobadasT12

            //TAREA 2
            tvSubTotalT2 = tvPdSubtotalT2
            this@RazonamientoEspacialE9M2.etAprobadasT2 = etAprobadasT2
            this@RazonamientoEspacialE9M2.etReprobadasT2 = etReprobadasT2

            //TOTAL
            this@RazonamientoEspacialE9M2.tvPdTotal = tvPdTotalValue
            tvPdCorregido = cardViewFinal.tvPdTotalCorregidoValue
            tvPercentil = cardViewFinal.tvPercentilValue
            tvNivel = cardViewFinal.tvNivelObtenidoValue
            tvDesviacionCalculada = cardViewFinal.tvDesviacionCalculadaValue

            progressBar = cardViewFinal.progressBar
            progressBar.max = resolver.perc.first()[1] as Int

            cardViewFinal.ivHelpPdCorregido.setOnClickListener {

                logInfo(R.string.DIALOGO_AYUDA_MSG_ABIERTO)
                alertDialogPdCorregido()

            }
            Utils.configurarTextoBaremo(
                supportFragmentManager,
                tablaBaremo.tvBaremo,
                resolver.perc,
                getString(R.string.TOOLBAR_RAZON_ESPACIAL)
            )
        }).also {
            textWatcherTarea1(getString(R.string.TAREA_1))
            textWatcherTarea2(getString(R.string.TAREA_2))
        }
    }

    private fun textWatcherTarea1(tarea: String) {

        etAprobadasT11.run {
            addTextChangedListener(object : TextWatcher {

                override fun beforeTextChanged(
                    s: CharSequence,
                    start: Int,
                    count: Int,
                    after: Int
                ) {
                    subTotalPdT11 = 0.0
                }

                override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}

                override fun afterTextChanged(s: Editable) {

                    when {
                        s.isEmpty() -> aprobadasT11 = 0
                        s.isNotEmpty() -> aprobadasT11 = text.toString().toInt()
                    }

                    subTotalPdT11 = calcularSubTarea(11, aprobadasT11, reprobadasT11)

                    with(
                        resolver.calculateTask(
                            nTarea = 1,
                            aprobadas = subTotalPdT11.toInt(),
                            reprobadas = subTotalPdT12.toInt()
                        ), {
                            resolver.totalPdTarea1 = this
                            tvSubTotalT1.text = formatSubTotalPoints(tarea, this)
                        })
                    calculateResult()
                }
            })
        }

        etReprobadasT11.run {
            addTextChangedListener(object : TextWatcher {

                override fun beforeTextChanged(
                    s: CharSequence,
                    start: Int,
                    count: Int,
                    after: Int
                ) {
                    subTotalPdT11 = 0.0
                }

                override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}

                override fun afterTextChanged(s: Editable) {

                    when {
                        s.isEmpty() -> reprobadasT11 = 0
                        s.isNotEmpty() -> reprobadasT11 = text.toString().toInt()
                    }

                    subTotalPdT11 = calcularSubTarea(11, aprobadasT11, reprobadasT11)

                    with(
                        resolver.calculateTask(
                            nTarea = 1,
                            aprobadas = subTotalPdT11.toInt(),
                            reprobadas = subTotalPdT12.toInt()
                        ), {
                            resolver.totalPdTarea1 = this
                            tvSubTotalT1.text = formatSubTotalPoints(tarea, this)
                        })
                    calculateResult()
                }
            })
        }

        etAprobadasT12.run {
            addTextChangedListener(object : TextWatcher {

                override fun beforeTextChanged(
                    s: CharSequence,
                    start: Int,
                    count: Int,
                    after: Int
                ) {
                    subTotalPdT12 = 0.0
                }

                override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}

                override fun afterTextChanged(s: Editable) {

                    when {
                        s.isEmpty() -> aprobadasT12 = 0
                        s.isNotEmpty() -> aprobadasT12 = text.toString().toInt()
                    }

                    subTotalPdT12 = calcularSubTarea(12, aprobadasT12, reprobadasT12)

                    with(
                        resolver.calculateTask(
                            nTarea = 1,
                            aprobadas = subTotalPdT11.toInt(),
                            reprobadas = subTotalPdT12.toInt()
                        ), {
                            resolver.totalPdTarea1 = this
                            tvSubTotalT1.text = formatSubTotalPoints(tarea, this)
                        })
                    calculateResult()
                }
            })
        }

        etReprobadasT12.run {
            addTextChangedListener(object : TextWatcher {

                override fun beforeTextChanged(
                    s: CharSequence,
                    start: Int,
                    count: Int,
                    after: Int
                ) {
                    subTotalPdT12 = 0.0
                }

                override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}

                override fun afterTextChanged(s: Editable) {

                    when {
                        s.isEmpty() -> reprobadasT12 = 0
                        s.isNotEmpty() -> reprobadasT12 = text.toString().toInt()
                    }

                    subTotalPdT12 = calcularSubTarea(12, aprobadasT12, reprobadasT12)

                    with(
                        resolver.calculateTask(
                            nTarea = 1,
                            aprobadas = subTotalPdT11.toInt(),
                            reprobadas = subTotalPdT12.toInt()
                        ), {
                            resolver.totalPdTarea1 = this
                            tvSubTotalT1.text = formatSubTotalPoints(tarea, this)
                        })
                    calculateResult()
                }
            })
        }
    }

    private fun textWatcherTarea2(tarea: String) {

        etAprobadasT2.run {
            addTextChangedListener(object : TextWatcher {

                override fun beforeTextChanged(
                    s: CharSequence,
                    start: Int,
                    count: Int,
                    after: Int
                ) {
                    resolver.totalPdTarea2 = 0.0
                }

                override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}

                override fun afterTextChanged(s: Editable) {

                    when {
                        s.isEmpty() -> aprobadasT2 = 0
                        s.isNotEmpty() -> aprobadasT2 = text.toString().toInt()
                    }
                    with(
                        resolver.calculateTask(
                            nTarea = 2,
                            aprobadas = aprobadasT2,
                            reprobadas = reprobadasT2
                        ), {
                            resolver.totalPdTarea2 = this
                            tvSubTotalT2.text = formatSubTotalPoints(tarea, this)
                        })
                    calculateResult()
                }
            })
        }

        etReprobadasT2.run {
            addTextChangedListener(object : TextWatcher {

                override fun beforeTextChanged(
                    s: CharSequence,
                    start: Int,
                    count: Int,
                    after: Int
                ) {
                    resolver.totalPdTarea2 = 0.0
                }

                override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}

                override fun afterTextChanged(s: Editable) {

                    when {
                        s.isEmpty() -> reprobadasT2 = 0
                        s.isNotEmpty() -> reprobadasT2 = text.toString().toInt()
                    }
                    with(
                        resolver.calculateTask(
                            nTarea = 2,
                            aprobadas = aprobadasT2,
                            reprobadas = reprobadasT2
                        ), {
                            resolver.totalPdTarea2 = this
                            tvSubTotalT2.text = formatSubTotalPoints(tarea, this)
                        })
                    calculateResult()
                }
            })
        }
    }

    private fun calculateResult() {

        //Calculate Total PD
        resolver.run {

            tvPdTotal.text = formatResult(R.string.POINTS_SIMPLE_FORMAT, getTotal())

            //Correct total pd based on Baremo Table
            val pdCorregido = correctPD(perc, getTotal().toInt())
            tvPdCorregido.text = formatResult(R.string.POINTS_SIMPLE_FORMAT, pdCorregido.toDouble())

            //Calculate desviation
            tvDesviacionCalculada.text =
                Utils.calcularDesviacion2(MEDIA, DESVIACION, pdCorregido)

            //Calculate Percentile
            val percentile = Utils.calculatePercentile(perc, pdCorregido)
            tvPercentil.text = percentile.toString()

            when {
                Build.VERSION.SDK_INT >= Build.VERSION_CODES.N -> progressBar.setProgressCompat(
                    percentile,
                    true
                )
                else -> progressBar.progress = percentile
            }

            //Calculate student level
            tvNivel.text = Utils.calcularNivel(percentile)
        }
    }

    private fun calcularSubTarea(subTarea: Int, aprobadas: Int, reprobadas: Int): Double {
        return when (subTarea) {
            //TAREA 1_1 items 1-7
            11 -> aprobadas - (reprobadas / 5.0)

            //TAREA 1_2 items 8-9
            12 -> aprobadas - (reprobadas / 10.0)
            else -> 0.0
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if (item.itemId == android.R.id.home) {
            logInfo(R.string.ACTIVIDAD_CERRADA)
            finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

}