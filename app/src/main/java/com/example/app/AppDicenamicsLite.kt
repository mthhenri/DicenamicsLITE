package com.example.app

import android.app.Application
import android.content.Context
import com.example.app.data.dao.DadoDao
import com.example.app.data.dao.DadoSpeedDao
import com.example.app.data.dao.PastaDao
import com.example.app.data.dao.UsuarioDao
import com.example.app.data.database.BancoSQLite
import com.example.app.data.repository.DadoRepository
import com.example.app.data.repository.DadoSpeedRepository
import com.example.app.data.repository.PastaRepository
import com.example.app.data.repository.UsuarioRepository
import com.example.app.data.repositorySqlite.DadoRepositorySqlite
import com.example.app.data.repositorySqlite.DadoSpeedRepositorySqlite
import com.example.app.data.repositorySqlite.PastaRepositorySqlite
import com.example.app.data.repositorySqlite.UsuarioRepositorySqlite
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@HiltAndroidApp
@InstallIn(SingletonComponent::class)
class AppDicenamicsLite : Application() {

    @Provides
    fun provideDadoSpeedRepository(dadoSpeedDao: DadoSpeedDao) : DadoSpeedRepositorySqlite {
        return DadoSpeedRepositorySqlite(dadoSpeedDao)
    }

    @Provides
    fun providesDadoRepository(dadoDao: DadoDao) : DadoRepositorySqlite {
        return DadoRepositorySqlite(dadoDao)
    }

    @Provides
    fun providesUsuarioRepository(usuarioDao: UsuarioDao) : UsuarioRepositorySqlite {
        return UsuarioRepositorySqlite(usuarioDao)
    }

    @Provides
    fun providePastaRepository(pastaDao: PastaDao) : PastaRepositorySqlite {
        return PastaRepositorySqlite(pastaDao)
    }

    @Provides
    fun provideDadoSpeedDao(banco : BancoSQLite) : DadoSpeedDao{
        return banco.DadoSpeedDao()
    }

    @Provides
    fun provideDadoDao(banco : BancoSQLite) : DadoDao {
        return banco.DadoDao()
    }

    @Provides
    fun provideUsuarioDao(banco : BancoSQLite) : UsuarioDao {
        return  banco.UsuarioDao()
    }

    @Provides
    fun providePastaDao(banco : BancoSQLite) : PastaDao {
        return banco.PastaDao()
    }

    @Provides
    @Singleton
    fun provideBanco(@ApplicationContext ctx : Context) : BancoSQLite {
        return BancoSQLite.get(ctx)
    }

}