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

package cl.figonzal.evaluatool.evalua.evalua4.modulo1;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import cl.figonzal.evaluatool.utilidades.Utilidades;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class MemoriaAtencionE4M1Test {

    private static final double DESVIACION = 17.11;
    private static final double MEDIA = 62.66;
    private final double percentil_esperado;
    private final double pd_total;
    private final double desviacion_esperada;
    private MemoriaAtencionE4M1 m1;

    public MemoriaAtencionE4M1Test(double pd_total, double percentil_esperado,
                                   double desviacion_esperada) {
        this.percentil_esperado = percentil_esperado;
        this.pd_total = pd_total;
        this.desviacion_esperada = desviacion_esperada;
    }

    @Parameterized.Parameters()
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{

                {102, 99, 2.3},
                {101, 99, 2.24},
                {100, 99, 2.18},
                {99, 99, 2.12},
                {98, 99, 2.07},
                {97, 99, 2.01},
                {96, 99, 1.95},
                {95, 99, 1.89},
                {94, 95, 1.83},
                {93, 95, 1.77},
                {92, 95, 1.71},
                {91, 95, 1.66},
                {90, 95, 1.6},
                {89, 90, 1.54},
                {88, 90, 1.48},
                {87, 90, 1.42},
                {86, 90, 1.36},
                {85, 90, 1.31},
                {84, 85, 1.25},
                {83, 85, 1.19},
                {82, 85, 1.13},
                {81, 85, 1.07},
                {80, 85, 1.01},
                {79, 80, 0.95},
                {78, 80, 0.9},
                {77, 80, 0.84},
                {76, 80, 0.78},
                {75, 80, 0.72},
                {74, 70, 0.66},
                {73, 70, 0.6},
                {72, 70, 0.55},
                {71, 70, 0.49},
                {70, 70, 0.43},
                {69, 60, 0.37},
                {68, 60, 0.31},
                {67, 60, 0.25},
                {66, 60, 0.2},
                {65, 60, 0.14},
                {64, 50, 0.08},
                {63, 50, 0.02},
                {62, 50, -0.04},
                {61, 50, -0.1},
                {60, 50, -0.16},
                {59, 40, -0.21},
                {58, 40, -0.27},
                {57, 40, -0.33},
                {56, 40, -0.39},
                {55, 40, -0.45},
                {54, 30, -0.51},
                {53, 30, -0.56},
                {52, 30, -0.62},
                {51, 30, -0.68},
                {50, 30, -0.74},
                {49, 20, -0.8},
                {48, 20, -0.86},
                {47, 20, -0.92},
                {46, 20, -0.97},
                {45, 20, -1.03},
                {44, 15, -1.09},
                {43, 15, -1.15},
                {42, 15, -1.21},
                {41, 15, -1.27},
                {40, 15, -1.32},
                {39, 12, -1.38},
                {38, 12, -1.44},
                {37, 12, -1.5},
                {36, 12, -1.56},
                {35, 12, -1.62},
                {34, 10, -1.68},
                {33, 10, -1.73},
                {32, 10, -1.79},
                {31, 10, -1.85},
                {30, 10, -1.91},
                {29, 7, -1.97},
                {28, 7, -2.03},
                {27, 7, -2.08},
                {26, 7, -2.14},
                {25, 7, -2.2},
                {24, 5, -2.26},
                {23, 5, -2.32},
                {22, 5, -2.38},
                {21, 5, -2.43},
                {20, 5, -2.49},
                {19, 3, -2.55},
                {18, 3, -2.61},
                {17, 3, -2.67},
                {16, 3, -2.73},
                {15, 3, -2.79},
                {14, 2, -2.84},
                {13, 2, -2.9},
                {12, 2, -2.96},
                {11, 2, -3.02},
                {10, 2, -3.08},
                {9, 1, -3.14},
                {8, 1, -3.19},
                {7, 1, -3.25},
                {6, 1, -3.31},
                {5, 1, -3.37}
        });
    }

    @Before
    public void setUp() {
        m1 = new MemoriaAtencionE4M1();
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
