package uz.gita.testapp.presentation.viewModel.impl

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import uz.gita.testapp.presentation.viewModel.SettingVIewModel
import javax.inject.Inject

@HiltViewModel
class SettingVIewModelImpl @Inject constructor() : ViewModel(), SettingVIewModel {
    override val backLiveData = MutableLiveData<Unit>()
    override val openDialogLiveData = MutableLiveData<Unit>()
    override val openDialogThemeLiveData = MutableLiveData<Unit>()

    override fun back() {
        backLiveData.value = Unit
    }

    override fun openDialog() {
        openDialogLiveData.value = Unit
    }

    override fun openThemeDialog() {
        openDialogThemeLiveData.value = Unit
    }
}