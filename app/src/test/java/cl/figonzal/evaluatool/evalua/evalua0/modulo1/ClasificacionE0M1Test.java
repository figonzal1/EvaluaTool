/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2020

 Last modified 27-11-20 1:08
 */

package cl.figonzal.evaluatool.evalua.evalua0.modulo1;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import cl.figonzal.evaluatool.utilidades.EvaluaUtils;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class ClasificacionE0M1Test {


    private static final double DESVIACION = 3.00;
    private static final double MEDIA = 12.93;
    private final double percentil_esperado;
    private final double pd_total;
    private final double desviacion_esperada;
    private ClasificacionE0M1 m1;

    public ClasificacionE0M1Test(double pd_total, double percentil_esperado,
                                 double desviacion_esperada) {
        this.percentil_esperado = percentil_esperado;
        this.pd_total = pd_total;
        this.desviacion_esperada = desviacion_esperada;
    }

    @Parameterized.Parameters()
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {18, 99, 1.69},
                {17, 95, 1.36},
                {16, 85, 1.02},
                {15, 75, 0.69},
                {14, 60, 0.36},
                {13, 50, 0.02},
                {12, 40, -0.31},
                {11, 30, -0.64},
                {10, 20, -0.98},
                {9, 10, -1.31},
                {8, 8, -1.64},
                {7, 6, -1.98},
                {6, 4, -2.31},
                {5, 2, -2.64},
                {4, 1, -2.98},
                {3, 1, -3.31},

                //LIMITES
                {25, 99, 4.02},
                {2, 1, -3.64}
        });
    }

    @Before
    public void setUp() {
        m1 = new ClasificacionE0M1();
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
