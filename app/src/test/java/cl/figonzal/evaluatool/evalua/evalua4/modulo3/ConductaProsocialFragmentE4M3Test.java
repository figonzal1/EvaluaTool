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

import cl.figonzal.evaluatool.evalua.evalua4.modulo3.adaptacionFragments.ConductaProSocialFragmentE4M3;
import cl.figonzal.evaluatool.utilidades.Utils;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class ConductaProsocialFragmentE4M3Test {

    private static final double DESVIACION = 2.05;
    private static final double MEDIA = 2.57;
    private final double percentil_esperado;
    private final double pd_total;
    private final double desviacion_esperada;
    private ConductaProSocialFragmentE4M3 m1;

    public ConductaProsocialFragmentE4M3Test(double pd_total, double percentil_esperado,
                                             double desviacion_esperada) {
        this.percentil_esperado = percentil_esperado;
        this.pd_total = pd_total;
        this.desviacion_esperada = desviacion_esperada;
    }

    @Parameterized.Parameters()
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {0, 94, 1.25},
                {1, 82, 0.77},
                {2, 65, 0.28},
                {3, 50, -0.21},
                {4, 40, -0.7},
                {5, 35, -1.19},
                {6, 30, -1.67},
                {7, 20, -2.16},
                {8, 15, -2.65},
                {9, 12, -3.14},
                {10, 10, -3.62},
                {11, 9, -4.11},
                {12, 7, -4.6},
                {13, 5, -5.09},
                {14, 3, -5.58},
                {15, 1, -6.06},
                {16, 1, -6.55},
                {17, 1, -7.04},
                {18, 1, -7.53},
                {19, 1, -8.01},
                {20, 1, -8.5},
                {22, 1, -9.48},
                {24, 1, -10.45},
                {26, 1, -11.43},
                {28, 1, -12.4},
                {30, 1, -13.38}
        });
    }

    @Before
    public void setUp() {
        m1 = new ConductaProSocialFragmentE4M3();
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