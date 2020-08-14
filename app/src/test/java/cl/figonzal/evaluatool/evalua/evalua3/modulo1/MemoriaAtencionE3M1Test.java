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
 Last modified 14-08-20 1:02                                                  -
 -----------------------------------------------------------------------------*/

package cl.figonzal.evaluatool.evalua.evalua3.modulo1;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import cl.figonzal.evaluatool.utilidades.Utilidades;

import static junit.framework.TestCase.assertEquals;

@RunWith(Parameterized.class)
public class MemoriaAtencionE3M1Test {
    private static final double DESVIACION = 18.78;
    private static final double MEDIA = 84.36;
    private final double percentil_esperado;
    private final double pd_total;
    private final double desviacion_esperada;
    private MemoriaAtencionE3M1 m1;

    public MemoriaAtencionE3M1Test(double pd_total, double percentil_esperado, double desviacion_esperada) {
        this.percentil_esperado = percentil_esperado;
        this.pd_total = pd_total;
        this.desviacion_esperada = desviacion_esperada;
    }

    @Parameterized.Parameters()
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {125, 99, 2.16},
                {122, 97, 2.00},
                {119, 95, 1.84},
                {116, 93, 1.68},
                {113, 90, 1.53},
                {110, 87, 1.37},
                {107, 85, 1.21},
                {104, 80, 1.05},
                {101, 75, 0.89},
                {98, 70, 0.73},
                {95, 67, 0.57},
                {92, 62, 0.41},
                {89, 60, 0.25},
                {86, 55, 0.09},
                {83, 50, -0.07},
                {80, 45, -0.23},
                {77, 42, -0.39},
                {74, 40, -0.55},
                {71, 35, -0.71},
                {68, 30, -0.87},
                {65, 25, -1.03},
                {62, 20, -1.19},
                {59, 17, -1.35},
                {56, 15, -1.51},
                {53, 12, -1.67},
                {50, 10, -1.83},
                {47, 7, -1.99},
                {44, 5, -2.15},
                {41, 3, -2.31},

                //LIMITE
                {40, 3, -2.36},
                {126, 99, 2.22}
        });
    }

    @Before
    public void setUp() {
        m1 = new MemoriaAtencionE3M1();
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
