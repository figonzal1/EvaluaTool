/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2022

 Last modified 22-06-22 00:41
 */

package cl.figonzal.evaluatool.domain.baremo_tables

import cl.figonzal.evaluatool.domain.resolvers.BaremoTable

/**
 * Evalua 7
 */
class Evalua7Baremo : BaremoTable {
    override fun getBaremo(baremo: String): Array<Array<Double>> {
        return when (baremo) {
            "aten" -> atencionConcentracionE7M1Baremo()

            "razod" -> razonamientoDeductivoE7M2Baremo()
            "razoi" -> razonamientoInductivoE7M2Baremo()
            "razoe" -> razonamientoEspacialE7M2Baremo()

            "moti" -> motivacionFragmentE7M3Baremo()
            "auto" -> autoControlFragmentE7M3Baremo()
            "conduct" -> conductaProSocialFragmentE7M3Baremo()
            "esti" -> autoEstimaFragmentE7M3Baremo()

            "efic" -> eficaciaLectoraE7M4Baremo()
            "compl" -> comprensionLectoraE7M4Baremo()
            "velo" -> velocidadFragmentE7M4Baremo()
            "compf" -> comprensionFragmentE7M4Baremo()

            "ortof" -> ortografiaFoneticaE7M5Baremo()
            "ortov" -> ortografiaVisualRegladaE7M5Baremo()
            "expr" -> expresionEscritaE7M5Baremo()

            "calc" -> calculoNumeracionE7M6Baremo()
            "reso" -> resolucionProblemasE7M6Baremo()

            else -> emptyArray()
        }
    }

}

/**
 * I.- Atencion - Concentracion
 *
 * Page 25
 */
