package uz.gita.testapp.domain.repository.impl

import retrofit2.Response
import uz.gita.testapp.data.remote.MainApi
import uz.gita.testapp.data.remote.responce.ImageResponse
import uz.gita.testapp.domain.repository.MainRepository
import javax.inject.Inject


class MainRepositoryImpl
@Inject constructor(
    private val mainApi: MainApi
) : MainRepository {
    override suspend fun getVerticalImages(): Response<List<ImageResponse>> {
        return mainApi.getImages(1, 50)
    }

    override suspend fun getHorizontalImages(): Response<List<ImageResponse>> {
        return mainApi.getImages(1, 50)
    }
}