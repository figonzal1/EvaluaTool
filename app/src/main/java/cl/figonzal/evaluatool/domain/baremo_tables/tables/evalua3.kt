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
import cl.figonzal.evaluatool.domain.baremo_tables.constants.Evalua3Constants
import cl.figonzal.evaluatool.domain.baremo_tables.constants.Evalua3Constants.AUTO_CONTROL_FRAGMENT_E3M3
import cl.figonzal.evaluatool.domain.baremo_tables.constants.Evalua3Constants.AUTO_ESTIMA_FRAGMENT_E3M3
import cl.figonzal.evaluatool.domain.baremo_tables.constants.Evalua3Constants.CALCULO_NUMERACION_E3M6
import cl.figonzal.evaluatool.domain.baremo_tables.constants.Evalua3Constants.COMPRENSION_LECTORA_E3M4
import cl.figonzal.evaluatool.domain.baremo_tables.constants.Evalua3Constants.CONDUCTA_PRO_SOCIAL_E3M3
import cl.figonzal.evaluatool.domain.baremo_tables.constants.Evalua3Constants.EXACTITUD_LECTORA_E3M4
import cl.figonzal.evaluatool.domain.baremo_tables.constants.Evalua3Constants.MEMORIA_ATENCION_E3M1
import cl.figonzal.evaluatool.domain.baremo_tables.constants.Evalua3Constants.MOTIVACION_FRAGMENT_E3M3
import cl.figonzal.evaluatool.domain.baremo_tables.constants.Evalua3Constants.ORGANIZACION_PERCEPTIVA_E3M2
import cl.figonzal.evaluatool.domain.baremo_tables.constants.Evalua3Constants.ORTOGRAFIA_FONETICA_E3M5
import cl.figonzal.evaluatool.domain.baremo_tables.constants.Evalua3Constants.ORTOGRAFIA_VISUAL_E3M5
import cl.figonzal.evaluatool.domain.baremo_tables.constants.Evalua3Constants.PENSAMIENTO_ANALOGICO_E3M2
import cl.figonzal.evaluatool.domain.baremo_tables.constants.Evalua3Constants.REFLEXIVIDAD_E3M2
import cl.figonzal.evaluatool.domain.baremo_tables.constants.Evalua3Constants.RESOLUCION_PROBLEMAS_E3M6

/**
 * Evalua 3
 */
class Evalua3Baremo : BaremoTable {

    override fun getBaremo(baremo: BaseConstants) = when (baremo as Evalua3Constants) {
        MEMORIA_ATENCION_E3M1 -> memoriaAtencionE3M1Baremo()

        REFLEXIVIDAD_E3M2 -> reflexividadE3M2Baremo()
        PENSAMIENTO_ANALOGICO_E3M2 -> pensamientoAnalogicoE3M2Baremo()
        ORGANIZACION_PERCEPTIVA_E3M2 -> organizacionPerceptivaE3M2Baremo()

        MOTIVACION_FRAGMENT_E3M3 -> motivacionFragmentE3M3Baremo()
        AUTO_CONTROL_FRAGMENT_E3M3 -> autoControlFragmentE3M3Baremo()
        CONDUCTA_PRO_SOCIAL_E3M3 -> conductaProSocialFragmentE3M3Baremo()
        AUTO_ESTIMA_FRAGMENT_E3M3 -> autoEstimaFragmentE3M3Baremo()

        COMPRENSION_LECTORA_E3M4 -> comprensionLectoraE3M4Baremo()
        EXACTITUD_LECTORA_E3M4 -> exactitudLectoraE3M4Baremo()

        ORTOGRAFIA_FONETICA_E3M5 -> ortografiaFoneticaE3M5Baremo()
        ORTOGRAFIA_VISUAL_E3M5 -> ortografiaVisualRegladaE3M5Baremo()

        CALCULO_NUMERACION_E3M6 -> calculoNumeracionE3M6Baremo()
        RESOLUCION_PROBLEMAS_E3M6 -> resolucionProblemasE3M6Baremo()
    }
}

