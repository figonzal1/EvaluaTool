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
import cl.figonzal.evaluatool.domain.baremo_tables.constants.Evalua7Constants
import cl.figonzal.evaluatool.domain.baremo_tables.constants.Evalua7Constants.ATENCION_CONCENTRACION_E7M1
import cl.figonzal.evaluatool.domain.baremo_tables.constants.Evalua7Constants.AUTO_CONTROL_FRAGMENT_E7M3
import cl.figonzal.evaluatool.domain.baremo_tables.constants.Evalua7Constants.AUTO_ESTIMA_FRAGMENT_E7M3
import cl.figonzal.evaluatool.domain.baremo_tables.constants.Evalua7Constants.CALCULO_NUMERACION_E7M6
import cl.figonzal.evaluatool.domain.baremo_tables.constants.Evalua7Constants.COMPRENSION_FRAGMENT_E7M4
import cl.figonzal.evaluatool.domain.baremo_tables.constants.Evalua7Constants.COMPRENSION_LECTORA_E7M4
import cl.figonzal.evaluatool.domain.baremo_tables.constants.Evalua7Constants.CONDUCTA_PRO_SOCIAL_E7M3
import cl.figonzal.evaluatool.domain.baremo_tables.constants.Evalua7Constants.EFICACIA_LECTORA_E7M4
import cl.figonzal.evaluatool.domain.baremo_tables.constants.Evalua7Constants.EXPRESION_ESCRITA_E7M5
import cl.figonzal.evaluatool.domain.baremo_tables.constants.Evalua7Constants.MOTIVACION_FRAGMENT_E7M3
import cl.figonzal.evaluatool.domain.baremo_tables.constants.Evalua7Constants.ORTOGRAFIA_FONETICA_E7M5
import cl.figonzal.evaluatool.domain.baremo_tables.constants.Evalua7Constants.ORTOGRAFIA_VISUAL_REGLADA_E7M5
import cl.figonzal.evaluatool.domain.baremo_tables.constants.Evalua7Constants.RAZONAMIENTO_DEDUCTIVO_E7M2
import cl.figonzal.evaluatool.domain.baremo_tables.constants.Evalua7Constants.RAZONAMIENTO_ESPACIAL_E7M2
import cl.figonzal.evaluatool.domain.baremo_tables.constants.Evalua7Constants.RAZONAMIENTO_INDUCTIVO_E7M2
import cl.figonzal.evaluatool.domain.baremo_tables.constants.Evalua7Constants.RESOLUCION_PROBLEMAS_E7M6
import cl.figonzal.evaluatool.domain.baremo_tables.constants.Evalua7Constants.VELOCIDAD_FRAGMENT_E7M4

/**
 * Evalua 7
 */
class Evalua7Baremo : BaremoTable {

    override fun getBaremo(baremo: BaseConstants) = when (baremo as Evalua7Constants) {
        ATENCION_CONCENTRACION_E7M1 -> atencionConcentracionE7M1Baremo()

        RAZONAMIENTO_DEDUCTIVO_E7M2 -> razonamientoDeductivoE7M2Baremo()
        RAZONAMIENTO_INDUCTIVO_E7M2 -> razonamientoInductivoE7M2Baremo()
        RAZONAMIENTO_ESPACIAL_E7M2 -> razonamientoEspacialE7M2Baremo()

        MOTIVACION_FRAGMENT_E7M3 -> motivacionFragmentE7M3Baremo()
        AUTO_CONTROL_FRAGMENT_E7M3 -> autoControlFragmentE7M3Baremo()
        CONDUCTA_PRO_SOCIAL_E7M3 -> conductaProSocialFragmentE7M3Baremo()
        AUTO_ESTIMA_FRAGMENT_E7M3 -> autoEstimaFragmentE7M3Baremo()

        EFICACIA_LECTORA_E7M4 -> eficaciaLectoraE7M4Baremo()
        COMPRENSION_LECTORA_E7M4 -> comprensionLectoraE7M4Baremo()
        VELOCIDAD_FRAGMENT_E7M4 -> velocidadFragmentE7M4Baremo()
        COMPRENSION_FRAGMENT_E7M4 -> comprensionFragmentE7M4Baremo()

        ORTOGRAFIA_FONETICA_E7M5 -> ortografiaFoneticaE7M5Baremo()
        ORTOGRAFIA_VISUAL_REGLADA_E7M5 -> ortografiaVisualRegladaE7M5Baremo()
        EXPRESION_ESCRITA_E7M5 -> expresionEscritaE7M5Baremo()

        CALCULO_NUMERACION_E7M6 -> calculoNumeracionE7M6Baremo()
        RESOLUCION_PROBLEMAS_E7M6 -> resolucionProblemasE7M6Baremo()
    }
}

