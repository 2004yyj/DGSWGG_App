package kr.hs.dgsw.data.network.base

import com.google.gson.Gson
import kr.hs.dgsw.data.entity.NetworkResponse
import retrofit2.Response

interface Request {
    fun <T> getResponse(response: Response<NetworkResponse<T>>): T {
        checkError(response)
        return response.body()?.data!!
    }

    fun <T> getMessage(response: Response<NetworkResponse<T>>): String {
        checkError(response)
        return response.body()?.message!!
    }

    private fun <T> checkError(response: Response<NetworkResponse<T>>) {
        if (!response.isSuccessful) {
            val errorBody = Gson().fromJson(response.errorBody()?.charStream(), NetworkResponse::class.java)
            throw Throwable(errorBody.message)
        }
    }
}