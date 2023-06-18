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
import cl.figonzal.evaluatool.domain.baremo_tables.constants.Evalua6Constants
import cl.figonzal.evaluatool.domain.baremo_tables.constants.Evalua6Constants.AUTO_CONTROL_FRAGMENT_E6M3
import cl.figonzal.evaluatool.domain.baremo_tables.constants.Evalua6Constants.AUTO_ESTIMA_FRAGMENT_E6M3
import cl.figonzal.evaluatool.domain.baremo_tables.constants.Evalua6Constants.CALCULO_NUMERACION_E6M6
import cl.figonzal.evaluatool.domain.baremo_tables.constants.Evalua6Constants.COMPRENSION_LECTORA_E6M4
import cl.figonzal.evaluatool.domain.baremo_tables.constants.Evalua6Constants.COMPRESION_FRAGMENT_E6M4
import cl.figonzal.evaluatool.domain.baremo_tables.constants.Evalua6Constants.CONDUCTA_PRO_SOCIAL_E6M3
import cl.figonzal.evaluatool.domain.baremo_tables.constants.Evalua6Constants.MEMORIA_ATENCION_E6M2
import cl.figonzal.evaluatool.domain.baremo_tables.constants.Evalua6Constants.MOTIVACION_FRAGMENT_E6M3
import cl.figonzal.evaluatool.domain.baremo_tables.constants.Evalua6Constants.ORGANIZACION_PERCEPTIVA_E6M1
import cl.figonzal.evaluatool.domain.baremo_tables.constants.Evalua6Constants.ORTOGRAFIA_VISUAL_REGLADA_E6M5
import cl.figonzal.evaluatool.domain.baremo_tables.constants.Evalua6Constants.PENSAMIENTO_ANALOGICO_E6M1
import cl.figonzal.evaluatool.domain.baremo_tables.constants.Evalua6Constants.REFLEXIVIDAD_E6M1
import cl.figonzal.evaluatool.domain.baremo_tables.constants.Evalua6Constants.RESOLUCION_PROBLEMAS_E6M6
import cl.figonzal.evaluatool.domain.baremo_tables.constants.Evalua6Constants.VELOCIDAD_FRAGMENT_E6M4

/**
 * Evalua 6
 */
class Evalua6Baremo : BaremoTable {
    override fun getBaremo(baremo: BaseConstants) = when (baremo as Evalua6Constants) {

        REFLEXIVIDAD_E6M1 -> reflexividadE6M1Baremo()
        PENSAMIENTO_ANALOGICO_E6M1 -> pensamientoAnalogicoE6M1Baremo()
        ORGANIZACION_PERCEPTIVA_E6M1 -> organizacionPerceptivaE6M1Baremo()

        MEMORIA_ATENCION_E6M2 -> memoriaAtencionE6M2Baremo()

        MOTIVACION_FRAGMENT_E6M3 -> motivacionFragmentE6M3Baremo()
        AUTO_CONTROL_FRAGMENT_E6M3 -> autoControlFragmentE6M3Baremo()
        CONDUCTA_PRO_SOCIAL_E6M3 -> conductaProSocialFragmentE6M3Baremo()
        AUTO_ESTIMA_FRAGMENT_E6M3 -> autoEstimaFragmentE6M3Baremo()

        COMPRENSION_LECTORA_E6M4 -> comprensionLectoraE6M4Baremo()
        COMPRESION_FRAGMENT_E6M4 -> comprensionFragmentE6M4Baremo()
        VELOCIDAD_FRAGMENT_E6M4 -> velocidadFragmentE6M4Baremo()

        ORTOGRAFIA_VISUAL_REGLADA_E6M5 -> ortografiaVisualRegladaE6M5Baremo()

        CALCULO_NUMERACION_E6M6 -> calculoNumeracionE6M6Baremo()
        RESOLUCION_PROBLEMAS_E6M6 -> resolucionProblemasE6M6Baremo()
    }
}

/**
 * I.- Bases del razonamiento
 * A. Reflexividad
 *
 * Page 30
 */
