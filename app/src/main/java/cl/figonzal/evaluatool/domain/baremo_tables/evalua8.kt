/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2022

 Last modified 23-06-22 00:35
 */

package cl.figonzal.evaluatool.domain.baremo_tables

import cl.figonzal.evaluatool.domain.baremo_tables.constants.EvaluaConstants
import cl.figonzal.evaluatool.domain.resolvers.BaremoTable

/**
 * Evalua 8
 */
class Evalua8Baremo : BaremoTable {

    override fun getBaremo(baremo: EvaluaConstants): Array<Array<Double>> {
        return emptyArray()
    }

    override fun getBaremo(baremo: String) = when (baremo) {
        "aten" -> atencionConcentracionE8M1Baremo()

        "razoi" -> razonamientoInductivoE8M2Baremo()
        "razoe" -> razonamientoEspacialE8M2Baremo()
        "razod" -> razonamientoDeductivoE8M2Baremo()

        "adapp" -> adaptacionPersonalE8M3Baremo()
        "adapf" -> adaptacionFamiliarFragmentE8M3Baremo()
        "adape" -> adaptacionEscolarFragmentE8M3Baremo()
        "habi" -> habilidadesSocialesFragmentE8M3Baremo()

        "compl" -> comprensionLectoraE8M4Baremo()
        "efic" -> eficaciaLectoraE8M4Baremo()
        "velof" -> velocidadFragmentE8M4Baremo()
        "compf" -> comprensionFragmentE8M4Baremo()

        "ortov" -> ortografiaVisualRegladaE8M5Baremo()

        "calc" -> calculoNumeracionE8M6Baremo()
        "reso" -> resolucionProblemasE8M6Baremo()

        else -> emptyArray()
    }

}

/**
 * I.- Atencion - Concentracion
 *
 * Page 31
 */
fun atencionConcentracionE8M1Baremo() = arrayOf(
    arrayOf(250.0, 99.0, 1.25),
    arrayOf(241.0, 90.0, 1.0),
    arrayOf(232.0, 80.0, 0.76),
    arrayOf(223.0, 70.0, 0.52),
    arrayOf(214.0, 60.0, 0.28),
    arrayOf(205.0, 50.0, 0.04),
    arrayOf(196.0, 40.0, -0.21),
    arrayOf(187.0, 35.0, -0.45),
    arrayOf(178.0, 30.0, -0.69),
    arrayOf(169.0, 20.0, -0.93),
    arrayOf(160.0, 15.0, -1.17),
    arrayOf(151.0, 12.0, -1.41),
    arrayOf(142.0, 10.0, -1.66),
    arrayOf(133.0, 9.0, -1.9),
    arrayOf(124.0, 7.0, -2.14),
    arrayOf(115.0, 6.0, -2.38),
    arrayOf(96.0, 5.0, -2.89),
    arrayOf(87.0, 4.0, -3.13),
    arrayOf(78.0, 3.0, -3.38),
    arrayOf(69.0, 2.0, -3.62),
    arrayOf(60.0, 1.0, -3.86)
)

/**
 * II.- Razonamiento
 * A.- Razonamiento Inductivo
 *
 * Page 33
 */
fun razonamientoInductivoE8M2Baremo() = arrayOf(
    arrayOf(50.0, 99.0, 2.1),
    arrayOf(48.0, 98.0, 1.9),
    arrayOf(46.0, 96.0, 1.7),
    arrayOf(44.0, 94.0, 1.5),
    arrayOf(42.0, 90.0, 1.3),
    arrayOf(40.0, 85.0, 1.09),
    arrayOf(38.0, 75.0, 0.89),
    arrayOf(36.0, 70.0, 0.69),
    arrayOf(34.0, 65.0, 0.49),
    arrayOf(32.0, 55.0, 0.29),
    arrayOf(30.0, 50.0, 0.09),
    arrayOf(28.0, 45.0, -0.12),
    arrayOf(26.0, 40.0, -0.32),
    arrayOf(24.0, 35.0, -0.52),
    arrayOf(22.0, 30.0, -0.72),
    arrayOf(20.0, 25.0, -0.92),
    arrayOf(18.0, 20.0, -1.13),
    arrayOf(16.0, 15.0, -1.33),
    arrayOf(14.0, 10.0, -1.53),
    arrayOf(12.0, 8.0, -1.73),
    arrayOf(10.0, 6.0, -1.93),
    arrayOf(8.0, 4.0, -2.13),
    arrayOf(6.0, 2.0, -2.34),
    arrayOf(4.0, 1.0, -2.54)
)

