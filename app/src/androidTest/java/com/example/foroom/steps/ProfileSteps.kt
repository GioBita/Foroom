package com.example.foroom.steps

import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import com.example.foroom.Helper.waitUntil
import com.example.foroom.pages.*

class ProfileSteps(
    private val profile: ProfilePage = ProfilePage(),
    private val password: ChangePasswordPage = ChangePasswordPage(),
    private val language: ChangeLanguagePage = ChangeLanguagePage(),
) {
    fun homeShown() = waitUntil { profile.navBar().check(matches(isDisplayed())) }
    fun changePassword(new: String) {
        profile.openProfile()
        profile.changePassword()
        password.typePassword(new)
        password.typeRepeat(new)
        password.confirm()
    }

    fun setLanguage(geo: Boolean) {
        profile.changeLanguage()
        if (geo) language.georgian() else language.english()
    }

    fun openProfile() = profile.openProfile()
    fun labelShown(t: String) = waitUntil { profile.text(t).check(matches(isDisplayed())) }

    fun signOut() { profile.openProfile(); profile.signOut() }
}