fun atencionConcentracionE7M1Baremo() = arrayOf(
    arrayOf(191.0, 99.0, 2.69),
    arrayOf(190.0, 99.0, 2.65),
    arrayOf(189.0, 99.0, 2.61),
    arrayOf(188.0, 99.0, 2.58),
    arrayOf(187.0, 99.0, 2.54),
    arrayOf(186.0, 99.0, 2.51),
    arrayOf(185.0, 99.0, 2.47),
    arrayOf(184.0, 95.0, 2.44),
    arrayOf(183.0, 95.0, 2.4),
    arrayOf(182.0, 95.0, 2.37),
    arrayOf(181.0, 95.0, 2.33),
    arrayOf(180.0, 95.0, 2.29),
    arrayOf(179.0, 90.0, 2.26),
    arrayOf(178.0, 90.0, 2.22),
    arrayOf(177.0, 90.0, 2.19),
    arrayOf(176.0, 90.0, 2.15),
    arrayOf(175.0, 90.0, 2.12),
    arrayOf(174.0, 87.0, 2.08),
    arrayOf(173.0, 87.0, 2.04),
    arrayOf(172.0, 87.0, 2.01),
    arrayOf(171.0, 87.0, 1.97),
    arrayOf(170.0, 87.0, 1.94),
    arrayOf(169.0, 85.0, 1.9),
    arrayOf(168.0, 85.0, 1.87),
    arrayOf(167.0, 85.0, 1.83),
    arrayOf(166.0, 85.0, 1.79),
    arrayOf(165.0, 85.0, 1.76),
    arrayOf(164.0, 80.0, 1.72),
    arrayOf(163.0, 80.0, 1.69),
    arrayOf(162.0, 80.0, 1.65),
    arrayOf(161.0, 80.0, 1.62),
    arrayOf(160.0, 80.0, 1.58),
    arrayOf(159.0, 78.0, 1.54),
    arrayOf(158.0, 78.0, 1.51),
    arrayOf(157.0, 78.0, 1.47),
    arrayOf(156.0, 78.0, 1.44),
    arrayOf(155.0, 78.0, 1.4),
    arrayOf(154.0, 75.0, 1.37),
    arrayOf(153.0, 75.0, 1.33),
    arrayOf(152.0, 75.0, 1.3),
    arrayOf(151.0, 75.0, 1.26),
    arrayOf(150.0, 75.0, 1.22),
    arrayOf(149.0, 72.0, 1.19),
    arrayOf(148.0, 72.0, 1.15),
    arrayOf(147.0, 72.0, 1.12),
    arrayOf(146.0, 72.0, 1.08),
    arrayOf(145.0, 72.0, 1.05),
    arrayOf(144.0, 70.0, 1.01),
    arrayOf(143.0, 70.0, 0.97),
    arrayOf(142.0, 70.0, 0.94),
    arrayOf(141.0, 70.0, 0.9),
    arrayOf(140.0, 70.0, 0.87),
    arrayOf(139.0, 65.0, 0.83),
    arrayOf(138.0, 65.0, 0.8),
    arrayOf(137.0, 65.0, 0.76),
    arrayOf(136.0, 65.0, 0.72),
    arrayOf(135.0, 65.0, 0.69),
    arrayOf(134.0, 63.0, 0.65),
    arrayOf(133.0, 63.0, 0.62),
    arrayOf(132.0, 63.0, 0.58),
    arrayOf(131.0, 63.0, 0.55),
    arrayOf(130.0, 63.0, 0.51),
    arrayOf(129.0, 60.0, 0.48),
    arrayOf(128.0, 60.0, 0.44),
    arrayOf(127.0, 60.0, 0.4),
    arrayOf(126.0, 60.0, 0.37),
    arrayOf(125.0, 60.0, 0.33),
    arrayOf(124.0, 55.0, 0.3),
    arrayOf(123.0, 55.0, 0.26),
    arrayOf(122.0, 55.0, 0.23),
    arrayOf(121.0, 55.0, 0.19),
    arrayOf(120.0, 55.0, 0.15),
    arrayOf(119.0, 50.0, 0.12),
    arrayOf(118.0, 50.0, 0.08),
    arrayOf(117.0, 50.0, 0.05),
    arrayOf(116.0, 50.0, 0.01),
    arrayOf(115.0, 50.0, -0.02),
    arrayOf(114.0, 45.0, -0.06),
    arrayOf(113.0, 45.0, -0.1),
    arrayOf(112.0, 45.0, -0.13),
    arrayOf(111.0, 45.0, -0.17),
    arrayOf(110.0, 45.0, -0.2),
    arrayOf(109.0, 40.0, -0.24),
    arrayOf(108.0, 40.0, -0.27),
    arrayOf(107.0, 40.0, -0.31),
    arrayOf(106.0, 40.0, -0.35),
    arrayOf(105.0, 40.0, -0.38),
    arrayOf(104.0, 35.0, -0.42),
    arrayOf(103.0, 35.0, -0.45),
    arrayOf(102.0, 35.0, -0.49),
    arrayOf(101.0, 35.0, -0.52),
    arrayOf(100.0, 35.0, -0.56),
    arrayOf(99.0, 30.0, -0.59),
    arrayOf(98.0, 30.0, -0.63),
    arrayOf(97.0, 30.0, -0.67),
    arrayOf(96.0, 30.0, -0.7),
    arrayOf(95.0, 30.0, -0.74),
    arrayOf(94.0, 25.0, -0.77),
    arrayOf(93.0, 25.0, -0.81),
    arrayOf(92.0, 25.0, -0.84),
    arrayOf(91.0, 25.0, -0.88),
    arrayOf(90.0, 25.0, -0.92),
    arrayOf(89.0, 18.0, -0.95),
    arrayOf(88.0, 18.0, -0.99),
    arrayOf(87.0, 18.0, -1.02),
    arrayOf(86.0, 18.0, -1.06),
    arrayOf(85.0, 18.0, -1.09),
    arrayOf(84.0, 15.0, -1.13),
    arrayOf(83.0, 15.0, -1.17),
    arrayOf(82.0, 15.0, -1.2),
    arrayOf(81.0, 15.0, -1.24),
    arrayOf(80.0, 15.0, -1.27),
    arrayOf(79.0, 12.0, -1.31),
    arrayOf(78.0, 12.0, -1.34),
    arrayOf(77.0, 12.0, -1.38),
    arrayOf(76.0, 12.0, -1.42),
    arrayOf(75.0, 12.0, -1.45),
    arrayOf(74.0, 10.0, -1.49),
    arrayOf(73.0, 10.0, -1.52),
    arrayOf(72.0, 10.0, -1.56),
    arrayOf(71.0, 10.0, -1.59),
    arrayOf(70.0, 10.0, -1.63),
    arrayOf(69.0, 9.0, -1.66),
    arrayOf(68.0, 9.0, -1.7),
    arrayOf(67.0, 9.0, -1.74),
    arrayOf(66.0, 9.0, -1.77),
    arrayOf(65.0, 9.0, -1.81),
    arrayOf(64.0, 7.0, -1.84),
    arrayOf(63.0, 7.0, -1.88),
    arrayOf(62.0, 7.0, -1.91),
    arrayOf(61.0, 7.0, -1.95),
    arrayOf(60.0, 7.0, -1.99),
    arrayOf(59.0, 5.0, -2.02),
    arrayOf(58.0, 5.0, -2.06),
    arrayOf(57.0, 5.0, -2.09),
    arrayOf(56.0, 5.0, -2.13),
    arrayOf(55.0, 5.0, -2.16),
    arrayOf(54.0, 3.0, -2.2),
    arrayOf(53.0, 3.0, -2.24),
    arrayOf(52.0, 3.0, -2.27),
    arrayOf(51.0, 3.0, -2.31),
    arrayOf(50.0, 3.0, -2.34),
    arrayOf(49.0, 1.0, -2.38),
    arrayOf(48.0, 1.0, -2.41),
    arrayOf(47.0, 1.0, -2.45),
    arrayOf(46.0, 1.0, -2.49),
    arrayOf(45.0, 1.0, -2.52),
)

