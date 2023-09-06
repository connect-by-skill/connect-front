package com.example.presentation.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.LoginTokenData
import com.example.domain.model.state.LoginState
import com.example.domain.usecase.LoginUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val loginUseCase: LoginUseCase): ViewModel() {

    private val _id = MutableLiveData("")
    val id : LiveData<String> = _id

    private val _pw = MutableLiveData("")
    val pw : LiveData<String> = _pw

    fun setId(text : String){
        _id.value = text
    }

    fun setPw(text : String){
        _pw.value = text
    }

    suspend fun login() : LoginState {
        return loginUseCase.login(_id.value ?: "", _pw.value ?: "")
    }

    fun saveToken(context: Context) {
        viewModelScope.launch {
            val sharedPreferences = context.getSharedPreferences("Token", Context.MODE_PRIVATE)
            val editor = sharedPreferences.edit()
            editor.putString("atk", LoginTokenData.atk)
            editor.putString("rtk", LoginTokenData.rtk)
            editor.apply()
        }
    }
}