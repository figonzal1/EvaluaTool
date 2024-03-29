/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2023

 Last modified 21-06-23 20:51
 */
package cl.figonzal.evaluatool.utils

import cl.figonzal.evaluatool.R
import cl.figonzal.evaluatool.ui.evaluas.evalua0.modulo1.ClasificacionE0M1
import cl.figonzal.evaluatool.ui.evaluas.evalua0.modulo1.IndiceGeneralCognitivoE0M1
import cl.figonzal.evaluatool.ui.evaluas.evalua0.modulo1.LetrasYNumerosE0M1
import cl.figonzal.evaluatool.ui.evaluas.evalua0.modulo1.MemoriaVerbalE0M1
import cl.figonzal.evaluatool.ui.evaluas.evalua0.modulo1.OrganizacionPerceptivaE0M1
import cl.figonzal.evaluatool.ui.evaluas.evalua0.modulo1.SeriesE0M1
import cl.figonzal.evaluatool.ui.evaluas.evalua0.modulo2.CopiaDibujosE0M2
import cl.figonzal.evaluatool.ui.evaluas.evalua0.modulo2.GrafoMotricidadE0M2
import cl.figonzal.evaluatool.ui.evaluas.evalua0.modulo2.IndiceGeneralEspacialE0M2
import cl.figonzal.evaluatool.ui.evaluas.evalua0.modulo3.HabilidadesFonologicasE0M3
import cl.figonzal.evaluatool.ui.evaluas.evalua0.modulo3.IndiceGeneralLinguisticoE0M3
import cl.figonzal.evaluatool.ui.evaluas.evalua0.modulo3.PalabrasYFrasesE0M3
import cl.figonzal.evaluatool.ui.evaluas.evalua0.modulo3.RecepcionAuditivaArticulacionE0M3
import cl.figonzal.evaluatool.ui.evaluas.evalua1.modulo1.MemoriaAtencionE1M1
import cl.figonzal.evaluatool.ui.evaluas.evalua1.modulo2.ClasificacionesE1M2
import cl.figonzal.evaluatool.ui.evaluas.evalua1.modulo2.OrganizacionPerceptivaE1M2
import cl.figonzal.evaluatool.ui.evaluas.evalua1.modulo2.SeriesE1M2
import cl.figonzal.evaluatool.ui.evaluas.evalua1.modulo2.ValoracionGlobalBasesRazonamientoE1M2
import cl.figonzal.evaluatool.ui.evaluas.evalua1.modulo3.NivelesAdaptacionE1M3
import cl.figonzal.evaluatool.ui.evaluas.evalua1.modulo4.ComprensionLectoraE1M4
import cl.figonzal.evaluatool.ui.evaluas.evalua1.modulo4.ExactitudLectoraE1M4
import cl.figonzal.evaluatool.ui.evaluas.evalua1.modulo4.ValoracionGlobalLecturaE1M4
import cl.figonzal.evaluatool.ui.evaluas.evalua1.modulo5.OrtografiaFoneticaE1M5
import cl.figonzal.evaluatool.ui.evaluas.evalua1.modulo5.OrtografiaVisualE1M5
import cl.figonzal.evaluatool.ui.evaluas.evalua1.modulo5.ValoracionGlobalEscrituraE1M5
import cl.figonzal.evaluatool.ui.evaluas.evalua1.modulo6.CalculoNumeracionE1M6
import cl.figonzal.evaluatool.ui.evaluas.evalua10.modulo1.AtencionConcentracionE10M1
import cl.figonzal.evaluatool.ui.evaluas.evalua10.modulo2.IndiceGeneralCognitivoE10M2
import cl.figonzal.evaluatool.ui.evaluas.evalua10.modulo2.RazonamientoDeductivoE10M2
import cl.figonzal.evaluatool.ui.evaluas.evalua10.modulo2.RazonamientoEspacialE10M2
import cl.figonzal.evaluatool.ui.evaluas.evalua10.modulo2.RazonamientoInductivoE10M2
import cl.figonzal.evaluatool.ui.evaluas.evalua10.modulo2.ValoracionGlobalRazonamientoE10M2
import cl.figonzal.evaluatool.ui.evaluas.evalua10.modulo3.NivelesAdaptacionE10M3
import cl.figonzal.evaluatool.ui.evaluas.evalua10.modulo4.ComprensionLectoraE10M4
import cl.figonzal.evaluatool.ui.evaluas.evalua10.modulo4.IndiceGeneralLecturaE10M4
import cl.figonzal.evaluatool.ui.evaluas.evalua10.modulo4.VelocidadLectoraE10M4
import cl.figonzal.evaluatool.ui.evaluas.evalua10.modulo5.IndiceGeneralEscrituraE10M5
import cl.figonzal.evaluatool.ui.evaluas.evalua10.modulo5.OrtografiaVisualRegladaE10M5
import cl.figonzal.evaluatool.ui.evaluas.evalua10.modulo6.CalculoNumeracionE10M6
import cl.figonzal.evaluatool.ui.evaluas.evalua10.modulo6.IndiceGeneralMatematicasE10M6
import cl.figonzal.evaluatool.ui.evaluas.evalua10.modulo6.ResolucionProblemasE10M6
import cl.figonzal.evaluatool.ui.evaluas.evalua10.modulo6.ValoracionGlobalMatematicasE10M6
import cl.figonzal.evaluatool.ui.evaluas.evalua2.modulo1.ClasificacionesE2M1
import cl.figonzal.evaluatool.ui.evaluas.evalua2.modulo1.IndiceGeneralCognitivoE2M1
import cl.figonzal.evaluatool.ui.evaluas.evalua2.modulo1.OrganizacionPerceptivaE2M1
import cl.figonzal.evaluatool.ui.evaluas.evalua2.modulo1.PensamientoAnalogicoE2M1
import cl.figonzal.evaluatool.ui.evaluas.evalua2.modulo1.ValoracionGlobalRazonamientoE2M1
import cl.figonzal.evaluatool.ui.evaluas.evalua2.modulo2.MemoriaAtencionE2M2
import cl.figonzal.evaluatool.ui.evaluas.evalua2.modulo3.NivelesAdaptacionE2M3
import cl.figonzal.evaluatool.ui.evaluas.evalua2.modulo4.ComprensionLectoraE2M4
import cl.figonzal.evaluatool.ui.evaluas.evalua2.modulo4.IndiceGeneralLecturaE2M4
import cl.figonzal.evaluatool.ui.evaluas.evalua2.modulo4.ValoracionGlobalLecturaE2M4
import cl.figonzal.evaluatool.ui.evaluas.evalua2.modulo5.IndiceGeneralEscrituraE2M5
import cl.figonzal.evaluatool.ui.evaluas.evalua2.modulo5.OrtografiaE2M5
import cl.figonzal.evaluatool.ui.evaluas.evalua2.modulo5.ValoracionGlobalEscrituraE2M5
import cl.figonzal.evaluatool.ui.evaluas.evalua2.modulo6.CalculoNumeracionE2M6
import cl.figonzal.evaluatool.ui.evaluas.evalua2.modulo6.IndiceGeneralMatematicoE2M6
import cl.figonzal.evaluatool.ui.evaluas.evalua2.modulo6.ResolucionProblemasE2M6
import cl.figonzal.evaluatool.ui.evaluas.evalua2.modulo6.ValoracionGlobalMatematicasE2M6
import cl.figonzal.evaluatool.ui.evaluas.evalua3.modulo1.MemoriaAtencionE3M1
import cl.figonzal.evaluatool.ui.evaluas.evalua3.modulo2.OrganizacionPerceptivaE3M2
import cl.figonzal.evaluatool.ui.evaluas.evalua3.modulo2.PensamientoAnalogicoE3M2
import cl.figonzal.evaluatool.ui.evaluas.evalua3.modulo2.ReflexividadE3M2
import cl.figonzal.evaluatool.ui.evaluas.evalua3.modulo2.ValoracionGlobalBasesE3M2
import cl.figonzal.evaluatool.ui.evaluas.evalua3.modulo3.NivelesAdaptacionE3M3
import cl.figonzal.evaluatool.ui.evaluas.evalua3.modulo4.ComprensionLectoraE3M4
import cl.figonzal.evaluatool.ui.evaluas.evalua3.modulo4.ExactitudLectoraE3M4
import cl.figonzal.evaluatool.ui.evaluas.evalua3.modulo4.ValoracionGlobalLecturaE3M4
import cl.figonzal.evaluatool.ui.evaluas.evalua3.modulo5.OrtografiaFoneticaE3M5
import cl.figonzal.evaluatool.ui.evaluas.evalua3.modulo5.OrtografiaVisualRegladaE3M5
import cl.figonzal.evaluatool.ui.evaluas.evalua3.modulo5.ValoracionGlobalEscrituraE3M5
import cl.figonzal.evaluatool.ui.evaluas.evalua3.modulo6.CalculoNumeracionE3M6
import cl.figonzal.evaluatool.ui.evaluas.evalua3.modulo6.ResolucionProblemasE3M6
import cl.figonzal.evaluatool.ui.evaluas.evalua3.modulo6.ValoracionGlobalAprenMatematE3M6
import cl.figonzal.evaluatool.ui.evaluas.evalua4.modulo1.MemoriaAtencionE4M1
import cl.figonzal.evaluatool.ui.evaluas.evalua4.modulo2.IndiceGeneralCognitivoE4M2
import cl.figonzal.evaluatool.ui.evaluas.evalua4.modulo2.OrganizacionPerceptivaE4M2
import cl.figonzal.evaluatool.ui.evaluas.evalua4.modulo2.PensamientoAnalogicoE4M2
import cl.figonzal.evaluatool.ui.evaluas.evalua4.modulo2.ReflexividadE4M2
import cl.figonzal.evaluatool.ui.evaluas.evalua4.modulo2.ValoracionGlobalRazonamientoE4M2
import cl.figonzal.evaluatool.ui.evaluas.evalua4.modulo3.NivelesAdaptacionE4M3
import cl.figonzal.evaluatool.ui.evaluas.evalua4.modulo4.ComprensionLectoraE4M4
import cl.figonzal.evaluatool.ui.evaluas.evalua4.modulo4.IndiceGeneralLecturaE4M4
import cl.figonzal.evaluatool.ui.evaluas.evalua4.modulo4.ValoracionGlobalLectoraE4M4
import cl.figonzal.evaluatool.ui.evaluas.evalua4.modulo4.VelocidadLectoraE4M4
import cl.figonzal.evaluatool.ui.evaluas.evalua4.modulo5.IndiceGeneralEscrituraE4M5
import cl.figonzal.evaluatool.ui.evaluas.evalua4.modulo5.OrtografiaVisualRegladaE4M5
import cl.figonzal.evaluatool.ui.evaluas.evalua4.modulo6.CalculoNumeracionE4M6
import cl.figonzal.evaluatool.ui.evaluas.evalua4.modulo6.IndiceGeneralMatematicoE4M6
import cl.figonzal.evaluatool.ui.evaluas.evalua4.modulo6.ResolucionProblemasE4M6
import cl.figonzal.evaluatool.ui.evaluas.evalua4.modulo6.ValoracionGlobalMatematicasE4M6
import cl.figonzal.evaluatool.ui.evaluas.evalua5.modulo1.MemoriaAtencionE5M1
import cl.figonzal.evaluatool.ui.evaluas.evalua5.modulo2.OrganizacionPerceptivaE5M2
import cl.figonzal.evaluatool.ui.evaluas.evalua5.modulo2.PensamientoAnalogicoE5M2
import cl.figonzal.evaluatool.ui.evaluas.evalua5.modulo2.ReflexividadE5M2
import cl.figonzal.evaluatool.ui.evaluas.evalua5.modulo2.ValoracionGlobalRazonamientoE5M2
import cl.figonzal.evaluatool.ui.evaluas.evalua5.modulo3.NivelesAdaptacionE5M3
import cl.figonzal.evaluatool.ui.evaluas.evalua5.modulo4.ComprensionLectoraE5M4
import cl.figonzal.evaluatool.ui.evaluas.evalua5.modulo4.ExactitudLectoraE5M4
import cl.figonzal.evaluatool.ui.evaluas.evalua5.modulo4.ValoracionGlobalLecturaE5M4
import cl.figonzal.evaluatool.ui.evaluas.evalua5.modulo4.VelocidadLectoraE5M4
import cl.figonzal.evaluatool.ui.evaluas.evalua5.modulo5.OrtografiaFoneticaE5M5
import cl.figonzal.evaluatool.ui.evaluas.evalua5.modulo5.OrtografiaVisualRegladaE5M5
import cl.figonzal.evaluatool.ui.evaluas.evalua5.modulo5.ValoracionGlobalEscrituraE5M5
import cl.figonzal.evaluatool.ui.evaluas.evalua5.modulo6.CalculoNumeracionE5M6
import cl.figonzal.evaluatool.ui.evaluas.evalua5.modulo6.ResolucionProblemasE5M6
import cl.figonzal.evaluatool.ui.evaluas.evalua5.modulo6.ValoracionGlobalMatematicasE5M6
import cl.figonzal.evaluatool.ui.evaluas.evalua6.modulo1.IndiceGeneralCognitivoE6M1
import cl.figonzal.evaluatool.ui.evaluas.evalua6.modulo1.OrganizacionPerceptivaE6M1
import cl.figonzal.evaluatool.ui.evaluas.evalua6.modulo1.PensamientoAnalogicoE6M1
import cl.figonzal.evaluatool.ui.evaluas.evalua6.modulo1.ReflexividadE6M1
import cl.figonzal.evaluatool.ui.evaluas.evalua6.modulo1.ValoracionGlobalRazonamientoE6M1
import cl.figonzal.evaluatool.ui.evaluas.evalua6.modulo2.MemoriaAtencionE6M2
import cl.figonzal.evaluatool.ui.evaluas.evalua6.modulo3.NivelesAdaptacionE6M3
import cl.figonzal.evaluatool.ui.evaluas.evalua6.modulo4.ComprensionLectoraE6M4
import cl.figonzal.evaluatool.ui.evaluas.evalua6.modulo4.IndiceGeneralLecturaE6M4
import cl.figonzal.evaluatool.ui.evaluas.evalua6.modulo4.ValoracionGlobalLecturaE6M4
import cl.figonzal.evaluatool.ui.evaluas.evalua6.modulo4.VelocidadLectoraE6M4
import cl.figonzal.evaluatool.ui.evaluas.evalua6.modulo5.IndiceGeneralEscrituraE6M5
import cl.figonzal.evaluatool.ui.evaluas.evalua6.modulo5.OrtografiaVisualRegladaE6M5
import cl.figonzal.evaluatool.ui.evaluas.evalua6.modulo6.CalculoNumeracionE6M6
import cl.figonzal.evaluatool.ui.evaluas.evalua6.modulo6.IndiceGeneralMatematicasE6M6
import cl.figonzal.evaluatool.ui.evaluas.evalua6.modulo6.ResolucionProblemasE6M6
import cl.figonzal.evaluatool.ui.evaluas.evalua6.modulo6.ValoracionGlobalMatematicasE6M6
import cl.figonzal.evaluatool.ui.evaluas.evalua7.modulo1.AtencionConcentracionE7M1
import cl.figonzal.evaluatool.ui.evaluas.evalua7.modulo2.RazonamientoDeductivoE7M2
import cl.figonzal.evaluatool.ui.evaluas.evalua7.modulo2.RazonamientoEspacialE7M2
import cl.figonzal.evaluatool.ui.evaluas.evalua7.modulo2.RazonamientoInductivoE7M2
import cl.figonzal.evaluatool.ui.evaluas.evalua7.modulo3.NivelesAdaptacionE7M3
import cl.figonzal.evaluatool.ui.evaluas.evalua7.modulo4.ComprensionLectoraE7M4
import cl.figonzal.evaluatool.ui.evaluas.evalua7.modulo4.EficaciaLectoraE7M4
import cl.figonzal.evaluatool.ui.evaluas.evalua7.modulo4.VelocidadLectoraE7M4
import cl.figonzal.evaluatool.ui.evaluas.evalua7.modulo5.ExpresionEscritaE7M5
import cl.figonzal.evaluatool.ui.evaluas.evalua7.modulo5.OrtografiaFoneticaE7M5
import cl.figonzal.evaluatool.ui.evaluas.evalua7.modulo5.OrtografiaVisualRegladaE7M5
import cl.figonzal.evaluatool.ui.evaluas.evalua7.modulo6.CalculoNumeracionE7M6
import cl.figonzal.evaluatool.ui.evaluas.evalua7.modulo6.ResolucionProblemasE7M6
import cl.figonzal.evaluatool.ui.evaluas.evalua8.modulo1.AtencionConcentracionE8M1
import cl.figonzal.evaluatool.ui.evaluas.evalua8.modulo2.IndiceGeneralCognitivoE8M2
import cl.figonzal.evaluatool.ui.evaluas.evalua8.modulo2.RazonamientoDeductivoE8M2
import cl.figonzal.evaluatool.ui.evaluas.evalua8.modulo2.RazonamientoEspacialE8M2
import cl.figonzal.evaluatool.ui.evaluas.evalua8.modulo2.RazonamientoInductivoE8M2
import cl.figonzal.evaluatool.ui.evaluas.evalua8.modulo2.ValoracionGlobalRazonamientoE8M2
import cl.figonzal.evaluatool.ui.evaluas.evalua8.modulo3.NivelesAdaptacionE8M3
import cl.figonzal.evaluatool.ui.evaluas.evalua8.modulo4.ComprensionLectoraE8M4
import cl.figonzal.evaluatool.ui.evaluas.evalua8.modulo4.EficaciaLectoraE8M4
import cl.figonzal.evaluatool.ui.evaluas.evalua8.modulo4.IndiceGeneralLecturaE8M4
import cl.figonzal.evaluatool.ui.evaluas.evalua8.modulo4.VelocidadLectoraE8M4
import cl.figonzal.evaluatool.ui.evaluas.evalua8.modulo5.IndiceGeneralEscrituraE8M5
import cl.figonzal.evaluatool.ui.evaluas.evalua8.modulo5.OrtografiaVisualRegladaE8M5
import cl.figonzal.evaluatool.ui.evaluas.evalua8.modulo6.CalculoNumeracionE8M6
import cl.figonzal.evaluatool.ui.evaluas.evalua8.modulo6.IndiceGeneralMatematicasE8M6
import cl.figonzal.evaluatool.ui.evaluas.evalua8.modulo6.ResolucionProblemasE8M6
import cl.figonzal.evaluatool.ui.evaluas.evalua8.modulo6.ValoracionGlobalMatematicasE8M6
import cl.figonzal.evaluatool.ui.evaluas.evalua9.modulo1.AtencionConcentracionE9M1
import cl.figonzal.evaluatool.ui.evaluas.evalua9.modulo2.IndiceGeneralCognitivoE9M2
import cl.figonzal.evaluatool.ui.evaluas.evalua9.modulo2.RazonamientoDeductivoE9M2
import cl.figonzal.evaluatool.ui.evaluas.evalua9.modulo2.RazonamientoEspacialE9M2
import cl.figonzal.evaluatool.ui.evaluas.evalua9.modulo2.RazonamientoInductivoE9M2
import cl.figonzal.evaluatool.ui.evaluas.evalua9.modulo2.ValoracionGlobalRazonamientoE9M2
import cl.figonzal.evaluatool.ui.evaluas.evalua9.modulo3.NivelesAdaptacionE9M3
import cl.figonzal.evaluatool.ui.evaluas.evalua9.modulo4.ComprensionLectoraE9M4
import cl.figonzal.evaluatool.ui.evaluas.evalua9.modulo4.EficaciaLectoraE9M4
import cl.figonzal.evaluatool.ui.evaluas.evalua9.modulo4.IndiceGeneralLecturaE9M4
import cl.figonzal.evaluatool.ui.evaluas.evalua9.modulo4.VelocidadLectoraE9M4
import cl.figonzal.evaluatool.ui.evaluas.evalua9.modulo5.IndiceGeneralEscrituraE9M5
import cl.figonzal.evaluatool.ui.evaluas.evalua9.modulo5.OrtografiaVisualRegladaE9M5
import cl.figonzal.evaluatool.ui.evaluas.evalua9.modulo6.CalculoNumeracionE9M6
import cl.figonzal.evaluatool.ui.evaluas.evalua9.modulo6.IndiceGeneralMatematicasE9M6
import cl.figonzal.evaluatool.ui.evaluas.evalua9.modulo6.ResolucionProblemasE9M6
import cl.figonzal.evaluatool.ui.evaluas.evalua9.modulo6.ValoracionGlobalMatematicasE9M6
import cl.figonzal.evaluatool.utils.EvaluaUtils.get

