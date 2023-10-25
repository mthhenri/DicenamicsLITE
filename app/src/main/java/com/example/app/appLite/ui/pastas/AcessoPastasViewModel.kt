package com.example.app.appLite.ui.pastas

import androidx.lifecycle.ViewModel
import com.example.app.data.repository.PastaRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AcessoPastasViewModel @Inject constructor(val repository: PastaRepository) : ViewModel() {

}