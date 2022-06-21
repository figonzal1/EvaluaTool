/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2022

 Last modified 21-06-22 12:27
 */

package cl.figonzal.evaluatool.di

import cl.figonzal.evaluatool.domain.baremo_tables.Evalua0Baremo
import cl.figonzal.evaluatool.domain.baremo_tables.Evalua1Baremo
import cl.figonzal.evaluatool.domain.baremo_tables.Evalua2Baremo
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
import org.koin.dsl.module


val evalua0Module = module {
    //Evalua 0 Baremo Table
    single<BaremoTable> { Evalua0Baremo() }

    //RESOLVERS

    //MODULO 1
    factory { ClasificacionE0M1Resolver(get()) }
    factory { SeriesE0M1Resolver(get()) }
    factory { OrganizacionPerceptivaE0M1Resolver(get()) }
    factory { LetrasYNumerosE0M1Resolver(get()) }
    factory { MemoriaVerbalE0M1Resolver(get()) }

    //MODULO 2
    factory { CopiaDibujosE0M2Resolver(get()) }
    factory { GrafoMotricidadE0M2Resolver(get()) }

    //MODULO 3
    factory { PalabrasYFrasesE0M3Resolver(get()) }
    factory { RecepcionAuditivaArticulacionE0M3Resolver(get()) }
    factory { HabilidadesFonologicasE0M3Resolver(get()) }
}


val evalua1Module = module {
    //Evalua 1 Baremo Table
    single<BaremoTable> { Evalua1Baremo() }

    //RESOLVERS

    //MODULO 1
    factory { MemoriaAtencionE1M1Resolver(get()) }

    //MODULO 2
    factory { SeriesE1M2Resolver(get()) }
    factory { ClasificacionesE1M2Resolver(get()) }
    factory { OrganizacionPerceptivaE1M2Resolver(get()) }

    //MODULO 3
    factory { MotivacionFragmentE1M3Resolver(get()) }
    factory { AutoControlFragmentE1M3Resolver(get()) }
    factory { ConductaProSocialFragmentE1M3Resolver(get()) }
    factory { AutoEstimaFragmentE1M3Resolver(get()) }

    //MODULO 4
    factory { ComprensionLectoraE1M4Resolver(get()) }
    factory { ExactitudLectoraE1M4Resolver(get()) }

    //MODULO 5
    factory { OrtografiaFoneticaE1M5Resolver(get()) }
    factory { OrtografiaVisualE1M5Resolver(get()) }

    //MODULO 6
    factory { CalculoNumeracionE1M6Resolver(get()) }
}

val evalua2Module = module {
    single<BaremoTable> { Evalua2Baremo() }

    //RESOLVERS
    //MODULO 1
    factory { PensamientoAnalogicoE2M1Resolver(get()) }
    factory { OrganizacionPerceptivaE2M1Resolver(get()) }
    factory { ClasificacionesE2M1Resolver(get()) }

    //MODULO 2
    factory { MemoriaAtencionE2M2Resolver(get()) }

    //MODULO 3
    factory { MotivacionFragmentE2M3Resolver(get()) }
    factory { AutoControlFragmentE2M3Resolver(get()) }
    factory { ConductaProSocialFragmentE2M3Resolver(get()) }
    factory { AutoEstimaFragmentE2M3Resolver(get()) }

    //MODULO 4
    factory { ComprensionLectoraE2M4Resolver(get()) }

    //MODULO 5
    factory { OrtografiaE2M5Resolver(get()) }

    //MODULO 6
    factory { CalculoNumeracionE2M6Resolver(get()) }
    factory { ResolucionProblemasE2M6Resolver(get()) }
}

val appModule = module {

    includes(
        evalua0Module,
        evalua1Module,
        evalua2Module
    )
}