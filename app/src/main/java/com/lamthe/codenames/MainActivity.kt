package com.lamthe.codenames

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import com.lamthe.codenames.ui.theme.CodeNamesTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: CodenamesViewModel by viewModels()

    @ExperimentalFoundationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CodeNamesTheme {
                Surface(color = MaterialTheme.colors.background) {
                    CodenamesScreen(words = viewModel.words)
                }
            }
        }
    }
}

@ExperimentalFoundationApi
@Composable
fun CodenamesScreen(words: List<String>) {
    LazyVerticalGrid(cells = GridCells.Fixed(5)) {
        items(words.size) { index ->
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(text = words[index])
            }
        }
    }
}