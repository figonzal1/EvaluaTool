/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2021

 Last modified 21-02-21 19:46
 */
package cl.figonzal.evaluatool.evalua.evalua0.modulo3

import android.os.Build
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.MenuItem
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import cl.figonzal.evaluatool.R
import cl.figonzal.evaluatool.databinding.ActivityHabilidadesFonologicasE0M3Binding
import cl.figonzal.evaluatool.dialogs.CorregidoDialogFragment
import cl.figonzal.evaluatool.interfaces.EvaluaInterface
import cl.figonzal.evaluatool.utilidades.EvaluaUtils
import com.google.android.material.textfield.TextInputEditText
import timber.log.Timber
import java.util.*
import kotlin.math.floor

class HabilidadesFonologicasE0M3 : AppCompatActivity(), EvaluaInterface {

    companion object {
        private const val DESVIACION = 10.07
        private const val MEDIA = 44.73
    }

    private lateinit var binding: ActivityHabilidadesFonologicasE0M3Binding

    //PD,PC CHILE
    private val perc = arrayOf(
            arrayOf(62, 99),
            arrayOf(61, 99),
            arrayOf(60, 99),
            arrayOf(59, 95),
            arrayOf(58, 95),
            arrayOf(57, 95),
            arrayOf(56, 90),
            arrayOf(55, 90),
            arrayOf(54, 80),
            arrayOf(53, 80),
            arrayOf(52, 70),
            arrayOf(51, 70),
            arrayOf(50, 65),
            arrayOf(49, 65),
            arrayOf(48, 60),
            arrayOf(47, 60),
            arrayOf(46, 55),
            arrayOf(45, 55),
            arrayOf(44, 50),
            arrayOf(43, 50),
            arrayOf(42, 40),
            arrayOf(41, 40),
            arrayOf(40, 30),
            arrayOf(39, 30),
            arrayOf(38, 20),
            arrayOf(37, 20),
            arrayOf(36, 20),
            arrayOf(35, 15),
            arrayOf(34, 15),
            arrayOf(33, 10),
            arrayOf(32, 10),
            arrayOf(31, 10),
            arrayOf(30, 7),
            arrayOf(29, 7),
            arrayOf(28, 7),
            arrayOf(27, 7),
            arrayOf(26, 7),
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
            arrayOf(6, 1),
            arrayOf(5, 1)
    )

    //TAREA 1
    private lateinit var etAprobadasT1: TextInputEditText
    private lateinit var tvSubTotalT1: TextView
    private var aprobadasT1 = 0
    private var subtotalPdT1 = 0.0

    //TAREA 2
    private lateinit var etAprobadasT2: TextInputEditText
    private lateinit var tvSubTotalT2: TextView
    private var aprobadasT2 = 0
    private var subtotalPdT2 = 0.0

    //TAREA 3
    private lateinit var etAprobadasT3: TextInputEditText
    private lateinit var tvSubTotalT3: TextView
    private var aprobadasT3 = 0
    private var subtotalPdT3 = 0.0

    //TAREA 4
    private lateinit var etAprobadasT4: TextInputEditText
    private lateinit var tvSubTotalT4: TextView
    private var aprobadasT4 = 0
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
        binding = ActivityHabilidadesFonologicasE0M3Binding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.include.toolbar)

        val actionBar = supportActionBar!!
        actionBar.setDisplayHomeAsUpEnabled(true)
        actionBar.setHomeAsUpIndicator(R.drawable.ic_arrow_back_white_24dp)
        actionBar.title = getString(R.string.TOOLBAR_HABILIDADES_FONOLOGICAS)

        instanciarRecursosInterfaz()
        textWatcherTarea1()
        textWatcherTarea2()
        textWatcherTarea3()
        textWatcherTarea4()
    }

    /**
     * Funcion encargada de instanciar los recursos de la interfaz gráfica
     */
    private fun instanciarRecursosInterfaz() {

        //Promedio y desviacion
        val tvMedia = binding.cardViewConstantes.tvMediaValue
        val tvDesviacion = binding.cardViewConstantes.tvDesviacionValue
        tvMedia.text = MEDIA.toString()
        tvDesviacion.text = DESVIACION.toString()

        //TAREA 1
        tvSubTotalT1 = binding.tvPdSubtotalT1
        etAprobadasT1 = binding.etAprobadasT1

        //TAREA 2
        tvSubTotalT2 = binding.tvPdSubtotalT2
        etAprobadasT2 = binding.etAprobadasT2

        //TAREA 3
        tvSubTotalT3 = binding.tvPdSubtotalT3
        etAprobadasT3 = binding.etAprobadasT3

        //TAREA 4
        tvSubTotalT4 = binding.tvPdSubtotalT4
        etAprobadasT4 = binding.etAprobadasT4

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
        EvaluaUtils.configurarTextoBaremo(supportFragmentManager, tvBaremo, perc, getString(R.string.TOOLBAR_HABILIDADES_FONOLOGICAS))

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
                subtotalPdT1 = calcularTarea(null, tvSubTotalT1, "Tarea 1: ", aprobadasT1, null, null)
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
                subtotalPdT2 = calcularTarea(null, tvSubTotalT2, "Tarea 2: ", aprobadasT2, null, null)
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
                subtotalPdT3 = calcularTarea(null, tvSubTotalT3, "Tarea 3: ", aprobadasT3, null, null)
                calcularResultado()
            }
        })
    }

    /**
     * Funcion encargada de la logica de los TextWatcher de la tarea 1
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
                subtotalPdT4 = calcularTarea(null, tvSubTotalT4, "Tarea 4: ", aprobadasT4, null, null)
                calcularResultado()
            }
        })
    }

    override fun calcularTarea(n_tarea: Int?, tv_sub_total: TextView, tarea: String, aprobadas: Int?, omitidas: Int?, reprobadas: Int?): Double {

        var total = aprobadas!!.toDouble()
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