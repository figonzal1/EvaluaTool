/*-----------------------------------------------------------------------------
                                                                              -
 This file is subject to the terms and conditions defined in                  -
 file 'LICENSE', which is part of this source code package                    -
                                                                              -
 Autor: Felipe González                                                       -
 Email: felipe.gonzalezalarcon94@gmail.com                                    -
                                                                              -
 Copyright (c) 2020                                                           -
                                                                              -
 Last modified 29-07-20 18:05                                                 -
 -----------------------------------------------------------------------------*/

package cl.figonzal.evaluatool;

import android.content.Context;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cl.figonzal.evaluatool.evalua0.modulo1.ClasificacionE0M1;
import cl.figonzal.evaluatool.evalua0.modulo1.IndiceGeneralCognitivoE0M1;
import cl.figonzal.evaluatool.evalua0.modulo1.LetrasYNumerosE0M1;
import cl.figonzal.evaluatool.evalua0.modulo1.MemoriaVerbalE0M1;
import cl.figonzal.evaluatool.evalua0.modulo1.OrganizacionPerceptivaE0M1;
import cl.figonzal.evaluatool.evalua0.modulo1.SeriesE0M1;
import cl.figonzal.evaluatool.evalua0.modulo2.CopiaDibujosE0M2;
import cl.figonzal.evaluatool.evalua0.modulo2.GrafoMotricidadE0M2;
import cl.figonzal.evaluatool.evalua0.modulo2.IndiceGeneralEspacialE0M2;
import cl.figonzal.evaluatool.evalua0.modulo3.HabilidadesFonologicasE0M3;
import cl.figonzal.evaluatool.evalua0.modulo3.IndiceGeneralLinguisticoE0M3;
import cl.figonzal.evaluatool.evalua0.modulo3.PalabrasYFrasesE0M3;
import cl.figonzal.evaluatool.evalua0.modulo3.RecepcionAuditivaArticulacionE0M3;
import cl.figonzal.evaluatool.evalua1.modulo1.MemoriaAtencionE1M1;
import cl.figonzal.evaluatool.evalua1.modulo2.ClasificacionesE1M2;
import cl.figonzal.evaluatool.evalua1.modulo2.OrganizacionPerceptivaE1M2;
import cl.figonzal.evaluatool.evalua1.modulo2.SeriesE1M2;
import cl.figonzal.evaluatool.evalua1.modulo2.ValoracionGlobalBasesE1M2;
import cl.figonzal.evaluatool.evalua1.modulo3.NivelesAdaptacionE1M3;
import cl.figonzal.evaluatool.evalua1.modulo4.ComprensionLectoraE1M4;
import cl.figonzal.evaluatool.evalua1.modulo4.ExactitudLectoraE1M4;
import cl.figonzal.evaluatool.evalua1.modulo4.ValoracionGlobalLecturaE1M4;
import cl.figonzal.evaluatool.evalua1.modulo5.OrtografiaFoneticaE1M5;
import cl.figonzal.evaluatool.evalua1.modulo5.OrtografiaVisualE1M5;
import cl.figonzal.evaluatool.evalua1.modulo6.CalculoNumeracionE1M6;
import cl.figonzal.evaluatool.evalua2.modulo1.ClasificacionesE2M1;
import cl.figonzal.evaluatool.evalua2.modulo1.IndiceGeneralCognitivoE2M1;
import cl.figonzal.evaluatool.evalua2.modulo1.OrganizacionPerceptivaE2M1;
import cl.figonzal.evaluatool.evalua2.modulo1.PensamientoAnalogicoE2M1;
import cl.figonzal.evaluatool.evalua2.modulo1.ValoracionGlobalRazonamientoE2M1;
import cl.figonzal.evaluatool.evalua2.modulo2.MemoriaAtencionE2M2;
import cl.figonzal.evaluatool.evalua2.modulo3.NivelesAdaptacionE2M3;
import cl.figonzal.evaluatool.evalua2.modulo4.ComprensionLectoraE2M4;
import cl.figonzal.evaluatool.evalua2.modulo5.OrtografiaE2M5;
import cl.figonzal.evaluatool.evalua2.modulo6.CalculoNumeracionE2M6;
import cl.figonzal.evaluatool.evalua2.modulo6.IndiceGeneralMatematicoE2M6;
import cl.figonzal.evaluatool.evalua2.modulo6.ResolucionProblemasE2M6;
import cl.figonzal.evaluatool.evalua2.modulo6.ValoracionGlobalMatematicasE2M6;
import cl.figonzal.evaluatool.evalua3.modulo2.OrganizacionPerceptivaE3M2;
import cl.figonzal.evaluatool.evalua3.modulo2.PensamientoAnalogicoE3M2;
import cl.figonzal.evaluatool.evalua3.modulo2.ReflexividadE3M2;
import cl.figonzal.evaluatool.evalua3.modulo2.ValoracionGlobalBasesE3M2;
import cl.figonzal.evaluatool.evalua3.modulo3.NivelesAdaptacionE3M3;
import cl.figonzal.evaluatool.evalua3.modulo4.ComprensionLectoraE3M4;
import cl.figonzal.evaluatool.evalua3.modulo4.ExactitudLectoraE3M4;
import cl.figonzal.evaluatool.evalua3.modulo4.ValoracionGlobalLecturaE3M4;
import cl.figonzal.evaluatool.evalua3.modulo5.OrtografiaFoneticaE3M5;
import cl.figonzal.evaluatool.evalua3.modulo5.OrtografiaVisualRegladaE3M5;
import cl.figonzal.evaluatool.evalua3.modulo6.CalculoNumeracionE3M6;
import cl.figonzal.evaluatool.evalua3.modulo6.ResolucionProblemasE3M6;
import cl.figonzal.evaluatool.evalua3.modulo6.ValoracionGlobalAprenMatematE3M6;
import cl.figonzal.evaluatool.evalua4.modulo1.MemoriaAtencionE4M1;
import cl.figonzal.evaluatool.evalua4.modulo2.IndiceGeneralCognitivoE4M2;
import cl.figonzal.evaluatool.evalua4.modulo2.OrganizacionPerceptivaE4M2;
import cl.figonzal.evaluatool.evalua4.modulo2.PensamientoAnalogicoE4M2;
import cl.figonzal.evaluatool.evalua4.modulo2.ReflexividadE4M2;
import cl.figonzal.evaluatool.evalua4.modulo2.ValoracionGlobalRazonamientoE4M2;
import cl.figonzal.evaluatool.evalua4.modulo3.NivelesAdaptacionE4M3;
import cl.figonzal.evaluatool.evalua4.modulo4.ComprensionLectoraE4M4;
import cl.figonzal.evaluatool.evalua4.modulo4.IndiceGeneralLecturaE4M4;
import cl.figonzal.evaluatool.evalua4.modulo4.ValoracionGlobalLectoraE4M4;
import cl.figonzal.evaluatool.evalua4.modulo4.VelocidadLectoraE4M4;
import cl.figonzal.evaluatool.evalua4.modulo5.OrtografiaVisualRegladaE4M5;
import cl.figonzal.evaluatool.evalua4.modulo6.CalculoNumeracionE4M6;
import cl.figonzal.evaluatool.evalua4.modulo6.IndiceGeneralMatematicoE4M6;
import cl.figonzal.evaluatool.evalua4.modulo6.ResolucionProblemasE4M6;
import cl.figonzal.evaluatool.evalua4.modulo6.ValoracionGlobalMatematicasE4M6;
import cl.figonzal.evaluatool.evalua5.modulo1.MemoriaAtencionE5M1;
import cl.figonzal.evaluatool.evalua5.modulo2.OrganizacionPerceptivaE5M2;
import cl.figonzal.evaluatool.evalua5.modulo2.PensamientoAnalogicoE5M2;
import cl.figonzal.evaluatool.evalua5.modulo2.ReflexividadE5M2;
import cl.figonzal.evaluatool.evalua5.modulo2.ValoracionGlobalRazonamientoE5M2;
import cl.figonzal.evaluatool.evalua5.modulo3.NivelesAdaptacionE5M3;
import cl.figonzal.evaluatool.evalua5.modulo4.ComprensionLectoraE5M4;
import cl.figonzal.evaluatool.evalua5.modulo4.ExactitudLectoraE5M4;
import cl.figonzal.evaluatool.evalua5.modulo4.VelocidadLectoraE5M4;
import cl.figonzal.evaluatool.evalua7.modulo1.AtencionConcentracionE7M1;
import cl.figonzal.evaluatool.evalua7.modulo2.RazonamientoDeductivoE7M2;
import cl.figonzal.evaluatool.evalua7.modulo2.RazonamientoEspacialE7M2;
import cl.figonzal.evaluatool.evalua7.modulo2.RazonamientoInductivoE7M2;
import cl.figonzal.evaluatool.evalua7.modulo4.ComprensionLectoraE7M4;
import cl.figonzal.evaluatool.evalua7.modulo4.EficaciaLectoraE7M4;
import cl.figonzal.evaluatool.evalua7.modulo4.VelocidadLectoraE7M4;
import cl.figonzal.evaluatool.evalua7.modulo5.ExpresionEscritaE7M5;
import cl.figonzal.evaluatool.evalua7.modulo5.OrtografiaFoneticaE7M5;
import cl.figonzal.evaluatool.evalua7.modulo5.OrtografiaVisualRegladaE7M5;
import cl.figonzal.evaluatool.evalua7.modulo6.CalculoNumeracionE7M6;
import cl.figonzal.evaluatool.evalua7.modulo6.ResolucionProblemasE7M6;

