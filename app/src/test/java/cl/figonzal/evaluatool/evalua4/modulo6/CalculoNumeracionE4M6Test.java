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
 Last modified 20-07-20 13:33                                                 -
 -----------------------------------------------------------------------------*/

package cl.figonzal.evaluatool.evalua4.modulo6;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import cl.figonzal.evaluatool.Utilidades;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class CalculoNumeracionE4M6Test {

    private static final double DESVIACION = 5.16;
    private static final double MEDIA = 28.05;
    private final double percentil_esperado;
    private final double pd_total;
    private final double desviacion_esperada;
    private CalculoNumeracionE4M6 m1;

    public CalculoNumeracionE4M6Test(double pd_total, double percentil_esperado,
                                     double desviacion_esperada) {
        this.percentil_esperado = percentil_esperado;
        this.pd_total = pd_total;
        this.desviacion_esperada = desviacion_esperada;
    }

    @Parameterized.Parameters()
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {35, 99, 1.35},
                {34, 95, 1.15},
                {33, 85, 0.96},
                {32, 80, 0.77},
                {31, 70, 0.57},
                {30, 65, 0.38},
                {29, 55, 0.18},
                {28, 50, -0.01},
                {27, 45, -0.2},
                {26, 40, -0.4},
                {25, 37, -0.59},
                {24, 35, -0.78},
                {23, 30, -0.98},
                {22, 25, -1.17},
                {21, 20, -1.37},
                {20, 18, -1.56},
                {19, 15, -1.75},
                {18, 12, -1.95},
                {17, 10, -2.14},
                {16, 9, -2.34},
                {15, 8, -2.53},
                {14, 7, -2.72},
                {13, 6, -2.92},
                {12, 5, -3.11},
                {11, 3, -3.3},
                {10, 2, -3.5},
                {9, 1, -3.69}
        });
    }

    @Before
    public void setUp() {
        m1 = new CalculoNumeracionE4M6();
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