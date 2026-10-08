package com.example.foroom.pages

import androidx.test.espresso.matcher.ViewMatchers.hasDescendant
import androidx.test.espresso.matcher.ViewMatchers.isDescendantOfA
import androidx.test.espresso.matcher.ViewMatchers.withClassName
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withResourceName
import androidx.test.espresso.matcher.ViewMatchers.withText
import com.alternator.foroom.R
import org.hamcrest.Matchers.allOf
import org.hamcrest.Matchers.endsWith
import com.example.design_system.R as DS

class ConversationPage {
    val messageList = withId(R.id.messagesRecyclerView)
    val messageInput = allOf(withId(DS.id.inputEditText), isDescendantOfA(withId(R.id.messageInput)))
    val sendButton = allOf(withId(R.id.sendMessageButton), isDescendantOfA(withId(R.id.messageInput)))
    fun message(text: String) = allOf(withText(text), isDescendantOfA(messageList))
    fun messageFrom(text: String, user: String) = allOf(
        withClassName(endsWith("ForoomMessageView")),
        isDescendantOfA(messageList),
        hasDescendant(allOf(withResourceName("messageTextView"), withText(text))),
        hasDescendant(allOf(withResourceName("userNameTextView"), withText(user)))
    )
}