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
import cl.figonzal.evaluatool.domain.baremo_tables.constants.Evalua2Constants
import cl.figonzal.evaluatool.domain.baremo_tables.constants.Evalua2Constants.AUTO_CONTROL_FRAGMENT_E2M3
import cl.figonzal.evaluatool.domain.baremo_tables.constants.Evalua2Constants.AUTO_ESTIMA_FRAGMENT_E2M3
import cl.figonzal.evaluatool.domain.baremo_tables.constants.Evalua2Constants.CALCULO_NUMERACION_E2M6
import cl.figonzal.evaluatool.domain.baremo_tables.constants.Evalua2Constants.CLASIFICACIONES_E2M1
import cl.figonzal.evaluatool.domain.baremo_tables.constants.Evalua2Constants.COMPRENSION_LECTORA_E2M4
import cl.figonzal.evaluatool.domain.baremo_tables.constants.Evalua2Constants.CONDUCTA_PRO_SOCIAL_E2M3
import cl.figonzal.evaluatool.domain.baremo_tables.constants.Evalua2Constants.MEMORIA_ATENCION_E2M2
import cl.figonzal.evaluatool.domain.baremo_tables.constants.Evalua2Constants.MOTIVACION_FRAGMENT_E2M3
import cl.figonzal.evaluatool.domain.baremo_tables.constants.Evalua2Constants.ORGANIZACION_PERCEPTIVA_E2M1
import cl.figonzal.evaluatool.domain.baremo_tables.constants.Evalua2Constants.ORTOGRAFIA_E2M5
import cl.figonzal.evaluatool.domain.baremo_tables.constants.Evalua2Constants.PENSAMIENTO_ANALOGICO_E2M1
import cl.figonzal.evaluatool.domain.baremo_tables.constants.Evalua2Constants.RESOLUCION_PROBLEMAS_E2M6

/**
 * Evalua 2
 */
class Evalua2Baremo : BaremoTable {

    override fun getBaremo(baremo: BaseConstants) = when (baremo as Evalua2Constants) {

        PENSAMIENTO_ANALOGICO_E2M1 -> pensamientoAnalogicoE2M1Baremo()
        ORGANIZACION_PERCEPTIVA_E2M1 -> organizacionPerceptivaE2M1Baremo()
        CLASIFICACIONES_E2M1 -> clasificacionesE2M1Baremo()

        MEMORIA_ATENCION_E2M2 -> memoriaAtencionE2M2Baremo()

        MOTIVACION_FRAGMENT_E2M3 -> motivacionFragmentE2M3Baremo()
        AUTO_CONTROL_FRAGMENT_E2M3 -> autoControlFragmentE2M3Baremo()
        CONDUCTA_PRO_SOCIAL_E2M3 -> conductaProSocialFragmentE2M3Baremo()
        AUTO_ESTIMA_FRAGMENT_E2M3 -> autoEstimaFragmentE2M3Baremo()

        COMPRENSION_LECTORA_E2M4 -> comprensionLectoraE2M4Baremo()

        ORTOGRAFIA_E2M5 -> ortografiaE2M5Baremo()

        CALCULO_NUMERACION_E2M6 -> calculoNumeracionE2M6Baremo()
        RESOLUCION_PROBLEMAS_E2M6 -> resolucionProblemasE2M6Baremo()
    }
}

/**
 * I.- Bases del razonamiento
 * A. Pensamiento Analogico
 * Page 27
 */
