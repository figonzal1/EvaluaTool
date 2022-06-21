/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2022

 Last modified 21-06-22 15:13
 */

package cl.figonzal.evaluatool.di

import cl.figonzal.evaluatool.domain.baremo_tables.Evalua0Baremo
import cl.figonzal.evaluatool.domain.baremo_tables.Evalua1Baremo
import cl.figonzal.evaluatool.domain.baremo_tables.Evalua2Baremo
import cl.figonzal.evaluatool.domain.baremo_tables.Evalua3Baremo
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

val appModule = module {
    includes(
        evalua0Module,
        evalua1Module,
        evalua2Module,
        evalua3Module
    )
}