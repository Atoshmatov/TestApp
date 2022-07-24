package uz.gita.testapp.presentation.viewModel.impl

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import uz.gita.testapp.presentation.viewModel.SplashViewModel
import uz.gita.testapp.utils.isConnected
import javax.inject.Inject

@HiltViewModel
class SplashViewModelImpl @Inject constructor() : ViewModel(), SplashViewModel {
    override val openLanguageScreen = MutableLiveData<Unit>()
    override val notConnectionLiveData = MutableLiveData<Boolean>()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            delay(2000)
            if (!isConnected()) {
                notConnectionLiveData.postValue(false)
                return@launch
            }
            openLanguageScreen.postValue(Unit)
        }
    }
}