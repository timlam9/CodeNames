package com.lamthe.codenames.cards

import com.lamthe.codenames.key.KeySpot

data class Card(
    val title: String,
    val identity: KeySpot,
    val isRevealed: Boolean = false
)