/**
 * This object class is used to configure all routes to open Evalua's subItems
 *
 * @version 17-04-2021
 */
object ConfigRoutes {

    private var routeMapEvalua0 = HashMap<String, List<Any>>()
    private var routeMapEvalua1 = HashMap<String, List<Any>>()
    private var routeMapEvalua2 = HashMap<String, List<Any>>()
    private var routeMapEvalua3 = HashMap<String, List<Any>>()
    private var routeMapEvalua4 = HashMap<String, List<Any>>()
    private var routeMapEvalua5 = HashMap<String, List<Any>>()
    private var routeMapEvalua6 = HashMap<String, List<Any>>()
    private var routeMapEvalua7 = HashMap<String, List<Any>>()
    private var routeMapEvalua8 = HashMap<String, List<Any>>()
    private var routeMapEvalua9 = HashMap<String, List<Any>>()
    private var routeMapEvalua10 = HashMap<String, List<Any>>()

    //List of activity routes
    val routeMap = mapOf(
        get(R.string.routeMapEvalua0) to routeMapEvalua0,
        get(R.string.routeMapEvalua1) to routeMapEvalua1,
        get(R.string.routeMapEvalua2) to routeMapEvalua2,
        get(R.string.routeMapEvalua3) to routeMapEvalua3,
        get(R.string.routeMapEvalua4) to routeMapEvalua4,
        get(R.string.routeMapEvalua5) to routeMapEvalua5,
        get(R.string.routeMapEvalua6) to routeMapEvalua6,
        get(R.string.routeMapEvalua7) to routeMapEvalua7,
        get(R.string.routeMapEvalua8) to routeMapEvalua8,
        get(R.string.routeMapEvalua9) to routeMapEvalua9,
        get(R.string.routeMapEvalua10) to routeMapEvalua10
    )

