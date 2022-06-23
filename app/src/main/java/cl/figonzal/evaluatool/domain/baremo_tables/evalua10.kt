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
 * Evalua 10
 */
class Evalua10Baremo : BaremoTable {
    override fun getBaremo(baremo: String) = when (baremo) {

        "aten" -> atencionConcentracionE10M1Baremo()

        "razoi" -> razonamientoInductivoE10M2Baremo()
        "razoe" -> razonamientoEspacialE10M2Baremo()
        "razod" -> razonamientoDeductivoE10M2Baremo()

        "adapp" -> adaptacionPersonalFragmentE10M3Baremo()
        "adapf" -> adaptacionFamiliarFragmentE10M3Baremo()
        "adape" -> adaptacionEscolarFragmentE10M3Baremo()
        "habi" -> habilidadesSocialesFragmentE10M3Baremo()

        "compl" -> comprensionLectoraE10M4Baremo()
        "velo" -> velocidadFragmentE10M4Baremo()
        "compf" -> comprensionFragmentE10M4Baremo()

        "ortov" -> ortografiaVisualRegladaE10M5Baremo()

        "calc" -> calculoNumeracionE10M6Baremo()
        "resol" -> resolucionProblemasE10M6Baremo()

        else -> emptyArray()
    }

    override fun getBaremo(baremo: BaseConstants): Array<Array<Double>> {
        return emptyArray()
    }
}

/**
 * I.- Atencion - Concentracion
 *
 * Page 29
 */
fun atencionConcentracionE10M1Baremo() = arrayOf(
    arrayOf(165.0, 99.0, 1.21),
    arrayOf(162.0, 95.0, 1.08),
    arrayOf(160.0, 90.0, 1.0),
    arrayOf(157.0, 85.0, 0.88),
    arrayOf(155.0, 80.0, 0.8),
    arrayOf(150.0, 70.0, 0.59),
    arrayOf(145.0, 60.0, 0.38),
    arrayOf(140.0, 55.0, 0.18),
    arrayOf(135.0, 50.0, -0.03),
    arrayOf(130.0, 40.0, -0.23),
    arrayOf(125.0, 30.0, -0.44),
    arrayOf(120.0, 20.0, -0.65),
    arrayOf(115.0, 15.0, -0.85),
    arrayOf(110.0, 10.0, -1.06),
    arrayOf(105.0, 8.0, -1.26),
    arrayOf(100.0, 6.0, -1.47),
    arrayOf(95.0, 5.0, -1.68),
    arrayOf(90.0, 4.0, -1.88),
    arrayOf(85.0, 3.0, -2.09),
    arrayOf(80.0, 2.0, -2.29),
    arrayOf(75.0, 1.0, -2.5),
)

/**
 * II.- Razonamiento
 * A.- Razonamiento Inductivo
 *
 * Page 35
 */
fun razonamientoInductivoE10M2Baremo() = arrayOf(
    arrayOf(25.0, 99.0, 2.24),
    arrayOf(24.0, 97.0, 2.07),
    arrayOf(23.0, 95.0, 1.89),
    arrayOf(22.0, 94.0, 1.72),
    arrayOf(21.0, 92.0, 1.54),
    arrayOf(20.0, 90.0, 1.37),
    arrayOf(19.0, 85.0, 1.19),
    arrayOf(18.0, 80.0, 1.02),
    arrayOf(17.0, 75.0, 0.84),
    arrayOf(16.0, 70.0, 0.67),
    arrayOf(15.0, 65.0, 0.5),
    arrayOf(14.0, 60.0, 0.32),
    arrayOf(13.0, 55.0, 0.15),
    arrayOf(12.0, 50.0, -0.03),
    arrayOf(11.0, 45.0, -0.2),
    arrayOf(10.0, 40.0, -0.38),
    arrayOf(9.0, 35.0, -0.55),
    arrayOf(8.0, 30.0, -0.73),
    arrayOf(7.0, 25.0, -0.9),
    arrayOf(6.0, 20.0, -1.08),
    arrayOf(5.0, 15.0, -1.25),
    arrayOf(4.0, 10.0, -1.42),
    arrayOf(3.0, 7.0, -1.6),
    arrayOf(2.0, 5.0, -1.77),
    arrayOf(1.0, 1.0, -1.95),
)

/**
 * II.- Razonamiento
 * B.- Razonamiento Espacial
 *
 * Page 41
 */
