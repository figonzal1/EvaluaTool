/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2021

 Last modified 02-05-21 0:38
 */
package cl.figonzal.evaluatool.evalua.evalua0.modulo1

import android.os.Build
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.MenuItem
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import cl.figonzal.evaluatool.R
import cl.figonzal.evaluatool.databinding.ActivityOrganizacionPerceptivaE0M1Binding
import cl.figonzal.evaluatool.dialogs.CorregidoDialogFragment
import cl.figonzal.evaluatool.interfaces.EvaluaInterface
import cl.figonzal.evaluatool.utilidades.Utils
import cl.figonzal.evaluatool.utilidades.configActionBar
import cl.figonzal.evaluatool.utilidades.logInfo
import cl.figonzal.evaluatool.utilidades.setSubTotalPoints
import com.google.android.material.textfield.TextInputEditText
import java.util.*
import kotlin.math.floor

class OrganizacionPerceptivaE0M1 : AppCompatActivity(), EvaluaInterface {

    companion object {
        private const val DESVIACION = 3.98
        private const val MEDIA = 19.39
    }

    private lateinit var binding: ActivityOrganizacionPerceptivaE0M1Binding
    private val perc = listOf(
            22 to 99,
            21 to 75,
            20 to 60,
            19 to 50,
            18 to 40,
            17 to 30,
            16 to 25,
            15 to 20,
            14 to 15,
            13 to 10,
            12 to 7,
            10 to 5,
            8 to 3,
            7 to 1,
            4 to 1,
            2 to 1
    )

    //TAREA 1
    private lateinit var etReprobadasT1: TextInputEditText
    private lateinit var tvSubTotalT1: TextView
    private var reprobadasT1 = 0
    private var subtotalPdT1 = 0.0

    //TAREA 2
    private lateinit var etReprobadasT2: TextInputEditText
    private lateinit var tvSubTotalT2: TextView
    private var reprobadasT2 = 0
    private var subtotalPdT2 = 0.0

    //TAREA 3
    private lateinit var etReprobadasT3: TextInputEditText
    private lateinit var tvSubTotalT3: TextView
    private var reprobadasT3 = 0
    private var subtotalPdT3 = 0.0

    //TAREA 4
    private lateinit var etReprobadasT4: TextInputEditText
    private lateinit var tvSubTotalT4: TextView
    private var reprobadasT4 = 0
    private var subtotalPdT4 = 0.0

    //Tetview para total
    private lateinit var tvPdTotal: TextView
    private lateinit var tvPdCorregido: TextView
    private lateinit var tvPercentil: TextView
    private lateinit var tvNivel: TextView
    private lateinit var tvDesviacionCalculada: TextView
    private lateinit var progressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOrganizacionPerceptivaE0M1Binding.inflate(layoutInflater)
        setContentView(binding.root)

        configActionBar(R.string.TOOLBAR_ORG_PERCEPTIVA, binding.include.toolbar)

