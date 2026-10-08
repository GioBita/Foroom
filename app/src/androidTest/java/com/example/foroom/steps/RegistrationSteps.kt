package com.example.foroom.steps

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import com.example.foroom.Helper.typeInto
import com.example.foroom.Helper.waitUntil
import com.example.foroom.data.Constants.AVATAR_POSITION
import com.example.foroom.data.Constants.HOME_TIMEOUT_MS
import com.example.foroom.pages.HomePage
import com.example.foroom.pages.RegistrationPage

class RegistrationSteps(
    private val login: LoginSteps = LoginSteps(),
    private val page: RegistrationPage = RegistrationPage(),
    private val home: HomePage = HomePage()
) {
    fun registrationScreenShown() = apply { waitUntil { onView(page.screenMarker).check(matches(isDisplayed())) } }
    fun typeUserName(v: String) = apply { typeInto(page.userNameInput, v) }
    fun typePassword(v: String) = apply { typeInto(page.passwordInput, v) }
    fun typeRepeat(v: String) = apply { typeInto(page.repeatPasswordInput, v) }
    fun chooseAvatar() = apply { waitUntil { onView(page.avatar(AVATAR_POSITION)).perform(click()) } }
    fun tapSignUp() = apply { onView(page.signUpButton).perform(click()) }
    fun homeShown() = apply { waitUntil(HOME_TIMEOUT_MS) { onView(home.navBar).check(matches(isDisplayed())) } }

    fun openRegistration() = apply { login.tapSignUp(); registrationScreenShown() }
    fun register(user: String, pass: String) =
        typeUserName(user).typePassword(pass).typeRepeat(pass).chooseAvatar().tapSignUp()
}