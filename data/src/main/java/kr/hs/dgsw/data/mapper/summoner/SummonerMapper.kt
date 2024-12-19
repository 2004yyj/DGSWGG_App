package kr.hs.dgsw.data.mapper.summoner

import kr.hs.dgsw.data.entity.summoner.SummonerData
import kr.hs.dgsw.domain.entity.summoner.Summoner

fun SummonerData.toEntity(): Summoner {
    return Summoner(
        id,
        playerUUID,
        createdAt,
        updatedAt,
        grade,
        klass,
        number,
        name,
        profileIconId,
        summonerName,
        summonerLevel,
        rankData.map { it.toEntity() }
    )
}