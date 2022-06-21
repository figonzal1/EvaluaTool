/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2022

 Last modified 21-06-22 18:14
 */

package cl.figonzal.evaluatool.di

import cl.figonzal.evaluatool.domain.baremo_tables.*
import cl.figonzal.evaluatool.domain.resolvers.BaremoTable
import cl.figonzal.evaluatool.domain.resolvers.evalua0.modulo1.*
import cl.figonzal.evaluatool.domain.resolvers.evalua0.modulo2.CopiaDibujosE0M2Resolver
import cl.figonzal.evaluatool.domain.resolvers.evalua0.modulo2.GrafoMotricidadE0M2Resolver
import cl.figonzal.evaluatool.domain.resolvers.evalua0.modulo3.HabilidadesFonologicasE0M3Resolver
import cl.figonzal.evaluatool.domain.resolvers.evalua0.modulo3.PalabrasYFrasesE0M3Resolver
import cl.figonzal.evaluatool.domain.resolvers.evalua0.modulo3.RecepcionAuditivaArticulacionE0M3Resolver
import cl.figonzal.evaluatool.domain.resolvers.evalua1.modulo1.MemoriaAtencionE1M1Resolver
import cl.figonzal.evaluatool.domain.resolvers.evalua1.modulo2.ClasificacionesE1M2Resolver
import cl.figonzal.evaluatool.domain.resolvers.evalua1.modulo2.OrganizacionPerceptivaE1M2Resolver
import cl.figonzal.evaluatool.domain.resolvers.evalua1.modulo2.SeriesE1M2Resolver
import cl.figonzal.evaluatool.domain.resolvers.evalua1.modulo3.AutoControlFragmentE1M3Resolver
import cl.figonzal.evaluatool.domain.resolvers.evalua1.modulo3.AutoEstimaFragmentE1M3Resolver
import cl.figonzal.evaluatool.domain.resolvers.evalua1.modulo3.ConductaProSocialFragmentE1M3Resolver
import cl.figonzal.evaluatool.domain.resolvers.evalua1.modulo3.MotivacionFragmentE1M3Resolver
import cl.figonzal.evaluatool.domain.resolvers.evalua1.modulo4.ComprensionLectoraE1M4Resolver
import cl.figonzal.evaluatool.domain.resolvers.evalua1.modulo4.ExactitudLectoraE1M4Resolver
import cl.figonzal.evaluatool.domain.resolvers.evalua1.modulo5.OrtografiaFoneticaE1M5Resolver
import cl.figonzal.evaluatool.domain.resolvers.evalua1.modulo5.OrtografiaVisualE1M5Resolver
import cl.figonzal.evaluatool.domain.resolvers.evalua1.modulo6.CalculoNumeracionE1M6Resolver
import cl.figonzal.evaluatool.domain.resolvers.evalua2.modulo1.ClasificacionesE2M1Resolver
import cl.figonzal.evaluatool.domain.resolvers.evalua2.modulo1.OrganizacionPerceptivaE2M1Resolver
import cl.figonzal.evaluatool.domain.resolvers.evalua2.modulo1.PensamientoAnalogicoE2M1Resolver
import cl.figonzal.evaluatool.domain.resolvers.evalua2.modulo2.MemoriaAtencionE2M2Resolver
import cl.figonzal.evaluatool.domain.resolvers.evalua2.modulo3.AutoControlFragmentE2M3Resolver
import cl.figonzal.evaluatool.domain.resolvers.evalua2.modulo3.AutoEstimaFragmentE2M3Resolver
import cl.figonzal.evaluatool.domain.resolvers.evalua2.modulo3.ConductaProSocialFragmentE2M3Resolver
import cl.figonzal.evaluatool.domain.resolvers.evalua2.modulo3.MotivacionFragmentE2M3Resolver
import cl.figonzal.evaluatool.domain.resolvers.evalua2.modulo4.ComprensionLectoraE2M4Resolver
import cl.figonzal.evaluatool.domain.resolvers.evalua2.modulo5.OrtografiaE2M5Resolver
import cl.figonzal.evaluatool.domain.resolvers.evalua2.modulo6.CalculoNumeracionE2M6Resolver
import cl.figonzal.evaluatool.domain.resolvers.evalua2.modulo6.ResolucionProblemasE2M6Resolver
import cl.figonzal.evaluatool.domain.resolvers.evalua3.modulo1.MemoriaAtencionE3M1Resolver
import cl.figonzal.evaluatool.domain.resolvers.evalua3.modulo2.OrganizacionPerceptivaE3M2Resolver
import cl.figonzal.evaluatool.domain.resolvers.evalua3.modulo2.PensamientoAnalogicoE3M2Resolver
import cl.figonzal.evaluatool.domain.resolvers.evalua3.modulo2.ReflexividadE3M2Resolver
import cl.figonzal.evaluatool.domain.resolvers.evalua3.modulo3.AutoControlFragmentE3M3Resolver
import cl.figonzal.evaluatool.domain.resolvers.evalua3.modulo3.AutoEstimaFragmentE3M3Resolver
import cl.figonzal.evaluatool.domain.resolvers.evalua3.modulo3.ConductaProSocialFragmentE3M3Resolver
import cl.figonzal.evaluatool.domain.resolvers.evalua3.modulo3.MotivacionFragmentE3M3Resolver
import cl.figonzal.evaluatool.domain.resolvers.evalua3.modulo4.ComprensionLectoraE3M4Resolver
import cl.figonzal.evaluatool.domain.resolvers.evalua3.modulo4.ExactitudLectoraE3M4Resolver
import cl.figonzal.evaluatool.domain.resolvers.evalua3.modulo5.OrtografiaFoneticaE3M5Resolver
import cl.figonzal.evaluatool.domain.resolvers.evalua3.modulo5.OrtografiaVisualRegladaE3M5Resolver
import cl.figonzal.evaluatool.domain.resolvers.evalua3.modulo6.CalculoNumeracionE3M6Resolver
import cl.figonzal.evaluatool.domain.resolvers.evalua3.modulo6.ResolucionProblemasE3M6Resolver
import cl.figonzal.evaluatool.domain.resolvers.evalua4.modulo1.MemoriaAtencionE4M1Resolver
import cl.figonzal.evaluatool.domain.resolvers.evalua4.modulo2.OrganizacionPerceptivaE4M2Resolver
import cl.figonzal.evaluatool.domain.resolvers.evalua4.modulo2.PensamientoAnalogicoE4M2Resolver
import cl.figonzal.evaluatool.domain.resolvers.evalua4.modulo2.ReflexividadE4M2Resolver
import cl.figonzal.evaluatool.domain.resolvers.evalua4.modulo3.AutoControlFragmentE4M3Resolver
import cl.figonzal.evaluatool.domain.resolvers.evalua4.modulo3.AutoEstimaFragmentE4M3Resolver
import cl.figonzal.evaluatool.domain.resolvers.evalua4.modulo3.ConductaProSocialFragmentE4M3Resolver
import cl.figonzal.evaluatool.domain.resolvers.evalua4.modulo3.MotivacionFragmentE4M3Resolver
import cl.figonzal.evaluatool.domain.resolvers.evalua4.modulo4.ComprensionFragmentE4M4Resolver
import cl.figonzal.evaluatool.domain.resolvers.evalua4.modulo4.ComprensionLectoraE4M4Resolver
import cl.figonzal.evaluatool.domain.resolvers.evalua4.modulo4.VelocidadFragmentE4M4Resolver
import cl.figonzal.evaluatool.domain.resolvers.evalua4.modulo5.OrtografiaVisualRegladaE4M5Resolver
import cl.figonzal.evaluatool.domain.resolvers.evalua4.modulo6.CalculoNumeracionE4M6Resolver
import cl.figonzal.evaluatool.domain.resolvers.evalua4.modulo6.ResolucionProblemasE4M6Resolver
import cl.figonzal.evaluatool.domain.resolvers.evalua5.modulo1.MemoriaAtencionE5M1Resolver
import cl.figonzal.evaluatool.domain.resolvers.evalua5.modulo2.OrganizacionPerceptivaE5M2Resolver
import cl.figonzal.evaluatool.domain.resolvers.evalua5.modulo2.PensamientoAnalogicoE5M2Resolver
import cl.figonzal.evaluatool.domain.resolvers.evalua5.modulo2.ReflexividadE5M2Resolver
import cl.figonzal.evaluatool.domain.resolvers.evalua5.modulo3.AutoControlFragmentE5M3Resolver
import cl.figonzal.evaluatool.domain.resolvers.evalua5.modulo3.AutoEstimaFragmentE5M3Resolver
import cl.figonzal.evaluatool.domain.resolvers.evalua5.modulo3.ConductaProSocialFragmentE5M3Resolver
import cl.figonzal.evaluatool.domain.resolvers.evalua5.modulo3.MotivacionFragmentE5M3Resolver
import cl.figonzal.evaluatool.domain.resolvers.evalua5.modulo4.ComprensionFragmentE5M4Resolver
import cl.figonzal.evaluatool.domain.resolvers.evalua5.modulo4.ComprensionLectoraE5M4Resolver
import cl.figonzal.evaluatool.domain.resolvers.evalua5.modulo4.ExactitudLectoraE5M4Resolver
import cl.figonzal.evaluatool.domain.resolvers.evalua5.modulo4.VelocidadFragmentE5M4Resolver
import cl.figonzal.evaluatool.domain.resolvers.evalua5.modulo5.OrtografiaFoneticaE5M5Resolver
import cl.figonzal.evaluatool.domain.resolvers.evalua5.modulo6.CalculoNumeracionE5M6Resolver
import cl.figonzal.evaluatool.domain.resolvers.evalua5.modulo6.ResolucionProblemasE5M6Resolver
import org.koin.core.qualifier.named
import org.koin.dsl.module


