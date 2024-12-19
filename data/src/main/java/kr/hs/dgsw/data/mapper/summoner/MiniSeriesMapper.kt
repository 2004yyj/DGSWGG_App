package kr.hs.dgsw.data.mapper.summoner

import kr.hs.dgsw.data.entity.summoner.MiniSeriesData
import kr.hs.dgsw.domain.entity.summoner.MiniSeries

fun MiniSeriesData.toEntity(): MiniSeries {
    return MiniSeries(
        losses,
        progress,
        target,
        wins
    )
}