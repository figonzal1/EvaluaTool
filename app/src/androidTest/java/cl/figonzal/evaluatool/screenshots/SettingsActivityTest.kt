/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2023

 Last modified 21-06-23 00:57
 */

package cl.figonzal.evaluatool.screenshots


import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.*
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import cl.figonzal.evaluatool.ui.SettingsActivity
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import tools.fastlane.screengrab.Screengrab
import tools.fastlane.screengrab.UiAutomatorScreenshotStrategy
import tools.fastlane.screengrab.cleanstatusbar.BluetoothState
import tools.fastlane.screengrab.cleanstatusbar.CleanStatusBar
import tools.fastlane.screengrab.cleanstatusbar.MobileDataType
import tools.fastlane.screengrab.locale.LocaleTestRule

@LargeTest
@RunWith(AndroidJUnit4::class)
class SettingsActivityTest {

    @Rule
    @JvmField
    val localeTestRule = LocaleTestRule()

    @Rule
    @JvmField
    var mActivityScenarioRule = ActivityScenarioRule(SettingsActivity::class.java)

    @Before
    fun setUp() {

        Screengrab.setDefaultScreenshotStrategy(
            UiAutomatorScreenshotStrategy()
        )

        CleanStatusBar()
            .setBluetoothState(BluetoothState.DISCONNECTED)
            .setMobileNetworkDataType(MobileDataType.LTE)
            .setClock("0900")
            .setBatteryLevel(100)
            .enable()
    }

    @Test
    fun testTakeScreenshot() {

        Thread.sleep(2000)

        Screengrab.screenshot("settings_activity")
    }

}
