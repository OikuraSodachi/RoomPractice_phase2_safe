package com.todokanai.roompractice.service

import android.app.Service
import android.content.Context
import android.content.Intent
import android.os.IBinder
import android.util.Log
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import com.todokanai.roompractice.room.User
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MyService : Service() {

    companion object{
       val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "mydatastore")
       var result : String  = "null found"
    }

    override fun onBind(p0: Intent?): IBinder? {
        TODO("Not yet implemented")
    }

    override fun onCreate() {
        super.onCreate()
        Log.d("service","onCreate")
    }
}