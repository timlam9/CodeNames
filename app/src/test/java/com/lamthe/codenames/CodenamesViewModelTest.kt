package com.lamthe.codenames

import com.lamthe.codenames.key.Key
import com.lamthe.codenames.key.KeySpot
import org.junit.Assert.assertEquals
import org.junit.Test

class CodenamesViewModelTest {

    @Test
    fun `given a list of words, when , then`() {
        val viewModel = CodenamesViewModel(FakeWordsService(), FakeKeyGenerator())

        val key = viewModel.key

        assertEquals(createKey(), key)
    }

    private fun createKey(): Key {
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

