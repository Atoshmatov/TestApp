package uz.gita.testapp.presentation.viewModel.impl

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import uz.gita.testapp.presentation.viewModel.DetailViewModel
import javax.inject.Inject

@HiltViewModel
class DetailViewModelImpl @Inject constructor() : ViewModel(), DetailViewModel {
    override val backLiveData = MutableLiveData<Unit>()
    override fun back() {
        backLiveData.value = Unit
    }
}