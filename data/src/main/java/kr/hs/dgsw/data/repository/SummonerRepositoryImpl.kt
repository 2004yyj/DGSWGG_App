package kr.hs.dgsw.data.repository

import kotlinx.coroutines.flow.Flow
import kr.hs.dgsw.data.datasource.summoner.SummonerDataSource
import kr.hs.dgsw.domain.entity.summoner.Summoner
import kr.hs.dgsw.domain.repository.SummonerRepository
import javax.inject.Inject

class SummonerRepositoryImpl @Inject constructor(
    private val summonerDataSource: SummonerDataSource
): SummonerRepository {
    override suspend fun postRefreshSummonerInfo(
        grade: Int,
        klass: Int,
        number: Int,
        name: String,
        summonerName: String
    ): String {
        return summonerDataSource.postRefreshSummonerInfo(grade, klass, number, name, summonerName)
    }

    override fun getSummonerByName(summonerName: String): Flow<Summoner> {
        return summonerDataSource.getSummonerByName(summonerName)
    }
}