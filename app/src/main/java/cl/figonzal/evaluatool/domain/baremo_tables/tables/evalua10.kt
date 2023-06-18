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
import cl.figonzal.evaluatool.domain.baremo_tables.constants.Evalua10Constants
import cl.figonzal.evaluatool.domain.baremo_tables.constants.Evalua10Constants.ADAPTACION_ESCOLAR_E10M3
import cl.figonzal.evaluatool.domain.baremo_tables.constants.Evalua10Constants.ADAPTACION_FAMILIAR_E10M3
import cl.figonzal.evaluatool.domain.baremo_tables.constants.Evalua10Constants.ADAPTACION_PERSONAL_E10M3
import cl.figonzal.evaluatool.domain.baremo_tables.constants.Evalua10Constants.ATENCION_CONCENTRACION_E10M1
import cl.figonzal.evaluatool.domain.baremo_tables.constants.Evalua10Constants.CALCULO_NUMERACION_E10M6
import cl.figonzal.evaluatool.domain.baremo_tables.constants.Evalua10Constants.COMPRENSION_FRAGMENT_E10M4
import cl.figonzal.evaluatool.domain.baremo_tables.constants.Evalua10Constants.COMPRENSION_LECTORA_E10M4
import cl.figonzal.evaluatool.domain.baremo_tables.constants.Evalua10Constants.HABILIDADES_SOCIALES_E10M3
import cl.figonzal.evaluatool.domain.baremo_tables.constants.Evalua10Constants.ORTOGRAFIA_VISUAL_REGLADA_E10M5
import cl.figonzal.evaluatool.domain.baremo_tables.constants.Evalua10Constants.RAZONAMIENTO_DEDUCTIVO_E10M2
import cl.figonzal.evaluatool.domain.baremo_tables.constants.Evalua10Constants.RAZONAMIENTO_ESPACIAL_E10M2
import cl.figonzal.evaluatool.domain.baremo_tables.constants.Evalua10Constants.RAZONAMIENTO_INDUCTIVO_E10M2
import cl.figonzal.evaluatool.domain.baremo_tables.constants.Evalua10Constants.RESOLUCION_PROBLEMAS_E10M6
import cl.figonzal.evaluatool.domain.baremo_tables.constants.Evalua10Constants.VELOCIDAD_FRAGMENT_E10M4

/**
 * Evalua 10
 */
class Evalua10Baremo : BaremoTable {

    override fun getBaremo(baremo: BaseConstants) = when (baremo as Evalua10Constants) {
        ATENCION_CONCENTRACION_E10M1 -> atencionConcentracionE10M1Baremo()

        RAZONAMIENTO_INDUCTIVO_E10M2 -> razonamientoInductivoE10M2Baremo()
        RAZONAMIENTO_ESPACIAL_E10M2 -> razonamientoEspacialE10M2Baremo()
        RAZONAMIENTO_DEDUCTIVO_E10M2 -> razonamientoDeductivoE10M2Baremo()

        ADAPTACION_PERSONAL_E10M3 -> adaptacionPersonalFragmentE10M3Baremo()
        ADAPTACION_FAMILIAR_E10M3 -> adaptacionFamiliarFragmentE10M3Baremo()
        ADAPTACION_ESCOLAR_E10M3 -> adaptacionEscolarFragmentE10M3Baremo()
        HABILIDADES_SOCIALES_E10M3 -> habilidadesSocialesFragmentE10M3Baremo()

        COMPRENSION_LECTORA_E10M4 -> comprensionLectoraE10M4Baremo()
        VELOCIDAD_FRAGMENT_E10M4 -> velocidadFragmentE10M4Baremo()
        COMPRENSION_FRAGMENT_E10M4 -> comprensionFragmentE10M4Baremo()

        ORTOGRAFIA_VISUAL_REGLADA_E10M5 -> ortografiaVisualRegladaE10M5Baremo()

        CALCULO_NUMERACION_E10M6 -> calculoNumeracionE10M6Baremo()
        RESOLUCION_PROBLEMAS_E10M6 -> resolucionProblemasE10M6Baremo()
    }
}

/**
 * I.- Atencion - Concentracion
 *
 * Page 29
 */
