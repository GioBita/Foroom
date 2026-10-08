package com.example.foroom.pages

import androidx.test.espresso.matcher.ViewMatchers.isDescendantOfA
import androidx.test.espresso.matcher.ViewMatchers.withId
import com.alternator.foroom.R
import org.hamcrest.Matchers.allOf
import com.example.design_system.R as DS

class LoginPage {
    val userNameInput = allOf(withId(DS.id.inputEditText), isDescendantOfA(withId(R.id.userNameInput)))
    val passwordInput = allOf(withId(DS.id.inputEditText), isDescendantOfA(withId(R.id.passwordInput)))
    val logInButton = withId(R.id.logInButton)
    val signUpButton = withId(R.id.signUpButton)
}