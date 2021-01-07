package com.example.kotlin_application.domain.usecase

import com.example.kotlin_application.data.repository.UserRepository
import com.example.kotlin_application.domain.entity.User

class GetUserUseCase(
    private val userRepository: UserRepository
) {
    suspend fun invoke(email: String) : User?{
       return userRepository.getUser(email)
    }

}