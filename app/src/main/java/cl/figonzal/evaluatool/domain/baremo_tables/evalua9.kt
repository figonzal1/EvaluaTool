/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2022

 Last modified 23-06-22 00:39
 */

package cl.figonzal.evaluatool.domain.baremo_tables

import cl.figonzal.evaluatool.domain.baremo_tables.constants.BaseConstants
import cl.figonzal.evaluatool.domain.resolvers.BaremoTable

/**
 * Evalua 9
 */
class Evalua9Baremo : BaremoTable {

    override fun getBaremo(baremo: BaseConstants): Array<Array<Double>> {
        return emptyArray()
    }

    override fun getBaremo(baremo: String): Array<Array<Double>> {
        return when (baremo) {

            "aten" -> atencionConcentracionE9M1Baremo()

            "razoi" -> razonamientoInductivoE9M2Baremo()
            "razoe" -> razonamientoEspacialE9M2Baremo()
            "razod" -> razonamientoDeductivoE9M2Baremo()

            "adapp" -> adaptacionPersonalE9M3Baremo()
            "adapf" -> adaptacionFamiliarFragmentE9M3Baremo()
            "adape" -> adaptacionEscolarFragmentE9M3Baremo()
            "habi" -> habilidadesSocialesE9M3Baremo()

            "compl" -> comprensionLectoraE9M4Baremo()
            "efic" -> eficaciaLectoraE9M4Baremo()
            "velo" -> velocidadFragmentE9M4Baremo()
            "compf" -> comprensionFragmentE9M4Baremo()

            "ortov" -> ortografiaVisualRegladaE9M5Baremo()

            "calc" -> calculoNumeracionE9M6Baremo()
            "reso" -> resolucionProblemasE9M6Baremo()

            else -> emptyArray()
        }
    }

}

/**
 * I.- Atencion - Concentracion
 *
 * Page 31
 */
fun atencionConcentracionE9M1Baremo() = arrayOf(
    arrayOf(193.0, 99.0, 1.15),
    arrayOf(189.0, 90.0, 1.04),
    arrayOf(183.0, 80.0, 0.88),
    arrayOf(177.0, 75.0, 0.71),
    arrayOf(171.0, 70.0, 0.55),
    arrayOf(165.0, 65.0, 0.38),
    arrayOf(159.0, 60.0, 0.22),
    arrayOf(153.0, 50.0, 0.06),
    arrayOf(147.0, 45.0, -0.11),
    arrayOf(141.0, 40.0, -0.27),
    arrayOf(135.0, 30.0, -0.43),
    arrayOf(129.0, 20.0, -0.6),
    arrayOf(123.0, 18.0, -0.76),
    arrayOf(117.0, 15.0, -0.92),
    arrayOf(111.0, 11.0, -1.09),
    arrayOf(105.0, 10.0, -1.25),
    arrayOf(99.0, 8.0, -1.42),
    arrayOf(93.0, 7.0, -1.58),
    arrayOf(87.0, 6.0, -1.74),
    arrayOf(81.0, 5.0, -1.91),
    arrayOf(75.0, 4.0, -2.07),
    arrayOf(69.0, 3.0, -2.23),
    arrayOf(63.0, 2.0, -2.4),
    arrayOf(57.0, 1.0, -2.56),
)

/**
 * II.- Razonamiento
 * A.- Razonamiento Inductivo
 *
 * Page 35
 */
