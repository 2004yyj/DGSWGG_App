package kr.hs.dgsw.data.datasource.summoner

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kr.hs.dgsw.data.mapper.summoner.toEntity
import kr.hs.dgsw.data.network.remote.SummonerRemote
import kr.hs.dgsw.domain.entity.summoner.Summoner
import javax.inject.Inject

class SummonerDataSource @Inject constructor(
    private val remote: SummonerRemote
) {
    suspend fun postRefreshSummonerInfo(
        grade: Int,
        klass: Int,
        number: Int,
        name: String,
        summonerName: String
    ): String {
        return remote.postRefreshSummonerInfo(grade, klass, number, name, summonerName)
    }

    fun getSummonerByName(summonerName: String): Flow<Summoner> {
        return remote.getSummonerByName(summonerName).map {
            it.toEntity()
        }
    }
}