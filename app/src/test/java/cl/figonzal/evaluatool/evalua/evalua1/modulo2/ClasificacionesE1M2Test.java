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

package cl.figonzal.evaluatool.evalua.evalua1.modulo2;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import cl.figonzal.evaluatool.utilidades.Utilidades;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class ClasificacionesE1M2Test {

    private static final double DESVIACION = 4.87;
    private static final double MEDIA = 8.80;
    private final double percentil_esperado;
    private final double pd_total;
    private final double desviacion_esperada;
    private ClasificacionesE1M2 m1;

    public ClasificacionesE1M2Test(double pd_total, double percentil_esperado,
                                   double desviacion_esperada) {
        this.percentil_esperado = percentil_esperado;
        this.pd_total = pd_total;
        this.desviacion_esperada = desviacion_esperada;
    }

    @Parameterized.Parameters()
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {20, 99, 2.3},
                {19, 98, 2.09},
                {18, 97, 1.89},
                {17, 95, 1.68},
                {16, 92, 1.48},
                {15, 90, 1.27},
                {14, 85, 1.07},
                {13, 80, 0.86},
                {12, 70, 0.66},
                {11, 65, 0.45},
                {10, 55, 0.25},
                {9, 50, 0.04},
                {8, 45, -0.16},
                {7, 40, -0.37},
                {6, 30, -0.57},
                {5, 25, -0.78},
                {4, 20, -0.99},
                {3, 15, -1.19},
                {2, 10, -1.4},
                {1, 5, -1.6},
                {0, 1, -1.81},

                //LIMITE
                {-1, 1, -2.01},
                {21, 99, 2.51}

        });
    }

    @Before
    public void setUp() {
        m1 = new ClasificacionesE1M2();
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
