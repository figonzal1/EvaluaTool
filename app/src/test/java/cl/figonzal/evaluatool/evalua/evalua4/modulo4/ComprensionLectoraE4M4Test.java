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

package cl.figonzal.evaluatool.evalua.evalua4.modulo4;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import cl.figonzal.evaluatool.utilidades.Utilidades;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class ComprensionLectoraE4M4Test {

    private static final double DESVIACION = 6.63;
    private static final double MEDIA = 21.47;
    private final double percentil_esperado;
    private final double pd_total;
    private final double desviacion_esperada;
    private ComprensionLectoraE4M4 m1;

    public ComprensionLectoraE4M4Test(double pd_total, double percentil_esperado,
                                      double desviacion_esperada) {
        this.percentil_esperado = percentil_esperado;
        this.pd_total = pd_total;
        this.desviacion_esperada = desviacion_esperada;
    }

    @Parameterized.Parameters()
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {32, 99, 1.59},
                {31, 99, 1.44},
                {30, 94, 1.29},
                {29, 94, 1.14},
                {28, 85, 0.98},
                {27, 85, 0.83},
                {26, 70, 0.68},
                {25, 70, 0.53},
                {24, 60, 0.38},
                {23, 60, 0.23},
                {22, 50, 0.08},
                {21, 50, -0.07},
                {20, 40, -0.22},
                {19, 40, -0.37},
                {18, 30, -0.52},
                {17, 30, -0.67},
                {16, 25, -0.83},
                {15, 25, -0.98},
                {14, 15, -1.13},
                {13, 15, -1.28},
                {12, 10, -1.43},
                {11, 10, -1.58},
                {10, 8, -1.73},
                {9, 8, -1.88},
                {8, 6, -2.03},
                {7, 6, -2.18},
                {6, 4, -2.33},
                {5, 4, -2.48},
                {4, 2, -2.63},
                {3, 2, -2.79},
                {2, 1, -2.94},
                {1, 1, -3.09}
        });
    }

    @Before
    public void setUp() {
        m1 = new ComprensionLectoraE4M4();
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