package com.example.foroom.steps

import com.example.foroom.data.Constants.VALID_PASSWORD

class AccountSteps(
    private val login: LoginSteps = LoginSteps(),
    private val profile: ProfileSteps = ProfileSteps(),
    private val chat: ChatSteps = ChatSteps(),
) {
    fun signInAs(user: String) = apply {
        login.login(user, VALID_PASSWORD)
        profile.homeShown()
    }

    fun signOut() = apply {
        profile.signOut()
        login.loginScreenShown()
    }

    fun switchTo(user: String) = apply {
        chat.closeChat()
        signOut()
        signInAs(user)
    }
}