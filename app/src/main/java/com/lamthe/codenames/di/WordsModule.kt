package com.lamthe.codenames.di

import com.lamthe.codenames.words.InMemoryWordsService
import com.lamthe.codenames.words.WordsService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent


@Module
@InstallIn(ViewModelComponent::class)
object WordsModule {

    @Provides
    fun provideWordsService(): WordsService = InMemoryWordsService()

}