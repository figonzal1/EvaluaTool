/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2023

 Last modified 18-06-23 17:21
 */

package cl.figonzal.evaluatool.domain.baremo_tables.tables

import cl.figonzal.evaluatool.domain.baremo_tables.constants.BaseConstants
import cl.figonzal.evaluatool.domain.baremo_tables.constants.Evalua1Constants
import cl.figonzal.evaluatool.domain.baremo_tables.constants.Evalua1Constants.AUTO_CONTROL_FRAGMENT_E1M3
import cl.figonzal.evaluatool.domain.baremo_tables.constants.Evalua1Constants.AUTO_ESTIMA_FRAGMENT_E1M3
import cl.figonzal.evaluatool.domain.baremo_tables.constants.Evalua1Constants.CALCULO_NUMERACION_E1M6
import cl.figonzal.evaluatool.domain.baremo_tables.constants.Evalua1Constants.CLASIFICACIONES_E1M2
import cl.figonzal.evaluatool.domain.baremo_tables.constants.Evalua1Constants.COMPRENSION_LECTORA_E1M4
import cl.figonzal.evaluatool.domain.baremo_tables.constants.Evalua1Constants.CONDUCTA_PRO_SOCIAL_E1M3
import cl.figonzal.evaluatool.domain.baremo_tables.constants.Evalua1Constants.EXACTITUD_LECTORA_E1M4
import cl.figonzal.evaluatool.domain.baremo_tables.constants.Evalua1Constants.MEMORIA_ATENCION_E1M1
import cl.figonzal.evaluatool.domain.baremo_tables.constants.Evalua1Constants.MOTIVACION_FRAGMENT_E1M3
import cl.figonzal.evaluatool.domain.baremo_tables.constants.Evalua1Constants.ORGANIZACION_PERCEPTIVA_E1M2
import cl.figonzal.evaluatool.domain.baremo_tables.constants.Evalua1Constants.ORTOGRAFIA_FONETICA_E1M5
import cl.figonzal.evaluatool.domain.baremo_tables.constants.Evalua1Constants.ORTOGRAFIA_VISUAL_E1M5
import cl.figonzal.evaluatool.domain.baremo_tables.constants.Evalua1Constants.SERIES_E1M2

/**
 * Evalua 1
 */
class Evalua1Baremo : BaremoTable {

    override fun getBaremo(baremo: BaseConstants) = when (baremo as Evalua1Constants) {
        MEMORIA_ATENCION_E1M1 -> memoriaAtencionE1M1Baremo()

        SERIES_E1M2 -> seriesE1M2Baremo()
        CLASIFICACIONES_E1M2 -> clasificacionesE1M2Baremo()
        ORGANIZACION_PERCEPTIVA_E1M2 -> organizacionPerceptivaE1M2Baremo()

        MOTIVACION_FRAGMENT_E1M3 -> motivacionFragmentE1M3Baremo()
        AUTO_CONTROL_FRAGMENT_E1M3 -> autoControlFragmentE1M3Baremo()
        CONDUCTA_PRO_SOCIAL_E1M3 -> conductaProSocialFragmentE1M3Baremo()
        AUTO_ESTIMA_FRAGMENT_E1M3 -> autoEstimaFragmentE1M3Baremo()

        COMPRENSION_LECTORA_E1M4 -> comprensionLectoraE1M4Baremo()
        EXACTITUD_LECTORA_E1M4 -> exactitudLectoraE1M4Baremo()

        ORTOGRAFIA_FONETICA_E1M5 -> ortografiaFoneticaE1M5Baremo()
        ORTOGRAFIA_VISUAL_E1M5 -> ortografiaVisualE1M5Baremo()

        CALCULO_NUMERACION_E1M6 -> calculoNumeracionE1M6Baremo()
    }
}

/**
 * I.- Memoria y Atencion
 * A. Memoria y Atencion
 * Page 27
 */
