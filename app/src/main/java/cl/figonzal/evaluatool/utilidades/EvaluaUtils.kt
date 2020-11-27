/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2020

 Last modified 27-11-20 18:50
 */
package cl.figonzal.evaluatool.utilidades

import android.text.Spannable
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.view.View
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentManager
import cl.figonzal.evaluatool.dialogs.BaremoDialogFragment
import timber.log.Timber
import kotlin.math.roundToInt

object EvaluaUtils {
    /**
     * Funcion encargada de calcular la desviación del PD de un alumno (Metodo con implementacion
     * generica)
     *
     * @param pd_total Puntaje Directo del alumno
     * @return Desviación calculada
     */
    @JvmStatic
    fun calcularDesviacion(MEDIA: Double, DESVIACION: Double, pd_total: Double, reverse: Boolean): Double {
        return if (!reverse) {
            ((pd_total - MEDIA) / DESVIACION * 100.0).roundToInt() / 100.0
        } else {
            ((MEDIA - pd_total) / DESVIACION * 100.0).roundToInt() / 100.0
        }
    }

    /**
     * Funcion encargada de calcular el nivel del alumno según el percentil obtenido (Metodo con
     * implementacion generica)
     *
     * @param percentil Percentil de posicion del alumno
     * @return Nivel asociado al percentil
     */
    @JvmStatic
    fun calcularNivel(percentil: Int): String? {

        when (percentil) {
            in 80..99 -> {
                return "ALTO"
            }
            in 60..79 -> {
                return "MEDIO-ALTO"
            }
            in 40..59 -> {
                return "MEDIO"
            }
            in 20..39 -> {
                return "MEDIO-BAJO"
            }
            in 0..19 -> {
                return "BAJO"
            }
            //Percentil no encontrado
            else -> {
                Timber.i("NIVEL_CALCULADO: nulo")
                return null
            }
        }
    }

    fun configurarTextoBaremo(fragmentManager: FragmentManager, tvBaremo: TextView, perc: Array<Array<Int>>, itemName: String) {

        tvBaremo.movementMethod = LinkMovementMethod.getInstance()
        val spans: Spannable = tvBaremo.text as Spannable
        val clickSpan: ClickableSpan = object : ClickableSpan() {
            override fun onClick(widget: View) {
                val dialogFragment: DialogFragment = BaremoDialogFragment(perc, itemName)
                dialogFragment.show(fragmentManager, "Dialogo baremo")
            }
        }
        spans.setSpan(clickSpan, 0, spans.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
    }
}