package com.example.jetpackpaginglibrary.datasource

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.example.jetpackpaginglibrary.models.User

class UsersDataSourceFactory : DataSource.Factory<Int, User>(){
    val usersLiveDataSource = MutableLiveData<UsersDataSource>()

    override fun create(): DataSource<Int, User> {
        val usersDataSource = UsersDataSource()
        usersLiveDataSource.postValue(usersDataSource)
        return usersDataSource
    }
}