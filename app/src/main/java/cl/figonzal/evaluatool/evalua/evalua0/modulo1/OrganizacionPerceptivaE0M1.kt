/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2021

 Last modified 21-02-21 19:46
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
import cl.figonzal.evaluatool.utilidades.EvaluaUtils
import com.google.android.material.textfield.TextInputEditText
import timber.log.Timber
import java.util.*
import kotlin.math.floor

class OrganizacionPerceptivaE0M1 : AppCompatActivity(), EvaluaInterface {

    companion object {
        private const val DESVIACION = 3.98
        private const val MEDIA = 19.39
    }

    private lateinit var binding: ActivityOrganizacionPerceptivaE0M1Binding
    private val perc = arrayOf(
            arrayOf(22, 99),
            arrayOf(21, 75),
            arrayOf(20, 60),
            arrayOf(19, 50),
            arrayOf(18, 40),
            arrayOf(17, 30),
            arrayOf(16, 25),
            arrayOf(15, 20),
            arrayOf(14, 15),
            arrayOf(13, 10),
            arrayOf(12, 7),
            arrayOf(10, 5),
            arrayOf(8, 3),
            arrayOf(7, 1),
            arrayOf(4, 1),
            arrayOf(2, 1)
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

        setSupportActionBar(binding.include.toolbar)

        val actionBar = supportActionBar!!
        actionBar.setDisplayHomeAsUpEnabled(true)
        actionBar.setHomeAsUpIndicator(R.drawable.ic_arrow_back_white_24dp)
        actionBar.title = getString(R.string.TOOLBAR_ORG_PERCEPTIVA)

        instanciarRecursosInterfaz()
        textWatcherTarea1()
        textWatcherTarea2()
        textWatcherTarea3()
        textWatcherTarea4()
    }

    private fun instanciarRecursosInterfaz() {
        //Promedio y desviacion
        val tvMedia = binding.cardViewConstantes.tvMediaValue
        val tvDesviacion = binding.cardViewConstantes.tvDesviacionValue
        tvMedia.text = MEDIA.toString()
        tvDesviacion.text = DESVIACION.toString()

        //TAREA 1
        tvSubTotalT1 = binding.tvPdSubtotalT1
        etReprobadasT1 = binding.etReprobadasT1

        //TAREA 2
        tvSubTotalT2 = binding.tvPdSubtotalT2
        etReprobadasT2 = binding.etReprobadasT2

        //TAREA 3
        tvSubTotalT3 = binding.tvPdSubtotalT3
        etReprobadasT3 = binding.etReprobadasT3

        //TAREA 4
        tvSubTotalT4 = binding.tvPdSubtotalT4
        etReprobadasT4 = binding.etReprobadasT4

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
        EvaluaUtils.configurarTextoBaremo(supportFragmentManager, tvBaremo, perc, getString(R.string.TOOLBAR_ORG_PERCEPTIVA))

    }

    /**
     * Funcion encargada de la logica de los TextWatcher de la tarea 1
     */
    private fun textWatcherTarea1() {

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
                subtotalPdT1 = calcularTarea(1, tvSubTotalT1, "Caballo: ", null, null, reprobadasT1)
                calcularResultado()
            }
        })
    }

    /**
     * Funcion encargada de la logica de los TextWatcher de la tarea 2
     */
    private fun textWatcherTarea2() {

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
                subtotalPdT2 = calcularTarea(2, tvSubTotalT2, "Dinosaurio: ", null, null, reprobadasT2)
                calcularResultado()
            }
        })
    }

    /**
     * Funcion encargada de la logica de los TextWatcher de la tarea 3
     */
    private fun textWatcherTarea3() {

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
                subtotalPdT3 = calcularTarea(3, tvSubTotalT3, "Uvas: ", null, null, reprobadasT3)
                calcularResultado()
            }
        })
    }

    /**
     * Funcion encargada de la logica de los TextWatcher de la tarea 3
     */
    private fun textWatcherTarea4() {

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
                subtotalPdT4 = calcularTarea(4, tvSubTotalT4, "Plátanos: ", null, null, reprobadasT4)
                calcularResultado()
            }
        })
    }

    override fun calcularTarea(n_tarea: Int?, tv_sub_total: TextView, tarea: String, aprobadas: Int?, omitidas: Int?, reprobadas: Int?): Double {
        var total = 0.0

        when (n_tarea) {
            1 -> {
                total = 3 - reprobadas!!.toDouble()
            }
            2 -> {
                total = 5 - reprobadas!! * 1.5
            }
            3 -> {
                total = 6 - (reprobadas!! * 2).toDouble()
            }
            4 -> {
                total = 8 - (reprobadas!! * 2).toDouble()
            }
        }
        total = floor(total)

        if (total < 0) {
            total = 0.0
        }
        tv_sub_total.text = String.format(Locale.US, "%s%s pts", tarea, total)
        return total
    }

    override fun calcularResultado() {

        val totalPd: Double = subtotalPdT1 + subtotalPdT2 + subtotalPdT3 + subtotalPdT4

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