fun atencionConcentracionE10M1Baremo() = arrayOf(
    doubleArrayOf(165.0, 99.0, 1.21),
    doubleArrayOf(162.0, 95.0, 1.08),
    doubleArrayOf(160.0, 90.0, 1.0),
    doubleArrayOf(157.0, 85.0, 0.88),
    doubleArrayOf(155.0, 80.0, 0.8),
    doubleArrayOf(150.0, 70.0, 0.59),
    doubleArrayOf(145.0, 60.0, 0.38),
    doubleArrayOf(140.0, 55.0, 0.18),
    doubleArrayOf(135.0, 50.0, -0.03),
    doubleArrayOf(130.0, 40.0, -0.23),
    doubleArrayOf(125.0, 30.0, -0.44),
    doubleArrayOf(120.0, 20.0, -0.65),
    doubleArrayOf(115.0, 15.0, -0.85),
    doubleArrayOf(110.0, 10.0, -1.06),
    doubleArrayOf(105.0, 8.0, -1.26),
    doubleArrayOf(100.0, 6.0, -1.47),
    doubleArrayOf(95.0, 5.0, -1.68),
    doubleArrayOf(90.0, 4.0, -1.88),
    doubleArrayOf(85.0, 3.0, -2.09),
    doubleArrayOf(80.0, 2.0, -2.29),
    doubleArrayOf(75.0, 1.0, -2.5),
)

/**
 * II.- Razonamiento
 * A.- Razonamiento Inductivo
 *
 * Page 35
 */
fun razonamientoInductivoE10M2Baremo() = arrayOf(
    doubleArrayOf(25.0, 99.0, 2.24),
    doubleArrayOf(24.0, 97.0, 2.07),
    doubleArrayOf(23.0, 95.0, 1.89),
    doubleArrayOf(22.0, 94.0, 1.72),
    doubleArrayOf(21.0, 92.0, 1.54),
    doubleArrayOf(20.0, 90.0, 1.37),
    doubleArrayOf(19.0, 85.0, 1.19),
    doubleArrayOf(18.0, 80.0, 1.02),
    doubleArrayOf(17.0, 75.0, 0.84),
    doubleArrayOf(16.0, 70.0, 0.67),
    doubleArrayOf(15.0, 65.0, 0.5),
    doubleArrayOf(14.0, 60.0, 0.32),
    doubleArrayOf(13.0, 55.0, 0.15),
    doubleArrayOf(12.0, 50.0, -0.03),
    doubleArrayOf(11.0, 45.0, -0.2),
    doubleArrayOf(10.0, 40.0, -0.38),
    doubleArrayOf(9.0, 35.0, -0.55),
    doubleArrayOf(8.0, 30.0, -0.73),
    doubleArrayOf(7.0, 25.0, -0.9),
    doubleArrayOf(6.0, 20.0, -1.08),
    doubleArrayOf(5.0, 15.0, -1.25),
    doubleArrayOf(4.0, 10.0, -1.42),
    doubleArrayOf(3.0, 7.0, -1.6),
    doubleArrayOf(2.0, 5.0, -1.77),
    doubleArrayOf(1.0, 1.0, -1.95),
)

/**
 * II.- Razonamiento
 * B.- Razonamiento Espacial
 *
 * Page 41
 */
fun razonamientoEspacialE10M2Baremo() = arrayOf(
    doubleArrayOf(22.0, 99.0, 1.52),
    doubleArrayOf(21.0, 95.0, 1.32),
    doubleArrayOf(20.0, 85.0, 1.13),
    doubleArrayOf(19.0, 75.0, 0.93),
    doubleArrayOf(18.0, 70.0, 0.74),
    doubleArrayOf(17.0, 65.0, 0.54),
    doubleArrayOf(16.0, 60.0, 0.35),
    doubleArrayOf(15.0, 55.0, 0.15),
    doubleArrayOf(14.0, 50.0, -0.04),
    doubleArrayOf(13.0, 45.0, -0.24),
    doubleArrayOf(12.0, 40.0, -0.43),
    doubleArrayOf(11.0, 35.0, -0.63),
    doubleArrayOf(10.0, 30.0, -0.82),
    doubleArrayOf(9.0, 25.0, -1.02),
    doubleArrayOf(8.0, 15.0, -1.21),
    doubleArrayOf(7.0, 10.0, -1.41),
    doubleArrayOf(6.0, 5.0, -1.61),
    doubleArrayOf(5.0, 3.0, -1.8),
    doubleArrayOf(4.0, 1.0, -2.0),
)

/**
 * II.- Razonamiento
 * C.- Razonamiento Deductivo
 *
 * Page 45
 */
