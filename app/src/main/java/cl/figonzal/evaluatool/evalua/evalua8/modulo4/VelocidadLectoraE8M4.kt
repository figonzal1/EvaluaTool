/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2021

 Last modified 17-05-21 02:31
 */

package cl.figonzal.evaluatool.evalua.evalua8.modulo4

import android.os.Bundle
import android.os.PersistableBundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import cl.figonzal.evaluatool.R
import cl.figonzal.evaluatool.baremosTables.velocidadLectoraE8M4Baremo
import cl.figonzal.evaluatool.databinding.ActivityVelocidadLectoraE8M4Binding
import cl.figonzal.evaluatool.interfaces.EvaluaInterface
import cl.figonzal.evaluatool.utilidades.*
import com.google.android.material.textfield.TextInputEditText
import kotlin.math.floor

class VelocidadLectoraE8M4 : AppCompatActivity(), EvaluaInterface {

    //TODO: No entiendo la comprension aqui
    companion object {
        private const val DESVIACION = 73.19
        private const val MEDIA = 171.80
    }


    private lateinit var binding: ActivityVelocidadLectoraE8M4Binding

    private val perc = velocidadLectoraE8M4Baremo()

    //TAREA 1
    private lateinit var etAprobadasT1: TextInputEditText
    private lateinit var etOmitidasT1: TextInputEditText
    private lateinit var etReprobadasT1: TextInputEditText
    private var aprobadasT1 = 0
    private var omitidasT1 = 0
    private var reprobadasT1 = 0
    private var subtotalPdT1 = 0.0

    //SUBTOTALES
    private lateinit var tvSubTotalT1: TextView
    private var totalPdT1 = 0.0

    //TOTALES
    private lateinit var tvPdTotal: TextView
    private lateinit var tvPdCorregido: TextView
    private lateinit var tvNivelComprension: TextView
    private lateinit var tvPercentil: TextView
    private lateinit var tvNivel: TextView
    private lateinit var tvDesviacionCalculada: TextView
    private lateinit var progressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        binding = ActivityVelocidadLectoraE8M4Binding.inflate(layoutInflater)
        setContentView(binding.root)

        configActionBar(R.string.TOOLBAR_VELOCIDAD_LECTORA, binding.include.toolbar)

