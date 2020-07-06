/*-----------------------------------------------------------------------------
                                                                              -
 This file is subject to the terms and conditions defined in                  -
 file 'LICENSE', which is part of this source code package                    -
                                                                              -
 Autor: Felipe González                                                       -
 Email: felipe.gonzalezalarcon94@gmail.com                                    -
                                                                              -
 Copyright (c) 2020                                                           -
                                                                              -
 Last modified 05-07-20 23:54                                                 -
 -----------------------------------------------------------------------------*/

package cl.figonzal.evaluatool.evalua2.modulo3;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import cl.figonzal.evaluatool.Utilidades;
import cl.figonzal.evaluatool.evalua2.modulo3.adaptacionFragments.AutoEstimaFragmentE2M3;

import static junit.framework.TestCase.assertEquals;

@RunWith(Parameterized.class)
public class AutoEstimaE2M3Test {

    private static final double DESVIACION = 2.90;
    private static final double MEDIA = 23.07;
    private final double percentil_esperado;
    private final double pd_total;
    private final double desviacion_esperada;
    private AutoEstimaFragmentE2M3 m1;

    public AutoEstimaE2M3Test(double pd_total, double percentil_esperado, double desviacion_esperada) {
        this.percentil_esperado = percentil_esperado;
        this.pd_total = pd_total;
        this.desviacion_esperada = desviacion_esperada;
    }

    @Parameterized.Parameters()
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {30, 99, 2.39},
                {28, 90, 1.7},
                {27, 80, 1.36},
                {26, 70, 1.01},
                {25, 60, 0.67},
                {24, 50, 0.32},
                {23, 40, -0.02},
                {20, 30, -1.06},
                {15, 20, -2.78},
                {12, 10, -3.82},
                {10, 5, -4.51}
        });
    }

    @Before
    public void setUp() {
        m1 = new AutoEstimaFragmentE2M3();
    }

    @Test
    public void testCalcularPercentil() {
        assertEquals(percentil_esperado, m1.calcularPercentil(pd_total), 0.1);
    }

    @Test
    public void testCalcularDesviacion() {
        assertEquals(desviacion_esperada, Utilidades.calcularDesviacion(MEDIA, DESVIACION, pd_total, false), 0.001);
    }
}