fun razonamientoDeductivoE10M2Baremo() = arrayOf(
    doubleArrayOf(30.0, 99.0, 2.44),
    doubleArrayOf(29.0, 97.0, 2.28),
    doubleArrayOf(28.0, 95.0, 2.12),
    doubleArrayOf(27.0, 92.0, 1.96),
    doubleArrayOf(26.0, 90.0, 1.8),
    doubleArrayOf(25.0, 87.0, 1.64),
    doubleArrayOf(24.0, 85.0, 1.48),
    doubleArrayOf(23.0, 83.0, 1.32),
    doubleArrayOf(22.0, 80.0, 1.16),
    doubleArrayOf(21.0, 77.0, 1.0),
    doubleArrayOf(20.0, 75.0, 0.84),
    doubleArrayOf(19.0, 70.0, 0.68),
    doubleArrayOf(18.0, 65.0, 0.52),
    doubleArrayOf(17.0, 60.0, 0.36),
    doubleArrayOf(16.0, 55.0, 0.2),
    doubleArrayOf(15.0, 50.0, 0.04),
    doubleArrayOf(14.0, 45.0, -0.12),
    doubleArrayOf(13.0, 40.0, -0.28),
    doubleArrayOf(12.0, 37.0, -0.44),
    doubleArrayOf(11.0, 35.0, -0.6),
    doubleArrayOf(10.0, 30.0, -0.76),
    doubleArrayOf(9.0, 25.0, -0.92),
    doubleArrayOf(8.0, 20.0, -1.08),
    doubleArrayOf(7.0, 15.0, -1.24),
    doubleArrayOf(6.0, 12.0, -1.4),
    doubleArrayOf(5.0, 10.0, -1.56),
    doubleArrayOf(4.0, 7.0, -1.72),
    doubleArrayOf(3.0, 5.0, -1.88),
    doubleArrayOf(2.0, 3.0, -2.04),
    doubleArrayOf(1.0, 2.0, -2.2),
    doubleArrayOf(0.0, 1.0, -2.36),
)

/**
 * III.- Niveles Adaptacion
 * A.- Adaptacion Personal
 *
 * Page 53
 */
fun adaptacionPersonalFragmentE10M3Baremo() = arrayOf(
    doubleArrayOf(0.0, 99.0, 1.65),
    doubleArrayOf(1.0, 99.0, 1.57),
    doubleArrayOf(2.0, 99.0, 1.49),
    doubleArrayOf(3.0, 95.0, 1.41),
    doubleArrayOf(4.0, 95.0, 1.32),
    doubleArrayOf(5.0, 95.0, 1.24),
    doubleArrayOf(6.0, 90.0, 1.16),
    doubleArrayOf(7.0, 90.0, 1.08),
    doubleArrayOf(8.0, 90.0, 1.0),
    doubleArrayOf(9.0, 80.0, 0.92),
    doubleArrayOf(10.0, 80.0, 0.84),
    doubleArrayOf(11.0, 80.0, 0.75),
    doubleArrayOf(12.0, 75.0, 0.67),
    doubleArrayOf(13.0, 75.0, 0.59),
    doubleArrayOf(14.0, 75.0, 0.51),
    doubleArrayOf(15.0, 70.0, 0.43),
    doubleArrayOf(16.0, 70.0, 0.35),
    doubleArrayOf(17.0, 70.0, 0.27),
    doubleArrayOf(18.0, 60.0, 0.18),
    doubleArrayOf(19.0, 60.0, 0.1),
    doubleArrayOf(20.0, 60.0, 0.02),
    doubleArrayOf(21.0, 55.0, -0.06),
    doubleArrayOf(22.0, 55.0, -0.14),
    doubleArrayOf(23.0, 55.0, -0.22),
    doubleArrayOf(24.0, 50.0, -0.3),
    doubleArrayOf(25.0, 50.0, -0.38),
    doubleArrayOf(26.0, 50.0, -0.47),
    doubleArrayOf(27.0, 45.0, -0.55),
    doubleArrayOf(28.0, 45.0, -0.63),
    doubleArrayOf(29.0, 45.0, -0.71),
    doubleArrayOf(30.0, 40.0, -0.79),
    doubleArrayOf(31.0, 40.0, -0.87),
    doubleArrayOf(32.0, 40.0, -0.95),
    doubleArrayOf(33.0, 35.0, -1.04),
    doubleArrayOf(34.0, 35.0, -1.12),
    doubleArrayOf(35.0, 35.0, -1.2),
    doubleArrayOf(36.0, 30.0, -1.28),
    doubleArrayOf(37.0, 30.0, -1.36),
    doubleArrayOf(38.0, 30.0, -1.44),
    doubleArrayOf(39.0, 25.0, -1.52),
    doubleArrayOf(40.0, 25.0, -1.61),
    doubleArrayOf(41.0, 25.0, -1.69),
    doubleArrayOf(42.0, 20.0, -1.77),
    doubleArrayOf(43.0, 20.0, -1.85),
    doubleArrayOf(44.0, 20.0, -1.93),
    doubleArrayOf(45.0, 15.0, -2.01),
    doubleArrayOf(46.0, 15.0, -2.09),
    doubleArrayOf(47.0, 15.0, -2.17),
    doubleArrayOf(48.0, 10.0, -2.26),
    doubleArrayOf(49.0, 10.0, -2.34),
    doubleArrayOf(50.0, 10.0, -2.42),
    doubleArrayOf(51.0, 7.0, -2.5),
    doubleArrayOf(52.0, 7.0, -2.58),
    doubleArrayOf(53.0, 7.0, -2.66),
    doubleArrayOf(54.0, 5.0, -2.74),
    doubleArrayOf(55.0, 5.0, -2.83),
    doubleArrayOf(56.0, 5.0, -2.91),
    doubleArrayOf(57.0, 3.0, -2.99),
    doubleArrayOf(58.0, 3.0, -3.07),
    doubleArrayOf(59.0, 3.0, -3.15),
    doubleArrayOf(60.0, 1.0, -3.23),
)

