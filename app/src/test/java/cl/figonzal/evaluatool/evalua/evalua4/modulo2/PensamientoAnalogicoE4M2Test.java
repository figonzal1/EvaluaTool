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

package cl.figonzal.evaluatool.evalua.evalua4.modulo2;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import cl.figonzal.evaluatool.utilidades.Utilidades;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class PensamientoAnalogicoE4M2Test {

    private static final double DESVIACION = 4.05;
    private static final double MEDIA = 13.55;
    private final double percentil_esperado;
    private final double pd_total;
    private final double desviacion_esperada;
    private PensamientoAnalogicoE4M2 m1;

    public PensamientoAnalogicoE4M2Test(double pd_total, double percentil_esperado,
                                        double desviacion_esperada) {
        this.percentil_esperado = percentil_esperado;
        this.pd_total = pd_total;
        this.desviacion_esperada = desviacion_esperada;
    }

    @Parameterized.Parameters()
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {20, 99, 1.59},
                {19, 97, 1.35},
                {18, 92, 1.1},
                {17, 80, 0.85},
                {16, 70, 0.6},
                {15, 60, 0.36},
                {14, 50, 0.11},
                {13, 40, -0.14},
                {12, 35, -0.38},
                {11, 30, -0.63},
                {10, 25, -0.88},
                {9, 20, -1.12},
                {8, 15, -1.37},
                {7, 10, -1.62},
                {6, 7, -1.86},
                {5, 5, -2.11},
                {4, 3, -2.36},
                {3, 2, -2.6},
                {2, 1, -2.85},
                {1, 1, -3.1},
        });
    }

    @Before
    public void setUp() {
        m1 = new PensamientoAnalogicoE4M2();
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