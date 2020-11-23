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

package cl.figonzal.evaluatool.evalua.evalua3.modulo4;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import cl.figonzal.evaluatool.utilidades.Utilidades;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class ExactitudLectoraE3M4Test {
    private static final double DESVIACION = 5.54;
    private static final double MEDIA = 33.66;

    private final double pd_total;
    private final double percentil_esperado;
    private final double desviacion_esperada;
    private ExactitudLectoraE3M4 m1;

    public ExactitudLectoraE3M4Test(double pd_total, double percentil_esperado, double desviacion_esperada) {
        this.pd_total = pd_total;
        this.percentil_esperado = percentil_esperado;
        this.desviacion_esperada = desviacion_esperada;
    }

    @Parameterized.Parameters()
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {44, 99, 1.87},
                {43, 98, 1.69},
                {42, 97, 1.51},
                {41, 95, 1.32},
                {40, 90, 1.14},
                {39, 85, 0.96},
                {38, 80, 0.78},
                {37, 75, 0.6},
                {36, 65, 0.42},
                {35, 60, 0.24},
                {34, 55, 0.06},
                {33, 50, -0.12},
                {32, 45, -0.3},
                {31, 40, -0.48},
                {30, 35, -0.66},
                {29, 30, -0.84},
                {28, 25, -1.02},
                {27, 20, -1.2},
                {26, 15, -1.38},
                {25, 12, -1.56},
                {24, 10, -1.74},
                {23, 7, -1.92},
                {22, 5, -2.1},
                {21, 3, -2.29},
                {20, 2, -2.47},
                {19, 1, -2.65},
                {18, 1, -2.83},
                {45, 99, 2.05}

        });
    }

    @Before
    public void setUp() {
        m1 = new ExactitudLectoraE3M4();
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