public class ConfigRoutes {

    private Context context;

    private Map<String, List<Object[]>> routeMapEvalua0;
    private Map<String, List<Object[]>> routeMapEvalua1;
    private Map<String, List<Object[]>> routeMapEvalua2;
    private Map<String, List<Object[]>> routeMapEvalua3;
    private Map<String, List<Object[]>> routeMapEvalua4;
    private Map<String, List<Object[]>> routeMapEvalua5;
    private Map<String, List<Object[]>> routeMapEvalua7;

    public ConfigRoutes(Context context) {
        this.context = context;

        setRouteMapEvalua0();
        setRouteMapEvalua1();
        setRouteMapEvalua2();
        setRouteMapEvalua3();
        setRouteMapEvalua4();
        setRouteMapEvalua5();
        setRouteMapEvalua7();
    }

    //SETTER
    private void setRouteMapEvalua0() {
        routeMapEvalua0 = new HashMap<>();

        List<Object[]> subItems1 = new ArrayList<>();
        subItems1.add(new Object[]{
                context.getString(R.string.EVALUA_0_M1_SI_1), ClasificacionE0M1.class, context.getString(R.string.CLICK_CLASIFICACION)
        });
        subItems1.add(new Object[]{
                context.getString(R.string.EVALUA_0_M1_SI_2), SeriesE0M1.class, context.getString(R.string.CLICK_SERIES)
        });
        subItems1.add(new Object[]{
                context.getString(R.string.EVALUA_0_M1_SI_3), OrganizacionPerceptivaE0M1.class, context.getString(R.string.CLICK_ORG_PERCEPTIVA)
        });
        subItems1.add(new Object[]{
                context.getString(R.string.EVALUA_0_M1_SI_4), LetrasYNumerosE0M1.class, context.getString(R.string.CLICK_LETRAS_NUMEROS)
        });
        subItems1.add(new Object[]{
                context.getString(R.string.EVALUA_0_M1_SI_5), MemoriaVerbalE0M1.class, context.getString(R.string.CLICK_MEMORIA_VERBAL)
        });
        subItems1.add(new Object[]{
                context.getString(R.string.EVALUA_0_M1_SI_6), IndiceGeneralCognitivoE0M1.class, context.getString(R.string.CLICK_INDICE_GENERAL_COGNITIVO)
        });

        List<Object[]> subItems2 = new ArrayList<>();
        subItems2.add(new Object[]{
                context.getString(R.string.EVALUA_0_M2_SI_1), CopiaDibujosE0M2.class, context.getString(R.string.CLICK_COPIA_DIBUJOS)
        });
        subItems2.add(new Object[]{
                context.getString(R.string.EVALUA_0_M2_SI_2), GrafoMotricidadE0M2.class, context.getString(R.string.CLICK_GRAFO_MOTRICIDAD)
        });
        subItems2.add(new Object[]{
                context.getString(R.string.EVALUA_0_M2_SI_3), IndiceGeneralEspacialE0M2.class, context.getString(R.string.CLICK_INDICE_GENERAL_ESPACIAL)
        });

        List<Object[]> subItems3 = new ArrayList<>();
        subItems3.add(new Object[]{
                context.getString(R.string.EVALUA_0_M3_SI_1), PalabrasYFrasesE0M3.class, context.getString(R.string.CLICK_PALABRAS_FRASES)
        });
        subItems3.add(new Object[]{
                context.getString(R.string.EVALUA_0_M3_SI_2), RecepcionAuditivaArticulacionE0M3.class, context.getString(R.string.CLICK_RECEPCION_AUDITIVA)
        });
        subItems3.add(new Object[]{
                context.getString(R.string.EVALUA_0_M3_SI_3), HabilidadesFonologicasE0M3.class, context.getString(R.string.CLICK_HABILIDADES_FONOLOGICAS)
        });
        subItems3.add(new Object[]{
                context.getString(R.string.EVALUA_0_M3_SI_4), IndiceGeneralLinguisticoE0M3.class, context.getString(R.string.CLICK_INDICE_GENERAL_LINGUISTICO)
        });

        routeMapEvalua0.put(context.getString(R.string.EVALUA_0_MODULO_1), subItems1);
        routeMapEvalua0.put(context.getString(R.string.EVALUA_0_MODULO_2), subItems2);
        routeMapEvalua0.put(context.getString(R.string.EVALUA_0_MODULO_3), subItems3);
    }

