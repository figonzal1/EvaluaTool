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
 Last modified 01-07-20 17:21                                                 -
 -----------------------------------------------------------------------------*/

package cl.figonzal.evaluatool.evalua3.modulo6;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import cl.figonzal.evaluatool.Utilidades;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class ResolucionProblemasE3M6Test {

    private static final double DESVIACION = 7.79;
    private static final double MEDIA = 14.68;

    private final double pd_total;
    private final double percentil_esperado;
    private final double desviacion_esperada;
    private ResolucionProblemasE3M6 m1;

    public ResolucionProblemasE3M6Test(double pd_total, double percentil_esperado, double desviacion_esperada) {
        this.pd_total = pd_total;
        this.percentil_esperado = percentil_esperado;
        this.desviacion_esperada = desviacion_esperada;
    }

    @Parameterized.Parameters()
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {31, 99, 2.09},
                {30, 98, 1.97},
                {29, 97, 1.84},
                {28, 96, 1.71},
                {27, 95, 1.58},
                {26, 92, 1.45},
                {25, 90, 1.32},
                {24, 85, 1.2},
                {23, 80, 1.07},
                {22, 75, 0.94},
                {21, 70, 0.81},
                {20, 67, 0.68},
                {19, 62, 0.55},
                {18, 60, 0.43},
                {17, 57, 0.3},
                {16, 55, 0.17},
                {15, 50, 0.04},
                {14, 45, -0.09},
                {13, 42, -0.22},
                {12, 40, -0.34},
                {11, 35, -0.47},
                {10, 30, -0.6},
                {9, 25, -0.73},
                {8, 20, -0.86},
                {7, 15, -0.99},
                {6, 10, -1.11},
                {5, 7, -1.24},
                {4, 5, -1.37},
                {3, 1, -1.5},

                //LIMITE
                {2, 1, -1.63},
                {32, 99, 2.22}

        });
    }

    @Before
    public void setUp() {
        m1 = new ResolucionProblemasE3M6();
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
