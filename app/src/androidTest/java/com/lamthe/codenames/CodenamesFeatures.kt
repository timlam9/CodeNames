package com.lamthe.codenames

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.AndroidComposeTestRule
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.lamthe.codenames.words.WordsService
import dagger.hilt.android.testing.BindValue
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.android.testing.UninstallModules
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@HiltAndroidTest
@UninstallModules(WordsModule::class)
@RunWith(AndroidJUnit4::class)
class CodenamesFeatures {

    @get:Rule(order = 0)
    val hiltRule = HiltAndroidRule(this)

    @get:Rule(order = 1)
    val codenamesRule = createAndroidComposeRule<MainActivity>()

    @BindValue @JvmField
    val wordsService: WordsService = FakeWordsService()

    @Test
    fun showGridOfCards() {
        launchCodenamesScreen(codenamesRule) verify {
            gridDisplayedWith(wordsService.words())
        }
    }

}

class FakeWordsService: WordsService {

    override fun words(): List<String> {
        return (0..24).map { it.toString() }
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

    fun gridDisplayedWith(words: List<String>) {
        words.forEach { word ->
            rule.onNodeWithText(word).assertIsDisplayed()
        }
    }

}
