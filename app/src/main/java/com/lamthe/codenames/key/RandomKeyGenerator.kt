package com.lamthe.codenames.key

import kotlin.random.Random

class RandomKeyGenerator : KeyGenerator {

    override fun generate(): Key {
        val blueSpots = (0..7).map { KeySpot.Blue }
        val redSpots = (0..7).map { KeySpot.Red }
        val whiteSpots = (0..7).map { KeySpot.White }

        return Key(
            (blueSpots + redSpots + whiteSpots + KeySpot.Black + randomSpot()).shuffled()
        )
    }

    private fun randomSpot(): KeySpot {
        return if (Random.nextInt().rem(2) == 0) KeySpot.Red else KeySpot.Blue
    }

}
