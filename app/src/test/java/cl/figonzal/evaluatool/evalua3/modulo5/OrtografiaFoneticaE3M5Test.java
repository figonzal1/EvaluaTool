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
 Last modified 01-07-20 17:16                                                 -
 -----------------------------------------------------------------------------*/

package cl.figonzal.evaluatool.evalua3.modulo5;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import cl.figonzal.evaluatool.Utilidades;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class OrtografiaFoneticaE3M5Test {

    private static final double DESVIACION = 6.84;
    private static final double MEDIA = 67.51;

    private final double pd_total;
    private final double percentil_esperado;
    private final double desviacion_esperada;
    private OrtografiaFoneticaE3M5 m1;

    public OrtografiaFoneticaE3M5Test(double pd_total, double percentil_esperado, double desviacion_esperada) {
        this.pd_total = pd_total;
        this.percentil_esperado = percentil_esperado;
        this.desviacion_esperada = desviacion_esperada;
    }

    @Parameterized.Parameters()
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {79, 99, 1.68},
                {78, 97, 1.53},
                {77, 95, 1.39},
                {76, 90, 1.24},
                {75, 85, 1.1},
                {74, 80, 0.95},
                {73, 75, 0.8},
                {72, 70, 0.66},
                {71, 67, 0.51},
                {70, 62, 0.36},
                {69, 60, 0.22},
                {68, 55, 0.07},
                {67, 50, -0.07},
                {66, 40, -0.22},
                {65, 35, -0.37},
                {64, 30, -0.51},
                {63, 25, -0.66},
                {62, 20, -0.81},
                {61, 15, -0.95},
                {60, 12, -1.1},
                {59, 10, -1.24},
                {58, 9, -1.39},
                {57, 8, -1.54},
                {56, 7, -1.68},
                {55, 6, -1.83},
                {54, 5, -1.98},
                {53, 3, -2.12},
                {52, 1, -2.27},

                //LIMITE
                {51, 1, -2.41},
                {80, 99, 1.83}


        });
    }

    @Before
    public void setUp() {
        m1 = new OrtografiaFoneticaE3M5();
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
