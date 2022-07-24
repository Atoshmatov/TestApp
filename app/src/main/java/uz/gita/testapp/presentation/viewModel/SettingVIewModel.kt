package uz.gita.testapp.presentation.viewModel

import androidx.lifecycle.LiveData

interface SettingVIewModel {
    val backLiveData: LiveData<Unit>
    val openDialogLiveData: LiveData<Unit>
    val openDialogThemeLiveData: LiveData<Unit>

    fun back()
    fun openDialog()
    fun openThemeDialog()
}