private fun memoriaAtencionE1M1Baremo() = arrayOf(
    doubleArrayOf(68.0, 99.0, 1.44),
    doubleArrayOf(67.0, 97.0, 1.37),
    doubleArrayOf(66.0, 95.0, 1.29),
    doubleArrayOf(65.0, 93.0, 1.21),
    doubleArrayOf(64.0, 90.0, 1.13),
    doubleArrayOf(63.0, 87.0, 1.06),
    doubleArrayOf(62.0, 85.0, 0.98),
    doubleArrayOf(61.0, 80.0, 0.9),
    doubleArrayOf(60.0, 75.0, 0.82),
    doubleArrayOf(59.0, 72.0, 0.74),
    doubleArrayOf(58.0, 70.0, 0.67),
    doubleArrayOf(57.0, 65.0, 0.59),
    doubleArrayOf(56.0, 62.0, 0.51),
    doubleArrayOf(55.0, 60.0, 0.43),
    doubleArrayOf(54.0, 57.0, 0.36),
    doubleArrayOf(53.0, 55.0, 0.28),
    doubleArrayOf(52.0, 52.0, 0.2),
    doubleArrayOf(51.0, 50.0, 0.12),
    doubleArrayOf(50.0, 47.0, 0.05),
    doubleArrayOf(49.0, 45.0, -0.03),
    doubleArrayOf(48.0, 43.0, -0.11),
    doubleArrayOf(47.0, 40.0, -0.19),
    doubleArrayOf(46.0, 37.0, -0.26),
    doubleArrayOf(45.0, 35.0, -0.34),
    doubleArrayOf(44.0, 32.0, -0.42),
    doubleArrayOf(43.0, 30.0, -0.5),
    doubleArrayOf(40.0, 25.0, -0.73),
    doubleArrayOf(37.0, 20.0, -0.96),
    doubleArrayOf(34.0, 15.0, -1.19),
    doubleArrayOf(31.0, 10.0, -1.43),
    doubleArrayOf(28.0, 7.0, -1.66),
    doubleArrayOf(25.0, 5.0, -1.89),
    doubleArrayOf(22.0, 1.0, -2.12),
)

/**
 * II.- Bases del razonamiento
 * A. Series
 * Page 33
 */
private fun seriesE1M2Baremo() = arrayOf(
    doubleArrayOf(24.0, 95.0, 1.19),
    doubleArrayOf(23.0, 90.0, 1.06),
    doubleArrayOf(22.0, 85.0, 0.94),
    doubleArrayOf(21.0, 80.0, 0.81),
    doubleArrayOf(20.0, 70.0, 0.69),
    doubleArrayOf(19.0, 65.0, 0.56),
    doubleArrayOf(18.0, 60.0, 0.44),
    doubleArrayOf(17.0, 55.0, 0.31),
    doubleArrayOf(16.0, 50.0, 0.19),
    doubleArrayOf(15.0, 45.0, 0.06),
    doubleArrayOf(14.0, 43.0, -0.06),
    doubleArrayOf(13.0, 40.0, -0.19),
    doubleArrayOf(12.0, 37.0, -0.31),
    doubleArrayOf(11.0, 35.0, -0.44),
    doubleArrayOf(10.0, 30.0, -0.56),
    doubleArrayOf(9.0, 25.0, -0.69),
    doubleArrayOf(8.0, 20.0, -0.81),
    doubleArrayOf(7.0, 15.0, -0.94),
    doubleArrayOf(6.0, 10.0, -1.06),
    doubleArrayOf(5.0, 7.0, -1.19),
    doubleArrayOf(4.0, 5.0, -1.31),
    doubleArrayOf(3.0, 1.0, -1.44),
)

/**
 * II.- Bases del razonamiento
 * B. Clasificaciones
 * Page 39
 */