fun razonamientoEspacialE10M2Baremo() = arrayOf(
    arrayOf(22.0, 99.0, 1.52),
    arrayOf(21.0, 95.0, 1.32),
    arrayOf(20.0, 85.0, 1.13),
    arrayOf(19.0, 75.0, 0.93),
    arrayOf(18.0, 70.0, 0.74),
    arrayOf(17.0, 65.0, 0.54),
    arrayOf(16.0, 60.0, 0.35),
    arrayOf(15.0, 55.0, 0.15),
    arrayOf(14.0, 50.0, -0.04),
    arrayOf(13.0, 45.0, -0.24),
    arrayOf(12.0, 40.0, -0.43),
    arrayOf(11.0, 35.0, -0.63),
    arrayOf(10.0, 30.0, -0.82),
    arrayOf(9.0, 25.0, -1.02),
    arrayOf(8.0, 15.0, -1.21),
    arrayOf(7.0, 10.0, -1.41),
    arrayOf(6.0, 5.0, -1.61),
    arrayOf(5.0, 3.0, -1.8),
    arrayOf(4.0, 1.0, -2.0),
)

/**
 * II.- Razonamiento
 * C.- Razonamiento Deductivo
 *
 * Page 45
 */
fun razonamientoDeductivoE10M2Baremo() = arrayOf(
    arrayOf(30.0, 99.0, 2.44),
    arrayOf(29.0, 97.0, 2.28),
    arrayOf(28.0, 95.0, 2.12),
    arrayOf(27.0, 92.0, 1.96),
    arrayOf(26.0, 90.0, 1.8),
    arrayOf(25.0, 87.0, 1.64),
    arrayOf(24.0, 85.0, 1.48),
    arrayOf(23.0, 83.0, 1.32),
    arrayOf(22.0, 80.0, 1.16),
    arrayOf(21.0, 77.0, 1.0),
    arrayOf(20.0, 75.0, 0.84),
    arrayOf(19.0, 70.0, 0.68),
    arrayOf(18.0, 65.0, 0.52),
    arrayOf(17.0, 60.0, 0.36),
    arrayOf(16.0, 55.0, 0.2),
    arrayOf(15.0, 50.0, 0.04),
    arrayOf(14.0, 45.0, -0.12),
    arrayOf(13.0, 40.0, -0.28),
    arrayOf(12.0, 37.0, -0.44),
    arrayOf(11.0, 35.0, -0.6),
    arrayOf(10.0, 30.0, -0.76),
    arrayOf(9.0, 25.0, -0.92),
    arrayOf(8.0, 20.0, -1.08),
    arrayOf(7.0, 15.0, -1.24),
    arrayOf(6.0, 12.0, -1.4),
    arrayOf(5.0, 10.0, -1.56),
    arrayOf(4.0, 7.0, -1.72),
    arrayOf(3.0, 5.0, -1.88),
    arrayOf(2.0, 3.0, -2.04),
    arrayOf(1.0, 2.0, -2.2),
    arrayOf(0.0, 1.0, -2.36),
)

/**
 * III.- Niveles Adaptacion
 * A.- Adaptacion Personal
 *
 * Page 53
 */