fun razonamientoInductivoE9M2Baremo() = arrayOf(
    arrayOf(45.0, 99.0, 3.49),
    arrayOf(42.0, 98.0, 3.06),
    arrayOf(40.0, 97.0, 2.78),
    arrayOf(38.0, 96.0, 2.49),
    arrayOf(36.0, 95.0, 2.21),
    arrayOf(34.0, 93.0, 1.92),
    arrayOf(32.0, 92.0, 1.64),
    arrayOf(30.0, 90.0, 1.35),
    arrayOf(28.0, 85.0, 1.07),
    arrayOf(27.0, 80.0, 0.93),
    arrayOf(26.0, 77.0, 0.78),
    arrayOf(25.0, 75.0, 0.64),
    arrayOf(24.0, 70.0, 0.5),
    arrayOf(23.0, 65.0, 0.36),
    arrayOf(22.0, 60.0, 0.21),
    arrayOf(21.0, 55.0, 0.07),
    arrayOf(20.0, 50.0, -0.07),
    arrayOf(19.0, 45.0, -0.21),
    arrayOf(18.0, 40.0, -0.36),
    arrayOf(16.0, 35.0, -0.64),
    arrayOf(14.0, 25.0, -0.93),
    arrayOf(12.0, 20.0, -1.21),
    arrayOf(10.0, 15.0, -1.5),
    arrayOf(8.0, 10.0, -1.78),
    arrayOf(6.0, 7.0, -2.07),
    arrayOf(4.0, 3.0, -2.35),
    arrayOf(2.0, 1.0, -2.64),
)

/**
 * II.- Razonamiento
 * B.- Razonamiento Espacial
 *
 * Page 41
 */
fun razonamientoEspacialE9M2Baremo() = arrayOf(
    arrayOf(29.0, 99.0, 2.02),
    arrayOf(28.0, 98.0, 1.87),
    arrayOf(27.0, 97.0, 1.71),
    arrayOf(26.0, 95.0, 1.56),
    arrayOf(25.0, 94.0, 1.41),
    arrayOf(24.0, 92.0, 1.25),
    arrayOf(23.0, 90.0, 1.1),
    arrayOf(22.0, 85.0, 0.95),
    arrayOf(21.0, 80.0, 0.79),
    arrayOf(20.0, 75.0, 0.64),
    arrayOf(19.0, 70.0, 0.49),
    arrayOf(18.0, 65.0, 0.33),
    arrayOf(17.0, 60.0, 0.18),
    arrayOf(16.0, 55.0, 0.02),
    arrayOf(15.0, 50.0, -0.13),
    arrayOf(14.0, 45.0, -0.28),
    arrayOf(13.0, 40.0, -0.44),
    arrayOf(12.0, 35.0, -0.59),
    arrayOf(11.0, 30.0, -0.74),
    arrayOf(10.0, 25.0, -0.9),
    arrayOf(9.0, 20.0, -1.05),
    arrayOf(8.0, 15.0, -1.2),
    arrayOf(7.0, 10.0, -1.36),
    arrayOf(6.0, 7.0, -1.51),
    arrayOf(5.0, 5.0, -1.67),
    arrayOf(4.0, 3.0, -1.82),
)

/**
 * II.- Razonamiento
 * C.- Razonamiento Deductivo
 *
 * Page 47
 */
fun razonamientoDeductivoE9M2Baremo() = arrayOf(
    arrayOf(29.0, 99.0, 2.17),
    arrayOf(27.0, 98.0, 1.87),
    arrayOf(26.0, 97.0, 1.71),
    arrayOf(25.0, 95.0, 1.56),
    arrayOf(24.0, 92.0, 1.4),
    arrayOf(23.0, 90.0, 1.25),
    arrayOf(22.0, 87.0, 1.1),
    arrayOf(21.0, 85.0, 0.94),
    arrayOf(20.0, 80.0, 0.79),
    arrayOf(19.0, 75.0, 0.64),
    arrayOf(18.0, 70.0, 0.48),
    arrayOf(17.0, 60.0, 0.33),
    arrayOf(16.0, 55.0, 0.18),
    arrayOf(15.0, 50.0, 0.02),
    arrayOf(13.0, 40.0, -0.28),
    arrayOf(11.0, 35.0, -0.59),
    arrayOf(9.0, 25.0, -0.9),
    arrayOf(7.0, 15.0, -1.2),
    arrayOf(5.0, 10.0, -1.51),
    arrayOf(3.0, 5.0, -1.82),
    arrayOf(1.0, 1.0, -2.12),
)

/**
 * III.- Niveles de Adaptacion
 * A.- Adaptacion Personal
 *
 * Page 55
 */
