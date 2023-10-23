package com.example.app.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "dadosSpeed")
data class DadoSpeed (
    @PrimaryKey
    var faces : Int = 0,
    var quantidade : Int = 0
){
    constructor() : this(0,0)
}