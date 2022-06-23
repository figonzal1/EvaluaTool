/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2022

 Last modified 23-06-22 00:08
 */

package cl.figonzal.evaluatool.domain.baremo_tables

import cl.figonzal.evaluatool.domain.resolvers.BaremoTable

/**
 * Evalua 4
 */
class Evalua4Baremo : BaremoTable {
    override fun getBaremo(baremo: String) = when (baremo) {
        "memo" -> memoriaAtencionE4M1Baremo()

        "reflex" -> reflexividadE4M2Baremo()
        "pensa" -> pensamientoAnalogicoE4M2Baremo()
        "orga" -> organizacionPerceptivaE4M2Baremo()

        "moti" -> motivacionFragmentE4M3Baremo()
        "auto" -> autoControlFragmentE4M3Baremo()
        "conduct" -> conductaProSocialFragmentE4M3Baremo()
        "esti" -> autoEstimaFragmentE4M3Baremo()

        "compl" -> comprensionLectoraE4M4Baremo()
        "veloc" -> velocidadFragmentE4M4Baremo()
        "compf" -> comprensionFragmentE4M4Baremo()

        "orto" -> ortografiaVisualRegladaE4M5Baremo()

        "calc" -> calculoNumeracionE4M6Baremo()
        "resol" -> resolucionProblemasE4M6Baremo()

        else -> emptyArray()
    }
}

/**
 * I.- Memoria y Atencion
 *
 * Page 29
 */
private fun memoriaAtencionE4M1Baremo() = arrayOf(
    arrayOf(103.0, 99.0, 2.36),
    arrayOf(102.0, 99.0, 2.3),
    arrayOf(101.0, 99.0, 2.24),
    arrayOf(100.0, 99.0, 2.18),
    arrayOf(99.0, 99.0, 2.12),
    arrayOf(98.0, 99.0, 2.07),
    arrayOf(97.0, 99.0, 2.01),
    arrayOf(96.0, 99.0, 1.95),
    arrayOf(95.0, 99.0, 1.89),
    arrayOf(94.0, 95.0, 1.83),
    arrayOf(93.0, 95.0, 1.77),
    arrayOf(92.0, 95.0, 1.71),
    arrayOf(91.0, 95.0, 1.66),
    arrayOf(90.0, 95.0, 1.6),
    arrayOf(89.0, 90.0, 1.54),
    arrayOf(88.0, 90.0, 1.48),
    arrayOf(87.0, 90.0, 1.42),
    arrayOf(86.0, 90.0, 1.36),
    arrayOf(85.0, 90.0, 1.31),
    arrayOf(84.0, 85.0, 1.25),
    arrayOf(83.0, 85.0, 1.19),
    arrayOf(82.0, 85.0, 1.13),
    arrayOf(81.0, 85.0, 1.07),
    arrayOf(80.0, 85.0, 1.01),
    arrayOf(79.0, 80.0, 0.95),
    arrayOf(78.0, 80.0, 0.9),
    arrayOf(77.0, 80.0, 0.84),
    arrayOf(76.0, 80.0, 0.78),
    arrayOf(75.0, 80.0, 0.72),
    arrayOf(74.0, 70.0, 0.66),
    arrayOf(73.0, 70.0, 0.6),
    arrayOf(72.0, 70.0, 0.55),
    arrayOf(71.0, 70.0, 0.49),
    arrayOf(70.0, 70.0, 0.43),
    arrayOf(69.0, 60.0, 0.37),
    arrayOf(68.0, 60.0, 0.31),
    arrayOf(67.0, 60.0, 0.25),
    arrayOf(66.0, 60.0, 0.2),
    arrayOf(65.0, 60.0, 0.14),
    arrayOf(64.0, 50.0, 0.08),
    arrayOf(63.0, 50.0, 0.02),
    arrayOf(62.0, 50.0, -0.04),
    arrayOf(61.0, 50.0, -0.1),
    arrayOf(60.0, 50.0, -0.16),
    arrayOf(59.0, 40.0, -0.21),
    arrayOf(58.0, 40.0, -0.27),
    arrayOf(57.0, 40.0, -0.33),
    arrayOf(56.0, 40.0, -0.39),
    arrayOf(55.0, 40.0, -0.45),
    arrayOf(54.0, 30.0, -0.51),
    arrayOf(53.0, 30.0, -0.56),
    arrayOf(52.0, 30.0, -0.62),
    arrayOf(51.0, 30.0, -0.68),
    arrayOf(50.0, 30.0, -0.74),
    arrayOf(49.0, 20.0, -0.8),
    arrayOf(48.0, 20.0, -0.86),
    arrayOf(47.0, 20.0, -0.92),
    arrayOf(46.0, 20.0, -0.97),
    arrayOf(45.0, 20.0, -1.03),
    arrayOf(44.0, 15.0, -1.09),
    arrayOf(43.0, 15.0, -1.15),
    arrayOf(42.0, 15.0, -1.21),
    arrayOf(41.0, 15.0, -1.27),
    arrayOf(40.0, 15.0, -1.32),
    arrayOf(39.0, 12.0, -1.38),
    arrayOf(38.0, 12.0, -1.44),
    arrayOf(37.0, 12.0, -1.5),
    arrayOf(36.0, 12.0, -1.56),
    arrayOf(35.0, 12.0, -1.62),
    arrayOf(34.0, 10.0, -1.68),
    arrayOf(33.0, 10.0, -1.73),
    arrayOf(32.0, 10.0, -1.79),
    arrayOf(31.0, 10.0, -1.85),
    arrayOf(30.0, 10.0, -1.91),
    arrayOf(29.0, 7.0, -1.97),
    arrayOf(28.0, 7.0, -2.03),
    arrayOf(27.0, 7.0, -2.08),
    arrayOf(26.0, 7.0, -2.14),
    arrayOf(25.0, 7.0, -2.2),
    arrayOf(24.0, 5.0, -2.26),
    arrayOf(23.0, 5.0, -2.32),
    arrayOf(22.0, 5.0, -2.38),
    arrayOf(21.0, 5.0, -2.43),
    arrayOf(20.0, 5.0, -2.49),
    arrayOf(19.0, 3.0, -2.55),
    arrayOf(18.0, 3.0, -2.61),
    arrayOf(17.0, 3.0, -2.67),
    arrayOf(16.0, 3.0, -2.73),
    arrayOf(15.0, 3.0, -2.79),
    arrayOf(14.0, 2.0, -2.84),
    arrayOf(13.0, 2.0, -2.9),
    arrayOf(12.0, 2.0, -2.96),
    arrayOf(11.0, 2.0, -3.02),
    arrayOf(10.0, 2.0, -3.08),
    arrayOf(9.0, 1.0, -3.14),
    arrayOf(8.0, 1.0, -3.19),
    arrayOf(7.0, 1.0, -3.25),
    arrayOf(6.0, 1.0, -3.31),
    arrayOf(5.0, 1.0, -3.37),
)