/**
 * I.- Memoria y Atencion
 *
 * Page 27
 */
private fun memoriaAtencionE3M1Baremo() = arrayOf(
    doubleArrayOf(125.0, 99.0, 2.16),
    doubleArrayOf(122.0, 97.0, 2.0),
    doubleArrayOf(119.0, 95.0, 1.84),
    doubleArrayOf(116.0, 93.0, 1.68),
    doubleArrayOf(113.0, 90.0, 1.53),
    doubleArrayOf(110.0, 87.0, 1.37),
    doubleArrayOf(107.0, 85.0, 1.21),
    doubleArrayOf(104.0, 80.0, 1.05),
    doubleArrayOf(101.0, 75.0, 0.89),
    doubleArrayOf(98.0, 70.0, 0.73),
    doubleArrayOf(95.0, 67.0, 0.57),
    doubleArrayOf(92.0, 62.0, 0.41),
    doubleArrayOf(89.0, 60.0, 0.25),
    doubleArrayOf(86.0, 55.0, 0.09),
    doubleArrayOf(83.0, 50.0, -0.07),
    doubleArrayOf(80.0, 45.0, -0.23),
    doubleArrayOf(77.0, 42.0, -0.39),
    doubleArrayOf(74.0, 40.0, -0.55),
    doubleArrayOf(71.0, 35.0, -0.71),
    doubleArrayOf(68.0, 30.0, -0.87),
    doubleArrayOf(65.0, 25.0, -1.03),
    doubleArrayOf(62.0, 20.0, -1.19),
    doubleArrayOf(59.0, 17.0, -1.35),
    doubleArrayOf(56.0, 15.0, -1.51),
    doubleArrayOf(53.0, 12.0, -1.67),
    doubleArrayOf(50.0, 10.0, -1.83),
    doubleArrayOf(47.0, 7.0, -1.99),
    doubleArrayOf(44.0, 5.0, -2.15),
    doubleArrayOf(41.0, 3.0, -2.31)
)

/**
 * II.- Bases del razonamiento
 * A. Reflexividad
 * Page 33
 */
private fun reflexividadE3M2Baremo() = arrayOf(
    doubleArrayOf(22.0, 99.0, 1.63),
    doubleArrayOf(21.0, 95.0, 1.47),
    doubleArrayOf(20.0, 90.0, 1.31),
    doubleArrayOf(19.0, 87.0, 1.15),
    doubleArrayOf(18.0, 85.0, 0.99),
    doubleArrayOf(17.0, 80.0, 0.83),
    doubleArrayOf(16.0, 75.0, 0.67),
    doubleArrayOf(15.0, 70.0, 0.51),
    doubleArrayOf(14.0, 65.0, 0.35),
    doubleArrayOf(13.0, 60.0, 0.19),
    doubleArrayOf(12.0, 55.0, 0.03),
    doubleArrayOf(11.0, 50.0, -0.14),
    doubleArrayOf(10.0, 47.0, -0.3),
    doubleArrayOf(9.0, 42.0, -0.46),
    doubleArrayOf(8.0, 40.0, -0.62),
    doubleArrayOf(7.0, 35.0, -0.78),
    doubleArrayOf(6.0, 30.0, -0.94),
    doubleArrayOf(5.0, 25.0, -1.1),
    doubleArrayOf(4.0, 15.0, -1.26),
    doubleArrayOf(3.0, 10.0, -1.42),
    doubleArrayOf(2.0, 5.0, -1.58),
    doubleArrayOf(1.0, 1.0, -1.74),
)

/**
 * II.- Bases del razonamiento
 * B. Pensamiento Analogico
 * Page 39
 */
