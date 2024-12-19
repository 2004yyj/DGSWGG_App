package kr.hs.dgsw.data.network.service

import kr.hs.dgsw.data.entity.NetworkResponse
import kr.hs.dgsw.data.entity.summoner.SummonerData
import retrofit2.Response
import retrofit2.http.*

interface SummonerService {
    @FormUrlEncoded
    @POST("/summoner")
    suspend fun postRefreshSummonerInfo(
        @Field("grade") grade: Int,
        @Field("klass") klass: Int,
        @Field("number") number: Int,
        @Field("name") name: String,
        @Field("summonerName") summonerName: String
    ): Response<NetworkResponse<Any?>>

    @GET("/summoner/{summonerName}")
    suspend fun getSummonerByName(@Path("summonerName") summonerName: String): Response<NetworkResponse<SummonerData>>
}