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
 Last modified 27-07-20 22:25                                                 -
 -----------------------------------------------------------------------------*/

package cl.figonzal.evaluatool;

import android.content.Context;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cl.figonzal.evaluatool.evalua5.modulo1.MemoriaAtencionE5M1;
import cl.figonzal.evaluatool.evalua5.modulo2.OrganizacionPerceptivaE5M2;
import cl.figonzal.evaluatool.evalua5.modulo2.PensamientoAnalogicoE5M2;
import cl.figonzal.evaluatool.evalua5.modulo2.ReflexividadE5M2;
import cl.figonzal.evaluatool.evalua5.modulo2.ValoracionGlobalRazonamientoE5M2;
import cl.figonzal.evaluatool.evalua5.modulo3.NivelesAdaptacionE5M3;

public class ConfigRoutes {

    private Context context;

    private Map<String, List<Object[]>> routeMapEvalua5;

    public ConfigRoutes(Context context) {
        this.context = context;

        setRouteMapEvalua5();
    }

    //SETTER
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
}