/**
 * III.- Niveles Adaptacion
 * B.- Adaptacion Familiar
 *
 * Page 53
 */
fun adaptacionFamiliarFragmentE10M3Baremo() = arrayOf(
    doubleArrayOf(0.0, 99.0, 2.4),
    doubleArrayOf(1.0, 99.0, 2.28),
    doubleArrayOf(2.0, 99.0, 2.16),
    doubleArrayOf(3.0, 95.0, 2.05),
    doubleArrayOf(4.0, 95.0, 1.93),
    doubleArrayOf(5.0, 95.0, 1.81),
    doubleArrayOf(6.0, 90.0, 1.69),
    doubleArrayOf(7.0, 90.0, 1.58),
    doubleArrayOf(8.0, 90.0, 1.46),
    doubleArrayOf(9.0, 80.0, 1.34),
    doubleArrayOf(10.0, 80.0, 1.22),
    doubleArrayOf(11.0, 80.0, 1.11),
    doubleArrayOf(12.0, 70.0, 0.99),
    doubleArrayOf(13.0, 70.0, 0.87),
    doubleArrayOf(14.0, 70.0, 0.75),
    doubleArrayOf(15.0, 60.0, 0.64),
    doubleArrayOf(16.0, 60.0, 0.52),
    doubleArrayOf(17.0, 60.0, 0.4),
    doubleArrayOf(18.0, 55.0, 0.28),
    doubleArrayOf(19.0, 55.0, 0.17),
    doubleArrayOf(20.0, 55.0, 0.05),
    doubleArrayOf(21.0, 50.0, -0.07),
    doubleArrayOf(22.0, 50.0, -0.19),
    doubleArrayOf(23.0, 50.0, -0.3),
    doubleArrayOf(24.0, 40.0, -0.42),
    doubleArrayOf(25.0, 40.0, -0.54),
    doubleArrayOf(26.0, 40.0, -0.66),
    doubleArrayOf(27.0, 30.0, -0.77),
    doubleArrayOf(28.0, 30.0, -0.89),
    doubleArrayOf(29.0, 30.0, -1.01),
    doubleArrayOf(30.0, 20.0, -1.13),
    doubleArrayOf(31.0, 20.0, -1.24),
    doubleArrayOf(32.0, 20.0, -1.36),
    doubleArrayOf(33.0, 15.0, -1.48),
    doubleArrayOf(34.0, 15.0, -1.6),
    doubleArrayOf(35.0, 15.0, -1.71),
    doubleArrayOf(36.0, 10.0, -1.83),
    doubleArrayOf(37.0, 10.0, -1.95),
    doubleArrayOf(38.0, 10.0, -2.07),
    doubleArrayOf(39.0, 7.0, -2.18),
    doubleArrayOf(40.0, 7.0, -2.3),
    doubleArrayOf(41.0, 7.0, -2.42),
    doubleArrayOf(42.0, 6.0, -2.54),
    doubleArrayOf(43.0, 6.0, -2.65),
    doubleArrayOf(44.0, 6.0, -2.77),
    doubleArrayOf(45.0, 5.0, -2.89),
    doubleArrayOf(46.0, 5.0, -3.01),
    doubleArrayOf(47.0, 5.0, -3.12),
    doubleArrayOf(48.0, 4.0, -3.24),
    doubleArrayOf(49.0, 4.0, -3.36),
    doubleArrayOf(50.0, 4.0, -3.48),
    doubleArrayOf(51.0, 3.0, -3.59),
    doubleArrayOf(52.0, 3.0, -3.71),
    doubleArrayOf(53.0, 3.0, -3.83),
    doubleArrayOf(54.0, 2.0, -3.95),
    doubleArrayOf(55.0, 2.0, -4.06),
    doubleArrayOf(56.0, 2.0, -4.18),
    doubleArrayOf(57.0, 1.0, -4.3),
    doubleArrayOf(58.0, 1.0, -4.42),
    doubleArrayOf(59.0, 1.0, -4.53),
    doubleArrayOf(60.0, 0.0, -4.65),
)

