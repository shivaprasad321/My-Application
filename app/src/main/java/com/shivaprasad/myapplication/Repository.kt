package com.shivaprasad.myapplication

import retrofit2.Response

class Repository(var api : API) {

    suspend fun newsdata(): Response<ResponceData.Responce> {
        return api.getData()
    }
}