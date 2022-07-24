package uz.gita.testapp.presentation.viewModel.impl

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import uz.gita.testapp.data.remote.responce.ImageResponse
import uz.gita.testapp.domain.useecase.MainUseCase
import uz.gita.testapp.presentation.viewModel.MainViewModel
import uz.gita.testapp.utils.isConnected
import javax.inject.Inject

@HiltViewModel
class MainViewModelImpl
@Inject constructor(
    private val main: MainUseCase
) : ViewModel(), MainViewModel {
    override val cardListHLIveData = MutableLiveData<List<ImageResponse>>()
    override val cardListVLIveData = MutableLiveData<List<ImageResponse>>()
    override val errorLiveData = MutableLiveData<String>()
    override val placeHolderLiveData = MutableLiveData<Boolean>()
    override val progressLiveData = MutableLiveData<Boolean>()
    override val notConnectionLiveData = MutableLiveData<Unit>()
    override val openSettingScreenLiveData = MutableLiveData<Unit>()


    override fun openSettingScreen() {
        openSettingScreenLiveData.value = Unit
    }

    override fun loadH() {
        if (!isConnected()) {
            notConnectionLiveData.value = Unit
            return
        }
        progressLiveData.value = true
        main.horizontalImages().onEach {
            progressLiveData.value = false
            it.onSuccess { list ->
                cardListHLIveData.value = list
                placeHolderLiveData.value = list.isEmpty()
            }.onFailure { error ->
                errorLiveData.value = error.message
            }
        }.launchIn(viewModelScope)
    }

    override fun loadV() {
        if (!isConnected()) {
            notConnectionLiveData.value = Unit
            return
        }
        progressLiveData.value = true
        main.horizontalImages().onEach {
            progressLiveData.value = false
            it.onSuccess { list ->
                cardListVLIveData.value = list
                placeHolderLiveData.value = list.isEmpty()
            }.onFailure { error ->
                errorLiveData.value = error.message
            }
        }.launchIn(viewModelScope)
    }
}