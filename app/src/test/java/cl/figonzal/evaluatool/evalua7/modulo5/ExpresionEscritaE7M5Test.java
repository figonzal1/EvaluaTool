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
 Last modified 01-07-20 18:39                                                 -
 -----------------------------------------------------------------------------*/

package cl.figonzal.evaluatool.evalua7.modulo5;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import cl.figonzal.evaluatool.Utilidades;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class ExpresionEscritaE7M5Test {

    private static final double DESVIACION = 0.843;
    private static final double MEDIA = 2.45;
    private final double pd_total;
    private final double precentil_esperado;
    private final double desviacion_esperada;
    private ExpresionEscritaE7M5 ee;

    public ExpresionEscritaE7M5Test(double pd_total, double precentil_esperado,
                                    double desviacion_esperada) {
        this.pd_total = pd_total;
        this.precentil_esperado = precentil_esperado;
        this.desviacion_esperada = desviacion_esperada;
    }

    @Parameterized.Parameters()
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {5, 10, -3.02},
                {4, 30, -1.84},
                {3, 50, -0.65},
                {2, 70, 0.53},
                {1, 90, 1.72},

                //Valores limite
                {0, 90, 2.91},
                {6, 10, -4.21}
        });
    }

    @Before
    public void setUp() {
        ee = new ExpresionEscritaE7M5();
    }

    @Test
    public void testCalcularPercentil() {
        assertEquals(precentil_esperado, ee.calcularPercentil(pd_total), 0.01);
    }

    @Test
    public void testCalcularDesviacion() {
        assertEquals(desviacion_esperada, Utilidades.calcularDesviacion(MEDIA, DESVIACION, pd_total, true), 0.01);
    }
}
