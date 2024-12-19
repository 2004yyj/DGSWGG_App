package kr.hs.dgsw.presentation.di.module

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kr.hs.dgsw.data.network.remote.MatchRemote
import kr.hs.dgsw.data.network.remote.SummonerRemote
import kr.hs.dgsw.data.network.service.MatchService
import kr.hs.dgsw.data.network.service.SummonerService
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RemoteModule {
    @Provides
    @Singleton
    fun provideSummonerRemote(summonerService: SummonerService): SummonerRemote {
        return SummonerRemote(summonerService)
    }

    @Provides
    @Singleton
    fun provideMatchRemote(matchService: MatchService): MatchRemote {
        return MatchRemote(matchService)
    }
}