    private void setRouteMapEvalua1() {
        routeMapEvalua1 = new HashMap<>();

        List<Object[]> subItems1 = new ArrayList<>();
        subItems1.add(new Object[]{
                context.getString(R.string.EVALUA_1_M1_SI_1), MemoriaAtencionE1M1.class, context.getString(R.string.CLICK_MEMORIA_ATENCION)
        });

        List<Object[]> subItems2 = new ArrayList<>();
        subItems2.add(new Object[]{
                context.getString(R.string.EVALUA_1_M1_SI_1), SeriesE1M2.class, context.getString(R.string.CLICK_SERIES)
        });
        subItems2.add(new Object[]{
                context.getString(R.string.EVALUA_1_M2_SI_2), ClasificacionesE1M2.class, context.getString(R.string.CLICK_CLASIFICACION)
        });
        subItems2.add(new Object[]{
                context.getString(R.string.EVALUA_1_M2_SI_3), OrganizacionPerceptivaE1M2.class, context.getString(R.string.CLICK_ORG_PERCEPTIVA)
        });
        subItems2.add(new Object[]{
                context.getString(R.string.EVALUA_1_M2_SI_3), OrganizacionPerceptivaE1M2.class, context.getString(R.string.CLICK_ORG_PERCEPTIVA)
        });
        subItems2.add(new Object[]{
                context.getString(R.string.EVALUA_1_EVALUA_GLOBAL), ValoracionGlobalBasesE1M2.class, context.getString(R.string.CLICK_VALORACION_GLOBAL)
        });

        List<Object[]> subItems3 = new ArrayList<>();
        subItems3.add(new Object[]{
                context.getString(R.string.EVALUA_1_M3_SI_1), NivelesAdaptacionE1M3.class, context.getString(R.string.CLICK_NIVELES_ADAPTACION)
        });

        List<Object[]> subItems4 = new ArrayList<>();
        subItems4.add(new Object[]{
                context.getString(R.string.EVALUA_1_M4_SI_1), ComprensionLectoraE1M4.class, context.getString(R.string.CLICK_COMPRENSION_LECTORA)
        });
        subItems4.add(new Object[]{
                context.getString(R.string.EVALUA_1_M4_SI_2), ExactitudLectoraE1M4.class, context.getString(R.string.CLICK_EXACTITUD_LECTORA)
        });
        subItems4.add(new Object[]{
                context.getString(R.string.EVALUA_1_EVALUA_GLOBAL), ValoracionGlobalLecturaE1M4.class, context.getString(R.string.CLICK_VALORACION_GLOBAL)
        });

        List<Object[]> subItems5 = new ArrayList<>();
        subItems5.add(new Object[]{
                context.getString(R.string.EVALUA_1_M5_SI_1), OrtografiaFoneticaE1M5.class, context.getString(R.string.CLICK_ORTOGRAFIA_FONETICA)
        });
        subItems5.add(new Object[]{
                context.getString(R.string.EVALUA_1_M5_SI_2), OrtografiaVisualE1M5.class, context.getString(R.string.CLICK_ORTOGRAFIA_VISUAL)
        });

        List<Object[]> subItems6 = new ArrayList<>();
        subItems6.add(new Object[]{
                context.getString(R.string.EVALUA_1_M6_SI_1), CalculoNumeracionE1M6.class, context.getString(R.string.CLICK_CAL_NUMERACION)
        });

        routeMapEvalua1.put(context.getString(R.string.EVALUA_1_MODULO_1), subItems1);
        routeMapEvalua1.put(context.getString(R.string.EVALUA_1_MODULO_2), subItems2);
        routeMapEvalua1.put(context.getString(R.string.EVALUA_1_MODULO_3), subItems3);
        routeMapEvalua1.put(context.getString(R.string.EVALUA_1_MODULO_4), subItems4);
        routeMapEvalua1.put(context.getString(R.string.EVALUA_1_MODULO_5), subItems5);
        routeMapEvalua1.put(context.getString(R.string.EVALUA_1_MODULO_6), subItems6);
    }

