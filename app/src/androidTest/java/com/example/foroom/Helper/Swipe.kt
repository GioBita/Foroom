package com.example.foroom.Helper

import android.view.View
import androidx.test.espresso.UiController
import androidx.test.espresso.ViewAction
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import com.example.foroom.data.Constants
import org.hamcrest.Matcher

fun swipeListDown(list: ViewInteraction) {
    var top = 0
    var bottom = 0
    list.perform(object : ViewAction {
        override fun getConstraints(): Matcher<View> = isDisplayed()
        override fun getDescription() = "read list bounds"
        override fun perform(uiController: UiController, view: View) {
            val loc = IntArray(2)
            view.getLocationOnScreen(loc)
            top = loc[1]
            bottom = loc[1] + view.height
        }
    })
    val h = bottom - top
    swiper(top + h / 5, bottom - h / 5, Constants.SWIPE_DURATION_MS)
}

fun swipeUntilVisible(list: () -> ViewInteraction, target: () -> Unit, maxSwipes: Int = 15) {
    repeat(maxSwipes) {
        try { target(); return } catch (_: Throwable) { swipeListDown(list()) }
    }
    target()
}