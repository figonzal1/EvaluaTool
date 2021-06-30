/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2021

 Last modified 30-06-21 16:33
 */
package cl.figonzal.evaluatool.evalua.evalua1.modulo4

import android.os.Build
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.MenuItem
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import cl.figonzal.evaluatool.R
import cl.figonzal.evaluatool.databinding.ActivityExactitudLectoraE1M4Binding
import cl.figonzal.evaluatool.resolvers.evalua1.modulo4.ExactitudLectoraE1M4Resolver
import cl.figonzal.evaluatool.resolvers.evalua1.modulo4.ExactitudLectoraE1M4Resolver.Companion.DESVIACION
import cl.figonzal.evaluatool.resolvers.evalua1.modulo4.ExactitudLectoraE1M4Resolver.Companion.MEDIA
import cl.figonzal.evaluatool.utilidades.*
import com.google.android.material.progressindicator.LinearProgressIndicator
import com.google.android.material.textfield.TextInputEditText
import java.util.*

class ExactitudLectoraE1M4 : AppCompatActivity() {

    private lateinit var binding: ActivityExactitudLectoraE1M4Binding

    //TAREA 1
    private lateinit var etAprobadasT1: TextInputEditText
    private var aprobadasT1 = 0

    //TAREA 2
    private lateinit var etAprobadasT2: TextInputEditText
    private var aprobadasT2 = 0

    //TAREA 3
    private lateinit var etAprobadasT3: TextInputEditText
    private var aprobadasT3 = 0

    //TAREA 4
    private lateinit var etAprobadasT4: TextInputEditText
    private var aprobadasT4 = 0

    //TAREA 5
    private lateinit var etAprobadasT5: TextInputEditText
    private var aprobadasT5 = 0

    //TAREA 6
    private lateinit var etAprobadasT6: TextInputEditText
    private var aprobadasT6 = 0

    //SUBTOTALES
    private lateinit var tvSubTotalT1: TextView
    private lateinit var tvSubTotalT2: TextView
    private lateinit var tvSubTotalT3: TextView
    private lateinit var tvSubTotalT4: TextView
    private lateinit var tvSubTotalT5: TextView
    private lateinit var tvSubTotalT6: TextView

    //TOTALES
    private lateinit var tvPdTotal: TextView
    private lateinit var tvPdCorregido: TextView
    private lateinit var tvPercentil: TextView
    private lateinit var tvNivel: TextView
    private lateinit var tvDesviacionCalculada: TextView
    private lateinit var progressBar: LinearProgressIndicator

    private val resolver by lazy {
        ExactitudLectoraE1M4Resolver()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityExactitudLectoraE1M4Binding.inflate(layoutInflater)
        setContentView(binding.root)

        configActionBar(R.string.TOOLBAR_EXACTITUD_LECTORA, binding.includeToolbar.materialToolbar)

        instanciarRecursosInterfaz()
    }

