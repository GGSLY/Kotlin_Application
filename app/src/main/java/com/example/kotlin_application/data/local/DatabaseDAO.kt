package com.example.kotlin_application.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.kotlin_application.data.local.models.UserLocal

@Dao
interface DatabaseDAO {
    @Query("SELECT * FROM userlocal")
    fun getAll(): List<UserLocal>


    @Query("SELECT * FROM userlocal WHERE email LIKE :email LIMIT 1")
    fun findByName(email: String): UserLocal?

    @Insert
    fun insert(user: UserLocal)

    @Delete
    fun delete(user: UserLocal)
}
