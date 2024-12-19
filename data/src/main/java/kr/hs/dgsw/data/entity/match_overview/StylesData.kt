package kr.hs.dgsw.data.entity.match_overview

data class StylesData (
    val description: String,
    val selections: List<SelectionData>,
    val style: Int,
    val stylePath: String
)