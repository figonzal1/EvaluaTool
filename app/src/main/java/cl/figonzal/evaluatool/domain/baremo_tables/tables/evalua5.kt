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
import cl.figonzal.evaluatool.domain.baremo_tables.constants.Evalua5Constants
import cl.figonzal.evaluatool.domain.baremo_tables.constants.Evalua5Constants.AUTO_CONTROL_FRAGMENT_E5M3
import cl.figonzal.evaluatool.domain.baremo_tables.constants.Evalua5Constants.AUTO_ESTIMA_FRAGMENT_E5M3
import cl.figonzal.evaluatool.domain.baremo_tables.constants.Evalua5Constants.CALCULO_NUMERACION_E5M6
import cl.figonzal.evaluatool.domain.baremo_tables.constants.Evalua5Constants.COMPRENSION_LECTORA_E5M4
import cl.figonzal.evaluatool.domain.baremo_tables.constants.Evalua5Constants.COMPRESION_FRAGMENT_E5M4
import cl.figonzal.evaluatool.domain.baremo_tables.constants.Evalua5Constants.CONDUCTA_PRO_SOCIAL_E5M3
import cl.figonzal.evaluatool.domain.baremo_tables.constants.Evalua5Constants.EXACTITUD_LECTORA_E5M4
import cl.figonzal.evaluatool.domain.baremo_tables.constants.Evalua5Constants.MEMORIA_ATENCION_E5M1
import cl.figonzal.evaluatool.domain.baremo_tables.constants.Evalua5Constants.MOTIVACION_FRAGMENT_E5M3
import cl.figonzal.evaluatool.domain.baremo_tables.constants.Evalua5Constants.ORGANIZACION_PERCEPTIVA_E5M2
import cl.figonzal.evaluatool.domain.baremo_tables.constants.Evalua5Constants.ORTOGRAFIA_FONETICA_E5M5
import cl.figonzal.evaluatool.domain.baremo_tables.constants.Evalua5Constants.ORTOGRAFIA_VISUAL_E5M5
import cl.figonzal.evaluatool.domain.baremo_tables.constants.Evalua5Constants.PENSAMIENTO_ANALOGICO_E5M2
import cl.figonzal.evaluatool.domain.baremo_tables.constants.Evalua5Constants.REFLEXIVIDAD_E5M2
import cl.figonzal.evaluatool.domain.baremo_tables.constants.Evalua5Constants.RESOLUCION_PROBLEMAS_E5M6
import cl.figonzal.evaluatool.domain.baremo_tables.constants.Evalua5Constants.VELOCIDAD_FRAGMENT_E5M4

/**
 * Evalua 5
 */
class Evalua5Baremo : BaremoTable {

    override fun getBaremo(baremo: BaseConstants) = when (baremo as Evalua5Constants) {
        MEMORIA_ATENCION_E5M1 -> memoriaAtencionE5M1Baremo()

        REFLEXIVIDAD_E5M2 -> reflexividadE5M2Baremo()
        PENSAMIENTO_ANALOGICO_E5M2 -> pensamientoAnalogicoE5M2Baremo()
        ORGANIZACION_PERCEPTIVA_E5M2 -> organizacionPerceptivaE5M2Baremo()

        MOTIVACION_FRAGMENT_E5M3 -> motivacionFragmentE5M3Baremo()
        AUTO_CONTROL_FRAGMENT_E5M3 -> autoControlFragmentE5M3Baremo()
        CONDUCTA_PRO_SOCIAL_E5M3 -> conductaProsocialFragmentE5M3Baremo()
        AUTO_ESTIMA_FRAGMENT_E5M3 -> autoEstimaFragmentE5M3Baremo()

        COMPRENSION_LECTORA_E5M4 -> comprensionLectoraE5M4Baremo()
        COMPRESION_FRAGMENT_E5M4 -> comprensionFragmentE5M4Baremo()
        VELOCIDAD_FRAGMENT_E5M4 -> velocidadFragmentE5M4Baremo()
        EXACTITUD_LECTORA_E5M4 -> exactitudLectoraE5M4Baremo()

        ORTOGRAFIA_FONETICA_E5M5 -> ortografiaFoneticaE5M5Baremo()
        ORTOGRAFIA_VISUAL_E5M5 -> ortografiaVisualRegladaE5M5Baremo()

        CALCULO_NUMERACION_E5M6 -> calculoNumeracionE5M6Baremo()
        RESOLUCION_PROBLEMAS_E5M6 -> resolucionProblemasE5M6Baremo()
    }

}

