package com.example.app.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Relation

@Entity(tableName = "pastas")
data class Pasta (
    @PrimaryKey(autoGenerate = true)
    var pastaId : Long = 0,
    var nome : String = "",
    var cor : String = "",
    var usuarioPastaId : Long = 0
){
    constructor() : this(0,"","#FFFFFF")
}