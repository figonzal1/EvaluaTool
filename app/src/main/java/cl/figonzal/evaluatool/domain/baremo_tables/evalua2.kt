/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2022

 Last modified 22-06-22 23:24
 */

package cl.figonzal.evaluatool.domain.baremo_tables

import cl.figonzal.evaluatool.domain.resolvers.BaremoTable

/**
 * Evalua 2
 */
class Evalua2Baremo : BaremoTable {
    override fun getBaremo(baremo: String) = when (baremo) {
        "pens" -> pensamientoAnalogicoE2M1Baremo()
        "orga" -> organizacionPerceptivaE2M1Baremo()
        "clasif" -> clasificacionesE2M1Baremo()

        "memo" -> memoriaAtencionE2M2Baremo()

        "moti" -> motivacionFragmentE2M3Baremo()
        "auto" -> autoControlFragmentE2M3Baremo()
        "condu" -> conductaProSocialFragmentE2M3Baremo()
        "esti" -> autoEstimaFragmentE2M3Baremo()

        "comp" -> comprensionLectoraE2M4Baremo()

        "orto" -> ortografiaE2M5Baremo()

        "calc" -> calculoNumeracionE2M6Baremo()
        "resol" -> resolucionProblemasE2M6Baremo()
        else -> emptyArray()
    }
}

/**
 * I.- Bases del razonamiento
 * A. Pensamiento Analogico
 * Page 27
 */
private fun pensamientoAnalogicoE2M1Baremo() = arrayOf(
    arrayOf(20.0, 99.0, 1.41),
    arrayOf(19.0, 90.0, 1.21),
    arrayOf(18.0, 80.0, 1.02),
    arrayOf(17.0, 75.0, 0.82),
    arrayOf(16.0, 70.0, 0.63),
    arrayOf(15.0, 65.0, 0.44),
    arrayOf(14.0, 60.0, 0.24),
    arrayOf(13.0, 55.0, 0.05),
    arrayOf(12.0, 50.0, -0.15),
    arrayOf(11.0, 40.0, -0.34),
    arrayOf(10.0, 35.0, -0.53),
    arrayOf(9.0, 30.0, -0.73),
    arrayOf(8.0, 20.0, -0.92),
    arrayOf(7.0, 15.0, -1.11),
    arrayOf(6.0, 13.0, -1.31),
    arrayOf(5.0, 10.0, -1.5),
    arrayOf(4.0, 8.0, -1.7),
    arrayOf(3.0, 7.0, -1.89),
    arrayOf(2.0, 5.0, -2.08),
    arrayOf(1.0, 3.0, -2.28),
    arrayOf(0.0, 1.0, -2.47),
)

/**
 * I.- Bases del razonamiento
 * B. Organizacion Perceptiva
 * Page 37
 */
private fun organizacionPerceptivaE2M1Baremo() = arrayOf(
    arrayOf(34.0, 95.0, 0.9),
    arrayOf(33.0, 95.0, 0.78),
    arrayOf(32.0, 85.0, 0.66),
    arrayOf(31.0, 85.0, 0.53),
    arrayOf(30.0, 75.0, 0.41),
    arrayOf(29.0, 75.0, 0.29),
    arrayOf(28.0, 60.0, 0.17),
    arrayOf(27.0, 60.0, 0.04),
    arrayOf(26.0, 50.0, -0.08),
    arrayOf(25.0, 50.0, -0.2),
    arrayOf(24.0, 40.0, -0.32),
    arrayOf(23.0, 40.0, -0.45),
    arrayOf(22.0, 35.0, -0.57),
    arrayOf(21.0, 35.0, -0.69),
    arrayOf(20.0, 25.0, -0.81),
    arrayOf(19.0, 25.0, -0.94),
    arrayOf(18.0, 20.0, -1.06),
    arrayOf(17.0, 20.0, -1.18),
    arrayOf(16.0, 15.0, -1.3),
    arrayOf(15.0, 15.0, -1.42),
    arrayOf(14.0, 13.0, -1.55),
    arrayOf(13.0, 13.0, -1.67),
    arrayOf(12.0, 12.0, -1.79),
    arrayOf(11.0, 12.0, -1.91),
    arrayOf(10.0, 10.0, -2.04),
    arrayOf(9.0, 10.0, -2.16),
    arrayOf(8.0, 7.0, -2.28),
    arrayOf(7.0, 7.0, -2.4),
    arrayOf(6.0, 5.0, -2.53),
    arrayOf(5.0, 5.0, -2.65),
    arrayOf(4.0, 3.0, -2.77),
    arrayOf(3.0, 3.0, -2.89),
    arrayOf(2.0, 2.0, -3.02),
    arrayOf(1.0, 2.0, -3.14),
    arrayOf(0.0, 1.0, -3.26),
)

