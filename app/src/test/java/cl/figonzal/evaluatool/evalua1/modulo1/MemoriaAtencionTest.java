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
 Last modified 15-04-20 21:16                                                 -
 -----------------------------------------------------------------------------*/

package cl.figonzal.evaluatool.evalua1.modulo1;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import cl.figonzal.evaluatool.Utilidades;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class MemoriaAtencionTest {

    private static final double DESVIACION = 12.90;
    private static final double MEDIA = 49.39;
    private final double percentil_esperado;
    private final double pd_total;
    private final double desviacion_esperada;
    private MemoriaAtencion m1;

    public MemoriaAtencionTest(double pd_total, double percentil_esperado,
                               double desviacion_esperada) {
        this.percentil_esperado = percentil_esperado;
        this.pd_total = pd_total;
        this.desviacion_esperada = desviacion_esperada;
    }

    @Parameterized.Parameters()
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {68, 99, 1.44},
                {67, 97, 1.37},
                {66, 95, 1.29},
                {65, 93, 1.21},
                {64, 90, 1.13},
                {63, 87, 1.06},
                {62, 85, 0.98},
                {61, 80, 0.9},
                {60, 75, 0.82},
                {59, 72, 0.74},
                {58, 70, 0.67},
                {57, 65, 0.59},
                {56, 62, 0.51},
                {55, 60, 0.43},
                {54, 57, 0.36},
                {53, 55, 0.28},
                {52, 52, 0.2},
                {51, 50, 0.12},
                {50, 47, 0.05},
                {49, 45, -0.03},
                {48, 43, -0.11},
                {47, 40, -0.19},
                {46, 37, -0.26},
                {45, 35, -0.34},
                {44, 32, -0.42},
                {43, 30, -0.5},
                {40, 25, -0.73},
                {37, 20, -0.96},
                {34, 15, -1.19},
                {31, 10, -1.43},
                {28, 7, -1.66},
                {25, 5, -1.89},
                {22, 1, -2.12},


                //LIMITES
                {21, 1, -2.2},
                {69, 99, 1.52}

        });
    }

    @Before
    public void setUp() {
        m1 = new MemoriaAtencion();
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
