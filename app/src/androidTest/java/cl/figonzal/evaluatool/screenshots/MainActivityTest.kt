/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2024

 Last modified 09-11-24, 21:57
 */

package cl.figonzal.evaluatool.screenshots


import android.widget.ScrollView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.*
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import cl.figonzal.evaluatool.BuildConfig
import cl.figonzal.evaluatool.ui.MainActivity
import org.hamcrest.Matchers
import org.hamcrest.core.IsInstanceOf
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
class MainActivityTest {

    @Rule
    @JvmField
    val localeTestRule = LocaleTestRule()

    @Rule
    @JvmField
    var mActivityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

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

        Screengrab.screenshot("main_activity")
    }

    @Test
    fun mainActivityTest() {
        // Added a sleep statement to match the app's execution delay.
        // The recommended way to handle such scenarios is to use Espresso idling resources:
        // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
        Thread.sleep(7000)

        val button = onView(
            Matchers.allOf(
                withId(cl.figonzal.evaluatool.R.id.btn_evalua_0), withText("EVALÚA 0"),
                withParent(withParent(IsInstanceOf.instanceOf(ScrollView::class.java))),
                isDisplayed()
            )
        )
        button.check(matches(isDisplayed()))

        val button2 = onView(
            Matchers.allOf(
                withId(cl.figonzal.evaluatool.R.id.btn_evalua_1), withText("EVALÚA 1"),
                withParent(withParent(IsInstanceOf.instanceOf(ScrollView::class.java))),
                isDisplayed()
            )
        )
        button2.check(matches(isDisplayed()))

        val button3 = onView(
            Matchers.allOf(
                withId(cl.figonzal.evaluatool.R.id.btn_evalua_2), withText("EVALÚA 2"),
                withParent(withParent(IsInstanceOf.instanceOf(ScrollView::class.java))),
                isDisplayed()
            )
        )
        button3.check(matches(isDisplayed()))

        val button4 = onView(
            Matchers.allOf(
                withId(cl.figonzal.evaluatool.R.id.btn_evalua_3), withText("EVALÚA 3"),
                withParent(withParent(IsInstanceOf.instanceOf(ScrollView::class.java))),
                isDisplayed()
            )
        )
        button4.check(matches(isDisplayed()))

        val button5 = onView(
            Matchers.allOf(
                withId(cl.figonzal.evaluatool.R.id.btn_evalua_4), withText("EVALÚA 4"),
                withParent(withParent(IsInstanceOf.instanceOf(ScrollView::class.java))),
                isDisplayed()
            )
        )
        button5.check(matches(isDisplayed()))

        val button6 = onView(
            Matchers.allOf(
                withId(cl.figonzal.evaluatool.R.id.btn_evalua_5), withText("EVALÚA 5"),
                withParent(withParent(IsInstanceOf.instanceOf(ScrollView::class.java))),
                isDisplayed()
            )
        )
        button6.check(matches(isDisplayed()))

        val button7 = onView(
            Matchers.allOf(
                withId(cl.figonzal.evaluatool.R.id.btn_evalua_6), withText("EVALÚA 6"),
                withParent(withParent(IsInstanceOf.instanceOf(ScrollView::class.java))),
                isDisplayed()
            )
        )
        button7.check(matches(isDisplayed()))

        val button8 = onView(
            Matchers.allOf(
                withId(cl.figonzal.evaluatool.R.id.btn_evalua_7), withText("EVALÚA 7"),
                withParent(withParent(IsInstanceOf.instanceOf(ScrollView::class.java))),
                isDisplayed()
            )
        )
        button8.check(matches(isDisplayed()))

        val button9 = onView(
            Matchers.allOf(
                withId(cl.figonzal.evaluatool.R.id.btn_evalua_8), withText("EVALÚA 8"),
                withParent(withParent(IsInstanceOf.instanceOf(ScrollView::class.java))),
                isDisplayed()
            )
        )
        button9.check(matches(isDisplayed()))

        val button10 = onView(
            Matchers.allOf(
                withId(cl.figonzal.evaluatool.R.id.btn_evalua_9), withText("EVALÚA 9"),
                withParent(withParent(IsInstanceOf.instanceOf(ScrollView::class.java))),
                isDisplayed()
            )
        )
        button10.check(matches(isDisplayed()))

        val button11 = onView(
            Matchers.allOf(
                withId(cl.figonzal.evaluatool.R.id.btn_evalua_10), withText("EVALÚA 10"),
                withParent(withParent(IsInstanceOf.instanceOf(ScrollView::class.java))),
                isDisplayed()
            )
        )
        button11.check(matches(isDisplayed()))

        val textView = onView(
            Matchers.allOf(
                withId(cl.figonzal.evaluatool.R.id.tv_version),
                withText("v" + BuildConfig.VERSION_NAME),
                withParent(withParent(IsInstanceOf.instanceOf(ScrollView::class.java))),
                isDisplayed()
            )
        )
        textView.check(matches(withText("v" + BuildConfig.VERSION_NAME)))

        try {
            Thread.sleep(2000)
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }
    }
}
