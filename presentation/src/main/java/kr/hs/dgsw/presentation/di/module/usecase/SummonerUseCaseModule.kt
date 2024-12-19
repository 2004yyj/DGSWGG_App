package kr.hs.dgsw.presentation.di.module.usecase

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kr.hs.dgsw.domain.repository.SummonerRepository
import kr.hs.dgsw.domain.usecase.summoner.GetSummonerByNameUseCase
import kr.hs.dgsw.domain.usecase.summoner.PostRefreshSummonerInfoUseCase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object SummonerUseCaseModule {
    @Provides
    @Singleton
    fun provideGetSummonerByNameUseCase(summonerRepository: SummonerRepository): GetSummonerByNameUseCase {
        return GetSummonerByNameUseCase(summonerRepository)
    }

    @Provides
    @Singleton
    fun providePostRefreshSummonerInfoUseCase(summonerRepository: SummonerRepository): PostRefreshSummonerInfoUseCase {
        return PostRefreshSummonerInfoUseCase(summonerRepository)
    }
}