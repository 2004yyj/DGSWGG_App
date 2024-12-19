package kr.hs.dgsw.presentation.ui.viewmodel

import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import kr.hs.dgsw.domain.usecase.summoner.PostRefreshSummonerInfoUseCase
import javax.inject.Inject

@HiltViewModel
class RefreshSummonerViewModel @Inject constructor(
    private val postRefreshSummonerInfoUseCase: PostRefreshSummonerInfoUseCase
): ViewModel() {
    val name = ObservableField("")
    val grade = ObservableField(0)
    val klass = ObservableField(0)
    val number = ObservableField(0)
    val summonerName = ObservableField("")

    private val _isFailure = MutableLiveData<String>()
    val isFailure: LiveData<String>
        get() = _isFailure

    private val _isSuccess = MutableLiveData<String>()
    val isSuccess: LiveData<String>
        get() = _isSuccess

    fun postRefreshSummonerInfo() {
        val name = name.get()!!
        val grade = grade.get()!!
        val klass = klass.get()!!
        val number = number.get()!!
        val summonerName = summonerName.get()!!
        viewModelScope.launch {
            val params = PostRefreshSummonerInfoUseCase.Params(
                grade, klass, number, name, summonerName
            )
            val result = postRefreshSummonerInfoUseCase.buildParamsSuspendUseCase(params)
            if (result.isFailure)
                _isFailure.value = result.getOrNull()
            else
                _isSuccess.value = result.getOrNull()
        }
    }
}