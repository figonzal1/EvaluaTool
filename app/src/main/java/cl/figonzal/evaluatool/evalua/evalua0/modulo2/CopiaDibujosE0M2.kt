/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2021

 Last modified 17-04-21 22:25
 */
package cl.figonzal.evaluatool.evalua.evalua0.modulo2

import android.os.Build
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.MenuItem
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import cl.figonzal.evaluatool.R
import cl.figonzal.evaluatool.databinding.ActivityCopiaDibujosE0M2Binding
import cl.figonzal.evaluatool.dialogs.CorregidoDialogFragment
import cl.figonzal.evaluatool.interfaces.EvaluaInterface
import cl.figonzal.evaluatool.utilidades.Utils
import com.google.android.material.textfield.TextInputEditText
import timber.log.Timber
import java.util.*
import kotlin.math.floor

class CopiaDibujosE0M2 : AppCompatActivity(), EvaluaInterface {

    companion object {
        private const val DESVIACION = 12.65
        private const val MEDIA = 42.22
    }

    private lateinit var binding: ActivityCopiaDibujosE0M2Binding
    private val perc = arrayOf(
            arrayOf(65, 99),
            arrayOf(64, 99),
            arrayOf(63, 97),
            arrayOf(62, 97),
            arrayOf(61, 95),
            arrayOf(60, 95),
            arrayOf(59, 90),
            arrayOf(58, 90),
            arrayOf(57, 90),
            arrayOf(56, 85),
            arrayOf(55, 85),
            arrayOf(54, 85),
            arrayOf(53, 75),
            arrayOf(52, 75),
            arrayOf(51, 75),
            arrayOf(50, 70),
            arrayOf(49, 70),
            arrayOf(48, 70),
            arrayOf(47, 65),
            arrayOf(46, 65),
            arrayOf(45, 65),
            arrayOf(44, 55),
            arrayOf(43, 55),
            arrayOf(42, 55),
            arrayOf(41, 50),
            arrayOf(40, 50),
            arrayOf(39, 50),
            arrayOf(38, 40),
            arrayOf(37, 40),
            arrayOf(36, 40),
            arrayOf(35, 30),
            arrayOf(34, 30),
            arrayOf(33, 30),
            arrayOf(32, 20),
            arrayOf(31, 20),
            arrayOf(30, 20),
            arrayOf(29, 15),
            arrayOf(28, 15),
            arrayOf(27, 15),
            arrayOf(26, 12),
            arrayOf(25, 12),
            arrayOf(24, 12),
            arrayOf(23, 10),
            arrayOf(22, 10),
            arrayOf(21, 10),
            arrayOf(20, 9),
            arrayOf(19, 9),
            arrayOf(18, 9),
            arrayOf(17, 6),
            arrayOf(16, 6),
            arrayOf(15, 6),
            arrayOf(14, 3),
            arrayOf(13, 3),
            arrayOf(12, 3),
            arrayOf(11, 3),
            arrayOf(10, 1),
            arrayOf(9, 1),
            arrayOf(8, 1),
            arrayOf(7, 1),
            arrayOf(6, 1),
            arrayOf(5, 1),
            arrayOf(4, 1),
            arrayOf(3, 1),
            arrayOf(2, 1),
            arrayOf(1, 1))

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

    //Tetview para total
    private lateinit var tvPdTotal: TextView
    private lateinit var tvPdCorregido: TextView
    private lateinit var tvPercentil: TextView
    private lateinit var tvNivel: TextView
    private lateinit var tvDesviacionCalculada: TextView

    private lateinit var progressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCopiaDibujosE0M2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.include.toolbar)

        val actionBar = supportActionBar!!
        actionBar.setDisplayHomeAsUpEnabled(true)
        actionBar.setHomeAsUpIndicator(R.drawable.ic_arrow_back_white_24dp)
        actionBar.title = getString(R.string.TOOLBAR_COPIA_DIBUJOS)

        instanciarRecursosInterfaz()
        textWatcherTarea1()
        textWatcherTarea2()
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
        etReprobadasT1 = binding.etReprobadasT1

        //TAREA 2
        tvSubTotalT2 = binding.tvPdSubtotalT2
        etReprobadasT2 = binding.etReprobadasT2

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
        Utils.configurarTextoBaremo(supportFragmentManager, tvBaremo, perc, getString(R.string.TOOLBAR_COPIA_DIBUJOS))

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
                    reprobadasT1 = Objects.requireNonNull(etReprobadasT1.text).toString().toInt()
                }
                subtotalPdT1 = calcularTarea(1, tvSubTotalT1, "Tarea 1: ", null, null, reprobadasT1)
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
                subtotalPdT2 = calcularTarea(2, tvSubTotalT2, "Tarea 2: ", null, null, reprobadasT2)
                calcularResultado()
            }
        })
    }

    override fun calcularTarea(n_tarea: Int?, tv_sub_total: TextView, tarea: String, aprobadas: Int?, omitidas: Int?, reprobadas: Int?): Double {

        var total = 0.0

        if (n_tarea == 1) {
            total = floor(17 - reprobadas!!.toDouble())
        } else if (n_tarea == 2) {
            total = floor(48 - reprobadas!!.toDouble())
        }
        if (total < 0) {
            total = 0.0
        }
        tv_sub_total.text = String.format(Locale.US, "%s%s pts", tarea, total)
        return total
    }

    override fun calcularResultado() {

        val totalPd: Double = subtotalPdT1 + subtotalPdT2
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

        val nivel = Utils.calcularNivel(percentil)
        tvNivel.text = nivel

        val desviacion = Utils.calcularDesviacion(MEDIA, DESVIACION, pdCorregido, false)
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
                    if (pd_total == item[0].toDouble()) {
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