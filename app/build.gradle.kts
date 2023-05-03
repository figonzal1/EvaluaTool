/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2023

 Last modified 02-05-23 22:27
 */

import java.io.FileInputStream
import java.util.Properties

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.google.gms.google-services")
    id("com.google.firebase.crashlytics")
    id("com.google.firebase.firebase-perf")
}

android {

    val prop = Properties().apply {
        load(FileInputStream(File(rootProject.rootDir, "keystore.properties")))
    }

    signingConfigs {
        create("evaluatoolsign") {
            storeFile = file(prop.getProperty("storeFile"))
            storePassword = prop.getProperty("storePassword").toString()
            keyPassword = prop.getProperty("keyPassword").toString()
            keyAlias = prop.getProperty("keyAlias").toString()
        }
    }

    namespace = "cl.figonzal.evaluatool"
    compileSdk = 33
    buildToolsVersion = "33.0.2"

    defaultConfig {
        applicationId = "cl.figonzal.evaluatool"
        minSdk = 23
        targetSdk = 33
        versionCode = 35
        versionName = "1.0.7"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("debug") {
            isDebuggable = true
            isMinifyEnabled = false
            versionNameSuffix = "-debug"
            applicationIdSuffix = ".debug"
            signingConfig = signingConfigs.getByName("debug")

            resValue("string", "app_name", "EvalúaTool-debug")

        }

        getByName("release") {
            isDebuggable = false
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro"
            )
            signingConfig = signingConfigs.getByName("evaluatoolsign")

            resValue("string", "app_name", "EvalúaTool")
        }
    }
    compileOptions {
        isCoreLibraryDesugaringEnabled = true
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlinOptions {
        jvmTarget = "17"
    }


    buildFeatures {
        viewBinding = true
    }
    lint {
        checkDependencies = true
    }
    flavorDimensions += listOf("version")
    productFlavors {
        create("dev") {
            dimension = "version"
            versionNameSuffix = "-dev"
        }
        create("prod") {
            dimension = "version"
        }
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.10.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")

    implementation("com.google.android.material:material:1.8.0") //Material Design
    implementation("androidx.preference:preference-ktx:1.2.0")//Preferencias de usuario
    implementation("androidx.core:core-splashscreen:1.0.1")//splash screen

    //Life cycle components
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.1")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.1")

    //FIREBASE
    implementation(platform("com.google.firebase:firebase-bom:31.5.0"))
    implementation("com.google.firebase:firebase-analytics-ktx")
    implementation("com.google.firebase:firebase-crashlytics-ktx")
    implementation("com.google.firebase:firebase-perf-ktx")

    implementation("com.jakewharton.timber:timber:5.0.1")//Timber logs

    //Google Play
    implementation("com.google.android.gms:play-services-base:18.2.0")
    implementation("com.google.android.play:app-update-ktx:2.0.1")

    //KOIN
    implementation("io.insert-koin:koin-core:3.4.0")
    implementation("io.insert-koin:koin-android:3.4.0")

    //junit
    testImplementation("junit:junit:4.13.2")
    testImplementation("androidx.test:core-ktx:1.5.0")
    testImplementation("io.insert-koin:koin-test:3.4.0")
    testImplementation("io.insert-koin:koin-test-junit4:3.4.0")
    testImplementation("androidx.arch.core:core-testing:2.2.0")
    testImplementation("androidx.test.ext:truth:1.5.0")

    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation("androidx.test:rules:1.5.0")
    androidTestImplementation("androidx.test:runner:1.5.2")
    androidTestImplementation("androidx.test.espresso:espresso-contrib:3.5.1")

    //DEBUG
    debugImplementation("com.squareup.leakcanary:leakcanary-android:2.9.1")

    coreLibraryDesugaring("com.android.tools:desugar_jdk_libs:1.1.5")
}

sonarqube {
    properties {
        property("sonar.projectName", "EvaluaTool")
        property("sonar.projectKey", "EvaluaTool")
        property("sonar.test.inclusions", "**/*Test*/**")
        property("sonar.sourceEncoding", "UTF-8")
        property("sonar.sources", "src/main/java")
    }
}