private fun pensamientoAnalogicoE3M2Baremo() = arrayOf(
    doubleArrayOf(20.0, 99.0, 2.03),
    doubleArrayOf(19.0, 97.0, 1.84),
    doubleArrayOf(18.0, 95.0, 1.65),
    doubleArrayOf(17.0, 92.0, 1.46),
    doubleArrayOf(16.0, 87.0, 1.27),
    doubleArrayOf(15.0, 80.0, 1.08),
    doubleArrayOf(14.0, 75.0, 0.89),
    doubleArrayOf(13.0, 70.0, 0.7),
    doubleArrayOf(12.0, 65.0, 0.51),
    doubleArrayOf(11.0, 60.0, 0.32),
    doubleArrayOf(10.0, 55.0, 0.13),
    doubleArrayOf(9.0, 50.0, -0.06),
    doubleArrayOf(8.0, 45.0, -0.25),
    doubleArrayOf(7.0, 40.0, -0.44),
    doubleArrayOf(6.0, 35.0, -0.63),
    doubleArrayOf(5.0, 30.0, -0.82),
    doubleArrayOf(4.0, 25.0, -1.01),
    doubleArrayOf(3.0, 15.0, -1.2),
    doubleArrayOf(2.0, 10.0, -1.39),
    doubleArrayOf(1.0, 5.0, -1.58),
)

/**
 * II.- Bases del razonamiento
 * C. Organizacion Perceptiva
 * Page 45
 */
private fun organizacionPerceptivaE3M2Baremo() = arrayOf(
    doubleArrayOf(20.0, 99.0, 1.54),
    doubleArrayOf(19.0, 95.0, 1.37),
    doubleArrayOf(18.0, 90.0, 1.2),
    doubleArrayOf(17.0, 80.0, 1.03),
    doubleArrayOf(16.0, 75.0, 0.86),
    doubleArrayOf(15.0, 70.0, 0.69),
    doubleArrayOf(14.0, 65.0, 0.52),
    doubleArrayOf(13.0, 60.0, 0.35),
    doubleArrayOf(12.0, 55.0, 0.18),
    doubleArrayOf(11.0, 50.0, 0.01),
    doubleArrayOf(10.0, 47.0, -0.16),
    doubleArrayOf(9.0, 42.0, -0.33),
    doubleArrayOf(8.0, 40.0, -0.51),
    doubleArrayOf(7.0, 35.0, -0.68),
    doubleArrayOf(6.0, 30.0, -0.85),
    doubleArrayOf(5.0, 25.0, -1.02),
    doubleArrayOf(4.0, 15.0, -1.19),
    doubleArrayOf(3.0, 10.0, -1.36),
    doubleArrayOf(2.0, 5.0, -1.53),
    doubleArrayOf(1.0, 1.0, -1.7),
)

/**
 * III.- Niveles de Adaptacion
 * A. Motivacion
 * Page 53
 */
private fun motivacionFragmentE3M3Baremo() = arrayOf(
    doubleArrayOf(0.0, 99.0, 1.54),
    doubleArrayOf(1.0, 98.0, 1.32),
    doubleArrayOf(2.0, 95.0, 1.1),
    doubleArrayOf(3.0, 90.0, 0.88),
    doubleArrayOf(4.0, 85.0, 0.66),
    doubleArrayOf(5.0, 75.0, 0.43),
    doubleArrayOf(6.0, 65.0, 0.21),
    doubleArrayOf(7.0, 55.0, -0.01),
    doubleArrayOf(8.0, 50.0, -0.23),
    doubleArrayOf(9.0, 45.0, -0.46),
    doubleArrayOf(10.0, 42.0, -0.68),
    doubleArrayOf(12.0, 40.0, -1.12),
    doubleArrayOf(14.0, 35.0, -1.57),
    doubleArrayOf(16.0, 30.0, -2.01),
    doubleArrayOf(18.0, 25.0, -2.46),
    doubleArrayOf(20.0, 20.0, -2.9),
    doubleArrayOf(22.0, 15.0, -3.34),
    doubleArrayOf(24.0, 10.0, -3.79),
    doubleArrayOf(26.0, 7.0, -4.23),
    doubleArrayOf(28.0, 5.0, -4.68),
    doubleArrayOf(30.0, 1.0, -5.12),
)