fun adaptacionPersonalE9M3Baremo() = arrayOf(
    arrayOf(0.0, 99.0),
    arrayOf(1.0, 99.0),
    arrayOf(2.0, 99.0),
    arrayOf(3.0, 98.0),
    arrayOf(4.0, 98.0),
    arrayOf(5.0, 98.0),
    arrayOf(6.0, 95.0),
    arrayOf(7.0, 95.0),
    arrayOf(8.0, 95.0),
    arrayOf(9.0, 90.0),
    arrayOf(10.0, 90.0),
    arrayOf(11.0, 90.0),
    arrayOf(12.0, 85.0),
    arrayOf(13.0, 85.0),
    arrayOf(14.0, 85.0),
    arrayOf(15.0, 75.0),
    arrayOf(16.0, 75.0),
    arrayOf(17.0, 75.0),
    arrayOf(18.0, 70.0),
    arrayOf(19.0, 70.0),
    arrayOf(20.0, 70.0),
    arrayOf(21.0, 65.0),
    arrayOf(22.0, 65.0),
    arrayOf(23.0, 65.0),
    arrayOf(24.0, 60.0),
    arrayOf(25.0, 60.0),
    arrayOf(26.0, 60.0),
    arrayOf(27.0, 55.0),
    arrayOf(28.0, 55.0),
    arrayOf(29.0, 55.0),
    arrayOf(30.0, 50.0),
    arrayOf(31.0, 50.0),
    arrayOf(32.0, 50.0),
    arrayOf(33.0, 45.0),
    arrayOf(34.0, 45.0),
    arrayOf(35.0, 45.0),
    arrayOf(36.0, 40.0),
    arrayOf(37.0, 40.0),
    arrayOf(38.0, 40.0),
    arrayOf(39.0, 35.0),
    arrayOf(40.0, 35.0),
    arrayOf(41.0, 35.0),
    arrayOf(42.0, 30.0),
    arrayOf(43.0, 30.0),
    arrayOf(44.0, 30.0),
    arrayOf(45.0, 20.0),
    arrayOf(46.0, 20.0),
    arrayOf(47.0, 20.0),
    arrayOf(48.0, 15.0),
    arrayOf(49.0, 15.0),
    arrayOf(50.0, 15.0),
    arrayOf(51.0, 10.0),
    arrayOf(52.0, 10.0),
    arrayOf(53.0, 10.0),
    arrayOf(54.0, 5.0),
    arrayOf(55.0, 5.0),
    arrayOf(56.0, 5.0),
    arrayOf(57.0, 3.0),
    arrayOf(58.0, 3.0),
    arrayOf(59.0, 3.0),
    arrayOf(60.0, 1.0),
)

/**
 * III.- Niveles de Adaptacion
 * B.- Adaptacion Familiar
 *
 * Page 55
 */
fun adaptacionFamiliarFragmentE9M3Baremo() = arrayOf(
    arrayOf(0.0, 99.0),
    arrayOf(1.0, 99.0),
    arrayOf(2.0, 99.0),
    arrayOf(3.0, 95.0),
    arrayOf(4.0, 95.0),
    arrayOf(5.0, 95.0),
    arrayOf(6.0, 90.0),
    arrayOf(7.0, 90.0),
    arrayOf(8.0, 90.0),
    arrayOf(9.0, 80.0),
    arrayOf(10.0, 80.0),
    arrayOf(11.0, 80.0),
    arrayOf(12.0, 75.0),
    arrayOf(13.0, 75.0),
    arrayOf(14.0, 75.0),
    arrayOf(15.0, 70.0),
    arrayOf(16.0, 70.0),
    arrayOf(17.0, 70.0),
    arrayOf(18.0, 65.0),
    arrayOf(19.0, 65.0),
    arrayOf(20.0, 65.0),
    arrayOf(21.0, 60.0),
    arrayOf(22.0, 60.0),
    arrayOf(23.0, 60.0),
    arrayOf(24.0, 55.0),
    arrayOf(25.0, 55.0),
    arrayOf(26.0, 55.0),
    arrayOf(27.0, 50.0),
    arrayOf(28.0, 50.0),
    arrayOf(29.0, 50.0),
    arrayOf(30.0, 45.0),
    arrayOf(31.0, 45.0),
    arrayOf(32.0, 45.0),
    arrayOf(33.0, 40.0),
    arrayOf(34.0, 40.0),
    arrayOf(35.0, 40.0),
    arrayOf(36.0, 35.0),
    arrayOf(37.0, 35.0),
    arrayOf(38.0, 35.0),
    arrayOf(39.0, 30.0),
    arrayOf(40.0, 30.0),
    arrayOf(41.0, 30.0),
    arrayOf(42.0, 20.0),
    arrayOf(43.0, 20.0),
    arrayOf(44.0, 20.0),
    arrayOf(45.0, 15.0),
    arrayOf(46.0, 15.0),
    arrayOf(47.0, 15.0),
    arrayOf(48.0, 12.0),
    arrayOf(49.0, 12.0),
    arrayOf(50.0, 12.0),
    arrayOf(51.0, 10.0),
    arrayOf(52.0, 10.0),
    arrayOf(53.0, 10.0),
    arrayOf(54.0, 5.0),
    arrayOf(55.0, 5.0),
    arrayOf(56.0, 5.0),
    arrayOf(57.0, 3.0),
    arrayOf(58.0, 3.0),
    arrayOf(59.0, 3.0),
    arrayOf(60.0, 1.0),
)

