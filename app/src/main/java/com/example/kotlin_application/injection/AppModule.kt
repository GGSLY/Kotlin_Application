package com.example.kotlin_application.injection

import com.example.kotlin_application.MainViewModel
import org.koin.dsl.module

val presentationModule = module {

    factory { MainViewModel() }
}