    //Initialization of routes
    init {
        setRouteMapEvalua0()
        setRouteMapEvalua1()
        setRouteMapEvalua2()
        setRouteMapEvalua3()
        setRouteMapEvalua4()
        setRouteMapEvalua5()
        setRouteMapEvalua6()
        setRouteMapEvalua7()
        setRouteMapEvalua8()
        setRouteMapEvalua9()
        setRouteMapEvalua10()
    }

    /**
     * Configuration of routes that are used in Evalua 0
     *
     * @return Unit
     */
    private fun setRouteMapEvalua0() {

        val subItems1 = listOf(
            //Nombre SubItem, Clase, Logger
            listOf(
                get(R.string.EVALUA_0_M1_SI_1),
                ClasificacionE0M1::class.java,
                get(R.string.CLICK_CLASIFICACION)
            ),
            listOf(
                get(R.string.EVALUA_0_M1_SI_2),
                SeriesE0M1::class.java,
                get(R.string.CLICK_SERIES)
            ),
            listOf(
                get(R.string.EVALUA_0_M1_SI_3),
                OrganizacionPerceptivaE0M1::class.java,
                get(R.string.CLICK_ORG_PERCEPTIVA)
            ),
            listOf(
                get(R.string.EVALUA_0_M1_SI_4),
                LetrasYNumerosE0M1::class.java,
                get(R.string.CLICK_LETRAS_NUMEROS)
            ),
            listOf(
                get(R.string.EVALUA_0_M1_SI_5),
                MemoriaVerbalE0M1::class.java,
                get(R.string.CLICK_MEMORIA_VERBAL)
            ),
            listOf(
                get(R.string.EVALUA_0_M1_SI_6),
                IndiceGeneralCognitivoE0M1::class.java,
                get(R.string.CLICK_INDICE_GENERAL_COGNITIVO)
            ),
        )

        val subItems2 = listOf(
            listOf(
                get(R.string.EVALUA_0_M2_SI_1),
                CopiaDibujosE0M2::class.java,
                get(R.string.CLICK_COPIA_DIBUJOS)
            ),
            listOf(
                get(R.string.EVALUA_0_M2_SI_2),
                GrafoMotricidadE0M2::class.java,
                get(R.string.CLICK_GRAFO_MOTRICIDAD)
            ),
            listOf(
                get(R.string.EVALUA_0_M2_SI_3),
                IndiceGeneralEspacialE0M2::class.java,
                get(R.string.CLICK_INDICE_GENERAL_ESPACIAL)
            )
        )


        val subItems3 = listOf(
            listOf(
                get(R.string.EVALUA_0_M3_SI_1),
                PalabrasYFrasesE0M3::class.java,
                get(R.string.CLICK_PALABRAS_FRASES)
            ),
            listOf(
                get(R.string.EVALUA_0_M3_SI_2),
                RecepcionAuditivaArticulacionE0M3::class.java,
                get(R.string.CLICK_RECEPCION_AUDITIVA)
            ),
            listOf(
                get(R.string.EVALUA_0_M3_SI_3),
                HabilidadesFonologicasE0M3::class.java,
                get(R.string.CLICK_HABILIDADES_FONOLOGICAS)
            ),
            listOf(
                get(R.string.EVALUA_0_M3_SI_4),
                IndiceGeneralLinguisticoE0M3::class.java,
                get(R.string.CLICK_INDICE_GENERAL_LINGUISTICO)
            )
        )


        routeMapEvalua0.apply {
            put(EvaluaUtils.get(R.string.EVALUA_0_MODULO_1), subItems1)
            put(EvaluaUtils.get(R.string.EVALUA_0_MODULO_2), subItems2)
            put(EvaluaUtils.get(R.string.EVALUA_0_MODULO_3), subItems3)
        }
    }