/**
 * II.- Razonamiento
 * B.- Razonamiento Espacial
 *
 * Page 39
 */
fun razonamientoEspacialE8M2Baremo() = arrayOf(
    arrayOf(29.0, 99.0, 1.55),
    arrayOf(28.0, 97.0, 1.41),
    arrayOf(27.0, 95.0, 1.27),
    arrayOf(26.0, 90.0, 1.13),
    arrayOf(25.0, 80.0, 0.98),
    arrayOf(24.0, 75.0, 0.84),
    arrayOf(23.0, 70.0, 0.7),
    arrayOf(22.0, 65.0, 0.55),
    arrayOf(21.0, 60.0, 0.41),
    arrayOf(20.0, 55.0, 0.27),
    arrayOf(19.0, 50.0, 0.13),
    arrayOf(18.0, 47.0, -0.02),
    arrayOf(17.0, 42.0, -0.16),
    arrayOf(16.0, 40.0, -0.3),
    arrayOf(15.0, 35.0, -0.44),
    arrayOf(14.0, 30.0, -0.59),
    arrayOf(13.0, 25.0, -0.73),
    arrayOf(12.0, 20.0, -0.87),
    arrayOf(11.0, 15.0, -1.01),
    arrayOf(10.0, 10.0, -1.16),
    arrayOf(9.0, 9.0, -1.3),
    arrayOf(8.0, 7.0, -1.44),
    arrayOf(7.0, 5.0, -1.58),
    arrayOf(6.0, 3.0, -1.73),
    arrayOf(5.0, 1.0, -1.87),
)

/**
 * II.- Razonamiento
 * C.- Razonamiento Deductivo
 *
 * Page 45
 */
fun razonamientoDeductivoE8M2Baremo() = arrayOf(
    arrayOf(23.0, 99.0, 2.11),
    arrayOf(22.0, 98.0, 1.95),
    arrayOf(21.0, 97.0, 1.79),
    arrayOf(20.0, 96.0, 1.63),
    arrayOf(19.0, 95.0, 1.47),
    arrayOf(18.0, 92.0, 1.3),
    arrayOf(17.0, 90.0, 1.14),
    arrayOf(16.0, 87.0, 0.98),
    arrayOf(15.0, 85.0, 0.82),
    arrayOf(14.0, 80.0, 0.66),
    arrayOf(13.0, 75.0, 0.5),
    arrayOf(12.0, 65.0, 0.33),
    arrayOf(11.0, 60.0, 0.17),
    arrayOf(10.0, 50.0, 0.01),
    arrayOf(9.0, 47.0, -0.15),
    arrayOf(8.0, 42.0, -0.31),
    arrayOf(7.0, 40.0, -0.48),
    arrayOf(6.0, 35.0, -0.64),
    arrayOf(5.0, 30.0, -0.8),
    arrayOf(4.0, 25.0, -0.96),
    arrayOf(3.0, 15.0, -1.12),
    arrayOf(2.0, 10.0, -1.28),
    arrayOf(1.0, 5.0, -1.45),
    arrayOf(0.0, 1.0, -1.61),
)

/**
 * III.- Niveles de Adaptacion
 * A.- Adaptacion Personal
 *
 * Page 53
 */
