/*
 
 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2022

 Last modified 23-06-22 00:59
 */

package cl.figonzal.evaluatool.domain.baremo_tables.tables

import cl.figonzal.evaluatool.domain.baremo_tables.constants.BaseConstants
import cl.figonzal.evaluatool.domain.baremo_tables.constants.Evalua0Constants
import cl.figonzal.evaluatool.domain.baremo_tables.constants.Evalua0Constants.*
import cl.figonzal.evaluatool.domain.resolvers.BaremoTable

/**
 * Evalua 0
 */
class Evalua0Baremo : BaremoTable {

    override fun getBaremo(baremo: String): Array<Array<Double>> {
        return emptyArray()
    }

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
    arrayOf(18.0, 99.0, 1.69),
    arrayOf(17.0, 95.0, 1.36),
    arrayOf(16.0, 85.0, 1.02),
    arrayOf(15.0, 75.0, 0.69),
    arrayOf(14.0, 60.0, 0.36),
    arrayOf(13.0, 50.0, 0.02),
    arrayOf(12.0, 40.0, -0.31),
    arrayOf(11.0, 30.0, -0.64),
    arrayOf(10.0, 20.0, -0.98),
    arrayOf(9.0, 10.0, -1.31),
    arrayOf(8.0, 8.0, -1.64),
    arrayOf(7.0, 6.0, -1.98),
    arrayOf(6.0, 4.0, -2.31),
    arrayOf(5.0, 2.0, -2.64),
    arrayOf(4.0, 1.0, -2.98),
    arrayOf(3.0, 1.0, -3.31),
)

/**
 * I.- Capacidades Cognitivas
 * B. Series
 * Page 39
 */
private fun seriesE0M1Baremo() = arrayOf(
    //PD, PC Chilean, Desviacion
    arrayOf(48.0, 95.0, 1.06),
    arrayOf(47.0, 90.0, 0.96),
    arrayOf(46.0, 85.0, 0.86),
    arrayOf(44.0, 80.0, 0.65),
    arrayOf(42.0, 70.0, 0.44),
    arrayOf(40.0, 60.0, 0.24),
    arrayOf(38.0, 50.0, 0.03),
    arrayOf(36.0, 45.0, -0.18),
    arrayOf(34.0, 35.0, -0.38),
    arrayOf(32.0, 30.0, -0.59),
    arrayOf(30.0, 25.0, -0.8),
    arrayOf(28.0, 20.0, -1.0),
    arrayOf(26.0, 15.0, -1.21),
    arrayOf(24.0, 12.0, -1.42),
    arrayOf(22.0, 10.0, -1.62),
    arrayOf(20.0, 9.0, -1.83),
    arrayOf(18.0, 7.0, -2.04),
    arrayOf(16.0, 5.0, -2.24),
    arrayOf(14.0, 3.0, -2.45),
    arrayOf(10.0, 1.0, -2.86)
)

/**
 * I.- Capacidades Cognitivas
 * C. Organizacion Perceptiva
 * Page 45
 */
private fun organizacionPerceptivaE0M1Baremo() = arrayOf(
    //PD, PC Chilean, Desviacion
    arrayOf(22.0, 99.0, 0.66),
    arrayOf(21.0, 75.0, 0.4),
    arrayOf(20.0, 60.0, 0.15),
    arrayOf(19.0, 50.0, -0.1),
    arrayOf(18.0, 40.0, -0.35),
    arrayOf(17.0, 30.0, -0.6),
    arrayOf(16.0, 25.0, -0.85),
    arrayOf(15.0, 20.0, -1.1),
    arrayOf(14.0, 15.0, -1.35),
    arrayOf(13.0, 10.0, -1.61),
    arrayOf(12.0, 7.0, -1.86),
    arrayOf(10.0, 5.0, -2.36),
    arrayOf(8.0, 3.0, -2.86),
    arrayOf(7.0, 1.0, -3.11),
    arrayOf(4.0, 1.0, -3.87),
    arrayOf(2.0, 1.0, -4.37)
)

/**
 * I.- Capacidades Cognitivas
 * D. Letras y Numeros
 * Page 49
 */
