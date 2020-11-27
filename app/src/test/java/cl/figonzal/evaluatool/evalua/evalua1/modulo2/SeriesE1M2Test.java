/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2020

 Last modified 27-11-20 1:07
 */

package cl.figonzal.evaluatool.evalua.evalua1.modulo2;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import cl.figonzal.evaluatool.utilidades.EvaluaUtils;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class SeriesE1M2Test {

    private static final double DESVIACION = 8.00;
    private static final double MEDIA = 14.50;
    private final double percentil_esperado;
    private final double pd_total;
    private final double desviacion_esperada;
    private SeriesE1M2 m1;

    public SeriesE1M2Test(double pd_total, double percentil_esperado,
                          double desviacion_esperada) {
        this.percentil_esperado = percentil_esperado;
        this.pd_total = pd_total;
        this.desviacion_esperada = desviacion_esperada;
    }

    @Parameterized.Parameters()
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {24, 95, 1.19},
                {23, 90, 1.06},
                {22, 85, 0.94},
                {21, 80, 0.81},
                {20, 70, 0.69},
                {19, 65, 0.56},
                {18, 60, 0.44},
                {17, 55, 0.31},
                {16, 50, 0.19},
                {15, 45, 0.06},
                {14, 43, -0.06},
                {13, 40, -0.19},
                {12, 37, -0.31},
                {11, 35, -0.44},
                {10, 30, -0.56},
                {9, 25, -0.69},
                {8, 20, -0.81},
                {7, 15, -0.94},
                {6, 10, -1.06},
                {5, 7, -1.19},
                {4, 5, -1.31},
                {3, 1, -1.44},

                //LIMITE
                {2, 1, -1.56},
                {25, 95, 1.31}


        });
    }

    @Before
    public void setUp() {
        m1 = new SeriesE1M2();
    }

    @Test
    public void testCalcularPercentil() {
        assertEquals(percentil_esperado, m1.calcularPercentil(pd_total), 0.1);
    }

    @Test
    public void testCalcularDesviacion() {
        assertEquals(desviacion_esperada, EvaluaUtils.calcularDesviacion(MEDIA, DESVIACION, pd_total, false), 0.001);
    }
}