    private void setRouteMapEvalua2() {
        routeMapEvalua2 = new HashMap<>();

        List<Object[]> subItems1 = new ArrayList<>();
        subItems1.add(new Object[]{
                context.getString(R.string.EVALUA_2_M1_SI_1), PensamientoAnalogicoE2M1.class, context.getString(R.string.CLICK_PENSAMIENTO_ANALOGICO)
        });
        subItems1.add(new Object[]{
                context.getString(R.string.EVALUA_2_M1_SI_2), OrganizacionPerceptivaE2M1.class, context.getString(R.string.CLICK_ORG_PERCEPTIVA)
        });
        subItems1.add(new Object[]{
                context.getString(R.string.EVALUA_2_M1_SI_3), ClasificacionesE2M1.class, context.getString(R.string.CLICK_CLASIFICACION)
        });
        subItems1.add(new Object[]{
                context.getString(R.string.EVALUA_2_EVALUA_GLOBAL), ValoracionGlobalRazonamientoE2M1.class, context.getString(R.string.CLICK_VALORACION_GLOBAL)
        });
        subItems1.add(new Object[]{
                context.getString(R.string.EVALUA_2_INDICE_GENERAL_COGNITIVO), IndiceGeneralCognitivoE2M1.class, context.getString(R.string.CLICK_INDICE_GENERAL_COGNITIVO)
        });

        List<Object[]> subItems2 = new ArrayList<>();
        subItems2.add(new Object[]{
                context.getString(R.string.EVALUA_2_M2_SI_1), MemoriaAtencionE2M2.class, context.getString(R.string.CLICK_MEMORIA_ATENCION)
        });

        List<Object[]> subItems3 = new ArrayList<>();
        subItems3.add(new Object[]{
                context.getString(R.string.EVALUA_2_M3_SI_1), NivelesAdaptacionE2M3.class, context.getString(R.string.CLICK_NIVELES_ADAPTACION)
        });

        List<Object[]> subItems4 = new ArrayList<>();
        subItems4.add(new Object[]{
                context.getString(R.string.EVALUA_2_M4_SI_1), ComprensionLectoraE2M4.class, context.getString(R.string.CLICK_COMPRENSION_LECTORA)
        });

        List<Object[]> subItems5 = new ArrayList<>();
        subItems5.add(new Object[]{
                context.getString(R.string.EVALUA_2_M5_SI_1), OrtografiaE2M5.class, context.getString(R.string.CLICK_ORTOGRAFIA)
        });

        List<Object[]> subItems6 = new ArrayList<>();
        subItems6.add(new Object[]{
                context.getString(R.string.EVALUA_2_M6_SI_1), CalculoNumeracionE2M6.class, context.getString(R.string.CLICK_CAL_NUMERACION)
        });
        subItems6.add(new Object[]{
                context.getString(R.string.EVALUA_2_M6_SI_2), ResolucionProblemasE2M6.class, context.getString(R.string.CLICK_CAL_RES_PROBLEMAS)
        });
        subItems6.add(new Object[]{
                context.getString(R.string.EVALUA_2_EVALUA_GLOBAL), ValoracionGlobalMatematicasE2M6.class, context.getString(R.string.CLICK_VALORACION_GLOBAL)
        });
        subItems6.add(new Object[]{
                context.getString(R.string.EVALUA_2_INDICE_GENERAL_MATEMATICO), IndiceGeneralMatematicoE2M6.class, context.getString(R.string.CLICK_INDICE_GENERAL_MATEMATICO)
        });


        routeMapEvalua2.put(context.getString(R.string.EVALUA_2_MODULO_1), subItems1);
        routeMapEvalua2.put(context.getString(R.string.EVALUA_2_MODULO_2), subItems2);
        routeMapEvalua2.put(context.getString(R.string.EVALUA_2_MODULO_3), subItems3);
        routeMapEvalua2.put(context.getString(R.string.EVALUA_2_MODULO_4), subItems4);
        routeMapEvalua2.put(context.getString(R.string.EVALUA_2_MODULO_5), subItems5);
        routeMapEvalua2.put(context.getString(R.string.EVALUA_2_MODULO_6), subItems6);
    }

