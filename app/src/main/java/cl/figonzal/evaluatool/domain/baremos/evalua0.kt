/*
 
 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2022

 Last modified 07-03-22 16:46
 */

package cl.figonzal.evaluatool.domain.baremos

/**
 * Evalua 0
 */

/**
 * I.- Capacidades Cognitivas
 * A. Clasificacion
 * Page 33
 */
fun clasificacionE0M1Baremo(): Array<Array<Any>> {
    //PD, PC Chilean, Desviation
    return arrayOf(
        arrayOf(18, 99, 1.69),
        arrayOf(17, 95, 1.36),
        arrayOf(16, 85, 1.02),
        arrayOf(15, 75, 0.69),
        arrayOf(14, 60, 0.36),
        arrayOf(13, 50, 0.02),
        arrayOf(12, 40, -0.31),
        arrayOf(11, 30, -0.64),
        arrayOf(10, 20, -0.98),
        arrayOf(9, 10, -1.31),
        arrayOf(8, 8, -1.64),
        arrayOf(7, 6, -1.98),
        arrayOf(6, 4, -2.31),
        arrayOf(5, 2, -2.64),
        arrayOf(4, 1, -2.98),
        arrayOf(3, 1, -3.31),
    )
}

/**
 * I.- Capacidades Cognitivas
 * B. Series
 * Page 39
 */
fun seriesE0M1Baremo(): Array<Array<Any>> {

    //PD, PC Chilean, Desviation
    return arrayOf(
        arrayOf(48, 95, 1.06),
        arrayOf(47, 90, 0.96),
        arrayOf(46, 85, 0.86),
        arrayOf(44, 80, 0.65),
        arrayOf(42, 70, 0.44),
        arrayOf(40, 60, 0.24),
        arrayOf(38, 50, 0.03),
        arrayOf(36, 45, -0.18),
        arrayOf(34, 35, -0.38),
        arrayOf(32, 30, -0.59),
        arrayOf(30, 25, -0.8),
        arrayOf(28, 20, -1.0),
        arrayOf(26, 15, -1.21),
        arrayOf(24, 12, -1.42),
        arrayOf(22, 10, -1.62),
        arrayOf(20, 9, -1.83),
        arrayOf(18, 7, -2.04),
        arrayOf(16, 5, -2.24),
        arrayOf(14, 3, -2.45),
        arrayOf(10, 1, -2.86)
    )
}

/**
 * I.- Capacidades Cognitivas
 * C. Organizacion Perceptiva
 * Page 45
 */
fun organizacionPerceptivaE0M1Baremo(): Array<Array<Any>> {
    //PD, PC Chilean, Desviation
    return arrayOf(
        arrayOf(22, 99, 0.66),
        arrayOf(21, 75, 0.4),
        arrayOf(20, 60, 0.15),
        arrayOf(19, 50, -0.1),
        arrayOf(18, 40, -0.35),
        arrayOf(17, 30, -0.6),
        arrayOf(16, 25, -0.85),
        arrayOf(15, 20, -1.1),
        arrayOf(14, 15, -1.35),
        arrayOf(13, 10, -1.61),
        arrayOf(12, 7, -1.86),
        arrayOf(10, 5, -2.36),
        arrayOf(8, 3, -2.86),
        arrayOf(7, 1, -3.11),
        arrayOf(4, 1, -3.87),
        arrayOf(2, 1, -4.37)
    )
}

/**
 * I.- Capacidades Cognitivas
 * D. Letras y Numeros
 * Page 49
 */
