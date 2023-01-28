package com.todokanai.roompractice.repository

import android.util.Log
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import com.todokanai.roompractice.application.MyApplication
import com.todokanai.roompractice.service.MyService.Companion.dataStore
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class DataStoreRepository {
    companion object{
        val DATASTORE_STRING = stringPreferencesKey("datastore_string")
    }
    private val myContext = MyApplication.appContext

    fun save( value: String) {
        CoroutineScope(Dispatchers.IO).launch {
            myContext.dataStore.edit {
                it[DATASTORE_STRING] = value
                Log.d("datastore", "datastore_string insert: $value")
            }
        }
    }

    val dataStoreString: LiveData<String?> = myContext.dataStore.data.map{
        it[DATASTORE_STRING]
    }.asLiveData()
}