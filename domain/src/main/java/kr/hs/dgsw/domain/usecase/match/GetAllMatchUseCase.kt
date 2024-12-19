package kr.hs.dgsw.domain.usecase.match

import kotlinx.coroutines.flow.Flow
import kr.hs.dgsw.domain.base.ParamsBaseUseCase
import kr.hs.dgsw.domain.repository.MatchRepository
import javax.inject.Inject

class GetAllMatchUseCase<T> @Inject constructor( // PagingData<MatchOverview>
    private val matchRepository: MatchRepository
) : ParamsBaseUseCase<GetAllMatchUseCase.Params, Flow<T>> {
    data class Params(val size: Int, val summonerId: String)

    override fun buildParamsUseCase(params: Params): Flow<T> {
        return matchRepository.getAllMatch(params.size, params.summonerId)
    }
}