    /**
     * Configuration of routes that are used in Evalua 1
     *
     * @return Unit
     */
    private fun setRouteMapEvalua1() {

        val subItems1 = listOf(
            listOf(
                get(R.string.EVALUA_1_M1_SI_1),
                MemoriaAtencionE1M1::class.java,
                get(R.string.CLICK_MEMORIA_ATENCION)
            )
        )

        val subItems2 = listOf(
            listOf(
                get(R.string.EVALUA_1_M1_SI_1),
                SeriesE1M2::class.java,
                get(R.string.CLICK_SERIES)
            ),
            listOf(
                get(R.string.EVALUA_1_M2_SI_2),
                ClasificacionesE1M2::class.java,
                get(R.string.CLICK_CLASIFICACION)
            ),
            listOf(
                get(R.string.EVALUA_1_M2_SI_3),
                OrganizacionPerceptivaE1M2::class.java,
                get(R.string.CLICK_ORG_PERCEPTIVA)
            ),
            listOf(
                get(R.string.EVALUA_1_VALORACION_BASES_RAZONAMIENTO),
                ValoracionGlobalBasesRazonamientoE1M2::class.java,
                get(R.string.CLICK_VALORACION_GLOBAL)
            )
        )

        val subItems3 = listOf(
            listOf(
                get(R.string.EVALUA_1_M3_SI_1),
                NivelesAdaptacionE1M3::class.java,
                get(R.string.CLICK_NIVELES_ADAPTACION)
            )
        )

        val subItems4 = listOf(
            listOf(
                get(R.string.EVALUA_1_M4_SI_1),
                ComprensionLectoraE1M4::class.java,
                get(R.string.CLICK_COMPRENSION_LECTORA)
            ),
            listOf(
                get(R.string.EVALUA_1_M4_SI_2),
                ExactitudLectoraE1M4::class.java,
                get(R.string.CLICK_EXACTITUD_LECTORA)
            ),
            listOf(
                get(R.string.EVALUA_1_VALORACION_LECTURA),
                ValoracionGlobalLecturaE1M4::class.java,
                get(R.string.CLICK_VALORACION_GLOBAL)
            )
        )

        val subItems5 = listOf(
            listOf(
                get(R.string.EVALUA_1_M5_SI_1),
                OrtografiaFoneticaE1M5::class.java,
                get(R.string.CLICK_ORTOGRAFIA_FONETICA)
            ),
            listOf(
                get(R.string.EVALUA_1_M5_SI_2),
                OrtografiaVisualE1M5::class.java,
                get(R.string.CLICK_ORTOGRAFIA_VISUAL)
            ),
            listOf(
                get(R.string.EVALUA_1_VALORACION_ESCRITURA),
                ValoracionGlobalEscrituraE1M5::class.java,
                get(R.string.CLICK_VALORACION_GLOBAL)
            )
        )

        val subItems6 = listOf(
            listOf(
                get(R.string.EVALUA_1_M6_SI_1),
                CalculoNumeracionE1M6::class.java,
                get(R.string.CLICK_CAL_NUMERACION)
            )
        )

        routeMapEvalua1.apply {
            put(EvaluaUtils.get(R.string.EVALUA_1_MODULO_1), subItems1)
            put(EvaluaUtils.get(R.string.EVALUA_1_MODULO_2), subItems2)
            put(EvaluaUtils.get(R.string.EVALUA_1_MODULO_3), subItems3)
            put(EvaluaUtils.get(R.string.EVALUA_1_MODULO_4), subItems4)
            put(EvaluaUtils.get(R.string.EVALUA_1_MODULO_5), subItems5)
            put(EvaluaUtils.get(R.string.EVALUA_1_MODULO_6), subItems6)
        }

    }

    /**
     * Configuration of routes that are used in Evalua 2
     *
     * @return Unit
     */
    private fun setRouteMapEvalua2() {

        val subItems1 = listOf(
            listOf(
                get(R.string.EVALUA_2_M1_SI_1),
                PensamientoAnalogicoE2M1::class.java,
                get(R.string.CLICK_PENSAMIENTO_ANALOGICO)
            ),
            listOf(
                get(R.string.EVALUA_2_M1_SI_2),
                OrganizacionPerceptivaE2M1::class.java,
                get(R.string.CLICK_ORG_PERCEPTIVA)
            ),
            listOf(
                get(R.string.EVALUA_2_M1_SI_3),
                ClasificacionesE2M1::class.java,
                get(R.string.CLICK_CLASIFICACION)
            ),
            listOf(
                get(R.string.EVALUA_2_VALORACION_GLOBAL_RAZONAMIENTO),
                ValoracionGlobalRazonamientoE2M1::class.java,
                get(R.string.CLICK_VALORACION_GLOBAL)
            ),
            listOf(
                get(R.string.EVALUA_2_INDICE_GENERAL_COGNITIVO),
                IndiceGeneralCognitivoE2M1::class.java,
                get(R.string.CLICK_INDICE_GENERAL_COGNITIVO)
            )
        )

        val subItems2 = listOf(
            listOf(
                get(R.string.EVALUA_2_M2_SI_1),
                MemoriaAtencionE2M2::class.java,
                get(R.string.CLICK_MEMORIA_ATENCION)
            )
        )


        val subItems3 = listOf(
            listOf(
                get(R.string.EVALUA_2_M3_SI_1),
                NivelesAdaptacionE2M3::class.java,
                get(R.string.CLICK_NIVELES_ADAPTACION)
            )
        )

        val subItems4 = listOf(
            listOf(
                get(R.string.EVALUA_2_M4_SI_1),
                ComprensionLectoraE2M4::class.java,
                get(R.string.CLICK_COMPRENSION_LECTORA)
            ),
            listOf(
                get(R.string.EVALUA_2_VALORACION_GLOBAL_LECTURA),
                ValoracionGlobalLecturaE2M4::class.java,
                get(R.string.CLICK_VALORACION_GLOBAL)
            ),
            listOf(
                get(R.string.EVALUA_2_INDICE_GENERAL_LECTURA),
                IndiceGeneralLecturaE2M4::class.java,
                get(R.string.CLICK_INDICE_GENERAL_LECTURA)
            )
        )

        val subItems5 = listOf(
            listOf(
                get(R.string.EVALUA_2_M5_SI_1),
                OrtografiaE2M5::class.java,
                get(R.string.CLICK_ORTOGRAFIA)
            ),
            listOf(
                get(R.string.EVALUA_2_VALORACION_GLOBAL_ESCRITURA),
                ValoracionGlobalEscrituraE2M5::class.java,
                get(R.string.CLICK_VALORACION_GLOBAL)
            ),
            listOf(
                get(R.string.EVALUA_2_INDICE_GENERAL_ESCRITURA),
                IndiceGeneralEscrituraE2M5::class.java,
                get(R.string.CLICK_INDICE_GENERAL_ESCRITURA)
            )
        )

        val subItems6 = listOf(
            listOf(
                get(R.string.EVALUA_2_M6_SI_1),
                CalculoNumeracionE2M6::class.java,
                get(R.string.CLICK_CAL_NUMERACION)
            ),
            listOf(
                get(R.string.EVALUA_2_M6_SI_2),
                ResolucionProblemasE2M6::class.java,
                get(R.string.CLICK_CAL_RES_PROBLEMAS)
            ),
            listOf(
                get(R.string.EVALUA_2_VALORACION_GLOBAL_MATEMATICA),
                ValoracionGlobalMatematicasE2M6::class.java,
                get(R.string.CLICK_VALORACION_GLOBAL)
            ),
            listOf(
                get(R.string.EVALUA_2_INDICE_GENERAL_MATEMATICO),
                IndiceGeneralMatematicoE2M6::class.java,
                get(R.string.CLICK_INDICE_GENERAL_MATEMATICO)
            )
        )

        routeMapEvalua2.apply {
            put(EvaluaUtils.get(R.string.EVALUA_2_MODULO_1), subItems1)
            put(EvaluaUtils.get(R.string.EVALUA_2_MODULO_2), subItems2)
            put(EvaluaUtils.get(R.string.EVALUA_2_MODULO_3), subItems3)
            put(EvaluaUtils.get(R.string.EVALUA_2_MODULO_4), subItems4)
            put(EvaluaUtils.get(R.string.EVALUA_2_MODULO_5), subItems5)
            put(EvaluaUtils.get(R.string.EVALUA_2_MODULO_6), subItems6)
        }


    }

