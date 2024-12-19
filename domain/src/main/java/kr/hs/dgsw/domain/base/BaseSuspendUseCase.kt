package kr.hs.dgsw.domain.base

interface BaseSuspendUseCase<T> {
    suspend fun buildSuspendUseCase(): T
}