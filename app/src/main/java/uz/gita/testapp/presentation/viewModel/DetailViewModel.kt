package uz.gita.testapp.presentation.viewModel

import androidx.lifecycle.LiveData

interface DetailViewModel {
    val backLiveData: LiveData<Unit>

    fun back()
}