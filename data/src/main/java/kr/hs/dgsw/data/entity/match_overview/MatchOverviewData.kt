package kr.hs.dgsw.data.entity.match_overview

data class MatchOverviewData(
    val win: Boolean,
    val matchId: String,
    val gameDuration: Int,
    val gameEndTimeStamp: Int,
    val gameMode: String,
    val kills: Int,
    val deaths: Int,
    val assists: Int,
    val kda: Int,
    val championName: String,
    val doubleKills: Int,
    val tripleKills: Int,
    val quadraKills: Int,
    val pentaKills: Int,
    val item: List<Int>,
    val summonerSpells: List<String>,
    val perks: PerksData
)