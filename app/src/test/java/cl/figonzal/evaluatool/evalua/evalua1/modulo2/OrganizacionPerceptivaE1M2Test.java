/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2020

 Last modified 27-11-20 1:08
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
public class OrganizacionPerceptivaE1M2Test {

    private static final double DESVIACION = 11.36;
    private static final double MEDIA = 38.01;
    private final double percentil_esperado;
    private final double pd_total;
    private final double desviacion_esperada;
    private OrganizacionPerceptivaE1M2 m1;

    public OrganizacionPerceptivaE1M2Test(double pd_total, double percentil_esperado,
                                          double desviacion_esperada) {
        this.percentil_esperado = percentil_esperado;
        this.pd_total = pd_total;
        this.desviacion_esperada = desviacion_esperada;
    }

    @Parameterized.Parameters()
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {52, 99, 1.23},
                {51, 95, 1.14},
                {50, 92, 1.06},
                {49, 90, 0.97},
                {48, 85, 0.88},
                {47, 80, 0.79},
                {46, 75, 0.7},
                {45, 70, 0.62},
                {44, 67, 0.53},
                {43, 62, 0.44},
                {42, 60, 0.35},
                {41, 57, 0.26},
                {40, 55, 0.18},
                {39, 52, 0.09},
                {38, 50, 0},
                {37, 45, -0.09},
                {36, 42, -0.18},
                {35, 40, -0.26},
                {34, 37, -0.35},
                {33, 35, -0.44},
                {32, 32, -0.53},
                {29, 30, -0.79},
                {26, 25, -1.06},
                {23, 20, -1.32},
                {20, 15, -1.59},
                {17, 10, -1.85},
                {14, 7, -2.11},
                {11, 5, -2.38},
                {8, 1, -2.64},


                //LIMITES
                {7, 1, -2.73},
                {53, 99, 1.32}

        });
    }

    @Before
    public void setUp() {
        m1 = new OrganizacionPerceptivaE1M2();
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
