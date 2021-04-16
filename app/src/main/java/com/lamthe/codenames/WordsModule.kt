package com.lamthe.codenames

import com.lamthe.codenames.words.WordsService
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
abstract class WordsModule {

    @Binds
    @Singleton
    abstract fun bindWordsService(wordsService: WordsService): WordsService

}