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
import cl.figonzal.evaluatool.domain.baremo_tables.constants.Evalua0Constants
import cl.figonzal.evaluatool.domain.baremo_tables.constants.Evalua0Constants.CLASIFICACION_E0M1
import cl.figonzal.evaluatool.domain.baremo_tables.constants.Evalua0Constants.COPIA_DIBUJOS_E0M2
import cl.figonzal.evaluatool.domain.baremo_tables.constants.Evalua0Constants.GRAFO_MOTRICIDAD_E0M2
import cl.figonzal.evaluatool.domain.baremo_tables.constants.Evalua0Constants.HABILIDADES_FONOLOGICAS_E0M3
import cl.figonzal.evaluatool.domain.baremo_tables.constants.Evalua0Constants.LETRAS_NUMEROS_E0M1
import cl.figonzal.evaluatool.domain.baremo_tables.constants.Evalua0Constants.MEMORIA_VERBAL_E0M1
import cl.figonzal.evaluatool.domain.baremo_tables.constants.Evalua0Constants.ORGANIZACION_PERCEPTIVA_E0M1
import cl.figonzal.evaluatool.domain.baremo_tables.constants.Evalua0Constants.PALABRAS_FRASES_E0M3
import cl.figonzal.evaluatool.domain.baremo_tables.constants.Evalua0Constants.RECEPCION_AUDITIVA_E0M3
import cl.figonzal.evaluatool.domain.baremo_tables.constants.Evalua0Constants.SERIES_E0M1

/**
 * Evalua 0
 */
class Evalua0Baremo : BaremoTable {

    override fun getBaremo(baremo: BaseConstants) = when (baremo as Evalua0Constants) {
        CLASIFICACION_E0M1 -> clasificacionE0M1Baremo()
        SERIES_E0M1 -> seriesE0M1Baremo()
        ORGANIZACION_PERCEPTIVA_E0M1 -> organizacionPerceptivaE0M1Baremo()
        LETRAS_NUMEROS_E0M1 -> letrasyNumerosE0M1Baremo()
        MEMORIA_VERBAL_E0M1 -> memoriaVerbalE0M1Baremo()

        COPIA_DIBUJOS_E0M2 -> copiaDeDibujosE0M2Baremo()
        GRAFO_MOTRICIDAD_E0M2 -> grafoMotricidadE0M2Baremo()

        PALABRAS_FRASES_E0M3 -> palabrasyFrasesE0M3Baremo()
        RECEPCION_AUDITIVA_E0M3 -> recepcionAuditivaE0M3Baremo()
        HABILIDADES_FONOLOGICAS_E0M3 -> habilidadesFonologicasE0M3Baremo()
    }
}

/**
 * I.- Capacidades Cognitivas
 * A. Clasificacion
 * Page 33
 */
private fun clasificacionE0M1Baremo() = arrayOf(
    //PD, PC Chilean, Desviacion
    doubleArrayOf(18.0, 99.0, 1.69),
    doubleArrayOf(17.0, 95.0, 1.36),
    doubleArrayOf(16.0, 85.0, 1.02),
    doubleArrayOf(15.0, 75.0, 0.69),
    doubleArrayOf(14.0, 60.0, 0.36),
    doubleArrayOf(13.0, 50.0, 0.02),
    doubleArrayOf(12.0, 40.0, -0.31),
    doubleArrayOf(11.0, 30.0, -0.64),
    doubleArrayOf(10.0, 20.0, -0.98),
    doubleArrayOf(9.0, 10.0, -1.31),
    doubleArrayOf(8.0, 8.0, -1.64),
    doubleArrayOf(7.0, 6.0, -1.98),
    doubleArrayOf(6.0, 4.0, -2.31),
    doubleArrayOf(5.0, 2.0, -2.64),
    doubleArrayOf(4.0, 1.0, -2.98),
    doubleArrayOf(3.0, 1.0, -3.31),
)

/**
 * I.- Capacidades Cognitivas
 * B. Series
 * Page 39
 */
