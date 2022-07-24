package uz.gita.testapp.presentation.viewModel

import androidx.lifecycle.LiveData

interface SplashViewModel {
    val openLanguageScreen: LiveData<Unit>
    val notConnectionLiveData: LiveData<Boolean>
}