/**
 * II. Razonamiento
 * A. Razonamiento Deductivo
 * Page 30
 */
fun razonamientoDeductivoE7M2Baremo() = arrayOf(
    arrayOf(26.0, 99.0, 2.23),
    arrayOf(25.0, 97.0, 2.06),
    arrayOf(24.0, 95.0, 1.9),
    arrayOf(23.0, 90.0, 1.73),
    arrayOf(22.0, 85.0, 1.57),
    arrayOf(21.0, 80.0, 1.4),
    arrayOf(20.0, 75.0, 1.24),
    arrayOf(19.0, 70.0, 1.07),
    arrayOf(18.0, 65.0, 0.91),
    arrayOf(17.0, 62.0, 0.74),
    arrayOf(16.0, 60.0, 0.58),
    arrayOf(15.0, 57.0, 0.41),
    arrayOf(14.0, 55.0, 0.25),
    arrayOf(13.0, 50.0, 0.08),
    arrayOf(12.0, 40.0, -0.08),
    arrayOf(11.0, 30.0, -0.25),
    arrayOf(10.0, 25.0, -0.41),
    arrayOf(9.0, 20.0, -0.58),
    arrayOf(8.0, 15.0, -0.75),
    arrayOf(7.0, 12.0, -0.91),
    arrayOf(6.0, 10.0, -1.08),
    arrayOf(5.0, 7.0, -1.24),
    arrayOf(4.0, 5.0, -1.41),
    arrayOf(3.0, 3.0, -1.57),
    arrayOf(2.0, 2.0, -1.74),
    arrayOf(1.0, 1.0, -1.9),
)

/**
 * II. Razonamiento
 * B. Razonamiento Inductivo
 * Page 35
 */
fun razonamientoInductivoE7M2Baremo() = arrayOf(
    arrayOf(46.0, 99.0, 3.72),
    arrayOf(44.0, 98.0, 3.44),
    arrayOf(42.0, 97.0, 3.16),
    arrayOf(40.0, 96.0, 2.87),
    arrayOf(38.0, 95.0, 2.59),
    arrayOf(36.0, 92.0, 2.31),
    arrayOf(34.0, 90.0, 2.02),
    arrayOf(32.0, 85.0, 1.74),
    arrayOf(30.0, 80.0, 1.46),
    arrayOf(28.0, 75.0, 1.17),
    arrayOf(26.0, 65.0, 0.89),
    arrayOf(24.0, 60.0, 0.61),
    arrayOf(22.0, 55.0, 0.32),
    arrayOf(20.0, 50.0, 0.04),
    arrayOf(18.0, 45.0, -0.24),
    arrayOf(16.0, 40.0, -0.53),
    arrayOf(14.0, 35.0, -0.81),
    arrayOf(12.0, 30.0, -1.09),
    arrayOf(10.0, 25.0, -1.38),
    arrayOf(8.0, 20.0, -1.66),
    arrayOf(6.0, 10.0, -1.94),
    arrayOf(4.0, 5.0, -2.23),
    arrayOf(2.0, 1.0, -2.51),
)