/**
 * II.- Memoria y Atencion
 * A. Reflexividad
 * Page 35
 */
private fun reflexividadE4M2Baremo() = arrayOf(
    arrayOf(20.0, 95.0, 1.14),
    arrayOf(19.0, 85.0, 0.95),
    arrayOf(18.0, 75.0, 0.76),
    arrayOf(17.0, 65.0, 0.57),
    arrayOf(16.0, 60.0, 0.39),
    arrayOf(15.0, 55.0, 0.2),
    arrayOf(14.0, 50.0, 0.01),
    arrayOf(13.0, 40.0, -0.18),
    arrayOf(12.0, 30.0, -0.36),
    arrayOf(11.0, 25.0, -0.55),
    arrayOf(10.0, 20.0, -0.74),
    arrayOf(9.0, 15.0, -0.93),
    arrayOf(8.0, 13.0, -1.11),
    arrayOf(7.0, 12.0, -1.3),
    arrayOf(6.0, 10.0, -1.49),
    arrayOf(5.0, 9.0, -1.68),
    arrayOf(4.0, 7.0, -1.86),
    arrayOf(3.0, 5.0, -2.05),
    arrayOf(2.0, 3.0, -2.24),
    arrayOf(1.0, 2.0, -2.43),
    arrayOf(0.0, 1.0, -2.62),
)

/**
 * II.- Memoria y Atencion
 * B. Pensamiento Analogico
 * Page 41
 */
