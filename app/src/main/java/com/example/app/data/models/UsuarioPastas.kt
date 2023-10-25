package com.example.app.data.models

import androidx.room.Embedded
import androidx.room.Relation

data class UsuarioPastas (
    @Embedded val usuario: Usuario,
    @Relation(
        parentColumn = "userId",
        entityColumn = "usuarioPastasId"
    )
    val pastas: List<Pasta>
)