        initResources()
    }

    private fun initResources() {

        with(binding, {
            //Promedio y desviacion
            cardViewConstantes.tvMediaValue.text = MEDIA.toString()
            cardViewConstantes.tvDesviacionValue.text = DESVIACION.toString()

            //TAREA 1
            tvSubTotalT1 = tvPdSubtotalT1
            this@OrganizacionPerceptivaE0M1.etReprobadasT1 = etReprobadasT1

            //TAREA 2
            tvSubTotalT2 = tvPdSubtotalT2
            this@OrganizacionPerceptivaE0M1.etReprobadasT2 = etReprobadasT2

            //TAREA 3
            tvSubTotalT3 = tvPdSubtotalT3
            this@OrganizacionPerceptivaE0M1.etReprobadasT3 = etReprobadasT3

            //TAREA 4
            tvSubTotalT4 = tvPdSubtotalT4
            this@OrganizacionPerceptivaE0M1.etReprobadasT4 = etReprobadasT4

            //TOTAL
            this@OrganizacionPerceptivaE0M1.tvPdTotal = tvPdTotalValue
            tvPdCorregido = cardViewFinal.tvPdTotalCorregidoValue
            tvPercentil = cardViewFinal.tvPercentilValue
            tvNivel = cardViewFinal.tvNivelObtenidoValue
            tvDesviacionCalculada = cardViewFinal.tvDesviacionCalculadaValue

            progressBar = cardViewFinal.progressBar
            progressBar.max = perc[0].second

            cardViewFinal.ivHelpPdCorregido.setOnClickListener {

                logInfo(R.string.DIALOGO_AYUDA_MSG_ABIERTO)

                val dialogo = CorregidoDialogFragment()
                dialogo.isCancelable = false
                dialogo.show(supportFragmentManager, getString(R.string.DIALOGO_AYUDA))
            }
            Utils.configurarTextoBaremo(supportFragmentManager, tablaBaremo.tvBaremo, perc, getString(R.string.TOOLBAR_ORG_PERCEPTIVA))
        }).run {
            textWatcherTarea1()
            textWatcherTarea2()
            textWatcherTarea3()
            textWatcherTarea4()
        }
    }

    private fun textWatcherTarea1() {

        with(etReprobadasT1) {
            addTextChangedListener(object : TextWatcher {

                override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
                    subtotalPdT1 = 0.0
                }

                override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}

                override fun afterTextChanged(s: Editable) {

                    when {
                        s.isEmpty() -> reprobadasT1 = 0
                        s.isNotEmpty() -> reprobadasT1 = text.toString().toInt()
                    }
                    subtotalPdT1 = calculateTask(1, tvSubTotalT1, "Caballo: ", null, null, reprobadasT1)
                    calculateResult()
                }
            })
        }
    }

    private fun textWatcherTarea2() {

        with(etReprobadasT2) {
            addTextChangedListener(object : TextWatcher {

                override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
                    subtotalPdT2 = 0.0
                }

                override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}

                override fun afterTextChanged(s: Editable) {

                    when {
                        s.isEmpty() -> reprobadasT2 = 0
                        s.isNotEmpty() -> reprobadasT2 = text.toString().toInt()
                    }
                    subtotalPdT2 = calculateTask(2, tvSubTotalT2, "Dinosaurio: ", null, null, reprobadasT2)
                    calculateResult()
                }
            })
        }
    }

    private fun textWatcherTarea3() {

        with(etReprobadasT3) {
            addTextChangedListener(object : TextWatcher {

                override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
                    subtotalPdT3 = 0.0
                }

                override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}

                override fun afterTextChanged(s: Editable) {

                    when {
                        s.isEmpty() -> reprobadasT3 = 0
                        s.isNotEmpty() -> reprobadasT3 = text.toString().toInt()
                    }
                    subtotalPdT3 = calculateTask(3, tvSubTotalT3, "Uvas: ", null, null, reprobadasT3)
                    calculateResult()
                }
            })
        }
    }

    private fun textWatcherTarea4() {

        with(etReprobadasT4) {
            addTextChangedListener(object : TextWatcher {

                override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
                    subtotalPdT4 = 0.0
                }

                override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}

                override fun afterTextChanged(s: Editable) {

                    when {
                        s.isEmpty() -> reprobadasT4 = 0
                        s.isNotEmpty() -> reprobadasT4 = text.toString().toInt()
                    }
                    subtotalPdT4 = calculateTask(4, tvSubTotalT4, "Plátanos: ", null, null, reprobadasT4)
                    calculateResult()
                }
            })
        }
    }

    override fun calculateTask(nTarea: Int?, tvSubTotal: TextView, tarea: String, aprobadas: Int?, omitidas: Int?, reprobadas: Int?): Double {
        val total = floor(when (nTarea) {
            1 -> 3 - reprobadas!!.toDouble()
            2 -> 5 - reprobadas!! * 1.5
            3 -> 6 - (reprobadas!! * 2).toDouble()
            4 -> 8 - (reprobadas!! * 2).toDouble()
            else -> 0.0
        })
        tvSubTotal.text = setSubTotalPoints(tarea, total)
        return total
    }

    override fun calculateResult() {

        with(subtotalPdT1 + subtotalPdT2 + subtotalPdT3 + subtotalPdT4, {
            tvPdTotal.text = String.format(Locale.US, "%s pts", this)

            //Correct total pd based on Baremo Table
            val pdCorregido = correctPD(perc, this)
            tvPdCorregido.text = String.format("%s pts", pdCorregido)

            //Calculate desviation
            tvDesviacionCalculada.text = Utils.calcularDesviacion(MEDIA, DESVIACION, pdCorregido, false).toString()

            //Calculate Percentile
            with(calculatePercentile(pdCorregido), {
                tvPercentil.text = this.toString()

                when {
                    Build.VERSION.SDK_INT >= Build.VERSION_CODES.N -> progressBar.setProgress(this, true)
                    else -> progressBar.progress = this
                }

                //Calculate student level
                tvNivel.text = Utils.calcularNivel(this)
            })
        })
    }

    override fun calculatePercentile(pdTotal: Double): Int {

        //Limite superior
        when {
            pdTotal > perc[0].first -> return perc[0].second
            pdTotal < perc[perc.size - 1].first -> return perc[perc.size - 1].second
            else -> perc.forEach { item ->
                if (pdTotal.toInt() == item.first) return item.second
            }
        }
        //Percentil no encontrado
        logInfo(R.string.TAG_PERCENTIL_CALCULADO, R.string.PERCENTIL_NULO)
        return -1
    }

    override fun correctPD(perc: List<Pair<Int, Int>>, pdActual: Double): Double {
        //Verificar si pd_actual esta en la lista
        when {
            pdActual < 0 -> return 0.0
            pdActual > perc[0].first -> return perc[0].first.toDouble()
            pdActual < perc[perc.size - 1].first -> return perc[perc.size - 1].first.toDouble()
            else -> perc.forEach { item ->
                when {
                    pdActual == item.first.toDouble() -> return item.first.toDouble()
                    pdActual - 1 == item.first.toDouble() -> return item.first.toDouble()
                }
            }
        }
        logInfo(R.string.TAG_PD_CORREGIDO, R.string.PD_NULO)
        return (-1).toDouble()
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