/**
 * I.- Bases del razonamiento
 * C. Clasificaciones
 * Page 43
 */
private fun clasificacionesE2M1Baremo() = arrayOf(
    arrayOf(29.0, 99.0, 1.41),
    arrayOf(28.0, 98.0, 1.27),
    arrayOf(27.0, 95.0, 1.12),
    arrayOf(26.0, 90.0, 0.98),
    arrayOf(25.0, 85.0, 0.84),
    arrayOf(24.0, 75.0, 0.69),
    arrayOf(23.0, 70.0, 0.55),
    arrayOf(22.0, 60.0, 0.4),
    arrayOf(21.0, 55.0, 0.26),
    arrayOf(20.0, 50.0, 0.12),
    arrayOf(19.0, 45.0, -0.03),
    arrayOf(18.0, 40.0, -0.17),
    arrayOf(17.0, 35.0, -0.31),
    arrayOf(16.0, 30.0, -0.46),
    arrayOf(15.0, 27.0, -0.6),
    arrayOf(14.0, 25.0, -0.74),
    arrayOf(13.0, 22.0, -0.89),
    arrayOf(12.0, 20.0, -1.03),
    arrayOf(11.0, 15.0, -1.17),
    arrayOf(10.0, 12.0, -1.32),
    arrayOf(9.0, 10.0, -1.46),
    arrayOf(8.0, 7.0, -1.6),
    arrayOf(7.0, 5.0, -1.75),
    arrayOf(6.0, 3.0, -1.89),
)

/**
 * II.- Memoria y Atencion
 *
 * Page 51
 */
