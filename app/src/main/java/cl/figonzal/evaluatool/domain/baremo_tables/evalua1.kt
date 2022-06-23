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
 * Evalua 1
 */
class Evalua1Baremo : BaremoTable {

    override fun getBaremo(baremo: EvaluaConstants): Array<Array<Double>> {
        return emptyArray()
    }

    override fun getBaremo(baremo: String) = when (baremo) {
        "memo" -> memoriaAtencionE1M1Baremo()

        "series" -> seriesE1M2Baremo()
        "clasif" -> clasificacionesE1M2Baremo()
        "orga" -> organizacionPerceptivaE1M2Baremo()

        "moti" -> motivacionFragmentE1M3Baremo()
        "auto" -> autoControlFragmentE1M3Baremo()
        "conduct" -> conductaProSocialFragmentE1M3Baremo()
        "esti" -> autoEstimaFragmentE1M3Baremo()

        "comp" -> comprensionLectoraE1M4Baremo()
        "exact" -> exactitudLectoraE1M4Baremo()

        "ortof" -> ortografiaFoneticaE1M5Baremo()
        "ortov" -> ortografiaVisualE1M5Baremo()

        "calc" -> calculoNumeracionE1M6Baremo()

        else -> emptyArray()
    }
}

/**
 * I.- Memoria y Atencion
 * A. Memoria y Atencion
 * Page 27
 */
private fun memoriaAtencionE1M1Baremo() = arrayOf(
    arrayOf(68.0, 99.0, 1.44),
    arrayOf(67.0, 97.0, 1.37),
    arrayOf(66.0, 95.0, 1.29),
    arrayOf(65.0, 93.0, 1.21),
    arrayOf(64.0, 90.0, 1.13),
    arrayOf(63.0, 87.0, 1.06),
    arrayOf(62.0, 85.0, 0.98),
    arrayOf(61.0, 80.0, 0.9),
    arrayOf(60.0, 75.0, 0.82),
    arrayOf(59.0, 72.0, 0.74),
    arrayOf(58.0, 70.0, 0.67),
    arrayOf(57.0, 65.0, 0.59),
    arrayOf(56.0, 62.0, 0.51),
    arrayOf(55.0, 60.0, 0.43),
    arrayOf(54.0, 57.0, 0.36),
    arrayOf(53.0, 55.0, 0.28),
    arrayOf(52.0, 52.0, 0.2),
    arrayOf(51.0, 50.0, 0.12),
    arrayOf(50.0, 47.0, 0.05),
    arrayOf(49.0, 45.0, -0.03),
    arrayOf(48.0, 43.0, -0.11),
    arrayOf(47.0, 40.0, -0.19),
    arrayOf(46.0, 37.0, -0.26),
    arrayOf(45.0, 35.0, -0.34),
    arrayOf(44.0, 32.0, -0.42),
    arrayOf(43.0, 30.0, -0.5),
    arrayOf(40.0, 25.0, -0.73),
    arrayOf(37.0, 20.0, -0.96),
    arrayOf(34.0, 15.0, -1.19),
    arrayOf(31.0, 10.0, -1.43),
    arrayOf(28.0, 7.0, -1.66),
    arrayOf(25.0, 5.0, -1.89),
    arrayOf(22.0, 1.0, -2.12),
)

/**
 * II.- Bases del razonamiento
 * A. Series
 * Page 33
 */