/**
 * III.- Niveles de Adaptacion
 * B. AutoControl
 * Page 53
 */
private fun autoControlFragmentE3M3Baremo() = arrayOf(
    doubleArrayOf(0.0, 99.0, 1.15),
    doubleArrayOf(1.0, 85.0, 0.87),
    doubleArrayOf(2.0, 75.0, 0.58),
    doubleArrayOf(3.0, 60.0, 0.29),
    doubleArrayOf(4.0, 55.0, 0.01),
    doubleArrayOf(5.0, 50.0, -0.28),
    doubleArrayOf(6.0, 47.0, -0.57),
    doubleArrayOf(7.0, 42.0, -0.85),
    doubleArrayOf(8.0, 40.0, -1.14),
    doubleArrayOf(9.0, 35.0, -1.43),
    doubleArrayOf(10.0, 25.0, -1.71),
    doubleArrayOf(12.0, 15.0, -2.29),
    doubleArrayOf(14.0, 10.0, -2.86),
    doubleArrayOf(16.0, 7.0, -3.43),
    doubleArrayOf(18.0, 5.0, -4.01),
    doubleArrayOf(20.0, 1.0, -4.58),
)

/**
 * III.- Niveles de Adaptacion
 * C. Conducta Pro Social
 * Page 53
 */
private fun conductaProSocialFragmentE3M3Baremo() = arrayOf(
    doubleArrayOf(0.0, 95.0, 1.07),
    doubleArrayOf(1.0, 80.0, 0.72),
    doubleArrayOf(2.0, 70.0, 0.37),
    doubleArrayOf(3.0, 60.0, 0.02),
    doubleArrayOf(4.0, 55.0, -0.32),
    doubleArrayOf(5.0, 50.0, -0.67),
    doubleArrayOf(6.0, 45.0, -1.02),
    doubleArrayOf(7.0, 40.0, -1.37),
    doubleArrayOf(8.0, 35.0, -1.72),
    doubleArrayOf(9.0, 30.0, -2.07),
    doubleArrayOf(10.0, 25.0, -2.41),
    doubleArrayOf(12.0, 15.0, -3.11),
    doubleArrayOf(14.0, 10.0, -3.81),
    doubleArrayOf(16.0, 7.0, -4.51),
    doubleArrayOf(18.0, 5.0, -5.2),
    doubleArrayOf(20.0, 1.0, -5.9),
)

/**
 * III.- Niveles de Adaptacion
 * D. AutoEstima
 * Page 53
 */
private fun autoEstimaFragmentE3M3Baremo() = arrayOf(
    doubleArrayOf(0.0, 99.0, 1.57),
    doubleArrayOf(1.0, 95.0, 1.27),
    doubleArrayOf(2.0, 90.0, 0.98),
    doubleArrayOf(3.0, 80.0, 0.69),
    doubleArrayOf(4.0, 70.0, 0.4),
    doubleArrayOf(5.0, 60.0, 0.11),
    doubleArrayOf(6.0, 55.0, -0.18),
    doubleArrayOf(7.0, 50.0, -0.48),
    doubleArrayOf(8.0, 45.0, -0.77),
    doubleArrayOf(9.0, 40.0, -1.06),
    doubleArrayOf(10.0, 35.0, -1.35),
    doubleArrayOf(12.0, 25.0, -1.93),
    doubleArrayOf(14.0, 15.0, -2.52),
    doubleArrayOf(16.0, 10.0, -3.1),
    doubleArrayOf(18.0, 5.0, -3.68),
    doubleArrayOf(20.0, 1.0, -4.27),
)