/**
 * III.- Niveles de Adaptacion
 * C.- Adaptacion Escolar
 *
 * Page 55
 */
fun adaptacionEscolarFragmentE9M3Baremo() = arrayOf(
    arrayOf(0.0, 99.0),
    arrayOf(1.0, 99.0),
    arrayOf(2.0, 99.0),
    arrayOf(3.0, 98.0),
    arrayOf(4.0, 98.0),
    arrayOf(5.0, 98.0),
    arrayOf(6.0, 97.0),
    arrayOf(7.0, 97.0),
    arrayOf(8.0, 97.0),
    arrayOf(9.0, 96.0),
    arrayOf(10.0, 96.0),
    arrayOf(11.0, 96.0),
    arrayOf(12.0, 93.0),
    arrayOf(13.0, 93.0),
    arrayOf(14.0, 93.0),
    arrayOf(15.0, 90.0),
    arrayOf(16.0, 90.0),
    arrayOf(17.0, 90.0),
    arrayOf(18.0, 85.0),
    arrayOf(19.0, 85.0),
    arrayOf(20.0, 85.0),
    arrayOf(21.0, 80.0),
    arrayOf(22.0, 80.0),
    arrayOf(23.0, 80.0),
    arrayOf(24.0, 75.0),
    arrayOf(25.0, 75.0),
    arrayOf(26.0, 75.0),
    arrayOf(27.0, 70.0),
    arrayOf(28.0, 70.0),
    arrayOf(29.0, 70.0),
    arrayOf(30.0, 65.0),
    arrayOf(31.0, 65.0),
    arrayOf(32.0, 65.0),
    arrayOf(33.0, 60.0),
    arrayOf(34.0, 60.0),
    arrayOf(35.0, 60.0),
    arrayOf(36.0, 55.0),
    arrayOf(37.0, 55.0),
    arrayOf(38.0, 55.0),
    arrayOf(39.0, 50.0),
    arrayOf(40.0, 50.0),
    arrayOf(41.0, 50.0),
    arrayOf(42.0, 40.0),
    arrayOf(43.0, 40.0),
    arrayOf(44.0, 40.0),
    arrayOf(45.0, 30.0),
    arrayOf(46.0, 30.0),
    arrayOf(47.0, 30.0),
    arrayOf(48.0, 20.0),
    arrayOf(49.0, 20.0),
    arrayOf(50.0, 20.0),
    arrayOf(51.0, 15.0),
    arrayOf(52.0, 15.0),
    arrayOf(53.0, 15.0),
    arrayOf(54.0, 10.0),
    arrayOf(55.0, 10.0),
    arrayOf(56.0, 10.0),
    arrayOf(57.0, 5.0),
    arrayOf(58.0, 5.0),
    arrayOf(59.0, 5.0),
    arrayOf(60.0, 1.0),
)