private fun seriesE1M2Baremo() = arrayOf(
    arrayOf(24.0, 95.0, 1.19),
    arrayOf(23.0, 90.0, 1.06),
    arrayOf(22.0, 85.0, 0.94),
    arrayOf(21.0, 80.0, 0.81),
    arrayOf(20.0, 70.0, 0.69),
    arrayOf(19.0, 65.0, 0.56),
    arrayOf(18.0, 60.0, 0.44),
    arrayOf(17.0, 55.0, 0.31),
    arrayOf(16.0, 50.0, 0.19),
    arrayOf(15.0, 45.0, 0.06),
    arrayOf(14.0, 43.0, -0.06),
    arrayOf(13.0, 40.0, -0.19),
    arrayOf(12.0, 37.0, -0.31),
    arrayOf(11.0, 35.0, -0.44),
    arrayOf(10.0, 30.0, -0.56),
    arrayOf(9.0, 25.0, -0.69),
    arrayOf(8.0, 20.0, -0.81),
    arrayOf(7.0, 15.0, -0.94),
    arrayOf(6.0, 10.0, -1.06),
    arrayOf(5.0, 7.0, -1.19),
    arrayOf(4.0, 5.0, -1.31),
    arrayOf(3.0, 1.0, -1.44),
)

/**
 * II.- Bases del razonamiento
 * B. Clasificaciones
 * Page 39
 */
private fun clasificacionesE1M2Baremo() = arrayOf(
    arrayOf(20.0, 99.0, 2.3),
    arrayOf(19.0, 98.0, 2.09),
    arrayOf(18.0, 97.0, 1.89),
    arrayOf(17.0, 95.0, 1.68),
    arrayOf(16.0, 92.0, 1.48),
    arrayOf(15.0, 90.0, 1.27),
    arrayOf(14.0, 85.0, 1.07),
    arrayOf(13.0, 80.0, 0.86),
    arrayOf(12.0, 70.0, 0.66),
    arrayOf(11.0, 65.0, 0.45),
    arrayOf(10.0, 55.0, 0.25),
    arrayOf(9.0, 50.0, 0.04),
    arrayOf(8.0, 45.0, -0.16),
    arrayOf(7.0, 40.0, -0.37),
    arrayOf(6.0, 30.0, -0.57),
    arrayOf(5.0, 25.0, -0.78),
    arrayOf(4.0, 20.0, -0.99),
    arrayOf(3.0, 15.0, -1.19),
    arrayOf(2.0, 10.0, -1.4),
    arrayOf(1.0, 5.0, -1.6),
    arrayOf(0.0, 1.0, -1.81)
)

/**
 * II.- Bases del razonamiento
 * C. Organizacion Perceptiva
 * Page 45
 */
private fun organizacionPerceptivaE1M2Baremo() = arrayOf(
    arrayOf(52.0, 99.0, 1.23),
    arrayOf(51.0, 95.0, 1.14),
    arrayOf(50.0, 92.0, 1.06),
    arrayOf(49.0, 90.0, 0.97),
    arrayOf(48.0, 85.0, 0.88),
    arrayOf(47.0, 80.0, 0.79),
    arrayOf(46.0, 75.0, 0.7),
    arrayOf(45.0, 70.0, 0.62),
    arrayOf(44.0, 67.0, 0.53),
    arrayOf(43.0, 62.0, 0.44),
    arrayOf(42.0, 60.0, 0.35),
    arrayOf(41.0, 57.0, 0.26),
    arrayOf(40.0, 55.0, 0.18),
    arrayOf(39.0, 52.0, 0.09),
    arrayOf(38.0, 50.0, 0.0),
    arrayOf(37.0, 45.0, -0.09),
    arrayOf(36.0, 42.0, -0.18),
    arrayOf(35.0, 40.0, -0.26),
    arrayOf(34.0, 37.0, -0.35),
    arrayOf(33.0, 35.0, -0.44),
    arrayOf(32.0, 32.0, -0.53),
    arrayOf(29.0, 30.0, -0.79),
    arrayOf(26.0, 25.0, -1.06),
    arrayOf(23.0, 20.0, -1.32),
    arrayOf(20.0, 15.0, -1.59),
    arrayOf(17.0, 10.0, -1.85),
    arrayOf(14.0, 7.0, -2.11),
    arrayOf(11.0, 5.0, -2.38),
    arrayOf(8.0, 1.0, -2.64),
)

