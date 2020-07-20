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
 Last modified 19-07-20 23:12                                                 -
 -----------------------------------------------------------------------------*/

package cl.figonzal.evaluatool.evalua4.modulo5;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import cl.figonzal.evaluatool.Utilidades;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class OrtografiaVisualRegladaE4M5Test {

    private static final double DESVIACION = 16.04;
    private static final double MEDIA = 40.62;
    private final double percentil_esperado;
    private final double pd_total;
    private final double desviacion_esperada;
    private OrtografiaVisualRegladaE4M5 m1;

    public OrtografiaVisualRegladaE4M5Test(double pd_total, double percentil_esperado,
                                           double desviacion_esperada) {
        this.percentil_esperado = percentil_esperado;
        this.pd_total = pd_total;
        this.desviacion_esperada = desviacion_esperada;
    }

    @Parameterized.Parameters()
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {80, 99, 2.46},
                {79, 99, 2.39},
                {78, 99, 2.33},
                {77, 98, 2.27},
                {76, 98, 2.21},
                {75, 98, 2.14},
                {74, 97, 2.08},
                {73, 97, 2.02},
                {72, 97, 1.96},
                {71, 96, 1.89},
                {70, 96, 1.83},
                {69, 96, 1.77},
                {68, 94, 1.71},
                {67, 94, 1.64},
                {66, 94, 1.58},
                {65, 92, 1.52},
                {64, 92, 1.46},
                {63, 92, 1.4},
                {62, 90, 1.33},
                {61, 90, 1.27},
                {60, 90, 1.21},
                {59, 85, 1.15},
                {58, 85, 1.08},
                {57, 85, 1.02},
                {56, 80, 0.96},
                {55, 80, 0.9},
                {54, 80, 0.83},
                {53, 75, 0.77},
                {52, 75, 0.71},
                {51, 75, 0.65},
                {50, 70, 0.58},
                {49, 70, 0.52},
                {48, 70, 0.46},
                {47, 60, 0.4},
                {46, 60, 0.34},
                {45, 60, 0.27},
                {44, 55, 0.21},
                {43, 55, 0.15},
                {42, 55, 0.09},
                {41, 50, 0.02},
                {40, 50, -0.04},
                {39, 50, -0.1},
                {38, 40, -0.16},
                {37, 40, -0.23},
                {36, 40, -0.29},
                {35, 35, -0.35},
                {34, 35, -0.41},
                {33, 35, -0.48},
                {32, 30, -0.54},
                {31, 30, -0.6},
                {30, 30, -0.66},
                {29, 25, -0.72},
                {28, 25, -0.79},
                {27, 25, -0.85},
                {26, 20, -0.91},
                {25, 20, -0.97},
                {24, 20, -1.04},
                {23, 17, -1.1},
                {22, 17, -1.16},
                {21, 17, -1.22},
                {20, 15, -1.29},
                {19, 15, -1.35},
                {18, 15, -1.41},
                {17, 10, -1.47},
                {16, 10, -1.53},
                {15, 10, -1.6},
                {14, 5, -1.66},
                {13, 5, -1.72},
                {12, 5, -1.78},
                {11, 1, -1.85},
                {10, 1, -1.91},
                {9, 1, -1.97}

        });
    }

    @Before
    public void setUp() {
        m1 = new OrtografiaVisualRegladaE4M5();
    }

    @Test
    public void testCalcularPercentil() {
        assertEquals(percentil_esperado, m1.calcularPercentil(pd_total), 0.1);
    }

    @Test
    public void testCalcularDesviacion() {
        assertEquals(desviacion_esperada, Utilidades.calcularDesviacion(MEDIA, DESVIACION, pd_total, false), 0.001);
    }
}
