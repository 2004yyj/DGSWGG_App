package kr.hs.dgsw.data.mapper

import kr.hs.dgsw.data.entity.SearchData
import kr.hs.dgsw.domain.entity.Search

fun SearchData.toEntity(): Search {
    return Search(
        this.id,
        this.profileIconId,
        this.summonerName
    )
}

fun Search.toData(): SearchData {
    return SearchData(
        this.id,
        this.profileIconId,
        this.summonerName
    )
}