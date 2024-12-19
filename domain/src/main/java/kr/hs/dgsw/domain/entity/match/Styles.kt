package kr.hs.dgsw.domain.entity.match

data class Styles (
    val description: String,
    val selections: List<Selection>,
    val style: Int,
    val stylePath: String
)