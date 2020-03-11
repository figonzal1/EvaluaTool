/*--------------------------------------------------------------
                                                               -
 This file is subject to the terms and conditions defined in   -
 file 'LICENSE', which is part of this source code package.    -
                                                               -
 Autor: Felipe González                                        -
 Email: felipe.gonzalezalarcon94@gmail.com                     -
                                                               -
 Copyright (c) 2020.                                           -
                                                               -
 Last modified 09-03-20 17:21                                  -
 --------------------------------------------------------------*/

package cl.figonzal.evaluatool.evalua7.modulo6;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.List;

import cl.figonzal.evaluatool.Utilidades;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class CalculoNumeracionTest {

    private static final double DESVIACION = 12.29;
    private static final double MEDIA = 33.70;
    private final double pd_total;
    private final double percentil_esperado;
    private final double desviacion_esperada;
    private CalculoNumeracion cn;

    public CalculoNumeracionTest(double pd_total, double percentil_esperado,
                                 double desviacion_esperada) {
        this.pd_total = pd_total;
        this.percentil_esperado = percentil_esperado;
        this.desviacion_esperada = desviacion_esperada;
    }

    @Parameterized.Parameters()
    public static List data() {
        return Arrays.asList(new Object[][]{
                {79, 99, 3.69},
                {76, 98, 3.44},
                {73, 97, 3.20},
                {70, 96, 2.95},
                {67, 95, 2.71},
                {64, 92, 2.47},
                {61, 90, 2.22},
                {58, 87, 1.98},
                {55, 85, 1.73},
                {52, 82, 1.49},
                {49, 80, 1.24},
                {46, 75, 1.00},
                {43, 70, 0.76},
                {40, 65, 0.51},
                {37, 60, 0.27},
                {34, 50, 0.02},
                {31, 40, -0.22},
                {28, 35, -0.46},
                {25, 30, -0.71},
                {22, 25, -0.95},
                {19, 20, -1.20},
                {16, 17, -1.44},
                {13, 15, -1.68},
                {10, 10, -1.93},
                {7, 5, -2.17},
                {4, 3, -2.42},
                {1, 1, -2.66}
        });
    }

    @Before
    public void setUp() {
        cn = new CalculoNumeracion();
    }

    @Test
    public void testCalcularPercentil() {
        assertEquals(percentil_esperado, cn.calcularPercentil(pd_total), 0.01);
    }

    @Test
    public void testCalcularDesviacion() {
        assertEquals(desviacion_esperada, Utilidades.calcularDesviacion(MEDIA, DESVIACION, pd_total, false), 0.01);
    }
}
