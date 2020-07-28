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
 Last modified 27-07-20 23:09                                                 -
 -----------------------------------------------------------------------------*/

package cl.figonzal.evaluatool;

import android.content.Context;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

public class ConfigRoutes {

    private Context context;

    private Map<String, List<Object[]>> routeMapEvalua4;
    private Map<String, List<Object[]>> routeMapEvalua5;

    public ConfigRoutes(Context context) {
        this.context = context;

        setRouteMapEvalua4();
        setRouteMapEvalua5();
    }

    //SETTER
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

        routeMapEvalua5.put(context.getString(R.string.EVALUA_5_MODULO_1), subItems1);
        routeMapEvalua5.put(context.getString(R.string.EVALUA_5_MODULO_2), subItems2);
        routeMapEvalua5.put(context.getString(R.string.EVALUA_5_MODULO_3), subItems3);
    }

    //GETTERS
    public Map<String, List<Object[]>> getRouteMapEvalua5() {
        return routeMapEvalua5;
    }

    public Map<String, List<Object[]>> getRouteMapEvalua4() {
        return routeMapEvalua4;
    }
}