    private void setRouteMapEvalua3() {
        routeMapEvalua3 = new HashMap<>();

        List<Object[]> subItems1 = new ArrayList<>();
        subItems1.add(new Object[]{
                context.getString(R.string.EVALUA_3_M1_SI_1), MemoriaAtencionE4M1.class, context.getString(R.string.CLICK_MEMORIA_ATENCION)
        });

        List<Object[]> subItems2 = new ArrayList<>();
        subItems2.add(new Object[]{
                context.getString(R.string.EVALUA_3_M2_SI_1), ReflexividadE3M2.class, context.getString(R.string.CLICK_REFLEXIVIDAD)
        });
        subItems2.add(new Object[]{
                context.getString(R.string.EVALUA_3_M2_SI_2), PensamientoAnalogicoE3M2.class, context.getString(R.string.CLICK_PENSAMIENTO_ANALOGICO)
        });
        subItems2.add(new Object[]{
                context.getString(R.string.EVALUA_3_M2_SI_3), OrganizacionPerceptivaE3M2.class, context.getString(R.string.CLICK_ORG_PERCEPTIVA)
        });
        subItems2.add(new Object[]{
                context.getString(R.string.EVALUA_3_EVALUA_GLOBAL), ValoracionGlobalBasesE3M2.class, context.getString(R.string.CLICK_NIVELES_ADAPTACION)
        });


        List<Object[]> subItems3 = new ArrayList<>();
        subItems3.add(new Object[]{
                context.getString(R.string.EVALUA_3_M3_SI_1), NivelesAdaptacionE3M3.class, context.getString(R.string.CLICK_MEMORIA_ATENCION)
        });

        List<Object[]> subItems4 = new ArrayList<>();
        subItems4.add(new Object[]{
                context.getString(R.string.EVALUA_3_M4_SI_1), ComprensionLectoraE3M4.class, context.getString(R.string.CLICK_COMPR_LECTORA)
        });
        subItems4.add(new Object[]{
                context.getString(R.string.EVALUA_3_M4_SI_2), ExactitudLectoraE3M4.class, context.getString(R.string.CLICK_EXACTITUD_LECTORA)
        });
        subItems4.add(new Object[]{
                context.getString(R.string.EVALUA_3_EVALUA_GLOBAL), ValoracionGlobalLecturaE3M4.class, context.getString(R.string.CLICK_VALORACION_GLOBAL)
        });


        List<Object[]> subItems5 = new ArrayList<>();
        subItems5.add(new Object[]{
                context.getString(R.string.EVALUA_3_M5_SI_1), OrtografiaFoneticaE3M5.class, context.getString(R.string.CLICK_ORTOGRAFIA_FONETICA)
        });
        subItems5.add(new Object[]{
                context.getString(R.string.EVALUA_3_M5_SI_2), OrtografiaVisualRegladaE3M5.class, context.getString(R.string.CLICK_ORT_VIS_REGLADA)
        });


        List<Object[]> subItems6 = new ArrayList<>();
        subItems6.add(new Object[]{
                context.getString(R.string.EVALUA_3_M6_SI_1), CalculoNumeracionE3M6.class, context.getString(R.string.CLICK_CAL_NUMERACION)
        });
        subItems6.add(new Object[]{
                context.getString(R.string.EVALUA_3_M6_SI_2), ResolucionProblemasE3M6.class, context.getString(R.string.CLICK_CAL_RES_PROBLEMAS)
        });
        subItems6.add(new Object[]{
                context.getString(R.string.EVALUA_3_EVALUA_GLOBAL), ValoracionGlobalAprenMatematE3M6.class, context.getString(R.string.CLICK_VALORACION_GLOBAL)
        });

        routeMapEvalua3.put(context.getString(R.string.EVALUA_3_MODULO_1), subItems1);
        routeMapEvalua3.put(context.getString(R.string.EVALUA_3_MODULO_2), subItems2);
        routeMapEvalua3.put(context.getString(R.string.EVALUA_3_MODULO_3), subItems3);
        routeMapEvalua3.put(context.getString(R.string.EVALUA_3_MODULO_4), subItems4);
        routeMapEvalua3.put(context.getString(R.string.EVALUA_3_MODULO_5), subItems5);
        routeMapEvalua3.put(context.getString(R.string.EVALUA_3_MODULO_6), subItems6);
    }

