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
 Last modified 15-04-20 20:14                                                 -
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
public class OrganizacionPerceptivaTest {

    private static final double DESVIACION = 3.98;
    private static final double MEDIA = 19.39;
    private final double percentil_esperado;
    private final double pd_total;
    private final double desviacion_esperada;
    private OrganizacionPerceptiva m1;

    public OrganizacionPerceptivaTest(double pd_total, double percentil_esperado,
                                      double desviacion_esperada) {
        this.percentil_esperado = percentil_esperado;
        this.pd_total = pd_total;
        this.desviacion_esperada = desviacion_esperada;
    }

    @Parameterized.Parameters()
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {22, 99, 0.66},
                {21, 75, 0.40},
                {20, 60, 0.15},
                {19, 50, -0.10},
                {18, 40, -0.35},
                {17, 30, -0.60},
                {16, 25, -0.85},
                {15, 20, -1.10},
                {14, 15, -1.35},
                {13, 10, -1.61},
                {12, 7, -1.86},
                {10, 5, -2.36},
                {8, 3, -2.86},
                {7, 1, -3.11},
                {4, 1, -3.87},
                {2, 1, -4.37},

                //LIMITES
                {0, 1, -4.87},
                {23, 99, 0.91}

        });
    }

    @Before
    public void setUp() {
        m1 = new OrganizacionPerceptiva();
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
