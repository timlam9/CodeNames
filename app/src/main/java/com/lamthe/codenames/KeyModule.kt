package com.lamthe.codenames

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object KeyModule {

    @Provides
    fun provideKeyGenerator(): KeyGenerator = RandomKeyGenerator()

}