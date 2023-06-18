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
import cl.figonzal.evaluatool.domain.baremo_tables.constants.Evalua4Constants
import cl.figonzal.evaluatool.domain.baremo_tables.constants.Evalua4Constants.AUTO_CONTROL_FRAGMENT_E4M3
import cl.figonzal.evaluatool.domain.baremo_tables.constants.Evalua4Constants.AUTO_ESTIMA_FRAGMENT_E4M3
import cl.figonzal.evaluatool.domain.baremo_tables.constants.Evalua4Constants.CALCULO_NUMERACION_E4M6
import cl.figonzal.evaluatool.domain.baremo_tables.constants.Evalua4Constants.COMPRENSION_LECTORA_E4M4
import cl.figonzal.evaluatool.domain.baremo_tables.constants.Evalua4Constants.COMPRESION_FRAGMENT_E4M4
import cl.figonzal.evaluatool.domain.baremo_tables.constants.Evalua4Constants.CONDUCTA_PRO_SOCIAL_E4M3
import cl.figonzal.evaluatool.domain.baremo_tables.constants.Evalua4Constants.MEMORIA_ATENCION_E4M1
import cl.figonzal.evaluatool.domain.baremo_tables.constants.Evalua4Constants.MOTIVACION_FRAGMENT_E4M3
import cl.figonzal.evaluatool.domain.baremo_tables.constants.Evalua4Constants.ORGANIZACION_PERCEPTIVA_E4M2
import cl.figonzal.evaluatool.domain.baremo_tables.constants.Evalua4Constants.ORTOGRAFIA_VISUAL_REGLADA_E4M5
import cl.figonzal.evaluatool.domain.baremo_tables.constants.Evalua4Constants.PENSAMIENTO_ANALOGICO_E4M2
import cl.figonzal.evaluatool.domain.baremo_tables.constants.Evalua4Constants.REFLEXIVIDAD_E4M2
import cl.figonzal.evaluatool.domain.baremo_tables.constants.Evalua4Constants.RESOLUCION_PROBLEMAS_E4M6
import cl.figonzal.evaluatool.domain.baremo_tables.constants.Evalua4Constants.VELOCIDAD_FRAGMENT_E4M4

/**
 * Evalua 4
 */
class Evalua4Baremo : BaremoTable {

    override fun getBaremo(baremo: BaseConstants) = when (baremo as Evalua4Constants) {
        MEMORIA_ATENCION_E4M1 -> memoriaAtencionE4M1Baremo()

        REFLEXIVIDAD_E4M2 -> reflexividadE4M2Baremo()
        PENSAMIENTO_ANALOGICO_E4M2 -> pensamientoAnalogicoE4M2Baremo()
        ORGANIZACION_PERCEPTIVA_E4M2 -> organizacionPerceptivaE4M2Baremo()

        MOTIVACION_FRAGMENT_E4M3 -> motivacionFragmentE4M3Baremo()
        AUTO_CONTROL_FRAGMENT_E4M3 -> autoControlFragmentE4M3Baremo()
        CONDUCTA_PRO_SOCIAL_E4M3 -> conductaProSocialFragmentE4M3Baremo()
        AUTO_ESTIMA_FRAGMENT_E4M3 -> autoEstimaFragmentE4M3Baremo()

        COMPRENSION_LECTORA_E4M4 -> comprensionLectoraE4M4Baremo()
        VELOCIDAD_FRAGMENT_E4M4 -> velocidadFragmentE4M4Baremo()
        COMPRESION_FRAGMENT_E4M4 -> comprensionFragmentE4M4Baremo()

        ORTOGRAFIA_VISUAL_REGLADA_E4M5 -> ortografiaVisualRegladaE4M5Baremo()

        CALCULO_NUMERACION_E4M6 -> calculoNumeracionE4M6Baremo()
        RESOLUCION_PROBLEMAS_E4M6 -> resolucionProblemasE4M6Baremo()
    }
}

/**
 * I.- Memoria y Atencion
 *
 * Page 29
 */