val evalua0Module = module {

    val e0 = "e0"

    //Evalua 0 Baremo Table
    single<BaremoTable>(named(e0)) { Evalua0Baremo() }

    //RESOLVERS

    //MODULO 1
    factory { ClasificacionE0M1Resolver(get(named(e0))) }
    factory { SeriesE0M1Resolver(get(named(e0))) }
    factory { OrganizacionPerceptivaE0M1Resolver(get(named(e0))) }
    factory { LetrasYNumerosE0M1Resolver(get(named(e0))) }
    factory { MemoriaVerbalE0M1Resolver(get(named(e0))) }

    //MODULO 2
    factory { CopiaDibujosE0M2Resolver(get(named(e0))) }
    factory { GrafoMotricidadE0M2Resolver(get(named(e0))) }

    //MODULO 3
    factory { PalabrasYFrasesE0M3Resolver(get(named(e0))) }
    factory { RecepcionAuditivaArticulacionE0M3Resolver(get(named(e0))) }
    factory { HabilidadesFonologicasE0M3Resolver(get(named(e0))) }
}


val evalua1Module = module {

    val e1 = "e1"

    //Evalua 1 Baremo Table
    single<BaremoTable>(named(e1)) { Evalua1Baremo() }

    //RESOLVERS

    //MODULO 1
    factory { MemoriaAtencionE1M1Resolver(get(named(e1))) }

    //MODULO 2
    factory { SeriesE1M2Resolver(get(named(e1))) }
    factory { ClasificacionesE1M2Resolver(get(named(e1))) }
    factory { OrganizacionPerceptivaE1M2Resolver(get(named(e1))) }

    //MODULO 3
    factory { MotivacionFragmentE1M3Resolver(get(named(e1))) }
    factory { AutoControlFragmentE1M3Resolver(get(named(e1))) }
    factory { ConductaProSocialFragmentE1M3Resolver(get(named(e1))) }
    factory { AutoEstimaFragmentE1M3Resolver(get(named(e1))) }

    //MODULO 4
    factory { ComprensionLectoraE1M4Resolver(get(named(e1))) }
    factory { ExactitudLectoraE1M4Resolver(get(named(e1))) }

    //MODULO 5
    factory { OrtografiaFoneticaE1M5Resolver(get(named(e1))) }
    factory { OrtografiaVisualE1M5Resolver(get(named(e1))) }

    //MODULO 6
    factory { CalculoNumeracionE1M6Resolver(get(named(e1))) }
}

