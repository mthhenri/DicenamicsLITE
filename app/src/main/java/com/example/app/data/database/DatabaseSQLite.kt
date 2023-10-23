package com.example.app.data.database

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.app.data.dao.DadoDao
import com.example.app.data.dao.DadoSpeedDao
import com.example.app.data.dao.PastaDao
import com.example.app.data.dao.UsuarioDao

abstract class BancoSQLite : RoomDatabase(){
        abstract fun DadoDao() : DadoDao
        abstract fun UsuarioDao() : UsuarioDao
        abstract fun PastaDao() : PastaDao
        abstract fun DadoSpeedDao() : DadoSpeedDao
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