fun letrasyNumerosE0M1Baremo(): Array<Array<Any>> {
    //PD, PC Chilean, Desviation
    return arrayOf(
        arrayOf(30, 99, 1.37),
        arrayOf(29, 90, 1.02),
        arrayOf(28, 60, 0.68),
        arrayOf(27, 65, 0.34),
        arrayOf(26, 50, -0.01),
        arrayOf(25, 35, -0.35),
        arrayOf(24, 25, -0.69),
        arrayOf(23, 15, -1.04),
        arrayOf(22, 8, -1.38),
        arrayOf(21, 7, -1.73),
        arrayOf(20, 6, -2.07),
        arrayOf(19, 5, -2.41),
        arrayOf(18, 4, -2.76),
        arrayOf(17, 3, -3.1),
        arrayOf(16, 2, -3.44),
        arrayOf(15, 1, -3.79)
    )
}

/**
 * I.- Capacidades Cognitivas
 * E. Memoria Verbal
 * Page 55
 */
fun memoriaVerbalE0M1Baremo(): Array<Array<Any>> {
    return arrayOf(
        arrayOf(35, 99, 1.93),
        arrayOf(34, 99, 1.78),
        arrayOf(33, 95, 1.63),
        arrayOf(32, 95, 1.49),
        arrayOf(31, 92, 1.34),
        arrayOf(30, 90, 1.19),
        arrayOf(29, 85, 1.04),
        arrayOf(27, 80, 0.74),
        arrayOf(25, 70, 0.44),
        arrayOf(23, 55, 0.15),
        arrayOf(21, 50, -0.15),
        arrayOf(19, 40, -0.45),
        arrayOf(18, 35, -0.6),
        arrayOf(17, 30, -0.75),
        arrayOf(15, 20, -1.04),
        arrayOf(14, 15, -1.19),
        arrayOf(12, 10, -1.49),
        arrayOf(11, 7, -1.64),
        arrayOf(10, 5, -1.79),
        arrayOf(9, 3, -1.94),
        arrayOf(8, 2, -2.09),
        arrayOf(7, 1, -2.24),
    )
}

/**
 * II.- Capacidades Cognitivas
 * A. Copia de dibujos
 * Page 61
 */
fun copiaDeDibujosE0M2Baremo(): Array<Array<Any>> {
    return arrayOf(
        arrayOf(65, 99, 1.8),
        arrayOf(64, 99, 1.72),
        arrayOf(63, 97, 1.64),
        arrayOf(62, 97, 1.56),
        arrayOf(61, 95, 1.48),
        arrayOf(60, 95, 1.41),
        arrayOf(59, 90, 1.33),
        arrayOf(58, 90, 1.25),
        arrayOf(57, 90, 1.17),
        arrayOf(56, 85, 1.09),
        arrayOf(55, 85, 1.01),
        arrayOf(54, 85, 0.93),
        arrayOf(53, 75, 0.85),
        arrayOf(52, 75, 0.77),
        arrayOf(51, 75, 0.69),
        arrayOf(50, 70, 0.62),
        arrayOf(49, 70, 0.54),
        arrayOf(48, 70, 0.46),
        arrayOf(47, 65, 0.38),
        arrayOf(46, 65, 0.3),
        arrayOf(45, 65, 0.22),
        arrayOf(44, 55, 0.14),
        arrayOf(43, 55, 0.06),
        arrayOf(42, 55, -0.02),
        arrayOf(41, 50, -0.1),
        arrayOf(40, 50, -0.18),
        arrayOf(39, 50, -0.25),
        arrayOf(38, 40, -0.33),
        arrayOf(37, 40, -0.41),
        arrayOf(36, 40, -0.49),
        arrayOf(35, 30, -0.57),
        arrayOf(34, 30, -0.65),
        arrayOf(33, 30, -0.73),
        arrayOf(32, 20, -0.81),
        arrayOf(31, 20, -0.89),
        arrayOf(30, 20, -0.97),
        arrayOf(29, 15, -1.05),
        arrayOf(28, 15, -1.12),
        arrayOf(27, 15, -1.2),
        arrayOf(26, 12, -1.28),
        arrayOf(25, 12, -1.36),
        arrayOf(24, 12, -1.44),
        arrayOf(23, 10, -1.52),
        arrayOf(22, 10, -1.6),
        arrayOf(21, 10, -1.68),
        arrayOf(20, 9, -1.76),
        arrayOf(19, 9, -1.84),
        arrayOf(18, 9, -1.91),
        arrayOf(17, 6, -1.99),
        arrayOf(16, 6, -2.07),
        arrayOf(15, 6, -2.15),
        arrayOf(14, 3, -2.23),
        arrayOf(13, 3, -2.31),
        arrayOf(12, 3, -2.39),
        arrayOf(11, 3, -2.47),
        arrayOf(10, 1, -2.55),
        arrayOf(9, 1, -2.63),
        arrayOf(8, 1, -2.71),
        arrayOf(7, 1, -2.78),
        arrayOf(6, 1, -2.86),
        arrayOf(5, 1, -2.94),
        arrayOf(4, 1, -3.02),
        arrayOf(3, 1, -3.1),
        arrayOf(2, 1, -3.18),
        arrayOf(1, 1, -3.26)
    )
}

