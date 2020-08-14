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
 Last modified 14-08-20 1:09                                                  -
 -----------------------------------------------------------------------------*/

package cl.figonzal.evaluatool.evalua.evalua4.modulo3;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import cl.figonzal.evaluatool.evalua.evalua4.modulo3.adaptacionFragments.AutoControlFragmentE4M3;
import cl.figonzal.evaluatool.utilidades.Utilidades;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class AutoControlFragmentE4M3Test {

    private static final double DESVIACION = 2.43;
    private static final double MEDIA = 3.37;
    private final double percentil_esperado;
    private final double pd_total;
    private final double desviacion_esperada;
    private AutoControlFragmentE4M3 m1;

    public AutoControlFragmentE4M3Test(double pd_total, double percentil_esperado,
                                       double desviacion_esperada) {
        this.percentil_esperado = percentil_esperado;
        this.pd_total = pd_total;
        this.desviacion_esperada = desviacion_esperada;
    }

    @Parameterized.Parameters()
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {0, 99, 1.39},
                {1, 95, 0.98},
                {2, 80, 0.56},
                {3, 70, 0.15},
                {4, 60, -0.26},
                {5, 50, -0.67},
                {6, 40, -1.08},
                {7, 35, -1.49},
                {8, 25, -1.91},
                {9, 20, -2.32},
                {10, 15, -2.73},
                {11, 10, -3.14},
                {12, 7, -3.55},
                {13, 5, -3.96},
                {14, 3, -4.37},
                {15, 1, -4.79},
                {16, 1, -5.2},
                {17, 1, -5.61},
                {18, 1, -6.02},
                {19, 1, -6.43},
                {20, 1, -6.84},
                {22, 1, -7.67},
                {24, 1, -8.49},
                {26, 1, -9.31},
                {28, 1, -10.14},
                {30, 1, -10.96}

        });
    }

    @Before
    public void setUp() {
        m1 = new AutoControlFragmentE4M3();
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