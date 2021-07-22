/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2021

 Last modified 21-07-21 22:54
 */
package cl.figonzal.evaluatool

import cl.figonzal.evaluatool.utilities.EvaluaUtils.calcularNivelTest
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class CalcularNivelTest(private val percentil: Int, private val nivelEsperado: String) {

    @Test
    fun testCalcularNivel() {
        Assert.assertEquals(nivelEsperado, calcularNivelTest(percentil))
    }

    companion object {

        @JvmStatic
        @Parameterized.Parameters
        fun data(): Array<Any> {

            //Puntaje directo, Nivel Calculado
            return arrayOf(
                    arrayOf(85, "ALTO"),
                    arrayOf(79, "MEDIO-ALTO"),
                    arrayOf(99, "ALTO"),
                    arrayOf(60, "MEDIO-ALTO"),
                    arrayOf(55, "MEDIO"),
                    arrayOf(40, "MEDIO"),
                    arrayOf(10, "BAJO"),
                    arrayOf(25, "MEDIO-BAJO"),
                    arrayOf(0, "BAJO")
            )
        }
    }
}