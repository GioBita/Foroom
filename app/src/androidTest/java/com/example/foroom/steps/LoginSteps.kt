package com.example.foroom.steps

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import com.example.foroom.Helper.typeInto
import com.example.foroom.Helper.waitUntil
import com.example.foroom.pages.LoginPage

class LoginSteps(private val page: LoginPage = LoginPage()) {
    fun loginScreenShown() = apply { waitUntil { onView(page.logInButton).check(matches(isDisplayed())) } }
    fun typeUserName(v: String) = apply { typeInto(page.userNameInput, v) }
    fun typePassword(v: String) = apply { typeInto(page.passwordInput, v) }
    fun tapLogIn() = apply { onView(page.logInButton).perform(click()) }
    fun tapSignUp() = apply { onView(page.signUpButton).perform(click()) }

    fun login(user: String, pass: String) = typeUserName(user).typePassword(pass).tapLogIn()
}