private fun memoriaAtencionE2M2Baremo() = arrayOf(
    arrayOf(88.0, 99.0, 2.2),
    arrayOf(87.0, 99.0, 2.12),
    arrayOf(86.0, 99.0, 2.04),
    arrayOf(85.0, 99.0, 1.97),
    arrayOf(84.0, 99.0, 1.89),
    arrayOf(83.0, 99.0, 1.81),
    arrayOf(82.0, 99.0, 1.74),
    arrayOf(81.0, 99.0, 1.66),
    arrayOf(80.0, 95.0, 1.58),
    arrayOf(79.0, 95.0, 1.51),
    arrayOf(78.0, 95.0, 1.43),
    arrayOf(77.0, 95.0, 1.35),
    arrayOf(76.0, 95.0, 1.28),
    arrayOf(75.0, 85.0, 1.2),
    arrayOf(74.0, 85.0, 1.12),
    arrayOf(73.0, 85.0, 1.05),
    arrayOf(72.0, 85.0, 0.97),
    arrayOf(71.0, 85.0, 0.89),
    arrayOf(70.0, 75.0, 0.82),
    arrayOf(69.0, 75.0, 0.74),
    arrayOf(68.0, 75.0, 0.66),
    arrayOf(67.0, 75.0, 0.59),
    arrayOf(66.0, 75.0, 0.51),
    arrayOf(65.0, 65.0, 0.43),
    arrayOf(64.0, 65.0, 0.36),
    arrayOf(63.0, 65.0, 0.28),
    arrayOf(62.0, 65.0, 0.2),
    arrayOf(61.0, 65.0, 0.13),
    arrayOf(60.0, 50.0, 0.05),
    arrayOf(59.0, 50.0, -0.03),
    arrayOf(58.0, 50.0, -0.1),
    arrayOf(57.0, 50.0, -0.18),
    arrayOf(56.0, 50.0, -0.26),
    arrayOf(55.0, 45.0, -0.33),
    arrayOf(54.0, 45.0, -0.41),
    arrayOf(53.0, 45.0, -0.49),
    arrayOf(52.0, 45.0, -0.56),
    arrayOf(51.0, 45.0, -0.64),
    arrayOf(50.0, 35.0, -0.72),
    arrayOf(49.0, 35.0, -0.79),
    arrayOf(48.0, 35.0, -0.87),
    arrayOf(47.0, 35.0, -0.95),
    arrayOf(46.0, 35.0, -1.02),
    arrayOf(45.0, 30.0, -1.1),
    arrayOf(44.0, 30.0, -1.18),
    arrayOf(43.0, 30.0, -1.25),
    arrayOf(42.0, 30.0, -1.33),
    arrayOf(41.0, 30.0, -1.41),
    arrayOf(40.0, 20.0, -1.48),
    arrayOf(39.0, 20.0, -1.56),
    arrayOf(38.0, 20.0, -1.64),
    arrayOf(37.0, 20.0, -1.71),
    arrayOf(36.0, 20.0, -1.79),
    arrayOf(35.0, 15.0, -1.87),
    arrayOf(34.0, 15.0, -1.94),
    arrayOf(33.0, 15.0, -2.02),
    arrayOf(32.0, 15.0, -2.1),
    arrayOf(31.0, 15.0, -2.17),
    arrayOf(30.0, 10.0, -2.25),
    arrayOf(29.0, 10.0, -2.33),
    arrayOf(27.0, 10.0, -2.48),
    arrayOf(26.0, 10.0, -2.56),
    arrayOf(25.0, 7.0, -2.63),
    arrayOf(24.0, 7.0, -2.71),
    arrayOf(23.0, 7.0, -2.79),
    arrayOf(22.0, 7.0, -2.86),
    arrayOf(21.0, 7.0, -2.94),
    arrayOf(20.0, 5.0, -3.02),
    arrayOf(19.0, 5.0, -3.09),
    arrayOf(18.0, 5.0, -3.17),
    arrayOf(17.0, 5.0, -3.25),
    arrayOf(16.0, 5.0, -3.32),
    arrayOf(15.0, 3.0, -3.4),
    arrayOf(14.0, 3.0, -3.48),
    arrayOf(13.0, 3.0, -3.55),
    arrayOf(12.0, 3.0, -3.63),
    arrayOf(11.0, 3.0, -3.71),
    arrayOf(10.0, 1.0, -3.78),
    arrayOf(9.0, 1.0, -3.86),
    arrayOf(8.0, 1.0, -3.94),
    arrayOf(7.0, 1.0, -4.01),
    arrayOf(6.0, 1.0, -4.09),
)

/**
 * III. Niveles de adaptacion
 * A. Motivacion
 *
 * Page 57
 */
private fun motivacionFragmentE2M3Baremo() = arrayOf(
    arrayOf(45.0, 99.0, 2.33),
    arrayOf(44.0, 99.0, 2.11),
    arrayOf(43.0, 99.0, 1.88),
    arrayOf(42.0, 99.0, 1.66),
    arrayOf(41.0, 99.0, 1.43),
    arrayOf(40.0, 99.0, 1.2),
    arrayOf(39.0, 90.0, 0.98),
    arrayOf(38.0, 80.0, 0.75),
    arrayOf(37.0, 70.0, 0.53),
    arrayOf(35.0, 60.0, 0.08),
    arrayOf(32.0, 50.0, -0.6),
    arrayOf(30.0, 40.0, -1.05),
    arrayOf(29.0, 30.0, -1.27),
    arrayOf(27.0, 20.0, -1.72),
    arrayOf(25.0, 10.0, -2.17),
    arrayOf(22.0, 5.0, -2.85),
)

