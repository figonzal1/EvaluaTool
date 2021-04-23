/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2021

 Last modified 21-04-21 14:42
 */
package cl.figonzal.evaluatool.utilidades

import android.text.Spannable
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.view.View
import android.widget.TextView
import androidx.annotation.StringRes
import androidx.fragment.app.FragmentManager
import cl.figonzal.evaluatool.ApplicationController
import cl.figonzal.evaluatool.R
import cl.figonzal.evaluatool.dialogs.BaremoDialogFragment
import timber.log.Timber
import java.util.*
import kotlin.math.roundToInt

object Utils {

    /**
     * Used to simplify the call of string resources
     * @param stringRes The id for string resource
     * @param formatArgs Some arguments "optional"
     *
     * @return String resource
     */
    fun get(@StringRes stringRes: Int, vararg formatArgs: Any = emptyArray()): String {
        return ApplicationController.instance.getString(stringRes, *formatArgs)
    }

    /**
     * Function in charge of calculating the deviation of a student's PD (Method with generic implementation)
     *
     * @param MEAN
     * @param DESVIATION
     * @param reverse Used to change the order calculation
     * @param pdTotal Directo score
     *
     * @return Double Desviation
     */
    fun calcularDesviacion(MEAN: Double, DESVIATION: Double, pdTotal: Double, reverse: Boolean): Double {
        return when {
            !reverse -> ((pdTotal - MEAN) / DESVIATION * 100.0).roundToInt() / 100.0
            else -> ((MEAN - pdTotal) / DESVIATION * 100.0).roundToInt() / 100.0
        }
    }

    /**
     * Function in charge of calculating the level of the student according to the percentile obtained (Method with generic implementation)
     *
     * @param percentile Percentile of student position in baremo
     * @return String Level asigned to student
     */
    fun calcularNivel(percentile: Int): String? {

        return when (percentile) {

            in 80..99 -> get(R.string.NIVEL_ALTO)
            in 60..79 -> get(R.string.NIVEL_MEDIO_ALTO)
            in 40..59 -> get(R.string.NIVEL_MEDIO)
            in 20..39 -> get(R.string.NIVEL_MEDIO_BAJO)
            in 0..19 -> get(R.string.NIVEL_BAJO)
            //Percentil no encontrado
            else -> {
                Timber.i("NIVEL_CALCULADO: nulo")
                null
            }
        }
    }

    /**
     * Function that allows to put the text in clickable mode
     *
     * @param fragmentManager
     * @param tvBaremo TextView for baremo score
     * @param perc Baremo percentile table score
     * @param itemName ItemName of actual baremo in perc
     *
     * @return Unit
     *
     */
    fun configurarTextoBaremo(fragmentManager: FragmentManager, tvBaremo: TextView, perc: List<Pair<Int, Int>>, itemName: String) {

        tvBaremo.movementMethod = LinkMovementMethod.getInstance()
        val spans: Spannable = tvBaremo.text as Spannable

        val clickSpan: ClickableSpan = object : ClickableSpan() {
            override fun onClick(widget: View) {
                BaremoDialogFragment(perc, itemName).show(fragmentManager, "Dialogo baremo")
            }
        }
        spans.setSpan(clickSpan, 0, spans.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
    }

    /**
     * Function that generate a random number with 30% of success
     *
     * @return Boolean with the result
     */
    fun generateRandomNumber(): Boolean = Random().nextInt(10) % 3 == 0
}