val evalua2Module = module {

    val e2 = "e2"

    single<BaremoTable>(named(e2)) { Evalua2Baremo() }

    //RESOLVERS
    //MODULO 1
    factory { PensamientoAnalogicoE2M1Resolver(get(named(e2))) }
    factory { OrganizacionPerceptivaE2M1Resolver(get(named(e2))) }
    factory { ClasificacionesE2M1Resolver(get(named(e2))) }

    //MODULO 2
    factory { MemoriaAtencionE2M2Resolver(get(named(e2))) }

    //MODULO 3
    factory { MotivacionFragmentE2M3Resolver(get(named(e2))) }
    factory { AutoControlFragmentE2M3Resolver(get(named(e2))) }
    factory { ConductaProSocialFragmentE2M3Resolver(get(named(e2))) }
    factory { AutoEstimaFragmentE2M3Resolver(get(named(e2))) }

    //MODULO 4
    factory { ComprensionLectoraE2M4Resolver(get(named(e2))) }

    //MODULO 5
    factory { OrtografiaE2M5Resolver(get(named(e2))) }

    //MODULO 6
    factory { CalculoNumeracionE2M6Resolver(get(named(e2))) }
    factory { ResolucionProblemasE2M6Resolver(get(named(e2))) }
}

val evalua3Module = module {

    val e3 = "e3"
    //Evalua 3 baremo
    single<BaremoTable>(named(e3)) { Evalua3Baremo() }

    //REsolvers
    //Modulo 1
    factory { MemoriaAtencionE3M1Resolver(get(named(e3))) }

    //MOdulo 2
    factory { ReflexividadE3M2Resolver(get(named(e3))) }
    factory { PensamientoAnalogicoE3M2Resolver(get(named(e3))) }
    factory { OrganizacionPerceptivaE3M2Resolver(get(named(e3))) }

    //Modulo 3
    factory { MotivacionFragmentE3M3Resolver(get(named(e3))) }
    factory { AutoControlFragmentE3M3Resolver(get(named(e3))) }
    factory { ConductaProSocialFragmentE3M3Resolver(get(named(e3))) }
    factory { AutoEstimaFragmentE3M3Resolver(get(named(e3))) }

    //Modulo 4
    factory { ComprensionLectoraE3M4Resolver(get(named(e3))) }
    factory { ExactitudLectoraE3M4Resolver(get(named(e3))) }

    //Modulo 5
    factory { OrtografiaFoneticaE3M5Resolver(get(named(e3))) }
    factory { OrtografiaVisualRegladaE3M5Resolver(get(named(e3))) }

    //Modulo 6
    factory { CalculoNumeracionE3M6Resolver(get(named(e3))) }
    factory { ResolucionProblemasE3M6Resolver(get(named(e3))) }
}

