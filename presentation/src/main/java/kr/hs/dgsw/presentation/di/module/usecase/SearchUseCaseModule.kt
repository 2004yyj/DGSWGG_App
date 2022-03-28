package kr.hs.dgsw.presentation.di.module.usecase

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kr.hs.dgsw.domain.repository.SearchRepository
import kr.hs.dgsw.domain.usecase.search.DeleteSearchUseCase
import kr.hs.dgsw.domain.usecase.search.GetAllSearchUseCase
import kr.hs.dgsw.domain.usecase.search.InsertSearchUseCase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object SearchUseCaseModule {
    @Provides
    @Singleton
    fun provideGetAllSearchUseCase(searchRepository: SearchRepository): GetAllSearchUseCase {
        return GetAllSearchUseCase(searchRepository)
    }

    @Provides
    @Singleton
    fun provideInsertSearchUseCase(searchRepository: SearchRepository): InsertSearchUseCase {
        return InsertSearchUseCase(searchRepository)
    }

    @Provides
    @Singleton
    fun provideDeleteSearchUseCase(searchRepository: SearchRepository): DeleteSearchUseCase {
        return DeleteSearchUseCase(searchRepository)
    }
}