    /**
     * Configuration of routes that are used in Evalua 3
     *
     * @return Unit
     */
    private fun setRouteMapEvalua3() {

        val subItems1 = listOf(
            listOf(
                get(R.string.EVALUA_3_M1_SI_1),
                MemoriaAtencionE3M1::class.java,
                get(R.string.CLICK_MEMORIA_ATENCION)
            )
        )

        val subItems2 = listOf(
            listOf(
                get(R.string.EVALUA_3_M2_SI_1),
                ReflexividadE3M2::class.java,
                get(R.string.CLICK_REFLEXIVIDAD)
            ),
            listOf(
                get(R.string.EVALUA_3_M2_SI_2),
                PensamientoAnalogicoE3M2::class.java,
                get(R.string.CLICK_PENSAMIENTO_ANALOGICO)
            ),
            listOf(
                get(R.string.EVALUA_3_M2_SI_3),
                OrganizacionPerceptivaE3M2::class.java,
                get(R.string.CLICK_ORG_PERCEPTIVA)
            ),
            listOf(
                get(R.string.EVALUA_3_VALORACION_GLOBAL_RAZONAMIENTO),
                ValoracionGlobalBasesE3M2::class.java,
                get(R.string.CLICK_NIVELES_ADAPTACION)
            )
        )

        val subItems3 = listOf(
            listOf(
                get(R.string.EVALUA_3_M3_SI_1),
                NivelesAdaptacionE3M3::class.java,
                get(R.string.CLICK_MEMORIA_ATENCION)
            )
        )

        val subItems4 = listOf(
            listOf(
                get(R.string.EVALUA_3_M4_SI_1),
                ComprensionLectoraE3M4::class.java,
                get(R.string.CLICK_COMPR_LECTORA)
            ),
            listOf(
                get(R.string.EVALUA_3_M4_SI_2),
                ExactitudLectoraE3M4::class.java,
                get(R.string.CLICK_EXACTITUD_LECTORA)
            ),
            listOf(
                get(R.string.EVALUA_3_VALORACION_GLOBAL_LECTURA),
                ValoracionGlobalLecturaE3M4::class.java,
                get(R.string.CLICK_VALORACION_GLOBAL)
            )
        )


        val subItems5 = listOf(
            listOf(
                get(R.string.EVALUA_3_M5_SI_1),
                OrtografiaFoneticaE3M5::class.java,
                get(R.string.CLICK_ORTOGRAFIA_FONETICA)
            ),
            listOf(
                get(R.string.EVALUA_3_M5_SI_2),
                OrtografiaVisualRegladaE3M5::class.java,
                get(R.string.CLICK_ORT_VIS_REGLADA)
            ),
            listOf(
                get(R.string.EVALUA_3_VALORACION_GLOBAL_ESCRITURA),
                ValoracionGlobalEscrituraE3M5::class.java,
                get(R.string.CLICK_VALORACION_GLOBAL)
            )
        )

        val subItems6 = listOf(
            listOf(
                get(R.string.EVALUA_3_M6_SI_1),
                CalculoNumeracionE3M6::class.java,
                get(R.string.CLICK_CAL_NUMERACION)
            ),
            listOf(
                get(R.string.EVALUA_3_M6_SI_2),
                ResolucionProblemasE3M6::class.java,
                get(R.string.CLICK_CAL_RES_PROBLEMAS)
            ),
            listOf(
                get(R.string.EVALUA_3_VALORACION_GLOBAL_MATEMATICA),
                ValoracionGlobalAprenMatematE3M6::class.java,
                get(R.string.CLICK_VALORACION_GLOBAL)
            )
        )

        routeMapEvalua3.apply {
            put(EvaluaUtils.get(R.string.EVALUA_3_MODULO_1), subItems1)
            put(EvaluaUtils.get(R.string.EVALUA_3_MODULO_2), subItems2)
            put(EvaluaUtils.get(R.string.EVALUA_3_MODULO_3), subItems3)
            put(EvaluaUtils.get(R.string.EVALUA_3_MODULO_4), subItems4)
            put(EvaluaUtils.get(R.string.EVALUA_3_MODULO_5), subItems5)
            put(EvaluaUtils.get(R.string.EVALUA_3_MODULO_6), subItems6)
        }
    }

    /**
     * Configuration of routes that are used in Evalua 4
     *
     * @return Unit
     */
    private fun setRouteMapEvalua4() {

        val subItems1 = listOf(
            listOf(
                get(R.string.EVALUA_4_M1_SI_1),
                MemoriaAtencionE4M1::class.java,
                get(R.string.CLICK_MEMORIA_ATENCION)
            )
        )

        val subItems2 = listOf(
            listOf(
                get(R.string.EVALUA_4_M2_SI_1),
                ReflexividadE4M2::class.java,
                get(R.string.CLICK_REFLEXIVIDAD)
            ),
            listOf(
                get(R.string.EVALUA_4_M2_SI_2),
                PensamientoAnalogicoE4M2::class.java,
                get(R.string.CLICK_PENSAMIENTO_ANALOGICO)
            ),
            listOf(
                get(R.string.EVALUA_4_M2_SI_3),
                OrganizacionPerceptivaE4M2::class.java,
                get(R.string.CLICK_ORG_PERCEPTIVA)
            ),
            listOf(
                get(R.string.EVALUA_4_VALORACION_GLOBAL_RAZONAMIENTO),
                ValoracionGlobalRazonamientoE4M2::class.java,
                get(R.string.CLICK_VALORACION_GLOBAL)
            ),
            listOf(
                get(R.string.EVALUA_4_INDICE_GENERAL_COGNITIVO),
                IndiceGeneralCognitivoE4M2::class.java,
                get(R.string.CLICK_INDICE_GENERAL_COGNITIVO)
            )
        )

        val subItems3 = listOf(
            listOf(
                get(R.string.EVALUA_4_M3_SI_1),
                NivelesAdaptacionE4M3::class.java,
                get(R.string.CLICK_NIVELES_ADAPTACION)
            )
        )

        val subItems4 = listOf(
            listOf(
                get(R.string.EVALUA_4_M4_SI_1),
                ComprensionLectoraE4M4::class.java,
                get(R.string.CLICK_COMPRENSION_LECTORA)
            ),
            listOf(
                get(R.string.EVALUA_4_M4_SI_2),
                VelocidadLectoraE4M4::class.java,
                get(R.string.CLICK_VELOCIDAD_LECTORA)
            ),
            listOf(
                get(R.string.EVALUA_4_VALORACION_GLOBAL_LECTURA),
                ValoracionGlobalLectoraE4M4::class.java,
                get(R.string.CLICK_VALORACION_GLOBAL)
            ),
            listOf(
                get(R.string.EVALUA_4_INDICE_GENERAL_LECTURA),
                IndiceGeneralLecturaE4M4::class.java,
                get(R.string.CLICK_INDICE_GENERAL_LECTURA)
            )
        )

        val subItems5 = listOf(
            listOf(
                get(R.string.EVALUA_4_M5_SI_1),
                OrtografiaVisualRegladaE4M5::class.java,
                get(R.string.CLICK_ORT_VIS_REGLADA)
            ),
            listOf(
                get(R.string.EVALUA_4_INDICE_GENERAL_ESCRITURA),
                IndiceGeneralEscrituraE4M5::class.java,
                get(R.string.CLICK_INDICE_GENERAL_ESCRITURA)
            )
        )

        val subItems6 = listOf(
            listOf(
                get(R.string.EVALUA_4_M6_SI_1),
                CalculoNumeracionE4M6::class.java,
                get(R.string.CLICK_CAL_NUMERACION)
            ),
            listOf(
                get(R.string.EVALUA_4_M6_SI_2),
                ResolucionProblemasE4M6::class.java,
                get(R.string.CLICK_CAL_RES_PROBLEMAS)
            ),
            listOf(
                get(R.string.EVALUA_4_VALORACION_GLOBAL_MATEMATICAS),
                ValoracionGlobalMatematicasE4M6::class.java,
                get(R.string.CLICK_VALORACION_GLOBAL)
            ),
            listOf(
                get(R.string.EVALUA_4_INDICE_GENERAL_MATEMATICO),
                IndiceGeneralMatematicoE4M6::class.java,
                get(R.string.CLICK_INDICE_GENERAL_MATEMATICO)
            )
        )

        routeMapEvalua4.apply {
            put(EvaluaUtils.get(R.string.EVALUA_4_MODULO_1), subItems1)
            put(EvaluaUtils.get(R.string.EVALUA_4_MODULO_2), subItems2)
            put(EvaluaUtils.get(R.string.EVALUA_4_MODULO_3), subItems3)
            put(EvaluaUtils.get(R.string.EVALUA_4_MODULO_4), subItems4)
            put(EvaluaUtils.get(R.string.EVALUA_4_MODULO_5), subItems5)
            put(EvaluaUtils.get(R.string.EVALUA_4_MODULO_6), subItems6)
        }
    }

