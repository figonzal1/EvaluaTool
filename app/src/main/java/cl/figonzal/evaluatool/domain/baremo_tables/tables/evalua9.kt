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
import cl.figonzal.evaluatool.domain.baremo_tables.constants.Evalua9Constants
import cl.figonzal.evaluatool.domain.baremo_tables.constants.Evalua9Constants.ADAPTACION_ESCOLAR_E9M3
import cl.figonzal.evaluatool.domain.baremo_tables.constants.Evalua9Constants.ADAPTACION_FAMILIAR_E9M3
import cl.figonzal.evaluatool.domain.baremo_tables.constants.Evalua9Constants.ADAPTACION_PERSONAL_E9M3
import cl.figonzal.evaluatool.domain.baremo_tables.constants.Evalua9Constants.ATENCION_CONCENTRACION_E9M1
import cl.figonzal.evaluatool.domain.baremo_tables.constants.Evalua9Constants.CALCULO_NUMERACION_E9M6
import cl.figonzal.evaluatool.domain.baremo_tables.constants.Evalua9Constants.COMPRENSION_FRAGMENT_E9M4
import cl.figonzal.evaluatool.domain.baremo_tables.constants.Evalua9Constants.COMPRENSION_LECTORA_E9M4
import cl.figonzal.evaluatool.domain.baremo_tables.constants.Evalua9Constants.EFICACIA_LECTORA_E9M4
import cl.figonzal.evaluatool.domain.baremo_tables.constants.Evalua9Constants.HABILIDADES_SOCIALES_E9M3
import cl.figonzal.evaluatool.domain.baremo_tables.constants.Evalua9Constants.ORTOGRAFIA_VISUAL_REGLADA_E9M5
import cl.figonzal.evaluatool.domain.baremo_tables.constants.Evalua9Constants.RAZONAMIENTO_DEDUCTIVO_E9M2
import cl.figonzal.evaluatool.domain.baremo_tables.constants.Evalua9Constants.RAZONAMIENTO_ESPACIAL_E9M2
import cl.figonzal.evaluatool.domain.baremo_tables.constants.Evalua9Constants.RAZONAMIENTO_INDUCTIVO_E9M2
import cl.figonzal.evaluatool.domain.baremo_tables.constants.Evalua9Constants.RESOLUCION_PROBLEMAS_E9M6
import cl.figonzal.evaluatool.domain.baremo_tables.constants.Evalua9Constants.VELOCIDAD_FRAGMENT_E9M4

/**
 * Evalua 9
 */
class Evalua9Baremo : BaremoTable {

    override fun getBaremo(baremo: BaseConstants) = when (baremo as Evalua9Constants) {
        ATENCION_CONCENTRACION_E9M1 -> atencionConcentracionE9M1Baremo()

        RAZONAMIENTO_INDUCTIVO_E9M2 -> razonamientoInductivoE9M2Baremo()
        RAZONAMIENTO_ESPACIAL_E9M2 -> razonamientoEspacialE9M2Baremo()
        RAZONAMIENTO_DEDUCTIVO_E9M2 -> razonamientoDeductivoE9M2Baremo()

        ADAPTACION_PERSONAL_E9M3 -> adaptacionPersonalE9M3Baremo()
        ADAPTACION_FAMILIAR_E9M3 -> adaptacionFamiliarFragmentE9M3Baremo()
        ADAPTACION_ESCOLAR_E9M3 -> adaptacionEscolarFragmentE9M3Baremo()
        HABILIDADES_SOCIALES_E9M3 -> habilidadesSocialesE9M3Baremo()

        COMPRENSION_LECTORA_E9M4 -> comprensionLectoraE9M4Baremo()
        EFICACIA_LECTORA_E9M4 -> eficaciaLectoraE9M4Baremo()
        VELOCIDAD_FRAGMENT_E9M4 -> velocidadFragmentE9M4Baremo()
        COMPRENSION_FRAGMENT_E9M4 -> comprensionFragmentE9M4Baremo()

        ORTOGRAFIA_VISUAL_REGLADA_E9M5 -> ortografiaVisualRegladaE9M5Baremo()

        CALCULO_NUMERACION_E9M6 -> calculoNumeracionE9M6Baremo()
        RESOLUCION_PROBLEMAS_E9M6 -> resolucionProblemasE9M6Baremo()
    }
}

