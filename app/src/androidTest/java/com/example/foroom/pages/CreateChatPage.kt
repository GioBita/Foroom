package com.example.foroom.pages

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import com.alternator.foroom.R

class CreateChatPage {
    fun open() = onView(withId(R.id.homeNavigationCreateChat)).perform(click())
    fun typeName(v: String) = type(R.id.chatNameInput, v)
    fun chooseImage() = onView(withId(R.id.chatImageChooser)).perform(click())
    fun create() = onView(withId(R.id.createChatButton)).perform(click())
    fun close() = onView(withId(R.id.closeButton)).perform(click())
    fun title(name: String) = onView(withText(name))
}