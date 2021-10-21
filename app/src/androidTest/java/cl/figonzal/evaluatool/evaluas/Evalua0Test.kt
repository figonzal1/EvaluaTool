/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2021

 Last modified 10/20/21, 5:57 PM
 */

package cl.figonzal.evaluatool.evaluas

import android.content.Context
import android.view.View
import android.view.ViewGroup
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.scrollTo
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import androidx.test.platform.app.InstrumentationRegistry
import cl.figonzal.evaluatool.R
import cl.figonzal.evaluatool.activities.MainActivity
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.Matchers.`is`
import org.hamcrest.Matchers.allOf
import org.hamcrest.TypeSafeMatcher
import org.junit.Before
import org.junit.FixMethodOrder
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.MethodSorters


@LargeTest
@RunWith(AndroidJUnit4::class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
class Evalua0Test {

    private lateinit var mContext: Context

    @Rule
    @JvmField
    var mActivityTestRule: ActivityScenarioRule<MainActivity> =
        ActivityScenarioRule(MainActivity::class.java)

    @Before
    fun start() {
        mContext = InstrumentationRegistry.getInstrumentation().targetContext
    }

    @Test
    fun test1_click_and_check_headers() {
        // Added a sleep statement to match the app's execution delay.
        // The recommended way to handle such scenarios is to use Espresso idling resources:
        // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
        Thread.sleep(7000)

        clickEvalua0Btn()
        checkHeaders()

        try {
            Thread.sleep(2000)
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }
    }

    @Test
    fun test2_click_and_click_headers() {
        // Added a sleep statement to match the app's execution delay.
        // The recommended way to handle such scenarios is to use Espresso idling resources:
        // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
        Thread.sleep(7000)

        clickEvalua0Btn()

        performAction("click", mContext.getString(R.string.EVALUA_0_MODULO_3), 2)
        checkChildsCapLinguisticas()
        performAction("click", mContext.getString(R.string.EVALUA_0_MODULO_3), 2)

        performAction("click", mContext.getString(R.string.EVALUA_0_MODULO_2), 1)
        checkChildsCapEspeciales()
        performAction("click", mContext.getString(R.string.EVALUA_0_MODULO_2), 1)

        performAction("click", mContext.getString(R.string.EVALUA_0_MODULO_1), 0)
        checkChildsCapCognitivas()
        performAction("click", mContext.getString(R.string.EVALUA_0_MODULO_1), 0)

        try {
            Thread.sleep(2000)
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }

    }

    private fun checkChildsCapCognitivas() {
        checkChildsItem(mContext.getString(R.string.EVALUA_0_M1_SI_1))
        checkChildsItem(mContext.getString(R.string.EVALUA_0_M1_SI_2))
        checkChildsItem(mContext.getString(R.string.EVALUA_0_M1_SI_3))
        checkChildsItem(mContext.getString(R.string.EVALUA_0_M1_SI_4))
        checkChildsItem(mContext.getString(R.string.EVALUA_0_M1_SI_5))
        checkChildsItem(mContext.getString(R.string.EVALUA_0_M1_SI_6))
    }

    private fun checkChildsCapEspeciales() {
        checkChildsItem(mContext.getString(R.string.EVALUA_0_M2_SI_1))
        checkChildsItem(mContext.getString(R.string.EVALUA_0_M2_SI_2))
        checkChildsItem(mContext.getString(R.string.EVALUA_0_M2_SI_3))
    }


    private fun checkChildsCapLinguisticas() {
        checkChildsItem(mContext.getString(R.string.EVALUA_0_M3_SI_1))
        checkChildsItem(mContext.getString(R.string.EVALUA_0_M3_SI_2))
        checkChildsItem(mContext.getString(R.string.EVALUA_0_M3_SI_3))
        checkChildsItem(mContext.getString(R.string.EVALUA_0_M3_SI_4))
    }

    private fun checkHeaders() {
        val textView = onView(
            allOf(
                withId(R.id.tv_group), withText(mContext.getString(R.string.EVALUA_0_MODULO_1)),
                withParent(
                    allOf(
                        withId(R.id.cl_header),
                        withParent(withId(R.id.rv_0))
                    )
                ),
                isDisplayed()
            )
        )
        textView.check(ViewAssertions.matches(withText(mContext.getString(R.string.EVALUA_0_MODULO_1))))

        val textView2 = onView(
            allOf(
                withId(R.id.tv_group), withText(mContext.getString(R.string.EVALUA_0_MODULO_2)),
                withParent(
                    allOf(
                        withId(R.id.cl_header),
                        withParent(withId(R.id.rv_0))
                    )
                ),
                isDisplayed()
            )
        )
        textView2.check(ViewAssertions.matches(withText(mContext.getString(R.string.EVALUA_0_MODULO_2))))

        val textView3 = onView(
            allOf(
                withId(R.id.tv_group), withText(mContext.getString(R.string.EVALUA_0_MODULO_3)),
                withParent(
                    allOf(
                        withId(R.id.cl_header),
                        withParent(withId(R.id.rv_0))
                    )
                ),
                isDisplayed()
            )
        )
        textView3.check(ViewAssertions.matches(withText(mContext.getString(R.string.EVALUA_0_MODULO_3))))
    }

    private fun checkChildsItem(nombre: String) {
        val textView3 = onView(
            allOf(
                withId(R.id.tv_child), withText(nombre),
                withParent(
                    allOf(
                        withId(R.id.cl_child),
                        withParent(withId(R.id.rv_child_item))
                    )
                ),
                isDisplayed()
            )
        )
        textView3.check(ViewAssertions.matches(withText(nombre)))
    }

    private fun clickEvalua0Btn() {
        val materialButton = onView(
            allOf(
                withId(R.id.btn_evalua_0), withText(mContext.getString(R.string.TOOLBAR_EVALUA_0)),
                childAtPosition(
                    childAtPosition(
                        withClassName(`is`("android.widget.ScrollView")),
                        0
                    ),
                    4
                )
            )
        )
        materialButton.perform(scrollTo(), click())
    }

    private fun performAction(typeAction: String, itemName: String, positionList: Int) {

        try {
            Thread.sleep(2000)
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }

        val textView = onView(
            allOf(
                withId(R.id.tv_group), withText(itemName),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.rv_0),
                        positionList
                    ),
                    0
                ),
                isDisplayed()
            )
        )

        when (typeAction) {
            "check" -> textView.check(ViewAssertions.matches(withText(itemName)))
            "click" -> textView.perform(click())
        }


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
