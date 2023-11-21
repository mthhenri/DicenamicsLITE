package com.example.app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.navigation.ui.AppBarConfiguration
import com.example.app.appLite.ui.dados.DadosViewModel
import com.example.app.appLite.ui.speedDados.RolagemRapidaViewModel
import com.example.app.databinding.ActivityMainBinding
import com.google.firebase.FirebaseApp
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val viewModelRR : RolagemRapidaViewModel by viewModels()
        val viewModelD : DadosViewModel by viewModels()

        fun db(){
               FirebaseApp.initializeApp(this)
        }
    }
}