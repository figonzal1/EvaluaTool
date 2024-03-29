/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2024

 Last modified 3/28/24, 9:29 PM
 */

import java.io.FileInputStream
import java.util.Properties

plugins {
    alias(libs.plugins.com.android.application)
    alias(libs.plugins.org.jetbrains.kotlin.android)
    alias(libs.plugins.com.google.gms.google.services)
    alias(libs.plugins.com.google.firebase.crashlytics)
    alias(libs.plugins.com.google.firebase.firebase.perf)
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
    compileSdk = 34

    defaultConfig {
        applicationId = "cl.figonzal.evaluatool"
        minSdk = 23
        targetSdk = 34
        versionCode = 40
        versionName = "1.1.2"
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
        buildConfig = true
    }
    lint {
        checkDependencies = true
    }
}

dependencies {

    implementation(libs.androidx.core.core.ktx)
    implementation(libs.androidx.appcompat)

    implementation(libs.com.google.android.material)
    implementation(libs.androidx.preference.preference.ktx)
    implementation(libs.androidx.core.core.splashscreen)

    //Life cycle components
    implementation(libs.bundles.lifecycle)

    //FIREBASE
    implementation(platform(libs.com.google.firebase.firebase.bom))
    implementation(libs.bundles.firebase)

    implementation(libs.com.jakewharton.timber)

    //Google Play
    implementation(libs.com.google.android.gms.play.services.base)
    implementation(libs.com.google.android.play.app.update.ktx)

    //KOIN
    implementation(libs.io.insert.koin.koin.core)
    implementation(libs.io.insert.koin.koin.android)

    //junit
    testImplementation(libs.junit)
    testImplementation(libs.androidx.test.core.ktx)
    testImplementation(libs.io.insert.koin.koin.test)
    testImplementation(libs.io.insert.koin.koin.test.junit4)
    testImplementation(libs.androidx.arch.core.testing)
    testImplementation(libs.androidx.test.ext.truth)

    androidTestImplementation(libs.androidx.test.ext.junit)
    androidTestImplementation(libs.androidx.test.espresso.espresso.core)
    androidTestImplementation(libs.androidx.test.espresso.espresso.contrib) {
        exclude(module = "protobuf-lite")
    }
    androidTestImplementation(libs.androidx.test.rules)
    androidTestImplementation(libs.androidx.test.runner)
    androidTestImplementation(libs.tools.fastlane.screengrab)

    //DEBUG
    //debugImplementation(libs.com.squareup.leakcanary.leakcanary.android)

    coreLibraryDesugaring(libs.com.android.tools.desugar.jdk.libs)
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
