package com.shivaprasad.myapplication.data.api

import com.shivaprasad.myapplication.data.api.API
import com.shivaprasad.myapplication.data.model.ResponceData
import retrofit2.Response

class Repository(var api : API) {

    suspend fun newsdata(): Response<ResponceData.Responce> {
        return api.getData()
    }
}