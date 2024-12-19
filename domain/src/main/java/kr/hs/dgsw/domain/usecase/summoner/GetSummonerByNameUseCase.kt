package kr.hs.dgsw.domain.usecase.summoner

import kotlinx.coroutines.flow.Flow
import kr.hs.dgsw.domain.base.ParamsBaseUseCase
import kr.hs.dgsw.domain.entity.summoner.Summoner
import kr.hs.dgsw.domain.repository.SummonerRepository
import javax.inject.Inject

class GetSummonerByNameUseCase @Inject constructor(
    private val summonerRepository: SummonerRepository
): ParamsBaseUseCase<GetSummonerByNameUseCase.Params, Flow<Summoner>> {
    class Params(val summonerName: String)

    override fun buildParamsUseCase(params: Params): Flow<Summoner> {
        return summonerRepository.getSummonerByName(params.summonerName)
    }
}