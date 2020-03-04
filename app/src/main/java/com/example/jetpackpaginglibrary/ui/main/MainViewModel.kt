package com.example.jetpackpaginglibrary.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.example.jetpackpaginglibrary.datasource.UsersDataSource
import com.example.jetpackpaginglibrary.datasource.UsersDataSourceFactory
import com.example.jetpackpaginglibrary.models.User

class MainViewModel : ViewModel(){
    var userPagedList: LiveData<PagedList<User>>

    init{
        val usersDataSourceFactory = UsersDataSourceFactory()

        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setPageSize(3)
            .setInitialLoadSizeHint(3)
            .build()

        userPagedList = LivePagedListBuilder(usersDataSourceFactory, config).build()
    }
}