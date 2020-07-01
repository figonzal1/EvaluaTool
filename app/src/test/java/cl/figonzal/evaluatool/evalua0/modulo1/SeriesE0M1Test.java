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
 Last modified 01-07-20 0:05                                                  -
 -----------------------------------------------------------------------------*/

package cl.figonzal.evaluatool.evalua0.modulo1;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import cl.figonzal.evaluatool.Utilidades;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class SeriesE0M1Test {

    private static final double DESVIACION = 9.68;
    private static final double MEDIA = 37.7;
    private final double percentil_esperado;
    private final double pd_total;
    private final double desviacion_esperada;
    private SeriesE0M1 m1;

    public SeriesE0M1Test(double pd_total, double percentil_esperado,
                          double desviacion_esperada) {
        this.percentil_esperado = percentil_esperado;
        this.pd_total = pd_total;
        this.desviacion_esperada = desviacion_esperada;
    }

    @Parameterized.Parameters()
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {48, 95, 1.06},
                {47, 90, 0.96},
                {46, 85, 0.86},
                {44, 80, 0.65},
                {42, 70, 0.44},
                {40, 60, 0.24},
                {38, 50, 0.03},
                {36, 45, -0.18},
                {34, 35, -0.38},
                {32, 30, -0.59},
                {30, 25, -0.80},
                {28, 20, -1.00},
                {26, 15, -1.21},
                {24, 12, -1.42},
                {22, 10, -1.62},
                {20, 9, -1.83},
                {18, 7, -2.04},
                {16, 5, -2.24},
                {14, 3, -2.45},
                {10, 1, -2.86},

                //LIMITES
                {9, 1, -2.96},
                {49, 95, 1.17}
        });
    }

    @Before
    public void setUp() {
        m1 = new SeriesE0M1();
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