    private fun instanciarRecursosInterfaz() {

        with(binding, {
            //Promedio y desviacion
            //TetView desviacion y media
            cardViewConstantes.tvMediaValue.text = MEDIA.toString()
            cardViewConstantes.tvDesviacionValue.text = DESVIACION.toString()

            //TAREA 1
            tvSubTotalT1 = tvPdSubtotalT1
            this@ExactitudLectoraE1M4.etAprobadasT1 = etAprobadasT1

            //TAREA 2
            tvSubTotalT2 = tvPdSubtotalT2
            this@ExactitudLectoraE1M4.etAprobadasT2 = etAprobadasT2

            //TAREA 3
            tvSubTotalT3 = tvPdSubtotalT3
            this@ExactitudLectoraE1M4.etAprobadasT3 = etAprobadasT3

            //TAREA 4
            tvSubTotalT4 = tvPdSubtotalT4
            this@ExactitudLectoraE1M4.etAprobadasT4 = etAprobadasT4

            //TAREA 5
            tvSubTotalT5 = tvPdSubtotalT5
            this@ExactitudLectoraE1M4.etAprobadasT5 = etAprobadasT5

            //TAREA 6
            tvSubTotalT6 = tvPdSubtotalT6
            this@ExactitudLectoraE1M4.etAprobadasT6 = etAprobadasT6

            //TOTAL
            this@ExactitudLectoraE1M4.tvPdTotal = tvPdTotalValue
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
                getString(R.string.TOOLBAR_EXACTITUD_LECTORA)
            )
        }).also {
            textWatcherTarea1(getString(R.string.TAREA_1))
            textWatcherTarea2(getString(R.string.TAREA_2))
            textWatcherTarea3(getString(R.string.TAREA_3))
            textWatcherTarea4(getString(R.string.TAREA_4))
            textWatcherTarea5(getString(R.string.TAREA_5))
            textWatcherTarea6(getString(R.string.TAREA_6))
        }
    }


    private fun textWatcherTarea1(tarea: String) {

        etAprobadasT1.run {
            addTextChangedListener(object : TextWatcher {

                override fun beforeTextChanged(
                    s: CharSequence,
                    start: Int,
                    count: Int,
                    after: Int
                ) {
                    resolver.totalPdTarea1 = 0.0
                }

                override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}

                override fun afterTextChanged(s: Editable) {

                    when {
                        s.isEmpty() -> aprobadasT1 = 0
                        s.isNotEmpty() -> aprobadasT1 = text.toString().toInt()
                    }
                    with(
                        resolver.calculateTask(
                            nTarea = 1,
                            aprobadas = aprobadasT1
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
                            aprobadas = aprobadasT2
                        ), {
                            resolver.totalPdTarea2 = this
                            tvSubTotalT2.text = formatSubTotalPoints(tarea, this)
                        })
                    calculateResult()
                }
            })
        }
    }

    private fun textWatcherTarea3(tarea: String) {

        etAprobadasT3.run {
            addTextChangedListener(object : TextWatcher {

                override fun beforeTextChanged(
                    s: CharSequence,
                    start: Int,
                    count: Int,
                    after: Int
                ) {
                    resolver.totalPdTarea3 = 0.0
                }

                override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}

                override fun afterTextChanged(s: Editable) {

                    when {
                        s.isEmpty() -> aprobadasT3 = 0
                        s.isNotEmpty() -> aprobadasT3 = text.toString().toInt()
                    }
                    with(
                        resolver.calculateTask(
                            nTarea = 3,
                            aprobadas = aprobadasT3
                        ), {
                            resolver.totalPdTarea3 = this
                            tvSubTotalT3.text = formatSubTotalPoints(tarea, this)
                        })
                    calculateResult()
                }
            })
        }
    }

    private fun textWatcherTarea4(tarea: String) {

        etAprobadasT4.run {
            addTextChangedListener(object : TextWatcher {

                override fun beforeTextChanged(
                    s: CharSequence,
                    start: Int,
                    count: Int,
                    after: Int
                ) {
                    resolver.totalPdTarea4 = 0.0
                }

                override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}

                override fun afterTextChanged(s: Editable) {

                    when {
                        s.isEmpty() -> aprobadasT4 = 0
                        s.isNotEmpty() -> aprobadasT4 = text.toString().toInt()
                    }
                    with(
                        resolver.calculateTask(
                            nTarea = 4,
                            aprobadas = aprobadasT4
                        ), {
                            resolver.totalPdTarea4 = this
                            tvSubTotalT4.text = formatSubTotalPoints(tarea, this)
                        })
                    calculateResult()
                }
            })
        }
    }

    private fun textWatcherTarea5(tarea: String) {

        etAprobadasT5.run {
            addTextChangedListener(object : TextWatcher {

                override fun beforeTextChanged(
                    s: CharSequence,
                    start: Int,
                    count: Int,
                    after: Int
                ) {
                    resolver.totalPdTarea5 = 0.0
                }

                override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}

                override fun afterTextChanged(s: Editable) {

                    when {
                        s.isEmpty() -> aprobadasT5 = 0
                        s.isNotEmpty() -> aprobadasT5 = text.toString().toInt()
                    }
                    with(
                        resolver.calculateTask(
                            nTarea = 5,
                            aprobadas = aprobadasT5
                        ), {
                            resolver.totalPdTarea5 = this
                            tvSubTotalT5.text = formatSubTotalPoints(tarea, this)
                        })
                    calculateResult()
                }
            })
        }
    }

    private fun textWatcherTarea6(tarea: String) {

        etAprobadasT6.run {
            addTextChangedListener(object : TextWatcher {

                override fun beforeTextChanged(
                    s: CharSequence,
                    start: Int,
                    count: Int,
                    after: Int
                ) {
                    resolver.totalPdTarea6 = 0.0
                }

                override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}

                override fun afterTextChanged(s: Editable) {

                    when {
                        s.isEmpty() -> aprobadasT6 = 0
                        s.isNotEmpty() -> aprobadasT6 = text.toString().toInt()
                    }
                    with(
                        resolver.calculateTask(
                            nTarea = 6,
                            aprobadas = aprobadasT6
                        ), {
                            resolver.totalPdTarea6 = this
                            tvSubTotalT6.text = formatSubTotalPoints(tarea, this)
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
                Utils.calcularDesviacion2(MEDIA, DESVIACION, pdCorregido, false)

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

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if (item.itemId == android.R.id.home) {
            logInfo(R.string.ACTIVIDAD_CERRADA)
            finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }


}