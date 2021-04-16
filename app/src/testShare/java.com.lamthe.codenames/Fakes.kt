package com.lamthe.codenames

import com.lamthe.codenames.words.WordsService

class FakeWordsService: WordsService {

    override fun words(): List<String> {
        return (0..24).map { it.toString() }.shuffled()
    }

}

class FakeKeyGenerator : KeyGenerator {

    override fun generate(): Key {
        return Key(
            listOf(
                KeySpot.Blue, KeySpot.White, KeySpot.White, KeySpot.Blue, KeySpot.White,
                KeySpot.Red, KeySpot.Blue, KeySpot.Black, KeySpot.White, KeySpot.Blue,
                KeySpot.Red, KeySpot.Red, KeySpot.Red, KeySpot.Red, KeySpot.Blue,
                KeySpot.Blue, KeySpot.White, KeySpot.Red, KeySpot.White, KeySpot.Red,
                KeySpot.White, KeySpot.Blue, KeySpot.Blue, KeySpot.Red, KeySpot.Red
            )
        )
    }

}