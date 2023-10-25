package com.example.app.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Valores(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val resultId: Int, // Chave estrangeira para associar a tabela de resultados
    val valor: Int // Valor inteiro associado a um resultado
)