fun reflexividadE6M1Baremo() = arrayOf(
    doubleArrayOf(18.0, 99.0, 2.17),
    doubleArrayOf(17.0, 97.0, 1.95),
    doubleArrayOf(16.0, 95.0, 1.73),
    doubleArrayOf(15.0, 92.0, 1.52),
    doubleArrayOf(14.0, 90.0, 1.3),
    doubleArrayOf(13.0, 85.0, 1.08),
    doubleArrayOf(12.0, 80.0, 0.87),
    doubleArrayOf(11.0, 75.0, 0.65),
    doubleArrayOf(10.0, 70.0, 0.43),
    doubleArrayOf(9.0, 60.0, 0.21),
    doubleArrayOf(8.0, 50.0, 0.0),
    doubleArrayOf(7.0, 45.0, -0.22),
    doubleArrayOf(6.0, 42.0, -0.44),
    doubleArrayOf(5.0, 40.0, -0.65),
    doubleArrayOf(4.0, 30.0, -0.87),
    doubleArrayOf(3.0, 20.0, -1.09),
    doubleArrayOf(2.0, 10.0, -1.3),
    doubleArrayOf(1.0, 5.0, -1.52),
    doubleArrayOf(0.0, 1.0, -1.74),
)

/**
 * I.- Bases del razonamiento
 * B. Pensamiento analogico
 *
 * Page 35
 */
fun pensamientoAnalogicoE6M1Baremo() = arrayOf(
    doubleArrayOf(20.0, 99.0, 2.24),
    doubleArrayOf(19.0, 98.0, 2.02),
    doubleArrayOf(18.0, 97.0, 1.79),
    doubleArrayOf(17.0, 95.0, 1.57),
    doubleArrayOf(16.0, 93.0, 1.35),
    doubleArrayOf(15.0, 90.0, 1.12),
    doubleArrayOf(14.0, 80.0, 0.9),
    doubleArrayOf(13.0, 75.0, 0.68),
    doubleArrayOf(12.0, 65.0, 0.45),
    doubleArrayOf(11.0, 60.0, 0.23),
    doubleArrayOf(10.0, 50.0, 0.0),
    doubleArrayOf(9.0, 45.0, -0.22),
    doubleArrayOf(8.0, 40.0, -0.44),
    doubleArrayOf(7.0, 35.0, -0.67),
    doubleArrayOf(6.0, 25.0, -0.89),
    doubleArrayOf(5.0, 20.0, -1.11),
    doubleArrayOf(4.0, 15.0, -1.34),
    doubleArrayOf(3.0, 10.0, -1.56),
    doubleArrayOf(2.0, 5.0, -1.79),
    doubleArrayOf(1.0, 1.0, -2.01),
)

/**
 * I.- Bases del razonamiento
 * C. Organizacion Perceptiva
 *
 * Page 39
 */
fun organizacionPerceptivaE6M1Baremo() = arrayOf(
    doubleArrayOf(18.0, 99.0, 1.88),
    doubleArrayOf(17.0, 97.0, 1.62),
    doubleArrayOf(16.0, 93.0, 1.36),
    doubleArrayOf(15.0, 90.0, 1.1),
    doubleArrayOf(14.0, 80.0, 0.84),
    doubleArrayOf(13.0, 70.0, 0.58),
    doubleArrayOf(12.0, 60.0, 0.32),
    doubleArrayOf(11.0, 50.0, 0.06),
    doubleArrayOf(10.0, 40.0, -0.2),
    doubleArrayOf(9.0, 35.0, -0.46),
    doubleArrayOf(8.0, 25.0, -0.72),
    doubleArrayOf(7.0, 20.0, -0.98),
    doubleArrayOf(6.0, 15.0, -1.24),
    doubleArrayOf(5.0, 10.0, -1.5),
    doubleArrayOf(4.0, 7.0, -1.76),
    doubleArrayOf(3.0, 5.0, -2.02),
    doubleArrayOf(2.0, 3.0, -2.28),
    doubleArrayOf(1.0, 1.0, -2.54)
)

/**
 * II.- Memoria Atencion
 * A. Memoria Atencion
 *
 * Page 47
 */
