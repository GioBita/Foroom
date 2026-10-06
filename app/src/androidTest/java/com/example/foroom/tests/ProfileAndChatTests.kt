package com.example.foroom.tests

import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.foroom.data.Constants
import com.example.foroom.presentation.ui.activity.ForoomActivity
import com.example.foroom.steps.ChatSteps
import com.example.foroom.steps.LoginSteps
import com.example.foroom.steps.ProfileSteps
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ProfileAndChatTests {
    @get:Rule val rule = ActivityScenarioRule(ForoomActivity::class.java)

    private val login = LoginSteps()
    private val profile = ProfileSteps()
    private val chat = ChatSteps()

    private val user = Constants.EXISTING_USER
    private val pass = Constants.VALID_PASSWORD
    @Before
    fun startFromLogin() {
        try {
            login.loginScreenShown()
        } catch (e: Throwable) {
            profile.signOut()
            login.loginScreenShown()
        }
    }

    @Test
    fun changePassword() {
        val newPass = "${Constants.NEW_PASS} ${System.currentTimeMillis() % 10000}"
        login.login(user, pass)
        profile.homeShown()
        profile.changePassword(newPass)
        login.loginScreenShown()
        login.login(user, newPass)
        profile.homeShown()
        profile.changePassword(pass)
    }

    @Test
    fun changeLanguage() {
        login.login(user, pass)
        profile.homeShown()
        profile.openProfile()
        profile.setLanguage(geo = true)
        profile.labelShown(Constants.SHOWN_LABEL)
        profile.setLanguage(geo = false)
        profile.labelShown(Constants.EN_SHOWN_LABEL)
        profile.setLanguage(geo = true)
        profile.labelShown(Constants.SHOWN_LABEL)
    }

    @Test
    fun createChat() {
        val name = "${Constants.CHAT_NAME} ${System.currentTimeMillis() % 10000}"
        login.login(user, pass)
        profile.homeShown()
        chat.createChat(name)
        chat.chatOpened(name)
        chat.closeChat()
        chat.findInList(name)
    }
}