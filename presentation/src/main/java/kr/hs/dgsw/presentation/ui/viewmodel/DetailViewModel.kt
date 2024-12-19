package kr.hs.dgsw.presentation.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import kr.hs.dgsw.domain.entity.Search
import kr.hs.dgsw.domain.entity.summoner.Summoner
import kr.hs.dgsw.domain.usecase.search.InsertSearchUseCase
import kr.hs.dgsw.domain.usecase.summoner.GetSummonerByNameUseCase
import kr.hs.dgsw.presentation.util.Event
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val getSummonerByNameUseCase: GetSummonerByNameUseCase,
    private val insertSearchUseCase: InsertSearchUseCase
): ViewModel() {

    private val _eventSummoner = MutableLiveData<Event<Summoner>>()
    val eventSummoner: LiveData<Event<Summoner>> = _eventSummoner

    private val _eventFailure = MutableLiveData<Event<String>>()
    val eventFailure: LiveData<Event<String>> = _eventFailure

    fun getSummoner(searchText: String) {
        val params = GetSummonerByNameUseCase.Params(searchText)
        viewModelScope.launch {
            getSummonerByNameUseCase.buildParamsUseCase(params)
                .flowOn(Dispatchers.IO)
                .catch { error -> _eventFailure.value = Event(error.message?:"") }
                .collect { _eventSummoner.value = Event(it) }
        }
    }

    fun insertSummonerSearch(searchText: String, profileIconId: Int) {
        viewModelScope.launch {
            val search = Search(profileIconId = profileIconId, summonerName = searchText)
            insertSearchUseCase.buildParamsSuspendUseCase(InsertSearchUseCase.Params(search))
        }
    }
}