/**
 * III.- Niveles Adaptacion
 * C.- Adaptacion Escolar
 *
 * Page 53
 */
fun adaptacionEscolarFragmentE10M3Baremo() = arrayOf(
    doubleArrayOf(0.0, 99.0, 2.02),
    doubleArrayOf(1.0, 99.0, 1.93),
    doubleArrayOf(2.0, 99.0, 1.83),
    doubleArrayOf(3.0, 85.0, 1.73),
    doubleArrayOf(4.0, 85.0, 1.63),
    doubleArrayOf(5.0, 85.0, 1.54),
    doubleArrayOf(6.0, 80.0, 1.44),
    doubleArrayOf(7.0, 80.0, 1.34),
    doubleArrayOf(8.0, 80.0, 1.24),
    doubleArrayOf(9.0, 75.0, 1.14),
    doubleArrayOf(10.0, 75.0, 1.05),
    doubleArrayOf(11.0, 75.0, 0.95),
    doubleArrayOf(12.0, 70.0, 0.85),
    doubleArrayOf(13.0, 70.0, 0.75),
    doubleArrayOf(14.0, 70.0, 0.66),
    doubleArrayOf(15.0, 60.0, 0.56),
    doubleArrayOf(16.0, 60.0, 0.46),
    doubleArrayOf(17.0, 60.0, 0.36),
    doubleArrayOf(18.0, 50.0, 0.27),
    doubleArrayOf(19.0, 50.0, 0.17),
    doubleArrayOf(20.0, 50.0, 0.07),
    doubleArrayOf(21.0, 40.0, -0.03),
    doubleArrayOf(22.0, 40.0, -0.13),
    doubleArrayOf(23.0, 40.0, -0.22),
    doubleArrayOf(24.0, 30.0, -0.32),
    doubleArrayOf(25.0, 30.0, -0.42),
    doubleArrayOf(26.0, 30.0, -0.52),
    doubleArrayOf(27.0, 25.0, -0.61),
    doubleArrayOf(28.0, 25.0, -0.71),
    doubleArrayOf(29.0, 25.0, -0.81),
    doubleArrayOf(30.0, 20.0, -0.91),
    doubleArrayOf(31.0, 20.0, -1.0),
    doubleArrayOf(32.0, 20.0, -1.1),
    doubleArrayOf(33.0, 15.0, -1.2),
    doubleArrayOf(34.0, 15.0, -1.3),
    doubleArrayOf(35.0, 15.0, -1.39),
    doubleArrayOf(36.0, 10.0, -1.49),
    doubleArrayOf(37.0, 10.0, -1.59),
    doubleArrayOf(38.0, 10.0, -1.69),
    doubleArrayOf(39.0, 8.0, -1.79),
    doubleArrayOf(40.0, 8.0, -1.88),
    doubleArrayOf(41.0, 8.0, -1.98),
    doubleArrayOf(42.0, 7.0, -2.08),
    doubleArrayOf(43.0, 7.0, -2.18),
    doubleArrayOf(44.0, 7.0, -2.27),
    doubleArrayOf(45.0, 6.0, -2.37),
    doubleArrayOf(46.0, 6.0, -2.47),
    doubleArrayOf(47.0, 6.0, -2.57),
    doubleArrayOf(48.0, 4.0, -2.66),
    doubleArrayOf(49.0, 4.0, -2.76),
    doubleArrayOf(50.0, 4.0, -2.86),
    doubleArrayOf(51.0, 3.0, -2.96),
    doubleArrayOf(52.0, 3.0, -3.05),
    doubleArrayOf(53.0, 3.0, -3.15),
    doubleArrayOf(54.0, 2.0, -3.25),
    doubleArrayOf(55.0, 2.0, -3.35),
    doubleArrayOf(56.0, 2.0, -3.45),
    doubleArrayOf(57.0, 1.0, -3.54),
    doubleArrayOf(58.0, 1.0, -3.64),
    doubleArrayOf(59.0, 1.0, -3.74),
    doubleArrayOf(60.0, 0.0, -3.84),
)

/**
 * III.- Niveles Adaptacion
 * D.- Habilidades Sociales
 *
 * Page 53
 */
