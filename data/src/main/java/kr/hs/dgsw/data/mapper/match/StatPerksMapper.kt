package kr.hs.dgsw.data.mapper.match

import kr.hs.dgsw.data.entity.match_overview.StatPerksData
import kr.hs.dgsw.domain.entity.match.StatPerks

fun StatPerksData.toEntity(): StatPerks {
    return StatPerks(
        defense.toEntity(),
        flex.toEntity(),
        offense.toEntity()
    )
}

fun StatPerks.toData(): StatPerksData {
    return StatPerksData(
        defense.toData(),
        flex.toData(),
        offense.toData()
    )
}