    /**
     * Configuration of routes that are used in Evalua 5
     *
     * @return Unit
     */
    private fun setRouteMapEvalua5() {

        val subItems1 = listOf(
            listOf(
                get(R.string.EVALUA_5_M1_SI_1),
                MemoriaAtencionE5M1::class.java,
                get(R.string.CLICK_MEMORIA_ATENCION)
            )
        )

        val subItems2 = listOf(
            listOf(
                get(R.string.EVALUA_5_M2_SI_1),
                ReflexividadE5M2::class.java,
                get(R.string.CLICK_REFLEXIVIDAD)
            ),
            listOf(
                get(R.string.EVALUA_5_M2_SI_2),
                PensamientoAnalogicoE5M2::class.java,
                get(R.string.CLICK_PENSAMIENTO_ANALOGICO)
            ),
            listOf(
                get(R.string.EVALUA_5_M2_SI_3),
                OrganizacionPerceptivaE5M2::class.java,
                get(R.string.CLICK_ORG_PERCEPTIVA)
            ),
            listOf(
                get(R.string.EVALUA_5_VALORACION_GLOBAL_RAZONAMIENTO),
                ValoracionGlobalRazonamientoE5M2::class.java,
                get(R.string.CLICK_VALORACION_GLOBAL)
            )
        )

        val subItems3 = listOf(
            listOf(
                get(R.string.EVALUA_5_M3_SI_1),
                NivelesAdaptacionE5M3::class.java,
                get(R.string.CLICK_NIVELES_ADAPTACION)
            )
        )


        val subItems4 = listOf(
            listOf(
                get(R.string.EVALUA_5_M4_SI_1),
                ComprensionLectoraE5M4::class.java,
                get(R.string.CLICK_COMPRENSION_LECTORA)
            ),
            listOf(
                get(R.string.EVALUA_5_M4_SI_2),
                VelocidadLectoraE5M4::class.java,
                get(R.string.CLICK_VELOCIDAD_LECTORA)
            ),
            listOf(
                get(R.string.EVALUA_5_M4_SI_3),
                ExactitudLectoraE5M4::class.java,
                get(R.string.CLICK_EXACTITUD_LECTORA)
            ),
            listOf(
                get(R.string.EVALUA_5_VALORACION_GLOBAL_LECTURA),
                ValoracionGlobalLecturaE5M4::class.java,
                get(R.string.CLICK_VALORACION_GLOBAL)
            )
        )


        val subItems5 = listOf(
            listOf(
                get(R.string.EVALUA_5_M5_SI_1),
                OrtografiaFoneticaE5M5::class.java,
                get(R.string.CLICK_ORTOGRAFIA_FONETICA)
            ),
            listOf(
                get(R.string.EVALUA_5_M5_SI_1),
                OrtografiaVisualRegladaE5M5::class.java,
                get(R.string.CLICK_ORTOGRAFIA_VISUAL)
            ),
            listOf(
                get(R.string.EVALUA_5_VALORACION_GLOBAL_ESCRITURA),
                ValoracionGlobalEscrituraE5M5::class.java,
                get(R.string.CLICK_VALORACION_GLOBAL)
            )
        )


        val subItems6 = listOf(
            listOf(
                get(R.string.EVALUA_5_M6_SI_1),
                CalculoNumeracionE5M6::class.java,
                get(R.string.CLICK_CAL_NUMERACION)
            ),
            listOf(
                get(R.string.EVALUA_5_M6_SI_2),
                ResolucionProblemasE5M6::class.java,
                get(R.string.CLICK_CAL_RES_PROBLEMAS)
            ),
            listOf(
                get(R.string.EVALUA_5_VALORACION_GLOBAL_MATEMATICA),
                ValoracionGlobalMatematicasE5M6::class.java,
                get(R.string.CLICK_VALORACION_GLOBAL)
            )
        )

        routeMapEvalua5.apply {
            put(EvaluaUtils.get(R.string.EVALUA_5_MODULO_1), subItems1)
            put(EvaluaUtils.get(R.string.EVALUA_5_MODULO_2), subItems2)
            put(EvaluaUtils.get(R.string.EVALUA_5_MODULO_3), subItems3)
            put(EvaluaUtils.get(R.string.EVALUA_5_MODULO_4), subItems4)
            put(EvaluaUtils.get(R.string.EVALUA_5_MODULO_5), subItems5)
            put(EvaluaUtils.get(R.string.EVALUA_5_MODULO_6), subItems6)
        }
    }

    private fun setRouteMapEvalua6() {

        val subItems1 = listOf(
            listOf(
                get(R.string.EVALUA_6_M1_SI_1),
                ReflexividadE6M1::class.java,
                get(R.string.CLICK_REFLEXIVIDAD)
            ),
            listOf(
                get(R.string.EVALUA_6_M1_SI_2),
                PensamientoAnalogicoE6M1::class.java,
                get(R.string.CLICK_PENSAMIENTO_ANALOGICO)
            ),
            listOf(
                get(R.string.EVALUA_6_M1_SI_3),
                OrganizacionPerceptivaE6M1::class.java,
                get(R.string.CLICK_ORG_PERCEPTIVA)
            ),
            listOf(
                get(R.string.EVALUA_6_VALORACION_GLOBAL_RAZONAMIENTO),
                ValoracionGlobalRazonamientoE6M1::class.java,
                get(R.string.CLICK_VALORACION_GLOBAL)
            ),
            listOf(
                get(R.string.EVALUA_6_INDICE_GENERAL_COGNITIVO),
                IndiceGeneralCognitivoE6M1::class.java,
                get(R.string.CLICK_INDICE_GENERAL_COGNITIVO)
            )
        )

        val subItems2 = listOf(
            listOf(
                get(R.string.EVALUA_6_M2_SI_1),
                MemoriaAtencionE6M2::class.java,
                get(R.string.CLICK_MEMORIA_ATENCION)
            )
        )

        val subItems3 = listOf(
            listOf(
                get(R.string.EVALUA_6_M3_SI_1),
                NivelesAdaptacionE6M3::class.java,
                get(R.string.CLICK_NIVELES_ADAPTACION)
            )
        )

        val subItems4 = listOf(
            listOf(
                get(R.string.EVALUA_6_M4_SI_1),
                ComprensionLectoraE6M4::class.java,
                get(R.string.CLICK_COMPRENSION_LECTORA)
            ),
            listOf(
                get(R.string.EVALUA_6_M4_SI_2),
                VelocidadLectoraE6M4::class.java,
                get(R.string.CLICK_VELOCIDAD_LECTORA)
            ),
            listOf(
                get(R.string.EVALUA_6_VALORACION_GLOBAL_LECTURA),
                ValoracionGlobalLecturaE6M4::class.java,
                get(R.string.CLICK_VALORACION_GLOBAL)
            ),
            listOf(
                get(R.string.EVALUA_6_INDICE_GENERAL_LECTURA),
                IndiceGeneralLecturaE6M4::class.java,
                get(R.string.CLICK_INDICE_GENERAL_LECTURA)
            )
        )

        val subItems5 = listOf(
            listOf(
                get(R.string.EVALUA_6_M5_SI_1),
                OrtografiaVisualRegladaE6M5::class.java,
                get(R.string.CLICK_ORTOGRAFIA_VISUAL)
            ),
            listOf(
                get(R.string.EVALUA_6_INDICE_GENERAL_ESCRITURA),
                IndiceGeneralEscrituraE6M5::class.java,
                get(R.string.CLICK_INDICE_GENERAL_ESCRITURA)
            )
        )
        val subItems6 = listOf(
            listOf(
                get(R.string.EVALUA_6_M6_SI_1),
                CalculoNumeracionE6M6::class.java,
                get(R.string.CLICK_CAL_NUMERACION)
            ),
            listOf(
                get(R.string.EVALUA_6_M6_SI_2),
                ResolucionProblemasE6M6::class.java,
                get(R.string.CLICK_CAL_RES_PROBLEMAS)
            ),
            listOf(
                get(R.string.EVALUA_6_VALORACION_GLOBAL_MATEMATICAS),
                ValoracionGlobalMatematicasE6M6::class.java,
                get(R.string.CLICK_VALORACION_GLOBAL)
            ),
            listOf(
                get(R.string.EVALUA_6_INDICE_GENERAL_MATEMATICAS),
                IndiceGeneralMatematicasE6M6::class.java,
                get(R.string.CLICK_INDICE_GENERAL_MATEMATICO)
            )
        )

        routeMapEvalua6.apply {
            put(EvaluaUtils.get(R.string.EVALUA_6_MODULO_1), subItems1)
            put(EvaluaUtils.get(R.string.EVALUA_6_MODULO_2), subItems2)
            put(EvaluaUtils.get(R.string.EVALUA_6_MODULO_3), subItems3)
            put(EvaluaUtils.get(R.string.EVALUA_6_MODULO_4), subItems4)
            put(EvaluaUtils.get(R.string.EVALUA_6_MODULO_5), subItems5)
            put(EvaluaUtils.get(R.string.EVALUA_6_MODULO_6), subItems6)
        }
    }

