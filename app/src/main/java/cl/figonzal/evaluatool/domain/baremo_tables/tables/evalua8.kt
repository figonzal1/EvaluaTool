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
import cl.figonzal.evaluatool.domain.baremo_tables.constants.Evalua8Constants
import cl.figonzal.evaluatool.domain.baremo_tables.constants.Evalua8Constants.ADAPTACION_ESCOLAR_E8M3
import cl.figonzal.evaluatool.domain.baremo_tables.constants.Evalua8Constants.ADAPTACION_FAMILIAR_E8M3
import cl.figonzal.evaluatool.domain.baremo_tables.constants.Evalua8Constants.ADAPTACION_PERSONAL_E8M3
import cl.figonzal.evaluatool.domain.baremo_tables.constants.Evalua8Constants.ATENCION_CONCENTRACION_E8M1
import cl.figonzal.evaluatool.domain.baremo_tables.constants.Evalua8Constants.CALCULO_NUMERACION_E8M6
import cl.figonzal.evaluatool.domain.baremo_tables.constants.Evalua8Constants.COMPRENSION_FRAGMENT_E8M4
import cl.figonzal.evaluatool.domain.baremo_tables.constants.Evalua8Constants.COMPRENSION_LECTORA_E8M4
import cl.figonzal.evaluatool.domain.baremo_tables.constants.Evalua8Constants.EFICACIA_LECTORA_E8M4
import cl.figonzal.evaluatool.domain.baremo_tables.constants.Evalua8Constants.HABILIDADES_SOCIALES_E8M3
import cl.figonzal.evaluatool.domain.baremo_tables.constants.Evalua8Constants.ORTOGRAFIA_VISUAL_REGLADA_E8M5
import cl.figonzal.evaluatool.domain.baremo_tables.constants.Evalua8Constants.RAZONAMIENTO_DEDUCTIVO_E8M2
import cl.figonzal.evaluatool.domain.baremo_tables.constants.Evalua8Constants.RAZONAMIENTO_ESPACIAL_E8M2
import cl.figonzal.evaluatool.domain.baremo_tables.constants.Evalua8Constants.RAZONAMIENTO_INDUCTIVO_E8M2
import cl.figonzal.evaluatool.domain.baremo_tables.constants.Evalua8Constants.RESOLUCION_PROBLEMAS_E8M6
import cl.figonzal.evaluatool.domain.baremo_tables.constants.Evalua8Constants.VELOCIDAD_FRAGMENT_E8M4

/**
 * Evalua 8
 */
class Evalua8Baremo : BaremoTable {

    override fun getBaremo(baremo: BaseConstants) = when (baremo as Evalua8Constants) {
        ATENCION_CONCENTRACION_E8M1 -> atencionConcentracionE8M1Baremo()

        RAZONAMIENTO_INDUCTIVO_E8M2 -> razonamientoInductivoE8M2Baremo()
        RAZONAMIENTO_ESPACIAL_E8M2 -> razonamientoEspacialE8M2Baremo()
        RAZONAMIENTO_DEDUCTIVO_E8M2 -> razonamientoDeductivoE8M2Baremo()

        ADAPTACION_PERSONAL_E8M3 -> adaptacionPersonalE8M3Baremo()
        ADAPTACION_FAMILIAR_E8M3 -> adaptacionFamiliarFragmentE8M3Baremo()
        ADAPTACION_ESCOLAR_E8M3 -> adaptacionEscolarFragmentE8M3Baremo()
        HABILIDADES_SOCIALES_E8M3 -> habilidadesSocialesFragmentE8M3Baremo()

        COMPRENSION_LECTORA_E8M4 -> comprensionLectoraE8M4Baremo()
        EFICACIA_LECTORA_E8M4 -> eficaciaLectoraE8M4Baremo()
        VELOCIDAD_FRAGMENT_E8M4 -> velocidadFragmentE8M4Baremo()
        COMPRENSION_FRAGMENT_E8M4 -> comprensionFragmentE8M4Baremo()

        ORTOGRAFIA_VISUAL_REGLADA_E8M5 -> ortografiaVisualRegladaE8M5Baremo()

        CALCULO_NUMERACION_E8M6 -> calculoNumeracionE8M6Baremo()
        RESOLUCION_PROBLEMAS_E8M6 -> resolucionProblemasE8M6Baremo()
    }
}

