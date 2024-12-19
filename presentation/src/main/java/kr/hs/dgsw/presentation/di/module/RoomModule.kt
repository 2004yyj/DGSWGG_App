package kr.hs.dgsw.presentation.di.module

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kr.hs.dgsw.data.database.dao.SearchDao
import kr.hs.dgsw.data.database.roomdb.SearchDatabase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {
    @Provides
    @Singleton
    fun provideSearchDatabase(
        @ApplicationContext
        context: Context
    ): SearchDatabase {
        return Room.databaseBuilder(
            context,
            SearchDatabase::class.java,
            "search"
        ).build()
    }
}