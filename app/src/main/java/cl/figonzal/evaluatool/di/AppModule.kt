/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2022

 Last modified 23-06-22 00:59
 */

package cl.figonzal.evaluatool.di

import cl.figonzal.evaluatool.domain.baremo_tables.*
import cl.figonzal.evaluatool.domain.baremo_tables.tables.Evalua0Baremo
import cl.figonzal.evaluatool.domain.baremo_tables.tables.Evalua1Baremo
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
import cl.figonzal.evaluatool.domain.resolvers.evalua10.modulo1.AtencionConcentracionE10M1Resolver
import cl.figonzal.evaluatool.domain.resolvers.evalua10.modulo2.RazonamientoDeductivoE10M2Resolver
import cl.figonzal.evaluatool.domain.resolvers.evalua10.modulo2.RazonamientoEspacialE10M2Resolver
import cl.figonzal.evaluatool.domain.resolvers.evalua10.modulo2.RazonamientoInductivoE10M2Resolver
import cl.figonzal.evaluatool.domain.resolvers.evalua10.modulo3.AdaptacionEscolarFragmentE10M3Resolver
import cl.figonzal.evaluatool.domain.resolvers.evalua10.modulo3.AdaptacionFamiliarFragmentE10M3Resolver
import cl.figonzal.evaluatool.domain.resolvers.evalua10.modulo3.AdaptacionPersonalFragmentE10M3Resolver
import cl.figonzal.evaluatool.domain.resolvers.evalua10.modulo3.HabilidadesSocialesFragmentE10M3Resolver
import cl.figonzal.evaluatool.domain.resolvers.evalua10.modulo4.ComprensionFragmentE10M4Resolver
import cl.figonzal.evaluatool.domain.resolvers.evalua10.modulo4.ComprensionLectoraE10M4Resolver
import cl.figonzal.evaluatool.domain.resolvers.evalua10.modulo4.VelocidadFragmentE10M4Resolver
import cl.figonzal.evaluatool.domain.resolvers.evalua10.modulo5.OrtografiaVisualRegladaE10M5Resolver
import cl.figonzal.evaluatool.domain.resolvers.evalua10.modulo6.CalculoNumeracionE10M6Resolver
import cl.figonzal.evaluatool.domain.resolvers.evalua10.modulo6.ResolucionProblemasE10M6Resolver
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
import cl.figonzal.evaluatool.domain.resolvers.evalua5.modulo5.OrtografiaVisualRegladaE5M5Resolver
import cl.figonzal.evaluatool.domain.resolvers.evalua5.modulo6.CalculoNumeracionE5M6Resolver
import cl.figonzal.evaluatool.domain.resolvers.evalua5.modulo6.ResolucionProblemasE5M6Resolver
import cl.figonzal.evaluatool.domain.resolvers.evalua6.modulo1.OrganizacionPerceptivaE6M1Resolver
import cl.figonzal.evaluatool.domain.resolvers.evalua6.modulo1.PensamientoAnalogicoE6M1Resolver
import cl.figonzal.evaluatool.domain.resolvers.evalua6.modulo1.ReflexividadE6M1Resolver
import cl.figonzal.evaluatool.domain.resolvers.evalua6.modulo2.MemoriaAtencionE6M2Resolver
import cl.figonzal.evaluatool.domain.resolvers.evalua6.modulo3.AutoControlFragmentE6M3Resolver
import cl.figonzal.evaluatool.domain.resolvers.evalua6.modulo3.AutoEstimaFragmentE6M3Resolver
import cl.figonzal.evaluatool.domain.resolvers.evalua6.modulo3.ConductaProSocialFragmentE6M3Resolver
import cl.figonzal.evaluatool.domain.resolvers.evalua6.modulo3.MotivacionFragmentE6M3Resolver
import cl.figonzal.evaluatool.domain.resolvers.evalua6.modulo4.ComprensionFragmentE6M4Resolver
import cl.figonzal.evaluatool.domain.resolvers.evalua6.modulo4.ComprensionLectoraE6M4Resolver
import cl.figonzal.evaluatool.domain.resolvers.evalua6.modulo4.VelocidadFragmentE6M4Resolver
import cl.figonzal.evaluatool.domain.resolvers.evalua6.modulo5.OrtografiaVisualRegladaE6M5Resolver
import cl.figonzal.evaluatool.domain.resolvers.evalua6.modulo6.CalculoNumeracionE6M6Resolver
import cl.figonzal.evaluatool.domain.resolvers.evalua6.modulo6.ResolucionProblemasE6M6Resolver
import cl.figonzal.evaluatool.domain.resolvers.evalua7.modulo1.AtencionConcentracionE7M1Resolver
import cl.figonzal.evaluatool.domain.resolvers.evalua7.modulo2.RazonamientoDeductivoE7M2Resolver
import cl.figonzal.evaluatool.domain.resolvers.evalua7.modulo2.RazonamientoEspacialE7M2Resolver
import cl.figonzal.evaluatool.domain.resolvers.evalua7.modulo2.RazonamientoInductivoE7M2Resolver
import cl.figonzal.evaluatool.domain.resolvers.evalua7.modulo3.AutoControlFragmentE7M3Resolver
import cl.figonzal.evaluatool.domain.resolvers.evalua7.modulo3.AutoEstimaFragmentE7M3Resolver
import cl.figonzal.evaluatool.domain.resolvers.evalua7.modulo3.ConductaProSocialFragmentE7M3Resolver
import cl.figonzal.evaluatool.domain.resolvers.evalua7.modulo3.MotivacionFragmentE7M3Resolver
import cl.figonzal.evaluatool.domain.resolvers.evalua7.modulo4.ComprensionFragmentE7M4Resolver
import cl.figonzal.evaluatool.domain.resolvers.evalua7.modulo4.ComprensionLectoraE7M4Resolver
import cl.figonzal.evaluatool.domain.resolvers.evalua7.modulo4.EficaciaLectoraE7M4Resolver
import cl.figonzal.evaluatool.domain.resolvers.evalua7.modulo4.VelocidadFragmentE7M4Resolver
import cl.figonzal.evaluatool.domain.resolvers.evalua7.modulo5.ExpresionEscritaE7M5Resolver
import cl.figonzal.evaluatool.domain.resolvers.evalua7.modulo5.OrtografiaFoneticaE7M5Resolver
import cl.figonzal.evaluatool.domain.resolvers.evalua7.modulo5.OrtografiaVisualRegladaE7M5Resolver
import cl.figonzal.evaluatool.domain.resolvers.evalua7.modulo6.CalculoNumeracionE7M6Resolver
import cl.figonzal.evaluatool.domain.resolvers.evalua7.modulo6.ResolucionProblemasE7M6Resolver
import cl.figonzal.evaluatool.domain.resolvers.evalua8.modulo1.AtencionConcentracionE8M1Resolver
import cl.figonzal.evaluatool.domain.resolvers.evalua8.modulo2.RazonamientoDeductivoE8M2Resolver
import cl.figonzal.evaluatool.domain.resolvers.evalua8.modulo2.RazonamientoEspacialE8M2Resolver
import cl.figonzal.evaluatool.domain.resolvers.evalua8.modulo2.RazonamientoInductivoE8M2Resolver
import cl.figonzal.evaluatool.domain.resolvers.evalua8.modulo3.AdaptacionEscolarFragmentE8M3Resolver
import cl.figonzal.evaluatool.domain.resolvers.evalua8.modulo3.AdaptacionFamiliarFragmentE8M3Resolver
import cl.figonzal.evaluatool.domain.resolvers.evalua8.modulo3.AdaptacionPersonalFragmentE8M3Resolver
import cl.figonzal.evaluatool.domain.resolvers.evalua8.modulo3.HabilidadesSocialesFragmentE8M3Resolver
import cl.figonzal.evaluatool.domain.resolvers.evalua8.modulo4.ComprensionFragmentE8M4Resolver
import cl.figonzal.evaluatool.domain.resolvers.evalua8.modulo4.ComprensionLectoraE8M4Resolver
import cl.figonzal.evaluatool.domain.resolvers.evalua8.modulo4.EficaciaLectoraE8M4Resolver
import cl.figonzal.evaluatool.domain.resolvers.evalua8.modulo4.VelocidadFragmentE8M4Resolver
import cl.figonzal.evaluatool.domain.resolvers.evalua8.modulo5.OrtografiaVisualRegladaE8M5Resolver
import cl.figonzal.evaluatool.domain.resolvers.evalua8.modulo6.CalculoNumeracionE8M6Resolver
import cl.figonzal.evaluatool.domain.resolvers.evalua8.modulo6.ResolucionProblemasE8M6Resolver
import cl.figonzal.evaluatool.domain.resolvers.evalua9.modulo1.AtencionConcentracionE9M1Resolver
import cl.figonzal.evaluatool.domain.resolvers.evalua9.modulo2.RazonamientoDeductivoE9M2Resolver
import cl.figonzal.evaluatool.domain.resolvers.evalua9.modulo2.RazonamientoEspacialE9M2Resolver
import cl.figonzal.evaluatool.domain.resolvers.evalua9.modulo2.RazonamientoInductivoE9M2Resolver
import cl.figonzal.evaluatool.domain.resolvers.evalua9.modulo3.AdaptacionEscolarFragmentE9M3Resolver
import cl.figonzal.evaluatool.domain.resolvers.evalua9.modulo3.AdaptacionFamiliarFragmentE9M3Resolver
import cl.figonzal.evaluatool.domain.resolvers.evalua9.modulo3.AdaptacionPersonalFragmentE9M3Resolver
import cl.figonzal.evaluatool.domain.resolvers.evalua9.modulo3.HabilidadesSocialesFragmentE9M3Resolver
import cl.figonzal.evaluatool.domain.resolvers.evalua9.modulo4.ComprensionFragmentE9M4Resolver
import cl.figonzal.evaluatool.domain.resolvers.evalua9.modulo4.ComprensionLectoraE9M4Resolver
import cl.figonzal.evaluatool.domain.resolvers.evalua9.modulo4.EficaciaLectoraE9M4Resolver
import cl.figonzal.evaluatool.domain.resolvers.evalua9.modulo4.VelocidadFragmentE9M4Resolver
import cl.figonzal.evaluatool.domain.resolvers.evalua9.modulo5.OrtografiaVisualRegladaE9M5Resolver
import cl.figonzal.evaluatool.domain.resolvers.evalua9.modulo6.CalculoNumeracionE9M6Resolver
import cl.figonzal.evaluatool.domain.resolvers.evalua9.modulo6.ResolucionProblemasE9M6Resolver
import org.koin.core.qualifier.named
import org.koin.dsl.module