/**
 * I.- Atencion - Concentracion
 *
 * Page 31
 */
fun atencionConcentracionE8M1Baremo() = arrayOf(
    doubleArrayOf(250.0, 99.0, 1.25),
    doubleArrayOf(241.0, 90.0, 1.0),
    doubleArrayOf(232.0, 80.0, 0.76),
    doubleArrayOf(223.0, 70.0, 0.52),
    doubleArrayOf(214.0, 60.0, 0.28),
    doubleArrayOf(205.0, 50.0, 0.04),
    doubleArrayOf(196.0, 40.0, -0.21),
    doubleArrayOf(187.0, 35.0, -0.45),
    doubleArrayOf(178.0, 30.0, -0.69),
    doubleArrayOf(169.0, 20.0, -0.93),
    doubleArrayOf(160.0, 15.0, -1.17),
    doubleArrayOf(151.0, 12.0, -1.41),
    doubleArrayOf(142.0, 10.0, -1.66),
    doubleArrayOf(133.0, 9.0, -1.9),
    doubleArrayOf(124.0, 7.0, -2.14),
    doubleArrayOf(115.0, 6.0, -2.38),
    doubleArrayOf(96.0, 5.0, -2.89),
    doubleArrayOf(87.0, 4.0, -3.13),
    doubleArrayOf(78.0, 3.0, -3.38),
    doubleArrayOf(69.0, 2.0, -3.62),
    doubleArrayOf(60.0, 1.0, -3.86)
)

/**
 * II.- Razonamiento
 * A.- Razonamiento Inductivo
 *
 * Page 33
 */
fun razonamientoInductivoE8M2Baremo() = arrayOf(
    doubleArrayOf(50.0, 99.0, 2.1),
    doubleArrayOf(48.0, 98.0, 1.9),
    doubleArrayOf(46.0, 96.0, 1.7),
    doubleArrayOf(44.0, 94.0, 1.5),
    doubleArrayOf(42.0, 90.0, 1.3),
    doubleArrayOf(40.0, 85.0, 1.09),
    doubleArrayOf(38.0, 75.0, 0.89),
    doubleArrayOf(36.0, 70.0, 0.69),
    doubleArrayOf(34.0, 65.0, 0.49),
    doubleArrayOf(32.0, 55.0, 0.29),
    doubleArrayOf(30.0, 50.0, 0.09),
    doubleArrayOf(28.0, 45.0, -0.12),
    doubleArrayOf(26.0, 40.0, -0.32),
    doubleArrayOf(24.0, 35.0, -0.52),
    doubleArrayOf(22.0, 30.0, -0.72),
    doubleArrayOf(20.0, 25.0, -0.92),
    doubleArrayOf(18.0, 20.0, -1.13),
    doubleArrayOf(16.0, 15.0, -1.33),
    doubleArrayOf(14.0, 10.0, -1.53),
    doubleArrayOf(12.0, 8.0, -1.73),
    doubleArrayOf(10.0, 6.0, -1.93),
    doubleArrayOf(8.0, 4.0, -2.13),
    doubleArrayOf(6.0, 2.0, -2.34),
    doubleArrayOf(4.0, 1.0, -2.54)
)

/**
 * II.- Razonamiento
 * B.- Razonamiento Espacial
 *
 * Page 39
 */
fun razonamientoEspacialE8M2Baremo() = arrayOf(
    doubleArrayOf(29.0, 99.0, 1.55),
    doubleArrayOf(28.0, 97.0, 1.41),
    doubleArrayOf(27.0, 95.0, 1.27),
    doubleArrayOf(26.0, 90.0, 1.13),
    doubleArrayOf(25.0, 80.0, 0.98),
    doubleArrayOf(24.0, 75.0, 0.84),
    doubleArrayOf(23.0, 70.0, 0.7),
    doubleArrayOf(22.0, 65.0, 0.55),
    doubleArrayOf(21.0, 60.0, 0.41),
    doubleArrayOf(20.0, 55.0, 0.27),
    doubleArrayOf(19.0, 50.0, 0.13),
    doubleArrayOf(18.0, 47.0, -0.02),
    doubleArrayOf(17.0, 42.0, -0.16),
    doubleArrayOf(16.0, 40.0, -0.3),
    doubleArrayOf(15.0, 35.0, -0.44),
    doubleArrayOf(14.0, 30.0, -0.59),
    doubleArrayOf(13.0, 25.0, -0.73),
    doubleArrayOf(12.0, 20.0, -0.87),
    doubleArrayOf(11.0, 15.0, -1.01),
    doubleArrayOf(10.0, 10.0, -1.16),
    doubleArrayOf(9.0, 9.0, -1.3),
    doubleArrayOf(8.0, 7.0, -1.44),
    doubleArrayOf(7.0, 5.0, -1.58),
    doubleArrayOf(6.0, 3.0, -1.73),
    doubleArrayOf(5.0, 1.0, -1.87),
)