/**
 * II.- Capacidades Cognitivas
 * B. GrafoMotricidad
 * Page 67
 */
fun grafoMotricidadE0M2Baremo(): Array<Array<Any>> {
    return arrayOf(
        arrayOf(48, 99, 2.18),
        arrayOf(47, 99, 2.05),
        arrayOf(46, 99, 1.91),
        arrayOf(45, 95, 1.77),
        arrayOf(44, 95, 1.64),
        arrayOf(43, 95, 1.5),
        arrayOf(42, 90, 1.36),
        arrayOf(41, 90, 1.22),
        arrayOf(40, 85, 1.09),
        arrayOf(39, 85, 0.95),
        arrayOf(38, 80, 0.81),
        arrayOf(37, 80, 0.67),
        arrayOf(36, 75, 0.54),
        arrayOf(35, 75, 0.4),
        arrayOf(34, 65, 0.26),
        arrayOf(33, 65, 0.13),
        arrayOf(32, 55, -0.01),
        arrayOf(31, 50, -0.15),
        arrayOf(30, 40, -0.29),
        arrayOf(29, 30, -0.42),
        arrayOf(28, 30, -0.56),
        arrayOf(27, 25, -0.7),
        arrayOf(26, 20, -0.83),
        arrayOf(25, 15, -0.97),
        arrayOf(24, 10, -1.11),
        arrayOf(23, 9, -1.25),
        arrayOf(22, 7, -1.38),
        arrayOf(21, 5, -1.52),
        arrayOf(20, 3, -1.66),
        arrayOf(19, 2, -1.79),
        arrayOf(18, 1, -1.93)
    )
}

/**
 * III.- Capacidades Linguisticas
 * A. Palabras y Frases
 * Page 73
 */
fun palabrasyFrasesE0M3Baremo(): Array<Array<Any>> {
    return arrayOf(
        arrayOf(24, 99, 2.06),
        arrayOf(23, 97, 1.76),
        arrayOf(22, 95, 1.46),
        arrayOf(21, 85, 1.16),
        arrayOf(20, 75, 0.86),
        arrayOf(19, 65, 0.56),
        arrayOf(18, 55, 0.26),
        arrayOf(17, 50, -0.05),
        arrayOf(16, 40, -0.35),
        arrayOf(15, 37, -0.65),
        arrayOf(14, 35, -0.95),
        arrayOf(13, 20, -1.25),
        arrayOf(12, 15, -1.55),
        arrayOf(11, 10, -1.85),
        arrayOf(10, 8, -2.15),
        arrayOf(9, 6, -2.45),
        arrayOf(8, 4, -2.75),
        arrayOf(7, 1, -3.05),
    )
}

/**
 * III.- Capacidades Linguisticas
 * B. Recepcion Auditiva y Articulacion
 * Page 79
 */
