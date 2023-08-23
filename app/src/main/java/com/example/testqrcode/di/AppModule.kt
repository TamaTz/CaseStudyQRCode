package com.example.testqrcode.di

import com.example.testqrcode.domain.ReduceBalanceUseCase
import com.example.testqrcode.domain.repository.TransactionRepository
import com.example.testqrcode.domain.repository.TransactionRepositoryImpl
import com.example.testqrcode.domain.repository.UserRepository
import com.example.testqrcode.domain.repository.UserRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

// AppModule.kt (Hilt Module)
@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    fun provideReduceBalanceUseCase(repository: TransactionRepository): ReduceBalanceUseCase {
        return ReduceBalanceUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideTransactionRepository(repository: TransactionRepositoryImpl): TransactionRepository {
        return repository
    }

    @Provides
    @Singleton
    fun provideUserRepository(repository: UserRepositoryImpl): UserRepository {
        return repository
    }
}