private fun memoriaAtencionE4M1Baremo() = arrayOf(
    doubleArrayOf(103.0, 99.0, 2.36),
    doubleArrayOf(102.0, 99.0, 2.3),
    doubleArrayOf(101.0, 99.0, 2.24),
    doubleArrayOf(100.0, 99.0, 2.18),
    doubleArrayOf(99.0, 99.0, 2.12),
    doubleArrayOf(98.0, 99.0, 2.07),
    doubleArrayOf(97.0, 99.0, 2.01),
    doubleArrayOf(96.0, 99.0, 1.95),
    doubleArrayOf(95.0, 99.0, 1.89),
    doubleArrayOf(94.0, 95.0, 1.83),
    doubleArrayOf(93.0, 95.0, 1.77),
    doubleArrayOf(92.0, 95.0, 1.71),
    doubleArrayOf(91.0, 95.0, 1.66),
    doubleArrayOf(90.0, 95.0, 1.6),
    doubleArrayOf(89.0, 90.0, 1.54),
    doubleArrayOf(88.0, 90.0, 1.48),
    doubleArrayOf(87.0, 90.0, 1.42),
    doubleArrayOf(86.0, 90.0, 1.36),
    doubleArrayOf(85.0, 90.0, 1.31),
    doubleArrayOf(84.0, 85.0, 1.25),
    doubleArrayOf(83.0, 85.0, 1.19),
    doubleArrayOf(82.0, 85.0, 1.13),
    doubleArrayOf(81.0, 85.0, 1.07),
    doubleArrayOf(80.0, 85.0, 1.01),
    doubleArrayOf(79.0, 80.0, 0.95),
    doubleArrayOf(78.0, 80.0, 0.9),
    doubleArrayOf(77.0, 80.0, 0.84),
    doubleArrayOf(76.0, 80.0, 0.78),
    doubleArrayOf(75.0, 80.0, 0.72),
    doubleArrayOf(74.0, 70.0, 0.66),
    doubleArrayOf(73.0, 70.0, 0.6),
    doubleArrayOf(72.0, 70.0, 0.55),
    doubleArrayOf(71.0, 70.0, 0.49),
    doubleArrayOf(70.0, 70.0, 0.43),
    doubleArrayOf(69.0, 60.0, 0.37),
    doubleArrayOf(68.0, 60.0, 0.31),
    doubleArrayOf(67.0, 60.0, 0.25),
    doubleArrayOf(66.0, 60.0, 0.2),
    doubleArrayOf(65.0, 60.0, 0.14),
    doubleArrayOf(64.0, 50.0, 0.08),
    doubleArrayOf(63.0, 50.0, 0.02),
    doubleArrayOf(62.0, 50.0, -0.04),
    doubleArrayOf(61.0, 50.0, -0.1),
    doubleArrayOf(60.0, 50.0, -0.16),
    doubleArrayOf(59.0, 40.0, -0.21),
    doubleArrayOf(58.0, 40.0, -0.27),
    doubleArrayOf(57.0, 40.0, -0.33),
    doubleArrayOf(56.0, 40.0, -0.39),
    doubleArrayOf(55.0, 40.0, -0.45),
    doubleArrayOf(54.0, 30.0, -0.51),
    doubleArrayOf(53.0, 30.0, -0.56),
    doubleArrayOf(52.0, 30.0, -0.62),
    doubleArrayOf(51.0, 30.0, -0.68),
    doubleArrayOf(50.0, 30.0, -0.74),
    doubleArrayOf(49.0, 20.0, -0.8),
    doubleArrayOf(48.0, 20.0, -0.86),
    doubleArrayOf(47.0, 20.0, -0.92),
    doubleArrayOf(46.0, 20.0, -0.97),
    doubleArrayOf(45.0, 20.0, -1.03),
    doubleArrayOf(44.0, 15.0, -1.09),
    doubleArrayOf(43.0, 15.0, -1.15),
    doubleArrayOf(42.0, 15.0, -1.21),
    doubleArrayOf(41.0, 15.0, -1.27),
    doubleArrayOf(40.0, 15.0, -1.32),
    doubleArrayOf(39.0, 12.0, -1.38),
    doubleArrayOf(38.0, 12.0, -1.44),
    doubleArrayOf(37.0, 12.0, -1.5),
    doubleArrayOf(36.0, 12.0, -1.56),
    doubleArrayOf(35.0, 12.0, -1.62),
    doubleArrayOf(34.0, 10.0, -1.68),
    doubleArrayOf(33.0, 10.0, -1.73),
    doubleArrayOf(32.0, 10.0, -1.79),
    doubleArrayOf(31.0, 10.0, -1.85),
    doubleArrayOf(30.0, 10.0, -1.91),
    doubleArrayOf(29.0, 7.0, -1.97),
    doubleArrayOf(28.0, 7.0, -2.03),
    doubleArrayOf(27.0, 7.0, -2.08),
    doubleArrayOf(26.0, 7.0, -2.14),
    doubleArrayOf(25.0, 7.0, -2.2),
    doubleArrayOf(24.0, 5.0, -2.26),
    doubleArrayOf(23.0, 5.0, -2.32),
    doubleArrayOf(22.0, 5.0, -2.38),
    doubleArrayOf(21.0, 5.0, -2.43),
    doubleArrayOf(20.0, 5.0, -2.49),
    doubleArrayOf(19.0, 3.0, -2.55),
    doubleArrayOf(18.0, 3.0, -2.61),
    doubleArrayOf(17.0, 3.0, -2.67),
    doubleArrayOf(16.0, 3.0, -2.73),
    doubleArrayOf(15.0, 3.0, -2.79),
    doubleArrayOf(14.0, 2.0, -2.84),
    doubleArrayOf(13.0, 2.0, -2.9),
    doubleArrayOf(12.0, 2.0, -2.96),
    doubleArrayOf(11.0, 2.0, -3.02),
    doubleArrayOf(10.0, 2.0, -3.08),
    doubleArrayOf(9.0, 1.0, -3.14),
    doubleArrayOf(8.0, 1.0, -3.19),
    doubleArrayOf(7.0, 1.0, -3.25),
    doubleArrayOf(6.0, 1.0, -3.31),
    doubleArrayOf(5.0, 1.0, -3.37),
)

