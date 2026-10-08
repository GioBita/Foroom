package com.example.foroom.tests

import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.foroom.Helper.uniqueSuffix
import com.example.foroom.data.Constants.CHAT_NAME
import com.example.foroom.data.Constants.DRINK_MESSAGE
import com.example.foroom.data.Constants.FILLER
import com.example.foroom.data.Constants.FILLER_COUNT
import com.example.foroom.data.Constants.GREETING
import com.example.foroom.data.Constants.JOHN_WEEK
import com.example.foroom.data.Constants.QUESTION
import com.example.foroom.data.Constants.REPLY
import com.example.foroom.data.Constants.SOMETHING
import com.example.foroom.data.Constants.USER_A
import com.example.foroom.data.Constants.USER_B
import com.example.foroom.data.Constants.VALID_PASSWORD as PASS
import com.example.foroom.presentation.ui.activity.ForoomActivity
import com.example.foroom.steps.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ConversationTests {
    @get:Rule val rule = ActivityScenarioRule(ForoomActivity::class.java)

    private val login = LoginSteps()
    private val account = AccountSteps()
    private val registration = RegistrationSteps()
    private val chat = ChatSteps()
    private val conv = ConversationSteps()

    @Before
    fun prepare() {
        try { login.loginScreenShown() } catch (e: Throwable) { account.signOut() }
        listOf(USER_A, USER_B).forEach {
            registration.openRegistration().register(it, PASS).homeShown()
            account.signOut()
        }
        account.signInAs(USER_A)
        listOf(JOHN_WEEK, CHAT_NAME, SOMETHING).forEach { chat.createChat(it).chatOpened(it).closeChat() }
        account.signOut()
    }

    @Test
    fun sendMessageInJohnWeekChat() {
        val msg = "$DRINK_MESSAGE${uniqueSuffix()}"
        account.signInAs(USER_A)
        chat.openChat(JOHN_WEEK)
        conv.send(msg).assertMessageDisplayed(msg)
        chat.closeChat().openChat(JOHN_WEEK)
        conv.assertMessageDisplayed(msg)
    }

    @Test
    fun sendQuestionInOwnChat() {
        val question = "$QUESTION${uniqueSuffix()}"
        account.signInAs(USER_A)
        chat.openChat(CHAT_NAME)
        conv.send(question).assertMessageDisplayed(question)
    }

    @Test
    fun continueConversationWithAnotherAccount() {
        val greeting = "$GREETING${uniqueSuffix()}"
        val reply = "$REPLY${uniqueSuffix()}"
        account.signInAs(USER_A)
        chat.openChat(SOMETHING)
        conv.send(greeting).assertMessageDisplayed(greeting)
        repeat(FILLER_COUNT) { conv.send("$FILLER $it") }
        account.switchTo(USER_B)
        chat.openChat(SOMETHING)
        conv.scrollToMessage(greeting)
            .assertMessageFromSender(greeting, USER_A)
            .send(reply)
            .assertMessageDisplayed(reply)
        account.switchTo(USER_A)
        chat.openChat(SOMETHING)
        conv.assertMessageDisplayed(reply).assertMessageFromSender(reply, USER_B)
    }
}