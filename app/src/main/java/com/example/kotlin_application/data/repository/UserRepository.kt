package com.example.kotlin_application.data.repository

import com.example.kotlin_application.data.local.DatabaseDAO
import com.example.kotlin_application.data.local.models.toData
import com.example.kotlin_application.data.local.models.toEntity
import com.example.kotlin_application.domain.entity.User

class UserRepository(
    private val databaseDAO: DatabaseDAO
) {

    suspend fun createUser(user: User) {
        databaseDAO.insert(user.toData())
    }

    fun getUser(email: String) : User {
        val userLocal = databaseDAO.findByName(email)
        return userLocal.toEntity()
    }
}