private fun seriesE0M1Baremo() = arrayOf(
    //PD, PC Chilean, Desviacion
    doubleArrayOf(48.0, 95.0, 1.06),
    doubleArrayOf(47.0, 90.0, 0.96),
    doubleArrayOf(46.0, 85.0, 0.86),
    doubleArrayOf(44.0, 80.0, 0.65),
    doubleArrayOf(42.0, 70.0, 0.44),
    doubleArrayOf(40.0, 60.0, 0.24),
    doubleArrayOf(38.0, 50.0, 0.03),
    doubleArrayOf(36.0, 45.0, -0.18),
    doubleArrayOf(34.0, 35.0, -0.38),
    doubleArrayOf(32.0, 30.0, -0.59),
    doubleArrayOf(30.0, 25.0, -0.8),
    doubleArrayOf(28.0, 20.0, -1.0),
    doubleArrayOf(26.0, 15.0, -1.21),
    doubleArrayOf(24.0, 12.0, -1.42),
    doubleArrayOf(22.0, 10.0, -1.62),
    doubleArrayOf(20.0, 9.0, -1.83),
    doubleArrayOf(18.0, 7.0, -2.04),
    doubleArrayOf(16.0, 5.0, -2.24),
    doubleArrayOf(14.0, 3.0, -2.45),
    doubleArrayOf(10.0, 1.0, -2.86)
)

/**
 * I.- Capacidades Cognitivas
 * C. Organizacion Perceptiva
 * Page 45
 */
private fun organizacionPerceptivaE0M1Baremo() = arrayOf(
    //PD, PC Chilean, Desviacion
    doubleArrayOf(22.0, 99.0, 0.66),
    doubleArrayOf(21.0, 75.0, 0.4),
    doubleArrayOf(20.0, 60.0, 0.15),
    doubleArrayOf(19.0, 50.0, -0.1),
    doubleArrayOf(18.0, 40.0, -0.35),
    doubleArrayOf(17.0, 30.0, -0.6),
    doubleArrayOf(16.0, 25.0, -0.85),
    doubleArrayOf(15.0, 20.0, -1.1),
    doubleArrayOf(14.0, 15.0, -1.35),
    doubleArrayOf(13.0, 10.0, -1.61),
    doubleArrayOf(12.0, 7.0, -1.86),
    doubleArrayOf(10.0, 5.0, -2.36),
    doubleArrayOf(8.0, 3.0, -2.86),
    doubleArrayOf(7.0, 1.0, -3.11),
    doubleArrayOf(4.0, 1.0, -3.87),
    doubleArrayOf(2.0, 1.0, -4.37)
)

/**
 * I.- Capacidades Cognitivas
 * D. Letras y Numeros
 * Page 49
 */
private fun letrasyNumerosE0M1Baremo() = arrayOf(
    //PD, PC Chilean, Desviacion
    doubleArrayOf(30.0, 99.0, 1.37),
    doubleArrayOf(29.0, 90.0, 1.02),
    doubleArrayOf(28.0, 60.0, 0.68),
    doubleArrayOf(27.0, 65.0, 0.34),
    doubleArrayOf(26.0, 50.0, -0.01),
    doubleArrayOf(25.0, 35.0, -0.35),
    doubleArrayOf(24.0, 25.0, -0.69),
    doubleArrayOf(23.0, 15.0, -1.04),
    doubleArrayOf(22.0, 8.0, -1.38),
    doubleArrayOf(21.0, 7.0, -1.73),
    doubleArrayOf(20.0, 6.0, -2.07),
    doubleArrayOf(19.0, 5.0, -2.41),
    doubleArrayOf(18.0, 4.0, -2.76),
    doubleArrayOf(17.0, 3.0, -3.1),
    doubleArrayOf(16.0, 2.0, -3.44),
    doubleArrayOf(15.0, 1.0, -3.79)
)

/**
 * I.- Capacidades Cognitivas
 * E. Memoria Verbal
 * Page 55
 */
private fun memoriaVerbalE0M1Baremo() = arrayOf(
    doubleArrayOf(35.0, 99.0, 1.93),
    doubleArrayOf(34.0, 99.0, 1.78),
    doubleArrayOf(33.0, 95.0, 1.63),
    doubleArrayOf(32.0, 95.0, 1.49),
    doubleArrayOf(31.0, 92.0, 1.34),
    doubleArrayOf(30.0, 90.0, 1.19),
    doubleArrayOf(29.0, 85.0, 1.04),
    doubleArrayOf(27.0, 80.0, 0.74),
    doubleArrayOf(25.0, 70.0, 0.44),
    doubleArrayOf(23.0, 55.0, 0.15),
    doubleArrayOf(21.0, 50.0, -0.15),
    doubleArrayOf(19.0, 40.0, -0.45),
    doubleArrayOf(18.0, 35.0, -0.6),
    doubleArrayOf(17.0, 30.0, -0.75),
    doubleArrayOf(15.0, 20.0, -1.04),
    doubleArrayOf(14.0, 15.0, -1.19),
    doubleArrayOf(12.0, 10.0, -1.49),
    doubleArrayOf(11.0, 7.0, -1.64),
    doubleArrayOf(10.0, 5.0, -1.79),
    doubleArrayOf(9.0, 3.0, -1.94),
    doubleArrayOf(8.0, 2.0, -2.09),
    doubleArrayOf(7.0, 1.0, -2.24),
)