/**
 * I.- Memoria y Atencion
 *
 * Page 27
 */
private fun memoriaAtencionE5M1Baremo() = arrayOf(
    doubleArrayOf(89.0, 99.0, 2.35),
    doubleArrayOf(82.0, 97.0, 1.89),
    doubleArrayOf(80.0, 95.0, 1.76),
    doubleArrayOf(78.0, 92.0, 1.63),
    doubleArrayOf(76.0, 90.0, 1.5),
    doubleArrayOf(74.0, 87.0, 1.37),
    doubleArrayOf(72.0, 85.0, 1.24),
    doubleArrayOf(70.0, 82.0, 1.11),
    doubleArrayOf(68.0, 80.0, 0.98),
    doubleArrayOf(66.0, 75.0, 0.85),
    doubleArrayOf(64.0, 70.0, 0.72),
    doubleArrayOf(62.0, 67.0, 0.59),
    doubleArrayOf(60.0, 62.0, 0.46),
    doubleArrayOf(58.0, 60.0, 0.33),
    doubleArrayOf(56.0, 55.0, 0.2),
    doubleArrayOf(54.0, 50.0, 0.07),
    doubleArrayOf(52.0, 47.0, -0.06),
    doubleArrayOf(50.0, 45.0, -0.19),
    doubleArrayOf(48.0, 42.0, -0.32),
    doubleArrayOf(46.0, 40.0, -0.45),
    doubleArrayOf(44.0, 35.0, -0.58),
    doubleArrayOf(42.0, 30.0, -0.71),
    doubleArrayOf(40.0, 27.0, -0.84),
    doubleArrayOf(38.0, 25.0, -0.97),
    doubleArrayOf(36.0, 20.0, -1.1),
    doubleArrayOf(34.0, 15.0, -1.23),
    doubleArrayOf(32.0, 10.0, -1.36),
    doubleArrayOf(30.0, 5.0, -1.49),
    doubleArrayOf(28.0, 3.0, -1.62),
    doubleArrayOf(26.0, 1.0, -1.75),
)

/**
 * II. Bases del Razonamiento
 * A. Reflexividad
 * Page 33
 */
private fun reflexividadE5M2Baremo() = arrayOf(
    doubleArrayOf(20.0, 99.0, 2.63),
    doubleArrayOf(19.0, 99.0, 2.41),
    doubleArrayOf(18.0, 99.0, 2.2),
    doubleArrayOf(17.0, 97.0, 1.98),
    doubleArrayOf(16.0, 97.0, 1.76),
    doubleArrayOf(15.0, 95.0, 1.54),
    doubleArrayOf(14.0, 90.0, 1.32),
    doubleArrayOf(13.0, 85.0, 1.11),
    doubleArrayOf(12.0, 80.0, 0.89),
    doubleArrayOf(11.0, 75.0, 0.67),
    doubleArrayOf(10.0, 70.0, 0.45),
    doubleArrayOf(9.0, 60.0, 0.24),
    doubleArrayOf(8.0, 50.0, 0.02),
    doubleArrayOf(7.0, 45.0, -0.2),
    doubleArrayOf(6.0, 40.0, -0.42),
    doubleArrayOf(5.0, 35.0, -0.64),
    doubleArrayOf(4.0, 25.0, -0.85),
    doubleArrayOf(3.0, 15.0, -1.07),
    doubleArrayOf(2.0, 10.0, -1.29),
    doubleArrayOf(1.0, 5.0, -1.51),
)

/**
 * II. Bases del Razonamiento
 * B. Pensamiento Analogico
 * Page 38
 */
