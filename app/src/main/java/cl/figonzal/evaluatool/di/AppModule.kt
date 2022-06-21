/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2022

 Last modified 21-06-22 00:54
 */

package cl.figonzal.evaluatool.di

import cl.figonzal.evaluatool.domain.baremo_tables.Evalua0Baremo
import cl.figonzal.evaluatool.domain.resolvers.BaremoTable
import cl.figonzal.evaluatool.domain.resolvers.evalua0.modulo1.*
import cl.figonzal.evaluatool.domain.resolvers.evalua0.modulo2.CopiaDibujosE0M2Resolver
import cl.figonzal.evaluatool.domain.resolvers.evalua0.modulo2.GrafoMotricidadE0M2Resolver
import cl.figonzal.evaluatool.domain.resolvers.evalua0.modulo3.HabilidadesFonologicasE0M3Resolver
import cl.figonzal.evaluatool.domain.resolvers.evalua0.modulo3.PalabrasYFrasesE0M3Resolver
import cl.figonzal.evaluatool.domain.resolvers.evalua0.modulo3.RecepcionAuditivaArticulacionE0M3Resolver
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

/*
val evalua1Module = module {
    //Evalua 1 Baremo Table
    single<BaremoTable> { Evalua1Baremo() }

    //RESOLVERS
    factory { MemoriaAtencionE1M1Resolver(get()) }
}*/
val appModule = module {

    includes(evalua0Module)//, evalua1Module)
}