    private void setRouteMapEvalua4() {
        routeMapEvalua4 = new HashMap<>();

        List<Object[]> subItems1 = new ArrayList<>();
        subItems1.add(new Object[]{
                context.getString(R.string.EVALUA_4_M1_SI_1), MemoriaAtencionE4M1.class, context.getString(R.string.CLICK_MEMORIA_ATENCION)
        });


        List<Object[]> subItems2 = new ArrayList<>();
        subItems2.add(new Object[]{
                context.getString(R.string.EVALUA_4_M2_SI_1), ReflexividadE4M2.class, context.getString(R.string.CLICK_REFLEXIVIDAD)
        });
        subItems2.add(new Object[]{
                context.getString(R.string.EVALUA_4_M2_SI_2), PensamientoAnalogicoE4M2.class, context.getString(R.string.CLICK_PENSAMIENTO_ANALOGICO)
        });
        subItems2.add(new Object[]{
                context.getString(R.string.EVALUA_4_M2_SI_3), OrganizacionPerceptivaE4M2.class, context.getString(R.string.CLICK_ORG_PERCEPTIVA)
        });
        subItems2.add(new Object[]{
                context.getString(R.string.EVALUA_4_EVALUA_GLOBAL), ValoracionGlobalRazonamientoE4M2.class, context.getString(R.string.CLICK_VALORACION_GLOBAL)
        });
        subItems2.add(new Object[]{
                context.getString(R.string.EVALUA_4_M2_SI_4), IndiceGeneralCognitivoE4M2.class, context.getString(R.string.CLICK_INDICE_GENERAL_COGNITIVO)
        });

        List<Object[]> subItems3 = new ArrayList<>();
        subItems3.add(new Object[]{
                context.getString(R.string.EVALUA_4_M3_SI_1), NivelesAdaptacionE4M3.class, context.getString(R.string.CLICK_NIVELES_ADAPTACION)
        });

        List<Object[]> subItems4 = new ArrayList<>();
        subItems4.add(new Object[]{
                context.getString(R.string.EVALUA_4_M4_SI_1), ComprensionLectoraE4M4.class, context.getString(R.string.CLICK_COMPRENSION_LECTORA)
        });
        subItems4.add(new Object[]{
                context.getString(R.string.EVALUA_4_M4_SI_2), VelocidadLectoraE4M4.class, context.getString(R.string.CLICK_VELOCIDAD_LECTORA)
        });
        subItems4.add(new Object[]{
                context.getString(R.string.EVALUA_4_EVALUA_GLOBAL), ValoracionGlobalLectoraE4M4.class, context.getString(R.string.CLICK_VALORACION_GLOBAL)
        });
        subItems4.add(new Object[]{
                context.getString(R.string.EVALUA_4_M4_SI_3), IndiceGeneralLecturaE4M4.class, context.getString(R.string.CLICK_INDICE_GENERAL_LECTURA)
        });


        List<Object[]> subItems5 = new ArrayList<>();
        subItems5.add(new Object[]{
                context.getString(R.string.EVALUA_4_M5_SI_1), OrtografiaVisualRegladaE4M5.class, context.getString(R.string.CLICK_ORT_VIS_REGLADA)
        });

        List<Object[]> subItems6 = new ArrayList<>();
        subItems6.add(new Object[]{
                context.getString(R.string.EVALUA_4_M6_SI_1), CalculoNumeracionE4M6.class, context.getString(R.string.CLICK_CAL_NUMERACION)
        });
        subItems6.add(new Object[]{
                context.getString(R.string.EVALUA_4_M6_SI_2), ResolucionProblemasE4M6.class, context.getString(R.string.CLICK_CAL_RES_PROBLEMAS)
        });
        subItems6.add(new Object[]{
                context.getString(R.string.EVALUA_4_EVALUA_GLOBAL), ValoracionGlobalMatematicasE4M6.class, context.getString(R.string.CLICK_VALORACION_GLOBAL)
        });
        subItems6.add(new Object[]{
                context.getString(R.string.EVALUA_4_M6_SI_4), IndiceGeneralMatematicoE4M6.class, context.getString(R.string.CLICK_INDICE_GENERAL_MATEMATICO)
        });

        routeMapEvalua4.put(context.getString(R.string.EVALUA_4_MODULO_1), subItems1);
        routeMapEvalua4.put(context.getString(R.string.EVALUA_4_MODULO_2), subItems2);
        routeMapEvalua4.put(context.getString(R.string.EVALUA_4_MODULO_3), subItems3);
        routeMapEvalua4.put(context.getString(R.string.EVALUA_4_MODULO_4), subItems4);
        routeMapEvalua4.put(context.getString(R.string.EVALUA_4_MODULO_5), subItems5);
        routeMapEvalua4.put(context.getString(R.string.EVALUA_4_MODULO_6), subItems6);
    }