private fun letrasyNumerosE0M1Baremo() = arrayOf(
    //PD, PC Chilean, Desviacion
    arrayOf(30.0, 99.0, 1.37),
    arrayOf(29.0, 90.0, 1.02),
    arrayOf(28.0, 60.0, 0.68),
    arrayOf(27.0, 65.0, 0.34),
    arrayOf(26.0, 50.0, -0.01),
    arrayOf(25.0, 35.0, -0.35),
    arrayOf(24.0, 25.0, -0.69),
    arrayOf(23.0, 15.0, -1.04),
    arrayOf(22.0, 8.0, -1.38),
    arrayOf(21.0, 7.0, -1.73),
    arrayOf(20.0, 6.0, -2.07),
    arrayOf(19.0, 5.0, -2.41),
    arrayOf(18.0, 4.0, -2.76),
    arrayOf(17.0, 3.0, -3.1),
    arrayOf(16.0, 2.0, -3.44),
    arrayOf(15.0, 1.0, -3.79)
)

/**
 * I.- Capacidades Cognitivas
 * E. Memoria Verbal
 * Page 55
 */
private fun memoriaVerbalE0M1Baremo() = arrayOf(
    arrayOf(35.0, 99.0, 1.93),
    arrayOf(34.0, 99.0, 1.78),
    arrayOf(33.0, 95.0, 1.63),
    arrayOf(32.0, 95.0, 1.49),
    arrayOf(31.0, 92.0, 1.34),
    arrayOf(30.0, 90.0, 1.19),
    arrayOf(29.0, 85.0, 1.04),
    arrayOf(27.0, 80.0, 0.74),
    arrayOf(25.0, 70.0, 0.44),
    arrayOf(23.0, 55.0, 0.15),
    arrayOf(21.0, 50.0, -0.15),
    arrayOf(19.0, 40.0, -0.45),
    arrayOf(18.0, 35.0, -0.6),
    arrayOf(17.0, 30.0, -0.75),
    arrayOf(15.0, 20.0, -1.04),
    arrayOf(14.0, 15.0, -1.19),
    arrayOf(12.0, 10.0, -1.49),
    arrayOf(11.0, 7.0, -1.64),
    arrayOf(10.0, 5.0, -1.79),
    arrayOf(9.0, 3.0, -1.94),
    arrayOf(8.0, 2.0, -2.09),
    arrayOf(7.0, 1.0, -2.24),
)

/**
 * II.- Capacidades Cognitivas
 * A. Copia de dibujos
 * Page 61
 */
private fun copiaDeDibujosE0M2Baremo() = arrayOf(
    arrayOf(65.0, 99.0, 1.8),
    arrayOf(64.0, 99.0, 1.72),
    arrayOf(63.0, 97.0, 1.64),
    arrayOf(62.0, 97.0, 1.56),
    arrayOf(61.0, 95.0, 1.48),
    arrayOf(60.0, 95.0, 1.41),
    arrayOf(59.0, 90.0, 1.33),
    arrayOf(58.0, 90.0, 1.25),
    arrayOf(57.0, 90.0, 1.17),
    arrayOf(56.0, 85.0, 1.09),
    arrayOf(55.0, 85.0, 1.01),
    arrayOf(54.0, 85.0, 0.93),
    arrayOf(53.0, 75.0, 0.85),
    arrayOf(52.0, 75.0, 0.77),
    arrayOf(51.0, 75.0, 0.69),
    arrayOf(50.0, 70.0, 0.62),
    arrayOf(49.0, 70.0, 0.54),
    arrayOf(48.0, 70.0, 0.46),
    arrayOf(47.0, 65.0, 0.38),
    arrayOf(46.0, 65.0, 0.3),
    arrayOf(45.0, 65.0, 0.22),
    arrayOf(44.0, 55.0, 0.14),
    arrayOf(43.0, 55.0, 0.06),
    arrayOf(42.0, 55.0, -0.02),
    arrayOf(41.0, 50.0, -0.1),
    arrayOf(40.0, 50.0, -0.18),
    arrayOf(39.0, 50.0, -0.25),
    arrayOf(38.0, 40.0, -0.33),
    arrayOf(37.0, 40.0, -0.41),
    arrayOf(36.0, 40.0, -0.49),
    arrayOf(35.0, 30.0, -0.57),
    arrayOf(34.0, 30.0, -0.65),
    arrayOf(33.0, 30.0, -0.73),
    arrayOf(32.0, 20.0, -0.81),
    arrayOf(31.0, 20.0, -0.89),
    arrayOf(30.0, 20.0, -0.97),
    arrayOf(29.0, 15.0, -1.05),
    arrayOf(28.0, 15.0, -1.12),
    arrayOf(27.0, 15.0, -1.2),
    arrayOf(26.0, 12.0, -1.28),
    arrayOf(25.0, 12.0, -1.36),
    arrayOf(24.0, 12.0, -1.44),
    arrayOf(23.0, 10.0, -1.52),
    arrayOf(22.0, 10.0, -1.6),
    arrayOf(21.0, 10.0, -1.68),
    arrayOf(20.0, 9.0, -1.76),
    arrayOf(19.0, 9.0, -1.84),
    arrayOf(18.0, 9.0, -1.91),
    arrayOf(17.0, 6.0, -1.99),
    arrayOf(16.0, 6.0, -2.07),
    arrayOf(15.0, 6.0, -2.15),
    arrayOf(14.0, 3.0, -2.23),
    arrayOf(13.0, 3.0, -2.31),
    arrayOf(12.0, 3.0, -2.39),
    arrayOf(11.0, 3.0, -2.47),
    arrayOf(10.0, 1.0, -2.55),
    arrayOf(9.0, 1.0, -2.63),
    arrayOf(8.0, 1.0, -2.71),
    arrayOf(7.0, 1.0, -2.78),
    arrayOf(6.0, 1.0, -2.86),
    arrayOf(5.0, 1.0, -2.94),
    arrayOf(4.0, 1.0, -3.02),
    arrayOf(3.0, 1.0, -3.1),
    arrayOf(2.0, 1.0, -3.18),
    arrayOf(1.0, 1.0, -3.26)
)