fun adaptacionPersonalFragmentE10M3Baremo() = arrayOf(
    arrayOf(0.0, 99.0, 1.65),
    arrayOf(1.0, 99.0, 1.57),
    arrayOf(2.0, 99.0, 1.49),
    arrayOf(3.0, 95.0, 1.41),
    arrayOf(4.0, 95.0, 1.32),
    arrayOf(5.0, 95.0, 1.24),
    arrayOf(6.0, 90.0, 1.16),
    arrayOf(7.0, 90.0, 1.08),
    arrayOf(8.0, 90.0, 1.0),
    arrayOf(9.0, 80.0, 0.92),
    arrayOf(10.0, 80.0, 0.84),
    arrayOf(11.0, 80.0, 0.75),
    arrayOf(12.0, 75.0, 0.67),
    arrayOf(13.0, 75.0, 0.59),
    arrayOf(14.0, 75.0, 0.51),
    arrayOf(15.0, 70.0, 0.43),
    arrayOf(16.0, 70.0, 0.35),
    arrayOf(17.0, 70.0, 0.27),
    arrayOf(18.0, 60.0, 0.18),
    arrayOf(19.0, 60.0, 0.1),
    arrayOf(20.0, 60.0, 0.02),
    arrayOf(21.0, 55.0, -0.06),
    arrayOf(22.0, 55.0, -0.14),
    arrayOf(23.0, 55.0, -0.22),
    arrayOf(24.0, 50.0, -0.3),
    arrayOf(25.0, 50.0, -0.38),
    arrayOf(26.0, 50.0, -0.47),
    arrayOf(27.0, 45.0, -0.55),
    arrayOf(28.0, 45.0, -0.63),
    arrayOf(29.0, 45.0, -0.71),
    arrayOf(30.0, 40.0, -0.79),
    arrayOf(31.0, 40.0, -0.87),
    arrayOf(32.0, 40.0, -0.95),
    arrayOf(33.0, 35.0, -1.04),
    arrayOf(34.0, 35.0, -1.12),
    arrayOf(35.0, 35.0, -1.2),
    arrayOf(36.0, 30.0, -1.28),
    arrayOf(37.0, 30.0, -1.36),
    arrayOf(38.0, 30.0, -1.44),
    arrayOf(39.0, 25.0, -1.52),
    arrayOf(40.0, 25.0, -1.61),
    arrayOf(41.0, 25.0, -1.69),
    arrayOf(42.0, 20.0, -1.77),
    arrayOf(43.0, 20.0, -1.85),
    arrayOf(44.0, 20.0, -1.93),
    arrayOf(45.0, 15.0, -2.01),
    arrayOf(46.0, 15.0, -2.09),
    arrayOf(47.0, 15.0, -2.17),
    arrayOf(48.0, 10.0, -2.26),
    arrayOf(49.0, 10.0, -2.34),
    arrayOf(50.0, 10.0, -2.42),
    arrayOf(51.0, 7.0, -2.5),
    arrayOf(52.0, 7.0, -2.58),
    arrayOf(53.0, 7.0, -2.66),
    arrayOf(54.0, 5.0, -2.74),
    arrayOf(55.0, 5.0, -2.83),
    arrayOf(56.0, 5.0, -2.91),
    arrayOf(57.0, 3.0, -2.99),
    arrayOf(58.0, 3.0, -3.07),
    arrayOf(59.0, 3.0, -3.15),
    arrayOf(60.0, 1.0, -3.23),
)

/**
 * III.- Niveles Adaptacion
 * B.- Adaptacion Familiar
 *
 * Page 53
 */
fun adaptacionFamiliarFragmentE10M3Baremo() = arrayOf(
    arrayOf(0.0, 99.0, 2.4),
    arrayOf(1.0, 99.0, 2.28),
    arrayOf(2.0, 99.0, 2.16),
    arrayOf(3.0, 95.0, 2.05),
    arrayOf(4.0, 95.0, 1.93),
    arrayOf(5.0, 95.0, 1.81),
    arrayOf(6.0, 90.0, 1.69),
    arrayOf(7.0, 90.0, 1.58),
    arrayOf(8.0, 90.0, 1.46),
    arrayOf(9.0, 80.0, 1.34),
    arrayOf(10.0, 80.0, 1.22),
    arrayOf(11.0, 80.0, 1.11),
    arrayOf(12.0, 70.0, 0.99),
    arrayOf(13.0, 70.0, 0.87),
    arrayOf(14.0, 70.0, 0.75),
    arrayOf(15.0, 60.0, 0.64),
    arrayOf(16.0, 60.0, 0.52),
    arrayOf(17.0, 60.0, 0.4),
    arrayOf(18.0, 55.0, 0.28),
    arrayOf(19.0, 55.0, 0.17),
    arrayOf(20.0, 55.0, 0.05),
    arrayOf(21.0, 50.0, -0.07),
    arrayOf(22.0, 50.0, -0.19),
    arrayOf(23.0, 50.0, -0.3),
    arrayOf(24.0, 40.0, -0.42),
    arrayOf(25.0, 40.0, -0.54),
    arrayOf(26.0, 40.0, -0.66),
    arrayOf(27.0, 30.0, -0.77),
    arrayOf(28.0, 30.0, -0.89),
    arrayOf(29.0, 30.0, -1.01),
    arrayOf(30.0, 20.0, -1.13),
    arrayOf(31.0, 20.0, -1.24),
    arrayOf(32.0, 20.0, -1.36),
    arrayOf(33.0, 15.0, -1.48),
    arrayOf(34.0, 15.0, -1.6),
    arrayOf(35.0, 15.0, -1.71),
    arrayOf(36.0, 10.0, -1.83),
    arrayOf(37.0, 10.0, -1.95),
    arrayOf(38.0, 10.0, -2.07),
    arrayOf(39.0, 7.0, -2.18),
    arrayOf(40.0, 7.0, -2.3),
    arrayOf(41.0, 7.0, -2.42),
    arrayOf(42.0, 6.0, -2.54),
    arrayOf(43.0, 6.0, -2.65),
    arrayOf(44.0, 6.0, -2.77),
    arrayOf(45.0, 5.0, -2.89),
    arrayOf(46.0, 5.0, -3.01),
    arrayOf(47.0, 5.0, -3.12),
    arrayOf(48.0, 4.0, -3.24),
    arrayOf(49.0, 4.0, -3.36),
    arrayOf(50.0, 4.0, -3.48),
    arrayOf(51.0, 3.0, -3.59),
    arrayOf(52.0, 3.0, -3.71),
    arrayOf(53.0, 3.0, -3.83),
    arrayOf(54.0, 2.0, -3.95),
    arrayOf(55.0, 2.0, -4.06),
    arrayOf(56.0, 2.0, -4.18),
    arrayOf(57.0, 1.0, -4.3),
    arrayOf(58.0, 1.0, -4.42),
    arrayOf(59.0, 1.0, -4.53),
    arrayOf(60.0, 0.0, -4.65),
)