private fun pensamientoAnalogicoE5M2Baremo() = arrayOf(
    doubleArrayOf(20.0, 99.0, 2.32),
    doubleArrayOf(19.0, 97.0, 2.1),
    doubleArrayOf(18.0, 95.0, 1.88),
    doubleArrayOf(17.0, 93.0, 1.66),
    doubleArrayOf(16.0, 90.0, 1.44),
    doubleArrayOf(15.0, 85.0, 1.22),
    doubleArrayOf(14.0, 80.0, 1.0),
    doubleArrayOf(13.0, 75.0, 0.78),
    doubleArrayOf(12.0, 65.0, 0.56),
    doubleArrayOf(11.0, 55.0, 0.34),
    doubleArrayOf(10.0, 50.0, 0.12),
    doubleArrayOf(9.0, 40.0, -0.1),
    doubleArrayOf(8.0, 30.0, -0.32),
    doubleArrayOf(7.0, 25.0, -0.54),
    doubleArrayOf(6.0, 20.0, -0.76),
    doubleArrayOf(5.0, 15.0, -0.98),
    doubleArrayOf(4.0, 10.0, -1.2),
    doubleArrayOf(3.0, 7.0, -1.42),
    doubleArrayOf(2.0, 5.0, -1.64),
    doubleArrayOf(1.0, 1.0, -1.86),
)

/**
 * II. Bases del Razonamiento
 * C. Organizacion Perceptiva
 * Page 45
 */
private fun organizacionPerceptivaE5M2Baremo() = arrayOf(
    doubleArrayOf(16.0, 99.0, 1.98),
    doubleArrayOf(15.0, 95.0, 1.73),
    doubleArrayOf(14.0, 90.0, 1.48),
    doubleArrayOf(13.0, 85.0, 1.23),
    doubleArrayOf(12.0, 80.0, 0.98),
    doubleArrayOf(11.0, 75.0, 0.73),
    doubleArrayOf(10.0, 65.0, 0.48),
    doubleArrayOf(9.0, 55.0, 0.23),
    doubleArrayOf(8.0, 50.0, -0.02),
    doubleArrayOf(7.0, 45.0, -0.27),
    doubleArrayOf(6.0, 40.0, -0.52),
    doubleArrayOf(5.0, 30.0, -0.77),
    doubleArrayOf(4.0, 20.0, -1.01),
    doubleArrayOf(3.0, 15.0, -1.26),
    doubleArrayOf(2.0, 10.0, -1.51),
    doubleArrayOf(1.0, 5.0, -1.76),
)

/**
 * III. Niveles de Adaptacion
 * A. Motivacion
 * Page 53
 */
private fun motivacionFragmentE5M3Baremo() = arrayOf(
    doubleArrayOf(0.0, 99.0, 1.59),
    doubleArrayOf(1.0, 95.0, 1.38),
    doubleArrayOf(2.0, 90.0, 1.16),
    doubleArrayOf(3.0, 85.0, 0.94),
    doubleArrayOf(4.0, 80.0, 0.72),
    doubleArrayOf(5.0, 75.0, 0.51),
    doubleArrayOf(6.0, 70.0, 0.29),
    doubleArrayOf(7.0, 60.0, 0.07),
    doubleArrayOf(8.0, 57.0, -0.14),
    doubleArrayOf(9.0, 55.0, -0.36),
    doubleArrayOf(10.0, 52.0, -0.58),
    doubleArrayOf(11.0, 47.0, -0.79),
    doubleArrayOf(12.0, 45.0, -1.01),
    doubleArrayOf(13.0, 42.0, -1.23),
    doubleArrayOf(14.0, 40.0, -1.44),
    doubleArrayOf(15.0, 30.0, -1.66),
    doubleArrayOf(16.0, 20.0, -1.88),
    doubleArrayOf(17.0, 15.0, -2.1),
    doubleArrayOf(18.0, 10.0, -2.31),
    doubleArrayOf(19.0, 5.0, -2.53),
    doubleArrayOf(20.0, 1.0, -2.75),
)

