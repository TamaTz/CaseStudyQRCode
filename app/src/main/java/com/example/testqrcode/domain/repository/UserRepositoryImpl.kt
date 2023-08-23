package com.example.testqrcode.domain.repository

import com.example.testqrcode.domain.model.User
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserRepositoryImpl @Inject constructor() : UserRepository {
    private val userFlow: MutableStateFlow<User?> = MutableStateFlow(null)

    override fun getUser(): StateFlow<User?> = userFlow

    // Method to update user data in the repository
    fun updateUser(user: User) {
        userFlow.value = user
    }
}