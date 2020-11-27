/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2020

 Last modified 27-11-20 1:07
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
public class OrganizacionPerceptivaE2M1Test {

    private static final double DESVIACION = 8.17;
    private static final double MEDIA = 26.64;
    private final double percentil_esperado;
    private final double pd_total;
    private final double desviacion_esperada;
    private OrganizacionPerceptivaE2M1 m1;

    public OrganizacionPerceptivaE2M1Test(double pd_total, double percentil_esperado, double desviacion_esperada) {
        this.percentil_esperado = percentil_esperado;
        this.pd_total = pd_total;
        this.desviacion_esperada = desviacion_esperada;
    }

    @Parameterized.Parameters()
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {34, 95, 0.9},
                {33, 95, 0.78},
                {32, 85, 0.66},
                {31, 85, 0.53},
                {30, 75, 0.41},
                {29, 75, 0.29},
                {28, 60, 0.17},
                {27, 60, 0.04},
                {26, 50, -0.08},
                {25, 50, -0.2},
                {24, 40, -0.32},
                {23, 40, -0.45},
                {22, 35, -0.57},
                {21, 35, -0.69},
                {20, 25, -0.81},
                {19, 25, -0.94},
                {18, 20, -1.06},
                {17, 20, -1.18},
                {16, 15, -1.3},
                {15, 15, -1.42},
                {14, 13, -1.55},
                {13, 13, -1.67},
                {12, 12, -1.79},
                {11, 12, -1.91},
                {10, 10, -2.04},
                {9, 10, -2.16},
                {8, 7, -2.28},
                {7, 7, -2.4},
                {6, 5, -2.53},
                {5, 5, -2.65},
                {4, 3, -2.77},
                {3, 3, -2.89},
                {2, 2, -3.02},
                {1, 2, -3.14},
                {0, 1, -3.26},

                {-1, 1, -3.38},
                {35, 95, 1.02}
        });
    }

    @Before
    public void setUp() {
        m1 = new OrganizacionPerceptivaE2M1();
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
