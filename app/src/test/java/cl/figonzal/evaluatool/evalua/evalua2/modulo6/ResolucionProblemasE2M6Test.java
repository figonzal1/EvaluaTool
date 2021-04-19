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
public class ResolucionProblemasE2M6Test {

    private static final double DESVIACION = 3.38;
    private static final double MEDIA = 8.39;
    private final double percentil_esperado;
    private final double pd_total;
    private final double desviacion_esperada;
    private ResolucionProblemasE2M6 m1;

    public ResolucionProblemasE2M6Test(double pd_total, double percentil_esperado, double desviacion_esperada) {
        this.percentil_esperado = percentil_esperado;
        this.pd_total = pd_total;
        this.desviacion_esperada = desviacion_esperada;
    }

    @Parameterized.Parameters()
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {14, 99, 1.66},
                {13, 95, 1.36},
                {12, 85, 1.07},
                {11, 75, 0.77},
                {10, 65, 0.48},
                {9, 55, 0.18},
                {8, 45, -0.12},
                {7, 35, -0.41},
                {6, 25, -0.71},
                {5, 20, -1.0},
                {4, 10, -1.3},
                {3, 5, -1.59},
                {2, 1, -1.89}

        });
    }

    @Before
    public void setUp() {
        m1 = new ResolucionProblemasE2M6();
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