private fun pensamientoAnalogicoE4M2Baremo() = arrayOf(
    arrayOf(20.0, 99.0, 1.59),
    arrayOf(19.0, 97.0, 1.35),
    arrayOf(18.0, 92.0, 1.1),
    arrayOf(17.0, 80.0, 0.85),
    arrayOf(16.0, 70.0, 0.6),
    arrayOf(15.0, 60.0, 0.36),
    arrayOf(14.0, 50.0, 0.11),
    arrayOf(13.0, 40.0, -0.14),
    arrayOf(12.0, 35.0, -0.38),
    arrayOf(11.0, 30.0, -0.63),
    arrayOf(10.0, 25.0, -0.88),
    arrayOf(9.0, 20.0, -1.12),
    arrayOf(8.0, 15.0, -1.37),
    arrayOf(7.0, 10.0, -1.62),
    arrayOf(6.0, 7.0, -1.86),
    arrayOf(5.0, 5.0, -2.11),
    arrayOf(4.0, 3.0, -2.36),
    arrayOf(3.0, 2.0, -2.6),
    arrayOf(2.0, 1.0, -2.85),
    arrayOf(1.0, 1.0, -3.1),
)

/**
 * II.- Memoria y Atencion
 * C. Organizacion Perceptiva
 * Page 47
 */
private fun organizacionPerceptivaE4M2Baremo() = arrayOf(
    arrayOf(18.0, 99.0, 1.5),
    arrayOf(17.0, 90.0, 1.19),
    arrayOf(16.0, 75.0, 0.88),
    arrayOf(15.0, 70.0, 0.57),
    arrayOf(14.0, 60.0, 0.26),
    arrayOf(13.0, 50.0, -0.06),
    arrayOf(12.0, 40.0, -0.37),
    arrayOf(11.0, 30.0, -0.68),
    arrayOf(10.0, 20.0, -0.99),
    arrayOf(9.0, 15.0, -1.3),
    arrayOf(8.0, 10.0, -1.61),
    arrayOf(7.0, 7.0, -1.93),
    arrayOf(6.0, 5.0, -2.24),
    arrayOf(5.0, 3.0, -2.55),
    arrayOf(4.0, 2.0, -2.86),
    arrayOf(3.0, 1.0, -3.17),
)

/**
 * III.- Niveles de Adaptacion
 * A. Motivacion
 * Page 55
 */
private fun motivacionFragmentE4M3Baremo() = arrayOf(
    arrayOf(0.0, 99.0, 1.95),
    arrayOf(1.0, 98.0, 1.67),
    arrayOf(2.0, 95.0, 1.38),
    arrayOf(3.0, 90.0, 1.1),
    arrayOf(4.0, 85.0, 0.82),
    arrayOf(5.0, 80.0, 0.54),
    arrayOf(6.0, 70.0, 0.25),
    arrayOf(7.0, 65.0, -0.03),
    arrayOf(8.0, 60.0, -0.31),
    arrayOf(9.0, 55.0, -0.59),
    arrayOf(10.0, 50.0, -0.88),
    arrayOf(11.0, 40.0, -1.16),
    arrayOf(12.0, 35.0, -1.44),
    arrayOf(13.0, 30.0, -1.72),
    arrayOf(14.0, 25.0, -2.01),
    arrayOf(15.0, 20.0, -2.29),
    arrayOf(16.0, 18.0, -2.57),
    arrayOf(17.0, 15.0, -2.85),
    arrayOf(18.0, 12.0, -3.14),
    arrayOf(19.0, 10.0, -3.42),
    arrayOf(20.0, 9.0, -3.7),
    arrayOf(22.0, 7.0, -4.27),
    arrayOf(24.0, 5.0, -4.83),
    arrayOf(26.0, 3.0, -5.4),
    arrayOf(28.0, 2.0, -5.96),
    arrayOf(30.0, 1.0, -6.53),
)

/**
 * III.- Niveles de Adaptacion
 * B. AutoControl
 * Page 55
 */
private fun autoControlFragmentE4M3Baremo() = arrayOf(
    arrayOf(0.0, 99.0, 1.39),
    arrayOf(1.0, 95.0, 0.98),
    arrayOf(2.0, 80.0, 0.56),
    arrayOf(3.0, 70.0, 0.15),
    arrayOf(4.0, 60.0, -0.26),
    arrayOf(5.0, 50.0, -0.67),
    arrayOf(6.0, 40.0, -1.08),
    arrayOf(7.0, 35.0, -1.49),
    arrayOf(8.0, 25.0, -1.91),
    arrayOf(9.0, 20.0, -2.32),
    arrayOf(10.0, 15.0, -2.73),
    arrayOf(11.0, 10.0, -3.14),
    arrayOf(12.0, 7.0, -3.55),
    arrayOf(13.0, 5.0, -3.96),
    arrayOf(14.0, 3.0, -4.37),
    arrayOf(15.0, 1.0, -4.79),
)