/**
 * III.- Niveles de Adaptacion
 * A. Motivacion
 * Page 53
 */
private fun motivacionFragmentE1M3Baremo() = arrayOf(
    arrayOf(45.0, 99.0, 1.74),
    arrayOf(40.0, 90.0, 0.98),
    arrayOf(38.0, 80.0, 0.68),
    arrayOf(37.0, 70.0, 0.53),
    arrayOf(36.0, 60.0, 0.38),
    arrayOf(34.0, 50.0, 0.08),
    arrayOf(33.0, 40.0, -0.07),
    arrayOf(30.0, 30.0, -0.52),
    arrayOf(25.0, 20.0, -1.27),
    arrayOf(20.0, 10.0, -2.03),
    arrayOf(15.0, 5.0, -2.78),
)

/**
 * III.- Niveles de Adaptacion
 * B. AutoControl
 * Page 53
 */
private fun autoControlFragmentE1M3Baremo() = arrayOf(
    arrayOf(30.0, 99.0, 1.53),
    arrayOf(27.0, 90.0, 0.94),
    arrayOf(26.0, 80.0, 0.74),
    arrayOf(25.0, 70.0, 0.55),
    arrayOf(24.0, 60.0, 0.35),
    arrayOf(22.0, 50.0, -0.05),
    arrayOf(18.0, 40.0, -0.84),
    arrayOf(16.0, 30.0, -1.23),
    arrayOf(15.0, 20.0, -1.43),
    arrayOf(10.0, 10.0, -2.42),
    arrayOf(8.0, 5.0, -2.81),
)

/**
 * III.- Niveles de Adaptacion
 * C. Conducta prosocial
 * Page 53
 */
private fun conductaProSocialFragmentE1M3Baremo() = arrayOf(
    arrayOf(30.0, 99.0, 0.99),
    arrayOf(29.0, 90.0, 0.8),
    arrayOf(28.0, 80.0, 0.61),
    arrayOf(26.0, 70.0, 0.23),
    arrayOf(25.0, 60.0, 0.04),
    arrayOf(22.0, 50.0, -0.53),
    arrayOf(18.0, 40.0, -1.3),
    arrayOf(16.0, 30.0, -1.68),
    arrayOf(14.0, 20.0, -2.06),
    arrayOf(12.0, 10.0, -2.44),
    arrayOf(8.0, 5.0, -3.2),
)

/**
 * III.- Niveles de Adaptacion
 * D. AutoEstima
 * Page 53
 */
private fun autoEstimaFragmentE1M3Baremo() = arrayOf(
    arrayOf(30.0, 99.0, 1.67),
    arrayOf(28.0, 90.0, 1.26),
    arrayOf(26.0, 80.0, 0.86),
    arrayOf(24.0, 70.0, 0.45),
    arrayOf(22.0, 60.0, 0.04),
    arrayOf(20.0, 50.0, -0.36),
    arrayOf(18.0, 40.0, -0.77),
    arrayOf(16.0, 30.0, -1.17),
    arrayOf(14.0, 20.0, -1.58),
    arrayOf(10.0, 10.0, -2.39),
    arrayOf(8.0, 5.0, -2.8),
)

/**
 * IV. Lectura
 * A. Comprension Lectora
 * Page 59
 */
