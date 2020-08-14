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

package cl.figonzal.evaluatool.evalua.evalua0.modulo3;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import cl.figonzal.evaluatool.utilidades.Utilidades;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class PalabrasYFrasesE0M3Test {

    private static final double DESVIACION = 3.33;
    private static final double MEDIA = 17.15;
    private final double percentil_esperado;
    private final double pd_total;
    private final double desviacion_esperada;
    private PalabrasYFrasesE0M3 m1;

    public PalabrasYFrasesE0M3Test(double pd_total, double percentil_esperado,
                                   double desviacion_esperada) {
        this.percentil_esperado = percentil_esperado;
        this.pd_total = pd_total;
        this.desviacion_esperada = desviacion_esperada;
    }

    @Parameterized.Parameters()
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {24, 99, 2.06},
                {23, 97, 1.76},
                {22, 95, 1.46},
                {21, 85, 1.16},
                {20, 75, 0.86},
                {19, 65, 0.56},
                {18, 55, 0.26},
                {17, 50, -0.05},
                {16, 40, -0.35},
                {15, 37, -0.65},
                {14, 35, -0.95},
                {13, 20, -1.25},
                {12, 15, -1.55},
                {11, 10, -1.85},
                {10, 8, -2.15},
                {9, 6, -2.45},
                {8, 4, -2.75},
                {7, 1, -3.05},


                //LIMITE
                //LIMITE
                {6, 1, -3.35},
                {25, 99, 2.36}
        });
    }

    @Before
    public void setUp() {
        m1 = new PalabrasYFrasesE0M3();
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
