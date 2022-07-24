package uz.gita.testapp.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import uz.gita.testapp.domain.repository.MainRepository
import uz.gita.testapp.domain.repository.impl.MainRepositoryImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

    @[Binds Singleton]
    fun bindMainRepository(impl: MainRepositoryImpl): MainRepository
}