/**
 * IV. Lectura
 * A. Comprension Lectora
 * Page 61
 */
private fun comprensionLectoraE3M4Baremo() = arrayOf(
    doubleArrayOf(30.0, 99.0, 3.58),
    doubleArrayOf(29.0, 98.0, 3.37),
    doubleArrayOf(28.0, 97.0, 3.16),
    doubleArrayOf(27.0, 96.0, 2.95),
    doubleArrayOf(26.0, 95.0, 2.75),
    doubleArrayOf(25.0, 93.0, 2.54),
    doubleArrayOf(24.0, 92.0, 2.33),
    doubleArrayOf(23.0, 91.0, 2.13),
    doubleArrayOf(22.0, 90.0, 1.92),
    doubleArrayOf(21.0, 87.0, 1.71),
    doubleArrayOf(20.0, 85.0, 1.51),
    doubleArrayOf(19.0, 82.0, 1.3),
    doubleArrayOf(18.0, 80.0, 1.09),
    doubleArrayOf(17.0, 75.0, 0.88),
    doubleArrayOf(16.0, 70.0, 0.68),
    doubleArrayOf(15.0, 60.0, 0.47),
    doubleArrayOf(14.0, 55.0, 0.26),
    doubleArrayOf(13.0, 50.0, 0.06),
    doubleArrayOf(12.0, 40.0, -0.15),
    doubleArrayOf(11.0, 35.0, -0.36),
    doubleArrayOf(10.0, 30.0, -0.57),
    doubleArrayOf(9.0, 25.0, -0.77),
    doubleArrayOf(8.0, 20.0, -0.98),
    doubleArrayOf(7.0, 15.0, -1.19),
    doubleArrayOf(6.0, 12.0, -1.39),
    doubleArrayOf(5.0, 10.0, -1.6),
    doubleArrayOf(4.0, 7.0, -1.81),
    doubleArrayOf(3.0, 5.0, -2.01),
    doubleArrayOf(2.0, 3.0, -2.22),
    doubleArrayOf(1.0, 1.0, -2.43),
)

/**
 * IV. Lectura
 * B. Exactitud Lectora
 * Page 67
 */
private fun exactitudLectoraE3M4Baremo() = arrayOf(
    doubleArrayOf(44.0, 99.0, 1.87),
    doubleArrayOf(43.0, 98.0, 1.69),
    doubleArrayOf(42.0, 97.0, 1.51),
    doubleArrayOf(41.0, 95.0, 1.32),
    doubleArrayOf(40.0, 90.0, 1.14),
    doubleArrayOf(39.0, 85.0, 0.96),
    doubleArrayOf(38.0, 80.0, 0.78),
    doubleArrayOf(37.0, 75.0, 0.6),
    doubleArrayOf(36.0, 65.0, 0.42),
    doubleArrayOf(35.0, 60.0, 0.24),
    doubleArrayOf(34.0, 55.0, 0.06),
    doubleArrayOf(33.0, 50.0, -0.12),
    doubleArrayOf(32.0, 45.0, -0.3),
    doubleArrayOf(31.0, 40.0, -0.48),
    doubleArrayOf(30.0, 35.0, -0.66),
    doubleArrayOf(29.0, 30.0, -0.84),
    doubleArrayOf(28.0, 25.0, -1.02),
    doubleArrayOf(27.0, 20.0, -1.2),
    doubleArrayOf(26.0, 15.0, -1.38),
    doubleArrayOf(25.0, 12.0, -1.56),
    doubleArrayOf(24.0, 10.0, -1.74),
    doubleArrayOf(23.0, 7.0, -1.92),
    doubleArrayOf(22.0, 5.0, -2.1),
    doubleArrayOf(21.0, 3.0, -2.29),
    doubleArrayOf(20.0, 2.0, -2.47),
    doubleArrayOf(19.0, 1.0, -2.65),
)

/**
 * V. Escritura
 * A. Ortografia Fonectica
 * Page 75
 */
