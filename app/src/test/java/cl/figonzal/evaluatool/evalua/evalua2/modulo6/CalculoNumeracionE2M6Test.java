/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2021

 Last modified 17-04-21 22:25
 */

package cl.figonzal.evaluatool.evalua.evalua2.modulo6;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import cl.figonzal.evaluatool.utilidades.Utils;

import static junit.framework.TestCase.assertEquals;

@RunWith(Parameterized.class)
public class CalculoNumeracionE2M6Test {

    private static final double DESVIACION = 11.77;
    private static final double MEDIA = 35.29;
    private final double percentil_esperado;
    private final double pd_total;
    private final double desviacion_esperada;
    private CalculoNumeracionE2M6 m1;

    public CalculoNumeracionE2M6Test(double pd_total, double percentil_esperado, double desviacion_esperada) {
        this.percentil_esperado = percentil_esperado;
        this.pd_total = pd_total;
        this.desviacion_esperada = desviacion_esperada;
    }

    @Parameterized.Parameters()
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {55, 99, 1.67},
                {53, 98, 1.5},
                {52, 97, 1.42},
                {51, 95, 1.33},
                {50, 92, 1.25},
                {49, 90, 1.16},
                {48, 85, 1.08},
                {47, 80, 0.99},
                {45, 75, 0.82},
                {43, 70, 0.66},
                {41, 65, 0.49},
                {39, 60, 0.32},
                {38, 55, 0.23},
                {36, 50, 0.06},
                {35, 45, -0.02},
                {33, 40, -0.19},
                {30, 35, -0.45},
                {25, 25, -0.87},
                {20, 20, -1.3},
                {10, 10, -2.15},
                {8, 5, -2.32},
                {3, 1, -2.74}
        });
    }

    @Before
    public void setUp() {
        m1 = new CalculoNumeracionE2M6();
    }

    @Test
    public void testCalcularPercentil() {
        assertEquals(percentil_esperado, m1.calcularPercentil(pd_total), 0.1);
    }

    @Test
    public void testCalcularDesviacion() {
        assertEquals(desviacion_esperada, Utils.calcularDesviacion(MEDIA, DESVIACION, pd_total, false), 0.001);
    }
}
