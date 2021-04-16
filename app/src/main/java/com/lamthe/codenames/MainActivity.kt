package com.lamthe.codenames

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.lamthe.codenames.ui.theme.CardBackground
import com.lamthe.codenames.ui.theme.CardTitle
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
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(4.dp)
            ) {
                CodenamesCard(title = words[index])
            }
        }
    }
}

@Composable
fun CodenamesCard(title: String) {
    Card(
        elevation = 4.dp,
        backgroundColor = CardBackground,
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .height(80.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            Spacer(modifier = Modifier.weight(0.5f))
            Card(
                elevation = 4.dp,
                backgroundColor = Color.White,
                modifier = Modifier.weight(7f)
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.padding(4.dp)
                ) {
                    Text(
                        text = title,
                        color = CardTitle,
                        modifier = Modifier.padding(12.dp)
                    )
                }
            }
            Spacer(modifier = Modifier.weight(0.5f))
        }
    }
}

@Preview
@Composable
fun PreviewCard() {
    CodenamesCard(title = "Paixtaras")
}
