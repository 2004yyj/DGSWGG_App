package kr.hs.dgsw.data.network.remote

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kr.hs.dgsw.data.entity.summoner.SummonerData
import kr.hs.dgsw.data.network.base.BaseRemote
import kr.hs.dgsw.data.network.service.SummonerService
import javax.inject.Inject

class SummonerRemote @Inject constructor(
    override val service: SummonerService
): BaseRemote<SummonerService>() {
    suspend fun postRefreshSummonerInfo(
        grade: Int,
        klass: Int,
        number: Int,
        name: String,
        summonerName: String
    ): String {
        return getMessage(service.postRefreshSummonerInfo(
            grade, klass, number, name, summonerName
        ))
    }

    fun getSummonerByName(summonerName: String): Flow<SummonerData> {
        return flow {
            emit(getResponse(
                service.getSummonerByName(summonerName)
            ))
        }
    }
}