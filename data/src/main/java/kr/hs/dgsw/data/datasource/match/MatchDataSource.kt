package kr.hs.dgsw.data.datasource.match

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import kr.hs.dgsw.data.entity.match_overview.MatchOverviewData
import kr.hs.dgsw.data.network.remote.MatchRemote
import javax.inject.Inject

class MatchDataSource @Inject constructor(
    val remote: MatchRemote
) {
    fun getAllMatch(
        size: Int,
        summonerId: String
    ): Flow<PagingData<MatchOverviewData>> {
        return remote.getAllMatch(size, summonerId)
    }
}