    /**
     * Configuration of routes that are used in Evalua 7
     *
     * @return Unit
     */
    private fun setRouteMapEvalua7() {

        val subItems1 = listOf(
            listOf(
                get(R.string.EVALUA_7_M1_SI_1),
                AtencionConcentracionE7M1::class.java,
                get(R.string.CLICK_ATEN_CONCENTRACION)
            )
        )

        val subItems2 = listOf(
            listOf(
                get(R.string.EVALUA_7_M2_SI_1),
                RazonamientoDeductivoE7M2::class.java,
                get(R.string.CLICK_RAZON_DEDUCTIVO)
            ),
            listOf(
                get(R.string.EVALUA_7_M2_SI_2),
                RazonamientoInductivoE7M2::class.java,
                get(R.string.CLICK_RAZON_INDUCTIVO)
            ),
            listOf(
                get(R.string.EVALUA_7_M2_SI_3),
                RazonamientoEspacialE7M2::class.java,
                get(R.string.CLICK_RAZON_ESPACIAL)
            )
        )

        val subItems3 = listOf(
            listOf(
                get(R.string.EVALUA_7_M3_SI_1),
                NivelesAdaptacionE7M3::class.java,
                get(R.string.CLICK_NIVELES_ADAPTACION)
            )
        )

        val subItems4 = listOf(
            listOf(
                get(R.string.EVALUA_7_M4_SI_1),
                EficaciaLectoraE7M4::class.java,
                get(R.string.CLICK_EFICACIA_LECTORA)
            ),
            listOf(
                get(R.string.EVALUA_7_M4_SI_2),
                ComprensionLectoraE7M4::class.java,
                get(R.string.CLICK_COMPRENSION_LECTORA)
            ),
            listOf(
                get(R.string.EVALUA_7_M4_SI_3),
                VelocidadLectoraE7M4::class.java,
                get(R.string.CLICK_VELOCIDAD_LECTORA)
            )
        )

        val subItems5 = listOf(
            listOf(
                get(R.string.EVALUA_7_M5_SI_1),
                OrtografiaFoneticaE7M5::class.java,
                get(R.string.CLICK_ORTOGRAFIA_FONETICA)
            ),
            listOf(
                get(R.string.EVALUA_7_M5_SI_2),
                ExpresionEscritaE7M5::class.java,
                get(R.string.CLICK_EXP_ESCRITA)
            ),
            listOf(
                get(R.string.EVALUA_7_M5_SI_3),
                OrtografiaVisualRegladaE7M5::class.java,
                get(R.string.CLICK_ORT_VIS_REGLADA)
            )
        )

        val subItems6 = listOf(
            listOf(
                get(R.string.EVALUA_7_M6_SI_1),
                CalculoNumeracionE7M6::class.java,
                get(R.string.CLICK_CAL_NUMERACION)
            ),
            listOf(
                get(R.string.EVALUA_7_M6_SI_2),
                ResolucionProblemasE7M6::class.java,
                get(R.string.CLICK_CAL_RES_PROBLEMAS)
            )
        )

        routeMapEvalua7.apply {
            put(EvaluaUtils.get(R.string.EVALUA_7_MODULO_1), subItems1)
            put(EvaluaUtils.get(R.string.EVALUA_7_MODULO_2), subItems2)
            put(EvaluaUtils.get(R.string.EVALUA_7_MODULO_3), subItems3)
            put(EvaluaUtils.get(R.string.EVALUA_7_MODULO_4), subItems4)
            put(EvaluaUtils.get(R.string.EVALUA_7_MODULO_5), subItems5)
            put(EvaluaUtils.get(R.string.EVALUA_7_MODULO_6), subItems6)
        }
    }

    /**
     * Configuration of routes that are used in Evalua 8
     *
     * @return Unit
     */
    private fun setRouteMapEvalua8() {
        val subItems1 = listOf(
            listOf(
                get(R.string.EVALUA_8_M1_SI_1),
                AtencionConcentracionE8M1::class.java,
                get(R.string.CLICK_ATEN_CONCENTRACION)
            )
        )

        val subItems2 = listOf(
            listOf(
                get(R.string.EVALUA_8_M2_SI_1),
                RazonamientoInductivoE8M2::class.java,
                get(R.string.CLICK_RAZON_INDUCTIVO)
            ),
            listOf(
                get(R.string.EVALUA_8_M2_SI_2),
                RazonamientoEspacialE8M2::class.java,
                get(R.string.CLICK_RAZON_ESPACIAL)
            ),
            listOf(
                get(R.string.EVALUA_8_M2_SI_3),
                RazonamientoDeductivoE8M2::class.java,
                get(R.string.CLICK_RAZON_DEDUCTIVO)
            ),
            listOf(
                get(R.string.EVALUA_8_VALORACION_GLOBAL_RAZONAMIENTO),
                ValoracionGlobalRazonamientoE8M2::class.java,
                get(R.string.CLICK_VALORACION_GLOBAL)
            ),
            listOf(
                get(R.string.EVALUA_8_INDICE_GENERAL_COGNITIVO),
                IndiceGeneralCognitivoE8M2::class.java,
                get(R.string.CLICK_INDICE_GENERAL_COGNITIVO)
            )
        )

        val subItems3 = listOf(
            listOf(
                get(R.string.EVALUA_8_M3_SI_1),
                NivelesAdaptacionE8M3::class.java,
                get(R.string.CLICK_NIVELES_ADAPTACION)
            )
        )

        val subItems4 = listOf(
            listOf(
                get(R.string.EVALUA_8_M4_SI_1),
                ComprensionLectoraE8M4::class.java,
                get(R.string.CLICK_COMPRENSION_LECTORA)
            ),
            listOf(
                get(R.string.EVALUA_8_M4_SI_2),
                EficaciaLectoraE8M4::class.java,
                get(R.string.CLICK_EFICACIA_LECTORA)
            ),
            listOf(
                get(R.string.EVALUA_8_M4_SI_3),
                VelocidadLectoraE8M4::class.java,
                get(R.string.CLICK_VELOCIDAD_LECTORA)
            ),
            listOf(
                get(R.string.EVALUA_8_INDICE_GENERAL_LECTURA),
                IndiceGeneralLecturaE8M4::class.java,
                get(R.string.CLICK_INDICE_GENERAL_LECTURA)
            )
        )

        val subItems5 = listOf(
            listOf(
                get(R.string.EVALUA_8_M5_SI_1),
                OrtografiaVisualRegladaE8M5::class.java,
                get(R.string.CLICK_ORTOGRAFIA_VISUAL)
            ),
            listOf(
                get(R.string.EVALUA_8_INDICE_GENERAL_ESCRITURA),
                IndiceGeneralEscrituraE8M5::class.java,
                get(R.string.CLICK_INDICE_GENERAL_ESCRITURA)
            )
        )

        val subItems6 = listOf(
            listOf(
                get(R.string.EVALUA_8_M6_SI_1),
                CalculoNumeracionE8M6::class.java,
                get(R.string.CLICK_CAL_NUMERACION)
            ),
            listOf(
                get(R.string.EVALUA_8_M6_SI_2),
                ResolucionProblemasE8M6::class.java,
                get(R.string.CLICK_CAL_RES_PROBLEMAS)
            ),
            listOf(
                get(R.string.EVALUA_8_VALORACION_GLOBAL_MATEMATICAS),
                ValoracionGlobalMatematicasE8M6::class.java,
                get(R.string.CLICK_VALORACION_GLOBAL)
            ),
            listOf(
                get(R.string.EVALUA_8_INDICE_GENERAL_MATEMATICAS),
                IndiceGeneralMatematicasE8M6::class.java,
                get(R.string.CLICK_INDICE_GENERAL_MATEMATICO)
            )
        )

        routeMapEvalua8.apply {
            put(EvaluaUtils.get(R.string.EVALUA_8_MODULO_1), subItems1)
            put(EvaluaUtils.get(R.string.EVALUA_8_MODULO_2), subItems2)
            put(EvaluaUtils.get(R.string.EVALUA_8_MODULO_3), subItems3)
            put(EvaluaUtils.get(R.string.EVALUA_8_MODULO_4), subItems4)
            put(EvaluaUtils.get(R.string.EVALUA_8_MODULO_5), subItems5)
            put(EvaluaUtils.get(R.string.EVALUA_8_MODULO_6), subItems6)
        }
    }

