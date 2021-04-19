/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2021

 Last modified 17-04-21 22:25
 */

package cl.figonzal.evaluatool.evalua.evalua7.modulo1;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import cl.figonzal.evaluatool.utilidades.Utils;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class AtencionConcentracionE7M1Test {

    private static final double DESVIACION = 28.04;
    private static final double MEDIA = 115.68;
    private final double percentil_esperado;
    private final double pd_total;
    private final double desviacion_esperada;
    private AtencionConcentracionE7M1 m1;

    public AtencionConcentracionE7M1Test(double pd_total, double percentil_esperado,
                                         double desviacion_esperada) {
        this.percentil_esperado = percentil_esperado;
        this.pd_total = pd_total;
        this.desviacion_esperada = desviacion_esperada;
    }

    @Parameterized.Parameters()
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {191, 99, 2.69},
                {190, 99, 2.65},
                {189, 99, 2.61},
                {188, 99, 2.58},
                {187, 99, 2.54},
                {186, 99, 2.51},
                {185, 99, 2.47},

                {184, 95, 2.44},
                {183, 95, 2.40},
                {182, 95, 2.37},
                {181, 95, 2.33},
                {180, 95, 2.29},

                {179, 90, 2.26},
                {178, 90, 2.22},
                {177, 90, 2.19},
                {176, 90, 2.15},
                {175, 90, 2.12},

                {174, 87, 2.08},
                {173, 87, 2.04},
                {172, 87, 2.01},
                {171, 87, 1.97},
                {170, 87, 1.94},

                {169, 85, 1.90},
                {168, 85, 1.87},
                {167, 85, 1.83},
                {166, 85, 1.79},
                {165, 85, 1.76},

                {164, 80, 1.72},
                {163, 80, 1.69},
                {162, 80, 1.65},
                {161, 80, 1.62},
                {160, 80, 1.58},

                {159, 78, 1.54},
                {158, 78, 1.51},
                {157, 78, 1.47},
                {156, 78, 1.44},
                {155, 78, 1.40},

                {154, 75, 1.37},
                {153, 75, 1.33},
                {152, 75, 1.30},
                {151, 75, 1.26},
                {150, 75, 1.22},

                {149, 72, 1.19},
                {148, 72, 1.15},
                {147, 72, 1.12},
                {146, 72, 1.08},
                {145, 72, 1.05},

                {144, 70, 1.01},
                {143, 70, 0.97},
                {142, 70, 0.94},
                {141, 70, 0.90},
                {140, 70, 0.87},

                {139, 65, 0.83},
                {138, 65, 0.80},
                {137, 65, 0.76},
                {136, 65, 0.72},
                {135, 65, 0.69},

                {134, 63, 0.65},
                {133, 63, 0.62},
                {132, 63, 0.58},
                {131, 63, 0.55},
                {130, 63, 0.51},

                {129, 60, 0.48},
                {128, 60, 0.44},
                {127, 60, 0.40},
                {126, 60, 0.37},
                {125, 60, 0.33},

                {124, 55, 0.30},
                {123, 55, 0.26},
                {122, 55, 0.23},
                {121, 55, 0.19},
                {120, 55, 0.15},

                {119, 50, 0.12},
                {118, 50, 0.08},
                {117, 50, 0.05},
                {116, 50, 0.01},
                {115, 50, -0.02},

                {114, 45, -0.06},
                {113, 45, -0.10},
                {112, 45, -0.13},
                {111, 45, -0.17},
                {110, 45, -0.20},

                {109, 40, -0.24},
                {108, 40, -0.27},
                {107, 40, -0.31},
                {106, 40, -0.35},
                {105, 40, -0.38},

                {104, 35, -0.42},
                {103, 35, -0.45},
                {102, 35, -0.49},
                {101, 35, -0.52},
                {100, 35, -0.56},

                {99, 30, -0.59},
                {98, 30, -0.63},
                {97, 30, -0.67},
                {96, 30, -0.70},
                {95, 30, -0.74},

                {94, 25, -0.77},
                {93, 25, -0.81},
                {92, 25, -0.84},
                {91, 25, -0.88},
                {90, 25, -0.92},

                {89, 18, -0.95},
                {88, 18, -0.99},
                {87, 18, -1.02},
                {86, 18, -1.06},
                {85, 18, -1.09},

                {84, 15, -1.13},
                {83, 15, -1.17},
                {82, 15, -1.20},
                {81, 15, -1.24},
                {80, 15, -1.27},

                {79, 12, -1.31},
                {78, 12, -1.34},
                {77, 12, -1.38},
                {76, 12, -1.42},
                {75, 12, -1.45},

                {74, 10, -1.49},
                {73, 10, -1.52},
                {72, 10, -1.56},
                {71, 10, -1.59},
                {70, 10, -1.63},

                {69, 9, -1.66},
                {68, 9, -1.70},
                {67, 9, -1.74},
                {66, 9, -1.77},
                {65, 9, -1.81},

                {64, 7, -1.84},
                {63, 7, -1.88},
                {62, 7, -1.91},
                {61, 7, -1.95},
                {60, 7, -1.99},

                {59, 5, -2.02},
                {58, 5, -2.06},
                {57, 5, -2.09},
                {56, 5, -2.13},
                {55, 5, -2.16},

                {54, 3, -2.20},
                {53, 3, -2.24},
                {52, 3, -2.27},
                {51, 3, -2.31},
                {50, 3, -2.34},

                {49, 1, -2.38},
                {48, 1, -2.41},
                {47, 1, -2.45},
                {46, 1, -2.49},
                {45, 1, -2.52},

                //Valores Limites
                {44, 1, -2.56},
                {31, 1, -3.02},
                {0, 1, -4.13},
                {-1, 1, -4.16},
                {-50, 1, -5.91},
                {192, 99, 2.72}
        });
    }

    @Before
    public void setUp() {
        m1 = new AtencionConcentracionE7M1();
    }

    @Test
    public void testCalcularPercentil() {
        assertEquals(percentil_esperado, m1.calcularPercentil(pd_total), 0.1);
    }

    @Test
    public void testCalcularDesviacion() {
        assertEquals(desviacion_esperada, Utils.calcularDesviacion(MEDIA, DESVIACION, pd_total, false), 0.001);
    }
}