/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2021

 Last modified 14-07-21 20:58
 */
package cl.figonzal.evaluatool.evalua.evalua7.modulo6

import android.os.Build
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.MenuItem
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import cl.figonzal.evaluatool.R
import cl.figonzal.evaluatool.databinding.ActivityResolucionProblemasE7M6Binding
import cl.figonzal.evaluatool.resolvers.evalua7.modulo6.ResolucionProblemasE7M6Resolver
import cl.figonzal.evaluatool.resolvers.evalua7.modulo6.ResolucionProblemasE7M6Resolver.Companion.DESVIACION
import cl.figonzal.evaluatool.resolvers.evalua7.modulo6.ResolucionProblemasE7M6Resolver.Companion.MEDIA
import cl.figonzal.evaluatool.utilidades.*
import com.google.android.material.progressindicator.LinearProgressIndicator
import com.google.android.material.textfield.TextInputEditText

class ResolucionProblemasE7M6 : AppCompatActivity() {

    private lateinit var binding: ActivityResolucionProblemasE7M6Binding

    //TAREA 1
    private lateinit var etAprobadasT11: TextInputEditText
    private var aprobadasT11 = 0
    private lateinit var etAprobadasT12: TextInputEditText
    private var aprobadasT12 = 0

    private var subTotalPdT11 = 0.0
    private var subTotalPdT12 = 0.0

    private lateinit var tvSubTotalT1: TextView

    //TOTAL
    private lateinit var tvPdTotal: TextView
    private lateinit var tvPdCorregido: TextView
    private lateinit var tvPercentil: TextView
    private lateinit var tvNivel: TextView
    private lateinit var tvDesviacionCalculada: TextView
    private lateinit var progressBar: LinearProgressIndicator

    private val resolver by lazy {
        ResolucionProblemasE7M6Resolver()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResolucionProblemasE7M6Binding.inflate(layoutInflater)
        setContentView(binding.root)

        configActionBar(
            R.string.TOOLBAR_RESOLUCION_PROBLEMAS,
            binding.includeToolbar.materialToolbar
        )

        initResources()
    }

    private fun initResources() {

        with(binding, {
            cardViewConstantes.tvMediaValue.text = MEDIA.toString()
            cardViewConstantes.tvDesviacionValue.text = DESVIACION.toString()

            //SUBTOTALES
            tvSubTotalT1 = tvPdSubtotalT1
            this@ResolucionProblemasE7M6.etAprobadasT11 = etAprobadasT1
            this@ResolucionProblemasE7M6.etAprobadasT12 = etAprobadasT2

            //TOTALES
            this@ResolucionProblemasE7M6.tvPdTotal = tvPdTotalValue
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
                getString(R.string.TOOLBAR_RESOLUCION_PROBLEMAS)
            )
        }).also {
            textWatcherTarea1(getString(R.string.TAREA_1))
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
                    subTotalPdT11 = calcularSubTarea(11, aprobadasT11)
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
                    subTotalPdT12 = calcularSubTarea(12, aprobadasT12)
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

    private fun calcularSubTarea(subTarea: Int, aprobadas: Int): Double {
        return when (subTarea) {
            11 -> aprobadas.toDouble()
            12 -> 4 * aprobadas.toDouble()
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
}