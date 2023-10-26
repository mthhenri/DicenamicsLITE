package com.example.app.login

import androidx.lifecycle.ViewModel
import com.example.app.data.repository.UsuarioRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(val repository: UsuarioRepository) : ViewModel() {
    // TODO: Implement the ViewModel
}