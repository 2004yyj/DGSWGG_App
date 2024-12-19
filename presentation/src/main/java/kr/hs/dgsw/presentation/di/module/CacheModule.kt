package kr.hs.dgsw.presentation.di.module

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kr.hs.dgsw.data.database.cache.SearchCache
import kr.hs.dgsw.data.database.dao.SearchDao
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CacheModule {
    @Provides
    @Singleton
    fun provideSearchCache(searchDao: SearchDao): SearchCache {
        return SearchCache(searchDao)
    }
}