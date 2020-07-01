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
 Last modified 01-07-20 17:21                                                 -
 -----------------------------------------------------------------------------*/

package cl.figonzal.evaluatool.evalua3.modulo6;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import cl.figonzal.evaluatool.Utilidades;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class CalculoNumeracionE3M6Test {
    private static final double DESVIACION = 6.50;
    private static final double MEDIA = 19.56;

    private final double pd_total;
    private final double percentil_esperado;
    private final double desviacion_esperada;
    private CalculoNumeracionE3M6 m1;

    public CalculoNumeracionE3M6Test(double pd_total, double percentil_esperado, double desviacion_esperada) {
        this.pd_total = pd_total;
        this.percentil_esperado = percentil_esperado;
        this.desviacion_esperada = desviacion_esperada;
    }

    @Parameterized.Parameters()
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {34, 99, 2.22},
                {33, 98, 2.07},
                {32, 97, 1.91},
                {31, 95, 1.76},
                {30, 92, 1.61},
                {29, 87, 1.45},
                {28, 85, 1.3},
                {27, 82, 1.14},
                {26, 77, 0.99},
                {25, 75, 0.84},
                {24, 70, 0.68},
                {23, 65, 0.53},
                {22, 60, 0.38},
                {21, 55, 0.22},
                {20, 50, 0.07},
                {19, 45, -0.09},
                {18, 42, -0.24},
                {17, 40, -0.39},
                {16, 35, -0.55},
                {15, 30, -0.7},
                {14, 25, -.86},
                {13, 20, -1.01},
                {12, 15, -1.16},
                {11, 12, -1.32},
                {10, 10, -1.47},
                {9, 7, -1.62},
                {8, 5, -1.78},
                {7, 3, -1.93},
                {6, 1, -2.09},

                //LIMITE
                {5, 1, -2.24},
                {35, 99, 2.38}
        });
    }

    @Before
    public void setUp() {
        m1 = new CalculoNumeracionE3M6();
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