private fun ortografiaFoneticaE3M5Baremo() = arrayOf(
    doubleArrayOf(79.0, 99.0, 1.68),
    doubleArrayOf(78.0, 97.0, 1.53),
    doubleArrayOf(77.0, 95.0, 1.39),
    doubleArrayOf(76.0, 90.0, 1.24),
    doubleArrayOf(75.0, 85.0, 1.1),
    doubleArrayOf(74.0, 80.0, 0.95),
    doubleArrayOf(73.0, 75.0, 0.8),
    doubleArrayOf(72.0, 70.0, 0.66),
    doubleArrayOf(71.0, 67.0, 0.51),
    doubleArrayOf(70.0, 62.0, 0.36),
    doubleArrayOf(69.0, 60.0, 0.22),
    doubleArrayOf(68.0, 55.0, 0.07),
    doubleArrayOf(67.0, 50.0, -0.07),
    doubleArrayOf(66.0, 40.0, -0.22),
    doubleArrayOf(65.0, 35.0, -0.37),
    doubleArrayOf(64.0, 30.0, -0.51),
    doubleArrayOf(63.0, 25.0, -0.66),
    doubleArrayOf(62.0, 20.0, -0.81),
    doubleArrayOf(61.0, 15.0, -0.95),
    doubleArrayOf(60.0, 12.0, -1.1),
    doubleArrayOf(59.0, 10.0, -1.24),
    doubleArrayOf(58.0, 9.0, -1.39),
    doubleArrayOf(57.0, 8.0, -1.54),
    doubleArrayOf(56.0, 7.0, -1.68),
    doubleArrayOf(55.0, 6.0, -1.83),
    doubleArrayOf(54.0, 5.0, -1.98),
    doubleArrayOf(53.0, 3.0, -2.12),
    doubleArrayOf(52.0, 1.0, -2.27),
)

/**
 * V. Escritura
 * C. Ortografia Visual Reglada
 * Page 83
 */
private fun ortografiaVisualRegladaE3M5Baremo() = arrayOf(
    doubleArrayOf(67.0, 99.0, 2.76),
    doubleArrayOf(65.0, 97.0, 2.55),
    doubleArrayOf(63.0, 95.0, 2.35),
    doubleArrayOf(61.0, 94.0, 2.15),
    doubleArrayOf(59.0, 92.0, 1.94),
    doubleArrayOf(57.0, 90.0, 1.74),
    doubleArrayOf(55.0, 85.0, 1.54),
    doubleArrayOf(53.0, 80.0, 1.33),
    doubleArrayOf(51.0, 75.0, 1.13),
    doubleArrayOf(49.0, 70.0, 0.93),
    doubleArrayOf(47.0, 65.0, 0.72),
    doubleArrayOf(45.0, 60.0, 0.52),
    doubleArrayOf(43.0, 55.0, 0.32),
    doubleArrayOf(41.0, 50.0, 0.11),
    doubleArrayOf(39.0, 45.0, -0.09),
    doubleArrayOf(37.0, 40.0, -0.29),
    doubleArrayOf(35.0, 35.0, -0.5),
    doubleArrayOf(33.0, 30.0, -0.7),
    doubleArrayOf(31.0, 25.0, -0.9),
    doubleArrayOf(29.0, 20.0, -1.11),
    doubleArrayOf(27.0, 15.0, -1.31),
    doubleArrayOf(25.0, 12.0, -1.51),
    doubleArrayOf(23.0, 10.0, -1.72),
    doubleArrayOf(21.0, 7.0, -1.92),
    doubleArrayOf(19.0, 5.0, -2.12),
    doubleArrayOf(17.0, 3.0, -2.33),
    doubleArrayOf(15.0, 1.0, -2.53),
)

/**
 * VI. Aprendizajes Matematicos
 * A. Calculo y Numeracion
 * Page 91
 */
