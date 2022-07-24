package uz.gita.testapp.presentation.viewModel

import androidx.lifecycle.LiveData
import uz.gita.testapp.data.remote.responce.ImageResponse

interface MainViewModel {
    val cardListHLIveData: LiveData<List<ImageResponse>>
    val cardListVLIveData: LiveData<List<ImageResponse>>
    val errorLiveData: LiveData<String>
    val placeHolderLiveData: LiveData<Boolean>
    val progressLiveData: LiveData<Boolean>
    val notConnectionLiveData: LiveData<Unit>
    val openSettingScreenLiveData: LiveData<Unit>

    fun openSettingScreen()
    fun loadH()
    fun loadV()
}