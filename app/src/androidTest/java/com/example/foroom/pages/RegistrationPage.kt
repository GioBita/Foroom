package com.example.foroom.pages

import androidx.test.espresso.matcher.ViewMatchers.isDescendantOfA
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withParent
import androidx.test.espresso.matcher.ViewMatchers.withParentIndex
import com.alternator.foroom.R
import org.hamcrest.Matchers.allOf
import com.example.design_system.R as DS

class RegistrationPage {
    val screenMarker = withId(R.id.repeatPasswordInput)
    val userNameInput = allOf(withId(DS.id.inputEditText), isDescendantOfA(withId(R.id.userNameInput)))
    val passwordInput = allOf(withId(DS.id.inputEditText), isDescendantOfA(withId(R.id.passwordInput)))
    val repeatPasswordInput = allOf(withId(DS.id.inputEditText), isDescendantOfA(withId(R.id.repeatPasswordInput)))
    val signUpButton = withId(R.id.signUpButton)
    fun avatar(pos: Int) = allOf(withParent(withId(R.id.listView)), withParentIndex(pos))
}