val evalua4Module = module {

    val e4 = "e4"
    //Evalua 4 baremo
    single<BaremoTable>(named(e4)) { Evalua4Baremo() }

    //RESOLVER

    //MODULO 1
    factory { MemoriaAtencionE4M1Resolver(get(named(e4))) }

    //Modulo 2
    factory { ReflexividadE4M2Resolver(get(named(e4))) }
    factory { PensamientoAnalogicoE4M2Resolver(get(named(e4))) }
    factory { OrganizacionPerceptivaE4M2Resolver(get(named(e4))) }

    //Modulo 3
    factory { MotivacionFragmentE4M3Resolver(get(named(e4))) }
    factory { AutoControlFragmentE4M3Resolver(get(named(e4))) }
    factory { ConductaProSocialFragmentE4M3Resolver(get(named(e4))) }
    factory { AutoEstimaFragmentE4M3Resolver(get(named(e4))) }

    //MODULO 4
    factory { ComprensionLectoraE4M4Resolver(get(named(e4))) }
    factory { VelocidadFragmentE4M4Resolver(get(named(e4))) }
    factory { ComprensionFragmentE4M4Resolver(get(named(e4))) }

    //MOdulo 5
    factory { OrtografiaVisualRegladaE4M5Resolver(get(named(e4))) }

    //Modulo 6
    factory { CalculoNumeracionE4M6Resolver(get(named(e4))) }
    factory { ResolucionProblemasE4M6Resolver(get(named(e4))) }
}

val evalua5Module = module {

    val e5 = "e5"
    //Evalua 5 baremo
    single<BaremoTable>(named(e5)) { Evalua5Baremo() }

    //RESOLVER

    //MODULO 1
    factory { MemoriaAtencionE5M1Resolver(get(named(e5))) }

    //MOdulo 2
    factory { ReflexividadE5M2Resolver(get(named(e5))) }
    factory { PensamientoAnalogicoE5M2Resolver(get(named(e5))) }
    factory { OrganizacionPerceptivaE5M2Resolver(get(named(e5))) }

    //Modulo 3
    factory { MotivacionFragmentE5M3Resolver(get(named(e5))) }
    factory { AutoControlFragmentE5M3Resolver(get(named(e5))) }
    factory { ConductaProSocialFragmentE5M3Resolver(get(named(e5))) }
    factory { AutoEstimaFragmentE5M3Resolver(get(named(e5))) }

    //Modulo 4
    factory { ComprensionLectoraE5M4Resolver(get(named(e5))) }
    factory { ComprensionFragmentE5M4Resolver(get(named(e5))) }
    factory { VelocidadFragmentE5M4Resolver(get(named(e5))) }
    factory { ExactitudLectoraE5M4Resolver(get(named(e5))) }

    //Modulo 5
    factory { OrtografiaFoneticaE5M5Resolver(get(named(e5))) }
    factory { OrtografiaVisualRegladaE4M5Resolver(get(named(e5))) }

    //Modulo6
    factory { CalculoNumeracionE5M6Resolver(get(named(e5))) }
    factory { ResolucionProblemasE5M6Resolver(get(named(e5))) }
}

val appModule = module {
    includes(
        evalua0Module,
        evalua1Module,
        evalua2Module,
        evalua3Module,
        evalua4Module,
        evalua5Module
    )
}