/**
 * II.- Capacidades Cognitivas
 * B. GrafoMotricidad
 * Page 67
 */
private fun grafoMotricidadE0M2Baremo() = arrayOf(
    arrayOf(48.0, 99.0, 2.18),
    arrayOf(47.0, 99.0, 2.05),
    arrayOf(46.0, 99.0, 1.91),
    arrayOf(45.0, 95.0, 1.77),
    arrayOf(44.0, 95.0, 1.64),
    arrayOf(43.0, 95.0, 1.5),
    arrayOf(42.0, 90.0, 1.36),
    arrayOf(41.0, 90.0, 1.22),
    arrayOf(40.0, 85.0, 1.09),
    arrayOf(39.0, 85.0, 0.95),
    arrayOf(38.0, 80.0, 0.81),
    arrayOf(37.0, 80.0, 0.67),
    arrayOf(36.0, 75.0, 0.54),
    arrayOf(35.0, 75.0, 0.4),
    arrayOf(34.0, 65.0, 0.26),
    arrayOf(33.0, 65.0, 0.13),
    arrayOf(32.0, 55.0, -0.01),
    arrayOf(31.0, 50.0, -0.15),
    arrayOf(30.0, 40.0, -0.29),
    arrayOf(29.0, 30.0, -0.42),
    arrayOf(28.0, 30.0, -0.56),
    arrayOf(27.0, 25.0, -0.7),
    arrayOf(26.0, 20.0, -0.83),
    arrayOf(25.0, 15.0, -0.97),
    arrayOf(24.0, 10.0, -1.11),
    arrayOf(23.0, 9.0, -1.25),
    arrayOf(22.0, 7.0, -1.38),
    arrayOf(21.0, 5.0, -1.52),
    arrayOf(20.0, 3.0, -1.66),
    arrayOf(19.0, 2.0, -1.79),
    arrayOf(18.0, 1.0, -1.93)
)

/**
 * III.- Capacidades Linguisticas
 * A. Palabras y Frases
 * Page 73
 */
private fun palabrasyFrasesE0M3Baremo() = arrayOf(
    arrayOf(24.0, 99.0, 2.06),
    arrayOf(23.0, 97.0, 1.76),
    arrayOf(22.0, 95.0, 1.46),
    arrayOf(21.0, 85.0, 1.16),
    arrayOf(20.0, 75.0, 0.86),
    arrayOf(19.0, 65.0, 0.56),
    arrayOf(18.0, 55.0, 0.26),
    arrayOf(17.0, 50.0, -0.05),
    arrayOf(16.0, 40.0, -0.35),
    arrayOf(15.0, 37.0, -0.65),
    arrayOf(14.0, 35.0, -0.95),
    arrayOf(13.0, 20.0, -1.25),
    arrayOf(12.0, 15.0, -1.55),
    arrayOf(11.0, 10.0, -1.85),
    arrayOf(10.0, 8.0, -2.15),
    arrayOf(9.0, 6.0, -2.45),
    arrayOf(8.0, 4.0, -2.75),
    arrayOf(7.0, 1.0, -3.05),
)

/**
 * III.- Capacidades Linguisticas
 * B. Recepcion Auditiva y Articulacion
 * Page 79
 */