    private void setRouteMapEvalua5() {

        routeMapEvalua5 = new HashMap<>();

        List<Object[]> subItems1 = new ArrayList<>();
        subItems1.add(new Object[]{
                context.getString(R.string.EVALUA_5_M1_SI_1), MemoriaAtencionE5M1.class, context.getString(R.string.CLICK_MEMORIA_ATENCION)
        });

        List<Object[]> subItems2 = new ArrayList<>();
        subItems2.add(new Object[]{
                context.getString(R.string.EVALUA_5_M2_SI_1), ReflexividadE5M2.class, context.getString(R.string.CLICK_REFLEXIVIDAD)
        });
        subItems2.add(new Object[]{
                context.getString(R.string.EVALUA_5_M2_SI_2), PensamientoAnalogicoE5M2.class, context.getString(R.string.CLICK_PENSAMIENTO_ANALOGICO)
        });
        subItems2.add(new Object[]{
                context.getString(R.string.EVALUA_5_M2_SI_3), OrganizacionPerceptivaE5M2.class, context.getString(R.string.CLICK_ORG_PERCEPTIVA)
        });

        subItems2.add(new Object[]{
                context.getString(R.string.EVALUA_5_EVALUA_GLOBAL), ValoracionGlobalRazonamientoE5M2.class, context.getString(R.string.CLICK_VALORACION_GLOBAL)
        });

        List<Object[]> subItems3 = new ArrayList<>();
        subItems3.add(new Object[]{
                context.getString(R.string.EVALUA_5_M3_SI_1), NivelesAdaptacionE5M3.class, context.getString(R.string.CLICK_NIVELES_ADAPTACION)
        });

        List<Object[]> subItems4 = new ArrayList<>();
        subItems4.add(new Object[]{
                context.getString(R.string.EVALUA_5_M4_SI_1), ComprensionLectoraE5M4.class, context.getString(R.string.CLICK_COMPRENSION_LECTORA)
        });
        subItems4.add(new Object[]{
                context.getString(R.string.EVALUA_5_M4_SI_2), VelocidadLectoraE5M4.class, context.getString(R.string.CLICK_VELOCIDAD_LECTORA)
        });
        subItems4.add(new Object[]{
                context.getString(R.string.EVALUA_5_M4_SI_3), ExactitudLectoraE5M4.class, context.getString(R.string.CLICK_EXACTITUD_LECTORA)
        });

        routeMapEvalua5.put(context.getString(R.string.EVALUA_5_MODULO_1), subItems1);
        routeMapEvalua5.put(context.getString(R.string.EVALUA_5_MODULO_2), subItems2);
        routeMapEvalua5.put(context.getString(R.string.EVALUA_5_MODULO_3), subItems3);
        routeMapEvalua5.put(context.getString(R.string.EVALUA_5_MODULO_4), subItems4);
    }

