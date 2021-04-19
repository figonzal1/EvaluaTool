/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2021

 Last modified 18-04-21 21:35
 */
package cl.figonzal.evaluatool.utilidades

import cl.figonzal.evaluatool.R
import cl.figonzal.evaluatool.evalua.evalua0.modulo1.*
import cl.figonzal.evaluatool.evalua.evalua0.modulo2.CopiaDibujosE0M2
import cl.figonzal.evaluatool.evalua.evalua0.modulo2.GrafoMotricidadE0M2
import cl.figonzal.evaluatool.evalua.evalua0.modulo2.IndiceGeneralEspacialE0M2
import cl.figonzal.evaluatool.evalua.evalua0.modulo3.HabilidadesFonologicasE0M3
import cl.figonzal.evaluatool.evalua.evalua0.modulo3.IndiceGeneralLinguisticoE0M3
import cl.figonzal.evaluatool.evalua.evalua0.modulo3.PalabrasYFrasesE0M3
import cl.figonzal.evaluatool.evalua.evalua0.modulo3.RecepcionAuditivaArticulacionE0M3
import cl.figonzal.evaluatool.evalua.evalua1.modulo1.MemoriaAtencionE1M1
import cl.figonzal.evaluatool.evalua.evalua1.modulo2.ClasificacionesE1M2
import cl.figonzal.evaluatool.evalua.evalua1.modulo2.OrganizacionPerceptivaE1M2
import cl.figonzal.evaluatool.evalua.evalua1.modulo2.SeriesE1M2
import cl.figonzal.evaluatool.evalua.evalua1.modulo2.ValoracionGlobalBasesE1M2
import cl.figonzal.evaluatool.evalua.evalua1.modulo3.NivelesAdaptacionE1M3
import cl.figonzal.evaluatool.evalua.evalua1.modulo4.ComprensionLectoraE1M4
import cl.figonzal.evaluatool.evalua.evalua1.modulo4.ExactitudLectoraE1M4
import cl.figonzal.evaluatool.evalua.evalua1.modulo4.ValoracionGlobalLecturaE1M4
import cl.figonzal.evaluatool.evalua.evalua1.modulo5.OrtografiaFoneticaE1M5
import cl.figonzal.evaluatool.evalua.evalua1.modulo5.OrtografiaVisualE1M5
import cl.figonzal.evaluatool.evalua.evalua1.modulo6.CalculoNumeracionE1M6
import cl.figonzal.evaluatool.evalua.evalua2.modulo1.*
import cl.figonzal.evaluatool.evalua.evalua2.modulo2.MemoriaAtencionE2M2
import cl.figonzal.evaluatool.evalua.evalua2.modulo3.NivelesAdaptacionE2M3
import cl.figonzal.evaluatool.evalua.evalua2.modulo4.ComprensionLectoraE2M4
import cl.figonzal.evaluatool.evalua.evalua2.modulo5.OrtografiaE2M5
import cl.figonzal.evaluatool.evalua.evalua2.modulo6.CalculoNumeracionE2M6
import cl.figonzal.evaluatool.evalua.evalua2.modulo6.IndiceGeneralMatematicoE2M6
import cl.figonzal.evaluatool.evalua.evalua2.modulo6.ResolucionProblemasE2M6
import cl.figonzal.evaluatool.evalua.evalua2.modulo6.ValoracionGlobalMatematicasE2M6
import cl.figonzal.evaluatool.evalua.evalua3.modulo1.MemoriaAtencionE3M1
import cl.figonzal.evaluatool.evalua.evalua3.modulo2.OrganizacionPerceptivaE3M2
import cl.figonzal.evaluatool.evalua.evalua3.modulo2.PensamientoAnalogicoE3M2
import cl.figonzal.evaluatool.evalua.evalua3.modulo2.ReflexividadE3M2
import cl.figonzal.evaluatool.evalua.evalua3.modulo2.ValoracionGlobalBasesE3M2
import cl.figonzal.evaluatool.evalua.evalua3.modulo3.NivelesAdaptacionE3M3
import cl.figonzal.evaluatool.evalua.evalua3.modulo4.ComprensionLectoraE3M4
import cl.figonzal.evaluatool.evalua.evalua3.modulo4.ExactitudLectoraE3M4
import cl.figonzal.evaluatool.evalua.evalua3.modulo4.ValoracionGlobalLecturaE3M4
import cl.figonzal.evaluatool.evalua.evalua3.modulo5.OrtografiaFoneticaE3M5
import cl.figonzal.evaluatool.evalua.evalua3.modulo5.OrtografiaVisualRegladaE3M5
import cl.figonzal.evaluatool.evalua.evalua3.modulo6.CalculoNumeracionE3M6
import cl.figonzal.evaluatool.evalua.evalua3.modulo6.ResolucionProblemasE3M6
import cl.figonzal.evaluatool.evalua.evalua3.modulo6.ValoracionGlobalAprenMatematE3M6
import cl.figonzal.evaluatool.evalua.evalua4.modulo1.MemoriaAtencionE4M1
import cl.figonzal.evaluatool.evalua.evalua4.modulo2.*
import cl.figonzal.evaluatool.evalua.evalua4.modulo3.NivelesAdaptacionE4M3
import cl.figonzal.evaluatool.evalua.evalua4.modulo4.ComprensionLectoraE4M4
import cl.figonzal.evaluatool.evalua.evalua4.modulo4.IndiceGeneralLecturaE4M4
import cl.figonzal.evaluatool.evalua.evalua4.modulo4.ValoracionGlobalLectoraE4M4
import cl.figonzal.evaluatool.evalua.evalua4.modulo4.VelocidadLectoraE4M4
import cl.figonzal.evaluatool.evalua.evalua4.modulo5.OrtografiaVisualRegladaE4M5
import cl.figonzal.evaluatool.evalua.evalua4.modulo6.CalculoNumeracionE4M6
import cl.figonzal.evaluatool.evalua.evalua4.modulo6.IndiceGeneralMatematicoE4M6
import cl.figonzal.evaluatool.evalua.evalua4.modulo6.ResolucionProblemasE4M6
import cl.figonzal.evaluatool.evalua.evalua4.modulo6.ValoracionGlobalMatematicasE4M6
import cl.figonzal.evaluatool.evalua.evalua5.modulo1.MemoriaAtencionE5M1
import cl.figonzal.evaluatool.evalua.evalua5.modulo2.OrganizacionPerceptivaE5M2
import cl.figonzal.evaluatool.evalua.evalua5.modulo2.PensamientoAnalogicoE5M2
import cl.figonzal.evaluatool.evalua.evalua5.modulo2.ReflexividadE5M2
import cl.figonzal.evaluatool.evalua.evalua5.modulo2.ValoracionGlobalRazonamientoE5M2
import cl.figonzal.evaluatool.evalua.evalua5.modulo3.NivelesAdaptacionE5M3
import cl.figonzal.evaluatool.evalua.evalua5.modulo4.ComprensionLectoraE5M4
import cl.figonzal.evaluatool.evalua.evalua5.modulo4.ExactitudLectoraE5M4
import cl.figonzal.evaluatool.evalua.evalua5.modulo4.ValoracionGlobalLecturaE5M4
import cl.figonzal.evaluatool.evalua.evalua5.modulo4.VelocidadLectoraE5M4
import cl.figonzal.evaluatool.evalua.evalua5.modulo5.OrtografiaFoneticaE5M5
import cl.figonzal.evaluatool.evalua.evalua5.modulo5.OrtografiaVisualRegladaE5M5
import cl.figonzal.evaluatool.evalua.evalua5.modulo6.CalculoNumeracionE5M6
import cl.figonzal.evaluatool.evalua.evalua5.modulo6.ResolucionProblemasE5M6
import cl.figonzal.evaluatool.evalua.evalua7.modulo1.AtencionConcentracionE7M1
import cl.figonzal.evaluatool.evalua.evalua7.modulo2.RazonamientoDeductivoE7M2
import cl.figonzal.evaluatool.evalua.evalua7.modulo2.RazonamientoEspacialE7M2
import cl.figonzal.evaluatool.evalua.evalua7.modulo2.RazonamientoInductivoE7M2
import cl.figonzal.evaluatool.evalua.evalua7.modulo4.ComprensionLectoraE7M4
import cl.figonzal.evaluatool.evalua.evalua7.modulo4.EficaciaLectoraE7M4
import cl.figonzal.evaluatool.evalua.evalua7.modulo4.VelocidadLectoraE7M4
import cl.figonzal.evaluatool.evalua.evalua7.modulo5.ExpresionEscritaE7M5
import cl.figonzal.evaluatool.evalua.evalua7.modulo5.OrtografiaFoneticaE7M5
import cl.figonzal.evaluatool.evalua.evalua7.modulo5.OrtografiaVisualRegladaE7M5
import cl.figonzal.evaluatool.evalua.evalua7.modulo6.CalculoNumeracionE7M6
import cl.figonzal.evaluatool.evalua.evalua7.modulo6.ResolucionProblemasE7M6

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
    private var routeMapEvalua7 = HashMap<String, List<Any>>()

    //List of activity routes
    val routeMap = mapOf(
            Utils.get(R.string.routeMapEvalua0) to routeMapEvalua0,
            Utils.get(R.string.routeMapEvalua1) to routeMapEvalua1,
            Utils.get(R.string.routeMapEvalua2) to routeMapEvalua2,
            Utils.get(R.string.routeMapEvalua3) to routeMapEvalua3,
            Utils.get(R.string.routeMapEvalua4) to routeMapEvalua4,
            Utils.get(R.string.routeMapEvalua5) to routeMapEvalua5,
            Utils.get(R.string.routeMapEvalua7) to routeMapEvalua7
    )

    //Initialization of routes
    init {
        setRouteMapEvalua0()
        setRouteMapEvalua1()
        setRouteMapEvalua2()
        setRouteMapEvalua3()
        setRouteMapEvalua4()
        setRouteMapEvalua5()
        setRouteMapEvalua7()
    }

    /**
     * Configuration of routes that are used in Evalua 0
     *
     * @return Unit
     */
    private fun setRouteMapEvalua0() {

        val subItems1 = listOf(
                //Nombre SubItem, Clase, Logger
                listOf(Utils.get(R.string.EVALUA_0_M1_SI_1), ClasificacionE0M1::class.java, Utils.get(R.string.CLICK_CLASIFICACION)),
                listOf(Utils.get(R.string.EVALUA_0_M1_SI_2), SeriesE0M1::class.java, Utils.get(R.string.CLICK_SERIES)),
                listOf(Utils.get(R.string.EVALUA_0_M1_SI_3), OrganizacionPerceptivaE0M1::class.java, Utils.get(R.string.CLICK_ORG_PERCEPTIVA)),
                listOf(Utils.get(R.string.EVALUA_0_M1_SI_4), LetrasYNumerosE0M1::class.java, Utils.get(R.string.CLICK_LETRAS_NUMEROS)),
                listOf(Utils.get(R.string.EVALUA_0_M1_SI_5), MemoriaVerbalE0M1::class.java, Utils.get(R.string.CLICK_MEMORIA_VERBAL)),
                listOf(Utils.get(R.string.EVALUA_0_M1_SI_6), IndiceGeneralCognitivoE0M1::class.java, Utils.get(R.string.CLICK_INDICE_GENERAL_COGNITIVO)),
        )

        val subItems2 = listOf(
                listOf(Utils.get(R.string.EVALUA_0_M2_SI_1), CopiaDibujosE0M2::class.java, Utils.get(R.string.CLICK_COPIA_DIBUJOS)),
                listOf(Utils.get(R.string.EVALUA_0_M2_SI_2), GrafoMotricidadE0M2::class.java, Utils.get(R.string.CLICK_GRAFO_MOTRICIDAD)),
                listOf(Utils.get(R.string.EVALUA_0_M2_SI_3), IndiceGeneralEspacialE0M2::class.java, Utils.get(R.string.CLICK_INDICE_GENERAL_ESPACIAL))
        )


        val subItems3 = listOf(
                listOf(Utils.get(R.string.EVALUA_0_M3_SI_1), PalabrasYFrasesE0M3::class.java, Utils.get(R.string.CLICK_PALABRAS_FRASES)),
                listOf(Utils.get(R.string.EVALUA_0_M3_SI_2), RecepcionAuditivaArticulacionE0M3::class.java, Utils.get(R.string.CLICK_RECEPCION_AUDITIVA)),
                listOf(Utils.get(R.string.EVALUA_0_M3_SI_3), HabilidadesFonologicasE0M3::class.java, Utils.get(R.string.CLICK_HABILIDADES_FONOLOGICAS)),
                listOf(Utils.get(R.string.EVALUA_0_M3_SI_4), IndiceGeneralLinguisticoE0M3::class.java, Utils.get(R.string.CLICK_INDICE_GENERAL_LINGUISTICO))
        )


        routeMapEvalua0.apply {
            put(Utils.get(R.string.EVALUA_0_MODULO_1), subItems1)
            put(Utils.get(R.string.EVALUA_0_MODULO_2), subItems2)
            put(Utils.get(R.string.EVALUA_0_MODULO_3), subItems3)
        }
    }

    /**
     * Configuration of routes that are used in Evalua 1
     *
     * @return Unit
     */
    private fun setRouteMapEvalua1() {

        val subItems1 = listOf(
                listOf(Utils.get(R.string.EVALUA_1_M1_SI_1), MemoriaAtencionE1M1::class.java, Utils.get(R.string.CLICK_MEMORIA_ATENCION))
        )

        val subItems2 = listOf(
                listOf(Utils.get(R.string.EVALUA_1_M1_SI_1), SeriesE1M2::class.java, Utils.get(R.string.CLICK_SERIES)),
                listOf(Utils.get(R.string.EVALUA_1_M2_SI_2), ClasificacionesE1M2::class.java, Utils.get(R.string.CLICK_CLASIFICACION)),
                listOf(Utils.get(R.string.EVALUA_1_M2_SI_3), OrganizacionPerceptivaE1M2::class.java, Utils.get(R.string.CLICK_ORG_PERCEPTIVA)),
                listOf(Utils.get(R.string.EVALUA_1_EVALUA_GLOBAL), ValoracionGlobalBasesE1M2::class.java, Utils.get(R.string.CLICK_VALORACION_GLOBAL))
        )

        val subItems3 = listOf(
                listOf(Utils.get(R.string.EVALUA_1_M3_SI_1), NivelesAdaptacionE1M3::class.java, Utils.get(R.string.CLICK_NIVELES_ADAPTACION))
        )

        val subItems4 = listOf(
                listOf(Utils.get(R.string.EVALUA_1_M4_SI_1), ComprensionLectoraE1M4::class.java, Utils.get(R.string.CLICK_COMPRENSION_LECTORA)),
                listOf(Utils.get(R.string.EVALUA_1_M4_SI_2), ExactitudLectoraE1M4::class.java, Utils.get(R.string.CLICK_EXACTITUD_LECTORA)),
                listOf(Utils.get(R.string.EVALUA_1_EVALUA_GLOBAL), ValoracionGlobalLecturaE1M4::class.java, Utils.get(R.string.CLICK_VALORACION_GLOBAL))
        )

        val subItems5 = listOf(
                listOf(Utils.get(R.string.EVALUA_1_M5_SI_1), OrtografiaFoneticaE1M5::class.java, Utils.get(R.string.CLICK_ORTOGRAFIA_FONETICA)),
                listOf(Utils.get(R.string.EVALUA_1_M5_SI_2), OrtografiaVisualE1M5::class.java, Utils.get(R.string.CLICK_ORTOGRAFIA_VISUAL))
        )

        val subItems6 = listOf(
                listOf(Utils.get(R.string.EVALUA_1_M6_SI_1), CalculoNumeracionE1M6::class.java, Utils.get(R.string.CLICK_CAL_NUMERACION))
        )

        routeMapEvalua1.apply {
            put(Utils.get(R.string.EVALUA_1_MODULO_1), subItems1)
            put(Utils.get(R.string.EVALUA_1_MODULO_2), subItems2)
            put(Utils.get(R.string.EVALUA_1_MODULO_3), subItems3)
            put(Utils.get(R.string.EVALUA_1_MODULO_4), subItems4)
            put(Utils.get(R.string.EVALUA_1_MODULO_5), subItems5)
            put(Utils.get(R.string.EVALUA_1_MODULO_6), subItems6)
        }

    }

    /**
     * Configuration of routes that are used in Evalua 2
     *
     * @return Unit
     */
    private fun setRouteMapEvalua2() {

        val subItems1 = listOf(
                listOf(Utils.get(R.string.EVALUA_2_M1_SI_1), PensamientoAnalogicoE2M1::class.java, Utils.get(R.string.CLICK_PENSAMIENTO_ANALOGICO)),
                listOf(Utils.get(R.string.EVALUA_2_M1_SI_2), OrganizacionPerceptivaE2M1::class.java, Utils.get(R.string.CLICK_ORG_PERCEPTIVA)),
                listOf(Utils.get(R.string.EVALUA_2_M1_SI_3), ClasificacionesE2M1::class.java, Utils.get(R.string.CLICK_CLASIFICACION)),
                listOf(Utils.get(R.string.EVALUA_2_EVALUA_GLOBAL), ValoracionGlobalRazonamientoE2M1::class.java, Utils.get(R.string.CLICK_VALORACION_GLOBAL)),
                listOf(Utils.get(R.string.EVALUA_2_INDICE_GENERAL_COGNITIVO), IndiceGeneralCognitivoE2M1::class.java, Utils.get(R.string.CLICK_INDICE_GENERAL_COGNITIVO))
        )

        val subItems2 = listOf(
                listOf(Utils.get(R.string.EVALUA_2_M2_SI_1), MemoriaAtencionE2M2::class.java, Utils.get(R.string.CLICK_MEMORIA_ATENCION))
        )


        val subItems3 = listOf(
                listOf(Utils.get(R.string.EVALUA_2_M3_SI_1), NivelesAdaptacionE2M3::class.java, Utils.get(R.string.CLICK_NIVELES_ADAPTACION))
        )

        val subItems4 = listOf(
                listOf(Utils.get(R.string.EVALUA_2_M4_SI_1), ComprensionLectoraE2M4::class.java, Utils.get(R.string.CLICK_COMPRENSION_LECTORA))
        )

        val subItems5 = listOf(
                listOf(Utils.get(R.string.EVALUA_2_M5_SI_1), OrtografiaE2M5::class.java, Utils.get(R.string.CLICK_ORTOGRAFIA))
        )

        val subItems6 = listOf(
                listOf(Utils.get(R.string.EVALUA_2_M6_SI_1), CalculoNumeracionE2M6::class.java, Utils.get(R.string.CLICK_CAL_NUMERACION)),
                listOf(Utils.get(R.string.EVALUA_2_M6_SI_2), ResolucionProblemasE2M6::class.java, Utils.get(R.string.CLICK_CAL_RES_PROBLEMAS)),
                listOf(Utils.get(R.string.EVALUA_2_EVALUA_GLOBAL), ValoracionGlobalMatematicasE2M6::class.java, Utils.get(R.string.CLICK_VALORACION_GLOBAL)),
                listOf(Utils.get(R.string.EVALUA_2_INDICE_GENERAL_MATEMATICO), IndiceGeneralMatematicoE2M6::class.java, Utils.get(R.string.CLICK_INDICE_GENERAL_MATEMATICO))
        )

        routeMapEvalua2.apply {
            put(Utils.get(R.string.EVALUA_2_MODULO_1), subItems1)
            put(Utils.get(R.string.EVALUA_2_MODULO_2), subItems2)
            put(Utils.get(R.string.EVALUA_2_MODULO_3), subItems3)
            put(Utils.get(R.string.EVALUA_2_MODULO_4), subItems4)
            put(Utils.get(R.string.EVALUA_2_MODULO_5), subItems5)
            put(Utils.get(R.string.EVALUA_2_MODULO_6), subItems6)
        }


    }

    /**
     * Configuration of routes that are used in Evalua 3
     *
     * @return Unit
     */
    private fun setRouteMapEvalua3() {

        val subItems1 = listOf(
                listOf(Utils.get(R.string.EVALUA_3_M1_SI_1), MemoriaAtencionE3M1::class.java, Utils.get(R.string.CLICK_MEMORIA_ATENCION))
        )

        val subItems2 = listOf(
                listOf(Utils.get(R.string.EVALUA_3_M2_SI_1), ReflexividadE3M2::class.java, Utils.get(R.string.CLICK_REFLEXIVIDAD)),
                listOf(Utils.get(R.string.EVALUA_3_M2_SI_2), PensamientoAnalogicoE3M2::class.java, Utils.get(R.string.CLICK_PENSAMIENTO_ANALOGICO)),
                listOf(Utils.get(R.string.EVALUA_3_M2_SI_3), OrganizacionPerceptivaE3M2::class.java, Utils.get(R.string.CLICK_ORG_PERCEPTIVA)),
                listOf(Utils.get(R.string.EVALUA_3_EVALUA_GLOBAL), ValoracionGlobalBasesE3M2::class.java, Utils.get(R.string.CLICK_NIVELES_ADAPTACION))
        )

        val subItems3 = listOf(
                listOf(Utils.get(R.string.EVALUA_3_M3_SI_1), NivelesAdaptacionE3M3::class.java, Utils.get(R.string.CLICK_MEMORIA_ATENCION))
        )

        val subItems4 = listOf(
                listOf(Utils.get(R.string.EVALUA_3_M4_SI_1), ComprensionLectoraE3M4::class.java, Utils.get(R.string.CLICK_COMPR_LECTORA)),
                listOf(Utils.get(R.string.EVALUA_3_M4_SI_2), ExactitudLectoraE3M4::class.java, Utils.get(R.string.CLICK_EXACTITUD_LECTORA)),
                listOf(Utils.get(R.string.EVALUA_3_EVALUA_GLOBAL), ValoracionGlobalLecturaE3M4::class.java, Utils.get(R.string.CLICK_VALORACION_GLOBAL))
        )


        val subItems5 = listOf(
                listOf(Utils.get(R.string.EVALUA_3_M5_SI_1), OrtografiaFoneticaE3M5::class.java, Utils.get(R.string.CLICK_ORTOGRAFIA_FONETICA)),
                listOf(Utils.get(R.string.EVALUA_3_M5_SI_2), OrtografiaVisualRegladaE3M5::class.java, Utils.get(R.string.CLICK_ORT_VIS_REGLADA))
        )

        val subItems6 = listOf(
                listOf(Utils.get(R.string.EVALUA_3_M6_SI_1), CalculoNumeracionE3M6::class.java, Utils.get(R.string.CLICK_CAL_NUMERACION)),
                listOf(Utils.get(R.string.EVALUA_3_M6_SI_2), ResolucionProblemasE3M6::class.java, Utils.get(R.string.CLICK_CAL_RES_PROBLEMAS)),
                listOf(Utils.get(R.string.EVALUA_3_EVALUA_GLOBAL), ValoracionGlobalAprenMatematE3M6::class.java, Utils.get(R.string.CLICK_VALORACION_GLOBAL))
        )

        routeMapEvalua3.apply {
            put(Utils.get(R.string.EVALUA_3_MODULO_1), subItems1)
            put(Utils.get(R.string.EVALUA_3_MODULO_2), subItems2)
            put(Utils.get(R.string.EVALUA_3_MODULO_3), subItems3)
            put(Utils.get(R.string.EVALUA_3_MODULO_4), subItems4)
            put(Utils.get(R.string.EVALUA_3_MODULO_5), subItems5)
            put(Utils.get(R.string.EVALUA_3_MODULO_6), subItems6)
        }
    }

    /**
     * Configuration of routes that are used in Evalua 4
     *
     * @return Unit
     */
    private fun setRouteMapEvalua4() {

        val subItems1 = listOf(
                listOf(Utils.get(R.string.EVALUA_4_M1_SI_1), MemoriaAtencionE4M1::class.java, Utils.get(R.string.CLICK_MEMORIA_ATENCION))
        )

        val subItems2 = listOf(
                listOf(Utils.get(R.string.EVALUA_4_M2_SI_1), ReflexividadE4M2::class.java, Utils.get(R.string.CLICK_REFLEXIVIDAD)),
                listOf(Utils.get(R.string.EVALUA_4_M2_SI_2), PensamientoAnalogicoE4M2::class.java, Utils.get(R.string.CLICK_PENSAMIENTO_ANALOGICO)),
                listOf(Utils.get(R.string.EVALUA_4_M2_SI_3), OrganizacionPerceptivaE4M2::class.java, Utils.get(R.string.CLICK_ORG_PERCEPTIVA)),
                listOf(Utils.get(R.string.EVALUA_4_EVALUA_GLOBAL), ValoracionGlobalRazonamientoE4M2::class.java, Utils.get(R.string.CLICK_VALORACION_GLOBAL)),
                listOf(Utils.get(R.string.EVALUA_4_M2_SI_4), IndiceGeneralCognitivoE4M2::class.java, Utils.get(R.string.CLICK_INDICE_GENERAL_COGNITIVO))
        )

        val subItems3 = listOf(
                listOf(Utils.get(R.string.EVALUA_4_M3_SI_1), NivelesAdaptacionE4M3::class.java, Utils.get(R.string.CLICK_NIVELES_ADAPTACION))
        )

        val subItems4 = listOf(
                listOf(Utils.get(R.string.EVALUA_4_M4_SI_1), ComprensionLectoraE4M4::class.java, Utils.get(R.string.CLICK_COMPRENSION_LECTORA)),
                listOf(Utils.get(R.string.EVALUA_4_M4_SI_2), VelocidadLectoraE4M4::class.java, Utils.get(R.string.CLICK_VELOCIDAD_LECTORA)),
                listOf(Utils.get(R.string.EVALUA_4_EVALUA_GLOBAL), ValoracionGlobalLectoraE4M4::class.java, Utils.get(R.string.CLICK_VALORACION_GLOBAL)),
                listOf(Utils.get(R.string.EVALUA_4_M4_SI_3), IndiceGeneralLecturaE4M4::class.java, Utils.get(R.string.CLICK_INDICE_GENERAL_LECTURA))
        )

        val subItems5 = listOf(
                listOf(Utils.get(R.string.EVALUA_4_M5_SI_1), OrtografiaVisualRegladaE4M5::class.java, Utils.get(R.string.CLICK_ORT_VIS_REGLADA))
        )

        val subItems6 = listOf(
                listOf(Utils.get(R.string.EVALUA_4_M6_SI_1), CalculoNumeracionE4M6::class.java, Utils.get(R.string.CLICK_CAL_NUMERACION)),
                listOf(Utils.get(R.string.EVALUA_4_M6_SI_2), ResolucionProblemasE4M6::class.java, Utils.get(R.string.CLICK_CAL_RES_PROBLEMAS)),
                listOf(Utils.get(R.string.EVALUA_4_EVALUA_GLOBAL), ValoracionGlobalMatematicasE4M6::class.java, Utils.get(R.string.CLICK_VALORACION_GLOBAL)),
                listOf(Utils.get(R.string.EVALUA_4_M6_SI_4), IndiceGeneralMatematicoE4M6::class.java, Utils.get(R.string.CLICK_INDICE_GENERAL_MATEMATICO))
        )

        routeMapEvalua4.apply {
            put(Utils.get(R.string.EVALUA_4_MODULO_1), subItems1)
            put(Utils.get(R.string.EVALUA_4_MODULO_2), subItems2)
            put(Utils.get(R.string.EVALUA_4_MODULO_3), subItems3)
            put(Utils.get(R.string.EVALUA_4_MODULO_4), subItems4)
            put(Utils.get(R.string.EVALUA_4_MODULO_5), subItems5)
            put(Utils.get(R.string.EVALUA_4_MODULO_6), subItems6)
        }
    }

    /**
     * Configuration of routes that are used in Evalua 5
     *
     * @return Unit
     */
    private fun setRouteMapEvalua5() {

        val subItems1 = listOf(
                listOf(Utils.get(R.string.EVALUA_5_M1_SI_1), MemoriaAtencionE5M1::class.java, Utils.get(R.string.CLICK_MEMORIA_ATENCION))
        )

        val subItems2 = listOf(
                listOf(Utils.get(R.string.EVALUA_5_M2_SI_1), ReflexividadE5M2::class.java, Utils.get(R.string.CLICK_REFLEXIVIDAD)),
                listOf(Utils.get(R.string.EVALUA_5_M2_SI_2), PensamientoAnalogicoE5M2::class.java, Utils.get(R.string.CLICK_PENSAMIENTO_ANALOGICO)),
                listOf(Utils.get(R.string.EVALUA_5_M2_SI_3), OrganizacionPerceptivaE5M2::class.java, Utils.get(R.string.CLICK_ORG_PERCEPTIVA)),
                listOf(Utils.get(R.string.EVALUA_5_EVALUA_GLOBAL), ValoracionGlobalRazonamientoE5M2::class.java, Utils.get(R.string.CLICK_VALORACION_GLOBAL))
        )

        val subItems3 = listOf(
                listOf(Utils.get(R.string.EVALUA_5_M3_SI_1), NivelesAdaptacionE5M3::class.java, Utils.get(R.string.CLICK_NIVELES_ADAPTACION))
        )


        val subItems4 = listOf(
                listOf(Utils.get(R.string.EVALUA_5_M4_SI_1), ComprensionLectoraE5M4::class.java, Utils.get(R.string.CLICK_COMPRENSION_LECTORA)),
                listOf(Utils.get(R.string.EVALUA_5_M4_SI_2), VelocidadLectoraE5M4::class.java, Utils.get(R.string.CLICK_VELOCIDAD_LECTORA)),
                listOf(Utils.get(R.string.EVALUA_5_M4_SI_3), ExactitudLectoraE5M4::class.java, Utils.get(R.string.CLICK_EXACTITUD_LECTORA)),
                listOf(Utils.get(R.string.EVALUA_5_EVALUA_GLOBAL), ValoracionGlobalLecturaE5M4::class.java, Utils.get(R.string.CLICK_VALORACION_GLOBAL))
        )


        val subItems5 = listOf(
                listOf(Utils.get(R.string.EVALUA_5_M5_SI_1), OrtografiaFoneticaE5M5::class.java, Utils.get(R.string.CLICK_ORTOGRAFIA_FONETICA)),
                listOf(Utils.get(R.string.EVALUA_5_M5_SI_1), OrtografiaVisualRegladaE5M5::class.java, Utils.get(R.string.CLICK_ORTOGRAFIA_VISUAL))
        )


        val subItems6 = listOf(
                listOf(Utils.get(R.string.EVALUA_5_M6_SI_1), CalculoNumeracionE5M6::class.java, Utils.get(R.string.CLICK_CAL_NUMERACION)),
                listOf(Utils.get(R.string.EVALUA_5_M6_SI_2), ResolucionProblemasE5M6::class.java, Utils.get(R.string.CLICK_CAL_RES_PROBLEMAS))
        )

        routeMapEvalua5.apply {
            put(Utils.get(R.string.EVALUA_5_MODULO_1), subItems1)
            put(Utils.get(R.string.EVALUA_5_MODULO_2), subItems2)
            put(Utils.get(R.string.EVALUA_5_MODULO_3), subItems3)
            put(Utils.get(R.string.EVALUA_5_MODULO_4), subItems4)
            put(Utils.get(R.string.EVALUA_5_MODULO_5), subItems5)
            put(Utils.get(R.string.EVALUA_5_MODULO_6), subItems6)
        }
    }

    /**
     * Configuration of routes that are used in Evalua 7
     *
     * @return Unit
     */
    private fun setRouteMapEvalua7() {

        val subItems1 = listOf(
                listOf(Utils.get(R.string.EVALUA_7_M1_SI_1), AtencionConcentracionE7M1::class.java, Utils.get(R.string.CLICK_ATEN_CONCENTRACION))
        )

        val subItems2 = listOf(
                listOf(Utils.get(R.string.EVALUA_7_M2_SI_1), RazonamientoDeductivoE7M2::class.java, Utils.get(R.string.CLICK_RAZON_DEDUCTIVO)),
                listOf(Utils.get(R.string.EVALUA_7_M2_SI_2), RazonamientoInductivoE7M2::class.java, Utils.get(R.string.CLICK_RAZON_INDUCTIVO)),
                listOf(Utils.get(R.string.EVALUA_7_M2_SI_3), RazonamientoEspacialE7M2::class.java, Utils.get(R.string.CLICK_RAZON_ESPACIAL))
        )

        val subItems4 = listOf(
                listOf(Utils.get(R.string.EVALUA_7_M4_SI_1), EficaciaLectoraE7M4::class.java, Utils.get(R.string.CLICK_EFICACIA_LECTORA)),
                listOf(Utils.get(R.string.EVALUA_7_M4_SI_2), ComprensionLectoraE7M4::class.java, Utils.get(R.string.CLICK_COMPRENSION_LECTORA)),
                listOf(Utils.get(R.string.EVALUA_7_M4_SI_3), VelocidadLectoraE7M4::class.java, Utils.get(R.string.CLICK_VELOCIDAD_LECTORA))
        )

        val subItems5 = listOf(
                listOf(Utils.get(R.string.EVALUA_7_M5_SI_1), OrtografiaFoneticaE7M5::class.java, Utils.get(R.string.CLICK_ORTOGRAFIA_FONETICA)),
                listOf(Utils.get(R.string.EVALUA_7_M5_SI_2), ExpresionEscritaE7M5::class.java, Utils.get(R.string.CLICK_EXP_ESCRITA)),
                listOf(Utils.get(R.string.EVALUA_7_M5_SI_3), OrtografiaVisualRegladaE7M5::class.java, Utils.get(R.string.CLICK_ORT_VIS_REGLADA))
        )

        val subItems6 = listOf(
                listOf(Utils.get(R.string.EVALUA_7_M6_SI_1), CalculoNumeracionE7M6::class.java, Utils.get(R.string.CLICK_CAL_NUMERACION)),
                listOf(Utils.get(R.string.EVALUA_7_M6_SI_2), ResolucionProblemasE7M6::class.java, Utils.get(R.string.CLICK_CAL_RES_PROBLEMAS))
        )

        routeMapEvalua7.apply {
            put(Utils.get(R.string.EVALUA_7_MODULO_1), subItems1)
            put(Utils.get(R.string.EVALUA_7_MODULO_2), subItems2)
            put(Utils.get(R.string.EVALUA_7_MODULO_4), subItems4)
            put(Utils.get(R.string.EVALUA_7_MODULO_5), subItems5)
            put(Utils.get(R.string.EVALUA_7_MODULO_6), subItems6)
        }
    }
}