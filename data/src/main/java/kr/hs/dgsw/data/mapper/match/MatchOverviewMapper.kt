package kr.hs.dgsw.data.mapper.match

import kr.hs.dgsw.data.entity.match_overview.MatchOverviewData
import kr.hs.dgsw.domain.entity.match.MatchOverview

fun MatchOverviewData.toEntity(): MatchOverview {
    return MatchOverview(
        win,
        matchId,
        gameDuration,
        gameEndTimeStamp,
        gameMode,
        kills,
        deaths,
        assists,
        kda,
        championName,
        doubleKills,
        tripleKills,
        quadraKills,
        pentaKills,
        item,
        summonerSpells,
        perks.toEntity()
    )
}

fun MatchOverview.toData(): MatchOverviewData {
    return MatchOverviewData(
        win,
        matchId,
        gameDuration,
        gameEndTimeStamp,
        gameMode,
        kills,
        deaths,
        assists,
        kda,
        championName,
        doubleKills,
        tripleKills,
        quadraKills,
        pentaKills,
        item,
        summonerSpells,
        perks.toData()
    )
}