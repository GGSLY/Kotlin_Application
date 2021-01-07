package com.example.kotlin_application.injection

import android.content.Context
import androidx.room.Room
import com.example.kotlin_application.data.local.AppDatabase
import com.example.kotlin_application.data.local.DatabaseDAO
import com.example.kotlin_application.data.repository.UserRepository
import com.example.kotlin_application.domain.usecase.CreateUserUseCase
import com.example.kotlin_application.domain.usecase.GetUserUseCase
import com.example.kotlin_application.presentation.main.MainViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val presentationModule = module {

    factory { MainViewModel(get(), get()) }
}

val domainModule = module  {

    factory { CreateUserUseCase(get()) }
    factory { GetUserUseCase(get()) }
}

val dataModule = module {

    single { UserRepository(get()) }
    single { createDataBase(androidContext()) }
}

fun createDataBase(context: Context): DatabaseDAO {
    val appDatabase = Room.databaseBuilder(
        context,
        AppDatabase::class.java, "database-name"
    ).build()
    return appDatabase.databaseDao()

}