/**
 * I.- Atencion - Concentracion
 *
 * Page 25
 */
fun atencionConcentracionE7M1Baremo() = arrayOf(
    doubleArrayOf(191.0, 99.0, 2.69),
    doubleArrayOf(190.0, 99.0, 2.65),
    doubleArrayOf(189.0, 99.0, 2.61),
    doubleArrayOf(188.0, 99.0, 2.58),
    doubleArrayOf(187.0, 99.0, 2.54),
    doubleArrayOf(186.0, 99.0, 2.51),
    doubleArrayOf(185.0, 99.0, 2.47),
    doubleArrayOf(184.0, 95.0, 2.44),
    doubleArrayOf(183.0, 95.0, 2.4),
    doubleArrayOf(182.0, 95.0, 2.37),
    doubleArrayOf(181.0, 95.0, 2.33),
    doubleArrayOf(180.0, 95.0, 2.29),
    doubleArrayOf(179.0, 90.0, 2.26),
    doubleArrayOf(178.0, 90.0, 2.22),
    doubleArrayOf(177.0, 90.0, 2.19),
    doubleArrayOf(176.0, 90.0, 2.15),
    doubleArrayOf(175.0, 90.0, 2.12),
    doubleArrayOf(174.0, 87.0, 2.08),
    doubleArrayOf(173.0, 87.0, 2.04),
    doubleArrayOf(172.0, 87.0, 2.01),
    doubleArrayOf(171.0, 87.0, 1.97),
    doubleArrayOf(170.0, 87.0, 1.94),
    doubleArrayOf(169.0, 85.0, 1.9),
    doubleArrayOf(168.0, 85.0, 1.87),
    doubleArrayOf(167.0, 85.0, 1.83),
    doubleArrayOf(166.0, 85.0, 1.79),
    doubleArrayOf(165.0, 85.0, 1.76),
    doubleArrayOf(164.0, 80.0, 1.72),
    doubleArrayOf(163.0, 80.0, 1.69),
    doubleArrayOf(162.0, 80.0, 1.65),
    doubleArrayOf(161.0, 80.0, 1.62),
    doubleArrayOf(160.0, 80.0, 1.58),
    doubleArrayOf(159.0, 78.0, 1.54),
    doubleArrayOf(158.0, 78.0, 1.51),
    doubleArrayOf(157.0, 78.0, 1.47),
    doubleArrayOf(156.0, 78.0, 1.44),
    doubleArrayOf(155.0, 78.0, 1.4),
    doubleArrayOf(154.0, 75.0, 1.37),
    doubleArrayOf(153.0, 75.0, 1.33),
    doubleArrayOf(152.0, 75.0, 1.3),
    doubleArrayOf(151.0, 75.0, 1.26),
    doubleArrayOf(150.0, 75.0, 1.22),
    doubleArrayOf(149.0, 72.0, 1.19),
    doubleArrayOf(148.0, 72.0, 1.15),
    doubleArrayOf(147.0, 72.0, 1.12),
    doubleArrayOf(146.0, 72.0, 1.08),
    doubleArrayOf(145.0, 72.0, 1.05),
    doubleArrayOf(144.0, 70.0, 1.01),
    doubleArrayOf(143.0, 70.0, 0.97),
    doubleArrayOf(142.0, 70.0, 0.94),
    doubleArrayOf(141.0, 70.0, 0.9),
    doubleArrayOf(140.0, 70.0, 0.87),
    doubleArrayOf(139.0, 65.0, 0.83),
    doubleArrayOf(138.0, 65.0, 0.8),
    doubleArrayOf(137.0, 65.0, 0.76),
    doubleArrayOf(136.0, 65.0, 0.72),
    doubleArrayOf(135.0, 65.0, 0.69),
    doubleArrayOf(134.0, 63.0, 0.65),
    doubleArrayOf(133.0, 63.0, 0.62),
    doubleArrayOf(132.0, 63.0, 0.58),
    doubleArrayOf(131.0, 63.0, 0.55),
    doubleArrayOf(130.0, 63.0, 0.51),
    doubleArrayOf(129.0, 60.0, 0.48),
    doubleArrayOf(128.0, 60.0, 0.44),
    doubleArrayOf(127.0, 60.0, 0.4),
    doubleArrayOf(126.0, 60.0, 0.37),
    doubleArrayOf(125.0, 60.0, 0.33),
    doubleArrayOf(124.0, 55.0, 0.3),
    doubleArrayOf(123.0, 55.0, 0.26),
    doubleArrayOf(122.0, 55.0, 0.23),
    doubleArrayOf(121.0, 55.0, 0.19),
    doubleArrayOf(120.0, 55.0, 0.15),
    doubleArrayOf(119.0, 50.0, 0.12),
    doubleArrayOf(118.0, 50.0, 0.08),
    doubleArrayOf(117.0, 50.0, 0.05),
    doubleArrayOf(116.0, 50.0, 0.01),
    doubleArrayOf(115.0, 50.0, -0.02),
    doubleArrayOf(114.0, 45.0, -0.06),
    doubleArrayOf(113.0, 45.0, -0.1),
    doubleArrayOf(112.0, 45.0, -0.13),
    doubleArrayOf(111.0, 45.0, -0.17),
    doubleArrayOf(110.0, 45.0, -0.2),
    doubleArrayOf(109.0, 40.0, -0.24),
    doubleArrayOf(108.0, 40.0, -0.27),
    doubleArrayOf(107.0, 40.0, -0.31),
    doubleArrayOf(106.0, 40.0, -0.35),
    doubleArrayOf(105.0, 40.0, -0.38),
    doubleArrayOf(104.0, 35.0, -0.42),
    doubleArrayOf(103.0, 35.0, -0.45),
    doubleArrayOf(102.0, 35.0, -0.49),
    doubleArrayOf(101.0, 35.0, -0.52),
    doubleArrayOf(100.0, 35.0, -0.56),
    doubleArrayOf(99.0, 30.0, -0.59),
    doubleArrayOf(98.0, 30.0, -0.63),
    doubleArrayOf(97.0, 30.0, -0.67),
    doubleArrayOf(96.0, 30.0, -0.7),
    doubleArrayOf(95.0, 30.0, -0.74),
    doubleArrayOf(94.0, 25.0, -0.77),
    doubleArrayOf(93.0, 25.0, -0.81),
    doubleArrayOf(92.0, 25.0, -0.84),
    doubleArrayOf(91.0, 25.0, -0.88),
    doubleArrayOf(90.0, 25.0, -0.92),
    doubleArrayOf(89.0, 18.0, -0.95),
    doubleArrayOf(88.0, 18.0, -0.99),
    doubleArrayOf(87.0, 18.0, -1.02),
    doubleArrayOf(86.0, 18.0, -1.06),
    doubleArrayOf(85.0, 18.0, -1.09),
    doubleArrayOf(84.0, 15.0, -1.13),
    doubleArrayOf(83.0, 15.0, -1.17),
    doubleArrayOf(82.0, 15.0, -1.2),
    doubleArrayOf(81.0, 15.0, -1.24),
    doubleArrayOf(80.0, 15.0, -1.27),
    doubleArrayOf(79.0, 12.0, -1.31),
    doubleArrayOf(78.0, 12.0, -1.34),
    doubleArrayOf(77.0, 12.0, -1.38),
    doubleArrayOf(76.0, 12.0, -1.42),
    doubleArrayOf(75.0, 12.0, -1.45),
    doubleArrayOf(74.0, 10.0, -1.49),
    doubleArrayOf(73.0, 10.0, -1.52),
    doubleArrayOf(72.0, 10.0, -1.56),
    doubleArrayOf(71.0, 10.0, -1.59),
    doubleArrayOf(70.0, 10.0, -1.63),
    doubleArrayOf(69.0, 9.0, -1.66),
    doubleArrayOf(68.0, 9.0, -1.7),
    doubleArrayOf(67.0, 9.0, -1.74),
    doubleArrayOf(66.0, 9.0, -1.77),
    doubleArrayOf(65.0, 9.0, -1.81),
    doubleArrayOf(64.0, 7.0, -1.84),
    doubleArrayOf(63.0, 7.0, -1.88),
    doubleArrayOf(62.0, 7.0, -1.91),
    doubleArrayOf(61.0, 7.0, -1.95),
    doubleArrayOf(60.0, 7.0, -1.99),
    doubleArrayOf(59.0, 5.0, -2.02),
    doubleArrayOf(58.0, 5.0, -2.06),
    doubleArrayOf(57.0, 5.0, -2.09),
    doubleArrayOf(56.0, 5.0, -2.13),
    doubleArrayOf(55.0, 5.0, -2.16),
    doubleArrayOf(54.0, 3.0, -2.2),
    doubleArrayOf(53.0, 3.0, -2.24),
    doubleArrayOf(52.0, 3.0, -2.27),
    doubleArrayOf(51.0, 3.0, -2.31),
    doubleArrayOf(50.0, 3.0, -2.34),
    doubleArrayOf(49.0, 1.0, -2.38),
    doubleArrayOf(48.0, 1.0, -2.41),
    doubleArrayOf(47.0, 1.0, -2.45),
    doubleArrayOf(46.0, 1.0, -2.49),
    doubleArrayOf(45.0, 1.0, -2.52),
)

