/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2023

 Last modified 21-06-23 00:26
 */

package cl.figonzal.evaluatool.screenshots


import android.view.View
import android.view.ViewGroup
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.*
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import cl.figonzal.evaluatool.R
import cl.figonzal.evaluatool.ui.evaluas.evalua4.modulo2.PensamientoAnalogicoE4M2
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.Matchers.allOf
import org.hamcrest.Matchers.`is`
import org.hamcrest.TypeSafeMatcher
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
class PensamientoAnalogicoActivityTest {

    @Rule
    @JvmField
    val localeTestRule = LocaleTestRule()

    @Rule
    @JvmField
    var mActivityScenarioRule = ActivityScenarioRule(PensamientoAnalogicoE4M2::class.java)

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
    fun takeScreenShot() {

        // Added a sleep statement to match the app's execution delay.
        // The recommended way to handle such scenarios is to use Espresso idling resources:
        // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
        Thread.sleep(7000)

        val textInputEditText = onView(
            allOf(
                withId(R.id.et_aprobadas_t1),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.it_aprobadas_t1),
                        0
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        textInputEditText.perform(replaceText("1"), closeSoftKeyboard())

        // Added a sleep statement to match the app's execution delay.
        // The recommended way to handle such scenarios is to use Espresso idling resources:
        // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
        Thread.sleep(5000)

        val textInputEditText2 = onView(
            allOf(
                withId(R.id.et_aprobadas_t1), withText("1"),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.it_aprobadas_t1),
                        0
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        textInputEditText2.perform(replaceText("12"))

        val textInputEditText3 = onView(
            allOf(
                withId(R.id.et_aprobadas_t1), withText("12"),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.it_aprobadas_t1),
                        0
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        textInputEditText3.perform(closeSoftKeyboard())

        // Added a sleep statement to match the app's execution delay.
        // The recommended way to handle such scenarios is to use Espresso idling resources:
        // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
        Thread.sleep(5000)

        val textInputEditText4 = onView(
            allOf(
                withId(R.id.et_reprobadas_t1),
                childAtPosition(
                    childAtPosition(
                        withClassName(`is`("com.google.android.material.textfield.TextInputLayout")),
                        0
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        textInputEditText4.perform(replaceText("2"), closeSoftKeyboard())

        Thread.sleep(2000)

        Screengrab.screenshot("pensamiento_analog_activity")

        Thread.sleep(2000)
    }

    @Test
    fun takeScreenShot2() {
        val materialTextView = onView(
            allOf(
                withId(R.id.tv_baremo), withText("Ver tabla de baremos"),
                childAtPosition(
                    allOf(
                        withId(R.id.tabla_baremo),
                        childAtPosition(
                            withClassName(`is`("androidx.constraintlayout.widget.ConstraintLayout")),
                            0
                        )
                    ),
                    1
                )
            )
        )
        materialTextView.perform(scrollTo(), click())

        Thread.sleep(2000)

        Screengrab.screenshot("tabla_baremo")

        Thread.sleep(2000)

        val materialButton2 = onView(
            allOf(
                withId(R.id.btn_cerrar), withText("Cerrar"),
                childAtPosition(
                    childAtPosition(
                        withClassName(`is`("com.google.android.material.card.MaterialCardView")),
                        0
                    ),
                    3
                ),
                isDisplayed()
            )
        )
        materialButton2.perform(click())
    }

    private fun childAtPosition(
        parentMatcher: Matcher<View>, position: Int
    ): Matcher<View> {

        return object : TypeSafeMatcher<View>() {
            override fun describeTo(description: Description) {
                description.appendText("Child at position $position in parent ")
                parentMatcher.describeTo(description)
            }

            public override fun matchesSafely(view: View): Boolean {
                val parent = view.parent
                return parent is ViewGroup && parentMatcher.matches(parent)
                        && view == parent.getChildAt(position)
            }
        }
    }
}
