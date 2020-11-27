/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2020

 Last modified 27-11-20 1:08
 */

package cl.figonzal.evaluatool.evalua.evalua1.modulo4;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import cl.figonzal.evaluatool.utilidades.EvaluaUtils;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class ExactitudLectoraE1M4Test {

    private static final double DESVIACION = 25.02;
    private static final double MEDIA = 98.38;
    private final double percentil_esperado;
    private final double pd_total;
    private final double desviacion_esperada;
    private ExactitudLectoraE1M4 m1;

    public ExactitudLectoraE1M4Test(double pd_total, double percentil_esperado,
                                    double desviacion_esperada) {
        this.percentil_esperado = percentil_esperado;
        this.pd_total = pd_total;
        this.desviacion_esperada = desviacion_esperada;
    }

    @Parameterized.Parameters()
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {146, 99, 1.9},
                {143, 97, 1.78},
                {140, 95, 1.66},
                {137, 90, 1.54},
                {134, 85, 1.42},
                {131, 80, 1.3},
                {128, 75, 1.18},
                {125, 70, 1.06},
                {122, 65, 0.94},
                {119, 60, 0.82},
                {116, 57, 0.7},
                {113, 55, 0.58},
                {110, 52, 0.46},
                {107, 50, 0.34},
                {104, 48, 0.22},
                {101, 45, 0.1},
                {98, 42, -0.02},
                {95, 40, -0.14},
                {92, 38, -0.25},
                {89, 35, -0.37},
                {86, 34, -0.49},
                {83, 32, -0.61},
                {80, 31, -0.73},
                {77, 30, -0.85},
                {74, 29, -0.97},
                {71, 28, -1.09},
                {68, 27, -1.21},
                {65, 26, -1.33},
                {62, 25, -1.45},
                {59, 22, -1.57},
                {56, 20, -1.69},
                {53, 15, -1.81},
                {50, 12, -1.93},
                {47, 10, -2.05},
                {44, 5, -2.17},
                {41, 1, -2.29},

                //LIMITE
                {39, 1, -2.37},
                {147, 99, 1.94}
        });
    }

    @Before
    public void setUp() {
        m1 = new ExactitudLectoraE1M4();
    }

    @Test
    public void testCalcularPercentil() {
        assertEquals(percentil_esperado, m1.calcularPercentil(pd_total), 0.1);
    }

    @Test
    public void testCalcularDesviacion() {
        assertEquals(desviacion_esperada, EvaluaUtils.calcularDesviacion(MEDIA, DESVIACION, pd_total, false), 0.001);
    }
}
