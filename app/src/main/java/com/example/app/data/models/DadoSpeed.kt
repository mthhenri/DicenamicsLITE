package com.example.app.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlin.random.Random

@Entity(tableName = "dadosSpeed")
data class DadoSpeed (
    @PrimaryKey
    var faces : Int = 0,
    var quantidade : Int = 1
){
    constructor() : this(0)

    fun rolarDado() : Int {
        val rolagem = Random.nextInt(1, this.faces + 1)
        return rolagem
    }
}