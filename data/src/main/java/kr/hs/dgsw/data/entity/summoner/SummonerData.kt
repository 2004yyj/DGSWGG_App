package kr.hs.dgsw.data.entity.summoner

import kr.hs.dgsw.data.entity.summoner.RankData

data class SummonerData(
    val id: String,
    val playerUUID: String,
    val createdAt: Long,
    val updatedAt: Long,
    val grade: Int,
    val klass: Int,
    val number: Int,
    val name: String,
    val profileIconId: Int,
    val summonerName: String,
    val summonerLevel: Int,
    val rankData: List<RankData>
)