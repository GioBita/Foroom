package com.example.foroom.Helper

import android.view.View
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.closeSoftKeyboard
import androidx.test.espresso.action.ViewActions.replaceText
import org.hamcrest.Matcher

fun typeInto(field: Matcher<View>, text: String) =
    onView(field).perform(replaceText(text), closeSoftKeyboard())