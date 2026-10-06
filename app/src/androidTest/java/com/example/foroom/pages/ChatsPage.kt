package com.example.foroom.pages

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.matcher.ViewMatchers.isDescendantOfA
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import com.alternator.foroom.R
import org.hamcrest.Matchers.allOf

class ChatsPage {
    fun search(v: String) = type(R.id.searchChatInput, v)
    fun chatCard(name: String) =
        onView(allOf(withText(name), isDescendantOfA(withId(R.id.chatsRecyclerView))))
}