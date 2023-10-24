package com.example.app.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlin.random.Random

@Entity(tableName = "dados")
data class Dado (
    @PrimaryKey(autoGenerate = true)
    var id : Int = 0,
    var icon : String = "",
    var nome : String = "",
    var faces : Int = 0,
    var quantidade : Int = 0,
    var modificador : String = ""
){
    constructor() : this(0,"dados_icon.png","",2,1,"")

    fun rolarDado() : List<Int> {
        val resultados = mutableListOf<Int>()

        repeat(this.quantidade){
            val rolagem = Random.nextInt(1, this.faces + 1)
            resultados.add(rolagem);
        }
        val mod = splitString(this.modificador)
        if(modificador != "" && mod != null){
            val (operador, valor) = mod

            for(i in resultados.indices){
                when(operador){
                    "+" -> resultados[i] + valor
                    "-" -> resultados[i] - valor
                    "*" -> resultados[i] * valor
                    "/" -> resultados[i] / valor
                }
            }

        }

        return resultados
    }

    fun splitString(input: String): Pair<String, Int>? {
        val partes = input.trim().split(" ")

        if (partes.size == 2) {
            val operador = partes[0]
            val numero = partes[1].toIntOrNull() ?: 0
            return operador to numero
        }

        return null
    }
}