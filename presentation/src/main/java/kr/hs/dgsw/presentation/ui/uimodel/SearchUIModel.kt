package kr.hs.dgsw.presentation.ui.uimodel

import kr.hs.dgsw.domain.entity.Search

sealed class SearchUIModel {
    class SearchModel(val search: Search): SearchUIModel()
    object Header : SearchUIModel()
    object Footer : SearchUIModel()
}