/**
 * II.- Memoria y Atencion
 * A. Reflexividad
 * Page 35
 */
private fun reflexividadE4M2Baremo() = arrayOf(
    doubleArrayOf(20.0, 95.0, 1.14),
    doubleArrayOf(19.0, 85.0, 0.95),
    doubleArrayOf(18.0, 75.0, 0.76),
    doubleArrayOf(17.0, 65.0, 0.57),
    doubleArrayOf(16.0, 60.0, 0.39),
    doubleArrayOf(15.0, 55.0, 0.2),
    doubleArrayOf(14.0, 50.0, 0.01),
    doubleArrayOf(13.0, 40.0, -0.18),
    doubleArrayOf(12.0, 30.0, -0.36),
    doubleArrayOf(11.0, 25.0, -0.55),
    doubleArrayOf(10.0, 20.0, -0.74),
    doubleArrayOf(9.0, 15.0, -0.93),
    doubleArrayOf(8.0, 13.0, -1.11),
    doubleArrayOf(7.0, 12.0, -1.3),
    doubleArrayOf(6.0, 10.0, -1.49),
    doubleArrayOf(5.0, 9.0, -1.68),
    doubleArrayOf(4.0, 7.0, -1.86),
    doubleArrayOf(3.0, 5.0, -2.05),
    doubleArrayOf(2.0, 3.0, -2.24),
    doubleArrayOf(1.0, 2.0, -2.43),
    doubleArrayOf(0.0, 1.0, -2.62),
)

/**
 * II.- Memoria y Atencion
 * B. Pensamiento Analogico
 * Page 41
 */
