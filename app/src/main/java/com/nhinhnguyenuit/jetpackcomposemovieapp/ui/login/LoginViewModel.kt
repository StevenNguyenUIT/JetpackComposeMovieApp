package com.nhinhnguyenuit.jetpackcomposemovieapp.ui.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.HiltAndroidApp
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() {
    private val _isLoggedIn = MutableStateFlow(false)
    val isLoggedIn: StateFlow<Boolean> = _isLoggedIn

    fun login(userName: String, password: String){
        viewModelScope.launch {
            //Logic xu ly login
            _isLoggedIn.value = true
        }
    }

    fun logout(){
        viewModelScope.launch {
            _isLoggedIn.value = false
        }
    }
}