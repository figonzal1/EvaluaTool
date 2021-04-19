/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2021

 Last modified 17-04-21 22:24
 */

package cl.figonzal.evaluatool.evalua.evalua3.modulo5;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import cl.figonzal.evaluatool.utilidades.Utils;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class OrtografiaVisualRegladaE3M5Test {

    private static final double DESVIACION = 9.84;
    private static final double MEDIA = 39.89;

    private final double pd_total;
    private final double percentil_esperado;
    private final double desviacion_esperada;
    private OrtografiaVisualRegladaE3M5 m1;

    public OrtografiaVisualRegladaE3M5Test(double pd_total, double percentil_esperado, double desviacion_esperada) {
        this.pd_total = pd_total;
        this.percentil_esperado = percentil_esperado;
        this.desviacion_esperada = desviacion_esperada;
    }

    @Parameterized.Parameters()
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {67, 99, 2.76},
                {65, 97, 2.55},
                {63, 95, 2.35},
                {61, 94, 2.15},
                {59, 92, 1.94},
                {57, 90, 1.74},
                {55, 85, 1.54},
                {53, 80, 1.33},
                {51, 75, 1.13},
                {49, 70, 0.93},
                {47, 65, 0.72},
                {45, 60, 0.52},
                {43, 55, 0.32},
                {41, 50, 0.11},
                {39, 45, -0.09},
                {37, 40, -0.29},
                {35, 35, -0.5},
                {33, 30, -0.7},
                {31, 25, -0.9},
                {29, 20, -1.11},
                {27, 15, -1.31},
                {25, 12, -1.51},
                {23, 10, -1.72},
                {21, 7, -1.92},
                {19, 5, -2.12},
                {17, 3, -2.33},
                {15, 1, -2.53},

                //LIMITE
                {14, 1, -2.63},
                {68, 99, 2.86}
        });
    }

    @Before
    public void setUp() {
        m1 = new OrtografiaVisualRegladaE3M5();
    }

    @Test
    public void testCalcularPercentil() {
        assertEquals(percentil_esperado, m1.calcularPercentil(pd_total), 0.1);
    }

    @Test
    public void testCalcularDesviacion() {
        assertEquals(desviacion_esperada, Utils.calcularDesviacion(MEDIA, DESVIACION, pd_total, false), 0.001);
    }
}