fun memoriaAtencionE6M2Baremo() = arrayOf(
    doubleArrayOf(125.0, 99.0, 1.72),
    doubleArrayOf(124.0, 99.0, 1.68),
    doubleArrayOf(123.0, 99.0, 1.64),
    doubleArrayOf(122.0, 99.0, 1.6),
    doubleArrayOf(121.0, 99.0, 1.56),
    doubleArrayOf(120.0, 99.0, 1.52),
    doubleArrayOf(119.0, 95.0, 1.48),
    doubleArrayOf(118.0, 95.0, 1.44),
    doubleArrayOf(117.0, 95.0, 1.4),
    doubleArrayOf(116.0, 95.0, 1.36),
    doubleArrayOf(115.0, 95.0, 1.32),
    doubleArrayOf(114.0, 90.0, 1.28),
    doubleArrayOf(113.0, 90.0, 1.24),
    doubleArrayOf(112.0, 90.0, 1.2),
    doubleArrayOf(111.0, 90.0, 1.16),
    doubleArrayOf(110.0, 90.0, 1.12),
    doubleArrayOf(109.0, 85.0, 1.08),
    doubleArrayOf(108.0, 85.0, 1.04),
    doubleArrayOf(107.0, 85.0, 1.0),
    doubleArrayOf(106.0, 85.0, 0.96),
    doubleArrayOf(105.0, 85.0, 0.92),
    doubleArrayOf(104.0, 80.0, 0.88),
    doubleArrayOf(103.0, 80.0, 0.84),
    doubleArrayOf(102.0, 80.0, 0.8),
    doubleArrayOf(101.0, 80.0, 0.76),
    doubleArrayOf(100.0, 80.0, 0.72),
    doubleArrayOf(99.0, 75.0, 0.68),
    doubleArrayOf(98.0, 75.0, 0.64),
    doubleArrayOf(97.0, 75.0, 0.6),
    doubleArrayOf(96.0, 75.0, 0.56),
    doubleArrayOf(95.0, 75.0, 0.52),
    doubleArrayOf(94.0, 65.0, 0.48),
    doubleArrayOf(93.0, 65.0, 0.44),
    doubleArrayOf(92.0, 65.0, 0.4),
    doubleArrayOf(91.0, 65.0, 0.36),
    doubleArrayOf(90.0, 65.0, 0.32),
    doubleArrayOf(89.0, 60.0, 0.28),
    doubleArrayOf(88.0, 60.0, 0.24),
    doubleArrayOf(87.0, 60.0, 0.2),
    doubleArrayOf(86.0, 60.0, 0.16),
    doubleArrayOf(85.0, 60.0, 0.12),
    doubleArrayOf(84.0, 50.0, 0.08),
    doubleArrayOf(83.0, 50.0, 0.04),
    doubleArrayOf(82.0, 50.0, 0.0),
    doubleArrayOf(81.0, 50.0, -0.04),
    doubleArrayOf(80.0, 50.0, -0.08),
    doubleArrayOf(79.0, 45.0, -0.12),
    doubleArrayOf(78.0, 45.0, -0.16),
    doubleArrayOf(77.0, 45.0, -0.2),
    doubleArrayOf(76.0, 45.0, -0.24),
    doubleArrayOf(75.0, 45.0, -0.28),
    doubleArrayOf(74.0, 42.0, -0.32),
    doubleArrayOf(73.0, 42.0, -0.36),
    doubleArrayOf(72.0, 42.0, -0.4),
    doubleArrayOf(71.0, 42.0, -0.44),
    doubleArrayOf(70.0, 42.0, -0.48),
    doubleArrayOf(69.0, 40.0, -0.52),
    doubleArrayOf(68.0, 40.0, -0.56),
    doubleArrayOf(67.0, 40.0, -0.6),
    doubleArrayOf(66.0, 40.0, -0.64),
    doubleArrayOf(65.0, 40.0, -0.68),
    doubleArrayOf(64.0, 35.0, -0.72),
    doubleArrayOf(63.0, 35.0, -0.76),
    doubleArrayOf(62.0, 35.0, -0.8),
    doubleArrayOf(61.0, 35.0, -0.84),
    doubleArrayOf(60.0, 35.0, -0.88),
    doubleArrayOf(59.0, 30.0, -0.92),
    doubleArrayOf(58.0, 30.0, -0.96),
    doubleArrayOf(57.0, 30.0, -1.0),
    doubleArrayOf(56.0, 30.0, -1.04),
    doubleArrayOf(55.0, 30.0, -1.08),
    doubleArrayOf(54.0, 25.0, -1.12),
    doubleArrayOf(53.0, 25.0, -1.16),
    doubleArrayOf(52.0, 25.0, -1.2),
    doubleArrayOf(51.0, 25.0, -1.24),
    doubleArrayOf(50.0, 25.0, -1.28),
    doubleArrayOf(49.0, 20.0, -1.32),
    doubleArrayOf(48.0, 20.0, -1.36),
    doubleArrayOf(47.0, 20.0, -1.4),
    doubleArrayOf(46.0, 20.0, -1.44),
    doubleArrayOf(45.0, 20.0, -1.48),
    doubleArrayOf(44.0, 15.0, -1.52),
    doubleArrayOf(43.0, 15.0, -1.56),
    doubleArrayOf(42.0, 15.0, -1.6),
    doubleArrayOf(41.0, 15.0, -1.64),
    doubleArrayOf(40.0, 15.0, -1.68),
    doubleArrayOf(39.0, 10.0, -1.72),
    doubleArrayOf(38.0, 10.0, -1.76),
    doubleArrayOf(37.0, 10.0, -1.8),
    doubleArrayOf(36.0, 10.0, -1.84),
    doubleArrayOf(35.0, 10.0, -1.88),
    doubleArrayOf(34.0, 7.0, -1.92),
    doubleArrayOf(33.0, 7.0, -1.96),
    doubleArrayOf(32.0, 7.0, -2.0),
    doubleArrayOf(31.0, 7.0, -2.04),
    doubleArrayOf(30.0, 7.0, -2.08),
    doubleArrayOf(29.0, 5.0, -2.12),
    doubleArrayOf(28.0, 5.0, -2.16),
    doubleArrayOf(27.0, 5.0, -2.2),
    doubleArrayOf(26.0, 5.0, -2.24),
    doubleArrayOf(25.0, 5.0, -2.28),
    doubleArrayOf(24.0, 3.0, -2.32),
    doubleArrayOf(23.0, 3.0, -2.36),
    doubleArrayOf(22.0, 3.0, -2.4),
    doubleArrayOf(21.0, 3.0, -2.44),
    doubleArrayOf(20.0, 3.0, -2.48),
    doubleArrayOf(19.0, 1.0, -2.52),
    doubleArrayOf(18.0, 1.0, -2.56),
    doubleArrayOf(17.0, 1.0, -2.6),
    doubleArrayOf(16.0, 1.0, -2.64),
    doubleArrayOf(15.0, 1.0, -2.68)
)

