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
 Last modified 19-07-20 22:23                                                 -
 -----------------------------------------------------------------------------*/

package cl.figonzal.evaluatool.evalua4.modulo4;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import cl.figonzal.evaluatool.Utilidades;
import cl.figonzal.evaluatool.evalua4.modulo4.velodadFragments.ComprensionFragmentE4M4;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class ComprensionFragmentE4M4Test {

    private static final double DESVIACION = 4.01;
    private static final double MEDIA = 8.26;
    private final double percentil_esperado;
    private final double pd_total;
    private final double desviacion_esperada;
    private ComprensionFragmentE4M4 m1;

    public ComprensionFragmentE4M4Test(double pd_total, double percentil_esperado,
                                       double desviacion_esperada) {
        this.percentil_esperado = percentil_esperado;
        this.pd_total = pd_total;
        this.desviacion_esperada = desviacion_esperada;
    }

    @Parameterized.Parameters()
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {15, 97, 1.68},
                {14, 95, 1.43},
                {13, 85, 1.18},
                {12, 80, 0.93},
                {11, 70, 0.68},
                {10, 60, 0.43},
                {9, 50, 0.18},
                {8, 40, -0.06},
                {7, 35, -0.31},
                {6, 30, -0.56},
                {5, 25, -0.81},
                {4, 20, -1.06},
                {3, 10, -1.31},
                {2, 5, -1.56},
                {1, 1, -1.81}
        });
    }

    @Before
    public void setUp() {
        m1 = new ComprensionFragmentE4M4();
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