/**
 * II.- Razonamiento
 * C.- Razonamiento Deductivo
 *
 * Page 45
 */
fun razonamientoDeductivoE8M2Baremo() = arrayOf(
    doubleArrayOf(23.0, 99.0, 2.11),
    doubleArrayOf(22.0, 98.0, 1.95),
    doubleArrayOf(21.0, 97.0, 1.79),
    doubleArrayOf(20.0, 96.0, 1.63),
    doubleArrayOf(19.0, 95.0, 1.47),
    doubleArrayOf(18.0, 92.0, 1.3),
    doubleArrayOf(17.0, 90.0, 1.14),
    doubleArrayOf(16.0, 87.0, 0.98),
    doubleArrayOf(15.0, 85.0, 0.82),
    doubleArrayOf(14.0, 80.0, 0.66),
    doubleArrayOf(13.0, 75.0, 0.5),
    doubleArrayOf(12.0, 65.0, 0.33),
    doubleArrayOf(11.0, 60.0, 0.17),
    doubleArrayOf(10.0, 50.0, 0.01),
    doubleArrayOf(9.0, 47.0, -0.15),
    doubleArrayOf(8.0, 42.0, -0.31),
    doubleArrayOf(7.0, 40.0, -0.48),
    doubleArrayOf(6.0, 35.0, -0.64),
    doubleArrayOf(5.0, 30.0, -0.8),
    doubleArrayOf(4.0, 25.0, -0.96),
    doubleArrayOf(3.0, 15.0, -1.12),
    doubleArrayOf(2.0, 10.0, -1.28),
    doubleArrayOf(1.0, 5.0, -1.45),
    doubleArrayOf(0.0, 1.0, -1.61),
)

/**
 * III.- Niveles de Adaptacion
 * A.- Adaptacion Personal
 *
 * Page 53
 */
fun adaptacionPersonalE8M3Baremo() = arrayOf(
    doubleArrayOf(0.0, 99.0),
    doubleArrayOf(1.0, 99.0),
    doubleArrayOf(2.0, 99.0),
    doubleArrayOf(3.0, 97.0),
    doubleArrayOf(4.0, 97.0),
    doubleArrayOf(5.0, 97.0),
    doubleArrayOf(6.0, 95.0),
    doubleArrayOf(7.0, 95.0),
    doubleArrayOf(8.0, 95.0),
    doubleArrayOf(9.0, 90.0),
    doubleArrayOf(10.0, 90.0),
    doubleArrayOf(11.0, 90.0),
    doubleArrayOf(12.0, 85.0),
    doubleArrayOf(13.0, 85.0),
    doubleArrayOf(14.0, 85.0),
    doubleArrayOf(15.0, 75.0),
    doubleArrayOf(16.0, 75.0),
    doubleArrayOf(17.0, 75.0),
    doubleArrayOf(18.0, 65.0),
    doubleArrayOf(19.0, 65.0),
    doubleArrayOf(20.0, 65.0),
    doubleArrayOf(21.0, 60.0),
    doubleArrayOf(22.0, 60.0),
    doubleArrayOf(23.0, 60.0),
    doubleArrayOf(24.0, 57.0),
    doubleArrayOf(25.0, 57.0),
    doubleArrayOf(26.0, 57.0),
    doubleArrayOf(27.0, 52.0),
    doubleArrayOf(28.0, 52.0),
    doubleArrayOf(29.0, 52.0),
    doubleArrayOf(30.0, 50.0),
    doubleArrayOf(31.0, 50.0),
    doubleArrayOf(32.0, 50.0),
    doubleArrayOf(33.0, 45.0),
    doubleArrayOf(34.0, 45.0),
    doubleArrayOf(35.0, 45.0),
    doubleArrayOf(36.0, 40.0),
    doubleArrayOf(37.0, 40.0),
    doubleArrayOf(38.0, 40.0),
    doubleArrayOf(39.0, 35.0),
    doubleArrayOf(40.0, 35.0),
    doubleArrayOf(41.0, 35.0),
    doubleArrayOf(42.0, 30.0),
    doubleArrayOf(43.0, 30.0),
    doubleArrayOf(44.0, 30.0),
    doubleArrayOf(45.0, 20.0),
    doubleArrayOf(46.0, 20.0),
    doubleArrayOf(47.0, 20.0),
    doubleArrayOf(48.0, 15.0),
    doubleArrayOf(49.0, 15.0),
    doubleArrayOf(50.0, 15.0),
    doubleArrayOf(51.0, 10.0),
    doubleArrayOf(52.0, 10.0),
    doubleArrayOf(53.0, 10.0),
    doubleArrayOf(54.0, 5.0),
    doubleArrayOf(55.0, 5.0),
    doubleArrayOf(56.0, 5.0),
    doubleArrayOf(57.0, 3.0),
    doubleArrayOf(58.0, 3.0),
    doubleArrayOf(59.0, 3.0),
    doubleArrayOf(60.0, 1.0),

    )