val evalua0Module = module {

    val e0 = "e0"

    //Evalua 0 Baremo Table
    single<BaremoTable>(named(e0)) { Evalua0Baremo() }

    //RESOLVERS

    //Modulo 1
    factory { ClasificacionE0M1Resolver(get(named(e0))) }
    factory { SeriesE0M1Resolver(get(named(e0))) }
    factory { OrganizacionPerceptivaE0M1Resolver(get(named(e0))) }
    factory { LetrasYNumerosE0M1Resolver(get(named(e0))) }
    factory { MemoriaVerbalE0M1Resolver(get(named(e0))) }

    //Modulo 2
    factory { CopiaDibujosE0M2Resolver(get(named(e0))) }
    factory { GrafoMotricidadE0M2Resolver(get(named(e0))) }

    //Modulo 3
    factory { PalabrasYFrasesE0M3Resolver(get(named(e0))) }
    factory { RecepcionAuditivaArticulacionE0M3Resolver(get(named(e0))) }
    factory { HabilidadesFonologicasE0M3Resolver(get(named(e0))) }
}


val evalua1Module = module {

    val e1 = "e1"

    //Evalua 1 Baremo Table
    single<BaremoTable>(named(e1)) { Evalua1Baremo() }

    //RESOLVERS

    //Modulo 1
    factory { MemoriaAtencionE1M1Resolver(get(named(e1))) }

    //Modulo 2
    factory { SeriesE1M2Resolver(get(named(e1))) }
    factory { ClasificacionesE1M2Resolver(get(named(e1))) }
    factory { OrganizacionPerceptivaE1M2Resolver(get(named(e1))) }

    //Modulo 3
    factory { MotivacionFragmentE1M3Resolver(get(named(e1))) }
    factory { AutoControlFragmentE1M3Resolver(get(named(e1))) }
    factory { ConductaProSocialFragmentE1M3Resolver(get(named(e1))) }
    factory { AutoEstimaFragmentE1M3Resolver(get(named(e1))) }

    //Modulo 4
    factory { ComprensionLectoraE1M4Resolver(get(named(e1))) }
    factory { ExactitudLectoraE1M4Resolver(get(named(e1))) }

    //Modulo 5
    factory { OrtografiaFoneticaE1M5Resolver(get(named(e1))) }
    factory { OrtografiaVisualE1M5Resolver(get(named(e1))) }

    //Modulo 6
    factory { CalculoNumeracionE1M6Resolver(get(named(e1))) }
}

