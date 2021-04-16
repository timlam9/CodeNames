package com.lamthe.codenames

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.AndroidComposeTestRule
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@HiltAndroidTest
@RunWith(AndroidJUnit4::class)
class CodenamesFeatures {

    @get:Rule(order = 0)
    val hiltRule = HiltAndroidRule(this)

    @get:Rule(order = 1)
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