/**
 * III.- Niveles de Adaptacion
 * B.- Adaptacion Familiar
 *
 * Page 53
 */
fun adaptacionFamiliarFragmentE8M3Baremo() = arrayOf(
    doubleArrayOf(0.0, 95.0),
    doubleArrayOf(1.0, 95.0),
    doubleArrayOf(2.0, 95.0),
    doubleArrayOf(3.0, 90.0),
    doubleArrayOf(4.0, 90.0),
    doubleArrayOf(5.0, 90.0),
    doubleArrayOf(6.0, 85.0),
    doubleArrayOf(7.0, 85.0),
    doubleArrayOf(8.0, 85.0),
    doubleArrayOf(9.0, 80.0),
    doubleArrayOf(10.0, 80.0),
    doubleArrayOf(11.0, 80.0),
    doubleArrayOf(12.0, 75.0),
    doubleArrayOf(13.0, 75.0),
    doubleArrayOf(14.0, 75.0),
    doubleArrayOf(15.0, 70.0),
    doubleArrayOf(16.0, 70.0),
    doubleArrayOf(17.0, 70.0),
    doubleArrayOf(18.0, 65.0),
    doubleArrayOf(19.0, 65.0),
    doubleArrayOf(20.0, 65.0),
    doubleArrayOf(21.0, 60.0),
    doubleArrayOf(22.0, 60.0),
    doubleArrayOf(23.0, 60.0),
    doubleArrayOf(24.0, 55.0),
    doubleArrayOf(25.0, 55.0),
    doubleArrayOf(26.0, 55.0),
    doubleArrayOf(27.0, 50.0),
    doubleArrayOf(28.0, 50.0),
    doubleArrayOf(29.0, 50.0),
    doubleArrayOf(30.0, 40.0),
    doubleArrayOf(31.0, 40.0),
    doubleArrayOf(32.0, 40.0),
    doubleArrayOf(33.0, 35.0),
    doubleArrayOf(34.0, 35.0),
    doubleArrayOf(35.0, 35.0),
    doubleArrayOf(36.0, 30.0),
    doubleArrayOf(37.0, 30.0),
    doubleArrayOf(38.0, 30.0),
    doubleArrayOf(39.0, 25.0),
    doubleArrayOf(40.0, 25.0),
    doubleArrayOf(41.0, 25.0),
    doubleArrayOf(42.0, 20.0),
    doubleArrayOf(43.0, 20.0),
    doubleArrayOf(44.0, 20.0),
    doubleArrayOf(45.0, 15.0),
    doubleArrayOf(46.0, 15.0),
    doubleArrayOf(47.0, 15.0),
    doubleArrayOf(48.0, 10.0),
    doubleArrayOf(49.0, 10.0),
    doubleArrayOf(50.0, 10.0),
    doubleArrayOf(51.0, 7.0),
    doubleArrayOf(52.0, 7.0),
    doubleArrayOf(53.0, 7.0),
    doubleArrayOf(54.0, 5.0),
    doubleArrayOf(55.0, 5.0),
    doubleArrayOf(56.0, 5.0),
    doubleArrayOf(57.0, 3.0),
    doubleArrayOf(58.0, 3.0),
    doubleArrayOf(59.0, 3.0),
    doubleArrayOf(60.0, 1.0),

    )