val evalua2Module = module {

    val e2 = "e2"

    single<BaremoTable>(named(e2)) { Evalua2Baremo() }

    //RESOLVERS
    //Modulo 1
    factory { PensamientoAnalogicoE2M1Resolver(get(named(e2))) }
    factory { OrganizacionPerceptivaE2M1Resolver(get(named(e2))) }
    factory { ClasificacionesE2M1Resolver(get(named(e2))) }

    //Modulo 2
    factory { MemoriaAtencionE2M2Resolver(get(named(e2))) }

    //Modulo 3
    factory { MotivacionFragmentE2M3Resolver(get(named(e2))) }
    factory { AutoControlFragmentE2M3Resolver(get(named(e2))) }
    factory { ConductaProSocialFragmentE2M3Resolver(get(named(e2))) }
    factory { AutoEstimaFragmentE2M3Resolver(get(named(e2))) }

    //Modulo 4
    factory { ComprensionLectoraE2M4Resolver(get(named(e2))) }

    //Modulo 5
    factory { OrtografiaE2M5Resolver(get(named(e2))) }

    //Modulo 6
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

    //Modulo 2
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

    //Modulo 1
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

    //Modulo 4
    factory { ComprensionLectoraE4M4Resolver(get(named(e4))) }
    factory { VelocidadFragmentE4M4Resolver(get(named(e4))) }
    factory { ComprensionFragmentE4M4Resolver(get(named(e4))) }

    //Modulo 5
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

    //Modulo 1
    factory { MemoriaAtencionE5M1Resolver(get(named(e5))) }

    //Modulo 2
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
    factory { OrtografiaVisualRegladaE5M5Resolver(get(named(e5))) }

    //Modulo6
    factory { CalculoNumeracionE5M6Resolver(get(named(e5))) }
    factory { ResolucionProblemasE5M6Resolver(get(named(e5))) }
}