/**
 * III. Niveles de adaptacion
 * B. Autocontrol
 *
 * Page 57
 */
private fun autoControlFragmentE2M3Baremo() = arrayOf(
    arrayOf(30.0, 99.0, 1.93),
    arrayOf(28.0, 90.0, 1.37),
    arrayOf(26.0, 80.0, 0.8),
    arrayOf(25.0, 70.0, 0.52),
    arrayOf(24.0, 60.0, 0.24),
    arrayOf(23.0, 50.0, -0.05),
    arrayOf(22.0, 40.0, -0.33),
    arrayOf(20.0, 30.0, -0.9),
    arrayOf(16.0, 20.0, -2.03),
    arrayOf(14.0, 10.0, -2.6),
    arrayOf(12.0, 5.0, -3.16),
)

/**
 * III. Niveles de adaptacion
 * C. Conducta ProSocial
 *
 * Page 57
 */
private fun conductaProSocialFragmentE2M3Baremo() = arrayOf(
    arrayOf(30.0, 99.0, 1.05),
    arrayOf(29.0, 90.0, 0.78),
    arrayOf(28.0, 80.0, 0.51),
    arrayOf(27.0, 70.0, 0.24),
    arrayOf(26.0, 60.0, -0.03),
    arrayOf(25.0, 50.0, -0.3),
    arrayOf(24.0, 40.0, -0.57),
    arrayOf(22.0, 30.0, -1.12),
    arrayOf(21.0, 20.0, -1.39),
    arrayOf(20.0, 10.0, -1.66),
    arrayOf(15.0, 5.0, -3.01),
)

/**
 * III. Niveles de adaptacion
 * D. AutoEstima
 *
 * Page 57
 */
private fun autoEstimaFragmentE2M3Baremo() = arrayOf(
    arrayOf(30.0, 99.0, 2.39),
    arrayOf(29.0, 99.0, 2.04),
    arrayOf(28.0, 99.0, 1.7),
    arrayOf(27.0, 90.0, 1.36),
    arrayOf(26.0, 80.0, 1.01),
    arrayOf(25.0, 70.0, 0.67),
    arrayOf(24.0, 60.0, 0.32),
    arrayOf(22.0, 50.0, -0.37),
    arrayOf(20.0, 40.0, -1.06),
    arrayOf(19.0, 30.0, -1.4),
    arrayOf(17.0, 20.0, -2.09),
    arrayOf(15.0, 10.0, -2.78),
    arrayOf(10.0, 5.0, -4.51)
)

/**
 * IV. Lectura
 * A. Compresion Lectora
 *
 * Page 61
 */
private fun comprensionLectoraE2M4Baremo() = arrayOf(
    arrayOf(25.0, 99.0, 2.24),
    arrayOf(24.0, 98.0, 2.07),
    arrayOf(23.0, 97.0, 1.89),
    arrayOf(22.0, 96.0, 1.71),
    arrayOf(21.0, 95.0, 1.54),
    arrayOf(20.0, 93.0, 1.36),
    arrayOf(19.0, 92.0, 1.18),
    arrayOf(18.0, 90.0, 1.01),
    arrayOf(17.0, 85.0, 0.83),
    arrayOf(16.0, 80.0, 0.66),
    arrayOf(15.0, 70.0, 0.48),
    arrayOf(14.0, 65.0, 0.3),
    arrayOf(13.0, 60.0, 0.13),
    arrayOf(12.0, 50.0, -0.05),
    arrayOf(11.0, 45.0, -0.22),
    arrayOf(10.0, 40.0, -0.4),
    arrayOf(9.0, 35.0, -0.58),
    arrayOf(8.0, 30.0, -0.75),
    arrayOf(7.0, 25.0, -0.93),
    arrayOf(6.0, 20.0, -1.1),
    arrayOf(5.0, 15.0, -1.28),
    arrayOf(4.0, 10.0, -1.46),
    arrayOf(3.0, 7.0, -1.63),
    arrayOf(2.0, 5.0, -1.81),
    arrayOf(1.0, 1.0, -1.98),
)

