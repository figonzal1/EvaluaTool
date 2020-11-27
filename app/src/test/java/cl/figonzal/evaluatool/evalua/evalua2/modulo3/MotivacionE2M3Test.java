/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2020

 Last modified 27-11-20 1:07
 */

package cl.figonzal.evaluatool.evalua.evalua2.modulo3;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import cl.figonzal.evaluatool.evalua.evalua2.modulo3.adaptacionFragments.MotivacionFragmentE2M3;
import cl.figonzal.evaluatool.utilidades.EvaluaUtils;

import static junit.framework.TestCase.assertEquals;

@RunWith(Parameterized.class)
public class MotivacionE2M3Test {

    private static final double DESVIACION = 4.44;
    private static final double MEDIA = 34.65;
    private final double percentil_esperado;
    private final double pd_total;
    private final double desviacion_esperada;
    private MotivacionFragmentE2M3 m1;

    public MotivacionE2M3Test(double pd_total, double percentil_esperado, double desviacion_esperada) {
        this.percentil_esperado = percentil_esperado;
        this.pd_total = pd_total;
        this.desviacion_esperada = desviacion_esperada;
    }

    @Parameterized.Parameters()
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {40, 99, 1.2},
                {39, 90, 0.98},
                {38, 80, 0.75},
                {37, 70, 0.53},
                {35, 60, 0.08},
                {32, 50, -0.6},
                {30, 40, -1.05},
                {29, 30, -1.27},
                {27, 20, -1.72},
                {25, 10, -2.17},
                {22, 5, -2.85}
        });
    }

    @Before
    public void setUp() {
        m1 = new MotivacionFragmentE2M3();
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
