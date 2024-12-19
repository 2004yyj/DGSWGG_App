package kr.hs.dgsw.presentation.di.module

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kr.hs.dgsw.data.network.service.MatchService
import kr.hs.dgsw.data.network.service.SummonerService
import kr.hs.dgsw.domain.entity.summoner.Summoner
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ServiceModule {
    @Provides
    @Singleton
    fun provideSummonerService(retrofit: Retrofit): SummonerService {
        return retrofit.create(SummonerService::class.java)
    }

    @Provides
    @Singleton
    fun provideMatchService(retrofit: Retrofit): MatchService {
        return retrofit.create(MatchService::class.java)
    }
}