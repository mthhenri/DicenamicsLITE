package com.example.app.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.app.data.dao.DadoDao
import com.example.app.data.dao.DadoSpeedDao
import com.example.app.data.dao.PastaDao
import com.example.app.data.dao.ResultadosDao
import com.example.app.data.dao.UsuarioDao
import com.example.app.data.models.Dado
import com.example.app.data.models.DadoSpeed
import com.example.app.data.models.Pasta
import com.example.app.data.models.Resultados
import com.example.app.data.models.Usuario
import com.example.app.data.models.Valores

@Database(entities = [Dado::class, DadoSpeed::class, Pasta::class, Usuario::class, Resultados::class, Valores::class], version = 1, exportSchema = false)
abstract class BancoSQLite : RoomDatabase(){
        abstract fun DadoDao() : DadoDao
        abstract fun UsuarioDao() : UsuarioDao
        abstract fun PastaDao() : PastaDao
        abstract fun DadoSpeedDao() : DadoSpeedDao
        abstract fun ResultadosDao() : ResultadosDao
        companion object {
            @Volatile
            private var BANCO: BancoSQLite? = null

            fun get(context: Context) : BancoSQLite{
                if(BANCO == null){
                    BANCO = Room.databaseBuilder(
                        context.applicationContext,
                        BancoSQLite::class.java,
                        "bancoDados.db"
                    ).build()
                }
                return BANCO as BancoSQLite
            }

        }
}