/**
 * III.- Niveles de Adaptacion
 * C.- Adaptacion Escolar
 *
 * Page 53
 */
fun adaptacionEscolarFragmentE8M3Baremo() = arrayOf(
    doubleArrayOf(0.0, 99.0),
    doubleArrayOf(1.0, 99.0),
    doubleArrayOf(2.0, 99.0),
    doubleArrayOf(3.0, 97.0),
    doubleArrayOf(4.0, 97.0),
    doubleArrayOf(5.0, 97.0),
    doubleArrayOf(6.0, 95.0),
    doubleArrayOf(7.0, 95.0),
    doubleArrayOf(8.0, 95.0),
    doubleArrayOf(9.0, 92.0),
    doubleArrayOf(10.0, 92.0),
    doubleArrayOf(11.0, 92.0),
    doubleArrayOf(12.0, 90.0),
    doubleArrayOf(13.0, 90.0),
    doubleArrayOf(14.0, 90.0),
    doubleArrayOf(15.0, 85.0),
    doubleArrayOf(16.0, 85.0),
    doubleArrayOf(17.0, 85.0),
    doubleArrayOf(18.0, 80.0),
    doubleArrayOf(19.0, 80.0),
    doubleArrayOf(20.0, 80.0),
    doubleArrayOf(21.0, 75.0),
    doubleArrayOf(22.0, 75.0),
    doubleArrayOf(23.0, 75.0),
    doubleArrayOf(24.0, 70.0),
    doubleArrayOf(25.0, 70.0),
    doubleArrayOf(26.0, 70.0),
    doubleArrayOf(27.0, 65.0),
    doubleArrayOf(28.0, 65.0),
    doubleArrayOf(29.0, 65.0),
    doubleArrayOf(30.0, 60.0),
    doubleArrayOf(31.0, 60.0),
    doubleArrayOf(32.0, 60.0),
    doubleArrayOf(33.0, 55.0),
    doubleArrayOf(34.0, 55.0),
    doubleArrayOf(35.0, 55.0),
    doubleArrayOf(36.0, 45.0),
    doubleArrayOf(37.0, 45.0),
    doubleArrayOf(38.0, 45.0),
    doubleArrayOf(39.0, 35.0),
    doubleArrayOf(40.0, 35.0),
    doubleArrayOf(41.0, 35.0),
    doubleArrayOf(42.0, 30.0),
    doubleArrayOf(43.0, 30.0),
    doubleArrayOf(44.0, 30.0),
    doubleArrayOf(45.0, 25.0),
    doubleArrayOf(46.0, 25.0),
    doubleArrayOf(47.0, 25.0),
    doubleArrayOf(48.0, 20.0),
    doubleArrayOf(49.0, 20.0),
    doubleArrayOf(50.0, 20.0),
    doubleArrayOf(51.0, 15.0),
    doubleArrayOf(52.0, 15.0),
    doubleArrayOf(53.0, 15.0),
    doubleArrayOf(54.0, 10.0),
    doubleArrayOf(55.0, 10.0),
    doubleArrayOf(56.0, 10.0),
    doubleArrayOf(57.0, 5.0),
    doubleArrayOf(58.0, 5.0),
    doubleArrayOf(59.0, 5.0),
    doubleArrayOf(60.0, 1.0),
)

/**
 * III.- Niveles de Adaptacion
 * D.- Habilidades Sociales
 *
 * Page 53
 */