private fun pensamientoAnalogicoE4M2Baremo() = arrayOf(
    doubleArrayOf(20.0, 99.0, 1.59),
    doubleArrayOf(19.0, 97.0, 1.35),
    doubleArrayOf(18.0, 92.0, 1.1),
    doubleArrayOf(17.0, 80.0, 0.85),
    doubleArrayOf(16.0, 70.0, 0.6),
    doubleArrayOf(15.0, 60.0, 0.36),
    doubleArrayOf(14.0, 50.0, 0.11),
    doubleArrayOf(13.0, 40.0, -0.14),
    doubleArrayOf(12.0, 35.0, -0.38),
    doubleArrayOf(11.0, 30.0, -0.63),
    doubleArrayOf(10.0, 25.0, -0.88),
    doubleArrayOf(9.0, 20.0, -1.12),
    doubleArrayOf(8.0, 15.0, -1.37),
    doubleArrayOf(7.0, 10.0, -1.62),
    doubleArrayOf(6.0, 7.0, -1.86),
    doubleArrayOf(5.0, 5.0, -2.11),
    doubleArrayOf(4.0, 3.0, -2.36),
    doubleArrayOf(3.0, 2.0, -2.6),
    doubleArrayOf(2.0, 1.0, -2.85),
    doubleArrayOf(1.0, 1.0, -3.1),
)

/**
 * II.- Memoria y Atencion
 * C. Organizacion Perceptiva
 * Page 47
 */
private fun organizacionPerceptivaE4M2Baremo() = arrayOf(
    doubleArrayOf(18.0, 99.0, 1.5),
    doubleArrayOf(17.0, 90.0, 1.19),
    doubleArrayOf(16.0, 75.0, 0.88),
    doubleArrayOf(15.0, 70.0, 0.57),
    doubleArrayOf(14.0, 60.0, 0.26),
    doubleArrayOf(13.0, 50.0, -0.06),
    doubleArrayOf(12.0, 40.0, -0.37),
    doubleArrayOf(11.0, 30.0, -0.68),
    doubleArrayOf(10.0, 20.0, -0.99),
    doubleArrayOf(9.0, 15.0, -1.3),
    doubleArrayOf(8.0, 10.0, -1.61),
    doubleArrayOf(7.0, 7.0, -1.93),
    doubleArrayOf(6.0, 5.0, -2.24),
    doubleArrayOf(5.0, 3.0, -2.55),
    doubleArrayOf(4.0, 2.0, -2.86),
    doubleArrayOf(3.0, 1.0, -3.17),
)

/**
 * III.- Niveles de Adaptacion
 * A. Motivacion
 * Page 55
 */
private fun motivacionFragmentE4M3Baremo() = arrayOf(
    doubleArrayOf(0.0, 99.0, 1.95),
    doubleArrayOf(1.0, 98.0, 1.67),
    doubleArrayOf(2.0, 95.0, 1.38),
    doubleArrayOf(3.0, 90.0, 1.1),
    doubleArrayOf(4.0, 85.0, 0.82),
    doubleArrayOf(5.0, 80.0, 0.54),
    doubleArrayOf(6.0, 70.0, 0.25),
    doubleArrayOf(7.0, 65.0, -0.03),
    doubleArrayOf(8.0, 60.0, -0.31),
    doubleArrayOf(9.0, 55.0, -0.59),
    doubleArrayOf(10.0, 50.0, -0.88),
    doubleArrayOf(11.0, 40.0, -1.16),
    doubleArrayOf(12.0, 35.0, -1.44),
    doubleArrayOf(13.0, 30.0, -1.72),
    doubleArrayOf(14.0, 25.0, -2.01),
    doubleArrayOf(15.0, 20.0, -2.29),
    doubleArrayOf(16.0, 18.0, -2.57),
    doubleArrayOf(17.0, 15.0, -2.85),
    doubleArrayOf(18.0, 12.0, -3.14),
    doubleArrayOf(19.0, 10.0, -3.42),
    doubleArrayOf(20.0, 9.0, -3.7),
    doubleArrayOf(22.0, 7.0, -4.27),
    doubleArrayOf(24.0, 5.0, -4.83),
    doubleArrayOf(26.0, 3.0, -5.4),
    doubleArrayOf(28.0, 2.0, -5.96),
    doubleArrayOf(30.0, 1.0, -6.53),
)

