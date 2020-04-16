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
 Last modified 15-04-20 21:34                                                 -
 -----------------------------------------------------------------------------*/

package cl.figonzal.evaluatool.evalua1.modulo5;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import cl.figonzal.evaluatool.Utilidades;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class OrtografiaFoneticaTest {

    private static final double DESVIACION = 17.35;
    private static final double MEDIA = 54.30;
    private final double percentil_esperado;
    private final double pd_total;
    private final double desviacion_esperada;
    private OrtografiaFonetica m1;

    public OrtografiaFoneticaTest(double pd_total, double percentil_esperado,
                                  double desviacion_esperada) {
        this.percentil_esperado = percentil_esperado;
        this.pd_total = pd_total;
        this.desviacion_esperada = desviacion_esperada;
    }

    @Parameterized.Parameters()
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {84, 99, 1.71},
                {82, 95, 1.6},
                {80, 90, 1.48},
                {78, 87, 1.37},
                {76, 85, 1.25},
                {74, 82, 1.14},
                {72, 80, 1.02},
                {70, 77, 0.9},
                {68, 75, 0.79},
                {66, 70, 0.67},
                {64, 65, 0.56},
                {62, 60, 0.44},
                {60, 57, 0.33},
                {58, 55, 0.21},
                {56, 50, 0.1},
                {54, 45, -0.02},
                {52, 40, -0.13},
                {50, 37, -0.25},
                {48, 35, -0.36},
                {46, 32, -0.48},
                {44, 30, -0.59},
                {42, 27, -0.71},
                {40, 25, -0.82},
                {35, 20, -1.11},
                {30, 15, -1.4},
                {25, 10, -1.69},
                {20, 5, -1.98},

                //LIMITE
                {19, 5, -2.03},
                {84, 99, 1.71}

        });
    }

    @Before
    public void setUp() {
        m1 = new OrtografiaFonetica();
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