/**
 * III.- Niveles Adaptacion
 * C.- Adaptacion Escolar
 *
 * Page 53
 */
fun adaptacionEscolarFragmentE10M3Baremo() = arrayOf(
    arrayOf(0.0, 99.0, 2.02),
    arrayOf(1.0, 99.0, 1.93),
    arrayOf(2.0, 99.0, 1.83),
    arrayOf(3.0, 85.0, 1.73),
    arrayOf(4.0, 85.0, 1.63),
    arrayOf(5.0, 85.0, 1.54),
    arrayOf(6.0, 80.0, 1.44),
    arrayOf(7.0, 80.0, 1.34),
    arrayOf(8.0, 80.0, 1.24),
    arrayOf(9.0, 75.0, 1.14),
    arrayOf(10.0, 75.0, 1.05),
    arrayOf(11.0, 75.0, 0.95),
    arrayOf(12.0, 70.0, 0.85),
    arrayOf(13.0, 70.0, 0.75),
    arrayOf(14.0, 70.0, 0.66),
    arrayOf(15.0, 60.0, 0.56),
    arrayOf(16.0, 60.0, 0.46),
    arrayOf(17.0, 60.0, 0.36),
    arrayOf(18.0, 50.0, 0.27),
    arrayOf(19.0, 50.0, 0.17),
    arrayOf(20.0, 50.0, 0.07),
    arrayOf(21.0, 40.0, -0.03),
    arrayOf(22.0, 40.0, -0.13),
    arrayOf(23.0, 40.0, -0.22),
    arrayOf(24.0, 30.0, -0.32),
    arrayOf(25.0, 30.0, -0.42),
    arrayOf(26.0, 30.0, -0.52),
    arrayOf(27.0, 25.0, -0.61),
    arrayOf(28.0, 25.0, -0.71),
    arrayOf(29.0, 25.0, -0.81),
    arrayOf(30.0, 20.0, -0.91),
    arrayOf(31.0, 20.0, -1.0),
    arrayOf(32.0, 20.0, -1.1),
    arrayOf(33.0, 15.0, -1.2),
    arrayOf(34.0, 15.0, -1.3),
    arrayOf(35.0, 15.0, -1.39),
    arrayOf(36.0, 10.0, -1.49),
    arrayOf(37.0, 10.0, -1.59),
    arrayOf(38.0, 10.0, -1.69),
    arrayOf(39.0, 8.0, -1.79),
    arrayOf(40.0, 8.0, -1.88),
    arrayOf(41.0, 8.0, -1.98),
    arrayOf(42.0, 7.0, -2.08),
    arrayOf(43.0, 7.0, -2.18),
    arrayOf(44.0, 7.0, -2.27),
    arrayOf(45.0, 6.0, -2.37),
    arrayOf(46.0, 6.0, -2.47),
    arrayOf(47.0, 6.0, -2.57),
    arrayOf(48.0, 4.0, -2.66),
    arrayOf(49.0, 4.0, -2.76),
    arrayOf(50.0, 4.0, -2.86),
    arrayOf(51.0, 3.0, -2.96),
    arrayOf(52.0, 3.0, -3.05),
    arrayOf(53.0, 3.0, -3.15),
    arrayOf(54.0, 2.0, -3.25),
    arrayOf(55.0, 2.0, -3.35),
    arrayOf(56.0, 2.0, -3.45),
    arrayOf(57.0, 1.0, -3.54),
    arrayOf(58.0, 1.0, -3.64),
    arrayOf(59.0, 1.0, -3.74),
    arrayOf(60.0, 0.0, -3.84),
)

