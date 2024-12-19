package kr.hs.dgsw.domain.usecase.search

import kr.hs.dgsw.domain.base.ParamsBaseSuspendUseCase
import kr.hs.dgsw.domain.repository.SearchRepository
import javax.inject.Inject

class DeleteSearchUseCase @Inject constructor(
    private val searchRepository: SearchRepository
): ParamsBaseSuspendUseCase<DeleteSearchUseCase.Params, Unit> {
    data class Params(val id: Long)

    override suspend fun buildParamsSuspendUseCase(params: Params) {
        searchRepository.deleteSearch(params.id)
    }
}