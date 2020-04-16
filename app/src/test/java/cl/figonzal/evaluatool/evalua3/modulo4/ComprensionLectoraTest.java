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
 Last modified 15-04-20 22:12                                                 -
 -----------------------------------------------------------------------------*/

package cl.figonzal.evaluatool.evalua3.modulo4;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import cl.figonzal.evaluatool.Utilidades;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class ComprensionLectoraTest {

    private static final double DESVIACION = 12.73;
    private static final double MEDIA = 4.83;

    private final double pd_total;
    private final double percentil_esperado;
    private final double desviacion_esperada;
    private ComprensionLectora m1;

    public ComprensionLectoraTest(double pd_total, double percentil_esperado, double desviacion_esperada) {
        this.pd_total = pd_total;
        this.percentil_esperado = percentil_esperado;
        this.desviacion_esperada = desviacion_esperada;
    }

    @Parameterized.Parameters()
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {30, 99, 1.98},
                {29, 98, 1.9},
                {28, 97, 1.82},
                {27, 96, 1.74},
                {26, 95, 1.66},
                {25, 93, 1.58},
                {24, 92, 1.51},
                {23, 91, 1.43},
                {22, 90, 1.35},
                {21, 87, 1.27},
                {20, 85, 1.19},
                {19, 82, 1.11},
                {18, 80, 1.03},
                {17, 75, 0.96},
                {16, 70, 0.88},
                {15, 60, 0.8},
                {14, 55, 0.72},
                {13, 50, 0.64},
                {12, 40, 0.56},
                {11, 35, 0.48},
                {10, 30, 0.41},
                {9, 25, 0.33},
                {8, 20, 0.25},
                {7, 15, 0.17},
                {6, 12, 0.09},
                {5, 10, 0.01},
                {4, 7, -0.07},
                {3, 5, -0.14},
                {2, 3, -0.22},
                {1, 1, -0.3},

                //LIMITE
                {0, 1, -0.38},
                {31, 99, 2.06}
        });
    }

    @Before
    public void setUp() {
        m1 = new ComprensionLectora();
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
