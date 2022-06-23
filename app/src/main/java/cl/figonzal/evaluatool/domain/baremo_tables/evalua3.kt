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
 * Evalua 3
 */
class Evalua3Baremo : BaremoTable {

    override fun getBaremo(baremo: BaseConstants): Array<Array<Double>> {
        return emptyArray()
    }

    override fun getBaremo(baremo: String) = when (baremo) {
        "memo" -> memoriaAtencionE3M1Baremo()

        "reflex" -> reflexividadE3M2Baremo()
        "pensa" -> pensamientoAnalogicoE3M2Baremo()
        "orga" -> organizacionPerceptivaE3M2Baremo()

        "moti" -> motivacionFragmentE3M3Baremo()
        "auto" -> autoControlFragmentE3M3Baremo()
        "conduct" -> conductaProSocialFragmentE3M3Baremo()
        "esti" -> autoEstimaFragmentE3M3Baremo()

        "comp" -> comprensionLectoraE3M4Baremo()
        "exact" -> exactitudLectoraE3M4Baremo()

        "ortof" -> ortografiaFoneticaE3M5Baremo()
        "ortov" -> ortografiaVisualRegladaE3M5Baremo()

        "calc" -> calculoNumeracionE3M6Baremo()
        "reso" -> resolucionProblemasE3M6Baremo()

        else -> emptyArray()
    }
}

/**
 * I.- Memoria y Atencion
 *
 * Page 27
 */
private fun memoriaAtencionE3M1Baremo() = arrayOf(
    arrayOf(125.0, 99.0, 2.16),
    arrayOf(122.0, 97.0, 2.0),
    arrayOf(119.0, 95.0, 1.84),
    arrayOf(116.0, 93.0, 1.68),
    arrayOf(113.0, 90.0, 1.53),
    arrayOf(110.0, 87.0, 1.37),
    arrayOf(107.0, 85.0, 1.21),
    arrayOf(104.0, 80.0, 1.05),
    arrayOf(101.0, 75.0, 0.89),
    arrayOf(98.0, 70.0, 0.73),
    arrayOf(95.0, 67.0, 0.57),
    arrayOf(92.0, 62.0, 0.41),
    arrayOf(89.0, 60.0, 0.25),
    arrayOf(86.0, 55.0, 0.09),
    arrayOf(83.0, 50.0, -0.07),
    arrayOf(80.0, 45.0, -0.23),
    arrayOf(77.0, 42.0, -0.39),
    arrayOf(74.0, 40.0, -0.55),
    arrayOf(71.0, 35.0, -0.71),
    arrayOf(68.0, 30.0, -0.87),
    arrayOf(65.0, 25.0, -1.03),
    arrayOf(62.0, 20.0, -1.19),
    arrayOf(59.0, 17.0, -1.35),
    arrayOf(56.0, 15.0, -1.51),
    arrayOf(53.0, 12.0, -1.67),
    arrayOf(50.0, 10.0, -1.83),
    arrayOf(47.0, 7.0, -1.99),
    arrayOf(44.0, 5.0, -2.15),
    arrayOf(41.0, 3.0, -2.31)
)

/**
 * II.- Bases del razonamiento
 * A. Reflexividad
 * Page 33
 */
private fun reflexividadE3M2Baremo() = arrayOf(
    arrayOf(22.0, 99.0, 1.63),
    arrayOf(21.0, 95.0, 1.47),
    arrayOf(20.0, 90.0, 1.31),
    arrayOf(19.0, 87.0, 1.15),
    arrayOf(18.0, 85.0, 0.99),
    arrayOf(17.0, 80.0, 0.83),
    arrayOf(16.0, 75.0, 0.67),
    arrayOf(15.0, 70.0, 0.51),
    arrayOf(14.0, 65.0, 0.35),
    arrayOf(13.0, 60.0, 0.19),
    arrayOf(12.0, 55.0, 0.03),
    arrayOf(11.0, 50.0, -0.14),
    arrayOf(10.0, 47.0, -0.3),
    arrayOf(9.0, 42.0, -0.46),
    arrayOf(8.0, 40.0, -0.62),
    arrayOf(7.0, 35.0, -0.78),
    arrayOf(6.0, 30.0, -0.94),
    arrayOf(5.0, 25.0, -1.1),
    arrayOf(4.0, 15.0, -1.26),
    arrayOf(3.0, 10.0, -1.42),
    arrayOf(2.0, 5.0, -1.58),
    arrayOf(1.0, 1.0, -1.74),
)

