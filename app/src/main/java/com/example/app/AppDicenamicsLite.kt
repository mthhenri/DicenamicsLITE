package com.example.app

import android.app.Application
import android.content.Context
import com.example.app.data.dao.DadoSpeedDao
import com.example.app.data.database.BancoSQLite
import com.example.app.data.repository.DadoSpeedRepository
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
    fun provideDadoSpeedRepository(dadoSpeedDao: DadoSpeedDao) : DadoSpeedRepository {
        return DadoSpeedRepository(dadoSpeedDao)
    }

    @Provides
    fun provideDadoSpeedDao(banco : BancoSQLite) : DadoSpeedDao{
        return banco.DadoSpeedDao()
    }

    @Provides
    @Singleton
    fun provideBanco(@ApplicationContext ctx : Context) : BancoSQLite {
        return BancoSQLite.get(ctx)
    }

}