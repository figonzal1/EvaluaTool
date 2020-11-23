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
 Last modified 14-08-20 1:02                                                  -
 -----------------------------------------------------------------------------*/

package cl.figonzal.evaluatool.evalua.evalua2.modulo2;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import cl.figonzal.evaluatool.utilidades.Utilidades;

import static junit.framework.TestCase.assertEquals;

@RunWith(Parameterized.class)
public class MemoriaAtencionE2M2Test {

    private static final double DESVIACION = 13.04;
    private static final double MEDIA = 59.35;
    private final double percentil_esperado;
    private final double pd_total;
    private final double desviacion_esperada;
    private MemoriaAtencionE2M2 m1;

    public MemoriaAtencionE2M2Test(double pd_total, double percentil_esperado, double desviacion_esperada) {
        this.percentil_esperado = percentil_esperado;
        this.pd_total = pd_total;
        this.desviacion_esperada = desviacion_esperada;
    }

    @Parameterized.Parameters()
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {88, 99, 2.2},
                {87, 99, 2.12},
                {86, 99, 2.04},
                {85, 99, 1.97},
                {84, 99, 1.89},
                {83, 99, 1.81},
                {82, 99, 1.74},
                {81, 99, 1.66},
                {80, 95, 1.58},
                {79, 95, 1.51},
                {78, 95, 1.43},
                {77, 95, 1.35},
                {76, 95, 1.28},
                {75, 85, 1.2},
                {74, 85, 1.12},
                {73, 85, 1.05},
                {72, 85, 0.97},
                {71, 85, 0.89},
                {70, 75, 0.82},
                {69, 75, 0.74},
                {68, 75, 0.66},
                {67, 75, 0.59},
                {66, 75, 0.51},
                {65, 65, 0.43},
                {64, 65, 0.36},
                {63, 65, 0.28},
                {62, 65, 0.2},
                {61, 65, 0.13},
                {60, 50, 0.05},
                {59, 50, -0.03},
                {58, 50, -0.1},
                {56, 50, -0.26},
                {55, 45, -0.33},
                {54, 45, -0.41},
                {53, 45, -0.49},
                {52, 45, -0.56},
                {51, 45, -0.64},
                {50, 35, -0.72},
                {49, 35, -0.79},
                {48, 35, -0.87},
                {47, 35, -0.95},
                {46, 35, -1.02},
                {45, 30, -1.1},
                {44, 30, -1.18},
                {43, 30, -1.25},
                {42, 30, -1.33},
                {41, 30, -1.41},
                {40, 20, -1.48},
                {39, 20, -1.56},
                {38, 20, -1.64},
                {37, 20, -1.71},
                {36, 20, -1.79},
                {35, 15, -1.87},
                {34, 15, -1.94},
                {33, 15, -2.02},
                {32, 15, -2.1},
                {31, 15, -2.17},
                {30, 10, -2.25},
                {29, 10, -2.33},
                {27, 10, -2.48},
                {26, 10, -2.56},
                {25, 7, -2.63},
                {24, 7, -2.71},
                {23, 7, -2.79},
                {22, 7, -2.86},
                {21, 7, -2.94},
                {20, 5, -3.02},
                {19, 5, -3.09},
                {18, 5, -3.17},
                {17, 5, -3.25},
                {16, 5, -3.32},
                {15, 3, -3.4},
                {14, 3, -3.48},
                {13, 3, -3.55},
                {12, 3, -3.63},
                {11, 3, -3.71},
                {10, 1, -3.78},
                {9, 1, -3.86},
                {8, 1, -3.94},
                {7, 1, -4.01},
                {6, 1, -4.09}

        });
    }

    @Before
    public void setUp() {
        m1 = new MemoriaAtencionE2M2();
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
