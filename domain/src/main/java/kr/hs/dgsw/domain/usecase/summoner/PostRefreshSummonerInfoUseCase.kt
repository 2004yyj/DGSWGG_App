package kr.hs.dgsw.domain.usecase.summoner

import kotlinx.coroutines.Dispatchers
import kr.hs.dgsw.domain.base.ParamsBaseUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import kr.hs.dgsw.domain.base.ParamsBaseSuspendUseCase
import kr.hs.dgsw.domain.repository.SummonerRepository
import javax.inject.Inject

class PostRefreshSummonerInfoUseCase @Inject constructor(
    private val summonerRepository: SummonerRepository
): ParamsBaseSuspendUseCase<PostRefreshSummonerInfoUseCase.Params, Result<String>> {
    class Params(
        val grade: Int,
        val klass: Int,
        val number: Int,
        val name: String,
        val summonerName: String
    )

    override suspend fun buildParamsSuspendUseCase(params: Params): Result<String> {
        return withContext(Dispatchers.IO) {
            try {
                Result.success(
                    summonerRepository.postRefreshSummonerInfo(
                        params.grade,
                        params.klass,
                        params.number,
                        params.name,
                        params.summonerName
                    )
                )
            } catch (e: Throwable) {
                Result.failure(e)
            }
        }
    }
}