/**
 * I.- Atencion - Concentracion
 *
 * Page 31
 */
fun atencionConcentracionE9M1Baremo() = arrayOf(
    doubleArrayOf(193.0, 99.0, 1.15),
    doubleArrayOf(189.0, 90.0, 1.04),
    doubleArrayOf(183.0, 80.0, 0.88),
    doubleArrayOf(177.0, 75.0, 0.71),
    doubleArrayOf(171.0, 70.0, 0.55),
    doubleArrayOf(165.0, 65.0, 0.38),
    doubleArrayOf(159.0, 60.0, 0.22),
    doubleArrayOf(153.0, 50.0, 0.06),
    doubleArrayOf(147.0, 45.0, -0.11),
    doubleArrayOf(141.0, 40.0, -0.27),
    doubleArrayOf(135.0, 30.0, -0.43),
    doubleArrayOf(129.0, 20.0, -0.6),
    doubleArrayOf(123.0, 18.0, -0.76),
    doubleArrayOf(117.0, 15.0, -0.92),
    doubleArrayOf(111.0, 11.0, -1.09),
    doubleArrayOf(105.0, 10.0, -1.25),
    doubleArrayOf(99.0, 8.0, -1.42),
    doubleArrayOf(93.0, 7.0, -1.58),
    doubleArrayOf(87.0, 6.0, -1.74),
    doubleArrayOf(81.0, 5.0, -1.91),
    doubleArrayOf(75.0, 4.0, -2.07),
    doubleArrayOf(69.0, 3.0, -2.23),
    doubleArrayOf(63.0, 2.0, -2.4),
    doubleArrayOf(57.0, 1.0, -2.56),
)

/**
 * II.- Razonamiento
 * A.- Razonamiento Inductivo
 *
 * Page 35
 */
fun razonamientoInductivoE9M2Baremo() = arrayOf(
    doubleArrayOf(45.0, 99.0, 3.49),
    doubleArrayOf(42.0, 98.0, 3.06),
    doubleArrayOf(40.0, 97.0, 2.78),
    doubleArrayOf(38.0, 96.0, 2.49),
    doubleArrayOf(36.0, 95.0, 2.21),
    doubleArrayOf(34.0, 93.0, 1.92),
    doubleArrayOf(32.0, 92.0, 1.64),
    doubleArrayOf(30.0, 90.0, 1.35),
    doubleArrayOf(28.0, 85.0, 1.07),
    doubleArrayOf(27.0, 80.0, 0.93),
    doubleArrayOf(26.0, 77.0, 0.78),
    doubleArrayOf(25.0, 75.0, 0.64),
    doubleArrayOf(24.0, 70.0, 0.5),
    doubleArrayOf(23.0, 65.0, 0.36),
    doubleArrayOf(22.0, 60.0, 0.21),
    doubleArrayOf(21.0, 55.0, 0.07),
    doubleArrayOf(20.0, 50.0, -0.07),
    doubleArrayOf(19.0, 45.0, -0.21),
    doubleArrayOf(18.0, 40.0, -0.36),
    doubleArrayOf(16.0, 35.0, -0.64),
    doubleArrayOf(14.0, 25.0, -0.93),
    doubleArrayOf(12.0, 20.0, -1.21),
    doubleArrayOf(10.0, 15.0, -1.5),
    doubleArrayOf(8.0, 10.0, -1.78),
    doubleArrayOf(6.0, 7.0, -2.07),
    doubleArrayOf(4.0, 3.0, -2.35),
    doubleArrayOf(2.0, 1.0, -2.64),
)

/**
 * II.- Razonamiento
 * B.- Razonamiento Espacial
 *
 * Page 41
 */