/**
 * II.- Capacidades Cognitivas
 * A. Copia de dibujos
 * Page 61
 */
private fun copiaDeDibujosE0M2Baremo() = arrayOf(
    doubleArrayOf(65.0, 99.0, 1.8),
    doubleArrayOf(64.0, 99.0, 1.72),
    doubleArrayOf(63.0, 97.0, 1.64),
    doubleArrayOf(62.0, 97.0, 1.56),
    doubleArrayOf(61.0, 95.0, 1.48),
    doubleArrayOf(60.0, 95.0, 1.41),
    doubleArrayOf(59.0, 90.0, 1.33),
    doubleArrayOf(58.0, 90.0, 1.25),
    doubleArrayOf(57.0, 90.0, 1.17),
    doubleArrayOf(56.0, 85.0, 1.09),
    doubleArrayOf(55.0, 85.0, 1.01),
    doubleArrayOf(54.0, 85.0, 0.93),
    doubleArrayOf(53.0, 75.0, 0.85),
    doubleArrayOf(52.0, 75.0, 0.77),
    doubleArrayOf(51.0, 75.0, 0.69),
    doubleArrayOf(50.0, 70.0, 0.62),
    doubleArrayOf(49.0, 70.0, 0.54),
    doubleArrayOf(48.0, 70.0, 0.46),
    doubleArrayOf(47.0, 65.0, 0.38),
    doubleArrayOf(46.0, 65.0, 0.3),
    doubleArrayOf(45.0, 65.0, 0.22),
    doubleArrayOf(44.0, 55.0, 0.14),
    doubleArrayOf(43.0, 55.0, 0.06),
    doubleArrayOf(42.0, 55.0, -0.02),
    doubleArrayOf(41.0, 50.0, -0.1),
    doubleArrayOf(40.0, 50.0, -0.18),
    doubleArrayOf(39.0, 50.0, -0.25),
    doubleArrayOf(38.0, 40.0, -0.33),
    doubleArrayOf(37.0, 40.0, -0.41),
    doubleArrayOf(36.0, 40.0, -0.49),
    doubleArrayOf(35.0, 30.0, -0.57),
    doubleArrayOf(34.0, 30.0, -0.65),
    doubleArrayOf(33.0, 30.0, -0.73),
    doubleArrayOf(32.0, 20.0, -0.81),
    doubleArrayOf(31.0, 20.0, -0.89),
    doubleArrayOf(30.0, 20.0, -0.97),
    doubleArrayOf(29.0, 15.0, -1.05),
    doubleArrayOf(28.0, 15.0, -1.12),
    doubleArrayOf(27.0, 15.0, -1.2),
    doubleArrayOf(26.0, 12.0, -1.28),
    doubleArrayOf(25.0, 12.0, -1.36),
    doubleArrayOf(24.0, 12.0, -1.44),
    doubleArrayOf(23.0, 10.0, -1.52),
    doubleArrayOf(22.0, 10.0, -1.6),
    doubleArrayOf(21.0, 10.0, -1.68),
    doubleArrayOf(20.0, 9.0, -1.76),
    doubleArrayOf(19.0, 9.0, -1.84),
    doubleArrayOf(18.0, 9.0, -1.91),
    doubleArrayOf(17.0, 6.0, -1.99),
    doubleArrayOf(16.0, 6.0, -2.07),
    doubleArrayOf(15.0, 6.0, -2.15),
    doubleArrayOf(14.0, 3.0, -2.23),
    doubleArrayOf(13.0, 3.0, -2.31),
    doubleArrayOf(12.0, 3.0, -2.39),
    doubleArrayOf(11.0, 3.0, -2.47),
    doubleArrayOf(10.0, 1.0, -2.55),
    doubleArrayOf(9.0, 1.0, -2.63),
    doubleArrayOf(8.0, 1.0, -2.71),
    doubleArrayOf(7.0, 1.0, -2.78),
    doubleArrayOf(6.0, 1.0, -2.86),
    doubleArrayOf(5.0, 1.0, -2.94),
    doubleArrayOf(4.0, 1.0, -3.02),
    doubleArrayOf(3.0, 1.0, -3.1),
    doubleArrayOf(2.0, 1.0, -3.18),
    doubleArrayOf(1.0, 1.0, -3.26)
)

