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

package cl.figonzal.evaluatool.evalua4.modulo3;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import cl.figonzal.evaluatool.Utilidades;
import cl.figonzal.evaluatool.evalua4.modulo3.adaptacionFragments.AutoEstimaFragmentE4M3;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class AutoEstimaFragmentE4M3Test {
    private static final double DESVIACION = 2.59;
    private static final double MEDIA = 5.08;
    private final double percentil_esperado;
    private final double pd_total;
    private final double desviacion_esperada;
    private AutoEstimaFragmentE4M3 m1;

    public AutoEstimaFragmentE4M3Test(double pd_total, double percentil_esperado,
                                      double desviacion_esperada) {
        this.percentil_esperado = percentil_esperado;
        this.pd_total = pd_total;
        this.desviacion_esperada = desviacion_esperada;
    }

    @Parameterized.Parameters()
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {0, 99, 1.96},
                {1, 95, 1.58},
                {2, 90, 1.19},
                {3, 80, 0.8},
                {4, 75, 0.42},
                {5, 65, 0.03},
                {6, 55, -0.36},
                {7, 45, -0.74},
                {8, 40, -1.13},
                {9, 35, -1.51},
                {10, 25, -1.9},
                {11, 15, -2.29},
                {12, 10, -2.67},
                {13, 9, -3.06},
                {14, 7, -3.44},
                {15, 5, -3.83},
                {16, 3, -4.22},
                {17, 1, -4.6},
                {18, 1, -4.99},
                {19, 1, -5.37},
                {20, 1, -5.76},
                {22, 1, -6.53},
                {24, 1, -7.31},
                {26, 1, -8.08},
                {28, 1, -8.85},
                {30, 1, -9.62}
        });
    }

    @Before
    public void setUp() {
        m1 = new AutoEstimaFragmentE4M3();
    }

    @Test
    public void testCalcularPercentil() {
        assertEquals(percentil_esperado, m1.calcularPercentil(pd_total), 0.1);
    }

    @Test
    public void testCalcularDesviacion() {
        assertEquals(desviacion_esperada, Utilidades.calcularDesviacion(MEDIA, DESVIACION, pd_total, true), 0.001);
    }
}