/**
 * III.- Niveles Adaptacion
 * A. Motivacion
 *
 * Page 53
 */
fun motivacionFragmentE6M3Baremo() = arrayOf(
    doubleArrayOf(0.0, 99.0, 1.66),
    doubleArrayOf(1.0, 98.0, 1.43),
    doubleArrayOf(2.0, 95.0, 1.19),
    doubleArrayOf(3.0, 90.0, 0.96),
    doubleArrayOf(4.0, 85.0, 0.73),
    doubleArrayOf(5.0, 80.0, 0.5),
    doubleArrayOf(6.0, 70.0, 0.27),
    doubleArrayOf(7.0, 65.0, 0.04),
    doubleArrayOf(8.0, 60.0, -0.19),
    doubleArrayOf(9.0, 55.0, -0.43),
    doubleArrayOf(10.0, 50.0, -0.66),
    doubleArrayOf(11.0, 45.0, -0.89),
    doubleArrayOf(12.0, 40.0, -1.12),
    doubleArrayOf(13.0, 35.0, -1.35),
    doubleArrayOf(14.0, 30.0, -1.58),
    doubleArrayOf(15.0, 25.0, -1.81),
    doubleArrayOf(16.0, 20.0, -2.05),
    doubleArrayOf(17.0, 15.0, -2.28),
    doubleArrayOf(18.0, 10.0, -2.51),
    doubleArrayOf(19.0, 5.0, -2.74),
    doubleArrayOf(20.0, 1.0, -2.97),
)

