package com.example.app.data.models

import com.example.app.R

class Icons {
    companion object{
        fun get(key : String) : Int {
            val mapOfIcons = mapOf(
                "dados icone 1" to R.drawable.d10_dois_icone,
                "dados icone 2" to R.drawable.d10_icone,
                "dados icone 3" to R.drawable.d20_icone,
                "dados icone 4" to R.drawable.d6_icone,
                "dados icone 5" to R.drawable.dadinho_icone,
                "dados icone 6" to R.drawable.dado,
                "dados icone 7" to R.drawable.dado_icone,
                "dados icone 8" to R.drawable.dados_cubos,
                "dados icone 9" to R.drawable.dados_empilhado_icon,
                "dados icone 10" to R.drawable.dados_icon,
                "dados icone 11" to R.drawable.dados_pilha,
                "dados icone 12" to R.drawable.tres_dados,
                "dados icone 13" to R.drawable.numeros_icone
            )
            return mapOfIcons[key] ?: R.drawable.dados_icon
        }
    }
}