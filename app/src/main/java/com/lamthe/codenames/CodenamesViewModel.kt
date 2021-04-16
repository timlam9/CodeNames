package com.lamthe.codenames

import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.lamthe.codenames.cards.Card
import com.lamthe.codenames.key.KeyGenerator
import com.lamthe.codenames.key.KeySpot
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

    var currentTeam: Team by mutableStateOf(Team.Red)

    init {
        val words = wordsService.words()
        val key = keyGenerator.generate()
        cards = words.mapIndexed { index, title ->
            Card(title = title, identity = key.spots[index])
        }

        val redCards = cards.count { it.identity == KeySpot.Red }
        val blueCards = cards.count { it.identity == KeySpot.Blue }
        currentTeam = if (redCards > blueCards) Team.Red else Team.Blue
    }

    fun onCardClicked(card: Card) {
        cards = cards.map { if(it == card) card.copy(isRevealed = !it.isRevealed) else it}
    }

    fun onSkipClicked() {
        currentTeam = if (currentTeam == Team.Red) Team.Blue else Team.Red
    }

}