fun habilidadesSocialesFragmentE10M3Baremo() = arrayOf(
    doubleArrayOf(0.0, 99.0, 2.65),
    doubleArrayOf(1.0, 99.0, 2.54),
    doubleArrayOf(2.0, 99.0, 2.43),
    doubleArrayOf(3.0, 95.0, 2.32),
    doubleArrayOf(4.0, 95.0, 2.21),
    doubleArrayOf(5.0, 95.0, 2.1),
    doubleArrayOf(6.0, 90.0, 2.0),
    doubleArrayOf(7.0, 90.0, 1.89),
    doubleArrayOf(8.0, 90.0, 1.78),
    doubleArrayOf(9.0, 85.0, 1.67),
    doubleArrayOf(10.0, 85.0, 1.56),
    doubleArrayOf(11.0, 85.0, 1.45),
    doubleArrayOf(12.0, 80.0, 1.34),
    doubleArrayOf(13.0, 80.0, 1.24),
    doubleArrayOf(14.0, 80.0, 1.13),
    doubleArrayOf(15.0, 75.0, 1.02),
    doubleArrayOf(16.0, 75.0, 0.91),
    doubleArrayOf(17.0, 75.0, 0.8),
    doubleArrayOf(18.0, 70.0, 0.69),
    doubleArrayOf(19.0, 70.0, 0.58),
    doubleArrayOf(20.0, 70.0, 0.48),
    doubleArrayOf(21.0, 60.0, 0.37),
    doubleArrayOf(22.0, 60.0, 0.26),
    doubleArrayOf(23.0, 60.0, 0.15),
    doubleArrayOf(24.0, 50.0, 0.04),
    doubleArrayOf(25.0, 50.0, -0.07),
    doubleArrayOf(26.0, 50.0, -0.18),
    doubleArrayOf(27.0, 40.0, -0.28),
    doubleArrayOf(28.0, 40.0, -0.39),
    doubleArrayOf(29.0, 40.0, -0.5),
    doubleArrayOf(30.0, 30.0, -0.61),
    doubleArrayOf(31.0, 30.0, -0.72),
    doubleArrayOf(32.0, 30.0, -0.83),
    doubleArrayOf(33.0, 20.0, -0.94),
    doubleArrayOf(34.0, 20.0, -1.04),
    doubleArrayOf(35.0, 20.0, -1.15),
    doubleArrayOf(36.0, 15.0, -1.26),
    doubleArrayOf(37.0, 15.0, -1.37),
    doubleArrayOf(38.0, 15.0, -1.48),
    doubleArrayOf(39.0, 10.0, -1.59),
    doubleArrayOf(40.0, 10.0, -1.7),
    doubleArrayOf(41.0, 10.0, -1.8),
    doubleArrayOf(42.0, 7.0, -1.91),
    doubleArrayOf(43.0, 7.0, -2.02),
    doubleArrayOf(44.0, 7.0, -2.13),
    doubleArrayOf(45.0, 5.0, -2.24),
    doubleArrayOf(46.0, 5.0, -2.35),
    doubleArrayOf(47.0, 5.0, -2.46),
    doubleArrayOf(48.0, 4.0, -2.56),
    doubleArrayOf(49.0, 4.0, -2.67),
    doubleArrayOf(50.0, 4.0, -2.78),
    doubleArrayOf(51.0, 1.0, -2.89),
    doubleArrayOf(52.0, 1.0, -3.0),
    doubleArrayOf(53.0, 1.0, -3.11),
    doubleArrayOf(54.0, 0.0, -3.22),
    doubleArrayOf(55.0, 0.0, -3.32),
    doubleArrayOf(56.0, 0.0, -3.43),
)

/**
 * IV.- Lectura
 * A.- Comprension Lectura
 *
 * Page 57
 */
