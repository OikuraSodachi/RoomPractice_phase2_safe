package com.todokanai.roompractice.retrofit

import android.util.Log
import com.todokanai.roompractice.retrofit.myresponse.MyRetrofit
import com.todokanai.roompractice.retrofit.myresponse.MyRetrofitService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RetrofitControl {
    /*

    fun getFromNet() : Flow<List<Answer>> {
        val result = mutableListOf<Answer>()
        val myRetrofitService = MyRetrofit.retrofit.create(MyRetrofitService::class.java)

        myRetrofitService.getResponse().enqueue(object : Callback<MyRetrofitRepository> {
            override fun onFailure(call: Call<MyRetrofitRepository>, t: Throwable) {
                Log.d("busRetrofitTest", "onFailure:  $t")
            }
            override fun onResponse(
                call: Call<MyRetrofitRepository>,
                response: Response<MyRetrofitRepository>
            ) {
                val number = response.body()!!.response.body.totalCount
                for (index in 0..number - 1) {
                    result.add(response.body()!!.response.body.items.item[index])
                }
            }
        })
        return flowOf(result)
    }

     */
}