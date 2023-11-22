package com.example.app.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.app.data.dao.DadoDao
import com.example.app.data.dao.DadoSpeedDao
import com.example.app.data.dao.PastaDao
import com.example.app.data.dao.ResultadosDao
import com.example.app.data.dao.UsuarioDao
import com.example.app.data.dao.ValoresDao
import com.example.app.data.models.Dado
import com.example.app.data.models.DadoSpeed
import com.example.app.data.models.Pasta
import com.example.app.data.models.Resultados
import com.example.app.data.models.Usuario
import com.example.app.data.models.Valores

@Database(entities = [Dado::class, DadoSpeed::class, Pasta::class, Usuario::class, Resultados::class, Valores::class], version = 2, exportSchema = false)
abstract class BancoSQLite : RoomDatabase(){
        abstract fun DadoDao() : DadoDao
        abstract fun UsuarioDao() : UsuarioDao
        abstract fun PastaDao() : PastaDao
        abstract fun DadoSpeedDao() : DadoSpeedDao
        abstract fun ResultadosDao() : ResultadosDao
        abstract fun ValoresDao(): ValoresDao
        companion object {
            @Volatile
             var BANCO: BancoSQLite? = null

            val Migration_1_2 = object : Migration(1, 2) {
                override fun migrate(database: SupportSQLiteDatabase) {
                    // Adicione a lógica de migração aqui, por exemplo, crie a tabela Valores
                    database.execSQL("CREATE TABLE IF NOT EXISTS `Valores` (`id` INTEGER PRIMARY KEY AUTOINCREMENT, `valor` REAL)")
                }
            }

            fun get(context: Context) : BancoSQLite{
                if(BANCO == null){
                    BANCO = Room.databaseBuilder(
                        context.applicationContext,
                        BancoSQLite::class.java,
                        "bancoDados.db"
                    ).addMigrations(Migration_1_2).build()
                }
                return BANCO as BancoSQLite
            }

        }

}