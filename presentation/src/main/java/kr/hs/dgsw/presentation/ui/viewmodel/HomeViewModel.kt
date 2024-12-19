package kr.hs.dgsw.presentation.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import kr.hs.dgsw.presentation.util.SingleLiveEvent

class HomeViewModel : ViewModel() {

    private val _searchBtn = SingleLiveEvent<Unit>()
    val searchBtn: LiveData<Unit> = _searchBtn

    private val _refreshSummonerBtn = SingleLiveEvent<Unit>()
    val refreshSummonerBtn: LiveData<Unit> = _refreshSummonerBtn

    fun onClickSearch() {
        _searchBtn.call()
    }

    fun onClickRefreshSummoner() {
        _refreshSummonerBtn.call()
    }
}