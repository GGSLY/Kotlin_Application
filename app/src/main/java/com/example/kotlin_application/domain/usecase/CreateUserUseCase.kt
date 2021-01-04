package com.example.kotlin_application.domain.usecase

import com.example.kotlin_application.data.repository.UserRepository
import com.example.kotlin_application.domain.entity.User

class CreateUserUseCase(

    private val  userRepository: UserRepository) {


        suspend fun invoke(user: User) {
            userRepository.createUser(user)
        }

}