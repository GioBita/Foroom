package com.example.foroom.pages

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers.withId
import com.alternator.foroom.R

class ChangeLanguagePage {
    fun georgian() = onView(withId(R.id.languageButtonGeo)).perform(click())
    fun english() = onView(withId(R.id.languageButtonEng)).perform(click())
}