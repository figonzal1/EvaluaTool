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

package cl.figonzal.evaluatool.evalua.evalua3.modulo2;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import cl.figonzal.evaluatool.utilidades.Utilidades;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class OrganizacionPerceptivaE3M2Test {
    private static final double DESVIACION = 5.86;
    private static final double MEDIA = 10.96;

    private final double pd_total;
    private final double percentil_esperado;
    private final double desviacion_esperada;
    private OrganizacionPerceptivaE3M2 m1;

    public OrganizacionPerceptivaE3M2Test(double pd_total, double percentil_esperado, double desviacion_esperada) {
        this.pd_total = pd_total;
        this.percentil_esperado = percentil_esperado;
        this.desviacion_esperada = desviacion_esperada;
    }

    @Parameterized.Parameters()
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {20, 99, 1.54},
                {19, 95, 1.37},
                {18, 90, 1.2},
                {17, 80, 1.03},
                {16, 75, 0.86},
                {15, 70, 0.69},
                {14, 65, 0.52},
                {13, 60, 0.35},
                {12, 55, 0.18},
                {11, 50, 0.01},
                {10, 47, -0.16},
                {9, 42, -0.33},
                {8, 40, -0.51},
                {7, 35, -0.68},
                {6, 30, -0.85},
                {5, 25, -1.02},
                {4, 15, -1.19},
                {3, 10, -1.36},
                {2, 5, -1.53},
                {1, 1, -1.7},

                //LIMITE
                {0, 1, -1.87},
                {21, 99, 1.71}
        });
    }

    @Before
    public void setUp() {
        m1 = new OrganizacionPerceptivaE3M2();
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