/**
 * III.- Niveles Adaptacion
 * D.- Habilidades Sociales
 *
 * Page 53
 */
fun habilidadesSocialesFragmentE10M3Baremo() = arrayOf(
    arrayOf(0.0, 99.0, 2.65),
    arrayOf(1.0, 99.0, 2.54),
    arrayOf(2.0, 99.0, 2.43),
    arrayOf(3.0, 95.0, 2.32),
    arrayOf(4.0, 95.0, 2.21),
    arrayOf(5.0, 95.0, 2.1),
    arrayOf(6.0, 90.0, 2.0),
    arrayOf(7.0, 90.0, 1.89),
    arrayOf(8.0, 90.0, 1.78),
    arrayOf(9.0, 85.0, 1.67),
    arrayOf(10.0, 85.0, 1.56),
    arrayOf(11.0, 85.0, 1.45),
    arrayOf(12.0, 80.0, 1.34),
    arrayOf(13.0, 80.0, 1.24),
    arrayOf(14.0, 80.0, 1.13),
    arrayOf(15.0, 75.0, 1.02),
    arrayOf(16.0, 75.0, 0.91),
    arrayOf(17.0, 75.0, 0.8),
    arrayOf(18.0, 70.0, 0.69),
    arrayOf(19.0, 70.0, 0.58),
    arrayOf(20.0, 70.0, 0.48),
    arrayOf(21.0, 60.0, 0.37),
    arrayOf(22.0, 60.0, 0.26),
    arrayOf(23.0, 60.0, 0.15),
    arrayOf(24.0, 50.0, 0.04),
    arrayOf(25.0, 50.0, -0.07),
    arrayOf(26.0, 50.0, -0.18),
    arrayOf(27.0, 40.0, -0.28),
    arrayOf(28.0, 40.0, -0.39),
    arrayOf(29.0, 40.0, -0.5),
    arrayOf(30.0, 30.0, -0.61),
    arrayOf(31.0, 30.0, -0.72),
    arrayOf(32.0, 30.0, -0.83),
    arrayOf(33.0, 20.0, -0.94),
    arrayOf(34.0, 20.0, -1.04),
    arrayOf(35.0, 20.0, -1.15),
    arrayOf(36.0, 15.0, -1.26),
    arrayOf(37.0, 15.0, -1.37),
    arrayOf(38.0, 15.0, -1.48),
    arrayOf(39.0, 10.0, -1.59),
    arrayOf(40.0, 10.0, -1.7),
    arrayOf(41.0, 10.0, -1.8),
    arrayOf(42.0, 7.0, -1.91),
    arrayOf(43.0, 7.0, -2.02),
    arrayOf(44.0, 7.0, -2.13),
    arrayOf(45.0, 5.0, -2.24),
    arrayOf(46.0, 5.0, -2.35),
    arrayOf(47.0, 5.0, -2.46),
    arrayOf(48.0, 4.0, -2.56),
    arrayOf(49.0, 4.0, -2.67),
    arrayOf(50.0, 4.0, -2.78),
    arrayOf(51.0, 1.0, -2.89),
    arrayOf(52.0, 1.0, -3.0),
    arrayOf(53.0, 1.0, -3.11),
    arrayOf(54.0, 0.0, -3.22),
    arrayOf(55.0, 0.0, -3.32),
    arrayOf(56.0, 0.0, -3.43),
)

/**
 * IV.- Lectura
 * A.- Comprension Lectura
 *
 * Page 57
 */