private fun recepcionAuditivaE0M3Baremo() = arrayOf(
    arrayOf(102.0, 99.0, 1.91),
    arrayOf(101.0, 98.0, 1.80),
    arrayOf(100.0, 97.0, 1.69),
    arrayOf(99.0, 96.0, 1.57),
    arrayOf(98.0, 95.0, 1.46),
    arrayOf(97.0, 90.0, 1.35),
    arrayOf(96.0, 85.0, 1.24),
    arrayOf(95.0, 75.0, 1.13),
    arrayOf(93.0, 65.0, 0.91),
    arrayOf(91.0, 60.0, 0.69),
    arrayOf(89.0, 55.0, 0.47),
    arrayOf(86.0, 50.0, 0.13),
    arrayOf(83.0, 45.0, -0.2),
    arrayOf(80.0, 40.0, -0.53),
    arrayOf(77.0, 35.0, -0.87),
    arrayOf(74.0, 30.0, -1.2),
    arrayOf(71.0, 20.0, -1.53),
    arrayOf(69.0, 15.0, -1.75),
    arrayOf(65.0, 10.0, -2.2),
    arrayOf(60.0, 5.0, -2.75),
)

/**
 * III.- Capacidades Linguisticas
 * C. Habilidades Fonologicas
 * Page 83
 */
private fun habilidadesFonologicasE0M3Baremo() = arrayOf(
    arrayOf(62.0, 99.0, 1.71),
    arrayOf(61.0, 99.0, 1.62),
    arrayOf(60.0, 99.0, 1.52),
    arrayOf(59.0, 95.0, 1.42),
    arrayOf(58.0, 95.0, 1.32),
    arrayOf(57.0, 95.0, 1.22),
    arrayOf(56.0, 90.0, 1.12),
    arrayOf(55.0, 90.0, 1.02),
    arrayOf(54.0, 80.0, 0.92),
    arrayOf(53.0, 80.0, 0.82),
    arrayOf(52.0, 70.0, 0.72),
    arrayOf(51.0, 70.0, 0.62),
    arrayOf(50.0, 65.0, 0.52),
    arrayOf(49.0, 65.0, 0.42),
    arrayOf(48.0, 60.0, 0.32),
    arrayOf(47.0, 60.0, 0.23),
    arrayOf(46.0, 55.0, 0.13),
    arrayOf(45.0, 55.0, 0.03),
    arrayOf(44.0, 50.0, -0.07),
    arrayOf(43.0, 50.0, -0.17),
    arrayOf(42.0, 40.0, -0.27),
    arrayOf(41.0, 40.0, -0.37),
    arrayOf(40.0, 30.0, -0.47),
    arrayOf(39.0, 30.0, -0.57),
    arrayOf(38.0, 20.0, -0.67),
    arrayOf(37.0, 20.0, -0.77),
    arrayOf(36.0, 20.0, -0.87),
    arrayOf(35.0, 15.0, -0.97),
    arrayOf(34.0, 15.0, -1.07),
    arrayOf(33.0, 10.0, -1.16),
    arrayOf(32.0, 10.0, -1.26),
    arrayOf(31.0, 10.0, -1.36),
    arrayOf(30.0, 7.0, -1.46),
    arrayOf(29.0, 7.0, -1.56),
    arrayOf(28.0, 7.0, -1.66),
    arrayOf(27.0, 7.0, -1.76),
    arrayOf(26.0, 7.0, -1.86),
    arrayOf(25.0, 7.0, -1.96),
    arrayOf(24.0, 7.0, -2.06),
    arrayOf(23.0, 7.0, -2.16),
    arrayOf(22.0, 7.0, -2.26),
    arrayOf(21.0, 7.0, -2.36),
    arrayOf(20.0, 5.0, -2.46),
    arrayOf(19.0, 5.0, -2.56),
    arrayOf(18.0, 5.0, -2.65),
    arrayOf(17.0, 5.0, -2.75),
    arrayOf(16.0, 5.0, -2.85),
    arrayOf(15.0, 3.0, -2.95),
    arrayOf(14.0, 3.0, -3.05),
    arrayOf(13.0, 3.0, -3.15),
    arrayOf(12.0, 3.0, -3.25),
    arrayOf(11.0, 3.0, -3.35),
    arrayOf(10.0, 1.0, -3.45),
    arrayOf(9.0, 1.0, -3.55),
    arrayOf(8.0, 1.0, -3.65),
    arrayOf(7.0, 1.0, -3.75),
    arrayOf(6.0, 1.0, -3.85),
    arrayOf(5.0, 1.0, -3.95),
)



