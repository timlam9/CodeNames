package com.lamthe.codenames

import com.lamthe.codenames.cards.Card
import org.junit.Assert.assertEquals
import org.junit.Test

class CodenamesViewModelTest {

    @Test
    fun `given a list of words, when , then`() {
        val wordsService = FakeWordsService()
        val keyGenerator = FakeKeyGenerator()
        val viewModel = CodenamesViewModel(wordsService, keyGenerator)

        val words = wordsService.words()
        val key = keyGenerator.generate()
        val expectedCards = words.mapIndexed { index, title ->
            Card(title = title, identity = key.spots[index])
        }
        val cards = viewModel.cards

        assertEquals(expectedCards, cards)
    }

}
