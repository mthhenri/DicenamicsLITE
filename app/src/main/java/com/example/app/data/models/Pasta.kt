package com.example.app.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "pastas")
data class Pasta (
    @PrimaryKey(autoGenerate = true)
    var id : Int = 0,
    var nome : String = "",
    var cor : String = "",
    var dados : MutableList<Dado> = mutableListOf()
){
    constructor() : this(0,"","#FFFFFF")
}