val evalua6Module = module {

    val e6 = "e6"

    single<BaremoTable>(named(e6)) { Evalua6Baremo() }

    //RESOLVERS

    //Modulo 1
    factory { ReflexividadE6M1Resolver(get(named(e6))) }
    factory { PensamientoAnalogicoE6M1Resolver(get(named(e6))) }
    factory { OrganizacionPerceptivaE6M1Resolver(get(named(e6))) }

    //Modulo 2
    factory { MemoriaAtencionE6M2Resolver(get(named(e6))) }

    //Modulo3
    factory { MotivacionFragmentE6M3Resolver(get(named(e6))) }
    factory { AutoControlFragmentE6M3Resolver(get(named(e6))) }
    factory { ConductaProSocialFragmentE6M3Resolver(get(named(e6))) }
    factory { AutoEstimaFragmentE6M3Resolver(get(named(e6))) }

    //Modulo4
    factory { ComprensionLectoraE6M4Resolver(get(named(e6))) }
    factory { ComprensionFragmentE6M4Resolver(get(named(e6))) }
    factory { VelocidadFragmentE6M4Resolver(get(named(e6))) }

    //Modulo 5
    factory { OrtografiaVisualRegladaE6M5Resolver(get(named(e6))) }

    //Modulo6
    factory { CalculoNumeracionE6M6Resolver(get(named(e6))) }
    factory { ResolucionProblemasE6M6Resolver(get(named(e6))) }
}