/**
 * III. Niveles de Adaptacion
 * B. AutoControl
 * Page 53
 */
private fun autoControlFragmentE5M3Baremo() = arrayOf(
    doubleArrayOf(0.0, 95.0, 1.23),
    doubleArrayOf(1.0, 90.0, 0.95),
    doubleArrayOf(2.0, 80.0, 0.66),
    doubleArrayOf(3.0, 70.0, 0.38),
    doubleArrayOf(4.0, 60.0, 0.09),
    doubleArrayOf(5.0, 55.0, -0.19),
    doubleArrayOf(6.0, 50.0, -0.48),
    doubleArrayOf(7.0, 47.0, -0.76),
    doubleArrayOf(8.0, 45.0, -1.05),
    doubleArrayOf(9.0, 40.0, -1.33),
    doubleArrayOf(10.0, 35.0, -1.62),
    doubleArrayOf(11.0, 20.0, -1.9),
    doubleArrayOf(12.0, 15.0, -2.19),
    doubleArrayOf(13.0, 10.0, -2.47),
    doubleArrayOf(14.0, 5.0, -2.75),
    doubleArrayOf(15.0, 1.0, -3.04),
)

/**
 * III. Niveles de Adaptacion
 * C. ConductaProSocial
 * Page 53
 */
private fun conductaProsocialFragmentE5M3Baremo() = arrayOf(
    doubleArrayOf(0.0, 90.0, 1.25),
    doubleArrayOf(1.0, 80.0, 0.9),
    doubleArrayOf(2.0, 70.0, 0.55),
    doubleArrayOf(3.0, 60.0, 0.2),
    doubleArrayOf(4.0, 55.0, -0.15),
    doubleArrayOf(5.0, 50.0, -0.5),
    doubleArrayOf(6.0, 45.0, -0.85),
    doubleArrayOf(7.0, 40.0, -1.2),
    doubleArrayOf(8.0, 35.0, -1.55),
    doubleArrayOf(9.0, 30.0, -1.9),
    doubleArrayOf(10.0, 25.0, -2.25),
    doubleArrayOf(11.0, 20.0, -2.6),
    doubleArrayOf(12.0, 15.0, -2.95),
    doubleArrayOf(13.0, 10.0, -3.3),
    doubleArrayOf(14.0, 5.0, -3.65),
    doubleArrayOf(15.0, 1.0, -4.0),
)

/**
 * III. Niveles de Adaptacion
 * D. AutoEstima
 * Page 53
 */
private fun autoEstimaFragmentE5M3Baremo() = arrayOf(
    doubleArrayOf(0.0, 98.0, 1.68),
    doubleArrayOf(1.0, 95.0, 1.4),
    doubleArrayOf(2.0, 90.0, 1.11),
    doubleArrayOf(3.0, 80.0, 0.82),
    doubleArrayOf(4.0, 75.0, 0.53),
    doubleArrayOf(5.0, 65.0, 0.25),
    doubleArrayOf(6.0, 55.0, -0.04),
    doubleArrayOf(7.0, 50.0, -0.33),
    doubleArrayOf(8.0, 45.0, -0.61),
    doubleArrayOf(9.0, 40.0, -0.9),
    doubleArrayOf(10.0, 35.0, -1.19),
    doubleArrayOf(11.0, 30.0, -1.48),
    doubleArrayOf(12.0, 20.0, -1.76),
    doubleArrayOf(13.0, 10.0, -2.05),
    doubleArrayOf(14.0, 5.0, -2.34),
    doubleArrayOf(15.0, 1.0, -2.63),
)

/**
 * IV. Lectura
 * A. Comprension Lectora
 * Page 61
 */
