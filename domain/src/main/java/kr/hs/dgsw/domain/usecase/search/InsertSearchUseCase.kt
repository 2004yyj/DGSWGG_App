package kr.hs.dgsw.domain.usecase.search

import kr.hs.dgsw.domain.base.ParamsBaseSuspendUseCase
import kr.hs.dgsw.domain.entity.Search
import kr.hs.dgsw.domain.repository.SearchRepository
import javax.inject.Inject

class InsertSearchUseCase @Inject constructor(
    private val searchRepository: SearchRepository
): ParamsBaseSuspendUseCase<InsertSearchUseCase.Params, Unit> {
    data class Params(val search: Search)

    override suspend fun buildParamsSuspendUseCase(params: Params) {
        searchRepository.insertSearch(params.search)
    }
}