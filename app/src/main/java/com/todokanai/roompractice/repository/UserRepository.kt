package com.todokanai.roompractice.repository

import android.util.Log
import androidx.lifecycle.asLiveData
import com.todokanai.roompractice.room.User
import com.todokanai.roompractice.room.UserDao
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserRepository @Inject constructor(private val userDao: UserDao) {

    fun getUsers() = userDao.getAllAsFlow()

    suspend fun getUsersTest() =withContext(Dispatchers.IO){userDao.getAllAsFlow()}

    fun getUsersNonFlow() = userDao.getAll()

    fun getUserByIndex(index:Long) = userDao.getUserByIndex(index)

    fun insert(user : User){
        CoroutineScope(Dispatchers.IO).launch {
            userDao.insert(user)
        }
    }

    fun delete(user : User){
        CoroutineScope(Dispatchers.IO).launch {
            userDao.delete(user)
        }
    }

    fun deleteAll(){
        CoroutineScope(Dispatchers.IO).launch {
            userDao.deleteAll()
        }
    }
}