fun comprensionLectoraE10M4Baremo() = arrayOf(
    arrayOf(35.0, 99.0, 3.29),
    arrayOf(34.0, 98.0, 3.11),
    arrayOf(33.0, 97.0, 2.93),
    arrayOf(32.0, 96.0, 2.75),
    arrayOf(31.0, 95.0, 2.57),
    arrayOf(30.0, 94.0, 2.38),
    arrayOf(29.0, 93.0, 2.2),
    arrayOf(28.0, 92.0, 2.02),
    arrayOf(27.0, 91.0, 1.84),
    arrayOf(26.0, 90.0, 1.66),
    arrayOf(25.0, 88.0, 1.48),
    arrayOf(24.0, 85.0, 1.3),
    arrayOf(23.0, 80.0, 1.11),
    arrayOf(22.0, 75.0, 0.93),
    arrayOf(21.0, 70.0, 0.75),
    arrayOf(20.0, 65.0, 0.57),
    arrayOf(19.0, 60.0, 0.39),
    arrayOf(18.0, 55.0, 0.21),
    arrayOf(17.0, 50.0, 0.03),
    arrayOf(16.0, 45.0, -0.16),
    arrayOf(15.0, 40.0, -0.34),
    arrayOf(14.0, 35.0, -0.52),
    arrayOf(13.0, 30.0, -0.7),
    arrayOf(12.0, 25.0, -0.88),
    arrayOf(11.0, 20.0, -1.06),
    arrayOf(10.0, 18.0, -1.25),
    arrayOf(9.0, 15.0, -1.43),
    arrayOf(8.0, 11.0, -1.61),
    arrayOf(7.0, 10.0, -1.79),
    arrayOf(6.0, 9.0, -1.97),
    arrayOf(5.0, 7.0, -2.15),
    arrayOf(4.0, 5.0, -2.33),
    arrayOf(3.0, 3.0, -2.52),
    arrayOf(2.0, 2.0, -2.7),
    arrayOf(1.0, 1.0, -2.88),
)

/**
 * IV.- Lectura
 * B.- Velocidad Lectora - Velocidad Fragment
 *
 * Page 63
 */
fun velocidadFragmentE10M4Baremo() = arrayOf(
    arrayOf(120.0, 99.0, 3.19),
    arrayOf(150.0, 95.0, 2.32),
    arrayOf(170.0, 90.0, 1.75),
    arrayOf(180.0, 85.0, 1.46),
    arrayOf(190.0, 80.0, 1.17),
    arrayOf(200.0, 70.0, .88),
    arrayOf(210.0, 60.0, 0.59),
    arrayOf(220.0, 55.0, 0.3),
    arrayOf(230.0, 50.0, 0.01),
    arrayOf(240.0, 45.0, -0.28),
    arrayOf(250.0, 40.0, -0.57),
    arrayOf(260.0, 35.0, -0.86),
    arrayOf(270.0, 30.0, -1.15),
    arrayOf(280.0, 25.0, -1.44),
    arrayOf(290.0, 20.0, -1.73),
    arrayOf(300.0, 15.0, -2.02),
    arrayOf(310.0, 10.0, -2.31),
    arrayOf(330.0, 7.0, -2.89),
    arrayOf(345.0, 5.0, -3.32),
    arrayOf(360.0, 3.0, -3.76),
    arrayOf(420.0, 1.0, -5.5),
)

/**
 * IV.- Lectura
 * B.- Velocidad Lectora - Comprension Fragment
 *
 * Page 63
 */
fun comprensionFragmentE10M4Baremo() = arrayOf(
    arrayOf(15.0, 99.0, 0.99),
    arrayOf(14.0, 95.0, 0.86),
    arrayOf(13.0, 90.0, 0.72),
    arrayOf(12.0, 85.0, 0.59),
    arrayOf(11.0, 80.0, 0.46),
    arrayOf(10.0, 75.0, 0.33),
    arrayOf(9.0, 65.0, 0.19),
    arrayOf(8.0, 50.0, 0.06),
    arrayOf(7.0, 35.0, -0.07),
    arrayOf(6.0, 25.0, -0.2),
    arrayOf(5.0, 20.0, -0.34),
    arrayOf(4.0, 10.0, -0.47),
    arrayOf(3.0, 8.0, -0.6),
    arrayOf(2.0, 5.0, -0.73),
    arrayOf(1.0, 4.0, -0.86),
    arrayOf(0.0, 1.0, -1.0),
)

/**
 * V. Escritura
 * A. Ortografía Visual y Reglada
 *
 * Page 71
 */
