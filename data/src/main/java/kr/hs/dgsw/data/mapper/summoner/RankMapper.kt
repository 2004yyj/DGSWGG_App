package kr.hs.dgsw.data.mapper.summoner

import kr.hs.dgsw.data.entity.summoner.RankData
import kr.hs.dgsw.domain.entity.summoner.Rank

fun RankData.toEntity(): Rank {
    return Rank(
        id,
        tier,
        rank,
        queueType,
        leaguePoints,
        wins,
        losses,
        miniSeries?.toEntity()
    )
}