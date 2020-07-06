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
import cl.figonzal.evaluatool.evalua2.modulo3.adaptacionFragments.AutoControlFragmentE2M3;

import static junit.framework.TestCase.assertEquals;

@RunWith(Parameterized.class)
public class AutoControlE2M3Test {

    private static final double DESVIACION = 3.53;
    private static final double MEDIA = 23.17;
    private final double percentil_esperado;
    private final double pd_total;
    private final double desviacion_esperada;
    private AutoControlFragmentE2M3 m1;

    public AutoControlE2M3Test(double pd_total, double percentil_esperado, double desviacion_esperada) {
        this.percentil_esperado = percentil_esperado;
        this.pd_total = pd_total;
        this.desviacion_esperada = desviacion_esperada;
    }

    @Parameterized.Parameters()
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {30, 99, 1.93},
                {28, 90, 1.37},
                {26, 80, 0.8},
                {25, 70, 0.52},
                {24, 60, 0.24},
                {23, 50, -0.05},
                {22, 40, -0.33},
                {20, 30, -0.9},
                {16, 20, -2.03},
                {14, 10, -2.6},
                {12, 5, -3.16},
        });
    }

    @Before
    public void setUp() {
        m1 = new AutoControlFragmentE2M3();
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
