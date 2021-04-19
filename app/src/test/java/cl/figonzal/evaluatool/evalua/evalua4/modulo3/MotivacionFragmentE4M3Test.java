/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2021

 Last modified 17-04-21 22:25
 */

package cl.figonzal.evaluatool.evalua.evalua4.modulo3;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import cl.figonzal.evaluatool.evalua.evalua4.modulo3.adaptacionFragments.MotivacionFragmentE4M3;
import cl.figonzal.evaluatool.utilidades.Utils;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class MotivacionFragmentE4M3Test {

    private static final double DESVIACION = 3.54;
    private static final double MEDIA = 6.90;
    private final double percentil_esperado;
    private final double pd_total;
    private final double desviacion_esperada;
    private MotivacionFragmentE4M3 m1;

    public MotivacionFragmentE4M3Test(double pd_total, double percentil_esperado,
                                      double desviacion_esperada) {
        this.percentil_esperado = percentil_esperado;
        this.pd_total = pd_total;
        this.desviacion_esperada = desviacion_esperada;
    }

    @Parameterized.Parameters()
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {0, 99, 1.95},
                {1, 98, 1.67},
                {2, 95, 1.38},
                {3, 90, 1.1},
                {4, 85, 0.82},
                {5, 80, 0.54},
                {6, 70, 0.25},
                {7, 65, -0.03},
                {8, 60, -0.31},
                {9, 55, -0.59},
                {10, 50, -0.88},
                {11, 40, -1.16},
                {12, 35, -1.44},
                {13, 30, -1.72},
                {14, 25, -2.01},
                {15, 20, -2.29},
                {16, 18, -2.57},
                {17, 15, -2.85},
                {18, 12, -3.14},
                {19, 10, -3.42},
                {20, 9, -3.7},
                {22, 7, -4.27},
                {24, 5, -4.83},
                {26, 3, -5.4},
                {28, 2, -5.96},
                {30, 1, -6.53},

        });
    }

    @Before
    public void setUp() {
        m1 = new MotivacionFragmentE4M3();
    }

    @Test
    public void testCalcularPercentil() {
        assertEquals(percentil_esperado, m1.calcularPercentil(pd_total), 0.1);
    }

    @Test
    public void testCalcularDesviacion() {
        assertEquals(desviacion_esperada, Utils.calcularDesviacion(MEDIA, DESVIACION, pd_total, true), 0.001);
    }
}