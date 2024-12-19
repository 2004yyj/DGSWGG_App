package kr.hs.dgsw.domain.usecase.search

import kotlinx.coroutines.flow.Flow
import kr.hs.dgsw.domain.base.ParamsBaseUseCase
import kr.hs.dgsw.domain.repository.SearchRepository
import javax.inject.Inject

class GetAllSearchUseCase<T> @Inject constructor( // PagingData<Search>
    private val searchRepository: SearchRepository
): ParamsBaseUseCase<GetAllSearchUseCase.Params, Flow<T>> {
    data class Params(val size: Int)

    override fun buildParamsUseCase(params: Params): Flow<T> {
        return searchRepository.getAll(params.size)
    }
}