package com.example.foroom.pages

import androidx.test.espresso.matcher.ViewMatchers.isDescendantOfA
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import com.alternator.foroom.R
import org.hamcrest.Matchers.allOf
import com.example.design_system.R as DS

class CreateChatPage {
    val openButton = withId(R.id.homeNavigationCreateChat)
    val nameInput = allOf(withId(DS.id.inputEditText), isDescendantOfA(withId(R.id.chatNameInput)))
    val imageChooser = withId(R.id.chatImageChooser)
    val createButton = withId(R.id.createChatButton)
    val closeButton = withId(R.id.closeButton)
    fun title(name: String) = allOf(withId(DS.id.chatNameTextView), withText(name))
}