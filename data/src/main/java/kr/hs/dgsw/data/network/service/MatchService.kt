package kr.hs.dgsw.data.network.service

import kr.hs.dgsw.data.entity.NetworkResponse
import kr.hs.dgsw.data.entity.match_overview.MatchOverviewData
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MatchService {
    @GET("/match")
    suspend fun getAllMatch(
        @Query("size") size: Int,
        @Query("page") page: Int,
        @Query("summonerId") summonerId: String
    ): Response<NetworkResponse<List<MatchOverviewData>>>
}