/**
 * III.- Niveles de Adaptacion
 * C. ConductaProSocial
 * Page 55
 */
private fun conductaProSocialFragmentE4M3Baremo() = arrayOf(
    arrayOf(0.0, 94.0, 1.25),
    arrayOf(1.0, 82.0, 0.77),
    arrayOf(2.0, 65.0, 0.28),
    arrayOf(3.0, 50.0, -0.21),
    arrayOf(4.0, 40.0, -0.7),
    arrayOf(5.0, 35.0, -1.19),
    arrayOf(6.0, 30.0, -1.67),
    arrayOf(7.0, 20.0, -2.16),
    arrayOf(8.0, 15.0, -2.65),
    arrayOf(9.0, 12.0, -3.14),
    arrayOf(10.0, 10.0, -3.62),
    arrayOf(11.0, 9.0, -4.11),
    arrayOf(12.0, 7.0, -4.6),
    arrayOf(13.0, 5.0, -5.09),
    arrayOf(14.0, 3.0, -5.58),
    arrayOf(15.0, 1.0, -6.06),
)

/**
 * III.- Niveles de Adaptacion
 * D. AutoEstima
 * Page 55
 */
private fun autoEstimaFragmentE4M3Baremo() = arrayOf(
    arrayOf(0.0, 99.0, 1.96),
    arrayOf(1.0, 95.0, 1.58),
    arrayOf(2.0, 90.0, 1.19),
    arrayOf(3.0, 80.0, 0.8),
    arrayOf(4.0, 75.0, 0.42),
    arrayOf(5.0, 65.0, 0.03),
    arrayOf(6.0, 55.0, -0.36),
    arrayOf(7.0, 45.0, -0.74),
    arrayOf(8.0, 40.0, -1.13),
    arrayOf(9.0, 35.0, -1.51),
    arrayOf(10.0, 25.0, -1.9),
    arrayOf(11.0, 15.0, -2.29),
    arrayOf(12.0, 10.0, -2.67),
    arrayOf(13.0, 9.0, -3.06),
    arrayOf(14.0, 7.0, -3.44),
    arrayOf(15.0, 5.0, -3.83),
    arrayOf(16.0, 3.0, -4.22),
    arrayOf(17.0, 1.0, -4.6),
)

/**
 * IV.- Lectura
 * A. Comprension Lectora
 * Page 61
 */
private fun comprensionLectoraE4M4Baremo() = arrayOf(
    arrayOf(32.0, 99.0, 1.59),
    arrayOf(31.0, 99.0, 1.44),
    arrayOf(30.0, 94.0, 1.29),
    arrayOf(29.0, 94.0, 1.14),
    arrayOf(28.0, 85.0, 0.98),
    arrayOf(27.0, 85.0, 0.83),
    arrayOf(26.0, 70.0, 0.68),
    arrayOf(25.0, 70.0, 0.53),
    arrayOf(24.0, 60.0, 0.38),
    arrayOf(23.0, 60.0, 0.23),
    arrayOf(22.0, 50.0, 0.08),
    arrayOf(21.0, 50.0, -0.07),
    arrayOf(20.0, 40.0, -0.22),
    arrayOf(19.0, 40.0, -0.37),
    arrayOf(18.0, 30.0, -0.52),
    arrayOf(17.0, 30.0, -0.67),
    arrayOf(16.0, 25.0, -0.83),
    arrayOf(15.0, 25.0, -0.98),
    arrayOf(14.0, 15.0, -1.13),
    arrayOf(13.0, 15.0, -1.28),
    arrayOf(12.0, 10.0, -1.43),
    arrayOf(11.0, 10.0, -1.58),
    arrayOf(10.0, 8.0, -1.73),
    arrayOf(9.0, 8.0, -1.88),
    arrayOf(8.0, 6.0, -2.03),
    arrayOf(7.0, 6.0, -2.18),
    arrayOf(6.0, 4.0, -2.33),
    arrayOf(5.0, 4.0, -2.48),
    arrayOf(4.0, 2.0, -2.63),
    arrayOf(3.0, 2.0, -2.79),
    arrayOf(2.0, 1.0, -2.94),
    arrayOf(1.0, 1.0, -3.09),
)

/**
 * IV.- Lectura
 * B. Velocidad Lectora - VelocidadFragment
 * Page 67
 */
