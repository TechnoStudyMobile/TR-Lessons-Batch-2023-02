package com.betulnecanli.weatherapp.ui

import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import dagger.hilt.android.testing.HiltAndroidRule
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import com.betulnecanli.weatherapp.R
import com.betulnecanli.weatherapp.ui.detail.DetailFragment
import org.junit.runner.RunWith

import androidx.fragment.app.testing.launchFragmentInContainer

import androidx.test.espresso.matcher.ViewMatchers.withText


@RunWith(AndroidJUnit4::class)
class DetailFragmentTest {

    @Test
    fun test_isDetailInfoVisible_onAppLaunch() {
        // Create a mock Bundle to hold the fragment arguments
        val fakeArgs = Bundle().apply {
            putString("time", "10:00")
            putFloat("maxTemp", 30.0f)
            putFloat("minTemp", 20.0f)
        }

        // Use launchFragmentInContainer to create and launch the fragment
        launchFragmentInContainer<DetailFragment>(fakeArgs, R.style.Theme_WeatherApp)

        onView(withId(R.id.tvTime))
            .check(matches(isDisplayed()))
            .check(matches(withText("10:00")))

        onView(withId(R.id.tvMaxTemp))
            .check(matches(isDisplayed()))
            .check(matches(withText("30.0")))

        onView(withId(R.id.tvMinTemp))
            .check(matches(isDisplayed()))
            .check(matches(withText("20.0")))
    }
}

