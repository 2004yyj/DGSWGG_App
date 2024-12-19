package kr.hs.dgsw.data.network.remote

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import kr.hs.dgsw.data.entity.match_overview.MatchOverviewData
import kr.hs.dgsw.data.network.base.BaseRemote
import kr.hs.dgsw.data.network.paging.MatchPagingSource
import kr.hs.dgsw.data.network.service.MatchService
import javax.inject.Inject

class MatchRemote @Inject constructor(
    override val service: MatchService
): BaseRemote<MatchService>() {
    fun getAllMatch(
        size: Int,
        summonerId: String
    ): Flow<PagingData<MatchOverviewData>> {
        return Pager(
            config = PagingConfig(
                pageSize = size,
                initialLoadSize = size,
                enablePlaceholders = false
            ), pagingSourceFactory = { MatchPagingSource(summonerId, service) }
        ).flow
    }
}