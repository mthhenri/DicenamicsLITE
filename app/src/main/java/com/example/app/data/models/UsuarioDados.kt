package com.example.app.data.models

import androidx.room.Embedded
import androidx.room.Relation

data class UsuarioDados(
    @Embedded val usuario: Usuario,
    @Relation(
        parentColumn = "userId",
        entityColumn = "usuarioDadosId"
    )
    val dados: List<Dado>
)