/**
 * III.- Niveles Adaptacion
 * B. AutoControl
 *
 * Page 53
 */
fun autoControlFragmentE6M3Baremo() = arrayOf(
    doubleArrayOf(0.0, 99.0, 1.25),
    doubleArrayOf(1.0, 90.0, 0.91),
    doubleArrayOf(2.0, 80.0, 0.56),
    doubleArrayOf(3.0, 65.0, 0.21),
    doubleArrayOf(4.0, 60.0, -0.14),
    doubleArrayOf(5.0, 55.0, -0.48),
    doubleArrayOf(6.0, 50.0, -0.83),
    doubleArrayOf(7.0, 45.0, -1.18),
    doubleArrayOf(8.0, 35.0, -1.52),
    doubleArrayOf(9.0, 30.0, -1.87),
    doubleArrayOf(10.0, 20.0, -2.22),
    doubleArrayOf(11.0, 15.0, -2.57),
    doubleArrayOf(12.0, 10.0, -2.91),
    doubleArrayOf(13.0, 5.0, -3.26),
    doubleArrayOf(14.0, 3.0, -3.61),
    doubleArrayOf(15.0, 1.0, -3.95),
)

/**
 * III.- Niveles Adaptacion
 * C. ProSocial
 *
 * Page 53
 */
fun conductaProSocialFragmentE6M3Baremo() = arrayOf(
    doubleArrayOf(0.0, 99.0, 1.29),
    doubleArrayOf(1.0, 90.0, 0.92),
    doubleArrayOf(2.0, 85.0, 0.55),
    doubleArrayOf(3.0, 75.0, 0.18),
    doubleArrayOf(4.0, 65.0, -0.18),
    doubleArrayOf(5.0, 55.0, -0.55),
    doubleArrayOf(6.0, 50.0, -0.92),
    doubleArrayOf(7.0, 40.0, -1.29),
    doubleArrayOf(8.0, 30.0, -1.66),
    doubleArrayOf(9.0, 20.0, -2.03),
    doubleArrayOf(10.0, 15.0, -2.4),
    doubleArrayOf(11.0, 10.0, -2.77),
    doubleArrayOf(12.0, 7.0, -3.14),
    doubleArrayOf(13.0, 5.0, -3.51),
    doubleArrayOf(14.0, 3.0, -3.87),
    doubleArrayOf(15.0, 1.0, -4.24),
)

/**
 * III.- Niveles Adaptacion
 * D. AutoEStima
 *
 * Page 53
 */
fun autoEstimaFragmentE6M3Baremo() = arrayOf(
    doubleArrayOf(0.0, 99.0, 1.84),
    doubleArrayOf(1.0, 98.0, 1.51),
    doubleArrayOf(2.0, 95.0, 1.18),
    doubleArrayOf(3.0, 90.0, 0.84),
    doubleArrayOf(4.0, 80.0, 0.51),
    doubleArrayOf(5.0, 70.0, 0.18),
    doubleArrayOf(6.0, 55.0, -0.15),
    doubleArrayOf(7.0, 50.0, -0.49),
    doubleArrayOf(8.0, 45.0, -0.82),
    doubleArrayOf(9.0, 40.0, -1.15),
    doubleArrayOf(10.0, 30.0, -1.48),
    doubleArrayOf(11.0, 20.0, -1.81),
    doubleArrayOf(12.0, 10.0, -2.15),
    doubleArrayOf(13.0, 5.0, -2.48),
    doubleArrayOf(14.0, 3.0, -2.81),
    doubleArrayOf(15.0, 1.0, -3.14),
)

/**
 * IV.- Lectura
 * A.- Comprension Lectora
 *
 * Page 59
 */
