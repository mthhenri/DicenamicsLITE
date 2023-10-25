package com.example.app.data.models

import androidx.room.Embedded
import androidx.room.Relation

data class PastaDados(
    @Embedded val pasta: Pasta,
    @Relation(
        parentColumn = "pastaId",
        entityColumn = "pastaId"
    )
    val dados: List<Dado>
)