/**
 * III.- Niveles de Adaptacion
 * B. AutoControl
 * Page 55
 */
private fun autoControlFragmentE4M3Baremo() = arrayOf(
    doubleArrayOf(0.0, 99.0, 1.39),
    doubleArrayOf(1.0, 95.0, 0.98),
    doubleArrayOf(2.0, 80.0, 0.56),
    doubleArrayOf(3.0, 70.0, 0.15),
    doubleArrayOf(4.0, 60.0, -0.26),
    doubleArrayOf(5.0, 50.0, -0.67),
    doubleArrayOf(6.0, 40.0, -1.08),
    doubleArrayOf(7.0, 35.0, -1.49),
    doubleArrayOf(8.0, 25.0, -1.91),
    doubleArrayOf(9.0, 20.0, -2.32),
    doubleArrayOf(10.0, 15.0, -2.73),
    doubleArrayOf(11.0, 10.0, -3.14),
    doubleArrayOf(12.0, 7.0, -3.55),
    doubleArrayOf(13.0, 5.0, -3.96),
    doubleArrayOf(14.0, 3.0, -4.37),
    doubleArrayOf(15.0, 1.0, -4.79),
)

/**
 * III.- Niveles de Adaptacion
 * C. ConductaProSocial
 * Page 55
 */
private fun conductaProSocialFragmentE4M3Baremo() = arrayOf(
    doubleArrayOf(0.0, 94.0, 1.25),
    doubleArrayOf(1.0, 82.0, 0.77),
    doubleArrayOf(2.0, 65.0, 0.28),
    doubleArrayOf(3.0, 50.0, -0.21),
    doubleArrayOf(4.0, 40.0, -0.7),
    doubleArrayOf(5.0, 35.0, -1.19),
    doubleArrayOf(6.0, 30.0, -1.67),
    doubleArrayOf(7.0, 20.0, -2.16),
    doubleArrayOf(8.0, 15.0, -2.65),
    doubleArrayOf(9.0, 12.0, -3.14),
    doubleArrayOf(10.0, 10.0, -3.62),
    doubleArrayOf(11.0, 9.0, -4.11),
    doubleArrayOf(12.0, 7.0, -4.6),
    doubleArrayOf(13.0, 5.0, -5.09),
    doubleArrayOf(14.0, 3.0, -5.58),
    doubleArrayOf(15.0, 1.0, -6.06),
)

/**
 * III.- Niveles de Adaptacion
 * D. AutoEstima
 * Page 55
 */
private fun autoEstimaFragmentE4M3Baremo() = arrayOf(
    doubleArrayOf(0.0, 99.0, 1.96),
    doubleArrayOf(1.0, 95.0, 1.58),
    doubleArrayOf(2.0, 90.0, 1.19),
    doubleArrayOf(3.0, 80.0, 0.8),
    doubleArrayOf(4.0, 75.0, 0.42),
    doubleArrayOf(5.0, 65.0, 0.03),
    doubleArrayOf(6.0, 55.0, -0.36),
    doubleArrayOf(7.0, 45.0, -0.74),
    doubleArrayOf(8.0, 40.0, -1.13),
    doubleArrayOf(9.0, 35.0, -1.51),
    doubleArrayOf(10.0, 25.0, -1.9),
    doubleArrayOf(11.0, 15.0, -2.29),
    doubleArrayOf(12.0, 10.0, -2.67),
    doubleArrayOf(13.0, 9.0, -3.06),
    doubleArrayOf(14.0, 7.0, -3.44),
    doubleArrayOf(15.0, 5.0, -3.83),
    doubleArrayOf(16.0, 3.0, -4.22),
    doubleArrayOf(17.0, 1.0, -4.6),
)

/**
 * IV.- Lectura
 * A. Comprension Lectora
 * Page 61
 */
