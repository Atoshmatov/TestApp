package uz.gita.testapp.di

import android.content.Context
import com.mocklets.pluto.PlutoInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import uz.gita.testapp.BuildConfig.BASE_URL
import uz.gita.testapp.data.SharedPref
import uz.gita.testapp.data.remote.MainApi
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class MainModule {

    @[Provides Singleton]
    fun okHTTPClientObject(
        @ApplicationContext context: Context
    ): OkHttpClient =
        OkHttpClient.Builder()
            .addInterceptor(PlutoInterceptor())
            .build()

    @[Provides Singleton]
    fun getRetrofitObject(okHttpClient: OkHttpClient): Retrofit =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()

    @[Provides Singleton]
    fun getMainApi(retrofit: Retrofit): MainApi = retrofit.create(MainApi::class.java)

    @[Provides Singleton]
    fun getSharedPref(@ApplicationContext context: Context): SharedPref =
        SharedPref(context)

}