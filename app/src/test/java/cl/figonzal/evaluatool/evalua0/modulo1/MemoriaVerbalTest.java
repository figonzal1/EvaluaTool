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
 Last modified 15-04-20 20:11                                                 -
 -----------------------------------------------------------------------------*/

package cl.figonzal.evaluatool.evalua0.modulo1;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import cl.figonzal.evaluatool.Utilidades;

import static junit.framework.TestCase.assertEquals;

@RunWith(Parameterized.class)
public class MemoriaVerbalTest {

    private static final double DESVIACION = 6.72;
    private static final double MEDIA = 22.02;

    private final double percentil_esperado;
    private final double pd_total;
    private final double desviacion_esperada;
    private MemoriaVerbal m1;

    public MemoriaVerbalTest(double pd_total, double percentil_esperado,
                             double desviacion_esperada) {
        this.percentil_esperado = percentil_esperado;
        this.pd_total = pd_total;
        this.desviacion_esperada = desviacion_esperada;
    }

    @Parameterized.Parameters()
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {35, 99, 1.93},
                {34, 99, 1.78},
                {33, 95, 1.63},
                {32, 95, 1.49},
                {31, 92, 1.34},
                {30, 90, 1.19},
                {29, 85, 1.04},
                {27, 80, 0.74},
                {25, 70, 0.44},
                {23, 55, 0.15},
                {21, 50, -0.15},
                {19, 40, -0.45},
                {18, 35, -0.60},
                {17, 30, -0.75},
                {15, 20, -1.04},
                {14, 15, -1.19},
                {12, 10, -1.49},
                {11, 7, -1.64},
                {10, 5, -1.79},
                {9, 3, -1.94},
                {8, 2, -2.09},
                {7, 1, -2.24},

                //Limites
                {0, 1, -3.28},
                {6, 1, -2.38},
                {36, 99, 2.08}


        });
    }

    @Before
    public void setUp() {
        m1 = new MemoriaVerbal();
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
