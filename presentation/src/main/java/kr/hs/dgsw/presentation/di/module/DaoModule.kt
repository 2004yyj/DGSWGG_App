package kr.hs.dgsw.presentation.di.module

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kr.hs.dgsw.data.database.dao.SearchDao
import kr.hs.dgsw.data.database.roomdb.SearchDatabase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DaoModule {
    @Provides
    @Singleton
    fun provideSearchDao(searchDatabase: SearchDatabase): SearchDao {
        return searchDatabase.dao
    }
}