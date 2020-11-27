/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2020

 Last modified 27-11-20 1:07
 */

package cl.figonzal.evaluatool.evalua.evalua0.modulo2;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import cl.figonzal.evaluatool.utilidades.EvaluaUtils;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class GrafoMotricidadE0M2Test {

    private static final double DESVIACION = 7.29;
    private static final double MEDIA = 32.08;
    private final double percentil_esperado;
    private final double pd_total;
    private final double desviacion_esperada;
    private GrafoMotricidadE0M2 m1;

    public GrafoMotricidadE0M2Test(double pd_total, double percentil_esperado,
                                   double desviacion_esperada) {
        this.percentil_esperado = percentil_esperado;
        this.pd_total = pd_total;
        this.desviacion_esperada = desviacion_esperada;
    }

    @Parameterized.Parameters()
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {48, 99, 2.18},
                {47, 99, 2.05},
                {46, 99, 1.91},
                {45, 95, 1.77},
                {44, 95, 1.64},
                {43, 95, 1.50},
                {42, 90, 1.36},
                {41, 90, 1.22},
                {40, 85, 1.09},
                {39, 85, 0.95},
                {38, 80, 0.81},
                {37, 80, 0.67},
                {36, 75, 0.54},
                {35, 75, 0.40},
                {34, 65, 0.26},
                {33, 65, 0.13},
                {32, 55, -0.01},
                {31, 50, -0.15},
                {30, 40, -0.29},
                {29, 30, -0.42},
                {28, 30, -0.56},
                {27, 25, -0.70},
                {26, 20, -0.83},
                {25, 15, -0.97},
                {24, 10, -1.11},
                {23, 9, -1.25},
                {22, 7, -1.38},
                {21, 5, -1.52},
                {20, 3, -1.66},
                {19, 2, -1.79},
                {18, 1, -1.93},
                {16, 1, -2.21},

                //LIMITE
                {15, 1, -2.34},
                {49, 99, 2.32}
        });
    }

    @Before
    public void setUp() {
        m1 = new GrafoMotricidadE0M2();
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
