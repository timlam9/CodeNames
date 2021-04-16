package com.lamthe.codenames

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.lamthe.codenames.ui.theme.CodeNamesTheme

class MainActivity : ComponentActivity() {
    @ExperimentalFoundationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CodeNamesTheme {
                Surface(color = MaterialTheme.colors.background) {
                    CodenamesScreen()
                }
            }
        }
    }
}

@ExperimentalFoundationApi
@Composable
fun CodenamesScreen() {
    val words = (1..25).map { it.toString() }
    Column {
        Text(text = stringResource(id = R.string.board))
        LazyVerticalGrid(cells = GridCells.Fixed(5) ) {
            items(words.size) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(text = "$it")
                }
            }
        }
    }
}

@ExperimentalFoundationApi
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CodeNamesTheme {
        CodenamesScreen()
    }
}