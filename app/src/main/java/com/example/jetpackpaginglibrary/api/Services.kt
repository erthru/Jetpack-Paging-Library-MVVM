package com.example.jetpackpaginglibrary.api

import com.example.jetpackpaginglibrary.models.GetUserResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface Services {
    @GET("users")
    fun getUsers(
        @Query("page") page: Int,
        @Query("per_page") itemPerPage: Int
    ) : Call<GetUserResponse>
}