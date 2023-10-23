package com.example.app.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "usuarios")
data class Usuario (
    @PrimaryKey(autoGenerate = true)
    var id : Int = 0,
    var username : String = "",
    var apelido : String = "",
    var senha : String = "",
    var imgPerfil : String = "",
    var pastas : MutableList<Pasta> = mutableListOf(),
    var dados : MutableList<Dado> = mutableListOf()
){
    constructor() : this(0,"","","","sem_foto.png")
}