private fun calculoNumeracionE3M6Baremo() = arrayOf(
    doubleArrayOf(34.0, 99.0, 2.22),
    doubleArrayOf(33.0, 98.0, 2.07),
    doubleArrayOf(32.0, 97.0, 1.91),
    doubleArrayOf(31.0, 95.0, 1.76),
    doubleArrayOf(30.0, 92.0, 1.61),
    doubleArrayOf(29.0, 87.0, 1.45),
    doubleArrayOf(28.0, 85.0, 1.3),
    doubleArrayOf(27.0, 82.0, 1.14),
    doubleArrayOf(26.0, 77.0, 0.99),
    doubleArrayOf(25.0, 75.0, 0.84),
    doubleArrayOf(24.0, 70.0, 0.68),
    doubleArrayOf(23.0, 65.0, 0.53),
    doubleArrayOf(22.0, 60.0, 0.38),
    doubleArrayOf(21.0, 55.0, 0.22),
    doubleArrayOf(20.0, 50.0, 0.07),
    doubleArrayOf(19.0, 45.0, -0.09),
    doubleArrayOf(18.0, 42.0, -0.24),
    doubleArrayOf(17.0, 40.0, -0.39),
    doubleArrayOf(16.0, 35.0, -0.55),
    doubleArrayOf(15.0, 30.0, -0.7),
    doubleArrayOf(14.0, 25.0, -0.86),
    doubleArrayOf(13.0, 20.0, -1.01),
    doubleArrayOf(12.0, 15.0, -1.16),
    doubleArrayOf(11.0, 12.0, -1.32),
    doubleArrayOf(10.0, 10.0, -1.47),
    doubleArrayOf(9.0, 7.0, -1.62),
    doubleArrayOf(8.0, 5.0, -1.78),
    doubleArrayOf(7.0, 3.0, -1.93),
    doubleArrayOf(6.0, 1.0, -2.09),
)

/**
 * VI. Aprendizajes Matematicos
 * B. Resolucion y Problemas
 * Page 98
 */
private fun resolucionProblemasE3M6Baremo() = arrayOf(
    doubleArrayOf(31.0, 99.0, 2.09),
    doubleArrayOf(30.0, 98.0, 1.97),
    doubleArrayOf(29.0, 97.0, 1.84),
    doubleArrayOf(28.0, 96.0, 1.71),
    doubleArrayOf(27.0, 95.0, 1.58),
    doubleArrayOf(26.0, 92.0, 1.45),
    doubleArrayOf(25.0, 90.0, 1.32),
    doubleArrayOf(24.0, 85.0, 1.2),
    doubleArrayOf(23.0, 80.0, 1.07),
    doubleArrayOf(22.0, 75.0, 0.94),
    doubleArrayOf(21.0, 70.0, 0.81),
    doubleArrayOf(20.0, 67.0, 0.68),
    doubleArrayOf(19.0, 62.0, 0.55),
    doubleArrayOf(18.0, 60.0, 0.43),
    doubleArrayOf(17.0, 57.0, 0.3),
    doubleArrayOf(16.0, 55.0, 0.17),
    doubleArrayOf(15.0, 50.0, 0.04),
    doubleArrayOf(14.0, 45.0, -0.09),
    doubleArrayOf(13.0, 42.0, -0.22),
    doubleArrayOf(12.0, 40.0, -0.34),
    doubleArrayOf(11.0, 35.0, -0.47),
    doubleArrayOf(10.0, 30.0, -0.6),
    doubleArrayOf(9.0, 25.0, -0.73),
    doubleArrayOf(8.0, 20.0, -0.86),
    doubleArrayOf(7.0, 15.0, -0.99),
    doubleArrayOf(6.0, 10.0, -1.11),
    doubleArrayOf(5.0, 7.0, -1.24),
    doubleArrayOf(4.0, 5.0, -1.37),
    doubleArrayOf(3.0, 1.0, -1.5),
)