/**
 * II.- Bases del razonamiento
 * B. Pensamiento Analogico
 * Page 39
 */
private fun pensamientoAnalogicoE3M2Baremo() = arrayOf(
    arrayOf(20.0, 99.0, 2.03),
    arrayOf(19.0, 97.0, 1.84),
    arrayOf(18.0, 95.0, 1.65),
    arrayOf(17.0, 92.0, 1.46),
    arrayOf(16.0, 87.0, 1.27),
    arrayOf(15.0, 80.0, 1.08),
    arrayOf(14.0, 75.0, 0.89),
    arrayOf(13.0, 70.0, 0.7),
    arrayOf(12.0, 65.0, 0.51),
    arrayOf(11.0, 60.0, 0.32),
    arrayOf(10.0, 55.0, 0.13),
    arrayOf(9.0, 50.0, -0.06),
    arrayOf(8.0, 45.0, -0.25),
    arrayOf(7.0, 40.0, -0.44),
    arrayOf(6.0, 35.0, -0.63),
    arrayOf(5.0, 30.0, -0.82),
    arrayOf(4.0, 25.0, -1.01),
    arrayOf(3.0, 15.0, -1.2),
    arrayOf(2.0, 10.0, -1.39),
    arrayOf(1.0, 5.0, -1.58),
)

/**
 * II.- Bases del razonamiento
 * C. Organizacion Perceptiva
 * Page 45
 */
private fun organizacionPerceptivaE3M2Baremo() = arrayOf(
    arrayOf(20.0, 99.0, 1.54),
    arrayOf(19.0, 95.0, 1.37),
    arrayOf(18.0, 90.0, 1.2),
    arrayOf(17.0, 80.0, 1.03),
    arrayOf(16.0, 75.0, 0.86),
    arrayOf(15.0, 70.0, 0.69),
    arrayOf(14.0, 65.0, 0.52),
    arrayOf(13.0, 60.0, 0.35),
    arrayOf(12.0, 55.0, 0.18),
    arrayOf(11.0, 50.0, 0.01),
    arrayOf(10.0, 47.0, -0.16),
    arrayOf(9.0, 42.0, -0.33),
    arrayOf(8.0, 40.0, -0.51),
    arrayOf(7.0, 35.0, -0.68),
    arrayOf(6.0, 30.0, -0.85),
    arrayOf(5.0, 25.0, -1.02),
    arrayOf(4.0, 15.0, -1.19),
    arrayOf(3.0, 10.0, -1.36),
    arrayOf(2.0, 5.0, -1.53),
    arrayOf(1.0, 1.0, -1.7),
)

/**
 * III.- Niveles de Adaptacion
 * A. Motivacion
 * Page 53
 */
private fun motivacionFragmentE3M3Baremo() = arrayOf(
    arrayOf(0.0, 99.0, 1.54),
    arrayOf(1.0, 98.0, 1.32),
    arrayOf(2.0, 95.0, 1.1),
    arrayOf(3.0, 90.0, 0.88),
    arrayOf(4.0, 85.0, 0.66),
    arrayOf(5.0, 75.0, 0.43),
    arrayOf(6.0, 65.0, 0.21),
    arrayOf(7.0, 55.0, -0.01),
    arrayOf(8.0, 50.0, -0.23),
    arrayOf(9.0, 45.0, -0.46),
    arrayOf(10.0, 42.0, -0.68),
    arrayOf(12.0, 40.0, -1.12),
    arrayOf(14.0, 35.0, -1.57),
    arrayOf(16.0, 30.0, -2.01),
    arrayOf(18.0, 25.0, -2.46),
    arrayOf(20.0, 20.0, -2.9),
    arrayOf(22.0, 15.0, -3.34),
    arrayOf(24.0, 10.0, -3.79),
    arrayOf(26.0, 7.0, -4.23),
    arrayOf(28.0, 5.0, -4.68),
    arrayOf(30.0, 1.0, -5.12),
)

/**
 * III.- Niveles de Adaptacion
 * B. AutoControl
 * Page 53
 */
