/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2020

 Last modified 27-11-20 1:08
 */

package cl.figonzal.evaluatool.evalua.evalua2.modulo1;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import cl.figonzal.evaluatool.utilidades.EvaluaUtils;

import static junit.framework.TestCase.assertEquals;

@RunWith(Parameterized.class)
public class ClasificacionesE2M1Test {

    private static final double DESVIACION = 6.97;
    private static final double MEDIA = 19.18;
    private final double percentil_esperado;
    private final double pd_total;
    private final double desviacion_esperada;
    private ClasificacionesE2M1 m1;

    public ClasificacionesE2M1Test(double pd_total, double percentil_esperado, double desviacion_esperada) {
        this.percentil_esperado = percentil_esperado;
        this.pd_total = pd_total;
        this.desviacion_esperada = desviacion_esperada;
    }

    @Parameterized.Parameters()
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {29, 99, 1.41},
                {28, 98, 1.27},
                {27, 95, 1.12},
                {26, 90, 0.98},
                {25, 85, 0.84},
                {24, 75, 0.69},
                {23, 70, 0.55},
                {22, 60, 0.4},
                {21, 55, 0.26},
                {20, 50, 0.12},
                {19, 45, -0.03},
                {18, 40, -0.17},
                {17, 35, -0.31},
                {16, 30, -0.46},
                {15, 27, -0.6},
                {14, 25, -0.74},
                {13, 22, -0.89},
                {12, 20, -1.03},
                {11, 15, -1.17},
                {10, 12, -1.32},
                {9, 10, -1.46},
                {8, 7, -1.6},
                {7, 5, -1.75},
                {6, 3, -1.89},

                {30, 99, 1.55},
                {0, 3, -2.75}
        });
    }

    @Before
    public void setUp() {
        m1 = new ClasificacionesE2M1();
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
