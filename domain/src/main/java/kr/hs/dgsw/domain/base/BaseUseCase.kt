package kr.hs.dgsw.domain.base

interface BaseUseCase<T> {
    fun buildUseCase(): T
}