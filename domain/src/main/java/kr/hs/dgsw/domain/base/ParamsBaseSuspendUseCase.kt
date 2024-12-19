package kr.hs.dgsw.domain.base

interface ParamsBaseSuspendUseCase<Params, T> {
    suspend fun buildParamsSuspendUseCase(params: Params): T
}