private fun comprensionLectoraE5M4Baremo() = arrayOf(
    doubleArrayOf(42.0, 99.0, 3.27),
    doubleArrayOf(40.0, 97.0, 2.99),
    doubleArrayOf(38.0, 95.0, 2.71),
    doubleArrayOf(36.0, 92.0, 2.43),
    doubleArrayOf(34.0, 90.0, 2.15),
    doubleArrayOf(32.0, 85.0, 1.87),
    doubleArrayOf(30.0, 82.0, 1.59),
    doubleArrayOf(28.0, 80.0, 1.31),
    doubleArrayOf(26.0, 75.0, 1.03),
    doubleArrayOf(24.0, 65.0, 0.75),
    doubleArrayOf(22.0, 60.0, 0.47),
    doubleArrayOf(20.0, 50.0, 0.19),
    doubleArrayOf(18.0, 45.0, -0.09),
    doubleArrayOf(16.0, 40.0, -0.37),
    doubleArrayOf(14.0, 35.0, -0.65),
    doubleArrayOf(12.0, 25.0, -0.93),
    doubleArrayOf(10.0, 20.0, -1.21),
    doubleArrayOf(8.0, 15.0, -1.49),
    doubleArrayOf(6.0, 10.0, -1.77),
    doubleArrayOf(4.0, 7.0, -2.05),
    doubleArrayOf(2.0, 5.0, -2.33),
    doubleArrayOf(0.0, 1.0, -2.61),
)

/**
 * IV. Lectura
 * B. Velocidad Lectora - ComprensionFragment
 * Page 61
 */
private fun comprensionFragmentE5M4Baremo() = arrayOf(
    doubleArrayOf(15.0, 99.0, 2.72),
    doubleArrayOf(14.0, 97.0, 2.45),
    doubleArrayOf(13.0, 95.0, 2.18),
    doubleArrayOf(12.0, 93.0, 1.91),
    doubleArrayOf(11.0, 90.0, 1.64),
    doubleArrayOf(10.0, 85.0, 1.37),
    doubleArrayOf(9.0, 80.0, 1.1),
    doubleArrayOf(8.0, 75.0, 0.83),
    doubleArrayOf(7.0, 70.0, 0.56),
    doubleArrayOf(6.0, 65.0, 0.29),
    doubleArrayOf(5.0, 55.0, 0.02),
    doubleArrayOf(4.0, 45.0, -0.25),
    doubleArrayOf(3.0, 40.0, -0.51),
    doubleArrayOf(2.0, 20.0, -0.78),
    doubleArrayOf(1.0, 10.0, -1.05),
    doubleArrayOf(0.0, 5.0, -1.32),
)

/**
 * IV. Lectura
 * B. Velocidad Lectora - VelocidadFragment
 * Page 61
 */
private fun velocidadFragmentE5M4Baremo() = arrayOf(
    doubleArrayOf(45.0, 99.0, 1.7),
    doubleArrayOf(50.0, 95.0, 1.52),
    doubleArrayOf(55.0, 90.0, 1.35),
    doubleArrayOf(60.0, 85.0, 1.17),
    doubleArrayOf(65.0, 75.0, 1.0),
    doubleArrayOf(70.0, 70.0, 0.82),
    doubleArrayOf(75.0, 65.0, 0.65),
    doubleArrayOf(80.0, 60.0, 0.48),
    doubleArrayOf(85.0, 55.0, 0.3),
    doubleArrayOf(90.0, 50.0, 0.13),
    doubleArrayOf(95.0, 45.0, -0.05),
    doubleArrayOf(100.0, 35.0, -0.22),
    doubleArrayOf(105.0, 30.0, -0.4),
    doubleArrayOf(110.0, 25.0, -0.57),
    doubleArrayOf(115.0, 20.0, -0.75),
    doubleArrayOf(120.0, 15.0, -0.92),
    doubleArrayOf(125.0, 13.0, -1.1),
    doubleArrayOf(130.0, 10.0, -1.27),
    doubleArrayOf(135.0, 7.0, -1.45),
    doubleArrayOf(140.0, 5.0, -1.62),
    doubleArrayOf(145.0, 3.0, -1.8),
    doubleArrayOf(150.0, 1.0, -1.97),
)

/**
 * IV. Lectura
 * C. Exactitud Lectora
 * Page 73
 */
