package com.example.foroom.steps

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import com.example.foroom.Helper.swipeUntilVisible
import com.example.foroom.Helper.typeInto
import com.example.foroom.Helper.waitUntil
import com.example.foroom.data.Constants.MAX_SWIPES
import com.example.foroom.pages.ConversationPage

class ConversationSteps(private val page: ConversationPage = ConversationPage()) {
    fun typeMessage(text: String) = apply { waitUntil { typeInto(page.messageInput, text) } }
    fun tapSend() = apply { waitUntil { onView(page.sendButton).perform(click()) } }
    fun assertMessageDisplayed(text: String) =
        apply { waitUntil { onView(page.message(text)).check(matches(isDisplayed())) } }

    fun assertMessageFromSender(text: String, user: String) =
        apply { waitUntil { onView(page.messageFrom(text, user)).check(matches(isDisplayed())) } }

    fun send(text: String) = typeMessage(text).tapSend()

    fun scrollToMessage(text: String) = apply {
        swipeUntilVisible(
            { onView(page.messageList) },
            { onView(page.message(text)).check(matches(isDisplayed())) },
            MAX_SWIPES
        )
    }
}