    private void setRouteMapEvalua7() {
        routeMapEvalua7 = new HashMap<>();

        List<Object[]> subItems1 = new ArrayList<>();
        subItems1.add(new Object[]{
                context.getString(R.string.EVALUA_7_M1_SI_1), AtencionConcentracionE7M1.class, context.getString(R.string.CLICK_ATEN_CONCENTRACION)
        });

        List<Object[]> subItems2 = new ArrayList<>();
        subItems2.add(new Object[]{
                context.getString(R.string.EVALUA_7_M2_SI_1), RazonamientoDeductivoE7M2.class, context.getString(R.string.CLICK_RAZON_DEDUCTIVO)
        });
        subItems2.add(new Object[]{
                context.getString(R.string.EVALUA_7_M2_SI_2), RazonamientoInductivoE7M2.class, context.getString(R.string.CLICK_RAZON_INDUCTIVO)
        });
        subItems2.add(new Object[]{
                context.getString(R.string.EVALUA_7_M2_SI_3), RazonamientoEspacialE7M2.class, context.getString(R.string.CLICK_RAZON_ESPACIAL)
        });

        List<Object[]> subItems4 = new ArrayList<>();
        subItems4.add(new Object[]{
                context.getString(R.string.EVALUA_7_M4_SI_1), EficaciaLectoraE7M4.class, context.getString(R.string.CLICK_EFICACIA_LECTORA)
        });
        subItems4.add(new Object[]{
                context.getString(R.string.EVALUA_7_M4_SI_2), ComprensionLectoraE7M4.class, context.getString(R.string.CLICK_COMPRENSION_LECTORA)
        });
        subItems4.add(new Object[]{
                context.getString(R.string.EVALUA_7_M4_SI_3), VelocidadLectoraE7M4.class, context.getString(R.string.CLICK_VELOCIDAD_LECTORA)
        });

        List<Object[]> subItems5 = new ArrayList<>();
        subItems5.add(new Object[]{
                context.getString(R.string.EVALUA_7_M5_SI_1), OrtografiaFoneticaE7M5.class, context.getString(R.string.CLICK_ORTOGRAFIA_FONETICA)
        });
        subItems5.add(new Object[]{
                context.getString(R.string.EVALUA_7_M5_SI_2), ExpresionEscritaE7M5.class, context.getString(R.string.CLICK_EXP_ESCRITA)
        });
        subItems5.add(new Object[]{
                context.getString(R.string.EVALUA_7_M5_SI_3), OrtografiaVisualRegladaE7M5.class, context.getString(R.string.CLICK_ORT_VIS_REGLADA)
        });

        List<Object[]> subItems6 = new ArrayList<>();
        subItems6.add(new Object[]{
                context.getString(R.string.EVALUA_7_M6_SI_1), CalculoNumeracionE7M6.class, context.getString(R.string.CLICK_CAL_NUMERACION)
        });
        subItems6.add(new Object[]{
                context.getString(R.string.EVALUA_7_M6_SI_2), ResolucionProblemasE7M6.class, context.getString(R.string.CLICK_CAL_RES_PROBLEMAS)
        });

        routeMapEvalua7.put(context.getString(R.string.EVALUA_7_MODULO_1), subItems1);
        routeMapEvalua7.put(context.getString(R.string.EVALUA_7_MODULO_2), subItems2);
        routeMapEvalua7.put(context.getString(R.string.EVALUA_7_MODULO_4), subItems4);
        routeMapEvalua7.put(context.getString(R.string.EVALUA_7_MODULO_5), subItems5);
        routeMapEvalua7.put(context.getString(R.string.EVALUA_7_MODULO_6), subItems6);
    }

    //GETTERS
    public Map<String, List<Object[]>> getRouteMapEvalua0() {
        return routeMapEvalua0;
    }

    public Map<String, List<Object[]>> getRouteMapEvalua1() {
        return routeMapEvalua1;
    }

    public Map<String, List<Object[]>> getRouteMapEvalua2() {
        return routeMapEvalua2;
    }

    public Map<String, List<Object[]>> getRouteMapEvalua3() {
        return routeMapEvalua3;
    }

    public Map<String, List<Object[]>> getRouteMapEvalua4() {
        return routeMapEvalua4;
    }

    public Map<String, List<Object[]>> getRouteMapEvalua5() {
        return routeMapEvalua5;
    }

    public Map<String, List<Object[]>> getRouteMapEvalua7() {
        return routeMapEvalua7;
    }
}
