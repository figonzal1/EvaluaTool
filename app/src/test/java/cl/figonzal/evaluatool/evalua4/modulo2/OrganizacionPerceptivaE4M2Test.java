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
 Last modified 20-07-20 13:33                                                 -
 -----------------------------------------------------------------------------*/

package cl.figonzal.evaluatool.evalua4.modulo2;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import cl.figonzal.evaluatool.Utilidades;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class OrganizacionPerceptivaE4M2Test {

    private static final double DESVIACION = 3.21;
    private static final double MEDIA = 13.18;
    private final double percentil_esperado;
    private final double pd_total;
    private final double desviacion_esperada;
    private OrganizacionPerceptivaE4M2 m1;

    public OrganizacionPerceptivaE4M2Test(double pd_total, double percentil_esperado,
                                          double desviacion_esperada) {
        this.percentil_esperado = percentil_esperado;
        this.pd_total = pd_total;
        this.desviacion_esperada = desviacion_esperada;
    }

    @Parameterized.Parameters()
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {18, 99, 1.5},
                {17, 90, 1.19},
                {16, 75, 0.88},
                {15, 70, 0.57},
                {14, 60, 0.26},
                {13, 50, -0.06},
                {12, 40, -0.37},
                {11, 30, -0.68},
                {10, 20, -0.99},
                {9, 15, -1.3},
                {8, 10, -1.61},
                {7, 7, -1.93},
                {6, 5, -2.24},
                {5, 3, -2.55},
                {4, 2, -2.86},
                {3, 1, -3.17}

        });
    }

    @Before
    public void setUp() {
        m1 = new OrganizacionPerceptivaE4M2();
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