/**
 * II. Razonamiento
 * C. Razonamiento Espacial
 * Page 42
 */
fun razonamientoEspacialE7M2Baremo() = arrayOf(
    arrayOf(38.0, 99.0, 2.05),
    arrayOf(36.0, 97.0, 1.82),
    arrayOf(34.0, 95.0, 1.58),
    arrayOf(32.0, 90.0, 1.35),
    arrayOf(30.0, 80.0, 1.11),
    arrayOf(28.0, 70.0, 0.88),
    arrayOf(26.0, 60.0, 0.64),
    arrayOf(24.0, 55.0, 0.41),
    arrayOf(22.0, 50.0, 0.17),
    arrayOf(20.0, 45.0, -0.06),
    arrayOf(18.0, 40.0, -0.3),
    arrayOf(16.0, 35.0, -0.53),
    arrayOf(14.0, 30.0, -0.77),
    arrayOf(12.0, 25.0, -1.0),
    arrayOf(10.0, 20.0, -1.24),
    arrayOf(8.0, 15.0, -1.47),
    arrayOf(6.0, 10.0, -1.71),
    arrayOf(4.0, 5.0, -1.94),
    arrayOf(2.0, 1.0, -2.18),
)


/**
 * III. Niveles de Adaptacion
 * A. Motivacion
 * Page 42
 */
fun motivacionFragmentE7M3Baremo() = arrayOf(
    arrayOf(0.0, 99.0, 2.12),
    arrayOf(2.0, 95.0, 1.85),
    arrayOf(4.0, 90.0, 1.59),
    arrayOf(5.0, 85.0, 1.46),
    arrayOf(6.0, 80.0, 1.33),
    arrayOf(8.0, 75.0, 1.06),
    arrayOf(9.0, 70.0, 0.93),
    arrayOf(11.0, 60.0, 0.67),
    arrayOf(14.0, 50.0, 0.27),
    arrayOf(19.0, 40.0, -0.39),
    arrayOf(24.0, 30.0, -1.05),
    arrayOf(25.0, 25.0, -1.18),
    arrayOf(26.0, 20.0, -1.31),
    arrayOf(29.0, 15.0, -1.71),
    arrayOf(31.0, 10.0, -1.97),
    arrayOf(37.0, 5.0, -2.76),
    arrayOf(45.0, 1.0, -3.82),
)

/**
 * III. Niveles de Adaptacion
 * B. AutoControl
 * Page 42
 */
fun autoControlFragmentE7M3Baremo() = arrayOf(
    arrayOf(0.0, 99.0, 2.1),
    arrayOf(3.0, 95.0, 1.46),
    arrayOf(4.0, 90.0, 1.25),
    arrayOf(5.0, 85.0, 1.04),
    arrayOf(6.0, 80.0, 0.83),
    arrayOf(7.0, 75.0, 0.62),
    arrayOf(8.0, 70.0, 0.4),
    arrayOf(9.0, 60.0, 0.19),
    arrayOf(11.0, 50.0, -0.23),
    arrayOf(13.0, 40.0, -0.65),
    arrayOf(16.0, 30.0, -1.29),
    arrayOf(18.0, 25.0, -1.71),
    arrayOf(19.0, 20.0, -1.93),
    arrayOf(21.0, 15.0, -2.35),
    arrayOf(23.0, 10.0, -2.77),
    arrayOf(25.0, 5.0, -3.2),
    arrayOf(30.0, 1.0, -4.26),
)

/**
 * III. Niveles de Adaptacion
 * C. Prosocial
 * Page 42
 */
fun conductaProSocialFragmentE7M3Baremo() = arrayOf(
    arrayOf(0.0, 99.0, 1.85),
    arrayOf(2.0, 95.0, 1.43),
    arrayOf(3.0, 90.0, 1.22),
    arrayOf(4.0, 85.0, 1.01),
    arrayOf(5.0, 80.0, 0.8),
    arrayOf(6.0, 75.0, 0.59),
    arrayOf(7.0, 70.0, 0.38),
    arrayOf(8.0, 60.0, 0.17),
    arrayOf(9.0, 50.0, -0.04),
    arrayOf(10.0, 40.0, -0.25),
    arrayOf(12.0, 30.0, -0.67),
    arrayOf(13.0, 25.0, -0.87),
    arrayOf(15.0, 20.0, -1.29),
    arrayOf(17.0, 15.0, -1.71),
    arrayOf(20.0, 10.0, -2.34),
    arrayOf(25.0, 5.0, -3.38),
    arrayOf(30.0, 1.0, -4.43),
)

