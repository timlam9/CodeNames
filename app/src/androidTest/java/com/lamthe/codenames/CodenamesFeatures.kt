package com.lamthe.codenames

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.AndroidComposeTestRule
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class CodenamesFeatures {

    @get:Rule
    val codenamesRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun showGridOfCards() {
        launchCodenamesScreen(codenamesRule) verify {
            gridIsPresent()
        }
    }

}


fun launchCodenamesScreen(codenamesRule: AndroidComposeTestRule<ActivityScenarioRule<MainActivity>, MainActivity>): CodenamesRobot {
    return CodenamesRobot(codenamesRule)
}

class CodenamesRobot(
    private val codenamesRule: AndroidComposeTestRule<ActivityScenarioRule<MainActivity>, MainActivity>
) {

    infix fun verify(block: CodenamesVerification.() -> Unit): CodenamesVerification {
        return CodenamesVerification(codenamesRule).apply(block)
    }

}

class CodenamesVerification(
    private val rule: AndroidComposeTestRule<ActivityScenarioRule<MainActivity>, MainActivity>
) {

    fun gridIsPresent() {
        val board = rule.activity.getString(R.string.board)
        rule.onNodeWithText(board).assertIsDisplayed()
    }

}