private fun exactitudLectoraE5M4Baremo() = arrayOf(
    doubleArrayOf(44.0, 99.0, 1.15),
    doubleArrayOf(43.0, 95.0, 1.04),
    doubleArrayOf(42.0, 90.0, 0.93),
    doubleArrayOf(41.0, 80.0, 0.82),
    doubleArrayOf(40.0, 75.0, 0.71),
    doubleArrayOf(39.0, 70.0, 0.6),
    doubleArrayOf(38.0, 67.0, 0.49),
    doubleArrayOf(37.0, 63.0, 0.38),
    doubleArrayOf(36.0, 60.0, 0.27),
    doubleArrayOf(35.0, 55.0, 0.16),
    doubleArrayOf(34.0, 50.0, 0.05),
    doubleArrayOf(32.0, 40.0, -0.17),
    doubleArrayOf(30.0, 30.0, -0.39),
    doubleArrayOf(29.0, 25.0, -0.5),
    doubleArrayOf(27.0, 20.0, -0.72),
    doubleArrayOf(24.0, 15.0, -1.05),
    doubleArrayOf(22.0, 10.0, -1.27),
    doubleArrayOf(20.0, 7.0, -1.49),
    doubleArrayOf(17.0, 5.0, -1.82),
    doubleArrayOf(13.0, 1.0, -2.26),
)

/**
 * V. Escritura
 * A. Ortografia Fonetica
 * Page 81
 */
private fun ortografiaFoneticaE5M5Baremo() = arrayOf(
    doubleArrayOf(48.0, 99.0, 0.91),
    doubleArrayOf(47.0, 90.0, 0.78),
    doubleArrayOf(46.0, 80.0, 0.65),
    doubleArrayOf(45.0, 70.0, 0.52),
    doubleArrayOf(44.0, 60.0, 0.39),
    doubleArrayOf(43.0, 55.0, 0.26),
    doubleArrayOf(42.0, 50.0, 0.13),
    doubleArrayOf(41.0, 45.0, 0.0),
    doubleArrayOf(40.0, 40.0, -0.13),
    doubleArrayOf(39.0, 35.0, -0.27),
    doubleArrayOf(38.0, 30.0, -0.4),
    doubleArrayOf(37.0, 25.0, -0.53),
    doubleArrayOf(36.0, 20.0, -0.66),
    doubleArrayOf(35.0, 15.0, -0.79),
    doubleArrayOf(34.0, 10.0, -0.92),
    doubleArrayOf(33.0, 7.0, -1.05),
    doubleArrayOf(32.0, 5.0, -1.18),
    doubleArrayOf(31.0, 3.0, -1.31),
    doubleArrayOf(30.0, 1.0, -1.44),
)

/**
 * V. Escritura
 * C. Ortografia Visual y Reglada
 * Page 91
 */
private fun ortografiaVisualRegladaE5M5Baremo() = arrayOf(
    doubleArrayOf(91.0, 99.0, 4.2),
    doubleArrayOf(76.0, 98.0, 3.08),
    doubleArrayOf(73.0, 97.0, 2.86),
    doubleArrayOf(70.0, 96.0, 2.63),
    doubleArrayOf(67.0, 95.0, 2.41),
    doubleArrayOf(64.0, 94.0, 2.19),
    doubleArrayOf(61.0, 92.0, 1.97),
    doubleArrayOf(58.0, 90.0, 1.74),
    doubleArrayOf(55.0, 87.0, 1.52),
    doubleArrayOf(52.0, 85.0, 1.3),
    doubleArrayOf(49.0, 80.0, 1.07),
    doubleArrayOf(46.0, 75.0, 0.85),
    doubleArrayOf(43.0, 70.0, 0.63),
    doubleArrayOf(40.0, 60.0, 0.4),
    doubleArrayOf(37.0, 50.0, 0.18),
    doubleArrayOf(34.0, 45.0, -0.04),
    doubleArrayOf(31.0, 40.0, -0.27),
    doubleArrayOf(28.0, 35.0, -0.49),
    doubleArrayOf(25.0, 30.0, -0.71),
    doubleArrayOf(22.0, 25.0, -0.93),
    doubleArrayOf(19.0, 20.0, -1.16),
    doubleArrayOf(16.0, 15.0, -1.38),
    doubleArrayOf(13.0, 10.0, -1.6),
    doubleArrayOf(10.0, 5.0, -1.83),
    doubleArrayOf(7.0, 3.0, -2.05),
    doubleArrayOf(4.0, 1.0, -2.27),
)

