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
public class ComprensionLectoraE3M4Test {

    private static final double DESVIACION = 4.83;
    private static final double MEDIA = 12.73;

    private final double pd_total;
    private final double percentil_esperado;
    private final double desviacion_esperada;
    private ComprensionLectoraE3M4 m1;

    public ComprensionLectoraE3M4Test(double pd_total, double percentil_esperado, double desviacion_esperada) {
        this.pd_total = pd_total;
        this.percentil_esperado = percentil_esperado;
        this.desviacion_esperada = desviacion_esperada;
    }

    @Parameterized.Parameters()
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {30, 99, 3.58},
                {29, 98, 3.37},
                {28, 97, 3.16},
                {27, 96, 2.95},
                {26, 95, 2.75},
                {25, 93, 2.54},
                {24, 92, 2.33},
                {23, 91, 2.13},
                {22, 90, 1.92},
                {21, 87, 1.71},
                {20, 85, 1.51},
                {19, 82, 1.3},
                {18, 80, 1.09},
                {17, 75, 0.88},
                {16, 70, 0.68},
                {15, 60, 0.47},
                {14, 55, 0.26},
                {13, 50, 0.06},
                {12, 40, -0.15},
                {11, 35, -0.36},
                {10, 30, -0.57},
                {9, 25, -0.77},
                {8, 20, -0.98},
                {7, 15, -1.19},
                {6, 12, -1.39},
                {5, 10, -1.6},
                {4, 7, -1.81},
                {3, 5, -2.01},
                {2, 3, -2.22},
                {1, 1, -2.43},
                {0, 1, -2.64},
                {31, 99, 3.78}


        });
    }

    @Before
    public void setUp() {
        m1 = new ComprensionLectoraE3M4();
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
