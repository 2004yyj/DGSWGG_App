package kr.hs.dgsw.data.mapper.match

import kr.hs.dgsw.data.entity.match_overview.StatPerkData
import kr.hs.dgsw.domain.entity.match.StatPerk

fun StatPerkData.toEntity(): StatPerk {
    return StatPerk(
        code, iconPath, name
    )
}

fun StatPerk.toData(): StatPerkData {
    return StatPerkData(
        code, iconPath, name
    )
}