        initResources()
    }

    private fun initResources() {

        with(binding, {
            cardViewConstantes.tvMediaValue.text = MEDIA.toString()
            cardViewConstantes.tvDesviacionValue.text = DESVIACION.toString()

            //TAREA 1
            this@VelocidadLectoraE8M4.etAprobadasT1 = etAprobadasT1
            this@VelocidadLectoraE8M4.etOmitidasT1 = etOmitidasT1
            this@VelocidadLectoraE8M4.etReprobadasT1 = etReprobadasT1

            //SUBTOTALES
            tvSubTotalT1 = tvPdSubtotalT1

            //TOTALES
            this@VelocidadLectoraE8M4.tvPdTotal = tvPdTotalValue
            tvPdCorregido = tvPdTotalCorregidoValue
            this@VelocidadLectoraE8M4.tvNivelComprension = tvNivelComprensionValue
            this@VelocidadLectoraE8M4.tvPercentil = tvPercentilValue
            tvNivel = tvNivelObtenidoValue
            this@VelocidadLectoraE8M4.tvDesviacionCalculada = tvDesviacionCalculadaValue

            this@VelocidadLectoraE8M4.progressBar = progressBar
            progressBar.max = perc.first()[1] as Int

            ivHelpPdCorregido.setOnClickListener {

                logInfo(R.string.DIALOGO_AYUDA_MSG_ABIERTO)
                showHelperDialog(supportFragmentManager)
            }

            Utils.configurarTextoBaremo(
                supportFragmentManager,
                tablaBaremo.tvBaremo,
                perc,
                getString(R.string.TOOLBAR_VELOCIDAD)
            )
        }).also {
            textWatcherTarea1()
        }
    }

    private fun textWatcherTarea1() {

        with(etAprobadasT1) {
            addTextChangedListener(object : TextWatcher {

                override fun beforeTextChanged(
                    s: CharSequence,
                    start: Int,
                    count: Int,
                    after: Int
                ) {
                    subtotalPdT1 = 0.0
                }

                override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}

                override fun afterTextChanged(s: Editable) {

                    when {
                        s.isEmpty() -> aprobadasT1 = 0
                        s.isNotEmpty() -> aprobadasT1 = text.toString().toInt()
                    }
                    subtotalPdT1 = calculateTask(
                        0,
                        tvSubTotalT1,
                        context.getString(R.string.TAREA_1),
                        aprobadasT1,
                        omitidasT1,
                        reprobadasT1
                    )
                    calculateResult()
                }
            })
        }

        with(etOmitidasT1) {
            addTextChangedListener(object : TextWatcher {

                override fun beforeTextChanged(
                    s: CharSequence,
                    start: Int,
                    count: Int,
                    after: Int
                ) {
                    subtotalPdT1 = 0.0
                }

                override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}

                override fun afterTextChanged(s: Editable) {

                    when {
                        s.isEmpty() -> omitidasT1 = 0
                        s.isNotEmpty() -> omitidasT1 = text.toString().toInt()
                    }
                    subtotalPdT1 = calculateTask(
                        0,
                        tvSubTotalT1,
                        context.getString(R.string.TAREA_1),
                        aprobadasT1,
                        omitidasT1,
                        reprobadasT1
                    )
                    calculateResult()
                }
            })
        }

        with(etReprobadasT1) {
            addTextChangedListener(object : TextWatcher {

                override fun beforeTextChanged(
                    s: CharSequence,
                    start: Int,
                    count: Int,
                    after: Int
                ) {
                    subtotalPdT1 = 0.0
                }

                override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}

                override fun afterTextChanged(s: Editable) {

                    when {
                        s.isEmpty() -> reprobadasT1 = 0
                        s.isNotEmpty() -> reprobadasT1 = text.toString().toInt()
                    }
                    subtotalPdT1 = calculateTask(
                        1,
                        tvSubTotalT1,
                        context.getString(R.string.TAREA_1),
                        aprobadasT1,
                        reprobadasT1,
                        reprobadasT1
                    )
                    calculateResult()
                }
            })
        }
    }

    override fun calculateTask(
        nTarea: Int,
        tvSubTotal: TextView,
        tarea: String,
        aprobadas: Int,
        omitidas: Int,
        reprobadas: Int
    ): Double {

        val total = floor((aprobadas - (reprobadas + omitidas)).toDouble())

        tvSubTotal.text = setSubTotalPoints(tarea, total)
        return aprobadas.toDouble()
    }

    override fun calculateResult() {

        with(totalPdT1, {
            tvPdTotal.text = String.format(getString(R.string.SEG_SIMPLE_FORMAT), this)

            val pdCorregido = correctPD(perc, this.toInt())
            tvPdCorregido.text = String.format(getString(R.string.SEG_SIMPLE_FORMAT), pdCorregido)

            tvDesviacionCalculada.text =
                Utils.calcularDesviacion(MEDIA, DESVIACION, pdCorregido, true).toString()

            tvNivelComprension.text = calcularComprension(pdCorregido)

            with(calculatePercentile(pdCorregido), {
                tvPercentil.text = this.toString()

                when {
                    android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N -> progressBar.setProgress(
                        this,
                        true
                    )
                    else -> progressBar.progress = this
                }
                tvNivel.text = Utils.calcularNivel(this)
            })
        })
    }

    private fun calcularComprension(pd_actual: Int): String {
        return when (pd_actual) {
            0 -> getString(R.string.COMPRENSION_MUY_BAJA)
            in 1..2 -> getString(R.string.COMPRENSION_BAJA)
            in 3..4 -> getString(R.string.COMPRENSION_MEDIA)
            in 5..6 -> getString(R.string.COMPRENSION_ALTA)
            in 7..15 -> getString(R.string.COMPRENSION_MUY_ALTA)

            else -> {
                logInfo(
                    R.string.TAG_COMPRENSION_CALCULADA,
                    R.string.COMPRENSION_NULA
                )
                ""
            }
        }
    }

    override fun calculatePercentile(pdTotal: Int): Int {
        when {
            pdTotal < perc.first()[0] as Int -> return perc.first()[1] as Int
            pdTotal > perc.last()[0] as Int -> return perc.last()[1] as Int
            else -> perc.forEach { item ->
                if (pdTotal <= item.first() as Int) return item[1] as Int
            }
        }
        //Percentil no encontrado
        logInfo(R.string.TAG_PERCENTIL_CALCULADO, R.string.PERCENTIL_NULO)
        return -1
    }

    override fun correctPD(perc: Array<Array<Any>>, pdActual: Int): Int {
        when {
            pdActual < perc.first()[0] as Int -> return perc.first()[0] as Int
            pdActual > perc.last()[0] as Int -> return perc.last()[0] as Int
            else -> perc.forEach { item ->
                if (pdActual <= item.first() as Int) return item.first() as Int
            }
        }
        logInfo(R.string.TAG_PD_CORREGIDO, R.string.PD_NULO)
        return -1
    }

}