/**
 * III.- Niveles de Adaptacion
 * D.- Habilidades Sociales
 *
 * Page 55
 */
fun habilidadesSocialesE9M3Baremo() = arrayOf(
    arrayOf(0.0, 99.0),
    arrayOf(1.0, 99.0),
    arrayOf(2.0, 99.0),
    arrayOf(3.0, 98.0),
    arrayOf(4.0, 98.0),
    arrayOf(5.0, 98.0),
    arrayOf(6.0, 97.0),
    arrayOf(7.0, 97.0),
    arrayOf(8.0, 97.0),
    arrayOf(9.0, 96.0),
    arrayOf(10.0, 96.0),
    arrayOf(11.0, 96.0),
    arrayOf(12.0, 94.0),
    arrayOf(13.0, 94.0),
    arrayOf(14.0, 94.0),
    arrayOf(15.0, 90.0),
    arrayOf(16.0, 90.0),
    arrayOf(17.0, 90.0),
    arrayOf(18.0, 80.0),
    arrayOf(19.0, 80.0),
    arrayOf(20.0, 80.0),
    arrayOf(21.0, 70.0),
    arrayOf(22.0, 70.0),
    arrayOf(23.0, 70.0),
    arrayOf(24.0, 60.0),
    arrayOf(25.0, 60.0),
    arrayOf(26.0, 60.0),
    arrayOf(27.0, 50.0),
    arrayOf(28.0, 50.0),
    arrayOf(29.0, 50.0),
    arrayOf(30.0, 45.0),
    arrayOf(31.0, 45.0),
    arrayOf(32.0, 45.0),
    arrayOf(33.0, 40.0),
    arrayOf(34.0, 40.0),
    arrayOf(35.0, 40.0),
    arrayOf(36.0, 35.0),
    arrayOf(37.0, 35.0),
    arrayOf(38.0, 35.0),
    arrayOf(39.0, 25.0),
    arrayOf(40.0, 25.0),
    arrayOf(41.0, 25.0),
    arrayOf(42.0, 15.0),
    arrayOf(43.0, 15.0),
    arrayOf(44.0, 15.0),
    arrayOf(45.0, 10.0),
    arrayOf(46.0, 10.0),
    arrayOf(47.0, 10.0),
    arrayOf(48.0, 7.0),
    arrayOf(49.0, 7.0),
    arrayOf(50.0, 7.0),
    arrayOf(51.0, 5.0),
    arrayOf(52.0, 5.0),
    arrayOf(53.0, 5.0),
    arrayOf(54.0, 3.0),
    arrayOf(55.0, 3.0),
    arrayOf(56.0, 3.0),
    arrayOf(57.0, 1.0),
    arrayOf(58.0, 1.0),
    arrayOf(59.0, 1.0),
)

/**
 * IV.- Lectura
 * A.- Comprension Lectora
 *
 * Page 59
 */
fun comprensionLectoraE9M4Baremo() = arrayOf(
    arrayOf(37.0, 99.0, 3.23),
    arrayOf(35.0, 98.0, 2.96),
    arrayOf(33.0, 97.0, 2.69),
    arrayOf(31.0, 96.0, 2.42),
    arrayOf(29.0, 95.0, 2.14),
    arrayOf(27.0, 94.0, 1.87),
    arrayOf(25.0, 93.0, 1.6),
    arrayOf(24.0, 92.0, 1.47),
    arrayOf(23.0, 90.0, 1.33),
    arrayOf(22.0, 87.0, 1.2),
    arrayOf(21.0, 85.0, 1.06),
    arrayOf(20.0, 82.0, 0.93),
    arrayOf(19.0, 80.0, 0.79),
    arrayOf(18.0, 75.0, 0.65),
    arrayOf(17.0, 70.0, 0.52),
    arrayOf(16.0, 65.0, 0.38),
    arrayOf(15.0, 60.0, 0.25),
    arrayOf(14.0, 55.0, 0.11),
    arrayOf(13.0, 50.0, -0.02),
    arrayOf(12.0, 45.0, -0.16),
    arrayOf(10.0, 40.0, -0.43),
    arrayOf(8.0, 35.0, -0.7),
    arrayOf(6.0, 25.0, -0.97),
    arrayOf(5.0, 15.0, -1.11),
    arrayOf(4.0, 10.0, -1.24),
    arrayOf(3.0, 5.0, -1.38),
    arrayOf(2.0, 3.0, -1.51),
    arrayOf(1.0, 1.0, -1.65),
)