private fun clasificacionesE1M2Baremo() = arrayOf(
    doubleArrayOf(20.0, 99.0, 2.3),
    doubleArrayOf(19.0, 98.0, 2.09),
    doubleArrayOf(18.0, 97.0, 1.89),
    doubleArrayOf(17.0, 95.0, 1.68),
    doubleArrayOf(16.0, 92.0, 1.48),
    doubleArrayOf(15.0, 90.0, 1.27),
    doubleArrayOf(14.0, 85.0, 1.07),
    doubleArrayOf(13.0, 80.0, 0.86),
    doubleArrayOf(12.0, 70.0, 0.66),
    doubleArrayOf(11.0, 65.0, 0.45),
    doubleArrayOf(10.0, 55.0, 0.25),
    doubleArrayOf(9.0, 50.0, 0.04),
    doubleArrayOf(8.0, 45.0, -0.16),
    doubleArrayOf(7.0, 40.0, -0.37),
    doubleArrayOf(6.0, 30.0, -0.57),
    doubleArrayOf(5.0, 25.0, -0.78),
    doubleArrayOf(4.0, 20.0, -0.99),
    doubleArrayOf(3.0, 15.0, -1.19),
    doubleArrayOf(2.0, 10.0, -1.4),
    doubleArrayOf(1.0, 5.0, -1.6),
    doubleArrayOf(0.0, 1.0, -1.81)
)

/**
 * II.- Bases del razonamiento
 * C. Organizacion Perceptiva
 * Page 45
 */
private fun organizacionPerceptivaE1M2Baremo() = arrayOf(
    doubleArrayOf(52.0, 99.0, 1.23),
    doubleArrayOf(51.0, 95.0, 1.14),
    doubleArrayOf(50.0, 92.0, 1.06),
    doubleArrayOf(49.0, 90.0, 0.97),
    doubleArrayOf(48.0, 85.0, 0.88),
    doubleArrayOf(47.0, 80.0, 0.79),
    doubleArrayOf(46.0, 75.0, 0.7),
    doubleArrayOf(45.0, 70.0, 0.62),
    doubleArrayOf(44.0, 67.0, 0.53),
    doubleArrayOf(43.0, 62.0, 0.44),
    doubleArrayOf(42.0, 60.0, 0.35),
    doubleArrayOf(41.0, 57.0, 0.26),
    doubleArrayOf(40.0, 55.0, 0.18),
    doubleArrayOf(39.0, 52.0, 0.09),
    doubleArrayOf(38.0, 50.0, 0.0),
    doubleArrayOf(37.0, 45.0, -0.09),
    doubleArrayOf(36.0, 42.0, -0.18),
    doubleArrayOf(35.0, 40.0, -0.26),
    doubleArrayOf(34.0, 37.0, -0.35),
    doubleArrayOf(33.0, 35.0, -0.44),
    doubleArrayOf(32.0, 32.0, -0.53),
    doubleArrayOf(29.0, 30.0, -0.79),
    doubleArrayOf(26.0, 25.0, -1.06),
    doubleArrayOf(23.0, 20.0, -1.32),
    doubleArrayOf(20.0, 15.0, -1.59),
    doubleArrayOf(17.0, 10.0, -1.85),
    doubleArrayOf(14.0, 7.0, -2.11),
    doubleArrayOf(11.0, 5.0, -2.38),
    doubleArrayOf(8.0, 1.0, -2.64),
)

/**
 * III.- Niveles de Adaptacion
 * A. Motivacion
 * Page 53
 */
private fun motivacionFragmentE1M3Baremo() = arrayOf(
    doubleArrayOf(45.0, 99.0, 1.74),
    doubleArrayOf(40.0, 90.0, 0.98),
    doubleArrayOf(38.0, 80.0, 0.68),
    doubleArrayOf(37.0, 70.0, 0.53),
    doubleArrayOf(36.0, 60.0, 0.38),
    doubleArrayOf(34.0, 50.0, 0.08),
    doubleArrayOf(33.0, 40.0, -0.07),
    doubleArrayOf(30.0, 30.0, -0.52),
    doubleArrayOf(25.0, 20.0, -1.27),
    doubleArrayOf(20.0, 10.0, -2.03),
    doubleArrayOf(15.0, 5.0, -2.78),
)

/**
 * III.- Niveles de Adaptacion
 * B. AutoControl
 * Page 53
 */