/**
 * III. Niveles de Adaptacion
 * D. Autoestima
 * Page 42
 */
fun autoEstimaFragmentE7M3Baremo() = arrayOf(
    arrayOf(0.0, 99.0, 2.54),
    arrayOf(1.0, 95.0, 2.32),
    arrayOf(2.0, 90.0, 2.1),
    arrayOf(4.0, 85.0, 1.65),
    arrayOf(6.0, 80.0, 1.21),
    arrayOf(8.0, 75.0, 0.76),
    arrayOf(9.0, 70.0, 0.54),
    arrayOf(11.0, 60.0, 0.1),
    arrayOf(13.0, 50.0, -0.34),
    arrayOf(14.0, 40.0, -0.57),
    arrayOf(16.0, 30.0, -1.01),
    arrayOf(17.0, 25.0, -1.23),
    arrayOf(19.0, 20.0, -1.67),
    arrayOf(21.0, 15.0, -2.12),
    arrayOf(23.0, 10.0, -2.56),
    arrayOf(25.0, 5.0, -3.0),
    arrayOf(30.0, 1.0, -4.11),
)

/**
 * IV. Lectura
 * A. Eficacia Lectora
 * Page 54
 */
fun eficaciaLectoraE7M4Baremo() = arrayOf(
    arrayOf(23.0, 99.0, 1.43),
    arrayOf(22.0, 90.0, 1.24),
    arrayOf(21.0, 85.0, 1.05),
    arrayOf(20.0, 80.0, 0.86),
    arrayOf(19.0, 70.0, 0.67),
    arrayOf(18.0, 60.0, 0.47),
    arrayOf(17.0, 55.0, 0.28),
    arrayOf(16.0, 50.0, 0.09),
    arrayOf(15.0, 45.0, -0.1),
    arrayOf(14.0, 40.0, -0.29),
    arrayOf(13.0, 35.0, -0.48),
    arrayOf(12.0, 30.0, -0.67),
    arrayOf(11.0, 25.0, -0.86),
    arrayOf(10.0, 22.0, -1.06),
    arrayOf(9.0, 20.0, -1.25),
    arrayOf(8.0, 18.0, -1.44),
    arrayOf(7.0, 15.0, -1.63),
    arrayOf(6.0, 12.0, -1.82),
    arrayOf(5.0, 10.0, -2.01),
    arrayOf(4.0, 7.0, -2.2),
    arrayOf(3.0, 5.0, -2.39),
    arrayOf(2.0, 3.0, -2.59),
    arrayOf(1.0, 1.0, -2.78),
)

/**
 * IV. Lectura
 * B. Comprension Lectora
 * Page 54
 */
fun comprensionLectoraE7M4Baremo() = arrayOf(
    arrayOf(40.0, 99.0, 3.8),
    arrayOf(38.0, 98.0, 3.5),
    arrayOf(36.0, 97.0, 3.2),
    arrayOf(34.0, 96.0, 2.9),
    arrayOf(32.0, 95.0, 2.61),
    arrayOf(30.0, 92.0, 2.31),
    arrayOf(28.0, 90.0, 2.01),
    arrayOf(26.0, 85.0, 1.71),
    arrayOf(24.0, 80.0, 1.41),
    arrayOf(22.0, 70.0, 1.11),
    arrayOf(20.0, 60.0, 0.82),
    arrayOf(18.0, 55.0, 0.52),
    arrayOf(16.0, 50.0, 0.22),
    arrayOf(14.0, 45.0, -0.08),
    arrayOf(12.0, 40.0, -0.38),
    arrayOf(10.0, 30.0, -0.67),
    arrayOf(8.0, 20.0, -0.97),
    arrayOf(6.0, 15.0, -1.27),
    arrayOf(4.0, 10.0, -1.57),
    arrayOf(2.0, 5.0, -1.87),
)

/**
 * IV.- Lectura
 * C. Velocidad Lectora - VelocidadFragment
 * Page 64
 */