fun habilidadesSocialesFragmentE8M3Baremo() = arrayOf(
    doubleArrayOf(0.0, 99.0),
    doubleArrayOf(1.0, 99.0),
    doubleArrayOf(2.0, 99.0),
    doubleArrayOf(3.0, 97.0),
    doubleArrayOf(4.0, 97.0),
    doubleArrayOf(5.0, 97.0),
    doubleArrayOf(6.0, 95.0),
    doubleArrayOf(7.0, 95.0),
    doubleArrayOf(8.0, 95.0),
    doubleArrayOf(9.0, 90.0),
    doubleArrayOf(10.0, 90.0),
    doubleArrayOf(11.0, 90.0),
    doubleArrayOf(12.0, 80.0),
    doubleArrayOf(13.0, 80.0),
    doubleArrayOf(14.0, 80.0),
    doubleArrayOf(15.0, 75.0),
    doubleArrayOf(16.0, 75.0),
    doubleArrayOf(17.0, 75.0),
    doubleArrayOf(18.0, 65.0),
    doubleArrayOf(19.0, 65.0),
    doubleArrayOf(20.0, 65.0),
    doubleArrayOf(21.0, 60.0),
    doubleArrayOf(22.0, 60.0),
    doubleArrayOf(23.0, 60.0),
    doubleArrayOf(24.0, 55.0),
    doubleArrayOf(25.0, 55.0),
    doubleArrayOf(26.0, 55.0),
    doubleArrayOf(27.0, 50.0),
    doubleArrayOf(28.0, 50.0),
    doubleArrayOf(29.0, 50.0),
    doubleArrayOf(30.0, 47.0),
    doubleArrayOf(31.0, 47.0),
    doubleArrayOf(32.0, 47.0),
    doubleArrayOf(33.0, 42.0),
    doubleArrayOf(34.0, 42.0),
    doubleArrayOf(35.0, 42.0),
    doubleArrayOf(36.0, 40.0),
    doubleArrayOf(37.0, 40.0),
    doubleArrayOf(38.0, 40.0),
    doubleArrayOf(39.0, 35.0),
    doubleArrayOf(40.0, 35.0),
    doubleArrayOf(41.0, 35.0),
    doubleArrayOf(42.0, 30.0),
    doubleArrayOf(43.0, 30.0),
    doubleArrayOf(44.0, 30.0),
    doubleArrayOf(45.0, 15.0),
    doubleArrayOf(46.0, 15.0),
    doubleArrayOf(47.0, 15.0),
    doubleArrayOf(48.0, 10.0),
    doubleArrayOf(49.0, 10.0),
    doubleArrayOf(50.0, 10.0),
    doubleArrayOf(51.0, 7.0),
    doubleArrayOf(52.0, 7.0),
    doubleArrayOf(53.0, 7.0),
    doubleArrayOf(54.0, 5.0),
    doubleArrayOf(55.0, 5.0),
    doubleArrayOf(56.0, 5.0),
    doubleArrayOf(57.0, 3.0),
    doubleArrayOf(58.0, 3.0),
    doubleArrayOf(59.0, 3.0),
    doubleArrayOf(60.0, 1.0),

    )

/**
 * IV.- Lectura
 * A. Comprension Lectora
 *
 * Page 57
 */
fun comprensionLectoraE8M4Baremo() = arrayOf(
    doubleArrayOf(39.0, 99.0, 3.25),
    doubleArrayOf(37.0, 98.0, 2.97),
    doubleArrayOf(35.0, 97.0, 2.69),
    doubleArrayOf(33.0, 95.0, 2.41),
    doubleArrayOf(31.0, 93.0, 2.13),
    doubleArrayOf(29.0, 91.0, 1.85),
    doubleArrayOf(27.0, 90.0, 1.57),
    doubleArrayOf(25.0, 85.0, 1.29),
    doubleArrayOf(23.0, 80.0, 1.01),
    doubleArrayOf(21.0, 75.0, 0.73),
    doubleArrayOf(19.0, 65.0, 0.44),
    doubleArrayOf(17.0, 55.0, 0.16),
    doubleArrayOf(15.0, 50.0, -0.12),
    doubleArrayOf(13.0, 45.0, -0.4),
    doubleArrayOf(11.0, 40.0, -0.68),
    doubleArrayOf(9.0, 30.0, -0.96),
    doubleArrayOf(7.0, 20.0, -1.24),
    doubleArrayOf(5.0, 10.0, -1.52),
    doubleArrayOf(3.0, 5.0, -1.8),
    doubleArrayOf(1.0, 1.0, -2.08),
)

/**
 * IV.- Lectura
 * B. Eficacia Lectora
 *
 * Page 63
 */