private fun pensamientoAnalogicoE2M1Baremo() = arrayOf(
    doubleArrayOf(20.0, 99.0, 1.41),
    doubleArrayOf(19.0, 90.0, 1.21),
    doubleArrayOf(18.0, 80.0, 1.02),
    doubleArrayOf(17.0, 75.0, 0.82),
    doubleArrayOf(16.0, 70.0, 0.63),
    doubleArrayOf(15.0, 65.0, 0.44),
    doubleArrayOf(14.0, 60.0, 0.24),
    doubleArrayOf(13.0, 55.0, 0.05),
    doubleArrayOf(12.0, 50.0, -0.15),
    doubleArrayOf(11.0, 40.0, -0.34),
    doubleArrayOf(10.0, 35.0, -0.53),
    doubleArrayOf(9.0, 30.0, -0.73),
    doubleArrayOf(8.0, 20.0, -0.92),
    doubleArrayOf(7.0, 15.0, -1.11),
    doubleArrayOf(6.0, 13.0, -1.31),
    doubleArrayOf(5.0, 10.0, -1.5),
    doubleArrayOf(4.0, 8.0, -1.7),
    doubleArrayOf(3.0, 7.0, -1.89),
    doubleArrayOf(2.0, 5.0, -2.08),
    doubleArrayOf(1.0, 3.0, -2.28),
    doubleArrayOf(0.0, 1.0, -2.47),
)

/**
 * I.- Bases del razonamiento
 * B. Organizacion Perceptiva
 * Page 37
 */
private fun organizacionPerceptivaE2M1Baremo() = arrayOf(
    doubleArrayOf(34.0, 95.0, 0.9),
    doubleArrayOf(33.0, 95.0, 0.78),
    doubleArrayOf(32.0, 85.0, 0.66),
    doubleArrayOf(31.0, 85.0, 0.53),
    doubleArrayOf(30.0, 75.0, 0.41),
    doubleArrayOf(29.0, 75.0, 0.29),
    doubleArrayOf(28.0, 60.0, 0.17),
    doubleArrayOf(27.0, 60.0, 0.04),
    doubleArrayOf(26.0, 50.0, -0.08),
    doubleArrayOf(25.0, 50.0, -0.2),
    doubleArrayOf(24.0, 40.0, -0.32),
    doubleArrayOf(23.0, 40.0, -0.45),
    doubleArrayOf(22.0, 35.0, -0.57),
    doubleArrayOf(21.0, 35.0, -0.69),
    doubleArrayOf(20.0, 25.0, -0.81),
    doubleArrayOf(19.0, 25.0, -0.94),
    doubleArrayOf(18.0, 20.0, -1.06),
    doubleArrayOf(17.0, 20.0, -1.18),
    doubleArrayOf(16.0, 15.0, -1.3),
    doubleArrayOf(15.0, 15.0, -1.42),
    doubleArrayOf(14.0, 13.0, -1.55),
    doubleArrayOf(13.0, 13.0, -1.67),
    doubleArrayOf(12.0, 12.0, -1.79),
    doubleArrayOf(11.0, 12.0, -1.91),
    doubleArrayOf(10.0, 10.0, -2.04),
    doubleArrayOf(9.0, 10.0, -2.16),
    doubleArrayOf(8.0, 7.0, -2.28),
    doubleArrayOf(7.0, 7.0, -2.4),
    doubleArrayOf(6.0, 5.0, -2.53),
    doubleArrayOf(5.0, 5.0, -2.65),
    doubleArrayOf(4.0, 3.0, -2.77),
    doubleArrayOf(3.0, 3.0, -2.89),
    doubleArrayOf(2.0, 2.0, -3.02),
    doubleArrayOf(1.0, 2.0, -3.14),
    doubleArrayOf(0.0, 1.0, -3.26),
)

/**
 * I.- Bases del razonamiento
 * C. Clasificaciones
 * Page 43
 */