private fun comprensionLectoraE4M4Baremo() = arrayOf(
    doubleArrayOf(32.0, 99.0, 1.59),
    doubleArrayOf(31.0, 99.0, 1.44),
    doubleArrayOf(30.0, 94.0, 1.29),
    doubleArrayOf(29.0, 94.0, 1.14),
    doubleArrayOf(28.0, 85.0, 0.98),
    doubleArrayOf(27.0, 85.0, 0.83),
    doubleArrayOf(26.0, 70.0, 0.68),
    doubleArrayOf(25.0, 70.0, 0.53),
    doubleArrayOf(24.0, 60.0, 0.38),
    doubleArrayOf(23.0, 60.0, 0.23),
    doubleArrayOf(22.0, 50.0, 0.08),
    doubleArrayOf(21.0, 50.0, -0.07),
    doubleArrayOf(20.0, 40.0, -0.22),
    doubleArrayOf(19.0, 40.0, -0.37),
    doubleArrayOf(18.0, 30.0, -0.52),
    doubleArrayOf(17.0, 30.0, -0.67),
    doubleArrayOf(16.0, 25.0, -0.83),
    doubleArrayOf(15.0, 25.0, -0.98),
    doubleArrayOf(14.0, 15.0, -1.13),
    doubleArrayOf(13.0, 15.0, -1.28),
    doubleArrayOf(12.0, 10.0, -1.43),
    doubleArrayOf(11.0, 10.0, -1.58),
    doubleArrayOf(10.0, 8.0, -1.73),
    doubleArrayOf(9.0, 8.0, -1.88),
    doubleArrayOf(8.0, 6.0, -2.03),
    doubleArrayOf(7.0, 6.0, -2.18),
    doubleArrayOf(6.0, 4.0, -2.33),
    doubleArrayOf(5.0, 4.0, -2.48),
    doubleArrayOf(4.0, 2.0, -2.63),
    doubleArrayOf(3.0, 2.0, -2.79),
    doubleArrayOf(2.0, 1.0, -2.94),
    doubleArrayOf(1.0, 1.0, -3.09),
)

/**
 * IV.- Lectura
 * B. Velocidad Lectora - VelocidadFragment
 * Page 67
 */
private fun velocidadFragmentE4M4Baremo() = arrayOf(
    doubleArrayOf(60.0, 99.0, 1.92),
    doubleArrayOf(70.0, 97.0, 1.64),
    doubleArrayOf(80.0, 95.0, 1.36),
    doubleArrayOf(90.0, 90.0, 1.09),
    doubleArrayOf(100.0, 85.0, .81),
    doubleArrayOf(110.0, 75.0, 0.53),
    doubleArrayOf(120.0, 65.0, 0.26),
    doubleArrayOf(130.0, 55.0, -0.02),
    doubleArrayOf(140.0, 45.0, -0.3),
    doubleArrayOf(150.0, 40.0, -0.58),
    doubleArrayOf(160.0, 30.0, -0.85),
    doubleArrayOf(170.0, 25.0, -1.13),
    doubleArrayOf(180.0, 20.0, -1.41),
    doubleArrayOf(190.0, 15.0, -1.68),
    doubleArrayOf(200.0, 10.0, -1.96),
    doubleArrayOf(220.0, 5.0, -2.52),
    doubleArrayOf(230.0, 3.0, -2.79),
    doubleArrayOf(250.0, 2.0, -3.35),
    doubleArrayOf(300.0, 1.0, -4.73),
    doubleArrayOf(380.0, 0.0, -6.95),
)

/**
 * IV.- Lectura
 * B. Velocidad Lectora - ComprensionFragment
 * Page 67
 */
private fun comprensionFragmentE4M4Baremo() = arrayOf(
    doubleArrayOf(15.0, 97.0, 1.68),
    doubleArrayOf(14.0, 95.0, 1.43),
    doubleArrayOf(13.0, 85.0, 1.18),
    doubleArrayOf(12.0, 80.0, 0.93),
    doubleArrayOf(11.0, 70.0, 0.68),
    doubleArrayOf(10.0, 60.0, 0.43),
    doubleArrayOf(9.0, 50.0, 0.18),
    doubleArrayOf(8.0, 40.0, -0.06),
    doubleArrayOf(7.0, 35.0, -0.31),
    doubleArrayOf(6.0, 30.0, -0.56),
    doubleArrayOf(5.0, 25.0, -0.81),
    doubleArrayOf(4.0, 20.0, -1.06),
    doubleArrayOf(3.0, 10.0, -1.31),
    doubleArrayOf(2.0, 5.0, -1.56),
    doubleArrayOf(1.0, 1.0, -1.81),
)

