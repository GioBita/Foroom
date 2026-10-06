package com.example.foroom.steps

import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import com.example.foroom.Helper.waitUntil
import com.example.foroom.pages.*

class ChatSteps(
    private val create: CreateChatPage = CreateChatPage(),
    private val chats: ChatsPage = ChatsPage(),
) {
    fun createChat(name: String) {
        create.open()
        create.typeName(name)
        create.chooseImage()
        create.create()
    }

    fun chatOpened(name: String) = waitUntil { create.title(name).check(matches(isDisplayed())) }
    fun closeChat() = create.close()

    fun findInList(name: String) {
        chats.search(name)
        waitUntil { chats.chatCard(name).check(matches(isDisplayed())) }
    }
}