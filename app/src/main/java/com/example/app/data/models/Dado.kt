package com.example.app.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlin.random.Random

@Entity(tableName = "dados")
data class Dado (
    @PrimaryKey(autoGenerate = true)
    var dadoId : Int = 0,
    var icon : String = "",
    var nome : String = "",
    var faces : Int = 0,
    var quantidade : Int = 0,
    var modificador : String = "",
    var pastaId : Int = 0,
    var usuarioDadosId : Long = 0
){
    constructor() : this(0,"","",2,1,"")

    fun rolarDado() : List<Int> {
        val resultados = mutableListOf<Int>()
        val mod = splitString(this.modificador)

        repeat(this.quantidade){
            var rolagem = Random.nextInt(1, this.faces + 1)
            if(mod != null){
                val (operador, valor) = mod
                when(operador){
                    "+" -> rolagem += valor
                    "-" -> rolagem -= valor
                    "*" -> rolagem *= valor
                    "/" -> rolagem /= valor
                }
            } else {
                rolagem -= 1000
            }
            resultados.add(rolagem);
        }
//        if(mod != null){
//            val (operador, valor) = mod
//
//            for(i in resultados.indices){
//                when(operador){
//                    "+" -> resultados[i] += valor
//                    "-" -> resultados[i] -= valor
//                    "*" -> resultados[i] *= valor
//                    "/" -> resultados[i] /= valor
//                }
//            }
//        }

        return resultados
    }

    fun splitString(input: String): Pair<String, Int>? {
        val operadores = listOf("+", "-", "*", "/")
        val partes = operadores.find { input.contains(it) }

        if (partes != null) {
            val operador = partes
            val numero = input.substringAfter(partes).trim().toIntOrNull()

            if (numero != null) {
                return operador to numero
            }
        }

        return null
    }
}