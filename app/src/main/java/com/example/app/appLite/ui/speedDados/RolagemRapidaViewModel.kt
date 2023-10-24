package com.example.app.appLite.ui.speedDados

import androidx.lifecycle.ViewModel
import com.example.app.data.repository.DadoSpeedRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RolagemRapidaViewModel @Inject constructor(val repository: DadoSpeedRepository) : ViewModel() {
    // TODO: Implement the ViewModel
}