private fun autoControlFragmentE1M3Baremo() = arrayOf(
    doubleArrayOf(30.0, 99.0, 1.53),
    doubleArrayOf(27.0, 90.0, 0.94),
    doubleArrayOf(26.0, 80.0, 0.74),
    doubleArrayOf(25.0, 70.0, 0.55),
    doubleArrayOf(24.0, 60.0, 0.35),
    doubleArrayOf(22.0, 50.0, -0.05),
    doubleArrayOf(18.0, 40.0, -0.84),
    doubleArrayOf(16.0, 30.0, -1.23),
    doubleArrayOf(15.0, 20.0, -1.43),
    doubleArrayOf(10.0, 10.0, -2.42),
    doubleArrayOf(8.0, 5.0, -2.81),
)

/**
 * III.- Niveles de Adaptacion
 * C. Conducta prosocial
 * Page 53
 */
private fun conductaProSocialFragmentE1M3Baremo() = arrayOf(
    doubleArrayOf(30.0, 99.0, 0.99),
    doubleArrayOf(29.0, 90.0, 0.8),
    doubleArrayOf(28.0, 80.0, 0.61),
    doubleArrayOf(26.0, 70.0, 0.23),
    doubleArrayOf(25.0, 60.0, 0.04),
    doubleArrayOf(22.0, 50.0, -0.53),
    doubleArrayOf(18.0, 40.0, -1.3),
    doubleArrayOf(16.0, 30.0, -1.68),
    doubleArrayOf(14.0, 20.0, -2.06),
    doubleArrayOf(12.0, 10.0, -2.44),
    doubleArrayOf(8.0, 5.0, -3.2),
)

/**
 * III.- Niveles de Adaptacion
 * D. AutoEstima
 * Page 53
 */
private fun autoEstimaFragmentE1M3Baremo() = arrayOf(
    doubleArrayOf(30.0, 99.0, 1.67),
    doubleArrayOf(28.0, 90.0, 1.26),
    doubleArrayOf(26.0, 80.0, 0.86),
    doubleArrayOf(24.0, 70.0, 0.45),
    doubleArrayOf(22.0, 60.0, 0.04),
    doubleArrayOf(20.0, 50.0, -0.36),
    doubleArrayOf(18.0, 40.0, -0.77),
    doubleArrayOf(16.0, 30.0, -1.17),
    doubleArrayOf(14.0, 20.0, -1.58),
    doubleArrayOf(10.0, 10.0, -2.39),
    doubleArrayOf(8.0, 5.0, -2.8),
)

/**
 * IV. Lectura
 * A. Comprension Lectora
 * Page 59
 */
private fun comprensionLectoraE1M4Baremo() = arrayOf(
    doubleArrayOf(49.0, 95.0, 1.06),
    doubleArrayOf(48.0, 85.0, 0.94),
    doubleArrayOf(47.0, 75.0, 0.82),
    doubleArrayOf(46.0, 70.0, 0.7),
    doubleArrayOf(45.0, 65.0, 0.58),
    doubleArrayOf(44.0, 60.0, 0.46),
    doubleArrayOf(43.0, 55.0, 0.34),
    doubleArrayOf(42.0, 50.0, 0.21),
    doubleArrayOf(41.0, 45.0, 0.09),
    doubleArrayOf(40.0, 42.0, -0.03),
    doubleArrayOf(39.0, 40.0, -0.15),
    doubleArrayOf(38.0, 37.0, -0.27),
    doubleArrayOf(37.0, 35.0, -0.39),
    doubleArrayOf(36.0, 32.0, -0.51),
    doubleArrayOf(35.0, 30.0, -0.63),
    doubleArrayOf(34.0, 27.0, -0.76),
    doubleArrayOf(33.0, 25.0, -0.88),
    doubleArrayOf(32.0, 20.0, -1.0),
    doubleArrayOf(31.0, 15.0, -1.12),
    doubleArrayOf(30.0, 10.0, -1.24),
    doubleArrayOf(25.0, 7.0, -1.85),
    doubleArrayOf(20.0, 5.0, -2.45),
    doubleArrayOf(15.0, 3.0, -3.06),
    doubleArrayOf(10.0, 1.0, -3.66)
)

