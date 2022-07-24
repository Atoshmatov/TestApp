package uz.gita.testapp.domain.repository

import retrofit2.Response
import uz.gita.testapp.data.remote.responce.ImageResponse

interface MainRepository {
    suspend fun getVerticalImages(): Response<List<ImageResponse>>
    suspend fun getHorizontalImages(): Response<List<ImageResponse>>
}