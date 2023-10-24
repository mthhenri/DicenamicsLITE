package com.example.app.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "resultados")
data class Resultados(
    @PrimaryKey(autoGenerate = true)
    val id : Int,
    val ultimosResultados : List<Int>
){
    constructor() : this(0, mutableListOf<Int>())
}