    /**
     * Configuration of routes that are used in Evalua 9
     *
     * @return Unit
     */
    private fun setRouteMapEvalua9() {
        val subItems1 = listOf(
            listOf(
                get(R.string.EVALUA_9_M1_SI_1),
                AtencionConcentracionE9M1::class.java,
                get(R.string.CLICK_ATEN_CONCENTRACION)
            )
        )

        val subItems2 = listOf(
            listOf(
                get(R.string.EVALUA_9_M2_SI_1),
                RazonamientoInductivoE9M2::class.java,
                get(R.string.CLICK_RAZON_INDUCTIVO)
            ),
            listOf(
                get(R.string.EVALUA_9_M2_SI_2),
                RazonamientoEspacialE9M2::class.java,
                get(R.string.CLICK_RAZON_ESPACIAL)
            ),
            listOf(
                get(R.string.EVALUA_9_M2_SI_3),
                RazonamientoDeductivoE9M2::class.java,
                get(R.string.CLICK_RAZON_DEDUCTIVO)
            ),
            listOf(
                get(R.string.EVALUA_9_VALORACION_GLOBAL_RAZONAMIENTO),
                ValoracionGlobalRazonamientoE9M2::class.java,
                get(R.string.CLICK_VALORACION_GLOBAL)
            ),
            listOf(
                get(R.string.EVALUA_9_INDICE_GENERAL_COGNITIVO),
                IndiceGeneralCognitivoE9M2::class.java,
                get(R.string.CLICK_INDICE_GENERAL_COGNITIVO)
            )
        )

        val subItems3 = listOf(
            listOf(
                get(R.string.EVALUA_9_M3_SI_1),
                NivelesAdaptacionE9M3::class.java,
                get(R.string.CLICK_NIVELES_ADAPTACION)
            )
        )

        val subItems4 = listOf(
            listOf(
                get(R.string.EVALUA_9_M4_SI_1),
                ComprensionLectoraE9M4::class.java,
                get(R.string.CLICK_COMPRENSION_LECTORA)
            ),
            listOf(
                get(R.string.EVALUA_9_M4_SI_2),
                EficaciaLectoraE9M4::class.java,
                get(R.string.CLICK_EFICACIA_LECTORA)
            ),
            listOf(
                get(R.string.EVALUA_9_M4_SI_3),
                VelocidadLectoraE9M4::class.java,
                get(R.string.CLICK_VELOCIDAD_LECTORA)
            ),
            listOf(
                get(R.string.EVALUA_9_INDICE_GENERAL_LECTURA),
                IndiceGeneralLecturaE9M4::class.java,
                get(R.string.CLICK_INDICE_GENERAL_LECTURA)
            )
        )

        val subItems5 = listOf(
            listOf(
                get(R.string.EVALUA_9_M5_SI_1),
                OrtografiaVisualRegladaE9M5::class.java,
                get(R.string.CLICK_ORTOGRAFIA_VISUAL)
            ),
            listOf(
                get(R.string.EVALUA_9_INDICE_GENERAL_ESCRITURA),
                IndiceGeneralEscrituraE9M5::class.java,
                get(R.string.CLICK_INDICE_GENERAL_ESCRITURA)
            )
        )

        val subItems6 = listOf(
            listOf(
                get(R.string.EVALUA_9_M6_SI_1),
                CalculoNumeracionE9M6::class.java,
                get(R.string.CLICK_CAL_NUMERACION)
            ), listOf(
                get(R.string.EVALUA_9_M6_SI_2),
                ResolucionProblemasE9M6::class.java,
                get(R.string.CLICK_CAL_RES_PROBLEMAS)
            ), listOf(
                get(R.string.EVALUA_9_VALORACION_GLOBAL_MATEMATICAS),
                ValoracionGlobalMatematicasE9M6::class.java,
                get(R.string.CLICK_VALORACION_GLOBAL)
            ), listOf(
                get(R.string.EVALUA_9_INDICE_GENERAL_MATEMATICAS),
                IndiceGeneralMatematicasE9M6::class.java,
                get(R.string.CLICK_INDICE_GENERAL_MATEMATICO)
            )
        )

        routeMapEvalua9.apply {
            put(EvaluaUtils.get(R.string.EVALUA_9_MODULO_1), subItems1)
            put(EvaluaUtils.get(R.string.EVALUA_9_MODULO_2), subItems2)
            put(EvaluaUtils.get(R.string.EVALUA_9_MODULO_3), subItems3)
            put(EvaluaUtils.get(R.string.EVALUA_9_MODULO_4), subItems4)
            put(EvaluaUtils.get(R.string.EVALUA_9_MODULO_5), subItems5)
            put(EvaluaUtils.get(R.string.EVALUA_9_MODULO_6), subItems6)
        }
    }

    /**
     * Configuration of routes that are used in Evalua 10
     *
     * @return Unit
     */
    private fun setRouteMapEvalua10() {
        val subItems1 = listOf(
            listOf(
                get(R.string.EVALUA_10_M1_SI_1),
                AtencionConcentracionE10M1::class.java,
                get(R.string.CLICK_ATEN_CONCENTRACION)
            )
        )

        val subItems2 = listOf(
            listOf(
                get(R.string.EVALUA_10_M2_SI_1),
                RazonamientoInductivoE10M2::class.java,
                get(R.string.CLICK_RAZON_INDUCTIVO)
            ),
            listOf(
                get(R.string.EVALUA_10_M2_SI_2),
                RazonamientoEspacialE10M2::class.java,
                get(R.string.CLICK_RAZON_ESPACIAL)
            ),
            listOf(
                get(R.string.EVALUA_10_M2_SI_3),
                RazonamientoDeductivoE10M2::class.java,
                get(R.string.CLICK_RAZON_DEDUCTIVO)
            ),
            listOf(
                get(R.string.EVALUA_10_VALORACION_GLOBAL_RAZONAMIENTO),
                ValoracionGlobalRazonamientoE10M2::class.java,
                get(R.string.CLICK_VALORACION_GLOBAL)
            ),
            listOf(
                get(R.string.EVALUA_10_INDICE_GENERAL_COGNITIVO),
                IndiceGeneralCognitivoE10M2::class.java,
                get(R.string.CLICK_INDICE_GENERAL_COGNITIVO)
            )
        )

        val subItems3 = listOf(
            listOf(
                get(R.string.EVALUA_10_M3_SI_1),
                NivelesAdaptacionE10M3::class.java,
                get(R.string.CLICK_NIVELES_ADAPTACION)
            )
        )

        val subItems4 = listOf(
            listOf(
                get(R.string.EVALUA_10_M4_SI_1),
                ComprensionLectoraE10M4::class.java,
                get(R.string.CLICK_COMPRENSION_LECTORA)
            ),
            listOf(
                get(R.string.EVALUA_10_M4_SI_2),
                VelocidadLectoraE10M4::class.java,
                get(R.string.CLICK_VELOCIDAD_LECTORA)
            ),
            listOf(
                get(R.string.EVALUA_10_INDICE_GENERAL_LECTURA),
                IndiceGeneralLecturaE10M4::class.java,
                get(R.string.CLICK_INDICE_GENERAL_LECTURA)
            )
        )

        val subItems5 = listOf(
            listOf(
                get(R.string.EVALUA_10_M5_SI_1),
                OrtografiaVisualRegladaE10M5::class.java,
                get(R.string.CLICK_ORTOGRAFIA_VISUAL)
            ),
            listOf(
                get(R.string.EVALUA_10_INDICE_GENERAL_ESCRITURA),
                IndiceGeneralEscrituraE10M5::class.java,
                get(R.string.CLICK_INDICE_GENERAL_ESCRITURA)
            )
        )

        val subItems6 = listOf(
            listOf(
                get(R.string.EVALUA_10_M6_SI_1),
                CalculoNumeracionE10M6::class.java,
                get(R.string.CLICK_CAL_NUMERACION)
            ),
            listOf(
                get(R.string.EVALUA_10_M6_SI_2),
                ResolucionProblemasE10M6::class.java,
                get(R.string.CLICK_CAL_RES_PROBLEMAS)
            ),
            listOf(
                get(R.string.EVALUA_10_VALORACION_GLOBAL_MATEMATICAS),
                ValoracionGlobalMatematicasE10M6::class.java,
                get(R.string.CLICK_INDICE_GENERAL_MATEMATICO)
            ),
            listOf(
                get(R.string.EVALUA_10_INDICE_GENERAL_MATEMATICAS),
                IndiceGeneralMatematicasE10M6::class.java,
                get(R.string.CLICK_INDICE_GENERAL_MATEMATICO)
            )
        )

        routeMapEvalua10.apply {
            put(EvaluaUtils.get(R.string.EVALUA_10_MODULO_1), subItems1)
            put(EvaluaUtils.get(R.string.EVALUA_10_MODULO_2), subItems2)
            put(EvaluaUtils.get(R.string.EVALUA_10_MODULO_3), subItems3)
            put(EvaluaUtils.get(R.string.EVALUA_10_MODULO_4), subItems4)
            put(EvaluaUtils.get(R.string.EVALUA_10_MODULO_5), subItems5)
            put(EvaluaUtils.get(R.string.EVALUA_10_MODULO_6), subItems6)
        }
    }
}