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
 Last modified 15-04-20 13:22                                                 -
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
public class ExactitudLectoraTest {
    private static final double DESVIACION = 5.74;
    private static final double MEDIA = 33.66;

    private final double pd_total;
    private final double percentil_esperado;
    private final double desviacion_esperada;
    private ExactitudLectora m1;

    public ExactitudLectoraTest(double pd_total, double percentil_esperado, double desviacion_esperada) {
        this.pd_total = pd_total;
        this.percentil_esperado = percentil_esperado;
        this.desviacion_esperada = desviacion_esperada;
    }

    @Parameterized.Parameters()
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {44, 99, 1.8},
                {43, 98, 1.63},
                {42, 97, 1.45},
                {41, 95, 1.28},
                {40, 90, 1.1},
                {39, 85, 0.93},
                {38, 80, 0.76},
                {37, 75, 0.58},
                {36, 65, 0.41},
                {35, 60, 0.23},
                {34, 55, 0.06},
                {33, 50, -0.11},
                {32, 45, -0.29},
                {31, 40, -0.46},
                {30, 35, -0.64},
                {29, 30, -0.81},
                {28, 25, -0.99},
                {27, 20, -1.16},
                {26, 15, -1.33},
                {25, 12, -1.51},
                {24, 10, -1.68},
                {23, 7, -1.86},
                {22, 5, -2.03},
                {21, 3, -2.21},
                {20, 2, -2.38},
                {19, 1, -2.55}

        });
    }

    @Before
    public void setUp() {
        m1 = new ExactitudLectora();
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
