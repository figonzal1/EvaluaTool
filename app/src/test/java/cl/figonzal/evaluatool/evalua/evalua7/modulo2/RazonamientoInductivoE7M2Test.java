/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2020

 Last modified 27-11-20 1:08
 */

package cl.figonzal.evaluatool.evalua.evalua7.modulo2;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.List;

import cl.figonzal.evaluatool.utilidades.EvaluaUtils;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class RazonamientoInductivoE7M2Test {

    private static final double DESVIACION = 7.06;
    private static final double MEDIA = 19.72;
    private final double pd_total;
    private final double percentil_esperado;
    private final double desviacion_esperada;
    private RazonamientoInductivoE7M2 ri;

    public RazonamientoInductivoE7M2Test(double pd_total, double percentil_esperado,
                                         double desviacion_esperada) {
        this.pd_total = pd_total;
        this.percentil_esperado = percentil_esperado;
        this.desviacion_esperada = desviacion_esperada;
    }

    @Parameterized.Parameters()
    public static List data() {
        return Arrays.asList(new Object[][]{
                {46, 99, 3.72},
                {44, 98, 3.44},
                {42, 97, 3.16},
                {40, 96, 2.87},
                {38, 95, 2.59},
                {36, 92, 2.31},
                {34, 90, 2.02},
                {32, 85, 1.74},
                {30, 80, 1.46},
                {28, 75, 1.17},
                {26, 65, 0.89},
                {24, 60, 0.61},
                {22, 55, 0.32},
                {20, 50, 0.04},
                {18, 45, -0.24},
                {16, 40, -0.53},
                {14, 35, -0.81},
                {12, 30, -1.09},
                {10, 25, -1.38},
                {8, 20, -1.66},
                {6, 10, -1.94},
                {4, 5, -2.23},
                {2, 1, -2.51},

                //Valores limites
                {0, 1, -2.79},
                {-1, 1, -2.93}, //desviacion con pd=-2
                {-2, 1, -3.08},
                {-10, 1, -4.21},
                {47, 99, 3.86},
                {50, 99, 4.29}
        });
    }

    @Before
    public void setUp() {
        ri = new RazonamientoInductivoE7M2();
    }

    @Test
    public void testCalcularPercentil() {
        assertEquals(percentil_esperado, ri.calcularPercentil(pd_total), 0.01);
    }

    @Test
    public void testCalcularDesviacion() {
        assertEquals(desviacion_esperada, EvaluaUtils.calcularDesviacion(MEDIA, DESVIACION, pd_total, false), 0.001);
    }
}
