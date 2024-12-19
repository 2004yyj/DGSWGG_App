package kr.hs.dgsw.domain.entity.summoner

data class MiniSeries(
    val losses: Int,
    val progress: String,
    val target: Int,
    val wins: Int
)