private fun velocidadFragmentE4M4Baremo() = arrayOf(
    arrayOf(60.0, 99.0, 1.92),
    arrayOf(70.0, 97.0, 1.64),
    arrayOf(80.0, 95.0, 1.36),
    arrayOf(90.0, 90.0, 1.09),
    arrayOf(100.0, 85.0, .81),
    arrayOf(110.0, 75.0, 0.53),
    arrayOf(120.0, 65.0, 0.26),
    arrayOf(130.0, 55.0, -0.02),
    arrayOf(140.0, 45.0, -0.3),
    arrayOf(150.0, 40.0, -0.58),
    arrayOf(160.0, 30.0, -0.85),
    arrayOf(170.0, 25.0, -1.13),
    arrayOf(180.0, 20.0, -1.41),
    arrayOf(190.0, 15.0, -1.68),
    arrayOf(200.0, 10.0, -1.96),
    arrayOf(220.0, 5.0, -2.52),
    arrayOf(230.0, 3.0, -2.79),
    arrayOf(250.0, 2.0, -3.35),
    arrayOf(300.0, 1.0, -4.73),
    arrayOf(380.0, 0.0, -6.95),
)

/**
 * IV.- Lectura
 * B. Velocidad Lectora - ComprensionFragment
 * Page 67
 */
private fun comprensionFragmentE4M4Baremo() = arrayOf(
    arrayOf(15.0, 97.0, 1.68),
    arrayOf(14.0, 95.0, 1.43),
    arrayOf(13.0, 85.0, 1.18),
    arrayOf(12.0, 80.0, 0.93),
    arrayOf(11.0, 70.0, 0.68),
    arrayOf(10.0, 60.0, 0.43),
    arrayOf(9.0, 50.0, 0.18),
    arrayOf(8.0, 40.0, -0.06),
    arrayOf(7.0, 35.0, -0.31),
    arrayOf(6.0, 30.0, -0.56),
    arrayOf(5.0, 25.0, -0.81),
    arrayOf(4.0, 20.0, -1.06),
    arrayOf(3.0, 10.0, -1.31),
    arrayOf(2.0, 5.0, -1.56),
    arrayOf(1.0, 1.0, -1.81),
)

/**
 * V. Escritura
 * A. Ortografia Visual Reglada
 * Page 75
 */
private fun ortografiaVisualRegladaE4M5Baremo() = arrayOf(
    arrayOf(80.0, 99.0, 2.46),
    arrayOf(79.0, 99.0, 2.39),
    arrayOf(78.0, 99.0, 2.33),
    arrayOf(77.0, 98.0, 2.27),
    arrayOf(76.0, 98.0, 2.21),
    arrayOf(75.0, 98.0, 2.14),
    arrayOf(74.0, 97.0, 2.08),
    arrayOf(73.0, 97.0, 2.02),
    arrayOf(72.0, 97.0, 1.96),
    arrayOf(71.0, 96.0, 1.89),
    arrayOf(70.0, 96.0, 1.83),
    arrayOf(69.0, 96.0, 1.77),
    arrayOf(68.0, 94.0, 1.71),
    arrayOf(67.0, 94.0, 1.64),
    arrayOf(66.0, 94.0, 1.58),
    arrayOf(65.0, 92.0, 1.52),
    arrayOf(64.0, 92.0, 1.46),
    arrayOf(63.0, 92.0, 1.4),
    arrayOf(62.0, 90.0, 1.33),
    arrayOf(61.0, 90.0, 1.27),
    arrayOf(60.0, 90.0, 1.21),
    arrayOf(59.0, 85.0, 1.15),
    arrayOf(58.0, 85.0, 1.08),
    arrayOf(57.0, 85.0, 1.02),
    arrayOf(56.0, 80.0, 0.96),
    arrayOf(55.0, 80.0, 0.9),
    arrayOf(54.0, 80.0, 0.83),
    arrayOf(53.0, 75.0, 0.77),
    arrayOf(52.0, 75.0, 0.71),
    arrayOf(51.0, 75.0, 0.65),
    arrayOf(50.0, 70.0, 0.58),
    arrayOf(49.0, 70.0, 0.52),
    arrayOf(48.0, 70.0, 0.46),
    arrayOf(47.0, 60.0, 0.4),
    arrayOf(46.0, 60.0, 0.34),
    arrayOf(45.0, 60.0, 0.27),
    arrayOf(44.0, 55.0, 0.21),
    arrayOf(43.0, 55.0, 0.15),
    arrayOf(42.0, 55.0, 0.09),
    arrayOf(41.0, 50.0, 0.02),
    arrayOf(40.0, 50.0, -0.04),
    arrayOf(39.0, 50.0, -0.1),
    arrayOf(38.0, 40.0, -0.16),
    arrayOf(37.0, 40.0, -0.23),
    arrayOf(36.0, 40.0, -0.29),
    arrayOf(35.0, 35.0, -0.35),
    arrayOf(34.0, 35.0, -0.41),
    arrayOf(33.0, 35.0, -0.48),
    arrayOf(32.0, 30.0, -0.54),
    arrayOf(31.0, 30.0, -0.6),
    arrayOf(30.0, 30.0, -0.66),
    arrayOf(29.0, 25.0, -0.72),
    arrayOf(28.0, 25.0, -0.79),
    arrayOf(27.0, 25.0, -0.85),
    arrayOf(26.0, 20.0, -0.91),
    arrayOf(25.0, 20.0, -0.97),
    arrayOf(24.0, 20.0, -1.04),
    arrayOf(23.0, 17.0, -1.1),
    arrayOf(22.0, 17.0, -1.16),
    arrayOf(21.0, 17.0, -1.22),
    arrayOf(20.0, 15.0, -1.29),
    arrayOf(19.0, 15.0, -1.35),
    arrayOf(18.0, 15.0, -1.41),
    arrayOf(17.0, 10.0, -1.47),
    arrayOf(16.0, 10.0, -1.53),
    arrayOf(15.0, 10.0, -1.6),
    arrayOf(14.0, 5.0, -1.66),
    arrayOf(13.0, 5.0, -1.72),
    arrayOf(12.0, 5.0, -1.78),
    arrayOf(11.0, 1.0, -1.85),
    arrayOf(10.0, 1.0, -1.91),
    arrayOf(9.0, 1.0, -1.97),
)