/**
 * IV.- Lectura
 * B.- Eficacia Lectora
 *
 * Page 65
 */
fun eficaciaLectoraE9M4Baremo() = arrayOf(
    arrayOf(17.0, 98.0, 2.82),
    arrayOf(16.0, 96.0, 2.57),
    arrayOf(15.0, 95.0, 2.32),
    arrayOf(14.0, 94.0, 2.07),
    arrayOf(13.0, 93.0, 1.82),
    arrayOf(12.0, 92.0, 1.57),
    arrayOf(11.0, 90.0, 1.32),
    arrayOf(10.0, 88.0, 1.07),
    arrayOf(9.0, 85.0, 0.82),
    arrayOf(8.0, 75.0, 0.57),
    arrayOf(7.0, 65.0, 0.32),
    arrayOf(6.0, 55.0, 0.07),
    arrayOf(5.0, 50.0, -0.18),
    arrayOf(4.0, 40.0, -0.43),
    arrayOf(3.0, 25.0, -0.68),
    arrayOf(2.0, 10.0, -0.93),
    arrayOf(1.0, 5.0, -1.19),
)

/**
 * IV.- Lectura
 * C.- Velocidad Lectora - Velocidad Fragment
 *
 * Page 69
 */
fun velocidadFragmentE9M4Baremo() = arrayOf(
    arrayOf(90.0, 98.0, 1.53),
    arrayOf(100.0, 96.0, 1.4),
    arrayOf(120.0, 93.0, 1.13),
    arrayOf(130.0, 90.0, 0.99),
    arrayOf(140.0, 85.0, 0.86),
    arrayOf(150.0, 80.0, 0.72),
    arrayOf(160.0, 75.0, 0.59),
    arrayOf(170.0, 70.0, 0.45),
    arrayOf(180.0, 65.0, 0.32),
    arrayOf(190.0, 60.0, 0.18),
    arrayOf(200.0, 50.0, 0.05),
    arrayOf(210.0, 45.0, -0.09),
    arrayOf(220.0, 35.0, -0.22),
    arrayOf(230.0, 30.0, -0.36),
    arrayOf(240.0, 25.0, -0.49),
    arrayOf(250.0, 20.0, -0.63),
    arrayOf(270.0, 15.0, -0.9),
    arrayOf(290.0, 12.0, -1.17),
    arrayOf(310.0, 9.0, -1.44),
    arrayOf(330.0, 5.0, -1.71),
    arrayOf(350.0, 4.0, -1.98),
    arrayOf(370.0, 3.0, -2.24),
    arrayOf(390.0, 2.0, -2.51),
    arrayOf(410.0, 1.0, -2.78),
)

/**
 * IV.- Lectura
 * C.- Velocidad Lectora - Comprension Fragment
 *
 * Page 69
 */
fun comprensionFragmentE9M4Baremo() = arrayOf(
    arrayOf(15.0, 99.0, 1.71),
    arrayOf(14.0, 95.0, 1.45),
    arrayOf(13.0, 90.0, 1.18),
    arrayOf(12.0, 85.0, 0.91),
    arrayOf(11.0, 75.0, 0.65),
    arrayOf(10.0, 65.0, 0.38),
    arrayOf(9.0, 55.0, 0.11),
    arrayOf(8.0, 50.0, -0.15),
    arrayOf(7.0, 45.0, -0.42),
    arrayOf(6.0, 35.0, -0.69),
    arrayOf(5.0, 30.0, -0.95),
    arrayOf(4.0, 25.0, -1.22),
    arrayOf(3.0, 15.0, -1.49),
    arrayOf(2.0, 10.0, -1.75),
    arrayOf(1.0, 5.0, -2.02),
    arrayOf(0.0, 1.0, -2.29),
)

