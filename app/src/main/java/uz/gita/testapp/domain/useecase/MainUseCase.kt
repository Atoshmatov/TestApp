package uz.gita.testapp.domain.useecase

import kotlinx.coroutines.flow.Flow
import uz.gita.testapp.data.remote.responce.ImageResponse

interface MainUseCase {
    fun horizontalImages(): Flow<Result<List<ImageResponse>>>
    fun verticalImages(): Flow<Result<List<ImageResponse>>>
}