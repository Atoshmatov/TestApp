package uz.gita.testapp.domain.useecase.impl

import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import uz.gita.testapp.data.comman.model.ErrorMessage
import uz.gita.testapp.data.remote.responce.ImageResponse
import uz.gita.testapp.domain.repository.MainRepository
import uz.gita.testapp.domain.useecase.MainUseCase
import javax.inject.Inject

class MainUseCaseImpl
@Inject constructor(
    private val main: MainRepository,
    private val gson: Gson
) : MainUseCase {
    override fun horizontalImages(): Flow<Result<List<ImageResponse>>> =
        flow<Result<List<ImageResponse>>> {
            val response = main.getHorizontalImages()
            if (response.isSuccessful) {
                response.body()?.let { result ->
                    emit(Result.success(result.shuffled()))
                }
            } else {
                var error = ErrorMessage(406, "Unknown error")
                response.errorBody()?.string()?.let {
                    error = gson.fromJson(it, ErrorMessage::class.java)
                }
                emit(Result.failure(Exception(error.message)))
            }
        }.catch {
            emit(Result.failure(Exception(it)))
        }.flowOn(Dispatchers.IO)

    override fun verticalImages(): Flow<Result<List<ImageResponse>>> =
        flow<Result<List<ImageResponse>>> {
            val response = main.getVerticalImages()
            if (response.isSuccessful) {
                response.body()?.let { result ->
                    emit(Result.success(result.shuffled()))
                }
            } else {
                var error = ErrorMessage(406, "Unknown error")
                response.errorBody()?.string()?.let {
                    error = gson.fromJson(it, ErrorMessage::class.java)
                }
                emit(Result.failure(Exception(error.message)))
            }
        }.catch {
            emit(Result.failure(Exception(it)))
        }.flowOn(Dispatchers.IO)
}