/**
 * II. Razonamiento
 * A. Razonamiento Deductivo
 * Page 30
 */
fun razonamientoDeductivoE7M2Baremo() = arrayOf(
    doubleArrayOf(26.0, 99.0, 2.23),
    doubleArrayOf(25.0, 97.0, 2.06),
    doubleArrayOf(24.0, 95.0, 1.9),
    doubleArrayOf(23.0, 90.0, 1.73),
    doubleArrayOf(22.0, 85.0, 1.57),
    doubleArrayOf(21.0, 80.0, 1.4),
    doubleArrayOf(20.0, 75.0, 1.24),
    doubleArrayOf(19.0, 70.0, 1.07),
    doubleArrayOf(18.0, 65.0, 0.91),
    doubleArrayOf(17.0, 62.0, 0.74),
    doubleArrayOf(16.0, 60.0, 0.58),
    doubleArrayOf(15.0, 57.0, 0.41),
    doubleArrayOf(14.0, 55.0, 0.25),
    doubleArrayOf(13.0, 50.0, 0.08),
    doubleArrayOf(12.0, 40.0, -0.08),
    doubleArrayOf(11.0, 30.0, -0.25),
    doubleArrayOf(10.0, 25.0, -0.41),
    doubleArrayOf(9.0, 20.0, -0.58),
    doubleArrayOf(8.0, 15.0, -0.75),
    doubleArrayOf(7.0, 12.0, -0.91),
    doubleArrayOf(6.0, 10.0, -1.08),
    doubleArrayOf(5.0, 7.0, -1.24),
    doubleArrayOf(4.0, 5.0, -1.41),
    doubleArrayOf(3.0, 3.0, -1.57),
    doubleArrayOf(2.0, 2.0, -1.74),
    doubleArrayOf(1.0, 1.0, -1.9),
)

