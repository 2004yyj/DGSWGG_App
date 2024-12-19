package kr.hs.dgsw.presentation.di.module

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kr.hs.dgsw.data.database.cache.SearchCache
import kr.hs.dgsw.data.datasource.match.MatchDataSource
import kr.hs.dgsw.data.datasource.search.SearchDataSource
import kr.hs.dgsw.data.datasource.summoner.SummonerDataSource
import kr.hs.dgsw.data.network.remote.MatchRemote
import kr.hs.dgsw.data.network.remote.SummonerRemote
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataSourceModule {
    @Provides
    @Singleton
    fun searchDataSource(searchCache: SearchCache): SearchDataSource {
        return SearchDataSource(searchCache)
    }

    @Provides
    @Singleton
    fun summonerDataSource(summonerRemote: SummonerRemote): SummonerDataSource {
        return SummonerDataSource(summonerRemote)
    }

    @Provides
    @Singleton
    fun matchDataSource(matchRemote: MatchRemote): MatchDataSource {
        return MatchDataSource(matchRemote)
    }
}