private fun clasificacionesE2M1Baremo() = arrayOf(
    doubleArrayOf(29.0, 99.0, 1.41),
    doubleArrayOf(28.0, 98.0, 1.27),
    doubleArrayOf(27.0, 95.0, 1.12),
    doubleArrayOf(26.0, 90.0, 0.98),
    doubleArrayOf(25.0, 85.0, 0.84),
    doubleArrayOf(24.0, 75.0, 0.69),
    doubleArrayOf(23.0, 70.0, 0.55),
    doubleArrayOf(22.0, 60.0, 0.4),
    doubleArrayOf(21.0, 55.0, 0.26),
    doubleArrayOf(20.0, 50.0, 0.12),
    doubleArrayOf(19.0, 45.0, -0.03),
    doubleArrayOf(18.0, 40.0, -0.17),
    doubleArrayOf(17.0, 35.0, -0.31),
    doubleArrayOf(16.0, 30.0, -0.46),
    doubleArrayOf(15.0, 27.0, -0.6),
    doubleArrayOf(14.0, 25.0, -0.74),
    doubleArrayOf(13.0, 22.0, -0.89),
    doubleArrayOf(12.0, 20.0, -1.03),
    doubleArrayOf(11.0, 15.0, -1.17),
    doubleArrayOf(10.0, 12.0, -1.32),
    doubleArrayOf(9.0, 10.0, -1.46),
    doubleArrayOf(8.0, 7.0, -1.6),
    doubleArrayOf(7.0, 5.0, -1.75),
    doubleArrayOf(6.0, 3.0, -1.89),
)

/**
 * II.- Memoria y Atencion
 *
 * Page 51
 */
private fun memoriaAtencionE2M2Baremo() = arrayOf(
    doubleArrayOf(88.0, 99.0, 2.2),
    doubleArrayOf(87.0, 99.0, 2.12),
    doubleArrayOf(86.0, 99.0, 2.04),
    doubleArrayOf(85.0, 99.0, 1.97),
    doubleArrayOf(84.0, 99.0, 1.89),
    doubleArrayOf(83.0, 99.0, 1.81),
    doubleArrayOf(82.0, 99.0, 1.74),
    doubleArrayOf(81.0, 99.0, 1.66),
    doubleArrayOf(80.0, 95.0, 1.58),
    doubleArrayOf(79.0, 95.0, 1.51),
    doubleArrayOf(78.0, 95.0, 1.43),
    doubleArrayOf(77.0, 95.0, 1.35),
    doubleArrayOf(76.0, 95.0, 1.28),
    doubleArrayOf(75.0, 85.0, 1.2),
    doubleArrayOf(74.0, 85.0, 1.12),
    doubleArrayOf(73.0, 85.0, 1.05),
    doubleArrayOf(72.0, 85.0, 0.97),
    doubleArrayOf(71.0, 85.0, 0.89),
    doubleArrayOf(70.0, 75.0, 0.82),
    doubleArrayOf(69.0, 75.0, 0.74),
    doubleArrayOf(68.0, 75.0, 0.66),
    doubleArrayOf(67.0, 75.0, 0.59),
    doubleArrayOf(66.0, 75.0, 0.51),
    doubleArrayOf(65.0, 65.0, 0.43),
    doubleArrayOf(64.0, 65.0, 0.36),
    doubleArrayOf(63.0, 65.0, 0.28),
    doubleArrayOf(62.0, 65.0, 0.2),
    doubleArrayOf(61.0, 65.0, 0.13),
    doubleArrayOf(60.0, 50.0, 0.05),
    doubleArrayOf(59.0, 50.0, -0.03),
    doubleArrayOf(58.0, 50.0, -0.1),
    doubleArrayOf(57.0, 50.0, -0.18),
    doubleArrayOf(56.0, 50.0, -0.26),
    doubleArrayOf(55.0, 45.0, -0.33),
    doubleArrayOf(54.0, 45.0, -0.41),
    doubleArrayOf(53.0, 45.0, -0.49),
    doubleArrayOf(52.0, 45.0, -0.56),
    doubleArrayOf(51.0, 45.0, -0.64),
    doubleArrayOf(50.0, 35.0, -0.72),
    doubleArrayOf(49.0, 35.0, -0.79),
    doubleArrayOf(48.0, 35.0, -0.87),
    doubleArrayOf(47.0, 35.0, -0.95),
    doubleArrayOf(46.0, 35.0, -1.02),
    doubleArrayOf(45.0, 30.0, -1.1),
    doubleArrayOf(44.0, 30.0, -1.18),
    doubleArrayOf(43.0, 30.0, -1.25),
    doubleArrayOf(42.0, 30.0, -1.33),
    doubleArrayOf(41.0, 30.0, -1.41),
    doubleArrayOf(40.0, 20.0, -1.48),
    doubleArrayOf(39.0, 20.0, -1.56),
    doubleArrayOf(38.0, 20.0, -1.64),
    doubleArrayOf(37.0, 20.0, -1.71),
    doubleArrayOf(36.0, 20.0, -1.79),
    doubleArrayOf(35.0, 15.0, -1.87),
    doubleArrayOf(34.0, 15.0, -1.94),
    doubleArrayOf(33.0, 15.0, -2.02),
    doubleArrayOf(32.0, 15.0, -2.1),
    doubleArrayOf(31.0, 15.0, -2.17),
    doubleArrayOf(30.0, 10.0, -2.25),
    doubleArrayOf(29.0, 10.0, -2.33),
    doubleArrayOf(27.0, 10.0, -2.48),
    doubleArrayOf(26.0, 10.0, -2.56),
    doubleArrayOf(25.0, 7.0, -2.63),
    doubleArrayOf(24.0, 7.0, -2.71),
    doubleArrayOf(23.0, 7.0, -2.79),
    doubleArrayOf(22.0, 7.0, -2.86),
    doubleArrayOf(21.0, 7.0, -2.94),
    doubleArrayOf(20.0, 5.0, -3.02),
    doubleArrayOf(19.0, 5.0, -3.09),
    doubleArrayOf(18.0, 5.0, -3.17),
    doubleArrayOf(17.0, 5.0, -3.25),
    doubleArrayOf(16.0, 5.0, -3.32),
    doubleArrayOf(15.0, 3.0, -3.4),
    doubleArrayOf(14.0, 3.0, -3.48),
    doubleArrayOf(13.0, 3.0, -3.55),
    doubleArrayOf(12.0, 3.0, -3.63),
    doubleArrayOf(11.0, 3.0, -3.71),
    doubleArrayOf(10.0, 1.0, -3.78),
    doubleArrayOf(9.0, 1.0, -3.86),
    doubleArrayOf(8.0, 1.0, -3.94),
    doubleArrayOf(7.0, 1.0, -4.01),
    doubleArrayOf(6.0, 1.0, -4.09),
)