fun comprensionLectoraE6M4Baremo() = arrayOf(
    doubleArrayOf(28.0, 99.0, 2.86),
    doubleArrayOf(27.0, 99.0, 2.67),
    doubleArrayOf(26.0, 98.0, 2.48),
    doubleArrayOf(25.0, 98.0, 2.28),
    doubleArrayOf(24.0, 97.0, 2.09),
    doubleArrayOf(23.0, 96.0, 1.9),
    doubleArrayOf(22.0, 95.0, 1.71),
    doubleArrayOf(21.0, 93.0, 1.52),
    doubleArrayOf(20.0, 92.0, 1.32),
    doubleArrayOf(19.0, 90.0, 1.13),
    doubleArrayOf(18.0, 85.0, 0.94),
    doubleArrayOf(17.0, 80.0, 0.75),
    doubleArrayOf(16.0, 70.0, 0.56),
    doubleArrayOf(15.0, 65.0, 0.36),
    doubleArrayOf(14.0, 60.0, 0.17),
    doubleArrayOf(13.0, 50.0, -0.02),
    doubleArrayOf(12.0, 45.0, -0.21),
    doubleArrayOf(11.0, 40.0, -0.4),
    doubleArrayOf(10.0, 35.0, -0.6),
    doubleArrayOf(9.0, 30.0, -0.79),
    doubleArrayOf(8.0, 25.0, -0.98),
    doubleArrayOf(7.0, 20.0, -1.17),
    doubleArrayOf(6.0, 15.0, -1.36),
    doubleArrayOf(5.0, 10.0, -1.55),
    doubleArrayOf(4.0, 7.0, -1.75),
    doubleArrayOf(3.0, 5.0, -1.94),
    doubleArrayOf(2.0, 3.0, -2.13),
    doubleArrayOf(1.0, 1.0, -2.32),
)

/**
 * IV. Lectura
 * B. Velocidad Lectora - ComprensionFragment
 * Page 65
 */
fun comprensionFragmentE6M4Baremo() = arrayOf(
    doubleArrayOf(15.0, 99.0, 2.14),
    doubleArrayOf(14.0, 98.0, 1.86),
    doubleArrayOf(13.0, 95.0, 1.57),
    doubleArrayOf(12.0, 90.0, 1.29),
    doubleArrayOf(11.0, 80.0, 1.0),
    doubleArrayOf(10.0, 70.0, 0.72),
    doubleArrayOf(9.0, 60.0, 0.43),
    doubleArrayOf(8.0, 50.0, 0.15),
    doubleArrayOf(7.0, 40.0, -0.13),
    doubleArrayOf(6.0, 30.0, -0.42),
    doubleArrayOf(5.0, 20.0, -0.7),
    doubleArrayOf(4.0, 15.0, -0.99),
    doubleArrayOf(3.0, 10.0, -1.27),
    doubleArrayOf(1.0, 5.0, -1.84),
)

/**
 * IV. Lectura
 * B. Velocidad Lectora - VelocidadFragment
 * Page 65
 */
fun velocidadFragmentE6M4Baremo() = arrayOf(
    doubleArrayOf(70.0, 99.0, 1.88),
    doubleArrayOf(90.0, 95.0, 1.46),
    doubleArrayOf(100.0, 90.0, 1.24),
    doubleArrayOf(110.0, 85.0, 1.03),
    doubleArrayOf(120.0, 80.0, 0.81),
    doubleArrayOf(130.0, 70.0, 0.6),
    doubleArrayOf(140.0, 65.0, 0.38),
    doubleArrayOf(150.0, 55.0, 0.17),
    doubleArrayOf(160.0, 50.0, -0.05),
    doubleArrayOf(170.0, 40.0, -0.26),
    doubleArrayOf(180.0, 35.0, -0.48),
    doubleArrayOf(190.0, 25.0, -0.69),
    doubleArrayOf(200.0, 15.0, -0.91),
    doubleArrayOf(210.0, 12.0, -1.12),
    doubleArrayOf(230.0, 10.0, -1.55),
    doubleArrayOf(270.0, 5.0, -2.41),
    doubleArrayOf(350.0, 1.0, -4.12),
)

/**
 * V.- Lectura
 * A.- Ortografia Visual y Reglada
 *
 * Page 73
 */
