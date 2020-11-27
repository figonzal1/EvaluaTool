/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2020

 Last modified 27-11-20 1:08
 */

package cl.figonzal.evaluatool;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import cl.figonzal.evaluatool.utilidades.EvaluaUtils;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class CalcularNivelTest {

    private final int percentil;
    private final String nivelEsperado;

    public CalcularNivelTest(int percentil, String nivelEsperado) {
        this.percentil = percentil;
        this.nivelEsperado = nivelEsperado;
    }

    @Parameterized.Parameters()
    public static Collection<Object[]> data() {

        //Puntaje directo, Nivel Calculado
        return Arrays.asList(new Object[][]{
                {85, "ALTO"},
                {79, "MEDIO-ALTO"},
                {99, "ALTO"},
                {60, "MEDIO-ALTO"},
                {55, "MEDIO"},
                {40, "MEDIO"},
                {10, "BAJO"},
                {25, "MEDIO-BAJO"},
                {0, "BAJO"}
        });
    }

    @Test
    public void testCalcularNivel() {
        assertEquals(nivelEsperado, EvaluaUtils.calcularNivel(percentil));
    }
}