val evalua7Module = module {

    val e7 = "e7"

    single<BaremoTable>(named(e7)) { Evalua7Baremo() }

    //Resolver

    //Modulo 1
    factory { AtencionConcentracionE7M1Resolver(get(named(e7))) }

    //Modulo 2
    factory { RazonamientoDeductivoE7M2Resolver(get(named(e7))) }
    factory { RazonamientoInductivoE7M2Resolver(get(named(e7))) }
    factory { RazonamientoEspacialE7M2Resolver(get(named(e7))) }

    //Modulo 3
    factory { MotivacionFragmentE7M3Resolver(get(named(e7))) }
    factory { AutoControlFragmentE7M3Resolver(get(named(e7))) }
    factory { ConductaProSocialFragmentE7M3Resolver(get(named(e7))) }
    factory { AutoEstimaFragmentE7M3Resolver(get(named(e7))) }

    //Modulo 4
    factory { EficaciaLectoraE7M4Resolver(get(named(e7))) }
    factory { ComprensionLectoraE7M4Resolver(get(named(e7))) }
    factory { VelocidadFragmentE7M4Resolver(get(named(e7))) }
    factory { ComprensionFragmentE7M4Resolver(get(named(e7))) }

    //Modulo 5
    factory { OrtografiaFoneticaE7M5Resolver(get(named(e7))) }
    factory { OrtografiaVisualRegladaE7M5Resolver(get(named(e7))) }
    factory { ExpresionEscritaE7M5Resolver(get(named(e7))) }

    //Modulo 6
    factory { CalculoNumeracionE7M6Resolver(get(named(e7))) }
    factory { ResolucionProblemasE7M6Resolver(get(named(e7))) }
}

val evalua8Module = module {

    val e8 = "e8"

    single<BaremoTable>(named(e8)) { Evalua8Baremo() }

    //RESOLVERS

    //Modulo 1
    factory { AtencionConcentracionE8M1Resolver(get(named(e8))) }

    //Modulo 2
    factory { RazonamientoInductivoE8M2Resolver(get(named(e8))) }
    factory { RazonamientoEspacialE8M2Resolver(get(named(e8))) }
    factory { RazonamientoDeductivoE8M2Resolver(get(named(e8))) }

    //Modulo 3
    factory { AdaptacionPersonalFragmentE8M3Resolver(get(named(e8))) }
    factory { AdaptacionFamiliarFragmentE8M3Resolver(get(named(e8))) }
    factory { AdaptacionEscolarFragmentE8M3Resolver(get(named(e8))) }
    factory { HabilidadesSocialesFragmentE8M3Resolver(get(named(e8))) }

    //Modulo 4
    factory { ComprensionLectoraE8M4Resolver(get(named(e8))) }
    factory { EficaciaLectoraE8M4Resolver(get(named(e8))) }
    factory { VelocidadFragmentE8M4Resolver(get(named(e8))) }
    factory { ComprensionFragmentE8M4Resolver(get(named(e8))) }

    //Modulo 5
    factory { OrtografiaVisualRegladaE8M5Resolver(get(named(e8))) }

    //Modulo6
    factory { CalculoNumeracionE8M6Resolver(get(named(e8))) }
    factory { ResolucionProblemasE8M6Resolver(get(named(e8))) }
}

