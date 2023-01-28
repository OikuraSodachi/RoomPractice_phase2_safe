package com.todokanai.roompractice.viewmodel

import android.util.Log
import androidx.lifecycle.*
import com.todokanai.roompractice.repository.DataStoreRepository
import com.todokanai.roompractice.repository.UserRepository
import com.todokanai.roompractice.room.User
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.*
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val userRepository: UserRepository) : ViewModel() {

    private val dataStoreRepository = DataStoreRepository()
    private val userList = mutableListOf<User>()

    suspend fun indexedValue(index:Long) = withContext(Dispatchers.Default){ userRepository.getUserByIndex(index) }

    val testValue = MutableLiveData<List<User>>()

    val firstVal = userRepository.getUserByIndex(1).asLiveData()       // Dao에서 @Query getFirst()에 해당

    val allUser = userRepository.getUsers()


    fun testFunction(){
        viewModelScope.launch {
            userRepository.getUsersTest().collect() {
                testValue.value = it
                println("${testValue.value}")
            }
            println("after Collect: ${testValue.value}")
        }
       println("outOf Scope: ${testValue.value}")

    }


    fun tester() {
        viewModelScope.launch {
            allUser.collect(){
                userList.addAll(it)
                withContext(Dispatchers.Main){
                    Log.d("oikura","inside: $userList")
                    Log.d("oikura","pos: $coroutineContext")
                }
            }
            withContext(Dispatchers.Main){     Log.d("oikura","outside: $allUser")}
        }
        Log.d("oikura","outsideofViewModelScope: $userList")
    }

    fun insert(user: User) = userRepository.insert(user)

    fun deleteAll() = userRepository.deleteAll()

    fun dataStoreSave(value:String) = dataStoreRepository.save(value)

    // return 값이 있을경우 viewModel 단계에서 val 취급하기
}