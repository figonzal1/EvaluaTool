/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2023

 Last modified 21-06-23 21:07
 */
package cl.figonzal.evaluatool.utils

import android.text.Spannable
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.view.View
import android.widget.TextView
import androidx.annotation.StringRes
import androidx.core.text.toSpannable
import androidx.fragment.app.FragmentManager
import cl.figonzal.evaluatool.ApplicationController
import cl.figonzal.evaluatool.R
import cl.figonzal.evaluatool.domain.resolvers.BaseResolver
import cl.figonzal.evaluatool.ui.dialogs.BaremoDialogFragment
import cl.figonzal.evaluatool.utils.EvaluaUtils.LEVEL.*
import timber.log.Timber
import kotlin.math.roundToInt

object EvaluaUtils {


    /**
     * Function in charge of calculating the deviation of a student's PD (Method with generic implementation)
     *
     * @param mean
     * @param deviation
     * @param reverse Used to change the order calculation
     * @param pdTotal Direct score
     *
     * @return String desviacion
     */
    fun calculateDeviation(
        mean: Double,
        deviation: Double,
        pdTotal: Int,
        reverse: Boolean = false
    ) = when {
        !reverse -> ((pdTotal - mean) / deviation * 100.0).roundToInt() / 100.0
        else -> ((mean - pdTotal) / deviation * 100.0).roundToInt() / 100.0
    }.toString()

    /**
     * Function in charge of calculating the percentile of a student's PD
     *
     * @param percentile Baremo percentile table score
     * @param pdTotal Directo score
     *
     * @return Int percentile
     */
    fun calculatePercentile(
        percentile: Array<DoubleArray>,
        pdTotal: Int,
        reverse: Boolean = false
    ) = when {

        //When baremo table is revered
        reverse -> {
            when {
                pdTotal < percentile.first()[0].toInt() -> percentile.first()[1].toInt()
                pdTotal > percentile.last()[0].toInt() -> percentile.last()[1].toInt()
                else -> {
                    var value = 0
                    percentile.filter { pdTotal == it.first().toInt() }
                        .forEach { item -> value = item[1].toInt() }
                    value
                }
            }
        }

        else -> {
            when {
                pdTotal > percentile.first()[0].toInt() -> percentile.first()[1].toInt()
                pdTotal < percentile.last()[0].toInt() -> percentile.last()[1].toInt()
                else -> {
                    var value = 0
                    percentile.filter { pdTotal == it.first().toInt() }
                        .forEach { item -> value = item[1].toInt() }
                    value
                }
            }
        }
    }

    /**
     * Function in charge of calculating the level of the student according to the percentile obtained (Method with generic implementation)
     *
     * @param percentile Percentile of student position in baremo
     * @return String Level asigned to student
     */
    fun calculateStudentLevel(percentile: Int) = when (percentile) {

        in 80..99 -> ALTO.name
        in 60..79 -> MEDIO_ALTO.name
        in 40..59 -> MEDIO.name
        in 20..39 -> MEDIO_BAJO.name
        in 0..19 -> BAJO.name
        //Percentil no encontrado
        else -> {
            Timber.i("NIVEL_CALCULADO: nulo")
            null
        }
    }

    @Suppress("UNUSED_PARAMETER")
    enum class LEVEL(name: String) {
        ALTO(get(R.string.NIVEL_ALTO)),
        MEDIO_ALTO(get(R.string.NIVEL_MEDIO_ALTO)),
        MEDIO(get(R.string.NIVEL_MEDIO)),
        MEDIO_BAJO(get(R.string.NIVEL_MEDIO_BAJO)),
        BAJO(get(R.string.NIVEL_BAJO))
    }

    /**
     * Only for test
     */
    fun calculateStudentLevelTest(percentile: Int) = when (percentile) {

        in 80..99 -> "ALTO"
        in 60..79 -> "MEDIO-ALTO"
        in 40..59 -> "MEDIO"
        in 20..39 -> "MEDIO-BAJO"
        in 0..19 -> "BAJO"
        //Percentil no encontrado
        else -> {
            Timber.i("NIVEL_CALCULADO: nulo")
            null
        }
    }

    /**
     * Function that allows to put the text in clickable mode
     *
     * @param fragmentManager
     * @param tvBaremo TextView for baremo score
     * @param resolver Item resolver
     * @param itemName ItemName of actual baremo in perc
     *
     * @return Unit
     *
     */
    fun configBaremoText(
        fragmentManager: FragmentManager,
        tvBaremo: TextView,
        resolver: BaseResolver,
        itemName: String
    ) {

        tvBaremo.movementMethod = LinkMovementMethod()
        val spans: Spannable = tvBaremo.text.toSpannable()

        val clickSpan: ClickableSpan = object : ClickableSpan() {
            override fun onClick(widget: View) {
                BaremoDialogFragment(resolver.percentile, itemName).show(
                    fragmentManager,
                    "Dialogo baremo"
                )
            }
        }
        spans.setSpan(clickSpan, 0, spans.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
    }

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
}