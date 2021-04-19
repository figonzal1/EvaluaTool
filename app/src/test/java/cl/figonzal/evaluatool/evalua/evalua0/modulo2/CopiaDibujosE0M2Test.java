/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2021

 Last modified 17-04-21 22:25
 */

package cl.figonzal.evaluatool.evalua.evalua0.modulo2;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import cl.figonzal.evaluatool.utilidades.Utils;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class CopiaDibujosE0M2Test {

    private static final double DESVIACION = 12.65;
    private static final double MEDIA = 42.22;
    private final double percentil_esperado;
    private final double pd_total;
    private final double desviacion_esperada;
    private CopiaDibujosE0M2 m1;

    public CopiaDibujosE0M2Test(double pd_total, double percentil_esperado,
                                double desviacion_esperada) {
        this.percentil_esperado = percentil_esperado;
        this.pd_total = pd_total;
        this.desviacion_esperada = desviacion_esperada;
    }

    @Parameterized.Parameters()
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {65, 99, 1.80},
                {64, 99, 1.72},
                {63, 97, 1.64},
                {62, 97, 1.56},
                {61, 95, 1.48},
                {60, 95, 1.41},
                {59, 90, 1.33},
                {58, 90, 1.25},
                {57, 90, 1.17},
                {56, 85, 1.09},
                {55, 85, 1.01},
                {54, 85, 0.93},
                {53, 75, 0.85},
                {52, 75, 0.77},
                {51, 75, 0.69},
                {50, 70, 0.62},
                {49, 70, 0.54},
                {48, 70, 0.46},
                {47, 65, 0.38},
                {46, 65, 0.30},
                {45, 65, 0.22},
                {44, 55, 0.14},
                {43, 55, 0.06},
                {42, 55, -0.02},
                {41, 50, -0.10},
                {40, 50, -0.18},
                {39, 50, -0.25},
                {38, 40, -0.33},
                {37, 40, -0.41},
                {36, 40, -0.49},
                {35, 30, -0.57},
                {34, 30, -0.65},
                {33, 30, -0.73},
                {32, 20, -0.81},
                {31, 20, -0.89},
                {30, 20, -0.97},
                {29, 15, -1.05},
                {28, 15, -1.12},
                {27, 15, -1.20},
                {26, 12, -1.28},
                {25, 12, -1.36},
                {24, 12, -1.44},
                {23, 10, -1.52},
                {22, 10, -1.60},
                {21, 10, -1.68},
                {20, 9, -1.76},
                {19, 9, -1.84},
                {18, 9, -1.91},
                {17, 6, -1.99},
                {16, 6, -2.07},
                {15, 6, -2.15},
                {14, 3, -2.23},
                {13, 3, -2.31},
                {12, 3, -2.39},
                {11, 3, -2.47},
                {10, 1, -2.55},
                {9, 1, -2.63},
                {8, 1, -2.71},
                {7, 1, -2.78},
                {6, 1, -2.86},
                {5, 1, -2.94},
                {4, 1, -3.02},
                {3, 1, -3.10},
                {2, 1, -3.18},
                {1, 1, -3.26},

                //LIMITES
                {66, 99, 1.88},
                {0, 1, -3.34}

        });
    }

    @Before
    public void setUp() {
        m1 = new CopiaDibujosE0M2();
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
