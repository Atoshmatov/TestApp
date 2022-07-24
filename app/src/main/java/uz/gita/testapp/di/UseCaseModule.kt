package uz.gita.testapp.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import uz.gita.testapp.domain.useecase.MainUseCase
import uz.gita.testapp.domain.useecase.impl.MainUseCaseImpl

@Module
@InstallIn(ViewModelComponent::class)
interface UseCaseModule {
    @Binds
    fun bindMainUseCase(impl:MainUseCaseImpl):MainUseCase
}