fun razonamientoEspacialE9M2Baremo() = arrayOf(
    doubleArrayOf(29.0, 99.0, 2.02),
    doubleArrayOf(28.0, 98.0, 1.87),
    doubleArrayOf(27.0, 97.0, 1.71),
    doubleArrayOf(26.0, 95.0, 1.56),
    doubleArrayOf(25.0, 94.0, 1.41),
    doubleArrayOf(24.0, 92.0, 1.25),
    doubleArrayOf(23.0, 90.0, 1.1),
    doubleArrayOf(22.0, 85.0, 0.95),
    doubleArrayOf(21.0, 80.0, 0.79),
    doubleArrayOf(20.0, 75.0, 0.64),
    doubleArrayOf(19.0, 70.0, 0.49),
    doubleArrayOf(18.0, 65.0, 0.33),
    doubleArrayOf(17.0, 60.0, 0.18),
    doubleArrayOf(16.0, 55.0, 0.02),
    doubleArrayOf(15.0, 50.0, -0.13),
    doubleArrayOf(14.0, 45.0, -0.28),
    doubleArrayOf(13.0, 40.0, -0.44),
    doubleArrayOf(12.0, 35.0, -0.59),
    doubleArrayOf(11.0, 30.0, -0.74),
    doubleArrayOf(10.0, 25.0, -0.9),
    doubleArrayOf(9.0, 20.0, -1.05),
    doubleArrayOf(8.0, 15.0, -1.2),
    doubleArrayOf(7.0, 10.0, -1.36),
    doubleArrayOf(6.0, 7.0, -1.51),
    doubleArrayOf(5.0, 5.0, -1.67),
    doubleArrayOf(4.0, 3.0, -1.82),
)

/**
 * II.- Razonamiento
 * C.- Razonamiento Deductivo
 *
 * Page 47
 */
fun razonamientoDeductivoE9M2Baremo() = arrayOf(
    doubleArrayOf(29.0, 99.0, 2.17),
    doubleArrayOf(27.0, 98.0, 1.87),
    doubleArrayOf(26.0, 97.0, 1.71),
    doubleArrayOf(25.0, 95.0, 1.56),
    doubleArrayOf(24.0, 92.0, 1.4),
    doubleArrayOf(23.0, 90.0, 1.25),
    doubleArrayOf(22.0, 87.0, 1.1),
    doubleArrayOf(21.0, 85.0, 0.94),
    doubleArrayOf(20.0, 80.0, 0.79),
    doubleArrayOf(19.0, 75.0, 0.64),
    doubleArrayOf(18.0, 70.0, 0.48),
    doubleArrayOf(17.0, 60.0, 0.33),
    doubleArrayOf(16.0, 55.0, 0.18),
    doubleArrayOf(15.0, 50.0, 0.02),
    doubleArrayOf(13.0, 40.0, -0.28),
    doubleArrayOf(11.0, 35.0, -0.59),
    doubleArrayOf(9.0, 25.0, -0.9),
    doubleArrayOf(7.0, 15.0, -1.2),
    doubleArrayOf(5.0, 10.0, -1.51),
    doubleArrayOf(3.0, 5.0, -1.82),
    doubleArrayOf(1.0, 1.0, -2.12),
)

/**
 * III.- Niveles de Adaptacion
 * A.- Adaptacion Personal
 *
 * Page 55
 */