private fun autoControlFragmentE3M3Baremo() = arrayOf(
    arrayOf(0.0, 99.0, 1.15),
    arrayOf(1.0, 85.0, 0.87),
    arrayOf(2.0, 75.0, 0.58),
    arrayOf(3.0, 60.0, 0.29),
    arrayOf(4.0, 55.0, 0.01),
    arrayOf(5.0, 50.0, -0.28),
    arrayOf(6.0, 47.0, -0.57),
    arrayOf(7.0, 42.0, -0.85),
    arrayOf(8.0, 40.0, -1.14),
    arrayOf(9.0, 35.0, -1.43),
    arrayOf(10.0, 25.0, -1.71),
    arrayOf(12.0, 15.0, -2.29),
    arrayOf(14.0, 10.0, -2.86),
    arrayOf(16.0, 7.0, -3.43),
    arrayOf(18.0, 5.0, -4.01),
    arrayOf(20.0, 1.0, -4.58),
)

/**
 * III.- Niveles de Adaptacion
 * C. Conducta Pro Social
 * Page 53
 */
private fun conductaProSocialFragmentE3M3Baremo() = arrayOf(
    arrayOf(0.0, 95.0, 1.07),
    arrayOf(1.0, 80.0, 0.72),
    arrayOf(2.0, 70.0, 0.37),
    arrayOf(3.0, 60.0, 0.02),
    arrayOf(4.0, 55.0, -0.32),
    arrayOf(5.0, 50.0, -0.67),
    arrayOf(6.0, 45.0, -1.02),
    arrayOf(7.0, 40.0, -1.37),
    arrayOf(8.0, 35.0, -1.72),
    arrayOf(9.0, 30.0, -2.07),
    arrayOf(10.0, 25.0, -2.41),
    arrayOf(12.0, 15.0, -3.11),
    arrayOf(14.0, 10.0, -3.81),
    arrayOf(16.0, 7.0, -4.51),
    arrayOf(18.0, 5.0, -5.2),
    arrayOf(20.0, 1.0, -5.9),
)

/**
 * III.- Niveles de Adaptacion
 * D. AutoEstima
 * Page 53
 */
private fun autoEstimaFragmentE3M3Baremo() = arrayOf(
    arrayOf(0.0, 99.0, 1.57),
    arrayOf(1.0, 95.0, 1.27),
    arrayOf(2.0, 90.0, 0.98),
    arrayOf(3.0, 80.0, 0.69),
    arrayOf(4.0, 70.0, 0.4),
    arrayOf(5.0, 60.0, 0.11),
    arrayOf(6.0, 55.0, -0.18),
    arrayOf(7.0, 50.0, -0.48),
    arrayOf(8.0, 45.0, -0.77),
    arrayOf(9.0, 40.0, -1.06),
    arrayOf(10.0, 35.0, -1.35),
    arrayOf(12.0, 25.0, -1.93),
    arrayOf(14.0, 15.0, -2.52),
    arrayOf(16.0, 10.0, -3.1),
    arrayOf(18.0, 5.0, -3.68),
    arrayOf(20.0, 1.0, -4.27),
)

/**
 * IV. Lectura
 * A. Comprension Lectora
 * Page 61
 */
private fun comprensionLectoraE3M4Baremo() = arrayOf(
    arrayOf(30.0, 99.0, 3.58),
    arrayOf(29.0, 98.0, 3.37),
    arrayOf(28.0, 97.0, 3.16),
    arrayOf(27.0, 96.0, 2.95),
    arrayOf(26.0, 95.0, 2.75),
    arrayOf(25.0, 93.0, 2.54),
    arrayOf(24.0, 92.0, 2.33),
    arrayOf(23.0, 91.0, 2.13),
    arrayOf(22.0, 90.0, 1.92),
    arrayOf(21.0, 87.0, 1.71),
    arrayOf(20.0, 85.0, 1.51),
    arrayOf(19.0, 82.0, 1.3),
    arrayOf(18.0, 80.0, 1.09),
    arrayOf(17.0, 75.0, 0.88),
    arrayOf(16.0, 70.0, 0.68),
    arrayOf(15.0, 60.0, 0.47),
    arrayOf(14.0, 55.0, 0.26),
    arrayOf(13.0, 50.0, 0.06),
    arrayOf(12.0, 40.0, -0.15),
    arrayOf(11.0, 35.0, -0.36),
    arrayOf(10.0, 30.0, -0.57),
    arrayOf(9.0, 25.0, -0.77),
    arrayOf(8.0, 20.0, -0.98),
    arrayOf(7.0, 15.0, -1.19),
    arrayOf(6.0, 12.0, -1.39),
    arrayOf(5.0, 10.0, -1.6),
    arrayOf(4.0, 7.0, -1.81),
    arrayOf(3.0, 5.0, -2.01),
    arrayOf(2.0, 3.0, -2.22),
    arrayOf(1.0, 1.0, -2.43),
)