private fun comprensionLectoraE1M4Baremo() = arrayOf(
    arrayOf(49.0, 95.0, 1.06),
    arrayOf(48.0, 85.0, 0.94),
    arrayOf(47.0, 75.0, 0.82),
    arrayOf(46.0, 70.0, 0.7),
    arrayOf(45.0, 65.0, 0.58),
    arrayOf(44.0, 60.0, 0.46),
    arrayOf(43.0, 55.0, 0.34),
    arrayOf(42.0, 50.0, 0.21),
    arrayOf(41.0, 45.0, 0.09),
    arrayOf(40.0, 42.0, -0.03),
    arrayOf(39.0, 40.0, -0.15),
    arrayOf(38.0, 37.0, -0.27),
    arrayOf(37.0, 35.0, -0.39),
    arrayOf(36.0, 32.0, -0.51),
    arrayOf(35.0, 30.0, -0.63),
    arrayOf(34.0, 27.0, -0.76),
    arrayOf(33.0, 25.0, -0.88),
    arrayOf(32.0, 20.0, -1.0),
    arrayOf(31.0, 15.0, -1.12),
    arrayOf(30.0, 10.0, -1.24),
    arrayOf(25.0, 7.0, -1.85),
    arrayOf(20.0, 5.0, -2.45),
    arrayOf(15.0, 3.0, -3.06),
    arrayOf(10.0, 1.0, -3.66)
)

/**
 * IV. Lectura
 * B. Exactitud Lectora
 * Page 67
 */
private fun exactitudLectoraE1M4Baremo() = arrayOf(
    arrayOf(146.0, 99.0, 1.9),
    arrayOf(143.0, 97.0, 1.78),
    arrayOf(140.0, 95.0, 1.66),
    arrayOf(137.0, 90.0, 1.54),
    arrayOf(134.0, 85.0, 1.42),
    arrayOf(131.0, 80.0, 1.3),
    arrayOf(128.0, 75.0, 1.18),
    arrayOf(125.0, 70.0, 1.06),
    arrayOf(122.0, 65.0, 0.94),
    arrayOf(119.0, 60.0, 0.82),
    arrayOf(116.0, 57.0, 0.7),
    arrayOf(113.0, 55.0, 0.58),
    arrayOf(110.0, 52.0, 0.46),
    arrayOf(107.0, 50.0, 0.34),
    arrayOf(104.0, 48.0, 0.22),
    arrayOf(101.0, 45.0, 0.1),
    arrayOf(98.0, 42.0, -0.02),
    arrayOf(95.0, 40.0, -0.14),
    arrayOf(92.0, 38.0, -0.25),
    arrayOf(89.0, 35.0, -0.37),
    arrayOf(86.0, 34.0, -0.49),
    arrayOf(83.0, 32.0, -0.61),
    arrayOf(80.0, 31.0, -0.73),
    arrayOf(77.0, 30.0, -0.85),
    arrayOf(74.0, 29.0, -0.97),
    arrayOf(71.0, 28.0, -1.09),
    arrayOf(68.0, 27.0, -1.21),
    arrayOf(65.0, 26.0, -1.33),
    arrayOf(62.0, 25.0, -1.45),
    arrayOf(59.0, 22.0, -1.57),
    arrayOf(56.0, 20.0, -1.69),
    arrayOf(53.0, 15.0, -1.81),
    arrayOf(50.0, 12.0, -1.93),
    arrayOf(47.0, 10.0, -2.05),
    arrayOf(44.0, 5.0, -2.17),
    arrayOf(41.0, 1.0, -2.29),
)

/**
 * V. Escritura
 * A. Ortografia Fonetica
 * Page 75
 */
private fun ortografiaFoneticaE1M5Baremo() = arrayOf(
    arrayOf(84.0, 99.0, 1.71),
    arrayOf(82.0, 95.0, 1.6),
    arrayOf(80.0, 90.0, 1.48),
    arrayOf(78.0, 87.0, 1.37),
    arrayOf(76.0, 85.0, 1.25),
    arrayOf(74.0, 82.0, 1.14),
    arrayOf(72.0, 80.0, 1.02),
    arrayOf(70.0, 77.0, 0.9),
    arrayOf(68.0, 75.0, 0.79),
    arrayOf(66.0, 70.0, 0.67),
    arrayOf(64.0, 65.0, 0.56),
    arrayOf(62.0, 60.0, 0.44),
    arrayOf(60.0, 57.0, 0.33),
    arrayOf(58.0, 55.0, 0.21),
    arrayOf(56.0, 50.0, 0.1),
    arrayOf(54.0, 45.0, -0.02),
    arrayOf(52.0, 40.0, -0.13),
    arrayOf(50.0, 37.0, -0.25),
    arrayOf(48.0, 35.0, -0.36),
    arrayOf(46.0, 32.0, -0.48),
    arrayOf(44.0, 30.0, -0.59),
    arrayOf(42.0, 27.0, -0.71),
    arrayOf(40.0, 25.0, -0.82),
    arrayOf(35.0, 20.0, -1.11),
    arrayOf(30.0, 15.0, -1.4),
    arrayOf(25.0, 10.0, -1.69),
    arrayOf(20.0, 5.0, -1.98)
)

