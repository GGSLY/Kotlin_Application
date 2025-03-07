package com.example.kotlin_application.data.local.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.kotlin_application.domain.entity.User

@Entity
data class UserLocal(

    @ColumnInfo(name = "email") val email: String
){
    @PrimaryKey(autoGenerate = true) var uid: Int? = null
}

fun User.toData() : UserLocal {
    return UserLocal(
        email = email
    )
}

fun UserLocal.toEntity() : User {
    return User(
        email = email
    )
}