fun ortografiaVisualRegladaE6M5Baremo() = arrayOf(
    doubleArrayOf(92.0, 99.0, 2.26),
    doubleArrayOf(91.0, 99.0, 2.2),
    doubleArrayOf(90.0, 99.0, 2.13),
    doubleArrayOf(89.0, 97.0, 2.07),
    doubleArrayOf(88.0, 97.0, 2.0),
    doubleArrayOf(87.0, 97.0, 1.94),
    doubleArrayOf(86.0, 97.0, 1.87),
    doubleArrayOf(85.0, 97.0, 1.8),
    doubleArrayOf(84.0, 95.0, 1.74),
    doubleArrayOf(83.0, 95.0, 1.67),
    doubleArrayOf(82.0, 95.0, 1.61),
    doubleArrayOf(81.0, 95.0, 1.54),
    doubleArrayOf(80.0, 95.0, 1.48),
    doubleArrayOf(79.0, 85.0, 1.41),
    doubleArrayOf(78.0, 85.0, 1.35),
    doubleArrayOf(77.0, 85.0, 1.28),
    doubleArrayOf(76.0, 85.0, 1.21),
    doubleArrayOf(75.0, 85.0, 1.15),
    doubleArrayOf(74.0, 75.0, 1.08),
    doubleArrayOf(73.0, 75.0, 1.02),
    doubleArrayOf(72.0, 75.0, 0.95),
    doubleArrayOf(71.0, 75.0, 0.89),
    doubleArrayOf(70.0, 75.0, 0.82),
    doubleArrayOf(69.0, 65.0, 0.75),
    doubleArrayOf(68.0, 65.0, 0.69),
    doubleArrayOf(67.0, 65.0, 0.62),
    doubleArrayOf(66.0, 65.0, 0.56),
    doubleArrayOf(65.0, 65.0, 0.49),
    doubleArrayOf(64.0, 55.0, 0.43),
    doubleArrayOf(63.0, 55.0, 0.36),
    doubleArrayOf(62.0, 55.0, 0.29),
    doubleArrayOf(61.0, 55.0, 0.23),
    doubleArrayOf(60.0, 55.0, 0.16),
    doubleArrayOf(59.0, 50.0, 0.1),
    doubleArrayOf(58.0, 50.0, 0.03),
    doubleArrayOf(57.0, 50.0, -0.03),
    doubleArrayOf(56.0, 50.0, -0.1),
    doubleArrayOf(55.0, 50.0, -0.16),
    doubleArrayOf(54.0, 40.0, -0.23),
    doubleArrayOf(53.0, 40.0, -0.3),
    doubleArrayOf(52.0, 40.0, -0.36),
    doubleArrayOf(51.0, 40.0, -0.43),
    doubleArrayOf(50.0, 40.0, -0.49),
    doubleArrayOf(49.0, 30.0, -0.56),
    doubleArrayOf(48.0, 30.0, -0.62),
    doubleArrayOf(47.0, 30.0, -0.69),
    doubleArrayOf(46.0, 30.0, -0.76),
    doubleArrayOf(45.0, 30.0, -0.82),
    doubleArrayOf(44.0, 20.0, -0.89),
    doubleArrayOf(43.0, 20.0, -0.95),
    doubleArrayOf(42.0, 20.0, -1.02),
    doubleArrayOf(41.0, 20.0, -1.08),
    doubleArrayOf(40.0, 20.0, -1.15),
    doubleArrayOf(39.0, 10.0, -1.22),
    doubleArrayOf(38.0, 10.0, -1.28),
    doubleArrayOf(37.0, 10.0, -1.35),
    doubleArrayOf(36.0, 10.0, -1.41),
    doubleArrayOf(35.0, 10.0, -1.48),
    doubleArrayOf(34.0, 7.0, -1.54),
    doubleArrayOf(33.0, 7.0, -1.61),
    doubleArrayOf(32.0, 7.0, -1.67),
    doubleArrayOf(31.0, 7.0, -1.74),
    doubleArrayOf(30.0, 7.0, -1.81),
    doubleArrayOf(29.0, 5.0, -1.87),
    doubleArrayOf(28.0, 5.0, -1.94),
    doubleArrayOf(27.0, 5.0, -2.0),
    doubleArrayOf(26.0, 5.0, -2.07),
    doubleArrayOf(25.0, 5.0, -2.13),
    doubleArrayOf(24.0, 3.0, -2.2),
    doubleArrayOf(23.0, 3.0, -2.27),
    doubleArrayOf(22.0, 3.0, -2.33),
    doubleArrayOf(21.0, 3.0, -2.4),
    doubleArrayOf(20.0, 3.0, -2.46),
    doubleArrayOf(19.0, 2.0, -2.53),
    doubleArrayOf(18.0, 2.0, -2.59),
    doubleArrayOf(17.0, 2.0, -2.66),
    doubleArrayOf(16.0, 2.0, -2.73),
    doubleArrayOf(15.0, 2.0, -2.79),
    doubleArrayOf(14.0, 1.0, -2.86),
    doubleArrayOf(13.0, 1.0, -2.92),
    doubleArrayOf(12.0, 1.0, -2.99),
    doubleArrayOf(11.0, 1.0, -3.05),
    doubleArrayOf(10.0, 1.0, -3.12),
)