/**
 * IV. Lectura
 * B. Exactitud Lectora
 * Page 67
 */
private fun exactitudLectoraE3M4Baremo() = arrayOf(
    arrayOf(44.0, 99.0, 1.87),
    arrayOf(43.0, 98.0, 1.69),
    arrayOf(42.0, 97.0, 1.51),
    arrayOf(41.0, 95.0, 1.32),
    arrayOf(40.0, 90.0, 1.14),
    arrayOf(39.0, 85.0, 0.96),
    arrayOf(38.0, 80.0, 0.78),
    arrayOf(37.0, 75.0, 0.6),
    arrayOf(36.0, 65.0, 0.42),
    arrayOf(35.0, 60.0, 0.24),
    arrayOf(34.0, 55.0, 0.06),
    arrayOf(33.0, 50.0, -0.12),
    arrayOf(32.0, 45.0, -0.3),
    arrayOf(31.0, 40.0, -0.48),
    arrayOf(30.0, 35.0, -0.66),
    arrayOf(29.0, 30.0, -0.84),
    arrayOf(28.0, 25.0, -1.02),
    arrayOf(27.0, 20.0, -1.2),
    arrayOf(26.0, 15.0, -1.38),
    arrayOf(25.0, 12.0, -1.56),
    arrayOf(24.0, 10.0, -1.74),
    arrayOf(23.0, 7.0, -1.92),
    arrayOf(22.0, 5.0, -2.1),
    arrayOf(21.0, 3.0, -2.29),
    arrayOf(20.0, 2.0, -2.47),
    arrayOf(19.0, 1.0, -2.65),
)

/**
 * V. Escritura
 * A. Ortografia Fonectica
 * Page 75
 */
private fun ortografiaFoneticaE3M5Baremo() = arrayOf(
    arrayOf(79.0, 99.0, 1.68),
    arrayOf(78.0, 97.0, 1.53),
    arrayOf(77.0, 95.0, 1.39),
    arrayOf(76.0, 90.0, 1.24),
    arrayOf(75.0, 85.0, 1.1),
    arrayOf(74.0, 80.0, 0.95),
    arrayOf(73.0, 75.0, 0.8),
    arrayOf(72.0, 70.0, 0.66),
    arrayOf(71.0, 67.0, 0.51),
    arrayOf(70.0, 62.0, 0.36),
    arrayOf(69.0, 60.0, 0.22),
    arrayOf(68.0, 55.0, 0.07),
    arrayOf(67.0, 50.0, -0.07),
    arrayOf(66.0, 40.0, -0.22),
    arrayOf(65.0, 35.0, -0.37),
    arrayOf(64.0, 30.0, -0.51),
    arrayOf(63.0, 25.0, -0.66),
    arrayOf(62.0, 20.0, -0.81),
    arrayOf(61.0, 15.0, -0.95),
    arrayOf(60.0, 12.0, -1.1),
    arrayOf(59.0, 10.0, -1.24),
    arrayOf(58.0, 9.0, -1.39),
    arrayOf(57.0, 8.0, -1.54),
    arrayOf(56.0, 7.0, -1.68),
    arrayOf(55.0, 6.0, -1.83),
    arrayOf(54.0, 5.0, -1.98),
    arrayOf(53.0, 3.0, -2.12),
    arrayOf(52.0, 1.0, -2.27),
)

/**
 * V. Escritura
 * C. Ortografia Visual Reglada
 * Page 83
 */
