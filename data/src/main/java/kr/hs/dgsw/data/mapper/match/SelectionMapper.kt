package kr.hs.dgsw.data.mapper.match

import kr.hs.dgsw.data.entity.match_overview.SelectionData
import kr.hs.dgsw.domain.entity.match.Selection

fun SelectionData.toEntity(): Selection {
    return Selection(iconPath, perk)
}

fun Selection.toData(): SelectionData {
    return SelectionData(iconPath, perk)
}