fun adaptacionPersonalE9M3Baremo() = arrayOf(
    doubleArrayOf(0.0, 99.0),
    doubleArrayOf(1.0, 99.0),
    doubleArrayOf(2.0, 99.0),
    doubleArrayOf(3.0, 98.0),
    doubleArrayOf(4.0, 98.0),
    doubleArrayOf(5.0, 98.0),
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
    doubleArrayOf(18.0, 70.0),
    doubleArrayOf(19.0, 70.0),
    doubleArrayOf(20.0, 70.0),
    doubleArrayOf(21.0, 65.0),
    doubleArrayOf(22.0, 65.0),
    doubleArrayOf(23.0, 65.0),
    doubleArrayOf(24.0, 60.0),
    doubleArrayOf(25.0, 60.0),
    doubleArrayOf(26.0, 60.0),
    doubleArrayOf(27.0, 55.0),
    doubleArrayOf(28.0, 55.0),
    doubleArrayOf(29.0, 55.0),
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
 * Page 55
 */
fun adaptacionFamiliarFragmentE9M3Baremo() = arrayOf(
    doubleArrayOf(0.0, 99.0),
    doubleArrayOf(1.0, 99.0),
    doubleArrayOf(2.0, 99.0),
    doubleArrayOf(3.0, 95.0),
    doubleArrayOf(4.0, 95.0),
    doubleArrayOf(5.0, 95.0),
    doubleArrayOf(6.0, 90.0),
    doubleArrayOf(7.0, 90.0),
    doubleArrayOf(8.0, 90.0),
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
    doubleArrayOf(30.0, 45.0),
    doubleArrayOf(31.0, 45.0),
    doubleArrayOf(32.0, 45.0),
    doubleArrayOf(33.0, 40.0),
    doubleArrayOf(34.0, 40.0),
    doubleArrayOf(35.0, 40.0),
    doubleArrayOf(36.0, 35.0),
    doubleArrayOf(37.0, 35.0),
    doubleArrayOf(38.0, 35.0),
    doubleArrayOf(39.0, 30.0),
    doubleArrayOf(40.0, 30.0),
    doubleArrayOf(41.0, 30.0),
    doubleArrayOf(42.0, 20.0),
    doubleArrayOf(43.0, 20.0),
    doubleArrayOf(44.0, 20.0),
    doubleArrayOf(45.0, 15.0),
    doubleArrayOf(46.0, 15.0),
    doubleArrayOf(47.0, 15.0),
    doubleArrayOf(48.0, 12.0),
    doubleArrayOf(49.0, 12.0),
    doubleArrayOf(50.0, 12.0),
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
 * C.- Adaptacion Escolar
 *
 * Page 55
 */
fun adaptacionEscolarFragmentE9M3Baremo() = arrayOf(
    doubleArrayOf(0.0, 99.0),
    doubleArrayOf(1.0, 99.0),
    doubleArrayOf(2.0, 99.0),
    doubleArrayOf(3.0, 98.0),
    doubleArrayOf(4.0, 98.0),
    doubleArrayOf(5.0, 98.0),
    doubleArrayOf(6.0, 97.0),
    doubleArrayOf(7.0, 97.0),
    doubleArrayOf(8.0, 97.0),
    doubleArrayOf(9.0, 96.0),
    doubleArrayOf(10.0, 96.0),
    doubleArrayOf(11.0, 96.0),
    doubleArrayOf(12.0, 93.0),
    doubleArrayOf(13.0, 93.0),
    doubleArrayOf(14.0, 93.0),
    doubleArrayOf(15.0, 90.0),
    doubleArrayOf(16.0, 90.0),
    doubleArrayOf(17.0, 90.0),
    doubleArrayOf(18.0, 85.0),
    doubleArrayOf(19.0, 85.0),
    doubleArrayOf(20.0, 85.0),
    doubleArrayOf(21.0, 80.0),
    doubleArrayOf(22.0, 80.0),
    doubleArrayOf(23.0, 80.0),
    doubleArrayOf(24.0, 75.0),
    doubleArrayOf(25.0, 75.0),
    doubleArrayOf(26.0, 75.0),
    doubleArrayOf(27.0, 70.0),
    doubleArrayOf(28.0, 70.0),
    doubleArrayOf(29.0, 70.0),
    doubleArrayOf(30.0, 65.0),
    doubleArrayOf(31.0, 65.0),
    doubleArrayOf(32.0, 65.0),
    doubleArrayOf(33.0, 60.0),
    doubleArrayOf(34.0, 60.0),
    doubleArrayOf(35.0, 60.0),
    doubleArrayOf(36.0, 55.0),
    doubleArrayOf(37.0, 55.0),
    doubleArrayOf(38.0, 55.0),
    doubleArrayOf(39.0, 50.0),
    doubleArrayOf(40.0, 50.0),
    doubleArrayOf(41.0, 50.0),
    doubleArrayOf(42.0, 40.0),
    doubleArrayOf(43.0, 40.0),
    doubleArrayOf(44.0, 40.0),
    doubleArrayOf(45.0, 30.0),
    doubleArrayOf(46.0, 30.0),
    doubleArrayOf(47.0, 30.0),
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
 * Page 55
 */
fun habilidadesSocialesE9M3Baremo() = arrayOf(
    doubleArrayOf(0.0, 99.0),
    doubleArrayOf(1.0, 99.0),
    doubleArrayOf(2.0, 99.0),
    doubleArrayOf(3.0, 98.0),
    doubleArrayOf(4.0, 98.0),
    doubleArrayOf(5.0, 98.0),
    doubleArrayOf(6.0, 97.0),
    doubleArrayOf(7.0, 97.0),
    doubleArrayOf(8.0, 97.0),
    doubleArrayOf(9.0, 96.0),
    doubleArrayOf(10.0, 96.0),
    doubleArrayOf(11.0, 96.0),
    doubleArrayOf(12.0, 94.0),
    doubleArrayOf(13.0, 94.0),
    doubleArrayOf(14.0, 94.0),
    doubleArrayOf(15.0, 90.0),
    doubleArrayOf(16.0, 90.0),
    doubleArrayOf(17.0, 90.0),
    doubleArrayOf(18.0, 80.0),
    doubleArrayOf(19.0, 80.0),
    doubleArrayOf(20.0, 80.0),
    doubleArrayOf(21.0, 70.0),
    doubleArrayOf(22.0, 70.0),
    doubleArrayOf(23.0, 70.0),
    doubleArrayOf(24.0, 60.0),
    doubleArrayOf(25.0, 60.0),
    doubleArrayOf(26.0, 60.0),
    doubleArrayOf(27.0, 50.0),
    doubleArrayOf(28.0, 50.0),
    doubleArrayOf(29.0, 50.0),
    doubleArrayOf(30.0, 45.0),
    doubleArrayOf(31.0, 45.0),
    doubleArrayOf(32.0, 45.0),
    doubleArrayOf(33.0, 40.0),
    doubleArrayOf(34.0, 40.0),
    doubleArrayOf(35.0, 40.0),
    doubleArrayOf(36.0, 35.0),
    doubleArrayOf(37.0, 35.0),
    doubleArrayOf(38.0, 35.0),
    doubleArrayOf(39.0, 25.0),
    doubleArrayOf(40.0, 25.0),
    doubleArrayOf(41.0, 25.0),
    doubleArrayOf(42.0, 15.0),
    doubleArrayOf(43.0, 15.0),
    doubleArrayOf(44.0, 15.0),
    doubleArrayOf(45.0, 10.0),
    doubleArrayOf(46.0, 10.0),
    doubleArrayOf(47.0, 10.0),
    doubleArrayOf(48.0, 7.0),
    doubleArrayOf(49.0, 7.0),
    doubleArrayOf(50.0, 7.0),
    doubleArrayOf(51.0, 5.0),
    doubleArrayOf(52.0, 5.0),
    doubleArrayOf(53.0, 5.0),
    doubleArrayOf(54.0, 3.0),
    doubleArrayOf(55.0, 3.0),
    doubleArrayOf(56.0, 3.0),
    doubleArrayOf(57.0, 1.0),
    doubleArrayOf(58.0, 1.0),
    doubleArrayOf(59.0, 1.0),
)

/**
 * IV.- Lectura
 * A.- Comprension Lectora
 *
 * Page 59
 */
fun comprensionLectoraE9M4Baremo() = arrayOf(
    doubleArrayOf(37.0, 99.0, 3.23),
    doubleArrayOf(35.0, 98.0, 2.96),
    doubleArrayOf(33.0, 97.0, 2.69),
    doubleArrayOf(31.0, 96.0, 2.42),
    doubleArrayOf(29.0, 95.0, 2.14),
    doubleArrayOf(27.0, 94.0, 1.87),
    doubleArrayOf(25.0, 93.0, 1.6),
    doubleArrayOf(24.0, 92.0, 1.47),
    doubleArrayOf(23.0, 90.0, 1.33),
    doubleArrayOf(22.0, 87.0, 1.2),
    doubleArrayOf(21.0, 85.0, 1.06),
    doubleArrayOf(20.0, 82.0, 0.93),
    doubleArrayOf(19.0, 80.0, 0.79),
    doubleArrayOf(18.0, 75.0, 0.65),
    doubleArrayOf(17.0, 70.0, 0.52),
    doubleArrayOf(16.0, 65.0, 0.38),
    doubleArrayOf(15.0, 60.0, 0.25),
    doubleArrayOf(14.0, 55.0, 0.11),
    doubleArrayOf(13.0, 50.0, -0.02),
    doubleArrayOf(12.0, 45.0, -0.16),
    doubleArrayOf(10.0, 40.0, -0.43),
    doubleArrayOf(8.0, 35.0, -0.7),
    doubleArrayOf(6.0, 25.0, -0.97),
    doubleArrayOf(5.0, 15.0, -1.11),
    doubleArrayOf(4.0, 10.0, -1.24),
    doubleArrayOf(3.0, 5.0, -1.38),
    doubleArrayOf(2.0, 3.0, -1.51),
    doubleArrayOf(1.0, 1.0, -1.65),
)

/**
 * IV.- Lectura
 * B.- Eficacia Lectora
 *
 * Page 65
 */
fun eficaciaLectoraE9M4Baremo() = arrayOf(
    doubleArrayOf(17.0, 98.0, 2.82),
    doubleArrayOf(16.0, 96.0, 2.57),
    doubleArrayOf(15.0, 95.0, 2.32),
    doubleArrayOf(14.0, 94.0, 2.07),
    doubleArrayOf(13.0, 93.0, 1.82),
    doubleArrayOf(12.0, 92.0, 1.57),
    doubleArrayOf(11.0, 90.0, 1.32),
    doubleArrayOf(10.0, 88.0, 1.07),
    doubleArrayOf(9.0, 85.0, 0.82),
    doubleArrayOf(8.0, 75.0, 0.57),
    doubleArrayOf(7.0, 65.0, 0.32),
    doubleArrayOf(6.0, 55.0, 0.07),
    doubleArrayOf(5.0, 50.0, -0.18),
    doubleArrayOf(4.0, 40.0, -0.43),
    doubleArrayOf(3.0, 25.0, -0.68),
    doubleArrayOf(2.0, 10.0, -0.93),
    doubleArrayOf(1.0, 5.0, -1.19),
)

/**
 * IV.- Lectura
 * C.- Velocidad Lectora - Velocidad Fragment
 *
 * Page 69
 */
fun velocidadFragmentE9M4Baremo() = arrayOf(
    doubleArrayOf(90.0, 98.0, 1.53),
    doubleArrayOf(100.0, 96.0, 1.4),
    doubleArrayOf(120.0, 93.0, 1.13),
    doubleArrayOf(130.0, 90.0, 0.99),
    doubleArrayOf(140.0, 85.0, 0.86),
    doubleArrayOf(150.0, 80.0, 0.72),
    doubleArrayOf(160.0, 75.0, 0.59),
    doubleArrayOf(170.0, 70.0, 0.45),
    doubleArrayOf(180.0, 65.0, 0.32),
    doubleArrayOf(190.0, 60.0, 0.18),
    doubleArrayOf(200.0, 50.0, 0.05),
    doubleArrayOf(210.0, 45.0, -0.09),
    doubleArrayOf(220.0, 35.0, -0.22),
    doubleArrayOf(230.0, 30.0, -0.36),
    doubleArrayOf(240.0, 25.0, -0.49),
    doubleArrayOf(250.0, 20.0, -0.63),
    doubleArrayOf(270.0, 15.0, -0.9),
    doubleArrayOf(290.0, 12.0, -1.17),
    doubleArrayOf(310.0, 9.0, -1.44),
    doubleArrayOf(330.0, 5.0, -1.71),
    doubleArrayOf(350.0, 4.0, -1.98),
    doubleArrayOf(370.0, 3.0, -2.24),
    doubleArrayOf(390.0, 2.0, -2.51),
    doubleArrayOf(410.0, 1.0, -2.78),
)

/**
 * IV.- Lectura
 * C.- Velocidad Lectora - Comprension Fragment
 *
 * Page 69
 */
fun comprensionFragmentE9M4Baremo() = arrayOf(
    doubleArrayOf(15.0, 99.0, 1.71),
    doubleArrayOf(14.0, 95.0, 1.45),
    doubleArrayOf(13.0, 90.0, 1.18),
    doubleArrayOf(12.0, 85.0, 0.91),
    doubleArrayOf(11.0, 75.0, 0.65),
    doubleArrayOf(10.0, 65.0, 0.38),
    doubleArrayOf(9.0, 55.0, 0.11),
    doubleArrayOf(8.0, 50.0, -0.15),
    doubleArrayOf(7.0, 45.0, -0.42),
    doubleArrayOf(6.0, 35.0, -0.69),
    doubleArrayOf(5.0, 30.0, -0.95),
    doubleArrayOf(4.0, 25.0, -1.22),
    doubleArrayOf(3.0, 15.0, -1.49),
    doubleArrayOf(2.0, 10.0, -1.75),
    doubleArrayOf(1.0, 5.0, -2.02),
    doubleArrayOf(0.0, 1.0, -2.29),
)

/**
 * V.- Escritura
 * A.-  Ortografia Visual y Reglada
 *
 * Page 75
 */
fun ortografiaVisualRegladaE9M5Baremo() = arrayOf(
    doubleArrayOf(86.0, 99.0, 2.58),
    doubleArrayOf(82.0, 98.0, 2.36),
    doubleArrayOf(78.0, 97.0, 2.15),
    doubleArrayOf(74.0, 96.0, 1.94),
    doubleArrayOf(70.0, 95.0, 1.73),
    doubleArrayOf(66.0, 93.0, 1.51),
    doubleArrayOf(62.0, 90.0, 1.3),
    doubleArrayOf(58.0, 87.0, 1.09),
    doubleArrayOf(55.0, 85.0, 0.93),
    doubleArrayOf(52.0, 82.0, 0.77),
    doubleArrayOf(49.0, 80.0, 0.61),
    doubleArrayOf(46.0, 75.0, 0.45),
    doubleArrayOf(43.0, 65.0, 0.29),
    doubleArrayOf(40.0, 60.0, 0.13),
    doubleArrayOf(37.0, 50.0, -0.03),
    doubleArrayOf(34.0, 45.0, -0.19),
    doubleArrayOf(30.0, 40.0, -0.4),
    doubleArrayOf(26.0, 35.0, -0.61),
    doubleArrayOf(22.0, 30.0, -0.82),
    doubleArrayOf(18.0, 25.0, -1.04),
    doubleArrayOf(14.0, 20.0, -1.25),
    doubleArrayOf(10.0, 15.0, -1.46),
    doubleArrayOf(6.0, 10.0, -1.67),
    doubleArrayOf(4.0, 5.0, -1.78),
)

/**
 * VI.- Aprendizajes Matematicos
 * A.- Calculo y Numeracion
 *
 * Page 85
 */
fun calculoNumeracionE9M6Baremo() = arrayOf(
    doubleArrayOf(26.0, 99.0, 1.91),
    doubleArrayOf(25.0, 97.0, 1.75),
    doubleArrayOf(24.0, 95.0, 1.6),
    doubleArrayOf(23.0, 92.0, 1.44),
    doubleArrayOf(22.0, 90.0, 1.28),
    doubleArrayOf(21.0, 85.0, 1.13),
    doubleArrayOf(20.0, 80.0, 0.97),
    doubleArrayOf(19.0, 75.0, 0.81),
    doubleArrayOf(18.0, 70.0, 0.65),
    doubleArrayOf(17.0, 65.0, 0.5),
    doubleArrayOf(16.0, 60.0, 0.34),
    doubleArrayOf(15.0, 55.0, 0.18),
    doubleArrayOf(14.0, 50.0, 0.03),
    doubleArrayOf(13.0, 47.0, -0.13),
    doubleArrayOf(12.0, 45.0, -0.29),
    doubleArrayOf(11.0, 42.0, -0.45),
    doubleArrayOf(10.0, 40.0, -0.6),
    doubleArrayOf(9.0, 35.0, -0.76),
    doubleArrayOf(8.0, 30.0, -0.92),
    doubleArrayOf(7.0, 25.0, -1.08),
    doubleArrayOf(6.0, 20.0, -1.23),
    doubleArrayOf(5.0, 15.0, -1.39),
    doubleArrayOf(4.0, 10.0, -1.55),
    doubleArrayOf(3.0, 5.0, -1.7),
)

/**
 * VI.- Aprendizajes Matematicos
 * B.- Resolucion de Problemas
 *
 * Page 91
 */
fun resolucionProblemasE9M6Baremo() = arrayOf(
    doubleArrayOf(14.0, 99.0, 3.18),
    doubleArrayOf(13.0, 98.0, 2.86),
    doubleArrayOf(12.0, 97.0, 2.54),
    doubleArrayOf(11.0, 95.0, 2.22),
    doubleArrayOf(10.0, 93.0, 1.9),
    doubleArrayOf(9.0, 90.0, 1.58),
    doubleArrayOf(8.0, 85.0, 1.26),
    doubleArrayOf(7.0, 75.0, 0.95),
    doubleArrayOf(6.0, 70.0, 0.63),
    doubleArrayOf(5.0, 60.0, 0.31),
    doubleArrayOf(4.0, 50.0, -0.01),
    doubleArrayOf(3.0, 35.0, -0.33),
    doubleArrayOf(2.0, 20.0, -0.65),
    doubleArrayOf(1.0, 10.0, -0.96),
    doubleArrayOf(0.0, 2.0, -1.28),
)