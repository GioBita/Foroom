package com.example.foroom.steps

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import com.example.foroom.Helper.waitUntil
import com.example.foroom.pages.*

class ProfileSteps(
    private val profile: ProfilePage = ProfilePage(),

) {
    fun homeShown() = apply { waitUntil { onView(profile.navBar).check(matches(isDisplayed())) } }
    fun openProfile() = apply { onView(profile.profileTab).perform(click()) }
    fun tapSignOut() = apply { onView(profile.signOutItem).perform(click()) }
    fun signOut() = openProfile().tapSignOut()
}