/**
 * II. Razonamiento
 * B. Razonamiento Inductivo
 * Page 35
 */
fun razonamientoInductivoE7M2Baremo() = arrayOf(
    doubleArrayOf(46.0, 99.0, 3.72),
    doubleArrayOf(44.0, 98.0, 3.44),
    doubleArrayOf(42.0, 97.0, 3.16),
    doubleArrayOf(40.0, 96.0, 2.87),
    doubleArrayOf(38.0, 95.0, 2.59),
    doubleArrayOf(36.0, 92.0, 2.31),
    doubleArrayOf(34.0, 90.0, 2.02),
    doubleArrayOf(32.0, 85.0, 1.74),
    doubleArrayOf(30.0, 80.0, 1.46),
    doubleArrayOf(28.0, 75.0, 1.17),
    doubleArrayOf(26.0, 65.0, 0.89),
    doubleArrayOf(24.0, 60.0, 0.61),
    doubleArrayOf(22.0, 55.0, 0.32),
    doubleArrayOf(20.0, 50.0, 0.04),
    doubleArrayOf(18.0, 45.0, -0.24),
    doubleArrayOf(16.0, 40.0, -0.53),
    doubleArrayOf(14.0, 35.0, -0.81),
    doubleArrayOf(12.0, 30.0, -1.09),
    doubleArrayOf(10.0, 25.0, -1.38),
    doubleArrayOf(8.0, 20.0, -1.66),
    doubleArrayOf(6.0, 10.0, -1.94),
    doubleArrayOf(4.0, 5.0, -2.23),
    doubleArrayOf(2.0, 1.0, -2.51),
)

/**
 * II. Razonamiento
 * C. Razonamiento Espacial
 * Page 42
 */
fun razonamientoEspacialE7M2Baremo() = arrayOf(
    doubleArrayOf(38.0, 99.0, 2.05),
    doubleArrayOf(36.0, 97.0, 1.82),
    doubleArrayOf(34.0, 95.0, 1.58),
    doubleArrayOf(32.0, 90.0, 1.35),
    doubleArrayOf(30.0, 80.0, 1.11),
    doubleArrayOf(28.0, 70.0, 0.88),
    doubleArrayOf(26.0, 60.0, 0.64),
    doubleArrayOf(24.0, 55.0, 0.41),
    doubleArrayOf(22.0, 50.0, 0.17),
    doubleArrayOf(20.0, 45.0, -0.06),
    doubleArrayOf(18.0, 40.0, -0.3),
    doubleArrayOf(16.0, 35.0, -0.53),
    doubleArrayOf(14.0, 30.0, -0.77),
    doubleArrayOf(12.0, 25.0, -1.0),
    doubleArrayOf(10.0, 20.0, -1.24),
    doubleArrayOf(8.0, 15.0, -1.47),
    doubleArrayOf(6.0, 10.0, -1.71),
    doubleArrayOf(4.0, 5.0, -1.94),
    doubleArrayOf(2.0, 1.0, -2.18),
)


