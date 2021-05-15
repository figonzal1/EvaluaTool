/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2021

 Last modified 14-05-21 23:19
 */

package cl.figonzal.evaluatool.evaluas

import android.content.Context
import android.view.View
import android.view.ViewGroup
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import androidx.test.platform.app.InstrumentationRegistry
import cl.figonzal.evaluatool.MainActivity
import cl.figonzal.evaluatool.R
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.Matchers
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
class Evalua6Test {

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
    fun test1_click_and_check_items() {
        // Added a sleep statement to match the app's execution delay.
        // The recommended way to handle such scenarios is to use Espresso idling resources:
        // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
        try {
            Thread.sleep(7000)
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }

        clickEvalua6Btn()

        performAction("check", mContext.getString(R.string.EVALUA_6_MODULO_1), 0)
        performAction("check", mContext.getString(R.string.EVALUA_6_MODULO_2), 1)
        performAction("check", mContext.getString(R.string.EVALUA_6_MODULO_3), 2)
        performAction("check", mContext.getString(R.string.EVALUA_6_MODULO_4), 3)
        performAction("check", mContext.getString(R.string.EVALUA_6_MODULO_5), 4)
        performAction("check", mContext.getString(R.string.EVALUA_6_MODULO_6), 5)

        try {
            Thread.sleep(2000)
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }
    }

    @Test
    fun test2_click_and_click_items() {
        try {
            Thread.sleep(7000)
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }

        clickEvalua6Btn()

        performAction("click", mContext.getString(R.string.EVALUA_6_MODULO_6), 5)
        checkSubItemsAprendizajesMatematico()
        performAction("click", mContext.getString(R.string.EVALUA_6_MODULO_6), 5)

        performAction("click", mContext.getString(R.string.EVALUA_6_MODULO_5), 4)
        checkSubItemsEscritura()
        performAction("click", mContext.getString(R.string.EVALUA_6_MODULO_5), 4)

        performAction("click", mContext.getString(R.string.EVALUA_6_MODULO_4), 3)
        checkSubItemsLectura()
        performAction("click", mContext.getString(R.string.EVALUA_6_MODULO_4), 3)

        performAction("click", mContext.getString(R.string.EVALUA_6_MODULO_3), 2)
        checkSubItemsNivelesAdaptacion()
        performAction("click", mContext.getString(R.string.EVALUA_6_MODULO_3), 2)

        performAction("click", mContext.getString(R.string.EVALUA_6_MODULO_2), 1)
        checkSubItemsMemoriaAtencion()
        performAction("click", mContext.getString(R.string.EVALUA_6_MODULO_2), 1)

        performAction("click", mContext.getString(R.string.EVALUA_6_MODULO_1), 0)
        checkSubItemsBasesRazonamiento()
        performAction("click", mContext.getString(R.string.EVALUA_6_MODULO_1), 0)

        try {
            Thread.sleep(2000)
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }

    }

    private fun checkSubItemsAprendizajesMatematico() {
        try {
            Thread.sleep(2000)
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }
        checkSubItem(mContext.getString(R.string.EVALUA_6_M6_SI_1))
        checkSubItem(mContext.getString(R.string.EVALUA_6_M6_SI_2))
        checkSubItem(mContext.getString(R.string.EVALUA_6_VALORACION_GLOBAL_MATEMATICAS))
        checkSubItem(mContext.getString(R.string.EVALUA_6_INDICE_GENERAL_MATEMATICAS))
    }

    private fun checkSubItemsEscritura() {
        try {
            Thread.sleep(2000)
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }
        checkSubItem(mContext.getString(R.string.EVALUA_6_M5_SI_1))
        checkSubItem(mContext.getString(R.string.EVALUA_6_INDICE_GENERAL_ESCRITURA))
    }

    private fun checkSubItemsLectura() {
        try {
            Thread.sleep(2000)
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }
        checkSubItem(mContext.getString(R.string.EVALUA_6_M4_SI_1))
        checkSubItem(mContext.getString(R.string.EVALUA_6_M4_SI_2))
        checkSubItem(mContext.getString(R.string.EVALUA_6_VALORACION_GLOBAL_LECTURA))
        checkSubItem(mContext.getString(R.string.EVALUA_6_INDICE_GENERAL_LECTURA))
    }

    private fun checkSubItemsNivelesAdaptacion() {
        try {
            Thread.sleep(2000)
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }
        checkSubItem(mContext.getString(R.string.EVALUA_6_M3_SI_1))
    }

    private fun checkSubItemsMemoriaAtencion() {
        try {
            Thread.sleep(2000)
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }
        checkSubItem(mContext.getString(R.string.EVALUA_6_M2_SI_1))
    }

    private fun checkSubItemsBasesRazonamiento() {
        try {
            Thread.sleep(2000)
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }
        checkSubItem(mContext.getString(R.string.EVALUA_6_M1_SI_1))
        checkSubItem(mContext.getString(R.string.EVALUA_6_M1_SI_2))
        checkSubItem(mContext.getString(R.string.EVALUA_6_M1_SI_3))
        checkSubItem(mContext.getString(R.string.EVALUA_6_VALORACION_GLOBAL_RAZONAMIENTO))
        checkSubItem(mContext.getString(R.string.EVALUA_6_INDICE_GENERAL_COGNITIVO))
    }


    private fun checkSubItem(nombreSubItem: String) {
        Espresso.onView(
            Matchers.allOf(
                ViewMatchers.withId(R.id.tv_child), ViewMatchers.withText(nombreSubItem),
                ViewMatchers.withParent(ViewMatchers.withParent(ViewMatchers.withId(R.id.rv_6))),
                ViewMatchers.isDisplayed()
            )
        ).check(ViewAssertions.matches(ViewMatchers.withText(nombreSubItem)))
    }

    private fun performAction(typeAction: String, itemName: String, positionList: Int) {

        try {
            Thread.sleep(4000)
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }

        val textView = Espresso.onView(
            Matchers.allOf(
                ViewMatchers.withId(R.id.tv_group), ViewMatchers.withText(itemName),
                childAtPosition(
                    childAtPosition(
                        ViewMatchers.withId(R.id.rv_6),
                        positionList
                    ),
                    0
                ),
                ViewMatchers.isDisplayed()
            )
        )

        when (typeAction) {
            "check" -> textView.check(ViewAssertions.matches(ViewMatchers.withText(itemName)))
            "click" -> textView.perform(ViewActions.click())
        }
    }

    private fun clickEvalua6Btn() {
        val materialButton = Espresso.onView(
            Matchers.allOf(
                ViewMatchers.withId(R.id.btn_evalua_6),
                ViewMatchers.withText(mContext.getString(R.string.TOOLBAR_EVALUA_6)),
                childAtPosition(
                    childAtPosition(
                        ViewMatchers.withClassName(Matchers.`is`("android.widget.ScrollView")),
                        0
                    ),
                    10
                )
            )
        )
        materialButton.perform(ViewActions.scrollTo(), ViewActions.click())
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