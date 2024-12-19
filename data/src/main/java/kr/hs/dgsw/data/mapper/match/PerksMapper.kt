package kr.hs.dgsw.data.mapper.match

import kr.hs.dgsw.data.entity.match_overview.PerksData
import kr.hs.dgsw.domain.entity.match.Perks

fun PerksData.toEntity(): Perks {
    return Perks(
        statPerks.toEntity(),
        styles.toEntity()
    )
}

fun Perks.toData(): PerksData {
    return PerksData(
        statPerks.toData(),
        styles.toData()
    )
}