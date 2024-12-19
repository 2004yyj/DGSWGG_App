package kr.hs.dgsw.domain.entity.summoner

data class Rank(
    val id: Int,
    val tier: String,
    val rank: String,
    val queueType: String,
    val leaguePoints: Int,
    val wins: Int,
    val losses: Int,
    val miniSeries: MiniSeries?
)