package com.example.foroom.pages

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers.withId
import com.alternator.foroom.R

class ChangePasswordPage {
    fun typePassword(v: String) = type(R.id.passwordInput, v)
    fun typeRepeat(v: String) = type(R.id.repeatPasswordInput, v)
    fun confirm() = onView(withId(com.example.design_system.R.id.actionButton)).perform(click())
}