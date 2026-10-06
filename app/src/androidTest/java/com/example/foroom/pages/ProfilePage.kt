package com.example.foroom.pages

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import com.alternator.foroom.R

class ProfilePage {
    fun openProfile() = onView(withId(R.id.homeNavigationProfile)).perform(click())
    fun changePassword() = onView(withId(R.id.changePasswordItem)).perform(click())
    fun changeLanguage() = onView(withId(R.id.changeLanguageItem)).perform(click())
    fun text(t: String) = onView(withText(t))

    fun signOut() = onView(withId(R.id.signOutItem)).perform(click())
    fun navBar() = onView(withId(R.id.navBar))
}