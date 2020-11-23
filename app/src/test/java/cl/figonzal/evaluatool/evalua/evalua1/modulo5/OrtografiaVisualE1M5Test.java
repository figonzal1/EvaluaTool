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

package cl.figonzal.evaluatool.evalua.evalua1.modulo5;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import cl.figonzal.evaluatool.utilidades.Utilidades;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class OrtografiaVisualE1M5Test {

    private static final double DESVIACION = 7.57;
    private static final double MEDIA = 14.59;
    private final double percentil_esperado;
    private final double pd_total;
    private final double desviacion_esperada;
    private OrtografiaVisualE1M5 m1;

    public OrtografiaVisualE1M5Test(double pd_total, double percentil_esperado,
                                    double desviacion_esperada) {
        this.percentil_esperado = percentil_esperado;
        this.pd_total = pd_total;
        this.desviacion_esperada = desviacion_esperada;
    }

    @Parameterized.Parameters()
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {28, 99, 1.77},
                {27, 97, 1.64},
                {26, 95, 1.51},
                {25, 90, 1.38},
                {24, 87, 1.24},
                {23, 85, 1.11},
                {22, 82, 0.98},
                {21, 80, 0.85},
                {20, 75, 0.71},
                {19, 65, 0.58},
                {18, 60, 0.45},
                {17, 55, 0.32},
                {16, 52, 0.19},
                {15, 50, 0.05},
                {13, 45, -0.21},
                {11, 40, -0.47},
                {10, 35, -0.61},
                {8, 30, -0.87},
                {6, 25, -1.13},
                {5, 20, -1.27},
                {4, 15, -1.4},
                {3, 10, -1.53},

                //LIMITE
                {2, 10, -1.66},
                {29, 99, 1.9}

        });
    }

    @Before
    public void setUp() {
        m1 = new OrtografiaVisualE1M5();
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
