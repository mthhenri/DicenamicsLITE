package com.example.app

import android.app.Application
import android.content.Context
import com.example.app.data.dao.DadoDao
import com.example.app.data.dao.DadoSpeedDao
import com.example.app.data.dao.PastaDao
import com.example.app.data.dao.UsuarioDao
import com.example.app.data.database.BancoSQLite
import com.example.app.data.models.DadoSpeed
import com.example.app.data.repository.DadoRepository
import com.example.app.data.repository.DadoSpeedRepository
import com.example.app.data.repository.PastaRepository
import com.example.app.data.repository.UsuarioRepository
import com.example.app.data.repositorySqlite.DadoRepositorySqlite
import com.example.app.data.repositorySqlite.DadoSpeedRepositorySqlite
import com.example.app.data.repositorySqlite.PastaRepositorySqlite
import com.example.app.data.repositorySqlite.UsuarioRepositorySqlite
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.firestoreSettings
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
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
    fun provideDadoSpeedRepository() : CollectionReference {

        val firestore = Firebase.firestore
        val settings = firestoreSettings {
            this.isPersistenceEnabled = false
        }
        firestore.firestoreSettings = settings

        return firestore.collection("DadoSpeed")
    }

    @Provides
    fun providesDadoRepository() : CollectionReference {

        val firestore = Firebase.firestore
        val settings = firestoreSettings {
            this.isPersistenceEnabled = false
        }
        firestore.firestoreSettings = settings

        return firestore.collection("Dado")
    }

    @Provides
    fun providesUsuarioRepository() : CollectionReference {
        val firestore = Firebase.firestore
        val settings = firestoreSettings {
            this.isPersistenceEnabled = false
        }
        firestore.firestoreSettings = settings

        return firestore.collection("Usuario")
    }

    @Provides
    fun providePastaRepository() : CollectionReference {
        val firestore = Firebase.firestore
        val settings = firestoreSettings {
            this.isPersistenceEnabled = false
        }
        firestore.firestoreSettings = settings

        return firestore.collection("Pasta")
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