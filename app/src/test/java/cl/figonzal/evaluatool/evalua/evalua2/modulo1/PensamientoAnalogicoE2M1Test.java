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

package cl.figonzal.evaluatool.evalua.evalua2.modulo1;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import cl.figonzal.evaluatool.utilidades.Utilidades;

import static junit.framework.TestCase.assertEquals;

@RunWith(Parameterized.class)
public class PensamientoAnalogicoE2M1Test {
    private static final double DESVIACION = 5.16;
    private static final double MEDIA = 12.75;
    private final double percentil_esperado;
    private final double pd_total;
    private final double desviacion_esperada;
    private PensamientoAnalogicoE2M1 m1;

    public PensamientoAnalogicoE2M1Test(double pd_total, double percentil_esperado, double desviacion_esperada) {
        this.percentil_esperado = percentil_esperado;
        this.pd_total = pd_total;
        this.desviacion_esperada = desviacion_esperada;
    }

    @Parameterized.Parameters()
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {20, 99, 1.41},
                {19, 90, 1.21},
                {18, 80, 1.02},
                {17, 75, 0.82},
                {16, 70, 0.63},
                {15, 65, 0.44},
                {14, 60, 0.24},
                {13, 55, 0.05},
                {12, 50, -0.15},
                {11, 40, -0.34},
                {10, 35, -0.53},
                {9, 30, -0.73},
                {8, 20, -0.92},
                {7, 15, -1.11},
                {6, 13, -1.31},
                {5, 10, -1.5},
                {4, 8, -1.7},
                {3, 7, -1.89},
                {2, 5, -2.08},
                {1, 3, -2.28},
                {0, 1, -2.47}
        });
    }

    @Before
    public void setUp() {
        m1 = new PensamientoAnalogicoE2M1();
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