fun adaptacionPersonalE8M3Baremo() = arrayOf(
    arrayOf(0.0, 99.0),
    arrayOf(1.0, 99.0),
    arrayOf(2.0, 99.0),
    arrayOf(3.0, 97.0),
    arrayOf(4.0, 97.0),
    arrayOf(5.0, 97.0),
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
    arrayOf(18.0, 65.0),
    arrayOf(19.0, 65.0),
    arrayOf(20.0, 65.0),
    arrayOf(21.0, 60.0),
    arrayOf(22.0, 60.0),
    arrayOf(23.0, 60.0),
    arrayOf(24.0, 57.0),
    arrayOf(25.0, 57.0),
    arrayOf(26.0, 57.0),
    arrayOf(27.0, 52.0),
    arrayOf(28.0, 52.0),
    arrayOf(29.0, 52.0),
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
 * Page 53
 */
fun adaptacionFamiliarFragmentE8M3Baremo() = arrayOf(
    arrayOf(0.0, 95.0),
    arrayOf(1.0, 95.0),
    arrayOf(2.0, 95.0),
    arrayOf(3.0, 90.0),
    arrayOf(4.0, 90.0),
    arrayOf(5.0, 90.0),
    arrayOf(6.0, 85.0),
    arrayOf(7.0, 85.0),
    arrayOf(8.0, 85.0),
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
    arrayOf(30.0, 40.0),
    arrayOf(31.0, 40.0),
    arrayOf(32.0, 40.0),
    arrayOf(33.0, 35.0),
    arrayOf(34.0, 35.0),
    arrayOf(35.0, 35.0),
    arrayOf(36.0, 30.0),
    arrayOf(37.0, 30.0),
    arrayOf(38.0, 30.0),
    arrayOf(39.0, 25.0),
    arrayOf(40.0, 25.0),
    arrayOf(41.0, 25.0),
    arrayOf(42.0, 20.0),
    arrayOf(43.0, 20.0),
    arrayOf(44.0, 20.0),
    arrayOf(45.0, 15.0),
    arrayOf(46.0, 15.0),
    arrayOf(47.0, 15.0),
    arrayOf(48.0, 10.0),
    arrayOf(49.0, 10.0),
    arrayOf(50.0, 10.0),
    arrayOf(51.0, 7.0),
    arrayOf(52.0, 7.0),
    arrayOf(53.0, 7.0),
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
 * Page 53
 */
fun adaptacionEscolarFragmentE8M3Baremo() = arrayOf(
    arrayOf(0.0, 99.0),
    arrayOf(1.0, 99.0),
    arrayOf(2.0, 99.0),
    arrayOf(3.0, 97.0),
    arrayOf(4.0, 97.0),
    arrayOf(5.0, 97.0),
    arrayOf(6.0, 95.0),
    arrayOf(7.0, 95.0),
    arrayOf(8.0, 95.0),
    arrayOf(9.0, 92.0),
    arrayOf(10.0, 92.0),
    arrayOf(11.0, 92.0),
    arrayOf(12.0, 90.0),
    arrayOf(13.0, 90.0),
    arrayOf(14.0, 90.0),
    arrayOf(15.0, 85.0),
    arrayOf(16.0, 85.0),
    arrayOf(17.0, 85.0),
    arrayOf(18.0, 80.0),
    arrayOf(19.0, 80.0),
    arrayOf(20.0, 80.0),
    arrayOf(21.0, 75.0),
    arrayOf(22.0, 75.0),
    arrayOf(23.0, 75.0),
    arrayOf(24.0, 70.0),
    arrayOf(25.0, 70.0),
    arrayOf(26.0, 70.0),
    arrayOf(27.0, 65.0),
    arrayOf(28.0, 65.0),
    arrayOf(29.0, 65.0),
    arrayOf(30.0, 60.0),
    arrayOf(31.0, 60.0),
    arrayOf(32.0, 60.0),
    arrayOf(33.0, 55.0),
    arrayOf(34.0, 55.0),
    arrayOf(35.0, 55.0),
    arrayOf(36.0, 45.0),
    arrayOf(37.0, 45.0),
    arrayOf(38.0, 45.0),
    arrayOf(39.0, 35.0),
    arrayOf(40.0, 35.0),
    arrayOf(41.0, 35.0),
    arrayOf(42.0, 30.0),
    arrayOf(43.0, 30.0),
    arrayOf(44.0, 30.0),
    arrayOf(45.0, 25.0),
    arrayOf(46.0, 25.0),
    arrayOf(47.0, 25.0),
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
 * Page 53
 */
fun habilidadesSocialesFragmentE8M3Baremo() = arrayOf(
    arrayOf(0.0, 99.0),
    arrayOf(1.0, 99.0),
    arrayOf(2.0, 99.0),
    arrayOf(3.0, 97.0),
    arrayOf(4.0, 97.0),
    arrayOf(5.0, 97.0),
    arrayOf(6.0, 95.0),
    arrayOf(7.0, 95.0),
    arrayOf(8.0, 95.0),
    arrayOf(9.0, 90.0),
    arrayOf(10.0, 90.0),
    arrayOf(11.0, 90.0),
    arrayOf(12.0, 80.0),
    arrayOf(13.0, 80.0),
    arrayOf(14.0, 80.0),
    arrayOf(15.0, 75.0),
    arrayOf(16.0, 75.0),
    arrayOf(17.0, 75.0),
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
    arrayOf(30.0, 47.0),
    arrayOf(31.0, 47.0),
    arrayOf(32.0, 47.0),
    arrayOf(33.0, 42.0),
    arrayOf(34.0, 42.0),
    arrayOf(35.0, 42.0),
    arrayOf(36.0, 40.0),
    arrayOf(37.0, 40.0),
    arrayOf(38.0, 40.0),
    arrayOf(39.0, 35.0),
    arrayOf(40.0, 35.0),
    arrayOf(41.0, 35.0),
    arrayOf(42.0, 30.0),
    arrayOf(43.0, 30.0),
    arrayOf(44.0, 30.0),
    arrayOf(45.0, 15.0),
    arrayOf(46.0, 15.0),
    arrayOf(47.0, 15.0),
    arrayOf(48.0, 10.0),
    arrayOf(49.0, 10.0),
    arrayOf(50.0, 10.0),
    arrayOf(51.0, 7.0),
    arrayOf(52.0, 7.0),
    arrayOf(53.0, 7.0),
    arrayOf(54.0, 5.0),
    arrayOf(55.0, 5.0),
    arrayOf(56.0, 5.0),
    arrayOf(57.0, 3.0),
    arrayOf(58.0, 3.0),
    arrayOf(59.0, 3.0),
    arrayOf(60.0, 1.0),

    )

/**
 * IV.- Lectura
 * A. Comprension Lectora
 *
 * Page 57
 */
fun comprensionLectoraE8M4Baremo() = arrayOf(
    arrayOf(39.0, 99.0, 3.25),
    arrayOf(37.0, 98.0, 2.97),
    arrayOf(35.0, 97.0, 2.69),
    arrayOf(33.0, 95.0, 2.41),
    arrayOf(31.0, 93.0, 2.13),
    arrayOf(29.0, 91.0, 1.85),
    arrayOf(27.0, 90.0, 1.57),
    arrayOf(25.0, 85.0, 1.29),
    arrayOf(23.0, 80.0, 1.01),
    arrayOf(21.0, 75.0, 0.73),
    arrayOf(19.0, 65.0, 0.44),
    arrayOf(17.0, 55.0, 0.16),
    arrayOf(15.0, 50.0, -0.12),
    arrayOf(13.0, 45.0, -0.4),
    arrayOf(11.0, 40.0, -0.68),
    arrayOf(9.0, 30.0, -0.96),
    arrayOf(7.0, 20.0, -1.24),
    arrayOf(5.0, 10.0, -1.52),
    arrayOf(3.0, 5.0, -1.8),
    arrayOf(1.0, 1.0, -2.08),
)

/**
 * IV.- Lectura
 * B. Eficacia Lectora
 *
 * Page 63
 */
fun eficaciaLectoraE8M4Baremo() = arrayOf(
    arrayOf(28.0, 99.0, 1.13),
    arrayOf(27.0, 92.0, 1.01),
    arrayOf(26.0, 90.0, 0.89),
    arrayOf(25.0, 80.0, 0.77),
    arrayOf(24.0, 75.0, 0.65),
    arrayOf(23.0, 70.0, 0.53),
    arrayOf(22.0, 65.0, 0.41),
    arrayOf(21.0, 60.0, 0.29),
    arrayOf(20.0, 55.0, 0.16),
    arrayOf(19.0, 50.0, 0.04),
    arrayOf(18.0, 45.0, -0.08),
    arrayOf(17.0, 40.0, -0.2),
    arrayOf(16.0, 35.0, -0.32),
    arrayOf(14.0, 30.0, -0.56),
    arrayOf(13.0, 25.0, -0.69),
    arrayOf(12.0, 20.0, -0.81),
    arrayOf(10.0, 15.0, -1.05),
    arrayOf(9.0, 10.0, -1.17),
    arrayOf(8.0, 7.0, -1.29),
    arrayOf(7.0, 5.0, -1.41),
    arrayOf(5.0, 2.0, -1.66),
)

/**
 * IV.- Lectura
 * C. Velocidad Lectora - Velocidad Fragment
 *
 * Page 67
 */
fun velocidadFragmentE8M4Baremo() = arrayOf(
    arrayOf(80.0, 99.0, 1.33),
    arrayOf(90.0, 97.0, 1.19),
    arrayOf(100.0, 95.0, 1.06),
    arrayOf(120.0, 90.0, 0.78),
    arrayOf(140.0, 80.0, 0.51),
    arrayOf(150.0, 75.0, 0.37),
    arrayOf(160.0, 70.0, 0.24),
    arrayOf(170.0, 60.0, 0.1),
    arrayOf(180.0, 50.0, -0.04),
    arrayOf(190.0, 47.0, -0.17),
    arrayOf(200.0, 45.0, -0.31),
    arrayOf(210.0, 40.0, -0.45),
    arrayOf(220.0, 30.0, -0.58),
    arrayOf(230.0, 25.0, -0.72),
    arrayOf(240.0, 22.0, -0.86),
    arrayOf(250.0, 20.0, -0.99),
    arrayOf(270.0, 15.0, -1.27),
    arrayOf(290.0, 14.0, -1.54),
    arrayOf(310.0, 12.0, -1.81),
    arrayOf(380.0, 10.0, -2.77),
    arrayOf(400.0, 8.0, -3.04),
    arrayOf(420.0, 6.0, -3.32),
    arrayOf(440.0, 4.0, -3.59),
    arrayOf(460.0, 2.0, -3.86)
)

/**
 * IV.- Lectura
 * C. Velocidad Lectora - Comprension Fragment
 *
 * Page 67
 */
fun comprensionFragmentE8M4Baremo() = arrayOf(
    arrayOf(15.0, 99.0, 4.4),
    arrayOf(14.0, 98.0, 4.01),
    arrayOf(13.0, 97.0, 3.62),
    arrayOf(12.0, 96.0, 3.23),
    arrayOf(11.0, 95.0, 2.84),
    arrayOf(10.0, 94.0, 2.45),
    arrayOf(9.0, 92.0, 2.06),
    arrayOf(8.0, 90.0, 1.67),
    arrayOf(7.0, 80.0, 1.28),
    arrayOf(6.0, 70.0, 0.89),
    arrayOf(5.0, 60.0, 0.51),
    arrayOf(4.0, 50.0, 0.12),
    arrayOf(3.0, 40.0, -0.27),
    arrayOf(2.0, 30.0, -0.66),
    arrayOf(1.0, 20.0, -1.05),
    arrayOf(0.0, 10.0, -1.44),
)

/**
 * V.- Escritura
 * A. Ortografia Visual y Reglada
 *
 * Page 75
 */
fun ortografiaVisualRegladaE8M5Baremo() = arrayOf(
    arrayOf(90.0, 99.0, 3.77),
    arrayOf(80.0, 98.0, 3.22),
    arrayOf(70.0, 97.0, 2.67),
    arrayOf(60.0, 95.0, 2.12),
    arrayOf(55.0, 93.0, 1.85),
    arrayOf(50.0, 90.0, 1.57),
    arrayOf(45.0, 88.0, 1.3),
    arrayOf(42.0, 85.0, 1.13),
    arrayOf(39.0, 80.0, 0.97),
    arrayOf(36.0, 75.0, 0.8),
    arrayOf(33.0, 70.0, 0.64),
    arrayOf(30.0, 65.0, 0.47),
    arrayOf(27.0, 60.0, 0.31),
    arrayOf(24.0, 55.0, 0.14),
    arrayOf(21.0, 50.0, -0.02),
    arrayOf(18.0, 47.0, -0.19),
    arrayOf(15.0, 45.0, -0.35),
    arrayOf(13.0, 42.0, -0.46),
    arrayOf(11.0, 40.0, -0.57),
    arrayOf(9.0, 35.0, -0.68),
    arrayOf(7.0, 25.0, -0.79),
    arrayOf(5.0, 15.0, -0.9),
    arrayOf(3.0, 10.0, -1.01),
    arrayOf(1.0, 5.0, -1.12),
    arrayOf(0.0, 1.0, -1.18),
)

/**
 * VI.- Aprendizajes Matematicos
 * A. Calculo y Numeracion
 *
 * Page 87
 */
fun calculoNumeracionE8M6Baremo() = arrayOf(
    arrayOf(36.0, 99.0, 2.99),
    arrayOf(34.0, 98.0, 2.7),
    arrayOf(32.0, 97.0, 2.41),
    arrayOf(27.0, 96.0, 1.69),
    arrayOf(26.0, 95.0, 1.55),
    arrayOf(24.0, 90.0, 1.26),
    arrayOf(22.0, 85.0, 0.97),
    arrayOf(21.0, 80.0, 0.82),
    arrayOf(19.0, 70.0, 0.53),
    arrayOf(18.0, 65.0, 0.39),
    arrayOf(17.0, 60.0, 0.25),
    arrayOf(16.0, 55.0, 0.1),
    arrayOf(15.0, 50.0, -0.04),
    arrayOf(14.0, 45.0, -0.19),
    arrayOf(13.0, 40.0, -0.33),
    arrayOf(12.0, 35.0, -0.48),
    arrayOf(11.0, 30.0, -0.62),
    arrayOf(10.0, 25.0, -0.77),
    arrayOf(9.0, 20.0, -0.91),
    arrayOf(8.0, 15.0, -1.05),
    arrayOf(6.0, 10.0, -1.34),
    arrayOf(4.0, 7.0, -1.63),
    arrayOf(2.0, 5.0, -1.92),
    arrayOf(1.0, 1.0, -2.07),
)

/**
 * VI.- Aprendizajes Matematicos
 * B. Resolucion de Problemas
 *
 * Page 93
 */
fun resolucionProblemasE8M6Baremo() = arrayOf(
    arrayOf(15.0, 99.0, 3.45),
    arrayOf(14.0, 98.0, 3.11),
    arrayOf(13.0, 97.0, 2.77),
    arrayOf(12.0, 96.0, 2.43),
    arrayOf(11.0, 95.0, 2.09),
    arrayOf(10.0, 92.0, 1.75),
    arrayOf(9.0, 90.0, 1.41),
    arrayOf(8.0, 82.0, 1.07),
    arrayOf(7.0, 75.0, 0.73),
    arrayOf(6.0, 65.0, 0.39),
    arrayOf(5.0, 55.0, 0.05),
    arrayOf(4.0, 40.0, -0.29),
    arrayOf(3.0, 30.0, -0.63),
    arrayOf(2.0, 20.0, -0.97),
    arrayOf(1.0, 10.0, -1.31),
)