fun ortografiaVisualRegladaE10M5Baremo() = arrayOf(
    arrayOf(70.0, 99.0, 1.56),
    arrayOf(68.0, 98.0, 1.41),
    arrayOf(66.0, 96.0, 1.27),
    arrayOf(64.0, 95.0, 1.13),
    arrayOf(62.0, 93.0, 0.99),
    arrayOf(60.0, 90.0, 0.85),
    arrayOf(58.0, 85.0, 0.71),
    arrayOf(56.0, 75.0, 0.57),
    arrayOf(54.0, 70.0, 0.43),
    arrayOf(52.0, 60.0, 0.29),
    arrayOf(50.0, 55.0, 0.15),
    arrayOf(48.0, 50.0, 0.01),
    arrayOf(46.0, 45.0, -0.13),
    arrayOf(44.0, 40.0, -0.27),
    arrayOf(42.0, 35.0, -0.41),
    arrayOf(40.0, 30.0, -0.55),
    arrayOf(38.0, 25.0, -0.69),
    arrayOf(36.0, 20.0, -0.83),
    arrayOf(34.0, 18.0, -0.97),
    arrayOf(32.0, 15.0, -1.11),
    arrayOf(30.0, 12.0, -1.25),
    arrayOf(28.0, 10.0, -1.39),
    arrayOf(26.0, 7.0, -1.53),
    arrayOf(24.0, 5.0, -1.67),
    arrayOf(22.0, 3.0, -1.81),
    arrayOf(20.0, 2.0, -1.95),
    arrayOf(18.0, 1.0, -2.09),
)

/**
 * VI. Aprendizajes Matemáticos
 * A. Calculo y Numeracion
 *
 * Page 79
 */
fun calculoNumeracionE10M6Baremo() = arrayOf(
    arrayOf(30.0, 99.0, 2.41),
    arrayOf(29.0, 99.0, 2.24),
    arrayOf(28.0, 99.0, 2.08),
    arrayOf(27.0, 99.0, 1.91),
    arrayOf(26.0, 95.0, 1.74),
    arrayOf(25.0, 92.0, 1.58),
    arrayOf(24.0, 90.0, 1.41),
    arrayOf(23.0, 85.0, 1.24),
    arrayOf(22.0, 80.0, 1.08),
    arrayOf(21.0, 75.0, 0.91),
    arrayOf(20.0, 70.0, 0.75),
    arrayOf(19.0, 65.0, 0.58),
    arrayOf(18.0, 60.0, 0.41),
    arrayOf(17.0, 55.0, 0.25),
    arrayOf(16.0, 50.0, 0.08),
    arrayOf(15.0, 45.0, -0.09),
    arrayOf(14.0, 40.0, -0.25),
    arrayOf(13.0, 35.0, -0.42),
    arrayOf(12.0, 30.0, -0.59),
    arrayOf(11.0, 25.0, -0.75),
    arrayOf(10.0, 20.0, -0.92),
    arrayOf(9.0, 15.0, -1.08),
    arrayOf(8.0, 10.0, -1.25),
    arrayOf(6.0, 7.0, -1.58),
    arrayOf(5.0, 5.0, -1.75),
    arrayOf(4.0, 3.0, -1.92),
    arrayOf(3.0, 1.0, -2.08),
)

/**
 * VI. Aprendizajes Matemáticos
 * B. Resolucion de Problemas
 *
 * Page 85
 */
fun resolucionProblemasE10M6Baremo() = arrayOf(
    arrayOf(18.0, 99.0, 2.95),
    arrayOf(17.0, 97.0, 2.68),
    arrayOf(16.0, 96.0, 2.4),
    arrayOf(15.0, 95.0, 2.13),
    arrayOf(14.0, 90.0, 1.86),
    arrayOf(13.0, 85.0, 1.59),
    arrayOf(12.0, 80.0, 1.32),
    arrayOf(11.0, 75.0, 1.05),
    arrayOf(10.0, 70.0, 0.77),
    arrayOf(9.0, 60.0, 0.5),
    arrayOf(8.0, 55.0, 0.23),
    arrayOf(7.0, 50.0, -0.04),
    arrayOf(6.0, 45.0, -0.31),
    arrayOf(5.0, 40.0, -0.58),
    arrayOf(4.0, 30.0, -0.86),
    arrayOf(3.0, 20.0, -1.13),
    arrayOf(2.0, 10.0, -1.4),
    arrayOf(1.0, 5.0, -1.67),
)