/**
 * V. Escritura
 * A. Ortografia Visual Reglada
 * Page 75
 */
private fun ortografiaVisualRegladaE4M5Baremo() = arrayOf(
    doubleArrayOf(80.0, 99.0, 2.46),
    doubleArrayOf(79.0, 99.0, 2.39),
    doubleArrayOf(78.0, 99.0, 2.33),
    doubleArrayOf(77.0, 98.0, 2.27),
    doubleArrayOf(76.0, 98.0, 2.21),
    doubleArrayOf(75.0, 98.0, 2.14),
    doubleArrayOf(74.0, 97.0, 2.08),
    doubleArrayOf(73.0, 97.0, 2.02),
    doubleArrayOf(72.0, 97.0, 1.96),
    doubleArrayOf(71.0, 96.0, 1.89),
    doubleArrayOf(70.0, 96.0, 1.83),
    doubleArrayOf(69.0, 96.0, 1.77),
    doubleArrayOf(68.0, 94.0, 1.71),
    doubleArrayOf(67.0, 94.0, 1.64),
    doubleArrayOf(66.0, 94.0, 1.58),
    doubleArrayOf(65.0, 92.0, 1.52),
    doubleArrayOf(64.0, 92.0, 1.46),
    doubleArrayOf(63.0, 92.0, 1.4),
    doubleArrayOf(62.0, 90.0, 1.33),
    doubleArrayOf(61.0, 90.0, 1.27),
    doubleArrayOf(60.0, 90.0, 1.21),
    doubleArrayOf(59.0, 85.0, 1.15),
    doubleArrayOf(58.0, 85.0, 1.08),
    doubleArrayOf(57.0, 85.0, 1.02),
    doubleArrayOf(56.0, 80.0, 0.96),
    doubleArrayOf(55.0, 80.0, 0.9),
    doubleArrayOf(54.0, 80.0, 0.83),
    doubleArrayOf(53.0, 75.0, 0.77),
    doubleArrayOf(52.0, 75.0, 0.71),
    doubleArrayOf(51.0, 75.0, 0.65),
    doubleArrayOf(50.0, 70.0, 0.58),
    doubleArrayOf(49.0, 70.0, 0.52),
    doubleArrayOf(48.0, 70.0, 0.46),
    doubleArrayOf(47.0, 60.0, 0.4),
    doubleArrayOf(46.0, 60.0, 0.34),
    doubleArrayOf(45.0, 60.0, 0.27),
    doubleArrayOf(44.0, 55.0, 0.21),
    doubleArrayOf(43.0, 55.0, 0.15),
    doubleArrayOf(42.0, 55.0, 0.09),
    doubleArrayOf(41.0, 50.0, 0.02),
    doubleArrayOf(40.0, 50.0, -0.04),
    doubleArrayOf(39.0, 50.0, -0.1),
    doubleArrayOf(38.0, 40.0, -0.16),
    doubleArrayOf(37.0, 40.0, -0.23),
    doubleArrayOf(36.0, 40.0, -0.29),
    doubleArrayOf(35.0, 35.0, -0.35),
    doubleArrayOf(34.0, 35.0, -0.41),
    doubleArrayOf(33.0, 35.0, -0.48),
    doubleArrayOf(32.0, 30.0, -0.54),
    doubleArrayOf(31.0, 30.0, -0.6),
    doubleArrayOf(30.0, 30.0, -0.66),
    doubleArrayOf(29.0, 25.0, -0.72),
    doubleArrayOf(28.0, 25.0, -0.79),
    doubleArrayOf(27.0, 25.0, -0.85),
    doubleArrayOf(26.0, 20.0, -0.91),
    doubleArrayOf(25.0, 20.0, -0.97),
    doubleArrayOf(24.0, 20.0, -1.04),
    doubleArrayOf(23.0, 17.0, -1.1),
    doubleArrayOf(22.0, 17.0, -1.16),
    doubleArrayOf(21.0, 17.0, -1.22),
    doubleArrayOf(20.0, 15.0, -1.29),
    doubleArrayOf(19.0, 15.0, -1.35),
    doubleArrayOf(18.0, 15.0, -1.41),
    doubleArrayOf(17.0, 10.0, -1.47),
    doubleArrayOf(16.0, 10.0, -1.53),
    doubleArrayOf(15.0, 10.0, -1.6),
    doubleArrayOf(14.0, 5.0, -1.66),
    doubleArrayOf(13.0, 5.0, -1.72),
    doubleArrayOf(12.0, 5.0, -1.78),
    doubleArrayOf(11.0, 1.0, -1.85),
    doubleArrayOf(10.0, 1.0, -1.91),
    doubleArrayOf(9.0, 1.0, -1.97),
)

