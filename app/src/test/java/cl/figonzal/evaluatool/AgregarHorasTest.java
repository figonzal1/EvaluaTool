/*--------------------------------------------------------------
                                                               -
 This file is subject to the terms and conditions defined in   -
 file 'LICENSE', which is part of this source code package.    -
                                                               -
 Autor: Felipe González                                        -
 Email: felipe.gonzalezalarcon94@gmail.com                     -
                                                               -
 Copyright (c) 2020.                                           -
                                                               -
 Last modified 09-03-20 17:21                                  -
 --------------------------------------------------------------*/

package cl.figonzal.evaluatool;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;

import static junit.framework.TestCase.assertEquals;

@RunWith(Parameterized.class)
public class AgregarHorasTest {

    private final Date dActual;
    private final Date dEsperado;
    private final int dHoras;

    public AgregarHorasTest(Date dActual, Date dEsperado, int dHoras) {
        this.dActual = dActual;
        this.dEsperado = dEsperado;
        this.dHoras = dHoras;
    }

    @Parameterized.Parameters(name = "{index}: {0} = addHoursToJavaUtilDate({1},{2})")
    public static Collection<Object[]> data() throws ParseException {
        return Arrays.asList(new Object[][]{
                {new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2019-03-13 14:00:00"),
                        new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2019-03-13 15:00:00"), 1},
                {new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2019-03-13 14:00:00"),
                        new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2019-03-14 14:00:00"), 24},
                {new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2018-12-31 23:59:59"),
                        new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2019-01-01 09:59:59"), 10},
                {new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2019-10-12 08:00:00"),
                        new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2019-10-13 04:00:00"), 20},
                {new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2019-09-12 10:00:00"),
                        new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2019-09-12 15:00:00"), 5}
        });
    }

    @Test
    public void add_hours_to_date() {
        assertEquals(dEsperado, Utilidades.addHoursToJavaUtilDate(dActual, dHoras));
    }
}