/**
 * V.- Escritura
 * A.-  Ortografia Visual y Reglada
 *
 * Page 75
 */
fun ortografiaVisualRegladaE9M5Baremo() = arrayOf(
    arrayOf(86.0, 99.0, 2.58),
    arrayOf(82.0, 98.0, 2.36),
    arrayOf(78.0, 97.0, 2.15),
    arrayOf(74.0, 96.0, 1.94),
    arrayOf(70.0, 95.0, 1.73),
    arrayOf(66.0, 93.0, 1.51),
    arrayOf(62.0, 90.0, 1.3),
    arrayOf(58.0, 87.0, 1.09),
    arrayOf(55.0, 85.0, 0.93),
    arrayOf(52.0, 82.0, 0.77),
    arrayOf(49.0, 80.0, 0.61),
    arrayOf(46.0, 75.0, 0.45),
    arrayOf(43.0, 65.0, 0.29),
    arrayOf(40.0, 60.0, 0.13),
    arrayOf(37.0, 50.0, -0.03),
    arrayOf(34.0, 45.0, -0.19),
    arrayOf(30.0, 40.0, -0.4),
    arrayOf(26.0, 35.0, -0.61),
    arrayOf(22.0, 30.0, -0.82),
    arrayOf(18.0, 25.0, -1.04),
    arrayOf(14.0, 20.0, -1.25),
    arrayOf(10.0, 15.0, -1.46),
    arrayOf(6.0, 10.0, -1.67),
    arrayOf(4.0, 5.0, -1.78),
)

/**
 * VI.- Aprendizajes Matematicos
 * A.- Calculo y Numeracion
 *
 * Page 85
 */
fun calculoNumeracionE9M6Baremo() = arrayOf(
    arrayOf(26.0, 99.0, 1.91),
    arrayOf(25.0, 97.0, 1.75),
    arrayOf(24.0, 95.0, 1.6),
    arrayOf(23.0, 92.0, 1.44),
    arrayOf(22.0, 90.0, 1.28),
    arrayOf(21.0, 85.0, 1.13),
    arrayOf(20.0, 80.0, 0.97),
    arrayOf(19.0, 75.0, 0.81),
    arrayOf(18.0, 70.0, 0.65),
    arrayOf(17.0, 65.0, 0.5),
    arrayOf(16.0, 60.0, 0.34),
    arrayOf(15.0, 55.0, 0.18),
    arrayOf(14.0, 50.0, 0.03),
    arrayOf(13.0, 47.0, -0.13),
    arrayOf(12.0, 45.0, -0.29),
    arrayOf(11.0, 42.0, -0.45),
    arrayOf(10.0, 40.0, -0.6),
    arrayOf(9.0, 35.0, -0.76),
    arrayOf(8.0, 30.0, -0.92),
    arrayOf(7.0, 25.0, -1.08),
    arrayOf(6.0, 20.0, -1.23),
    arrayOf(5.0, 15.0, -1.39),
    arrayOf(4.0, 10.0, -1.55),
    arrayOf(3.0, 5.0, -1.7),
)

/**
 * VI.- Aprendizajes Matematicos
 * B.- Resolucion de Problemas
 *
 * Page 91
 */
fun resolucionProblemasE9M6Baremo() = arrayOf(
    arrayOf(14.0, 99.0, 3.18),
    arrayOf(13.0, 98.0, 2.86),
    arrayOf(12.0, 97.0, 2.54),
    arrayOf(11.0, 95.0, 2.22),
    arrayOf(10.0, 93.0, 1.9),
    arrayOf(9.0, 90.0, 1.58),
    arrayOf(8.0, 85.0, 1.26),
    arrayOf(7.0, 75.0, 0.95),
    arrayOf(6.0, 70.0, 0.63),
    arrayOf(5.0, 60.0, 0.31),
    arrayOf(4.0, 50.0, -0.01),
    arrayOf(3.0, 35.0, -0.33),
    arrayOf(2.0, 20.0, -0.65),
    arrayOf(1.0, 10.0, -0.96),
    arrayOf(0.0, 2.0, -1.28),
)