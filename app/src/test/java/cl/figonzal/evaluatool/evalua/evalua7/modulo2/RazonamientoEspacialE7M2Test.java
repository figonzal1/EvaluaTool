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

package cl.figonzal.evaluatool.evalua.evalua7.modulo2;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.List;

import cl.figonzal.evaluatool.utilidades.Utilidades;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class RazonamientoEspacialE7M2Test {

    private static final double DESVIACION = 8.51;
    private static final double MEDIA = 20.52;
    private final double pd_total;
    private final double percentil_esperado;
    private final double desviacion_esperada;
    private RazonamientoEspacialE7M2 re;

    public RazonamientoEspacialE7M2Test(double pd_total, double percentil_esperado,
                                        double desviacion_esperada) {
        this.pd_total = pd_total;
        this.percentil_esperado = percentil_esperado;
        this.desviacion_esperada = desviacion_esperada;
    }

    @Parameterized.Parameters()
    public static List data() {
        return Arrays.asList(new Object[][]{
                {38, 99, 2.05},
                {36, 97, 1.82},
                {34, 95, 1.58},
                {32, 90, 1.35},
                {30, 80, 1.11},
                {28, 70, 0.88},
                {26, 60, 0.64},
                {24, 55, 0.41},
                {22, 50, 0.17},
                {20, 45, -0.06},
                {18, 40, -0.30},
                {16, 35, -0.53},
                {14, 30, -0.77},
                {12, 25, -1.00},
                {10, 20, -1.24},
                {8, 15, -1.47},
                {6, 10, -1.71},
                {4, 5, -1.94},
                {2, 1, -2.18},

                //LIMITE
                {1, 1, -2.29},
                {39, 99, 2.17}


        });
    }

    @Before
    public void setUp() {
        re = new RazonamientoEspacialE7M2();
    }

    @Test
    public void testCalcularPercentil() {
        assertEquals(percentil_esperado, re.calcularPercentil(pd_total), 0.01);
    }

    @Test
    public void testEjecutarEvaluacion() {
        assertEquals(desviacion_esperada, Utilidades.calcularDesviacion(MEDIA, DESVIACION, pd_total, false), 0.01);
    }
}