package com.example.jetpackpaginglibrary.datasource

import androidx.lifecycle.MutableLiveData
import androidx.paging.PageKeyedDataSource
import com.example.jetpackpaginglibrary.api.Client
import com.example.jetpackpaginglibrary.models.GetUserResponse
import com.example.jetpackpaginglibrary.models.User
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UsersDataSource : PageKeyedDataSource<Int, User>(){

    override fun loadInitial(params: LoadInitialParams<Int>, callback: LoadInitialCallback<Int, User>) {
        Client.prepare().getUsers(1, params.requestedLoadSize).enqueue(object: Callback<GetUserResponse>{
            override fun onFailure(call: Call<GetUserResponse>, t: Throwable) {}

            override fun onResponse(call: Call<GetUserResponse>, response: Response<GetUserResponse>) {
                callback.onResult(response.body()!!.data, null, 2)
            }
        })
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, User>) {
        Client.prepare().getUsers(params.key, params.requestedLoadSize).enqueue(object: Callback<GetUserResponse>{
            override fun onFailure(call: Call<GetUserResponse>, t: Throwable) {}

            override fun onResponse(call: Call<GetUserResponse>, response: Response<GetUserResponse>) {
                callback.onResult(response.body()!!.data, params.key + 1)
            }
        })
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, User>) {}
}