package kr.hs.dgsw.data.mapper.match

import kr.hs.dgsw.data.entity.match_overview.StylesData
import kr.hs.dgsw.domain.entity.match.Styles

fun StylesData.toEntity(): Styles {
    return Styles(
        description,
        selections.map { it.toEntity() },
        style,
        stylePath
    )
}

fun Styles.toData(): StylesData {
    return StylesData(
        description,
        selections.map { it.toData() },
        style,
        stylePath
    )
}