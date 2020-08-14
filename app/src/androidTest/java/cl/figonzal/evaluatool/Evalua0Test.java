/*-----------------------------------------------------------------------------
                                                                              -
 This file is subject to the terms and conditions defined in                  -
 file 'LICENSE', which is part of this source code package                    -
                                                                              -
 Autor: Felipe González                                                       -
 Email: felipe.gonzalezalarcon94@gmail.com                                    -
                                                                              -
 Copyright (c) 2020                                                           -
                                                                              -
 Last modified 14-08-20 0:53                                                  -
 -----------------------------------------------------------------------------*/

package cl.figonzal.evaluatool;


import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import androidx.test.espresso.ViewInteraction;
import androidx.test.filters.LargeTest;
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner;
import androidx.test.rule.ActivityTestRule;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import cl.figonzal.evaluatool.evalua.evalua0.Evalua0Activity;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

@LargeTest
@RunWith(AndroidJUnit4ClassRunner.class)
public class Evalua0Test {

    @Rule
    public ActivityTestRule<Evalua0Activity> mActivityTestRule = new ActivityTestRule<>(Evalua0Activity.class);

    private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }

    @Test
    public void evalua0Test() {

        // Added a sleep statement to match the app's execution delay.
        // The recommended way to handle such scenarios is to use Espresso idling resources:
        // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ViewInteraction textView2 = onView(
                allOf(withId(R.id.tv_group), withText("Capacidades Cognitivas"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.recyclerview),
                                        0),
                                0),
                        isDisplayed()));
        textView2.check(matches(withText("Capacidades Cognitivas")));

        ViewInteraction textView3 = onView(
                allOf(withId(R.id.tv_group), withText("Capacidades Espaciales"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.recyclerview),
                                        1),
                                0),
                        isDisplayed()));
        textView3.check(matches(withText("Capacidades Espaciales")));

        ViewInteraction textView4 = onView(
                allOf(withId(R.id.tv_group), withText("Capacidades Linguísticas"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.recyclerview),
                                        2),
                                0),
                        isDisplayed()));
        textView4.check(matches(withText("Capacidades Linguísticas")));

        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        textView4.perform(click());
    }
}