/**
 * V. Escritura
 * C. Ortografia Visual
 * Page 81
 */
private fun ortografiaVisualE1M5Baremo() = arrayOf(
    arrayOf(28.0, 99.0, 1.77),
    arrayOf(27.0, 97.0, 1.64),
    arrayOf(26.0, 95.0, 1.51),
    arrayOf(25.0, 90.0, 1.38),
    arrayOf(24.0, 87.0, 1.24),
    arrayOf(23.0, 85.0, 1.11),
    arrayOf(22.0, 82.0, 0.98),
    arrayOf(21.0, 80.0, 0.85),
    arrayOf(20.0, 75.0, 0.71),
    arrayOf(19.0, 65.0, 0.58),
    arrayOf(18.0, 60.0, 0.45),
    arrayOf(17.0, 55.0, 0.32),
    arrayOf(16.0, 52.0, 0.19),
    arrayOf(15.0, 50.0, 0.05),
    arrayOf(13.0, 45.0, -0.21),
    arrayOf(11.0, 40.0, -0.47),
    arrayOf(10.0, 35.0, -0.61),
    arrayOf(8.0, 30.0, -0.87),
    arrayOf(6.0, 25.0, -1.13),
    arrayOf(5.0, 20.0, -1.27),
    arrayOf(4.0, 15.0, -1.4),
    arrayOf(3.0, 10.0, -1.53),
)

/**
 * VI. Aprendizajes Matematicos
 * A. Calculo y Numeracion
 * Page 91
 */
private fun calculoNumeracionE1M6Baremo() = arrayOf(
    arrayOf(47.0, 99.0, 1.8),
    arrayOf(46.0, 97.0, 1.69),
    arrayOf(45.0, 95.0, 1.58),
    arrayOf(44.0, 90.0, 1.46),
    arrayOf(43.0, 85.0, 1.35),
    arrayOf(42.0, 82.0, 1.24),
    arrayOf(41.0, 80.0, 1.12),
    arrayOf(40.0, 77.0, 1.01),
    arrayOf(39.0, 75.0, 0.9),
    arrayOf(38.0, 70.0, 0.78),
    arrayOf(37.0, 67.0, 0.67),
    arrayOf(36.0, 62.0, 0.56),
    arrayOf(35.0, 60.0, 0.44),
    arrayOf(34.0, 57.0, 0.33),
    arrayOf(33.0, 55.0, 0.22),
    arrayOf(32.0, 50.0, 0.1),
    arrayOf(31.0, 45.0, -0.01),
    arrayOf(30.0, 40.0, -0.12),
    arrayOf(29.0, 35.0, -0.24),
    arrayOf(28.0, 32.0, -0.35),
    arrayOf(27.0, 30.0, -0.46),
    arrayOf(26.0, 27.0, -0.58),
    arrayOf(25.0, 25.0, -0.69),
    arrayOf(21.0, 20.0, -1.14),
    arrayOf(19.0, 15.0, -1.37),
    arrayOf(16.0, 10.0, -1.71),
    arrayOf(13.0, 5.0, -2.05),
    arrayOf(10.0, 1.0, -2.39),
)
