package com.lamthe.codenames

import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.lamthe.codenames.words.WordsService
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CodenamesViewModel @Inject constructor(private val wordsService: WordsService) : ViewModel() {

    var words: List<String> by mutableStateOf(emptyList())
        private set

    init {
        words = wordsService.words()
    }

}