/**
 * II.- Capacidades Cognitivas
 * B. GrafoMotricidad
 * Page 67
 */
private fun grafoMotricidadE0M2Baremo() = arrayOf(
    doubleArrayOf(48.0, 99.0, 2.18),
    doubleArrayOf(47.0, 99.0, 2.05),
    doubleArrayOf(46.0, 99.0, 1.91),
    doubleArrayOf(45.0, 95.0, 1.77),
    doubleArrayOf(44.0, 95.0, 1.64),
    doubleArrayOf(43.0, 95.0, 1.5),
    doubleArrayOf(42.0, 90.0, 1.36),
    doubleArrayOf(41.0, 90.0, 1.22),
    doubleArrayOf(40.0, 85.0, 1.09),
    doubleArrayOf(39.0, 85.0, 0.95),
    doubleArrayOf(38.0, 80.0, 0.81),
    doubleArrayOf(37.0, 80.0, 0.67),
    doubleArrayOf(36.0, 75.0, 0.54),
    doubleArrayOf(35.0, 75.0, 0.4),
    doubleArrayOf(34.0, 65.0, 0.26),
    doubleArrayOf(33.0, 65.0, 0.13),
    doubleArrayOf(32.0, 55.0, -0.01),
    doubleArrayOf(31.0, 50.0, -0.15),
    doubleArrayOf(30.0, 40.0, -0.29),
    doubleArrayOf(29.0, 30.0, -0.42),
    doubleArrayOf(28.0, 30.0, -0.56),
    doubleArrayOf(27.0, 25.0, -0.7),
    doubleArrayOf(26.0, 20.0, -0.83),
    doubleArrayOf(25.0, 15.0, -0.97),
    doubleArrayOf(24.0, 10.0, -1.11),
    doubleArrayOf(23.0, 9.0, -1.25),
    doubleArrayOf(22.0, 7.0, -1.38),
    doubleArrayOf(21.0, 5.0, -1.52),
    doubleArrayOf(20.0, 3.0, -1.66),
    doubleArrayOf(19.0, 2.0, -1.79),
    doubleArrayOf(18.0, 1.0, -1.93)
)

/**
 * III.- Capacidades Linguisticas
 * A. Palabras y Frases
 * Page 73
 */
private fun palabrasyFrasesE0M3Baremo() = arrayOf(
    doubleArrayOf(24.0, 99.0, 2.06),
    doubleArrayOf(23.0, 97.0, 1.76),
    doubleArrayOf(22.0, 95.0, 1.46),
    doubleArrayOf(21.0, 85.0, 1.16),
    doubleArrayOf(20.0, 75.0, 0.86),
    doubleArrayOf(19.0, 65.0, 0.56),
    doubleArrayOf(18.0, 55.0, 0.26),
    doubleArrayOf(17.0, 50.0, -0.05),
    doubleArrayOf(16.0, 40.0, -0.35),
    doubleArrayOf(15.0, 37.0, -0.65),
    doubleArrayOf(14.0, 35.0, -0.95),
    doubleArrayOf(13.0, 20.0, -1.25),
    doubleArrayOf(12.0, 15.0, -1.55),
    doubleArrayOf(11.0, 10.0, -1.85),
    doubleArrayOf(10.0, 8.0, -2.15),
    doubleArrayOf(9.0, 6.0, -2.45),
    doubleArrayOf(8.0, 4.0, -2.75),
    doubleArrayOf(7.0, 1.0, -3.05),
)

/**
 * III.- Capacidades Linguisticas
 * B. Recepcion Auditiva y Articulacion
 * Page 79
 */
private fun recepcionAuditivaE0M3Baremo() = arrayOf(
    doubleArrayOf(102.0, 99.0, 1.91),
    doubleArrayOf(101.0, 98.0, 1.80),
    doubleArrayOf(100.0, 97.0, 1.69),
    doubleArrayOf(99.0, 96.0, 1.57),
    doubleArrayOf(98.0, 95.0, 1.46),
    doubleArrayOf(97.0, 90.0, 1.35),
    doubleArrayOf(96.0, 85.0, 1.24),
    doubleArrayOf(95.0, 75.0, 1.13),
    doubleArrayOf(93.0, 65.0, 0.91),
    doubleArrayOf(91.0, 60.0, 0.69),
    doubleArrayOf(89.0, 55.0, 0.47),
    doubleArrayOf(86.0, 50.0, 0.13),
    doubleArrayOf(83.0, 45.0, -0.2),
    doubleArrayOf(80.0, 40.0, -0.53),
    doubleArrayOf(77.0, 35.0, -0.87),
    doubleArrayOf(74.0, 30.0, -1.2),
    doubleArrayOf(71.0, 20.0, -1.53),
    doubleArrayOf(69.0, 15.0, -1.75),
    doubleArrayOf(65.0, 10.0, -2.2),
    doubleArrayOf(60.0, 5.0, -2.75),
)