/**
 * IV. Lectura
 * B. Exactitud Lectora
 * Page 67
 */
private fun exactitudLectoraE1M4Baremo() = arrayOf(
    doubleArrayOf(146.0, 99.0, 1.9),
    doubleArrayOf(143.0, 97.0, 1.78),
    doubleArrayOf(140.0, 95.0, 1.66),
    doubleArrayOf(137.0, 90.0, 1.54),
    doubleArrayOf(134.0, 85.0, 1.42),
    doubleArrayOf(131.0, 80.0, 1.3),
    doubleArrayOf(128.0, 75.0, 1.18),
    doubleArrayOf(125.0, 70.0, 1.06),
    doubleArrayOf(122.0, 65.0, 0.94),
    doubleArrayOf(119.0, 60.0, 0.82),
    doubleArrayOf(116.0, 57.0, 0.7),
    doubleArrayOf(113.0, 55.0, 0.58),
    doubleArrayOf(110.0, 52.0, 0.46),
    doubleArrayOf(107.0, 50.0, 0.34),
    doubleArrayOf(104.0, 48.0, 0.22),
    doubleArrayOf(101.0, 45.0, 0.1),
    doubleArrayOf(98.0, 42.0, -0.02),
    doubleArrayOf(95.0, 40.0, -0.14),
    doubleArrayOf(92.0, 38.0, -0.25),
    doubleArrayOf(89.0, 35.0, -0.37),
    doubleArrayOf(86.0, 34.0, -0.49),
    doubleArrayOf(83.0, 32.0, -0.61),
    doubleArrayOf(80.0, 31.0, -0.73),
    doubleArrayOf(77.0, 30.0, -0.85),
    doubleArrayOf(74.0, 29.0, -0.97),
    doubleArrayOf(71.0, 28.0, -1.09),
    doubleArrayOf(68.0, 27.0, -1.21),
    doubleArrayOf(65.0, 26.0, -1.33),
    doubleArrayOf(62.0, 25.0, -1.45),
    doubleArrayOf(59.0, 22.0, -1.57),
    doubleArrayOf(56.0, 20.0, -1.69),
    doubleArrayOf(53.0, 15.0, -1.81),
    doubleArrayOf(50.0, 12.0, -1.93),
    doubleArrayOf(47.0, 10.0, -2.05),
    doubleArrayOf(44.0, 5.0, -2.17),
    doubleArrayOf(41.0, 1.0, -2.29),
)

/**
 * V. Escritura
 * A. Ortografia Fonetica
 * Page 75
 */
private fun ortografiaFoneticaE1M5Baremo() = arrayOf(
    doubleArrayOf(84.0, 99.0, 1.71),
    doubleArrayOf(82.0, 95.0, 1.6),
    doubleArrayOf(80.0, 90.0, 1.48),
    doubleArrayOf(78.0, 87.0, 1.37),
    doubleArrayOf(76.0, 85.0, 1.25),
    doubleArrayOf(74.0, 82.0, 1.14),
    doubleArrayOf(72.0, 80.0, 1.02),
    doubleArrayOf(70.0, 77.0, 0.9),
    doubleArrayOf(68.0, 75.0, 0.79),
    doubleArrayOf(66.0, 70.0, 0.67),
    doubleArrayOf(64.0, 65.0, 0.56),
    doubleArrayOf(62.0, 60.0, 0.44),
    doubleArrayOf(60.0, 57.0, 0.33),
    doubleArrayOf(58.0, 55.0, 0.21),
    doubleArrayOf(56.0, 50.0, 0.1),
    doubleArrayOf(54.0, 45.0, -0.02),
    doubleArrayOf(52.0, 40.0, -0.13),
    doubleArrayOf(50.0, 37.0, -0.25),
    doubleArrayOf(48.0, 35.0, -0.36),
    doubleArrayOf(46.0, 32.0, -0.48),
    doubleArrayOf(44.0, 30.0, -0.59),
    doubleArrayOf(42.0, 27.0, -0.71),
    doubleArrayOf(40.0, 25.0, -0.82),
    doubleArrayOf(35.0, 20.0, -1.11),
    doubleArrayOf(30.0, 15.0, -1.4),
    doubleArrayOf(25.0, 10.0, -1.69),
    doubleArrayOf(20.0, 5.0, -1.98)
)