fun eficaciaLectoraE8M4Baremo() = arrayOf(
    doubleArrayOf(28.0, 99.0, 1.13),
    doubleArrayOf(27.0, 92.0, 1.01),
    doubleArrayOf(26.0, 90.0, 0.89),
    doubleArrayOf(25.0, 80.0, 0.77),
    doubleArrayOf(24.0, 75.0, 0.65),
    doubleArrayOf(23.0, 70.0, 0.53),
    doubleArrayOf(22.0, 65.0, 0.41),
    doubleArrayOf(21.0, 60.0, 0.29),
    doubleArrayOf(20.0, 55.0, 0.16),
    doubleArrayOf(19.0, 50.0, 0.04),
    doubleArrayOf(18.0, 45.0, -0.08),
    doubleArrayOf(17.0, 40.0, -0.2),
    doubleArrayOf(16.0, 35.0, -0.32),
    doubleArrayOf(14.0, 30.0, -0.56),
    doubleArrayOf(13.0, 25.0, -0.69),
    doubleArrayOf(12.0, 20.0, -0.81),
    doubleArrayOf(10.0, 15.0, -1.05),
    doubleArrayOf(9.0, 10.0, -1.17),
    doubleArrayOf(8.0, 7.0, -1.29),
    doubleArrayOf(7.0, 5.0, -1.41),
    doubleArrayOf(5.0, 2.0, -1.66),
)

/**
 * IV.- Lectura
 * C. Velocidad Lectora - Velocidad Fragment
 *
 * Page 67
 */
fun velocidadFragmentE8M4Baremo() = arrayOf(
    doubleArrayOf(80.0, 99.0, 1.33),
    doubleArrayOf(90.0, 97.0, 1.19),
    doubleArrayOf(100.0, 95.0, 1.06),
    doubleArrayOf(120.0, 90.0, 0.78),
    doubleArrayOf(140.0, 80.0, 0.51),
    doubleArrayOf(150.0, 75.0, 0.37),
    doubleArrayOf(160.0, 70.0, 0.24),
    doubleArrayOf(170.0, 60.0, 0.1),
    doubleArrayOf(180.0, 50.0, -0.04),
    doubleArrayOf(190.0, 47.0, -0.17),
    doubleArrayOf(200.0, 45.0, -0.31),
    doubleArrayOf(210.0, 40.0, -0.45),
    doubleArrayOf(220.0, 30.0, -0.58),
    doubleArrayOf(230.0, 25.0, -0.72),
    doubleArrayOf(240.0, 22.0, -0.86),
    doubleArrayOf(250.0, 20.0, -0.99),
    doubleArrayOf(270.0, 15.0, -1.27),
    doubleArrayOf(290.0, 14.0, -1.54),
    doubleArrayOf(310.0, 12.0, -1.81),
    doubleArrayOf(380.0, 10.0, -2.77),
    doubleArrayOf(400.0, 8.0, -3.04),
    doubleArrayOf(420.0, 6.0, -3.32),
    doubleArrayOf(440.0, 4.0, -3.59),
    doubleArrayOf(460.0, 2.0, -3.86)
)

/**
 * IV.- Lectura
 * C. Velocidad Lectora - Comprension Fragment
 *
 * Page 67
 */
fun comprensionFragmentE8M4Baremo() = arrayOf(
    doubleArrayOf(15.0, 99.0, 4.4),
    doubleArrayOf(14.0, 98.0, 4.01),
    doubleArrayOf(13.0, 97.0, 3.62),
    doubleArrayOf(12.0, 96.0, 3.23),
    doubleArrayOf(11.0, 95.0, 2.84),
    doubleArrayOf(10.0, 94.0, 2.45),
    doubleArrayOf(9.0, 92.0, 2.06),
    doubleArrayOf(8.0, 90.0, 1.67),
    doubleArrayOf(7.0, 80.0, 1.28),
    doubleArrayOf(6.0, 70.0, 0.89),
    doubleArrayOf(5.0, 60.0, 0.51),
    doubleArrayOf(4.0, 50.0, 0.12),
    doubleArrayOf(3.0, 40.0, -0.27),
    doubleArrayOf(2.0, 30.0, -0.66),
    doubleArrayOf(1.0, 20.0, -1.05),
    doubleArrayOf(0.0, 10.0, -1.44),
)

/**
 * V.- Escritura
 * A. Ortografia Visual y Reglada
 *
 * Page 75
 */
