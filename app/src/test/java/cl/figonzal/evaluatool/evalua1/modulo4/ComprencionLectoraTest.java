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
 Last modified 01-07-20 1:44                                                  -
 -----------------------------------------------------------------------------*/

package cl.figonzal.evaluatool.evalua1.modulo4;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import cl.figonzal.evaluatool.Utilidades;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class ComprencionLectoraTest {

    private static final double DESVIACION = 8.25;
    private static final double MEDIA = 40.23;
    private final double percentil_esperado;
    private final double pd_total;
    private final double desviacion_esperada;
    private ComprensionLectoraE1M4 m1;

    public ComprencionLectoraTest(double pd_total, double percentil_esperado,
                                  double desviacion_esperada) {
        this.percentil_esperado = percentil_esperado;
        this.pd_total = pd_total;
        this.desviacion_esperada = desviacion_esperada;
    }

    @Parameterized.Parameters()
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {49, 95, 1.06},
                {48, 85, 0.94},
                {47, 75, 0.82},
                {46, 70, 0.7},
                {45, 65, 0.58},
                {44, 60, 0.46},
                {43, 55, 0.34},
                {42, 50, 0.21},
                {41, 45, 0.09},
                {40, 42, -0.03},
                {39, 40, -0.15},
                {38, 37, -0.27},
                {37, 35, -0.39},
                {36, 32, -0.51},
                {35, 30, -0.63},
                {34, 27, -0.76},
                {33, 25, -0.88},
                {32, 20, -1.0},
                {31, 15, -1.12},
                {30, 10, -1.24},
                {25, 7, -1.85},
                {20, 5, -2.45},
                {15, 3, -3.06},
                {10, 1, -3.66},

                //LIMITE
                {9, 1, -3.79},
                {50, 95, 1.18}


        });
    }

    @Before
    public void setUp() {
        m1 = new ComprensionLectoraE1M4();
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
