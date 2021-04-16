package com.lamthe.codenames

import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.lamthe.codenames.cards.CodenamesCard
import com.lamthe.codenames.key.Key
import com.lamthe.codenames.key.KeyGenerator
import com.lamthe.codenames.words.WordsService
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CodenamesViewModel @Inject constructor(
    private val wordsService: WordsService,
    private val keyGenerator: KeyGenerator
) : ViewModel() {

    val key: Key = keyGenerator.generate()

    var cards: List<CodenamesCard> by mutableStateOf(emptyList())
        private set

    var words: List<String> by mutableStateOf(emptyList())
        private set

    init {
        words = wordsService.words()
    }

}