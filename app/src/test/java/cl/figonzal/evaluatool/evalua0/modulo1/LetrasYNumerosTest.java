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
 Last modified 15-04-20 19:54                                                 -
 -----------------------------------------------------------------------------*/

package cl.figonzal.evaluatool.evalua0.modulo1;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import cl.figonzal.evaluatool.Utilidades;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class LetrasYNumerosTest {

    private static final double DESVIACION = 2.91;
    private static final double MEDIA = 26.02;
    private final double percentil_esperado;
    private final double pd_total;
    private final double desviacion_esperada;
    private LetrasYNumeros m1;

    public LetrasYNumerosTest(double pd_total, double percentil_esperado,
                              double desviacion_esperada) {
        this.percentil_esperado = percentil_esperado;
        this.pd_total = pd_total;
        this.desviacion_esperada = desviacion_esperada;
    }

    @Parameterized.Parameters()
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {30, 99, 1.37},
                {29, 90, 1.02},
                {28, 60, 0.68},
                {27, 65, 0.34},
                {26, 50, -0.01},
                {25, 35, -0.35},
                {24, 25, -0.69},
                {23, 15, -1.04},
                {22, 8, -1.38},
                {21, 7, -1.73},
                {20, 6, -2.07},
                {19, 5, -2.41},
                {18, 4, -2.76},
                {17, 3, -3.10},
                {16, 2, -3.44},
                {15, 1, -3.79},

                //LIMITES
                {31, 99, 1.71},
                {14, 1, -4.13}

        });
    }

    @Before
    public void setUp() {
        m1 = new LetrasYNumeros();
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
