/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2020

 Last modified 27-11-20 1:08
 */

package cl.figonzal.evaluatool.evalua.evalua2.modulo4;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import cl.figonzal.evaluatool.utilidades.EvaluaUtils;

import static junit.framework.TestCase.assertEquals;

@RunWith(Parameterized.class)
public class ComprensionLectoraE2M4Test {

    private static final double DESVIACION = 5.68;
    private static final double MEDIA = 12.27;
    private final double percentil_esperado;
    private final double pd_total;
    private final double desviacion_esperada;
    private ComprensionLectoraE2M4 m1;

    public ComprensionLectoraE2M4Test(double pd_total, double percentil_esperado, double desviacion_esperada) {
        this.percentil_esperado = percentil_esperado;
        this.pd_total = pd_total;
        this.desviacion_esperada = desviacion_esperada;
    }

    @Parameterized.Parameters()
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {25, 99, 2.24},
                {24, 98, 2.07},
                {23, 97, 1.89},
                {22, 96, 1.71},
                {21, 95, 1.54},
                {20, 93, 1.36},
                {19, 92, 1.18},
                {18, 90, 1.01},
                {17, 85, 0.83},
                {16, 80, 0.66},
                {15, 70, 0.48},
                {14, 65, 0.3},
                {13, 60, 0.13},
                {12, 50, -0.05},
                {11, 45, -0.22},
                {10, 40, -0.4},
                {9, 35, -0.58},
                {8, 30, -0.75},
                {7, 25, -0.93},
                {6, 20, -1.1},
                {5, 15, -1.28},
                {4, 10, -1.46},
                {3, 7, -1.63},
                {2, 5, -1.81},
                {1, 1, -1.98}
        });
    }

    @Before
    public void setUp() {
        m1 = new ComprensionLectoraE2M4();
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
