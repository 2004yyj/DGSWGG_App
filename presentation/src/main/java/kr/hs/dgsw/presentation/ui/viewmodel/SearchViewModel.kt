package kr.hs.dgsw.presentation.ui.viewmodel

import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import kr.hs.dgsw.domain.entity.Search
import kr.hs.dgsw.domain.usecase.search.DeleteAllSearchUseCase
import kr.hs.dgsw.domain.usecase.search.DeleteSearchUseCase
import kr.hs.dgsw.domain.usecase.search.GetAllSearchUseCase
import kr.hs.dgsw.presentation.ui.uimodel.SearchUIModel
import kr.hs.dgsw.presentation.util.SingleLiveEvent
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val getAllSearchUseCase: GetAllSearchUseCase<PagingData<Search>>,
    private val deleteAllSearchUseCase: DeleteAllSearchUseCase,
    private val deleteSearchUseCase: DeleteSearchUseCase
): ViewModel() {
    val searchText = ObservableField<String>()

    private val _eventFinishActivity = SingleLiveEvent<Unit>()
    val eventFinishActivity: LiveData<Unit> = _eventFinishActivity

    private val _searchList = MutableLiveData<PagingData<SearchUIModel>>()
    val searchList: LiveData<PagingData<SearchUIModel>> = _searchList

    private val _eventRefresh = SingleLiveEvent<Unit>()
    val eventRefresh: LiveData<Unit> = _eventRefresh

    fun deleteSearch(id: Long) {
        viewModelScope.launch {
            deleteSearchUseCase.buildParamsSuspendUseCase(DeleteSearchUseCase.Params(id))
        }.invokeOnCompletion {
            _eventRefresh.call()
        }
    }

    fun deleteAllSearch() {
        viewModelScope.launch {
            deleteAllSearchUseCase.buildSuspendUseCase()
        }.invokeOnCompletion {
            _eventRefresh.call()
        }
    }

    fun getAllSearch() {
        viewModelScope.launch {
            getAllSearchUseCase.buildParamsUseCase(GetAllSearchUseCase.Params(10))
                .cachedIn(viewModelScope)
                .collectLatest {
                    _searchList.value =
                        it.map { search ->
                            SearchUIModel.SearchModel(search) as SearchUIModel
                        }.insertHeaderItem(TerminalSeparatorType.FULLY_COMPLETE, SearchUIModel.Header)
                }
        }
    }

    fun finishActivity() {
        _eventFinishActivity.call()
    }
}