/**
 * III. Niveles de adaptacion
 * A. Motivacion
 *
 * Page 57
 */
private fun motivacionFragmentE2M3Baremo() = arrayOf(
    doubleArrayOf(45.0, 99.0, 2.33),
    doubleArrayOf(44.0, 99.0, 2.11),
    doubleArrayOf(43.0, 99.0, 1.88),
    doubleArrayOf(42.0, 99.0, 1.66),
    doubleArrayOf(41.0, 99.0, 1.43),
    doubleArrayOf(40.0, 99.0, 1.2),
    doubleArrayOf(39.0, 90.0, 0.98),
    doubleArrayOf(38.0, 80.0, 0.75),
    doubleArrayOf(37.0, 70.0, 0.53),
    doubleArrayOf(35.0, 60.0, 0.08),
    doubleArrayOf(32.0, 50.0, -0.6),
    doubleArrayOf(30.0, 40.0, -1.05),
    doubleArrayOf(29.0, 30.0, -1.27),
    doubleArrayOf(27.0, 20.0, -1.72),
    doubleArrayOf(25.0, 10.0, -2.17),
    doubleArrayOf(22.0, 5.0, -2.85),
)

/**
 * III. Niveles de adaptacion
 * B. Autocontrol
 *
 * Page 57
 */
private fun autoControlFragmentE2M3Baremo() = arrayOf(
    doubleArrayOf(30.0, 99.0, 1.93),
    doubleArrayOf(28.0, 90.0, 1.37),
    doubleArrayOf(26.0, 80.0, 0.8),
    doubleArrayOf(25.0, 70.0, 0.52),
    doubleArrayOf(24.0, 60.0, 0.24),
    doubleArrayOf(23.0, 50.0, -0.05),
    doubleArrayOf(22.0, 40.0, -0.33),
    doubleArrayOf(20.0, 30.0, -0.9),
    doubleArrayOf(16.0, 20.0, -2.03),
    doubleArrayOf(14.0, 10.0, -2.6),
    doubleArrayOf(12.0, 5.0, -3.16),
)

