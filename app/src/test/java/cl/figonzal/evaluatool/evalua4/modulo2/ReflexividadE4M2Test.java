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
 Last modified 19-07-20 21:51                                                 -
 -----------------------------------------------------------------------------*/

package cl.figonzal.evaluatool.evalua4.modulo2;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import cl.figonzal.evaluatool.Utilidades;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class ReflexividadE4M2Test {

    private static final double DESVIACION = 5.33;
    private static final double MEDIA = 13.94;
    private final double percentil_esperado;
    private final double pd_total;
    private final double desviacion_esperada;
    private ReflexividadE4M2 m1;

    public ReflexividadE4M2Test(double pd_total, double percentil_esperado,
                                double desviacion_esperada) {
        this.percentil_esperado = percentil_esperado;
        this.pd_total = pd_total;
        this.desviacion_esperada = desviacion_esperada;
    }

    @Parameterized.Parameters()
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {20, 95, 1.14},
                {19, 85, 0.95},
                {18, 75, 0.76},
                {17, 65, 0.57},
                {16, 60, 0.39},
                {15, 55, 0.2},
                {14, 50, 0.01},
                {13, 40, -0.18},
                {12, 30, -0.36},
                {11, 25, -0.55},
                {10, 20, -0.74},
                {9, 15, -0.93},
                {8, 13, -1.11},
                {7, 12, -1.3},
                {6, 10, -1.49},
                {5, 9, -1.68},
                {4, 7, -1.86},
                {3, 5, -2.05},
                {2, 3, -2.24},
                {1, 2, -2.43},
                {0, 1, -2.62}
        });
    }

    @Before
    public void setUp() {
        m1 = new ReflexividadE4M2();
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