/**
 * VI. Aprendizajes Matematicos
 * A. Calculo y Numeracion
 * Page 85
 */
private fun calculoNumeracionE4M6Baremo() = arrayOf(
    doubleArrayOf(35.0, 99.0, 1.35),
    doubleArrayOf(34.0, 95.0, 1.15),
    doubleArrayOf(33.0, 85.0, 0.96),
    doubleArrayOf(32.0, 80.0, 0.77),
    doubleArrayOf(31.0, 70.0, 0.57),
    doubleArrayOf(30.0, 65.0, 0.38),
    doubleArrayOf(29.0, 55.0, 0.18),
    doubleArrayOf(28.0, 50.0, -0.01),
    doubleArrayOf(27.0, 45.0, -0.2),
    doubleArrayOf(26.0, 40.0, -0.4),
    doubleArrayOf(25.0, 37.0, -0.59),
    doubleArrayOf(24.0, 35.0, -0.78),
    doubleArrayOf(23.0, 30.0, -0.98),
    doubleArrayOf(22.0, 25.0, -1.17),
    doubleArrayOf(21.0, 20.0, -1.37),
    doubleArrayOf(20.0, 18.0, -1.56),
    doubleArrayOf(19.0, 15.0, -1.75),
    doubleArrayOf(18.0, 12.0, -1.95),
    doubleArrayOf(17.0, 10.0, -2.14),
    doubleArrayOf(16.0, 9.0, -2.34),
    doubleArrayOf(15.0, 8.0, -2.53),
    doubleArrayOf(14.0, 7.0, -2.72),
    doubleArrayOf(13.0, 6.0, -2.92),
    doubleArrayOf(12.0, 5.0, -3.11),
    doubleArrayOf(11.0, 3.0, -3.3),
    doubleArrayOf(10.0, 2.0, -3.5),
    doubleArrayOf(9.0, 1.0, -3.69),
)

/**
 * VI. Aprendizajes Matematicos
 * B. Resolucion de Problemas
 * Page 93
 */
private fun resolucionProblemasE4M6Baremo() = arrayOf(
    doubleArrayOf(15.0, 99.0, 1.94),
    doubleArrayOf(14.0, 98.0, 1.66),
    doubleArrayOf(13.0, 95.0, 1.38),
    doubleArrayOf(12.0, 85.0, 1.09),
    doubleArrayOf(11.0, 75.0, 0.81),
    doubleArrayOf(10.0, 65.0, 0.52),
    doubleArrayOf(9.0, 60.0, 0.24),
    doubleArrayOf(8.0, 50.0, -0.05),
    doubleArrayOf(7.0, 40.0, -0.33),
    doubleArrayOf(6.0, 35.0, -0.61),
    doubleArrayOf(5.0, 25.0, -0.9),
    doubleArrayOf(4.0, 20.0, -1.18),
    doubleArrayOf(3.0, 15.0, -1.47),
    doubleArrayOf(2.0, 10.0, -1.75),
    doubleArrayOf(1.0, 5.0, -2.03),
    doubleArrayOf(0.0, 3.0, -2.32),
)
