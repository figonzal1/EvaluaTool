/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2020

 Last modified 27-11-20 1:07
 */

package cl.figonzal.evaluatool.evalua.evalua2.modulo5;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import cl.figonzal.evaluatool.utilidades.EvaluaUtils;

import static junit.framework.TestCase.assertEquals;

@RunWith(Parameterized.class)
public class OrtografiaE2M5Test {


    private static final double DESVIACION = 9.463;
    private static final double MEDIA = 31.42;
    private final double percentil_esperado;
    private final double pd_total;
    private final double desviacion_esperada;
    private OrtografiaE2M5 m1;

    public OrtografiaE2M5Test(double pd_total, double percentil_esperado, double desviacion_esperada) {
        this.percentil_esperado = percentil_esperado;
        this.pd_total = pd_total;
        this.desviacion_esperada = desviacion_esperada;
    }

    @Parameterized.Parameters()
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {43, 99, 1.22},
                {42, 95, 1.12},
                {41, 90, 1.01},
                {40, 85, 0.91},
                {38, 80, 0.7},
                {36, 75, 0.48},
                {35, 70, 0.38},
                {34, 65, 0.27},
                {33, 60, 0.17},
                {32, 55, 0.06},
                {31, 50, -0.04},
                {30, 45, -0.15},
                {29, 40, -0.26},
                {28, 35, -0.36},
                {27, 30, -0.47},
                {25, 25, -0.68},
                {22, 20, -1.0},
                {20, 15, -1.21},
                {18, 10, -1.42},
                {14, 5, -1.84},
                {13, 1, -1.95}
        });
    }

    @Before
    public void setUp() {
        m1 = new OrtografiaE2M5();
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