/**
 * III. Niveles de adaptacion
 * C. Conducta ProSocial
 *
 * Page 57
 */
private fun conductaProSocialFragmentE2M3Baremo() = arrayOf(
    doubleArrayOf(30.0, 99.0, 1.05),
    doubleArrayOf(29.0, 90.0, 0.78),
    doubleArrayOf(28.0, 80.0, 0.51),
    doubleArrayOf(27.0, 70.0, 0.24),
    doubleArrayOf(26.0, 60.0, -0.03),
    doubleArrayOf(25.0, 50.0, -0.3),
    doubleArrayOf(24.0, 40.0, -0.57),
    doubleArrayOf(22.0, 30.0, -1.12),
    doubleArrayOf(21.0, 20.0, -1.39),
    doubleArrayOf(20.0, 10.0, -1.66),
    doubleArrayOf(15.0, 5.0, -3.01),
)

/**
 * III. Niveles de adaptacion
 * D. AutoEstima
 *
 * Page 57
 */
private fun autoEstimaFragmentE2M3Baremo() = arrayOf(
    doubleArrayOf(30.0, 99.0, 2.39),
    doubleArrayOf(29.0, 99.0, 2.04),
    doubleArrayOf(28.0, 99.0, 1.7),
    doubleArrayOf(27.0, 90.0, 1.36),
    doubleArrayOf(26.0, 80.0, 1.01),
    doubleArrayOf(25.0, 70.0, 0.67),
    doubleArrayOf(24.0, 60.0, 0.32),
    doubleArrayOf(22.0, 50.0, -0.37),
    doubleArrayOf(20.0, 40.0, -1.06),
    doubleArrayOf(19.0, 30.0, -1.4),
    doubleArrayOf(17.0, 20.0, -2.09),
    doubleArrayOf(15.0, 10.0, -2.78),
    doubleArrayOf(10.0, 5.0, -4.51)
)

/**
 * IV. Lectura
 * A. Compresion Lectora
 *
 * Page 61
 */
private fun comprensionLectoraE2M4Baremo() = arrayOf(
    doubleArrayOf(25.0, 99.0, 2.24),
    doubleArrayOf(24.0, 98.0, 2.07),
    doubleArrayOf(23.0, 97.0, 1.89),
    doubleArrayOf(22.0, 96.0, 1.71),
    doubleArrayOf(21.0, 95.0, 1.54),
    doubleArrayOf(20.0, 93.0, 1.36),
    doubleArrayOf(19.0, 92.0, 1.18),
    doubleArrayOf(18.0, 90.0, 1.01),
    doubleArrayOf(17.0, 85.0, 0.83),
    doubleArrayOf(16.0, 80.0, 0.66),
    doubleArrayOf(15.0, 70.0, 0.48),
    doubleArrayOf(14.0, 65.0, 0.3),
    doubleArrayOf(13.0, 60.0, 0.13),
    doubleArrayOf(12.0, 50.0, -0.05),
    doubleArrayOf(11.0, 45.0, -0.22),
    doubleArrayOf(10.0, 40.0, -0.4),
    doubleArrayOf(9.0, 35.0, -0.58),
    doubleArrayOf(8.0, 30.0, -0.75),
    doubleArrayOf(7.0, 25.0, -0.93),
    doubleArrayOf(6.0, 20.0, -1.1),
    doubleArrayOf(5.0, 15.0, -1.28),
    doubleArrayOf(4.0, 10.0, -1.46),
    doubleArrayOf(3.0, 7.0, -1.63),
    doubleArrayOf(2.0, 5.0, -1.81),
    doubleArrayOf(1.0, 1.0, -1.98),
)

/**
 * V. Escritura
 * B. Ortografia
 *
 * Page 77
 */
