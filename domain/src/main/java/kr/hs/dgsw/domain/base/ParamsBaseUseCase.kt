package kr.hs.dgsw.domain.base

interface ParamsBaseUseCase<Params, T> {
    fun buildParamsUseCase(params: Params): T
}