package com.lamthe.codenames

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.lamthe.codenames.cards.Card
import com.lamthe.codenames.key.KeySpot
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
                    CodenamesScreen(cards = viewModel.cards) { card ->
                        viewModel.onCardClicked(card)
                    }
                }
            }
        }
    }
}

@ExperimentalFoundationApi
@Composable
fun CodenamesScreen(cards: List<Card>, onClick: (Card) -> Unit) {
    LazyVerticalGrid(cells = GridCells.Fixed(5)) {
        items(cards.size) { index ->
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(4.dp)
            ) {
                CodenamesCard(card = cards[index], onClick)
            }
        }
    }
}

@Composable
fun CodenamesCard(card: Card, onClick: (Card) -> Unit) {
    val color = when (card.identity) {
        KeySpot.Blue -> Color.Blue
        KeySpot.Red -> Color.Red
        KeySpot.Black -> Color.Black
        KeySpot.White -> CardBackground
    }
    Card(
        elevation = 4.dp,
        backgroundColor = color,
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .height(80.dp)
            .clickable {
                onClick(card)
            }
            .animateContentSize()
    ) {
        if (card.isRevealed) {
            RevealedCard()
        } else {
            UnrevealedCard(card = card)
        }
    }
}

@Composable
fun UnrevealedCard(card: Card) {
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
                    text = card.title,
                    color = CardTitle,
                    modifier = Modifier.padding(12.dp)
                )
            }
        }
        Spacer(modifier = Modifier.weight(0.5f))
    }
}

@Composable
fun RevealedCard() {
    Image(
        painter = painterResource(id = R.drawable.ic_launcher_background),
        contentDescription = "",
        modifier = Modifier.fillMaxSize()
    )
}