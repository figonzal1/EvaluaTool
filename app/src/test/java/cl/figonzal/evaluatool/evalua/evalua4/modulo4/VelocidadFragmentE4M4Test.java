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
 Last modified 14-08-20 1:09                                                  -
 -----------------------------------------------------------------------------*/

package cl.figonzal.evaluatool.evalua.evalua4.modulo4;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import cl.figonzal.evaluatool.evalua.evalua4.modulo4.velodadFragments.VelocidadFragmentE4M4;
import cl.figonzal.evaluatool.utilidades.Utilidades;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class VelocidadFragmentE4M4Test {

    private static final double DESVIACION = 36.08;
    private static final double MEDIA = 129.21;
    private final double percentil_esperado;
    private final double pd_total;
    private final double desviacion_esperada;
    private VelocidadFragmentE4M4 m1;

    public VelocidadFragmentE4M4Test(double pd_total, double percentil_esperado,
                                     double desviacion_esperada) {
        this.percentil_esperado = percentil_esperado;
        this.pd_total = pd_total;
        this.desviacion_esperada = desviacion_esperada;
    }

    @Parameterized.Parameters()
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {60, 99, 1.92},
                {70, 97, 1.64},
                {80, 95, 1.36},
                {90, 90, 1.09},
                {100, 85, 0.81},
                {110, 75, 0.53},
                {120, 65, 0.26},
                {130, 55, -0.02},
                {140, 45, -0.3},
                {150, 40, -0.58},
                {160, 30, -0.85},
                {170, 25, -1.13},
                {180, 20, -1.41},
                {190, 15, -1.68},
                {200, 10, -1.96},
                {220, 5, -2.52},
                {230, 3, -2.79},
                {250, 2, -3.35},
                {300, 1, -4.73},
                {380, 0, -6.95}
        });
    }

    @Before
    public void setUp() {
        m1 = new VelocidadFragmentE4M4();
    }

    @Test
    public void testCalcularPercentil() {
        assertEquals(percentil_esperado, m1.calcularPercentil(pd_total), 0.1);
    }

    @Test
    public void testCalcularDesviacion() {
        assertEquals(desviacion_esperada, Utilidades.calcularDesviacion(MEDIA, DESVIACION, pd_total, true), 0.001);
    }
}