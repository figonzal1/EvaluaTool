/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2021

 Last modified 17-04-21 22:25
 */

package cl.figonzal.evaluatool;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import cl.figonzal.evaluatool.utilidades.Utils;

import static junit.framework.TestCase.assertEquals;

@RunWith(Parameterized.class)
public class DesviacionTest {

    private final double desviacion;
    private final double media;
    private final double pd_total;
    private final double desviacion_esperada;

    public DesviacionTest(double media, double desviacion, double pd_total, double desviacion_esperada) {
        this.desviacion = desviacion;
        this.media = media;
        this.pd_total = pd_total;
        this.desviacion_esperada = desviacion_esperada;
    }

    @Parameterized.Parameters()
    public static Collection<Object[]> data() {
        //MEDIA,DESVIACION,PD_TOTAL,DESVIACION CALCULADA
        return Arrays.asList(new Object[][]{
                {84.81, 9.01, 60, -2.75},
                {23.21, 2.01, 25, 0.89},
                {10.45, 4.12, 20, 2.32},
                {42.23, 6.1, 35.2, -1.15},
                {22.12, 10.1, 60.2, 3.77},
                {78.48, 1.04, 75.2, -3.15},
                {63.21, 10.35, 61.1, -0.2}
        });
    }

    @Test
    public void testCalcularDesviacion() {
        assertEquals(desviacion_esperada, Utils.calcularDesviacion(media, desviacion, pd_total, false), 0.001);
    }
}