fun comprensionLectoraE10M4Baremo() = arrayOf(
    doubleArrayOf(35.0, 99.0, 3.29),
    doubleArrayOf(34.0, 98.0, 3.11),
    doubleArrayOf(33.0, 97.0, 2.93),
    doubleArrayOf(32.0, 96.0, 2.75),
    doubleArrayOf(31.0, 95.0, 2.57),
    doubleArrayOf(30.0, 94.0, 2.38),
    doubleArrayOf(29.0, 93.0, 2.2),
    doubleArrayOf(28.0, 92.0, 2.02),
    doubleArrayOf(27.0, 91.0, 1.84),
    doubleArrayOf(26.0, 90.0, 1.66),
    doubleArrayOf(25.0, 88.0, 1.48),
    doubleArrayOf(24.0, 85.0, 1.3),
    doubleArrayOf(23.0, 80.0, 1.11),
    doubleArrayOf(22.0, 75.0, 0.93),
    doubleArrayOf(21.0, 70.0, 0.75),
    doubleArrayOf(20.0, 65.0, 0.57),
    doubleArrayOf(19.0, 60.0, 0.39),
    doubleArrayOf(18.0, 55.0, 0.21),
    doubleArrayOf(17.0, 50.0, 0.03),
    doubleArrayOf(16.0, 45.0, -0.16),
    doubleArrayOf(15.0, 40.0, -0.34),
    doubleArrayOf(14.0, 35.0, -0.52),
    doubleArrayOf(13.0, 30.0, -0.7),
    doubleArrayOf(12.0, 25.0, -0.88),
    doubleArrayOf(11.0, 20.0, -1.06),
    doubleArrayOf(10.0, 18.0, -1.25),
    doubleArrayOf(9.0, 15.0, -1.43),
    doubleArrayOf(8.0, 11.0, -1.61),
    doubleArrayOf(7.0, 10.0, -1.79),
    doubleArrayOf(6.0, 9.0, -1.97),
    doubleArrayOf(5.0, 7.0, -2.15),
    doubleArrayOf(4.0, 5.0, -2.33),
    doubleArrayOf(3.0, 3.0, -2.52),
    doubleArrayOf(2.0, 2.0, -2.7),
    doubleArrayOf(1.0, 1.0, -2.88),
)

/**
 * IV.- Lectura
 * B.- Velocidad Lectora - Velocidad Fragment
 *
 * Page 63
 */
fun velocidadFragmentE10M4Baremo() = arrayOf(
    doubleArrayOf(120.0, 99.0, 3.19),
    doubleArrayOf(150.0, 95.0, 2.32),
    doubleArrayOf(170.0, 90.0, 1.75),
    doubleArrayOf(180.0, 85.0, 1.46),
    doubleArrayOf(190.0, 80.0, 1.17),
    doubleArrayOf(200.0, 70.0, .88),
    doubleArrayOf(210.0, 60.0, 0.59),
    doubleArrayOf(220.0, 55.0, 0.3),
    doubleArrayOf(230.0, 50.0, 0.01),
    doubleArrayOf(240.0, 45.0, -0.28),
    doubleArrayOf(250.0, 40.0, -0.57),
    doubleArrayOf(260.0, 35.0, -0.86),
    doubleArrayOf(270.0, 30.0, -1.15),
    doubleArrayOf(280.0, 25.0, -1.44),
    doubleArrayOf(290.0, 20.0, -1.73),
    doubleArrayOf(300.0, 15.0, -2.02),
    doubleArrayOf(310.0, 10.0, -2.31),
    doubleArrayOf(330.0, 7.0, -2.89),
    doubleArrayOf(345.0, 5.0, -3.32),
    doubleArrayOf(360.0, 3.0, -3.76),
    doubleArrayOf(420.0, 1.0, -5.5),
)

/**
 * IV.- Lectura
 * B.- Velocidad Lectora - Comprension Fragment
 *
 * Page 63
 */
fun comprensionFragmentE10M4Baremo() = arrayOf(
    doubleArrayOf(15.0, 99.0, 0.99),
    doubleArrayOf(14.0, 95.0, 0.86),
    doubleArrayOf(13.0, 90.0, 0.72),
    doubleArrayOf(12.0, 85.0, 0.59),
    doubleArrayOf(11.0, 80.0, 0.46),
    doubleArrayOf(10.0, 75.0, 0.33),
    doubleArrayOf(9.0, 65.0, 0.19),
    doubleArrayOf(8.0, 50.0, 0.06),
    doubleArrayOf(7.0, 35.0, -0.07),
    doubleArrayOf(6.0, 25.0, -0.2),
    doubleArrayOf(5.0, 20.0, -0.34),
    doubleArrayOf(4.0, 10.0, -0.47),
    doubleArrayOf(3.0, 8.0, -0.6),
    doubleArrayOf(2.0, 5.0, -0.73),
    doubleArrayOf(1.0, 4.0, -0.86),
    doubleArrayOf(0.0, 1.0, -1.0),
)

/**
 * V. Escritura
 * A. Ortografía Visual y Reglada
 *
 * Page 71
 */
