package kr.hs.dgsw.domain.entity.summoner

import kr.hs.dgsw.domain.entity.summoner.Rank

data class Summoner(
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
    val rankData: List<Rank>
)