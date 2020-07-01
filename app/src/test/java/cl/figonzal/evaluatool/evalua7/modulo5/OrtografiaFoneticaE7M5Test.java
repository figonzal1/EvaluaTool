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
import java.util.List;

import cl.figonzal.evaluatool.Utilidades;

import static junit.framework.TestCase.assertEquals;

@RunWith(Parameterized.class)
public class OrtografiaFoneticaE7M5Test {

    private static final double DESVIACION = 7.01;
    private static final double MEDIA = 28.00;
    private final double pd_total;
    private final double percentil_esperado;
    private final double desviacion_esperada;
    private OrtografiaFoneticaE7M5 of;

    public OrtografiaFoneticaE7M5Test(double pd_total, double percentil_esperado,
                                      double desviacion_esperada) {
        this.pd_total = pd_total;
        this.percentil_esperado = percentil_esperado;
        this.desviacion_esperada = desviacion_esperada;
    }

    @Parameterized.Parameters()
    public static List data() {
        return Arrays.asList(new Object[][]{
                {36, 99, 1.14},
                {35, 97, 1.00},
                {34, 95, 0.86},
                {33, 90, 0.71},
                {32, 85, 0.57},
                {31, 80, 0.43},
                {30, 70, 0.29},
                {29, 60, 0.14},
                {28, 50, 0.00},
                {27, 40, -0.14},
                {26, 30, -0.29},
                {25, 20, -0.43},
                {24, 15, -0.57},
                {22, 12, -0.86},
                {20, 10, -1.14},
                {18, 9, -1.43},
                {16, 7, -1.71},
                {14, 5, -2.00},
                {12, 3, -2.28},
                {10, 1, -2.57},

                //Valores limites
                {0, 1, -3.99},
                {-10, 1, -5.42},
                {37, 99, 1.28},
                {40, 99, 1.71}
        });
    }

    @Before
    public void setUp() {
        of = new OrtografiaFoneticaE7M5();
    }

    @Test
    public void testCalcularPercentil() {
        assertEquals(percentil_esperado, of.calcularPercentil(pd_total), 0.01);
    }

    @Test
    public void testCalcularDesviacion() {
        assertEquals(desviacion_esperada, Utilidades.calcularDesviacion(MEDIA, DESVIACION, pd_total, false), 0.01);
    }
}
