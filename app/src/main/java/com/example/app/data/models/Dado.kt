package com.example.app.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "dados")
data class Dado (
    @PrimaryKey(autoGenerate = true)
    var id : Int = 0,
    var icon : String = "",
    var nome : String = "",
    var faces : Int = 0,
    var quatidade : Int = 0,
    var modificador : String = ""
){
    constructor() : this(0,"dados_icon.png","",2,1,"")
}