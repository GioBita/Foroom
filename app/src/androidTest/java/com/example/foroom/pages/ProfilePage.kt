package com.example.foroom.pages

import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import com.alternator.foroom.R

class ProfilePage {
    val navBar = withId(R.id.navBar)
    val profileTab = withId(R.id.homeNavigationProfile)
    val changePasswordItem = withId(R.id.changePasswordItem)
    val changeLanguageItem = withId(R.id.changeLanguageItem)
    val signOutItem = withId(R.id.signOutItem)
    fun text(t: String) = withText(t)
}