/**
 * VI. Aprendizajes Matematicos
 * A. Calculo y Numeracion
 * Page 85
 */
private fun calculoNumeracionE4M6Baremo() = arrayOf(
    arrayOf(35.0, 99.0, 1.35),
    arrayOf(34.0, 95.0, 1.15),
    arrayOf(33.0, 85.0, 0.96),
    arrayOf(32.0, 80.0, 0.77),
    arrayOf(31.0, 70.0, 0.57),
    arrayOf(30.0, 65.0, 0.38),
    arrayOf(29.0, 55.0, 0.18),
    arrayOf(28.0, 50.0, -0.01),
    arrayOf(27.0, 45.0, -0.2),
    arrayOf(26.0, 40.0, -0.4),
    arrayOf(25.0, 37.0, -0.59),
    arrayOf(24.0, 35.0, -0.78),
    arrayOf(23.0, 30.0, -0.98),
    arrayOf(22.0, 25.0, -1.17),
    arrayOf(21.0, 20.0, -1.37),
    arrayOf(20.0, 18.0, -1.56),
    arrayOf(19.0, 15.0, -1.75),
    arrayOf(18.0, 12.0, -1.95),
    arrayOf(17.0, 10.0, -2.14),
    arrayOf(16.0, 9.0, -2.34),
    arrayOf(15.0, 8.0, -2.53),
    arrayOf(14.0, 7.0, -2.72),
    arrayOf(13.0, 6.0, -2.92),
    arrayOf(12.0, 5.0, -3.11),
    arrayOf(11.0, 3.0, -3.3),
    arrayOf(10.0, 2.0, -3.5),
    arrayOf(9.0, 1.0, -3.69),
)

/**
 * VI. Aprendizajes Matematicos
 * B. Resolucion de Problemas
 * Page 93
 */
private fun resolucionProblemasE4M6Baremo() = arrayOf(
    arrayOf(15.0, 99.0, 1.94),
    arrayOf(14.0, 98.0, 1.66),
    arrayOf(13.0, 95.0, 1.38),
    arrayOf(12.0, 85.0, 1.09),
    arrayOf(11.0, 75.0, 0.81),
    arrayOf(10.0, 65.0, 0.52),
    arrayOf(9.0, 60.0, 0.24),
    arrayOf(8.0, 50.0, -0.05),
    arrayOf(7.0, 40.0, -0.33),
    arrayOf(6.0, 35.0, -0.61),
    arrayOf(5.0, 25.0, -0.9),
    arrayOf(4.0, 20.0, -1.18),
    arrayOf(3.0, 15.0, -1.47),
    arrayOf(2.0, 10.0, -1.75),
    arrayOf(1.0, 5.0, -2.03),
    arrayOf(0.0, 3.0, -2.32),
)
