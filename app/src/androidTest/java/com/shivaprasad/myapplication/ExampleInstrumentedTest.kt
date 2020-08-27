package com.shivaprasad.myapplication

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.rule.ActivityTestRule
import com.shivaprasad.myapplication.ui.home.HomeActivity
import com.shivaprasad.myapplication.ui.home.HomeAdapter
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import javax.net.ssl.ExtendedSSLSession

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {

    @Rule
    @JvmField
    var mActivityRule = ActivityTestRule(HomeActivity::class.java)

    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.shivaprasad.myapplication", appContext.packageName)
    }

    @Test
    fun homeScreenTest(){
        //textfilter
        onView(withId(R.id.search_icon)).perform(click())
        onView(withId(R.id.search_icon)).perform(click())
    }


    @Test
    fun homeListview(){
        //recycleTest
        onView(withId(R.id.listrecycleview)).perform(swipeUp())
        onView(withId(R.id.listrecycleview)).perform(swipeUp())
        onView(withId(R.id.listrecycleview)).perform(swipeDown())
        onView(withId(R.id.listrecycleview)).perform(RecyclerViewActions.actionOnItemAtPosition<HomeAdapter.GenericViewModel>(0, click()))
    }

    @Test
    fun  cartclick(){
        //cart
        onView(withId(R.id.cart)).perform(ViewActions.click())
    }

}