/**
 * VI. Aprendizaje Matematico
 * A. Calculo y Numeracion
 * Page 99
 */
private fun calculoNumeracionE5M6Baremo() = arrayOf(
    doubleArrayOf(56.0, 99.0, 2.38),
    doubleArrayOf(53.0, 97.0, 2.11),
    doubleArrayOf(51.0, 96.0, 1.92),
    doubleArrayOf(49.0, 95.0, 1.74),
    doubleArrayOf(47.0, 94.0, 1.55),
    doubleArrayOf(45.0, 92.0, 1.37),
    doubleArrayOf(43.0, 90.0, 1.18),
    doubleArrayOf(41.0, 85.0, 1.0),
    doubleArrayOf(39.0, 80.0, 0.81),
    doubleArrayOf(37.0, 70.0, 0.63),
    doubleArrayOf(35.0, 65.0, 0.45),
    doubleArrayOf(33.0, 60.0, 0.26),
    doubleArrayOf(31.0, 50.0, 0.08),
    doubleArrayOf(29.0, 45.0, -0.11),
    doubleArrayOf(27.0, 40.0, -0.29),
    doubleArrayOf(25.0, 35.0, -0.48),
    doubleArrayOf(23.0, 30.0, -0.66),
    doubleArrayOf(21.0, 25.0, -0.84),
    doubleArrayOf(19.0, 20.0, -1.03),
    doubleArrayOf(17.0, 15.0, -1.21),
    doubleArrayOf(15.0, 12.0, -1.4),
    doubleArrayOf(13.0, 10.0, -1.58),
    doubleArrayOf(10.0, 7.0, -1.86),
    doubleArrayOf(7.0, 5.0, -2.13),
    doubleArrayOf(4.0, 3.0, -2.41),
    doubleArrayOf(3.0, 1.0, -2.5),
)

/**
 * VI. Aprendizaje Matematico
 * B. Resolucion de Problemas
 * Page 107
 */
private fun resolucionProblemasE5M6Baremo() = arrayOf(
    doubleArrayOf(51.0, 99.0, 3.08),
    doubleArrayOf(45.0, 98.0, 2.52),
    doubleArrayOf(42.0, 97.0, 2.24),
    doubleArrayOf(39.0, 96.0, 1.97),
    doubleArrayOf(36.0, 95.0, 1.69),
    doubleArrayOf(34.0, 94.0, 1.5),
    doubleArrayOf(33.0, 92.0, 1.41),
    doubleArrayOf(32.0, 90.0, 1.31),
    doubleArrayOf(31.0, 87.0, 1.22),
    doubleArrayOf(30.0, 85.0, 1.13),
    doubleArrayOf(29.0, 82.0, 1.04),
    doubleArrayOf(28.0, 80.0, 0.94),
    doubleArrayOf(27.0, 75.0, 0.85),
    doubleArrayOf(25.0, 70.0, 0.66),
    doubleArrayOf(23.0, 60.0, 0.48),
    doubleArrayOf(20.0, 55.0, 0.2),
    doubleArrayOf(17.0, 50.0, -0.08),
    doubleArrayOf(15.0, 45.0, -0.27),
    doubleArrayOf(12.0, 40.0, -0.55),
    doubleArrayOf(9.0, 35.0, -0.83),
    doubleArrayOf(6.0, 25.0, -1.1),
    doubleArrayOf(4.0, 20.0, -1.29),
    doubleArrayOf(3.0, 15.0, -1.38),
    doubleArrayOf(2.0, 10.0, -1.48),
    doubleArrayOf(1.0, 5.0, -1.57),
)
