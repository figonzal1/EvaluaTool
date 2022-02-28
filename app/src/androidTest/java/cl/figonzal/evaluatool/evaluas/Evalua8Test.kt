/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2022

 Last modified 26/2/22 23:01
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
import cl.figonzal.evaluatool.ui.MainActivity
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
class Evalua8Test {

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

        clickEvalua8Btn()
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

        clickEvalua8Btn()

        performAction("click", mContext.getString(R.string.EVALUA_8_MODULO_6), 5)
        checkSubItemsAprendizajesMatematico()
        performAction("click", mContext.getString(R.string.EVALUA_8_MODULO_6), 5)

        performAction("click", mContext.getString(R.string.EVALUA_8_MODULO_5), 4)
        checkSubItemsEscritura()
        performAction("click", mContext.getString(R.string.EVALUA_8_MODULO_5), 4)

        performAction("click", mContext.getString(R.string.EVALUA_8_MODULO_4), 3)
        checkSubItemsLectura()
        performAction("click", mContext.getString(R.string.EVALUA_8_MODULO_4), 3)

        performAction("click", mContext.getString(R.string.EVALUA_8_MODULO_3), 2)
        checkSubItemsNivelesAdaptacion()
        performAction("click", mContext.getString(R.string.EVALUA_8_MODULO_3), 2)

        performAction("click", mContext.getString(R.string.EVALUA_8_MODULO_2), 1)
        checkSubItemsBasesRazonamiento()
        performAction("click", mContext.getString(R.string.EVALUA_8_MODULO_2), 1)

        performAction("click", mContext.getString(R.string.EVALUA_8_MODULO_1), 0)
        checkSubItemsAtencionConcentracion()
        performAction("click", mContext.getString(R.string.EVALUA_8_MODULO_1), 0)

        try {
            Thread.sleep(2000)
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }

    }

    private fun checkSubItemsAprendizajesMatematico() {
        checkChildsItem(mContext.getString(R.string.EVALUA_8_M6_SI_1))
        checkChildsItem(mContext.getString(R.string.EVALUA_8_M6_SI_2))
        checkChildsItem(mContext.getString(R.string.EVALUA_8_VALORACION_GLOBAL_MATEMATICAS))
        checkChildsItem(mContext.getString(R.string.EVALUA_8_INDICE_GENERAL_MATEMATICAS))
    }

    private fun checkSubItemsEscritura() {
        checkChildsItem(mContext.getString(R.string.EVALUA_8_M5_SI_1))
        checkChildsItem(mContext.getString(R.string.EVALUA_8_INDICE_GENERAL_ESCRITURA))
    }

    private fun checkSubItemsLectura() {
        checkChildsItem(mContext.getString(R.string.EVALUA_8_M4_SI_1))
        checkChildsItem(mContext.getString(R.string.EVALUA_8_M4_SI_2))
        checkChildsItem(mContext.getString(R.string.EVALUA_8_M4_SI_3))
        checkChildsItem(mContext.getString(R.string.EVALUA_8_INDICE_GENERAL_LECTURA))
    }

    private fun checkSubItemsNivelesAdaptacion() {
        checkChildsItem(mContext.getString(R.string.EVALUA_8_M3_SI_1))
    }

    private fun checkSubItemsBasesRazonamiento() {
        checkChildsItem(mContext.getString(R.string.EVALUA_8_M2_SI_1))
        checkChildsItem(mContext.getString(R.string.EVALUA_8_M2_SI_2))
        checkChildsItem(mContext.getString(R.string.EVALUA_8_M2_SI_3))
        checkChildsItem(mContext.getString(R.string.EVALUA_8_VALORACION_GLOBAL_RAZONAMIENTO))
        checkChildsItem(mContext.getString(R.string.EVALUA_8_INDICE_GENERAL_COGNITIVO))

    }


    private fun checkSubItemsAtencionConcentracion() {
        checkChildsItem(mContext.getString(R.string.EVALUA_8_M1_SI_1))
    }

    private fun checkHeaders() {
        val textView = onView(
            allOf(
                withId(R.id.tv_group), withText(mContext.getString(R.string.EVALUA_8_MODULO_1)),
                withParent(
                    allOf(
                        withId(R.id.cl_header),
                        withParent(withId(R.id.rv_8))
                    )
                ),
                isDisplayed()
            )
        )
        textView.check(ViewAssertions.matches(withText(mContext.getString(R.string.EVALUA_8_MODULO_1))))

        val textView2 = onView(
            allOf(
                withId(R.id.tv_group), withText(mContext.getString(R.string.EVALUA_8_MODULO_2)),
                withParent(
                    allOf(
                        withId(R.id.cl_header),
                        withParent(withId(R.id.rv_8))
                    )
                ),
                isDisplayed()
            )
        )
        textView2.check(ViewAssertions.matches(withText(mContext.getString(R.string.EVALUA_8_MODULO_2))))

        val textView3 = onView(
            allOf(
                withId(R.id.tv_group), withText(mContext.getString(R.string.EVALUA_8_MODULO_3)),
                withParent(
                    allOf(
                        withId(R.id.cl_header),
                        withParent(withId(R.id.rv_8))
                    )
                ),
                isDisplayed()
            )
        )
        textView3.check(ViewAssertions.matches(withText(mContext.getString(R.string.EVALUA_8_MODULO_3))))

        val textView4 = onView(
            allOf(
                withId(R.id.tv_group), withText(mContext.getString(R.string.EVALUA_8_MODULO_4)),
                withParent(
                    allOf(
                        withId(R.id.cl_header),
                        withParent(withId(R.id.rv_8))
                    )
                ),
                isDisplayed()
            )
        )
        textView4.check(ViewAssertions.matches(withText(mContext.getString(R.string.EVALUA_8_MODULO_4))))

        val textView5 = onView(
            allOf(
                withId(R.id.tv_group), withText(mContext.getString(R.string.EVALUA_8_MODULO_5)),
                withParent(
                    allOf(
                        withId(R.id.cl_header),
                        withParent(withId(R.id.rv_8))
                    )
                ),
                isDisplayed()
            )
        )
        textView5.check(ViewAssertions.matches(withText(mContext.getString(R.string.EVALUA_8_MODULO_5))))

        val textView6 = onView(
            allOf(
                withId(R.id.tv_group), withText(mContext.getString(R.string.EVALUA_8_MODULO_6)),
                withParent(
                    allOf(
                        withId(R.id.cl_header),
                        withParent(withId(R.id.rv_8))
                    )
                ),
                isDisplayed()
            )
        )
        textView6.check(ViewAssertions.matches(withText(mContext.getString(R.string.EVALUA_8_MODULO_6))))
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

    private fun clickEvalua8Btn() {
        val materialButton = onView(
            allOf(
                withId(R.id.btn_evalua_8), withText(mContext.getString(R.string.TOOLBAR_EVALUA_8)),
                childAtPosition(
                    childAtPosition(
                        withClassName(`is`("android.widget.ScrollView")),
                        0
                    ),
                    15
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
                        withId(R.id.rv_8),
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
