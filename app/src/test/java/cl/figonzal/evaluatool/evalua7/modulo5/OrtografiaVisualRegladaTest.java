/*-----------------------------------------------------------------------------
                                                                              -
 This file is subject to the terms and conditions defined in                  -
 file 'LICENSE', which is part of this source code package                    -
                                                                              -
 Autor: Felipe González                                                       -
 Email: felipe.gonzalezalarcon94@gmail.com                                    -
                                                                              -
 Copyright (c) 2020                                                           -
                                                                              -
 Last modified 15-04-20 13:22                                                 -
 -----------------------------------------------------------------------------*/

package cl.figonzal.evaluatool.evalua7.modulo5;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.List;

import cl.figonzal.evaluatool.Utilidades;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class OrtografiaVisualRegladaTest {

    private static final double DESVIACION = 14.49;
    private static final double MEDIA = 42.21;
    private final double pd_total;
    private final double percentil_esperado;
    private final double desviacion_esperada;
    private OrtografiaVisualReglada ov;

    public OrtografiaVisualRegladaTest(double pd_total, double percentil_esperado,
                                       double desviacion_esperada) {
        this.pd_total = pd_total;
        this.percentil_esperado = percentil_esperado;
        this.desviacion_esperada = desviacion_esperada;
    }

    @Parameterized.Parameters()
    public static List data() {
        return Arrays.asList(new Object[][]{
                {80, 99, 2.61},
                {78, 98, 2.47},
                {76, 97, 2.33},
                {74, 95, 2.19},
                {72, 92, 2.06},
                {70, 90, 1.92},
                {68, 87, 1.78},
                {66, 85, 1.64},
                {64, 82, 1.50},
                {62, 80, 1.37},
                {60, 77, 1.23},
                {58, 75, 1.09},
                {56, 72, 0.95},
                {54, 70, 0.81},
                {52, 65, 0.68},
                {50, 60, 0.54},
                {48, 55, 0.40},
                {44, 50, 0.12},
                {40, 45, -0.15},
                {36, 40, -0.43},
                {32, 35, -0.70},
                {28, 30, -0.98},
                {24, 25, -1.26},
                {20, 20, -1.53},
                {16, 15, -1.81},
                {12, 10, -2.08},
                {8, 5, -2.36},
                {4, 1, -2.64}
        });
    }

    @Before
    public void setUp() {
        ov = new OrtografiaVisualReglada();
    }

    @Test
    public void testCalcularPercentil() {
        assertEquals(percentil_esperado, ov.calcularPercentil(pd_total), 0.01);
    }

    @Test
    public void testCalcularDesviacion() {
        assertEquals(desviacion_esperada, Utilidades.calcularDesviacion(MEDIA, DESVIACION, pd_total, false), 0.01);
    }
}
