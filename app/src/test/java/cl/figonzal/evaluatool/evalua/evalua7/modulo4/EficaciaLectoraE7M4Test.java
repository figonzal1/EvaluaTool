/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2021

 Last modified 17-04-21 22:25
 */

package cl.figonzal.evaluatool.evalua.evalua7.modulo4;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.List;

import cl.figonzal.evaluatool.utilidades.Utils;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class EficaciaLectoraE7M4Test {

    private static final double DESVIACION = 5.23;
    private static final double MEDIA = 15.52;
    private final double pd_total;
    private final double percentil_esperado;
    private final double desviacion_esperada;
    private EficaciaLectoraE7M4 el;

    public EficaciaLectoraE7M4Test(double pd_total, double percentil_esperado,
                                   double desviacion_esperada) {
        this.pd_total = pd_total;
        this.percentil_esperado = percentil_esperado;
        this.desviacion_esperada = desviacion_esperada;
    }

    @Parameterized.Parameters()
    public static List data() {
        return Arrays.asList(new Object[][]{
                {23, 99, 1.43},
                {22, 90, 1.24},
                {21, 85, 1.05},
                {20, 80, 0.86},
                {19, 70, 0.67},
                {18, 60, 0.47},
                {17, 55, 0.28},
                {16, 50, 0.09},
                {15, 45, -0.10},
                {14, 40, -0.29},
                {13, 35, -0.48},
                {12, 30, -0.67},
                {11, 25, -0.86},
                {10, 22, -1.06},
                {9, 20, -1.25},
                {8, 18, -1.44},
                {7, 15, -1.63},
                {6, 12, -1.82},
                {5, 10, -2.01},
                {4, 7, -2.20},
                {3, 5, -2.39},
                {2, 3, -2.59},
                {1, 1, -2.78},

                //Valores limite
                {0, 1, -2.97},
                {-1, 1, -3.16},
                {26, 99, 2.00}
        });
    }

    @Before
    public void setUp() {
        el = new EficaciaLectoraE7M4();
    }

    @Test
    public void testCalcularPercentil() {
        assertEquals(percentil_esperado, el.calcularPercentil(pd_total), 0.01);
    }

    @Test
    public void testCalcularDesviacion() {
        assertEquals(desviacion_esperada, Utils.calcularDesviacion(MEDIA, DESVIACION, pd_total, false), 0.01);
    }
}