fun ortografiaVisualRegladaE8M5Baremo() = arrayOf(
    doubleArrayOf(90.0, 99.0, 3.77),
    doubleArrayOf(80.0, 98.0, 3.22),
    doubleArrayOf(70.0, 97.0, 2.67),
    doubleArrayOf(60.0, 95.0, 2.12),
    doubleArrayOf(55.0, 93.0, 1.85),
    doubleArrayOf(50.0, 90.0, 1.57),
    doubleArrayOf(45.0, 88.0, 1.3),
    doubleArrayOf(42.0, 85.0, 1.13),
    doubleArrayOf(39.0, 80.0, 0.97),
    doubleArrayOf(36.0, 75.0, 0.8),
    doubleArrayOf(33.0, 70.0, 0.64),
    doubleArrayOf(30.0, 65.0, 0.47),
    doubleArrayOf(27.0, 60.0, 0.31),
    doubleArrayOf(24.0, 55.0, 0.14),
    doubleArrayOf(21.0, 50.0, -0.02),
    doubleArrayOf(18.0, 47.0, -0.19),
    doubleArrayOf(15.0, 45.0, -0.35),
    doubleArrayOf(13.0, 42.0, -0.46),
    doubleArrayOf(11.0, 40.0, -0.57),
    doubleArrayOf(9.0, 35.0, -0.68),
    doubleArrayOf(7.0, 25.0, -0.79),
    doubleArrayOf(5.0, 15.0, -0.9),
    doubleArrayOf(3.0, 10.0, -1.01),
    doubleArrayOf(1.0, 5.0, -1.12),
    doubleArrayOf(0.0, 1.0, -1.18),
)

/**
 * VI.- Aprendizajes Matematicos
 * A. Calculo y Numeracion
 *
 * Page 87
 */
fun calculoNumeracionE8M6Baremo() = arrayOf(
    doubleArrayOf(36.0, 99.0, 2.99),
    doubleArrayOf(34.0, 98.0, 2.7),
    doubleArrayOf(32.0, 97.0, 2.41),
    doubleArrayOf(27.0, 96.0, 1.69),
    doubleArrayOf(26.0, 95.0, 1.55),
    doubleArrayOf(24.0, 90.0, 1.26),
    doubleArrayOf(22.0, 85.0, 0.97),
    doubleArrayOf(21.0, 80.0, 0.82),
    doubleArrayOf(19.0, 70.0, 0.53),
    doubleArrayOf(18.0, 65.0, 0.39),
    doubleArrayOf(17.0, 60.0, 0.25),
    doubleArrayOf(16.0, 55.0, 0.1),
    doubleArrayOf(15.0, 50.0, -0.04),
    doubleArrayOf(14.0, 45.0, -0.19),
    doubleArrayOf(13.0, 40.0, -0.33),
    doubleArrayOf(12.0, 35.0, -0.48),
    doubleArrayOf(11.0, 30.0, -0.62),
    doubleArrayOf(10.0, 25.0, -0.77),
    doubleArrayOf(9.0, 20.0, -0.91),
    doubleArrayOf(8.0, 15.0, -1.05),
    doubleArrayOf(6.0, 10.0, -1.34),
    doubleArrayOf(4.0, 7.0, -1.63),
    doubleArrayOf(2.0, 5.0, -1.92),
    doubleArrayOf(1.0, 1.0, -2.07),
)

/**
 * VI.- Aprendizajes Matematicos
 * B. Resolucion de Problemas
 *
 * Page 93
 */
fun resolucionProblemasE8M6Baremo() = arrayOf(
    doubleArrayOf(15.0, 99.0, 3.45),
    doubleArrayOf(14.0, 98.0, 3.11),
    doubleArrayOf(13.0, 97.0, 2.77),
    doubleArrayOf(12.0, 96.0, 2.43),
    doubleArrayOf(11.0, 95.0, 2.09),
    doubleArrayOf(10.0, 92.0, 1.75),
    doubleArrayOf(9.0, 90.0, 1.41),
    doubleArrayOf(8.0, 82.0, 1.07),
    doubleArrayOf(7.0, 75.0, 0.73),
    doubleArrayOf(6.0, 65.0, 0.39),
    doubleArrayOf(5.0, 55.0, 0.05),
    doubleArrayOf(4.0, 40.0, -0.29),
    doubleArrayOf(3.0, 30.0, -0.63),
    doubleArrayOf(2.0, 20.0, -0.97),
    doubleArrayOf(1.0, 10.0, -1.31),
)
