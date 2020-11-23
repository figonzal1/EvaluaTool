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

package cl.figonzal.evaluatool.evalua.evalua3.modulo2;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import cl.figonzal.evaluatool.utilidades.Utilidades;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class PensamientoAnalogicoE3M2Test {

    private static final double DESVIACION = 5.25;
    private static final double MEDIA = 9.32;
    private final double pd_total;
    private final double percentil_esperado;
    private final double desviacion_esperada;
    private PensamientoAnalogicoE3M2 m1;

    public PensamientoAnalogicoE3M2Test(double pd_total, double percentil_esperado, double desviacion_esperada) {
        this.pd_total = pd_total;
        this.percentil_esperado = percentil_esperado;
        this.desviacion_esperada = desviacion_esperada;
    }

    @Parameterized.Parameters()
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {20, 99, 2.03},
                {19, 97, 1.84},
                {18, 95, 1.65},
                {17, 92, 1.46},
                {16, 87, 1.27},
                {15, 80, 1.08},
                {14, 75, 0.89},
                {13, 70, 0.7},
                {12, 65, 0.51},
                {11, 60, 0.32},
                {10, 55, 0.13},
                {9, 50, -0.06},
                {8, 45, -0.25},
                {7, 40, -0.44},
                {6, 35, -0.63},
                {5, 30, -0.82},
                {4, 25, -1.01},
                {3, 15, -1.2},
                {2, 10, -1.39},
                {1, 5, -1.58},

                //LIMITE
                {0, 5, -1.78},
                {21, 99, 2.22}
        });
    }

    @Before
    public void setUp() {
        m1 = new PensamientoAnalogicoE3M2();
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