fun velocidadFragmentE7M4Baremo() = arrayOf(
    arrayOf(100.0, 99.0, 2.3),
    arrayOf(121.0, 97.0, 2.0),
    arrayOf(135.0, 95.0, 1.79),
    arrayOf(150.0, 90.0, 1.57),
    arrayOf(160.0, 85.0, 1.42),
    arrayOf(170.0, 80.0, 1.28),
    arrayOf(180.0, 75.0, 1.13),
    arrayOf(190.0, 70.0, 0.98),
    arrayOf(210.0, 65.0, 0.69),
    arrayOf(220.0, 60.0, 0.54),
    arrayOf(240.0, 55.0, 0.25),
    arrayOf(250.0, 50.0, 0.1),
    arrayOf(260.0, 40.0, -0.04),
    arrayOf(280.0, 30.0, -0.34),
    arrayOf(300.0, 20.0, -0.63),
    arrayOf(340.0, 10.0, -1.22),
    arrayOf(500.0, 5.0, -3.56),
)

/**
 * IV.- Lectura
 * C. Velocidad Lectora - ComprensionFragment
 * Page 64
 */
fun comprensionFragmentE7M4Baremo() = arrayOf(
    arrayOf(15.0, 99.0, 2.9),
    arrayOf(14.0, 97.0, 2.57),
    arrayOf(13.0, 95.0, 2.24),
    arrayOf(12.0, 90.0, 1.9),
    arrayOf(11.0, 85.0, 1.57),
    arrayOf(10.0, 80.0, 1.24),
    arrayOf(9.0, 75.0, 0.91),
    arrayOf(8.0, 75.0, 0.58),
    arrayOf(7.0, 70.0, 0.25),
    arrayOf(6.0, 65.0, -0.08),
    arrayOf(5.0, 60.0, -0.41),
    arrayOf(4.0, 55.0, -0.75),
    arrayOf(3.0, 55.0, -1.08),
    arrayOf(2.0, 50.0, -1.41),
    arrayOf(1.0, 40.0, -1.74),
    arrayOf(0.0, 30.0, -2.07),
)

/**
 * V. Escritura
 * A. Ortografia Fonectica
 * Page 70
 */
fun ortografiaFoneticaE7M5Baremo() = arrayOf(
    arrayOf(36.0, 99.0, 1.14),
    arrayOf(35.0, 97.0, 1.0),
    arrayOf(34.0, 95.0, 0.86),
    arrayOf(33.0, 90.0, 0.71),
    arrayOf(32.0, 85.0, 0.57),
    arrayOf(31.0, 80.0, 0.43),
    arrayOf(30.0, 70.0, 0.29),
    arrayOf(29.0, 60.0, 0.14),
    arrayOf(28.0, 50.0, 0.0),
    arrayOf(27.0, 40.0, -0.14),
    arrayOf(26.0, 30.0, -0.29),
    arrayOf(25.0, 20.0, -0.43),
    arrayOf(24.0, 15.0, -0.57),
    arrayOf(22.0, 12.0, -0.86),
    arrayOf(20.0, 10.0, -1.14),
    arrayOf(18.0, 9.0, -1.43),
    arrayOf(16.0, 7.0, -1.71),
    arrayOf(14.0, 5.0, -2.0),
    arrayOf(12.0, 3.0, -2.28),
    arrayOf(10.0, 1.0, -2.57),
)

/**
 * V. Escritura
 * B. Expresion Escrita
 * Page 74
 */
fun expresionEscritaE7M5Baremo() = arrayOf(
    arrayOf(5.0, 10.0, -3.02),
    arrayOf(4.0, 30.0, -1.84),
    arrayOf(3.0, 50.0, -0.65),
    arrayOf(2.0, 70.0, 0.53),
    arrayOf(1.0, 90.0, 1.72),
)

/**
 * V. Escritura
 * C. Ortografia Visual Reglada
 * Page 78
 */
