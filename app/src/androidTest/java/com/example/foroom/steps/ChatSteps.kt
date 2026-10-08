package com.example.foroom.steps

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import com.example.foroom.Helper.typeInto
import com.example.foroom.Helper.waitUntil
import com.example.foroom.pages.*

class ChatSteps(
    private val create: CreateChatPage = CreateChatPage(),
    private val chats: ChatsPage = ChatsPage(),
) {
    fun openCreateChat() = apply { onView(create.openButton).perform(click()) }
    fun typeChatName(v: String) = apply { typeInto(create.nameInput, v) }
    fun chooseImage() = apply { onView(create.imageChooser).perform(click()) }
    fun tapCreate() = apply { onView(create.createButton).perform(click()) }
    fun chatOpened(name: String) = apply { waitUntil { onView(create.title(name)).check(matches(isDisplayed())) } }
    fun closeChat() = apply { onView(create.closeButton).perform(click()) }
    fun searchChat(name: String) = apply { typeInto(chats.searchInput, name) }
    fun chatInList(name: String) = apply { waitUntil { onView(chats.chatCard(name)).check(matches(isDisplayed())) } }
    fun tapOpenChat(name: String) = apply { onView(chats.openChatButton(name)).perform(click()) }

    fun createChat(name: String) = openCreateChat().typeChatName(name).chooseImage().tapCreate()
    fun findInList(name: String) = searchChat(name).chatInList(name)
    fun openChat(name: String) = findInList(name).tapOpenChat(name).chatOpened(name)
}