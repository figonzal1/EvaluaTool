/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2020

 Last modified 27-11-20 1:08
 */

package cl.figonzal.evaluatool.evalua.evalua1.modulo6;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import cl.figonzal.evaluatool.utilidades.EvaluaUtils;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class CalculoNumeracionE1M6Test {
    private static final double DESVIACION = 8.83;
    private static final double MEDIA = 31.08;
    private final double percentil_esperado;
    private final double pd_total;
    private final double desviacion_esperada;
    private CalculoNumeracionE1M6 m1;

    public CalculoNumeracionE1M6Test(double pd_total, double percentil_esperado,
                                     double desviacion_esperada) {
        this.percentil_esperado = percentil_esperado;
        this.pd_total = pd_total;
        this.desviacion_esperada = desviacion_esperada;
    }

    @Parameterized.Parameters()
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {47, 99, 1.8},
                {46, 97, 1.69},
                {45, 95, 1.58},
                {44, 90, 1.46},
                {43, 85, 1.35},
                {42, 82, 1.24},
                {41, 80, 1.12},
                {40, 77, 1.01},
                {39, 75, 0.9},
                {38, 70, 0.78},
                {37, 67, 0.67},
                {36, 62, 0.56},
                {35, 60, 0.44},
                {34, 57, 0.33},
                {33, 55, 0.22},
                {32, 50, 0.1},
                {31, 45, -0.01},
                {30, 40, -0.12},
                {29, 35, -0.24},
                {28, 32, -0.35},
                {27, 30, -0.46},
                {26, 27, -0.58},
                {25, 25, -0.69},
                {21, 20, -1.14},
                {19, 15, -1.37},
                {16, 10, -1.71},
                {13, 5, -2.05},
                {10, 1, -2.39},

                //LIMITES
                {9, 1, -2.5},
                {48, 99, 1.92}


        });
    }

    @Before
    public void setUp() {
        m1 = new CalculoNumeracionE1M6();
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
