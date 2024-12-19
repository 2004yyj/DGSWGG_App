package kr.hs.dgsw.data.entity.summoner

data class RankData(
    val id: Int,
    val tier: String,
    val rank: String,
    val queueType: String,
    val leaguePoints: Int,
    val wins: Int,
    val losses: Int,
    val miniSeries: MiniSeriesData?
)