/**
 * VI.- Aprendizaje Matematico
 * A.- Calculo y Numeracion
 *
 * Page 83
 */
fun calculoNumeracionE6M6Baremo() = arrayOf(
    doubleArrayOf(35.0, 99.0, 2.08),
    doubleArrayOf(34.0, 98.0, 1.94),
    doubleArrayOf(33.0, 97.0, 1.8),
    doubleArrayOf(32.0, 96.0, 1.66),
    doubleArrayOf(31.0, 95.0, 1.53),
    doubleArrayOf(30.0, 92.0, 1.39),
    doubleArrayOf(29.0, 90.0, 1.25),
    doubleArrayOf(28.0, 87.0, 1.12),
    doubleArrayOf(27.0, 85.0, 0.98),
    doubleArrayOf(26.0, 82.0, 0.84),
    doubleArrayOf(25.0, 80.0, 0.7),
    doubleArrayOf(24.0, 75.0, 0.57),
    doubleArrayOf(23.0, 65.0, 0.43),
    doubleArrayOf(22.0, 60.0, 0.29),
    doubleArrayOf(21.0, 55.0, 0.15),
    doubleArrayOf(20.0, 50.0, 0.02),
    doubleArrayOf(19.0, 45.0, -0.12),
    doubleArrayOf(18.0, 40.0, -0.26),
    doubleArrayOf(17.0, 37.0, -0.4),
    doubleArrayOf(16.0, 35.0, -0.53),
    doubleArrayOf(15.0, 32.0, -0.67),
    doubleArrayOf(14.0, 30.0, -0.81),
    doubleArrayOf(13.0, 25.0, -0.95),
    doubleArrayOf(12.0, 20.0, -1.08),
    doubleArrayOf(11.0, 15.0, -1.22),
    doubleArrayOf(10.0, 10.0, -1.36),
    doubleArrayOf(9.0, 5.0, -1.49),
    doubleArrayOf(8.0, 1.0, -1.63),
)

/**
 * VI.- Aprendizaje Matematico
 * B.- Resolución Problemas
 *
 * Page 89
 */
fun resolucionProblemasE6M6Baremo() = arrayOf(
    doubleArrayOf(15.0, 99.0, 3.22),
    doubleArrayOf(14.0, 98.0, 2.86),
    doubleArrayOf(13.0, 97.0, 2.5),
    doubleArrayOf(12.0, 95.0, 2.14),
    doubleArrayOf(11.0, 90.0, 1.78),
    doubleArrayOf(10.0, 85.0, 1.43),
    doubleArrayOf(9.0, 75.0, 1.07),
    doubleArrayOf(8.0, 65.0, 0.71),
    doubleArrayOf(7.0, 55.0, 0.35),
    doubleArrayOf(6.0, 45.0, -0.01),
    doubleArrayOf(5.0, 40.0, -0.37),
    doubleArrayOf(4.0, 35.0, -0.72),
    doubleArrayOf(3.0, 20.0, -1.08),
    doubleArrayOf(2.0, 10.0, -1.44),
    doubleArrayOf(1.0, 5.0, -1.8),
    doubleArrayOf(0.0, 1.0, -2.16),
)


