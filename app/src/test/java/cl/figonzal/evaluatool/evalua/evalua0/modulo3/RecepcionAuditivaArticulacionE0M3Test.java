/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2021

 Last modified 17-04-21 22:25
 */

package cl.figonzal.evaluatool.evalua.evalua0.modulo3;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import cl.figonzal.evaluatool.utilidades.Utils;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class RecepcionAuditivaArticulacionE0M3Test {

    private static final double DESVIACION = 9.01;
    private static final double MEDIA = 84.81;
    private final double percentil_esperado;
    private final double pd_total;
    private final double desviacion_esperada;
    private RecepcionAuditivaArticulacionE0M3 m1;

    public RecepcionAuditivaArticulacionE0M3Test(double pd_total, double percentil_esperado,
                                                 double desviacion_esperada) {
        this.percentil_esperado = percentil_esperado;
        this.pd_total = pd_total;
        this.desviacion_esperada = desviacion_esperada;
    }

    @Parameterized.Parameters()
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {102, 99, 1.91},
                {101, 98, 1.80},
                {100, 97, 1.69},
                {99, 96, 1.57},
                {98, 95, 1.46},
                {97, 90, 1.35},
                {96, 85, 1.24},
                {95, 75, 1.13},
                {93, 65, 0.91},
                {91, 60, 0.69},
                {89, 55, 0.47},
                {86, 50, 0.13},
                {83, 45, -0.20},
                {80, 40, -0.53},
                {77, 35, -0.87},
                {74, 30, -1.20},
                {71, 20, -1.53},
                {69, 15, -1.75},
                {65, 10, -2.20},
                {60, 5, -2.75},


                //LIMITES
                {59, 5, -2.86},
                {103, 99, 2.02}

        });
    }

    @Before
    public void setUp() {
        m1 = new RecepcionAuditivaArticulacionE0M3();
    }

    @Test
    public void testCalcularPercentil() {
        assertEquals(percentil_esperado, m1.calcularPercentil(pd_total), 0.1);
    }

    @Test
    public void testCalcularDesviacion() {
        assertEquals(desviacion_esperada, Utils.calcularDesviacion(MEDIA, DESVIACION, pd_total, false), 0.001);
    }
}
