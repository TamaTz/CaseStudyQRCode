package com.example.testqrcode.domain.repository

import com.example.testqrcode.domain.model.User
import kotlinx.coroutines.flow.StateFlow

interface UserRepository {
    fun getUser(): StateFlow<User?>
}