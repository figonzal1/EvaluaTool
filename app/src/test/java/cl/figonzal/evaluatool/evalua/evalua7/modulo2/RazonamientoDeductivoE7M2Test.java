/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2020

 Last modified 27-11-20 1:07
 */

package cl.figonzal.evaluatool.evalua.evalua7.modulo2;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import cl.figonzal.evaluatool.utilidades.EvaluaUtils;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class RazonamientoDeductivoE7M2Test {

    private static final double DESVIACION = 6.05;
    private static final double MEDIA = 12.51;
    private final double percentil_esperado;
    private final double pd_total;
    private final double desviacion_esperada;
    private RazonamientoDeductivoE7M2 rd;

    public RazonamientoDeductivoE7M2Test(double pd_total, double percentil_esperado,
                                         double desviacion_esperada) {
        this.percentil_esperado = percentil_esperado;
        this.pd_total = pd_total;
        this.desviacion_esperada = desviacion_esperada;
    }

    //PD,PC Chile, Desviacion esperada
    @Parameterized.Parameters()
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {26, 99, 2.23},
                {25, 97, 2.06},
                {24, 95, 1.90},
                {23, 90, 1.73},
                {22, 85, 1.57},
                {21, 80, 1.40},
                {20, 75, 1.24},
                {19, 70, 1.07},
                {18, 65, 0.91},
                {17, 62, 0.74},
                {16, 60, 0.58},
                {15, 57, 0.41},
                {14, 55, 0.25},
                {13, 50, 0.08},
                {12, 40, -0.08},
                {11, 30, -0.25},
                {10, 25, -0.41},
                {9, 20, -0.58},
                {8, 15, -0.75},
                {7, 12, -0.91},
                {6, 10, -1.08},
                {5, 7, -1.24},
                {4, 5, -1.41},
                {3, 3, -1.57},
                {2, 2, -1.74},
                {1, 1, -1.90},

                //Valores Limite
                {0, 1, -2.07},
                {-1, 1, -2.23},
                {-6, 1, -3.06},
                {27, 99, 2.40}
        });
    }

    @Before
    public void setUp() {
        rd = new RazonamientoDeductivoE7M2();
    }

    @Test
    public void testCalcularPercentil() {
        assertEquals(percentil_esperado, rd.calcularPercentil(pd_total), 0.01);
    }

    @Test
    public void testCalcularDesviacion() {
        assertEquals(desviacion_esperada, EvaluaUtils.calcularDesviacion(MEDIA, DESVIACION, pd_total, false), 0.001);
    }
}
