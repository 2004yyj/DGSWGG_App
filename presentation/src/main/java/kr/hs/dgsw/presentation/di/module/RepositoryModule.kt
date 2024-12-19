package kr.hs.dgsw.presentation.di.module

import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kr.hs.dgsw.data.datasource.search.SearchDataSource
import kr.hs.dgsw.data.database.paging.SearchPagingSource
import kr.hs.dgsw.data.datasource.summoner.SummonerDataSource
import kr.hs.dgsw.data.repository.MatchRepositoryImpl
import kr.hs.dgsw.data.repository.SearchRepositoryImpl
import kr.hs.dgsw.data.repository.SummonerRepositoryImpl
import kr.hs.dgsw.domain.repository.MatchRepository
import kr.hs.dgsw.domain.repository.SearchRepository
import kr.hs.dgsw.domain.repository.SummonerRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun provideSearchRepository(searchRepository: SearchRepositoryImpl): SearchRepository

    @Binds
    @Singleton
    abstract fun provideSummonerRepository(summonerRepository: SummonerRepositoryImpl): SummonerRepository

    @Binds
    @Singleton
    abstract fun provideMatchRepository(matchRepository: MatchRepositoryImpl): MatchRepository
}