fun ortografiaVisualRegladaE10M5Baremo() = arrayOf(
    doubleArrayOf(70.0, 99.0, 1.56),
    doubleArrayOf(68.0, 98.0, 1.41),
    doubleArrayOf(66.0, 96.0, 1.27),
    doubleArrayOf(64.0, 95.0, 1.13),
    doubleArrayOf(62.0, 93.0, 0.99),
    doubleArrayOf(60.0, 90.0, 0.85),
    doubleArrayOf(58.0, 85.0, 0.71),
    doubleArrayOf(56.0, 75.0, 0.57),
    doubleArrayOf(54.0, 70.0, 0.43),
    doubleArrayOf(52.0, 60.0, 0.29),
    doubleArrayOf(50.0, 55.0, 0.15),
    doubleArrayOf(48.0, 50.0, 0.01),
    doubleArrayOf(46.0, 45.0, -0.13),
    doubleArrayOf(44.0, 40.0, -0.27),
    doubleArrayOf(42.0, 35.0, -0.41),
    doubleArrayOf(40.0, 30.0, -0.55),
    doubleArrayOf(38.0, 25.0, -0.69),
    doubleArrayOf(36.0, 20.0, -0.83),
    doubleArrayOf(34.0, 18.0, -0.97),
    doubleArrayOf(32.0, 15.0, -1.11),
    doubleArrayOf(30.0, 12.0, -1.25),
    doubleArrayOf(28.0, 10.0, -1.39),
    doubleArrayOf(26.0, 7.0, -1.53),
    doubleArrayOf(24.0, 5.0, -1.67),
    doubleArrayOf(22.0, 3.0, -1.81),
    doubleArrayOf(20.0, 2.0, -1.95),
    doubleArrayOf(18.0, 1.0, -2.09),
)

/**
 * VI. Aprendizajes Matemáticos
 * A. Calculo y Numeracion
 *
 * Page 79
 */
fun calculoNumeracionE10M6Baremo() = arrayOf(
    doubleArrayOf(30.0, 99.0, 2.41),
    doubleArrayOf(29.0, 99.0, 2.24),
    doubleArrayOf(28.0, 99.0, 2.08),
    doubleArrayOf(27.0, 99.0, 1.91),
    doubleArrayOf(26.0, 95.0, 1.74),
    doubleArrayOf(25.0, 92.0, 1.58),
    doubleArrayOf(24.0, 90.0, 1.41),
    doubleArrayOf(23.0, 85.0, 1.24),
    doubleArrayOf(22.0, 80.0, 1.08),
    doubleArrayOf(21.0, 75.0, 0.91),
    doubleArrayOf(20.0, 70.0, 0.75),
    doubleArrayOf(19.0, 65.0, 0.58),
    doubleArrayOf(18.0, 60.0, 0.41),
    doubleArrayOf(17.0, 55.0, 0.25),
    doubleArrayOf(16.0, 50.0, 0.08),
    doubleArrayOf(15.0, 45.0, -0.09),
    doubleArrayOf(14.0, 40.0, -0.25),
    doubleArrayOf(13.0, 35.0, -0.42),
    doubleArrayOf(12.0, 30.0, -0.59),
    doubleArrayOf(11.0, 25.0, -0.75),
    doubleArrayOf(10.0, 20.0, -0.92),
    doubleArrayOf(9.0, 15.0, -1.08),
    doubleArrayOf(8.0, 10.0, -1.25),
    doubleArrayOf(6.0, 7.0, -1.58),
    doubleArrayOf(5.0, 5.0, -1.75),
    doubleArrayOf(4.0, 3.0, -1.92),
    doubleArrayOf(3.0, 1.0, -2.08),
)

/**
 * VI. Aprendizajes Matemáticos
 * B. Resolucion de Problemas
 *
 * Page 85
 */
fun resolucionProblemasE10M6Baremo() = arrayOf(
    doubleArrayOf(18.0, 99.0, 2.95),
    doubleArrayOf(17.0, 97.0, 2.68),
    doubleArrayOf(16.0, 96.0, 2.4),
    doubleArrayOf(15.0, 95.0, 2.13),
    doubleArrayOf(14.0, 90.0, 1.86),
    doubleArrayOf(13.0, 85.0, 1.59),
    doubleArrayOf(12.0, 80.0, 1.32),
    doubleArrayOf(11.0, 75.0, 1.05),
    doubleArrayOf(10.0, 70.0, 0.77),
    doubleArrayOf(9.0, 60.0, 0.5),
    doubleArrayOf(8.0, 55.0, 0.23),
    doubleArrayOf(7.0, 50.0, -0.04),
    doubleArrayOf(6.0, 45.0, -0.31),
    doubleArrayOf(5.0, 40.0, -0.58),
    doubleArrayOf(4.0, 30.0, -0.86),
    doubleArrayOf(3.0, 20.0, -1.13),
    doubleArrayOf(2.0, 10.0, -1.4),
    doubleArrayOf(1.0, 5.0, -1.67),
)




