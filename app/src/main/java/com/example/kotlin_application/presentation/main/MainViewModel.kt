package com.example.kotlin_application.presentation.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kotlin_application.domain.entity.User
import com.example.kotlin_application.domain.usecase.CreateUserUseCase
import com.example.kotlin_application.domain.usecase.GetUserUseCase
import com.example.kotlin_application.presentation.LoginError
import com.example.kotlin_application.presentation.LoginStatus
import com.example.kotlin_application.presentation.LoginSuccess
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel(
    private val createUserUseCase: CreateUserUseCase,
    private val getUserUseCase: GetUserUseCase
) : ViewModel(){

    val loginLiveData : MutableLiveData<LoginStatus> = MutableLiveData()

    fun onClickedLogin(emailUser: String, password: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val user = getUserUseCase.invoke(emailUser)
            val loginStatus = if(user != null){
                LoginSuccess(user.email)
            }else {
                LoginError
            }

            withContext(Dispatchers.Main) {

                loginLiveData.value = loginStatus

            }


        }

    }

}