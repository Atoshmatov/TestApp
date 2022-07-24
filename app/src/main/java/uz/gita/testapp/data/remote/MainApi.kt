package uz.gita.testapp.data.remote

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import uz.gita.testapp.data.remote.responce.ImageResponse


interface MainApi {
    @GET("v2/list")
    suspend fun getImages(
        @Query("page") page: Int,
        @Query("limit") limit: Int
    ): Response<List<ImageResponse>>
}