/**
 * V. Escritura
 * C. Ortografia Visual
 * Page 81
 */
private fun ortografiaVisualE1M5Baremo() = arrayOf(
    doubleArrayOf(28.0, 99.0, 1.77),
    doubleArrayOf(27.0, 97.0, 1.64),
    doubleArrayOf(26.0, 95.0, 1.51),
    doubleArrayOf(25.0, 90.0, 1.38),
    doubleArrayOf(24.0, 87.0, 1.24),
    doubleArrayOf(23.0, 85.0, 1.11),
    doubleArrayOf(22.0, 82.0, 0.98),
    doubleArrayOf(21.0, 80.0, 0.85),
    doubleArrayOf(20.0, 75.0, 0.71),
    doubleArrayOf(19.0, 65.0, 0.58),
    doubleArrayOf(18.0, 60.0, 0.45),
    doubleArrayOf(17.0, 55.0, 0.32),
    doubleArrayOf(16.0, 52.0, 0.19),
    doubleArrayOf(15.0, 50.0, 0.05),
    doubleArrayOf(13.0, 45.0, -0.21),
    doubleArrayOf(11.0, 40.0, -0.47),
    doubleArrayOf(10.0, 35.0, -0.61),
    doubleArrayOf(8.0, 30.0, -0.87),
    doubleArrayOf(6.0, 25.0, -1.13),
    doubleArrayOf(5.0, 20.0, -1.27),
    doubleArrayOf(4.0, 15.0, -1.4),
    doubleArrayOf(3.0, 10.0, -1.53),
)

/**
 * VI. Aprendizajes Matematicos
 * A. Calculo y Numeracion
 * Page 91
 */
private fun calculoNumeracionE1M6Baremo() = arrayOf(
    doubleArrayOf(47.0, 99.0, 1.8),
    doubleArrayOf(46.0, 97.0, 1.69),
    doubleArrayOf(45.0, 95.0, 1.58),
    doubleArrayOf(44.0, 90.0, 1.46),
    doubleArrayOf(43.0, 85.0, 1.35),
    doubleArrayOf(42.0, 82.0, 1.24),
    doubleArrayOf(41.0, 80.0, 1.12),
    doubleArrayOf(40.0, 77.0, 1.01),
    doubleArrayOf(39.0, 75.0, 0.9),
    doubleArrayOf(38.0, 70.0, 0.78),
    doubleArrayOf(37.0, 67.0, 0.67),
    doubleArrayOf(36.0, 62.0, 0.56),
    doubleArrayOf(35.0, 60.0, 0.44),
    doubleArrayOf(34.0, 57.0, 0.33),
    doubleArrayOf(33.0, 55.0, 0.22),
    doubleArrayOf(32.0, 50.0, 0.1),
    doubleArrayOf(31.0, 45.0, -0.01),
    doubleArrayOf(30.0, 40.0, -0.12),
    doubleArrayOf(29.0, 35.0, -0.24),
    doubleArrayOf(28.0, 32.0, -0.35),
    doubleArrayOf(27.0, 30.0, -0.46),
    doubleArrayOf(26.0, 27.0, -0.58),
    doubleArrayOf(25.0, 25.0, -0.69),
    doubleArrayOf(21.0, 20.0, -1.14),
    doubleArrayOf(19.0, 15.0, -1.37),
    doubleArrayOf(16.0, 10.0, -1.71),
    doubleArrayOf(13.0, 5.0, -2.05),
    doubleArrayOf(10.0, 1.0, -2.39),
)
