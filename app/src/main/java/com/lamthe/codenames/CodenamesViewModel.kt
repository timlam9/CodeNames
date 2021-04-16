package com.lamthe.codenames

import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.lamthe.codenames.cards.Card
import com.lamthe.codenames.key.KeyGenerator
import com.lamthe.codenames.words.WordsService
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CodenamesViewModel @Inject constructor(
    private val wordsService: WordsService,
    private val keyGenerator: KeyGenerator
) : ViewModel() {

    var cards: List<Card> by mutableStateOf(emptyList())
        private set

    init {
        val words = wordsService.words()
        val key = keyGenerator.generate()
        cards = words.mapIndexed { index, title ->
            Card(title = title, identity = key.spots[index])
        }
    }

    fun onCardClicked(card: Card) {
        cards = cards.map { if(it == card) card.copy(isRevealed = !it.isRevealed) else it}
    }

}