/**
 * III. Niveles de Adaptacion
 * A. Motivacion
 * Page 42
 */
fun motivacionFragmentE7M3Baremo() = arrayOf(
    doubleArrayOf(0.0, 99.0, 2.12),
    doubleArrayOf(2.0, 95.0, 1.85),
    doubleArrayOf(4.0, 90.0, 1.59),
    doubleArrayOf(5.0, 85.0, 1.46),
    doubleArrayOf(6.0, 80.0, 1.33),
    doubleArrayOf(8.0, 75.0, 1.06),
    doubleArrayOf(9.0, 70.0, 0.93),
    doubleArrayOf(11.0, 60.0, 0.67),
    doubleArrayOf(14.0, 50.0, 0.27),
    doubleArrayOf(19.0, 40.0, -0.39),
    doubleArrayOf(24.0, 30.0, -1.05),
    doubleArrayOf(25.0, 25.0, -1.18),
    doubleArrayOf(26.0, 20.0, -1.31),
    doubleArrayOf(29.0, 15.0, -1.71),
    doubleArrayOf(31.0, 10.0, -1.97),
    doubleArrayOf(37.0, 5.0, -2.76),
    doubleArrayOf(45.0, 1.0, -3.82),
)

/**
 * III. Niveles de Adaptacion
 * B. AutoControl
 * Page 42
 */
fun autoControlFragmentE7M3Baremo() = arrayOf(
    doubleArrayOf(0.0, 99.0, 2.1),
    doubleArrayOf(3.0, 95.0, 1.46),
    doubleArrayOf(4.0, 90.0, 1.25),
    doubleArrayOf(5.0, 85.0, 1.04),
    doubleArrayOf(6.0, 80.0, 0.83),
    doubleArrayOf(7.0, 75.0, 0.62),
    doubleArrayOf(8.0, 70.0, 0.4),
    doubleArrayOf(9.0, 60.0, 0.19),
    doubleArrayOf(11.0, 50.0, -0.23),
    doubleArrayOf(13.0, 40.0, -0.65),
    doubleArrayOf(16.0, 30.0, -1.29),
    doubleArrayOf(18.0, 25.0, -1.71),
    doubleArrayOf(19.0, 20.0, -1.93),
    doubleArrayOf(21.0, 15.0, -2.35),
    doubleArrayOf(23.0, 10.0, -2.77),
    doubleArrayOf(25.0, 5.0, -3.2),
    doubleArrayOf(30.0, 1.0, -4.26),
)

/**
 * III. Niveles de Adaptacion
 * C. Prosocial
 * Page 42
 */
fun conductaProSocialFragmentE7M3Baremo() = arrayOf(
    doubleArrayOf(0.0, 99.0, 1.85),
    doubleArrayOf(2.0, 95.0, 1.43),
    doubleArrayOf(3.0, 90.0, 1.22),
    doubleArrayOf(4.0, 85.0, 1.01),
    doubleArrayOf(5.0, 80.0, 0.8),
    doubleArrayOf(6.0, 75.0, 0.59),
    doubleArrayOf(7.0, 70.0, 0.38),
    doubleArrayOf(8.0, 60.0, 0.17),
    doubleArrayOf(9.0, 50.0, -0.04),
    doubleArrayOf(10.0, 40.0, -0.25),
    doubleArrayOf(12.0, 30.0, -0.67),
    doubleArrayOf(13.0, 25.0, -0.87),
    doubleArrayOf(15.0, 20.0, -1.29),
    doubleArrayOf(17.0, 15.0, -1.71),
    doubleArrayOf(20.0, 10.0, -2.34),
    doubleArrayOf(25.0, 5.0, -3.38),
    doubleArrayOf(30.0, 1.0, -4.43),
)

/**
 * III. Niveles de Adaptacion
 * D. Autoestima
 * Page 42
 */