fun recepcionAuditivaE0M3Baremo(): Array<Array<Any>> {
    return arrayOf(
        arrayOf(102, 99, 1.91),
        arrayOf(101, 98, 1.80),
        arrayOf(100, 97, 1.69),
        arrayOf(99, 96, 1.57),
        arrayOf(98, 95, 1.46),
        arrayOf(97, 90, 1.35),
        arrayOf(96, 85, 1.24),
        arrayOf(95, 75, 1.13),
        arrayOf(93, 65, 0.91),
        arrayOf(91, 60, 0.69),
        arrayOf(89, 55, 0.47),
        arrayOf(86, 50, 0.13),
        arrayOf(83, 45, -0.2),
        arrayOf(80, 40, -0.53),
        arrayOf(77, 35, -0.87),
        arrayOf(74, 30, -1.2),
        arrayOf(71, 20, -1.53),
        arrayOf(69, 15, -1.75),
        arrayOf(65, 10, -2.2),
        arrayOf(60, 5, -2.75),
    )
}

/**
 * III.- Capacidades Linguisticas
 * C. Habilidades Fonologicas
 * Page 83
 */
fun habilidadesFonologicasE0M3Baremo(): Array<Array<Any>> {
    return arrayOf(
        arrayOf(62, 99, 1.71),
        arrayOf(61, 99, 1.62),
        arrayOf(60, 99, 1.52),
        arrayOf(59, 95, 1.42),
        arrayOf(58, 95, 1.32),
        arrayOf(57, 95, 1.22),
        arrayOf(56, 90, 1.12),
        arrayOf(55, 90, 1.02),
        arrayOf(54, 80, 0.92),
        arrayOf(53, 80, 0.82),
        arrayOf(52, 70, 0.72),
        arrayOf(51, 70, 0.62),
        arrayOf(50, 65, 0.52),
        arrayOf(49, 65, 0.42),
        arrayOf(48, 60, 0.32),
        arrayOf(47, 60, 0.23),
        arrayOf(46, 55, 0.13),
        arrayOf(45, 55, 0.03),
        arrayOf(44, 50, -0.07),
        arrayOf(43, 50, -0.17),
        arrayOf(42, 40, -0.27),
        arrayOf(41, 40, -0.37),
        arrayOf(40, 30, -0.47),
        arrayOf(39, 30, -0.57),
        arrayOf(38, 20, -0.67),
        arrayOf(37, 20, -0.77),
        arrayOf(36, 20, -0.87),
        arrayOf(35, 15, -0.97),
        arrayOf(34, 15, -1.07),
        arrayOf(33, 10, -1.16),
        arrayOf(32, 10, -1.26),
        arrayOf(31, 10, -1.36),
        arrayOf(30, 7, -1.46),
        arrayOf(29, 7, -1.56),
        arrayOf(28, 7, -1.66),
        arrayOf(27, 7, -1.76),
        arrayOf(26, 7, -1.86),
        arrayOf(25, 7, -1.96),
        arrayOf(24, 7, -2.06),
        arrayOf(23, 7, -2.16),
        arrayOf(22, 7, -2.26),
        arrayOf(21, 7, -2.36),
        arrayOf(20, 5, -2.46),
        arrayOf(19, 5, -2.56),
        arrayOf(18, 5, -2.65),
        arrayOf(17, 5, -2.75),
        arrayOf(16, 5, -2.85),
        arrayOf(15, 3, -2.95),
        arrayOf(14, 3, -3.05),
        arrayOf(13, 3, -3.15),
        arrayOf(12, 3, -3.25),
        arrayOf(11, 3, -3.35),
        arrayOf(10, 1, -3.45),
        arrayOf(9, 1, -3.55),
        arrayOf(8, 1, -3.65),
        arrayOf(7, 1, -3.75),
        arrayOf(6, 1, -3.85),
        arrayOf(5, 1, -3.95),
    )
}



