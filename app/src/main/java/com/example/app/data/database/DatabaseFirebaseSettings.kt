package com.example.app.data.database

import com.google.firebase.database.ktx.database
import com.google.firebase.firestore.firestoreSettings
import com.google.firebase.ktx.Firebase
import com.example.app.MainActivity.db
import com.google.firebase.FirebaseApp
import com.google.firebase.firestore.ktx.firestore

class DatabaseFirebaseSettings {

    val settings = firestoreSettings {
        Firebase.database.setPersistenceEnabled(false)
    }
    val db = MainActivity.db
}