fun autoEstimaFragmentE7M3Baremo() = arrayOf(
    doubleArrayOf(0.0, 99.0, 2.54),
    doubleArrayOf(1.0, 95.0, 2.32),
    doubleArrayOf(2.0, 90.0, 2.1),
    doubleArrayOf(4.0, 85.0, 1.65),
    doubleArrayOf(6.0, 80.0, 1.21),
    doubleArrayOf(8.0, 75.0, 0.76),
    doubleArrayOf(9.0, 70.0, 0.54),
    doubleArrayOf(11.0, 60.0, 0.1),
    doubleArrayOf(13.0, 50.0, -0.34),
    doubleArrayOf(14.0, 40.0, -0.57),
    doubleArrayOf(16.0, 30.0, -1.01),
    doubleArrayOf(17.0, 25.0, -1.23),
    doubleArrayOf(19.0, 20.0, -1.67),
    doubleArrayOf(21.0, 15.0, -2.12),
    doubleArrayOf(23.0, 10.0, -2.56),
    doubleArrayOf(25.0, 5.0, -3.0),
    doubleArrayOf(30.0, 1.0, -4.11),
)

/**
 * IV. Lectura
 * A. Eficacia Lectora
 * Page 54
 */
fun eficaciaLectoraE7M4Baremo() = arrayOf(
    doubleArrayOf(23.0, 99.0, 1.43),
    doubleArrayOf(22.0, 90.0, 1.24),
    doubleArrayOf(21.0, 85.0, 1.05),
    doubleArrayOf(20.0, 80.0, 0.86),
    doubleArrayOf(19.0, 70.0, 0.67),
    doubleArrayOf(18.0, 60.0, 0.47),
    doubleArrayOf(17.0, 55.0, 0.28),
    doubleArrayOf(16.0, 50.0, 0.09),
    doubleArrayOf(15.0, 45.0, -0.1),
    doubleArrayOf(14.0, 40.0, -0.29),
    doubleArrayOf(13.0, 35.0, -0.48),
    doubleArrayOf(12.0, 30.0, -0.67),
    doubleArrayOf(11.0, 25.0, -0.86),
    doubleArrayOf(10.0, 22.0, -1.06),
    doubleArrayOf(9.0, 20.0, -1.25),
    doubleArrayOf(8.0, 18.0, -1.44),
    doubleArrayOf(7.0, 15.0, -1.63),
    doubleArrayOf(6.0, 12.0, -1.82),
    doubleArrayOf(5.0, 10.0, -2.01),
    doubleArrayOf(4.0, 7.0, -2.2),
    doubleArrayOf(3.0, 5.0, -2.39),
    doubleArrayOf(2.0, 3.0, -2.59),
    doubleArrayOf(1.0, 1.0, -2.78),
)

/**
 * IV. Lectura
 * B. Comprension Lectora
 * Page 54
 */
fun comprensionLectoraE7M4Baremo() = arrayOf(
    doubleArrayOf(40.0, 99.0, 3.8),
    doubleArrayOf(38.0, 98.0, 3.5),
    doubleArrayOf(36.0, 97.0, 3.2),
    doubleArrayOf(34.0, 96.0, 2.9),
    doubleArrayOf(32.0, 95.0, 2.61),
    doubleArrayOf(30.0, 92.0, 2.31),
    doubleArrayOf(28.0, 90.0, 2.01),
    doubleArrayOf(26.0, 85.0, 1.71),
    doubleArrayOf(24.0, 80.0, 1.41),
    doubleArrayOf(22.0, 70.0, 1.11),
    doubleArrayOf(20.0, 60.0, 0.82),
    doubleArrayOf(18.0, 55.0, 0.52),
    doubleArrayOf(16.0, 50.0, 0.22),
    doubleArrayOf(14.0, 45.0, -0.08),
    doubleArrayOf(12.0, 40.0, -0.38),
    doubleArrayOf(10.0, 30.0, -0.67),
    doubleArrayOf(8.0, 20.0, -0.97),
    doubleArrayOf(6.0, 15.0, -1.27),
    doubleArrayOf(4.0, 10.0, -1.57),
    doubleArrayOf(2.0, 5.0, -1.87),
)

/**
 * IV.- Lectura
 * C. Velocidad Lectora - VelocidadFragment
 * Page 64
 */
