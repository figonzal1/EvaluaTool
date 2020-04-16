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
 Last modified 15-04-20 22:01                                                 -
 -----------------------------------------------------------------------------*/

package cl.figonzal.evaluatool.evalua3.modulo2;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import cl.figonzal.evaluatool.Utilidades;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class ReflexividadTest {

    private static final double DESVIACION = 6.22;
    private static final double MEDIA = 11.84;
    private final double pd_total;
    private final double percentil_esperado;
    private final double desviacion_esperada;
    private Reflexividad m1;

    public ReflexividadTest(double pd_total, double percentil_esperado, double desviacion_esperada) {
        this.pd_total = pd_total;
        this.percentil_esperado = percentil_esperado;
        this.desviacion_esperada = desviacion_esperada;
    }

    @Parameterized.Parameters()
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {22, 99, 1.63},
                {21, 95, 1.47},
                {20, 90, 1.31},
                {19, 87, 1.15},
                {18, 85, 0.99},
                {17, 80, 0.83},
                {16, 75, 0.67},
                {15, 70, 0.51},
                {14, 65, 0.35},
                {13, 60, 0.19},
                {12, 55, 0.03},
                {11, 50, -0.14},
                {10, 47, -0.3},
                {9, 42, -0.46},
                {8, 40, -0.62},
                {7, 35, -0.78},
                {6, 30, -0.94},
                {5, 25, -1.1},
                {4, 15, -1.26},
                {3, 10, -1.42},
                {2, 5, -1.58},
                {1, 1, -1.74},

                //LIMITE
                {1, 1, -1.74},
                {23, 99, 1.79}
        });
    }

    @Before
    public void setUp() {
        m1 = new Reflexividad();
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