private fun ortografiaE2M5Baremo() = arrayOf(
    doubleArrayOf(43.0, 99.0, 1.22),
    doubleArrayOf(42.0, 95.0, 1.12),
    doubleArrayOf(41.0, 90.0, 1.01),
    doubleArrayOf(40.0, 85.0, 0.91),
    doubleArrayOf(38.0, 80.0, 0.7),
    doubleArrayOf(36.0, 75.0, 0.48),
    doubleArrayOf(35.0, 70.0, 0.38),
    doubleArrayOf(34.0, 65.0, 0.27),
    doubleArrayOf(33.0, 60.0, 0.17),
    doubleArrayOf(32.0, 55.0, 0.06),
    doubleArrayOf(31.0, 50.0, -0.04),
    doubleArrayOf(30.0, 45.0, -0.15),
    doubleArrayOf(29.0, 40.0, -0.26),
    doubleArrayOf(28.0, 35.0, -0.36),
    doubleArrayOf(27.0, 30.0, -0.47),
    doubleArrayOf(25.0, 25.0, -0.68),
    doubleArrayOf(22.0, 20.0, -1.0),
    doubleArrayOf(20.0, 15.0, -1.21),
    doubleArrayOf(18.0, 10.0, -1.42),
    doubleArrayOf(14.0, 5.0, -1.84),
    doubleArrayOf(13.0, 1.0, -1.95),
)

/**
 * VI. Aprendizajes Matematicos
 * A. Calculos y numeracion
 *
 * Page 83
 */
private fun calculoNumeracionE2M6Baremo() = arrayOf(
    doubleArrayOf(55.0, 99.0, 1.67),
    doubleArrayOf(53.0, 98.0, 1.5),
    doubleArrayOf(52.0, 97.0, 1.42),
    doubleArrayOf(51.0, 95.0, 1.33),
    doubleArrayOf(50.0, 92.0, 1.25),
    doubleArrayOf(49.0, 90.0, 1.16),
    doubleArrayOf(48.0, 85.0, 1.08),
    doubleArrayOf(47.0, 80.0, 0.99),
    doubleArrayOf(45.0, 75.0, 0.82),
    doubleArrayOf(43.0, 70.0, 0.66),
    doubleArrayOf(41.0, 65.0, 0.49),
    doubleArrayOf(39.0, 60.0, 0.32),
    doubleArrayOf(38.0, 55.0, 0.23),
    doubleArrayOf(36.0, 50.0, 0.06),
    doubleArrayOf(35.0, 45.0, -0.02),
    doubleArrayOf(33.0, 40.0, -0.19),
    doubleArrayOf(30.0, 35.0, -0.45),
    doubleArrayOf(25.0, 25.0, -0.87),
    doubleArrayOf(20.0, 20.0, -1.3),
    doubleArrayOf(10.0, 10.0, -2.15),
    doubleArrayOf(8.0, 5.0, -2.32),
    doubleArrayOf(3.0, 1.0, -2.74),
)

/**
 * VI. Aprendizajes Matematicos
 * B. Resolucion de Problemas
 *
 * Page 89
 */
private fun resolucionProblemasE2M6Baremo() = arrayOf(
    doubleArrayOf(14.0, 99.0, 1.66),
    doubleArrayOf(13.0, 95.0, 1.36),
    doubleArrayOf(12.0, 85.0, 1.07),
    doubleArrayOf(11.0, 75.0, 0.77),
    doubleArrayOf(10.0, 65.0, 0.48),
    doubleArrayOf(9.0, 55.0, 0.18),
    doubleArrayOf(8.0, 45.0, -0.12),
    doubleArrayOf(7.0, 35.0, -0.41),
    doubleArrayOf(6.0, 25.0, -0.71),
    doubleArrayOf(5.0, 20.0, -1.0),
    doubleArrayOf(4.0, 10.0, -1.3),
    doubleArrayOf(3.0, 5.0, -1.59),
    doubleArrayOf(2.0, 1.0, -1.89),
)