fun velocidadFragmentE7M4Baremo() = arrayOf(
    doubleArrayOf(100.0, 99.0, 2.3),
    doubleArrayOf(121.0, 97.0, 2.0),
    doubleArrayOf(135.0, 95.0, 1.79),
    doubleArrayOf(150.0, 90.0, 1.57),
    doubleArrayOf(160.0, 85.0, 1.42),
    doubleArrayOf(170.0, 80.0, 1.28),
    doubleArrayOf(180.0, 75.0, 1.13),
    doubleArrayOf(190.0, 70.0, 0.98),
    doubleArrayOf(210.0, 65.0, 0.69),
    doubleArrayOf(220.0, 60.0, 0.54),
    doubleArrayOf(240.0, 55.0, 0.25),
    doubleArrayOf(250.0, 50.0, 0.1),
    doubleArrayOf(260.0, 40.0, -0.04),
    doubleArrayOf(280.0, 30.0, -0.34),
    doubleArrayOf(300.0, 20.0, -0.63),
    doubleArrayOf(340.0, 10.0, -1.22),
    doubleArrayOf(500.0, 5.0, -3.56),
)

/**
 * IV.- Lectura
 * C. Velocidad Lectora - ComprensionFragment
 * Page 64
 */
fun comprensionFragmentE7M4Baremo() = arrayOf(
    doubleArrayOf(15.0, 99.0, 2.9),
    doubleArrayOf(14.0, 97.0, 2.57),
    doubleArrayOf(13.0, 95.0, 2.24),
    doubleArrayOf(12.0, 90.0, 1.9),
    doubleArrayOf(11.0, 85.0, 1.57),
    doubleArrayOf(10.0, 80.0, 1.24),
    doubleArrayOf(9.0, 75.0, 0.91),
    doubleArrayOf(8.0, 75.0, 0.58),
    doubleArrayOf(7.0, 70.0, 0.25),
    doubleArrayOf(6.0, 65.0, -0.08),
    doubleArrayOf(5.0, 60.0, -0.41),
    doubleArrayOf(4.0, 55.0, -0.75),
    doubleArrayOf(3.0, 55.0, -1.08),
    doubleArrayOf(2.0, 50.0, -1.41),
    doubleArrayOf(1.0, 40.0, -1.74),
    doubleArrayOf(0.0, 30.0, -2.07),
)

/**
 * V. Escritura
 * A. Ortografia Fonectica
 * Page 70
 */
fun ortografiaFoneticaE7M5Baremo() = arrayOf(
    doubleArrayOf(36.0, 99.0, 1.14),
    doubleArrayOf(35.0, 97.0, 1.0),
    doubleArrayOf(34.0, 95.0, 0.86),
    doubleArrayOf(33.0, 90.0, 0.71),
    doubleArrayOf(32.0, 85.0, 0.57),
    doubleArrayOf(31.0, 80.0, 0.43),
    doubleArrayOf(30.0, 70.0, 0.29),
    doubleArrayOf(29.0, 60.0, 0.14),
    doubleArrayOf(28.0, 50.0, 0.0),
    doubleArrayOf(27.0, 40.0, -0.14),
    doubleArrayOf(26.0, 30.0, -0.29),
    doubleArrayOf(25.0, 20.0, -0.43),
    doubleArrayOf(24.0, 15.0, -0.57),
    doubleArrayOf(22.0, 12.0, -0.86),
    doubleArrayOf(20.0, 10.0, -1.14),
    doubleArrayOf(18.0, 9.0, -1.43),
    doubleArrayOf(16.0, 7.0, -1.71),
    doubleArrayOf(14.0, 5.0, -2.0),
    doubleArrayOf(12.0, 3.0, -2.28),
    doubleArrayOf(10.0, 1.0, -2.57),
)

/**
 * V. Escritura
 * B. Expresion Escrita
 * Page 74
 */
fun expresionEscritaE7M5Baremo() = arrayOf(
    doubleArrayOf(5.0, 10.0, -3.02),
    doubleArrayOf(4.0, 30.0, -1.84),
    doubleArrayOf(3.0, 50.0, -0.65),
    doubleArrayOf(2.0, 70.0, 0.53),
    doubleArrayOf(1.0, 90.0, 1.72),
)

/**
 * V. Escritura
 * C. Ortografia Visual Reglada
 * Page 78
 */
