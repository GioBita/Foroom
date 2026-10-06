package com.example.foroom.pages

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.closeSoftKeyboard
import androidx.test.espresso.action.ViewActions.replaceText
import androidx.test.espresso.matcher.ViewMatchers.isDescendantOfA
import androidx.test.espresso.matcher.ViewMatchers.withId
import org.hamcrest.Matchers.allOf
import com.example.design_system.R as DS

fun child(parent: Int, child: Int) = onView(allOf(withId(child), isDescendantOfA(withId(parent))))
fun type(parent: Int, text: String) =
    child(parent, DS.id.inputEditText).perform(replaceText(text), closeSoftKeyboard())