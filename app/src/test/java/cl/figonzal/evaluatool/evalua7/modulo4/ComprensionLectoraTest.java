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

package cl.figonzal.evaluatool.evalua7.modulo4;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.List;

import cl.figonzal.evaluatool.Utilidades;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class ComprensionLectoraTest {

    private static final double DESVIACION = 6.71;
    private static final double MEDIA = 14.52;
    private final double pd_total;
    private final double percentil_esperado;
    private final double desviacion_esperada;
    private ComprensionLectora cl;

    public ComprensionLectoraTest(double pd_total, double percentil_esperado,
                                  double desviacion_esperada) {
        this.pd_total = pd_total;
        this.percentil_esperado = percentil_esperado;
        this.desviacion_esperada = desviacion_esperada;
    }

    @Parameterized.Parameters()
    public static List data() {
        return Arrays.asList(new Object[][]{
                {40, 99, 3.80},
                {38, 98, 3.50},
                {36, 97, 3.20},
                {34, 96, 2.90},
                {32, 95, 2.61},
                {30, 92, 2.31},
                {28, 90, 2.01},
                {26, 85, 1.71},
                {24, 80, 1.41},
                {22, 70, 1.11},
                {20, 60, 0.82},
                {18, 55, 0.52},
                {16, 50, 0.22},
                {14, 45, -0.08},
                {12, 40, -0.38},
                {10, 30, -0.67},
                {8, 20, -0.97},
                {6, 15, -1.27},
                {4, 10, -1.57},
                {2, 5, -1.87},

                //Valores limite
                {0, 5, -2.16},
                {-1, 5, -2.31},
                {41, 99, 3.95}
        });
    }

    @Before
    public void setUp() {
        cl = new ComprensionLectora();
    }

    @Test
    public void testCalcularPercentil() {
        assertEquals(percentil_esperado, cl.calcularPercentil(pd_total), 0.01);
    }

    @Test
    public void testCalcularDesviacion() {
        assertEquals(desviacion_esperada, Utilidades.calcularDesviacion(MEDIA, DESVIACION, pd_total, false), 0.01);
    }
}