fun ortografiaVisualRegladaE7M5Baremo() = arrayOf(
    doubleArrayOf(80.0, 99.0, 2.61),
    doubleArrayOf(78.0, 98.0, 2.47),
    doubleArrayOf(76.0, 97.0, 2.33),
    doubleArrayOf(74.0, 95.0, 2.19),
    doubleArrayOf(72.0, 92.0, 2.06),
    doubleArrayOf(70.0, 90.0, 1.92),
    doubleArrayOf(68.0, 87.0, 1.78),
    doubleArrayOf(66.0, 85.0, 1.64),
    doubleArrayOf(64.0, 82.0, 1.5),
    doubleArrayOf(62.0, 80.0, 1.37),
    doubleArrayOf(60.0, 77.0, 1.23),
    doubleArrayOf(58.0, 75.0, 1.09),
    doubleArrayOf(56.0, 72.0, 0.95),
    doubleArrayOf(54.0, 70.0, 0.81),
    doubleArrayOf(52.0, 65.0, 0.68),
    doubleArrayOf(50.0, 60.0, 0.54),
    doubleArrayOf(48.0, 55.0, 0.4),
    doubleArrayOf(44.0, 50.0, 0.12),
    doubleArrayOf(40.0, 45.0, -0.15),
    doubleArrayOf(36.0, 40.0, -0.43),
    doubleArrayOf(32.0, 35.0, -0.7),
    doubleArrayOf(28.0, 30.0, -0.98),
    doubleArrayOf(24.0, 25.0, -1.26),
    doubleArrayOf(20.0, 20.0, -1.53),
    doubleArrayOf(16.0, 15.0, -1.81),
    doubleArrayOf(12.0, 10.0, -2.08),
    doubleArrayOf(8.0, 5.0, -2.36),
    doubleArrayOf(4.0, 1.0, -2.64),
)

/**
 * VI. Aprendizaje Matematico
 * A. Calculo y Numeracion
 * Page 82
 */
fun calculoNumeracionE7M6Baremo() = arrayOf(
    doubleArrayOf(79.0, 99.0, 3.69),
    doubleArrayOf(76.0, 98.0, 3.44),
    doubleArrayOf(73.0, 97.0, 3.2),
    doubleArrayOf(70.0, 96.0, 2.95),
    doubleArrayOf(67.0, 95.0, 2.71),
    doubleArrayOf(64.0, 92.0, 2.47),
    doubleArrayOf(61.0, 90.0, 2.22),
    doubleArrayOf(58.0, 87.0, 1.98),
    doubleArrayOf(55.0, 85.0, 1.73),
    doubleArrayOf(52.0, 82.0, 1.49),
    doubleArrayOf(49.0, 80.0, 1.24),
    doubleArrayOf(46.0, 75.0, 1.0),
    doubleArrayOf(43.0, 70.0, 0.76),
    doubleArrayOf(40.0, 65.0, 0.51),
    doubleArrayOf(37.0, 60.0, 0.27),
    doubleArrayOf(34.0, 50.0, 0.02),
    doubleArrayOf(31.0, 40.0, -0.22),
    doubleArrayOf(28.0, 35.0, -0.46),
    doubleArrayOf(25.0, 30.0, -0.71),
    doubleArrayOf(22.0, 25.0, -0.95),
    doubleArrayOf(19.0, 20.0, -1.2),
    doubleArrayOf(16.0, 17.0, -1.44),
    doubleArrayOf(13.0, 15.0, -1.68),
    doubleArrayOf(10.0, 10.0, -1.93),
    doubleArrayOf(7.0, 5.0, -2.17),
    doubleArrayOf(4.0, 3.0, -2.42),
    doubleArrayOf(1.0, 1.0, -2.66),
)

/**
 * VI. Aprendizaje Matematico
 * B. Resolucion de Problemas
 * Page 87
 */
fun resolucionProblemasE7M6Baremo() = arrayOf(
    doubleArrayOf(58.0, 99.0, 5.51),
    doubleArrayOf(55.0, 98.0, 5.16),
    doubleArrayOf(52.0, 97.0, 4.81),
    doubleArrayOf(49.0, 96.0, 4.47),
    doubleArrayOf(46.0, 95.0, 4.12),
    doubleArrayOf(43.0, 94.0, 3.77),
    doubleArrayOf(40.0, 93.0, 3.42),
    doubleArrayOf(37.0, 92.0, 3.07),
    doubleArrayOf(34.0, 91.0, 2.73),
    doubleArrayOf(31.0, 90.0, 2.38),
    doubleArrayOf(28.0, 87.0, 2.03),
    doubleArrayOf(25.0, 85.0, 1.68),
    doubleArrayOf(22.0, 82.0, 1.33),
    doubleArrayOf(19.0, 80.0, 0.98),
    doubleArrayOf(16.0, 70.0, 0.64),
    doubleArrayOf(13.0, 60.0, 0.29),
    doubleArrayOf(10.0, 50.0, -0.06),
    doubleArrayOf(8.0, 40.0, -0.29),
    doubleArrayOf(6.0, 30.0, -0.52),
    doubleArrayOf(4.0, 20.0, -0.76),
    doubleArrayOf(2.0, 10.0, -0.99),
)
