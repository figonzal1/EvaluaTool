/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2020

 Last modified 27-11-20 1:08
 */

package cl.figonzal.evaluatool.evalua.evalua2.modulo3;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import cl.figonzal.evaluatool.evalua.evalua2.modulo3.adaptacionFragments.ConductaProSocialFragmentE2M3;
import cl.figonzal.evaluatool.utilidades.EvaluaUtils;

import static junit.framework.TestCase.assertEquals;

@RunWith(Parameterized.class)
public class ConductaSocialE2M3Test {

    private static final double DESVIACION = 3.69;
    private static final double MEDIA = 26.12;
    private final double percentil_esperado;
    private final double pd_total;
    private final double desviacion_esperada;
    private ConductaProSocialFragmentE2M3 m1;

    public ConductaSocialE2M3Test(double pd_total, double percentil_esperado, double desviacion_esperada) {
        this.percentil_esperado = percentil_esperado;
        this.pd_total = pd_total;
        this.desviacion_esperada = desviacion_esperada;
    }

    @Parameterized.Parameters()
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {30, 99, 1.05},
                {29, 90, 0.78},
                {28, 80, 0.51},
                {27, 70, 0.24},
                {26, 60, -0.03},
                {25, 50, -0.3},
                {24, 40, -0.57},
                {22, 30, -1.12},
                {21, 20, -1.39},
                {20, 10, -1.66},
                {15, 5, -3.01}
        });
    }

    @Before
    public void setUp() {
        m1 = new ConductaProSocialFragmentE2M3();
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
