/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2021

 Last modified 17-04-21 22:25
 */

package cl.figonzal.evaluatool.evalua.evalua0.modulo3;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import cl.figonzal.evaluatool.utilidades.Utils;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class HabilidadesFonologicasE0M3Test {

    private static final double DESVIACION = 10.07;
    private static final double MEDIA = 44.73;
    private final double percentil_esperado;
    private final double pd_total;
    private final double desviacion_esperada;
    private HabilidadesFonologicasE0M3 m1;

    public HabilidadesFonologicasE0M3Test(double pd_total, double percentil_esperado,
                                          double desviacion_esperada) {
        this.percentil_esperado = percentil_esperado;
        this.pd_total = pd_total;
        this.desviacion_esperada = desviacion_esperada;
    }

    @Parameterized.Parameters()
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {62, 99, 1.71},
                {61, 99, 1.62},
                {60, 99, 1.52},
                {59, 95, 1.42},
                {58, 95, 1.32},
                {57, 95, 1.22},
                {56, 90, 1.12},
                {55, 90, 1.02},
                {54, 80, 0.92},
                {53, 80, 0.82},
                {52, 70, 0.72},
                {51, 70, 0.62},
                {50, 65, 0.52},
                {49, 65, 0.42},
                {48, 60, 0.32},
                {47, 60, 0.23},
                {46, 55, 0.13},
                {45, 55, 0.03},
                {44, 50, -0.07},
                {43, 50, -0.17},
                {42, 40, -0.27},
                {41, 40, -0.37},
                {40, 30, -0.47},
                {39, 30, -0.57},
                {38, 20, -0.67},
                {37, 20, -0.77},
                {36, 20, -0.87},
                {35, 15, -0.97},
                {34, 15, -1.07},
                {33, 10, -1.16},
                {32, 10, -1.26},
                {31, 10, -1.36},
                {30, 7, -1.46},
                {29, 7, -1.56},
                {28, 7, -1.66},
                {27, 7, -1.76},
                {26, 7, -1.86},
                {25, 7, -1.96},
                {24, 7, -2.06},
                {23, 7, -2.16},
                {22, 7, -2.26},
                {21, 7, -2.36},
                {20, 5, -2.46},
                {19, 5, -2.56},
                {18, 5, -2.65},
                {17, 5, -2.75},
                {16, 5, -2.85},
                {15, 3, -2.95},
                {14, 3, -3.05},
                {13, 3, -3.15},
                {12, 3, -3.25},
                {11, 3, -3.35},
                {10, 1, -3.45},
                {9, 1, -3.55},
                {8, 1, -3.65},
                {7, 1, -3.75},
                {6, 1, -3.85},
                {5, 1, -3.95},


                //LIMITES
                {4, 1, -4.04},
                {63, 99, 1.81}


        });
    }

    @Before
    public void setUp() {
        m1 = new HabilidadesFonologicasE0M3();
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