val evalua9Module = module {

    val e9 = "e9"

    single<BaremoTable>(named(e9)) { Evalua9Baremo() }

    //RESOLVERS

    //Modulo 1
    factory { AtencionConcentracionE9M1Resolver(get(named(e9))) }

    //Modulo 2
    factory { RazonamientoInductivoE9M2Resolver(get(named(e9))) }
    factory { RazonamientoEspacialE9M2Resolver(get(named(e9))) }
    factory { RazonamientoDeductivoE9M2Resolver(get(named(e9))) }

    //Modulo 3
    factory { AdaptacionPersonalFragmentE9M3Resolver(get(named(e9))) }
    factory { AdaptacionFamiliarFragmentE9M3Resolver(get(named(e9))) }
    factory { AdaptacionEscolarFragmentE9M3Resolver(get(named(e9))) }
    factory { HabilidadesSocialesFragmentE9M3Resolver(get(named(e9))) }

    //Modulo 4
    factory { ComprensionLectoraE9M4Resolver(get(named(e9))) }
    factory { EficaciaLectoraE9M4Resolver(get(named(e9))) }
    factory { VelocidadFragmentE9M4Resolver(get(named(e9))) }
    factory { ComprensionFragmentE9M4Resolver(get(named(e9))) }

    //Modulo 5
    factory { OrtografiaVisualRegladaE9M5Resolver(get(named(e9))) }

    //Modulo 6
    factory { CalculoNumeracionE9M6Resolver(get(named(e9))) }
    factory { ResolucionProblemasE9M6Resolver(get(named(e9))) }
}

val evalua10Module = module {

    val e10 = "e10"
    single<BaremoTable>(named(e10)) { Evalua10Baremo() }

    //RESOLVER

    //Modulo 1
    factory { AtencionConcentracionE10M1Resolver(get(named(e10))) }

    //Modulo2
    factory { RazonamientoInductivoE10M2Resolver(get(named(e10))) }
    factory { RazonamientoEspacialE10M2Resolver(get(named(e10))) }
    factory { RazonamientoDeductivoE10M2Resolver(get(named(e10))) }

    //Modulo 3
    factory { AdaptacionPersonalFragmentE10M3Resolver(get(named(e10))) }
    factory { AdaptacionFamiliarFragmentE10M3Resolver(get(named(e10))) }
    factory { AdaptacionEscolarFragmentE10M3Resolver(get(named(e10))) }
    factory { HabilidadesSocialesFragmentE10M3Resolver(get(named(e10))) }

    //Modulo4
    factory { ComprensionLectoraE10M4Resolver(get(named(e10))) }
    factory { VelocidadFragmentE10M4Resolver(get(named(e10))) }
    factory { ComprensionFragmentE10M4Resolver(get(named(e10))) }

    //Modulo 5
    factory { OrtografiaVisualRegladaE10M5Resolver(get(named(e10))) }

    //Modulo 6
    factory { CalculoNumeracionE10M6Resolver(get(named(e10))) }
    factory { ResolucionProblemasE10M6Resolver(get(named(e10))) }
}

val appModule = module {
    includes(
        evalua0Module,
        evalua1Module,
        evalua2Module,
        evalua3Module,
        evalua4Module,
        evalua5Module,
        evalua6Module,
        evalua7Module,
        evalua8Module,
        evalua9Module,
        evalua10Module
    )
}