private fun ortografiaVisualRegladaE3M5Baremo() = arrayOf(
    arrayOf(67.0, 99.0, 2.76),
    arrayOf(65.0, 97.0, 2.55),
    arrayOf(63.0, 95.0, 2.35),
    arrayOf(61.0, 94.0, 2.15),
    arrayOf(59.0, 92.0, 1.94),
    arrayOf(57.0, 90.0, 1.74),
    arrayOf(55.0, 85.0, 1.54),
    arrayOf(53.0, 80.0, 1.33),
    arrayOf(51.0, 75.0, 1.13),
    arrayOf(49.0, 70.0, 0.93),
    arrayOf(47.0, 65.0, 0.72),
    arrayOf(45.0, 60.0, 0.52),
    arrayOf(43.0, 55.0, 0.32),
    arrayOf(41.0, 50.0, 0.11),
    arrayOf(39.0, 45.0, -0.09),
    arrayOf(37.0, 40.0, -0.29),
    arrayOf(35.0, 35.0, -0.5),
    arrayOf(33.0, 30.0, -0.7),
    arrayOf(31.0, 25.0, -0.9),
    arrayOf(29.0, 20.0, -1.11),
    arrayOf(27.0, 15.0, -1.31),
    arrayOf(25.0, 12.0, -1.51),
    arrayOf(23.0, 10.0, -1.72),
    arrayOf(21.0, 7.0, -1.92),
    arrayOf(19.0, 5.0, -2.12),
    arrayOf(17.0, 3.0, -2.33),
    arrayOf(15.0, 1.0, -2.53),
)

/**
 * VI. Aprendizajes Matematicos
 * A. Calculo y Numeracion
 * Page 91
 */
private fun calculoNumeracionE3M6Baremo() = arrayOf(
    arrayOf(34.0, 99.0, 2.22),
    arrayOf(33.0, 98.0, 2.07),
    arrayOf(32.0, 97.0, 1.91),
    arrayOf(31.0, 95.0, 1.76),
    arrayOf(30.0, 92.0, 1.61),
    arrayOf(29.0, 87.0, 1.45),
    arrayOf(28.0, 85.0, 1.3),
    arrayOf(27.0, 82.0, 1.14),
    arrayOf(26.0, 77.0, 0.99),
    arrayOf(25.0, 75.0, 0.84),
    arrayOf(24.0, 70.0, 0.68),
    arrayOf(23.0, 65.0, 0.53),
    arrayOf(22.0, 60.0, 0.38),
    arrayOf(21.0, 55.0, 0.22),
    arrayOf(20.0, 50.0, 0.07),
    arrayOf(19.0, 45.0, -0.09),
    arrayOf(18.0, 42.0, -0.24),
    arrayOf(17.0, 40.0, -0.39),
    arrayOf(16.0, 35.0, -0.55),
    arrayOf(15.0, 30.0, -0.7),
    arrayOf(14.0, 25.0, -0.86),
    arrayOf(13.0, 20.0, -1.01),
    arrayOf(12.0, 15.0, -1.16),
    arrayOf(11.0, 12.0, -1.32),
    arrayOf(10.0, 10.0, -1.47),
    arrayOf(9.0, 7.0, -1.62),
    arrayOf(8.0, 5.0, -1.78),
    arrayOf(7.0, 3.0, -1.93),
    arrayOf(6.0, 1.0, -2.09),
)

/**
 * VI. Aprendizajes Matematicos
 * B. Resolucion y Problemas
 * Page 98
 */
private fun resolucionProblemasE3M6Baremo() = arrayOf(
    arrayOf(31.0, 99.0, 2.09),
    arrayOf(30.0, 98.0, 1.97),
    arrayOf(29.0, 97.0, 1.84),
    arrayOf(28.0, 96.0, 1.71),
    arrayOf(27.0, 95.0, 1.58),
    arrayOf(26.0, 92.0, 1.45),
    arrayOf(25.0, 90.0, 1.32),
    arrayOf(24.0, 85.0, 1.2),
    arrayOf(23.0, 80.0, 1.07),
    arrayOf(22.0, 75.0, 0.94),
    arrayOf(21.0, 70.0, 0.81),
    arrayOf(20.0, 67.0, 0.68),
    arrayOf(19.0, 62.0, 0.55),
    arrayOf(18.0, 60.0, 0.43),
    arrayOf(17.0, 57.0, 0.3),
    arrayOf(16.0, 55.0, 0.17),
    arrayOf(15.0, 50.0, 0.04),
    arrayOf(14.0, 45.0, -0.09),
    arrayOf(13.0, 42.0, -0.22),
    arrayOf(12.0, 40.0, -0.34),
    arrayOf(11.0, 35.0, -0.47),
    arrayOf(10.0, 30.0, -0.6),
    arrayOf(9.0, 25.0, -0.73),
    arrayOf(8.0, 20.0, -0.86),
    arrayOf(7.0, 15.0, -0.99),
    arrayOf(6.0, 10.0, -1.11),
    arrayOf(5.0, 7.0, -1.24),
    arrayOf(4.0, 5.0, -1.37),
    arrayOf(3.0, 1.0, -1.5),
)
