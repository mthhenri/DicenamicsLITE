package com.example.app.data.models

import androidx.room.Embedded
import androidx.room.Relation

data class ResultadosValores(
    @Embedded val resultado: Resultados,
    @Relation(
        parentColumn = "resultId",
        entityColumn = "resultId"
    )
    val valores: List<Valores>
)
