package com.example.foroom.pages

import androidx.test.espresso.matcher.ViewMatchers.hasDescendant
import androidx.test.espresso.matcher.ViewMatchers.isDescendantOfA
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import com.alternator.foroom.R
import org.hamcrest.Matchers.allOf
import com.example.design_system.R as DS

class ChatsPage {
    val searchInput = allOf(withId(DS.id.inputEditText), isDescendantOfA(withId(R.id.searchChatInput)))
    fun chatCard(name: String) = allOf(withText(name), isDescendantOfA(withId(R.id.chatsRecyclerView)))
    fun openChatButton(name: String) = allOf(
        withId(R.id.sendMessageButton),
        isDescendantOfA(
            allOf(
                hasDescendant(allOf(withId(DS.id.chatTitleTextView), withText(name))),
                isDescendantOfA(withId(R.id.chatsRecyclerView))
            )
        )
    )
}