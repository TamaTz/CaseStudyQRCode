package com.example.testqrcode.domain

import com.example.testqrcode.domain.model.User
import com.example.testqrcode.domain.repository.UserRepository
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

class GetUserUseCase @Inject constructor(private val userRepository: UserRepository) {
    val userState: StateFlow<User?> = userRepository.getUser()
}
