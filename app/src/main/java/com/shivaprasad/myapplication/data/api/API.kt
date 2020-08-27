package com.shivaprasad.myapplication.data.api

import com.shivaprasad.myapplication.data.model.ResponceData
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Streaming
import java.util.concurrent.TimeUnit


interface API {

    @Streaming
    @GET("search?term=all")
    suspend fun getData(): Response<ResponceData.Responce>

    companion object{
        operator fun invoke(): API {


            val logging = HttpLoggingInterceptor()
            logging.setLevel(HttpLoggingInterceptor.Level.BODY)
            val  clint: OkHttpClient= OkHttpClient().newBuilder()
                .connectTimeout(500, TimeUnit.MILLISECONDS)
                .readTimeout(500, TimeUnit.MILLISECONDS)
                .addInterceptor(logging)
                .build()

            return Retrofit.Builder()
                .baseUrl("https://itunes.apple.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(clint)
                .build()
                .create(API::class.java)
        }
    }





}