/**
 * III.- Capacidades Linguisticas
 * C. Habilidades Fonologicas
 * Page 83
 */
private fun habilidadesFonologicasE0M3Baremo() = arrayOf(
    doubleArrayOf(62.0, 99.0, 1.71),
    doubleArrayOf(61.0, 99.0, 1.62),
    doubleArrayOf(60.0, 99.0, 1.52),
    doubleArrayOf(59.0, 95.0, 1.42),
    doubleArrayOf(58.0, 95.0, 1.32),
    doubleArrayOf(57.0, 95.0, 1.22),
    doubleArrayOf(56.0, 90.0, 1.12),
    doubleArrayOf(55.0, 90.0, 1.02),
    doubleArrayOf(54.0, 80.0, 0.92),
    doubleArrayOf(53.0, 80.0, 0.82),
    doubleArrayOf(52.0, 70.0, 0.72),
    doubleArrayOf(51.0, 70.0, 0.62),
    doubleArrayOf(50.0, 65.0, 0.52),
    doubleArrayOf(49.0, 65.0, 0.42),
    doubleArrayOf(48.0, 60.0, 0.32),
    doubleArrayOf(47.0, 60.0, 0.23),
    doubleArrayOf(46.0, 55.0, 0.13),
    doubleArrayOf(45.0, 55.0, 0.03),
    doubleArrayOf(44.0, 50.0, -0.07),
    doubleArrayOf(43.0, 50.0, -0.17),
    doubleArrayOf(42.0, 40.0, -0.27),
    doubleArrayOf(41.0, 40.0, -0.37),
    doubleArrayOf(40.0, 30.0, -0.47),
    doubleArrayOf(39.0, 30.0, -0.57),
    doubleArrayOf(38.0, 20.0, -0.67),
    doubleArrayOf(37.0, 20.0, -0.77),
    doubleArrayOf(36.0, 20.0, -0.87),
    doubleArrayOf(35.0, 15.0, -0.97),
    doubleArrayOf(34.0, 15.0, -1.07),
    doubleArrayOf(33.0, 10.0, -1.16),
    doubleArrayOf(32.0, 10.0, -1.26),
    doubleArrayOf(31.0, 10.0, -1.36),
    doubleArrayOf(30.0, 7.0, -1.46),
    doubleArrayOf(29.0, 7.0, -1.56),
    doubleArrayOf(28.0, 7.0, -1.66),
    doubleArrayOf(27.0, 7.0, -1.76),
    doubleArrayOf(26.0, 7.0, -1.86),
    doubleArrayOf(25.0, 7.0, -1.96),
    doubleArrayOf(24.0, 7.0, -2.06),
    doubleArrayOf(23.0, 7.0, -2.16),
    doubleArrayOf(22.0, 7.0, -2.26),
    doubleArrayOf(21.0, 7.0, -2.36),
    doubleArrayOf(20.0, 5.0, -2.46),
    doubleArrayOf(19.0, 5.0, -2.56),
    doubleArrayOf(18.0, 5.0, -2.65),
    doubleArrayOf(17.0, 5.0, -2.75),
    doubleArrayOf(16.0, 5.0, -2.85),
    doubleArrayOf(15.0, 3.0, -2.95),
    doubleArrayOf(14.0, 3.0, -3.05),
    doubleArrayOf(13.0, 3.0, -3.15),
    doubleArrayOf(12.0, 3.0, -3.25),
    doubleArrayOf(11.0, 3.0, -3.35),
    doubleArrayOf(10.0, 1.0, -3.45),
    doubleArrayOf(9.0, 1.0, -3.55),
    doubleArrayOf(8.0, 1.0, -3.65),
    doubleArrayOf(7.0, 1.0, -3.75),
    doubleArrayOf(6.0, 1.0, -3.85),
    doubleArrayOf(5.0, 1.0, -3.95),
)