fun ortografiaVisualRegladaE7M5Baremo() = arrayOf(
    arrayOf(80.0, 99.0, 2.61),
    arrayOf(78.0, 98.0, 2.47),
    arrayOf(76.0, 97.0, 2.33),
    arrayOf(74.0, 95.0, 2.19),
    arrayOf(72.0, 92.0, 2.06),
    arrayOf(70.0, 90.0, 1.92),
    arrayOf(68.0, 87.0, 1.78),
    arrayOf(66.0, 85.0, 1.64),
    arrayOf(64.0, 82.0, 1.5),
    arrayOf(62.0, 80.0, 1.37),
    arrayOf(60.0, 77.0, 1.23),
    arrayOf(58.0, 75.0, 1.09),
    arrayOf(56.0, 72.0, 0.95),
    arrayOf(54.0, 70.0, 0.81),
    arrayOf(52.0, 65.0, 0.68),
    arrayOf(50.0, 60.0, 0.54),
    arrayOf(48.0, 55.0, 0.4),
    arrayOf(44.0, 50.0, 0.12),
    arrayOf(40.0, 45.0, -0.15),
    arrayOf(36.0, 40.0, -0.43),
    arrayOf(32.0, 35.0, -0.7),
    arrayOf(28.0, 30.0, -0.98),
    arrayOf(24.0, 25.0, -1.26),
    arrayOf(20.0, 20.0, -1.53),
    arrayOf(16.0, 15.0, -1.81),
    arrayOf(12.0, 10.0, -2.08),
    arrayOf(8.0, 5.0, -2.36),
    arrayOf(4.0, 1.0, -2.64),
)

/**
 * VI. Aprendizaje Matematico
 * A. Calculo y Numeracion
 * Page 82
 */
fun calculoNumeracionE7M6Baremo() = arrayOf(
    arrayOf(79.0, 99.0, 3.69),
    arrayOf(76.0, 98.0, 3.44),
    arrayOf(73.0, 97.0, 3.2),
    arrayOf(70.0, 96.0, 2.95),
    arrayOf(67.0, 95.0, 2.71),
    arrayOf(64.0, 92.0, 2.47),
    arrayOf(61.0, 90.0, 2.22),
    arrayOf(58.0, 87.0, 1.98),
    arrayOf(55.0, 85.0, 1.73),
    arrayOf(52.0, 82.0, 1.49),
    arrayOf(49.0, 80.0, 1.24),
    arrayOf(46.0, 75.0, 1.0),
    arrayOf(43.0, 70.0, 0.76),
    arrayOf(40.0, 65.0, 0.51),
    arrayOf(37.0, 60.0, 0.27),
    arrayOf(34.0, 50.0, 0.02),
    arrayOf(31.0, 40.0, -0.22),
    arrayOf(28.0, 35.0, -0.46),
    arrayOf(25.0, 30.0, -0.71),
    arrayOf(22.0, 25.0, -0.95),
    arrayOf(19.0, 20.0, -1.2),
    arrayOf(16.0, 17.0, -1.44),
    arrayOf(13.0, 15.0, -1.68),
    arrayOf(10.0, 10.0, -1.93),
    arrayOf(7.0, 5.0, -2.17),
    arrayOf(4.0, 3.0, -2.42),
    arrayOf(1.0, 1.0, -2.66),
)

/**
 * VI. Aprendizaje Matematico
 * B. Resolucion de Problemas
 * Page 87
 */
fun resolucionProblemasE7M6Baremo() = arrayOf(
    arrayOf(58.0, 99.0, 5.51),
    arrayOf(55.0, 98.0, 5.16),
    arrayOf(52.0, 97.0, 4.81),
    arrayOf(49.0, 96.0, 4.47),
    arrayOf(46.0, 95.0, 4.12),
    arrayOf(43.0, 94.0, 3.77),
    arrayOf(40.0, 93.0, 3.42),
    arrayOf(37.0, 92.0, 3.07),
    arrayOf(34.0, 91.0, 2.73),
    arrayOf(31.0, 90.0, 2.38),
    arrayOf(28.0, 87.0, 2.03),
    arrayOf(25.0, 85.0, 1.68),
    arrayOf(22.0, 82.0, 1.33),
    arrayOf(19.0, 80.0, 0.98),
    arrayOf(16.0, 70.0, 0.64),
    arrayOf(13.0, 60.0, 0.29),
    arrayOf(10.0, 50.0, -0.06),
    arrayOf(8.0, 40.0, -0.29),
    arrayOf(6.0, 30.0, -0.52),
    arrayOf(4.0, 20.0, -0.76),
    arrayOf(2.0, 10.0, -0.99),
)
