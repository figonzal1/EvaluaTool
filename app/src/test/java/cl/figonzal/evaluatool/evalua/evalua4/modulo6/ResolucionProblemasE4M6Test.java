/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2021

 Last modified 17-04-21 22:25
 */

package cl.figonzal.evaluatool.evalua.evalua4.modulo6;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import cl.figonzal.evaluatool.utilidades.Utils;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class ResolucionProblemasE4M6Test {

    private static final double DESVIACION = 3.52;
    private static final double MEDIA = 8.16;
    private final double percentil_esperado;
    private final double pd_total;
    private final double desviacion_esperada;
    private ResolucionProblemasE4M6 m1;

    public ResolucionProblemasE4M6Test(double pd_total, double percentil_esperado,
                                       double desviacion_esperada) {
        this.percentil_esperado = percentil_esperado;
        this.pd_total = pd_total;
        this.desviacion_esperada = desviacion_esperada;
    }

    @Parameterized.Parameters()
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {15, 99, 1.94},
                {14, 98, 1.66},
                {13, 95, 1.38},
                {12, 85, 1.09},
                {11, 75, 0.81},
                {10, 65, 0.52},
                {9, 60, 0.24},
                {8, 50, -0.05},
                {7, 40, -0.33},
                {6, 35, -0.61},
                {5, 25, -0.9},
                {4, 20, -1.18},
                {3, 15, -1.47},
                {2, 10, -1.75},
                {1, 5, -2.03},
                {0, 3, -2.32}
        });
    }

    @Before
    public void setUp() {
        m1 = new ResolucionProblemasE4M6();
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