/**
 * V. Escritura
 * B. Ortografia
 *
 * Page 77
 */
private fun ortografiaE2M5Baremo() = arrayOf(
    arrayOf(43.0, 99.0, 1.22),
    arrayOf(42.0, 95.0, 1.12),
    arrayOf(41.0, 90.0, 1.01),
    arrayOf(40.0, 85.0, 0.91),
    arrayOf(38.0, 80.0, 0.7),
    arrayOf(36.0, 75.0, 0.48),
    arrayOf(35.0, 70.0, 0.38),
    arrayOf(34.0, 65.0, 0.27),
    arrayOf(33.0, 60.0, 0.17),
    arrayOf(32.0, 55.0, 0.06),
    arrayOf(31.0, 50.0, -0.04),
    arrayOf(30.0, 45.0, -0.15),
    arrayOf(29.0, 40.0, -0.26),
    arrayOf(28.0, 35.0, -0.36),
    arrayOf(27.0, 30.0, -0.47),
    arrayOf(25.0, 25.0, -0.68),
    arrayOf(22.0, 20.0, -1.0),
    arrayOf(20.0, 15.0, -1.21),
    arrayOf(18.0, 10.0, -1.42),
    arrayOf(14.0, 5.0, -1.84),
    arrayOf(13.0, 1.0, -1.95),
)

/**
 * VI. Aprendizajes Matematicos
 * A. Calculos y numeracion
 *
 * Page 83
 */
private fun calculoNumeracionE2M6Baremo() = arrayOf(
    arrayOf(55.0, 99.0, 1.67),
    arrayOf(53.0, 98.0, 1.5),
    arrayOf(52.0, 97.0, 1.42),
    arrayOf(51.0, 95.0, 1.33),
    arrayOf(50.0, 92.0, 1.25),
    arrayOf(49.0, 90.0, 1.16),
    arrayOf(48.0, 85.0, 1.08),
    arrayOf(47.0, 80.0, 0.99),
    arrayOf(45.0, 75.0, 0.82),
    arrayOf(43.0, 70.0, 0.66),
    arrayOf(41.0, 65.0, 0.49),
    arrayOf(39.0, 60.0, 0.32),
    arrayOf(38.0, 55.0, 0.23),
    arrayOf(36.0, 50.0, 0.06),
    arrayOf(35.0, 45.0, -0.02),
    arrayOf(33.0, 40.0, -0.19),
    arrayOf(30.0, 35.0, -0.45),
    arrayOf(25.0, 25.0, -0.87),
    arrayOf(20.0, 20.0, -1.3),
    arrayOf(10.0, 10.0, -2.15),
    arrayOf(8.0, 5.0, -2.32),
    arrayOf(3.0, 1.0, -2.74),
)

/**
 * VI. Aprendizajes Matematicos
 * B. Resolucion de Problemas
 *
 * Page 89
 */
private fun resolucionProblemasE2M6Baremo() = arrayOf(
    arrayOf(14.0, 99.0, 1.66),
    arrayOf(13.0, 95.0, 1.36),
    arrayOf(12.0, 85.0, 1.07),
    arrayOf(11.0, 75.0, 0.77),
    arrayOf(10.0, 65.0, 0.48),
    arrayOf(9.0, 55.0, 0.18),
    arrayOf(8.0, 45.0, -0.12),
    arrayOf(7.0, 35.0, -0.41),
    arrayOf(6.0, 25.0, -0.71),
    arrayOf(5.0, 20.0, -1.0),
    arrayOf(4.0, 10.0, -1.3),
    arrayOf(3.0, 5.0, -1.59),
    arrayOf(2.0, 1.0, -1.89),
)



