package kr.hs.dgsw.data.network.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import kr.hs.dgsw.data.entity.match_overview.MatchOverviewData
import kr.hs.dgsw.data.network.base.Request
import kr.hs.dgsw.data.network.service.MatchService

class MatchPagingSource(
    private val summonerId: String,
    val service: MatchService,
): PagingSource<Int, MatchOverviewData>(), Request {

    override fun getRefreshKey(state: PagingState<Int, MatchOverviewData>): Int? {
        return state.anchorPosition?.let { anchorPos ->
            state.closestPageToPosition(anchorPos)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPos)?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, MatchOverviewData> {
        val position = params.key ?: 0
        val loadData = getResponse(service.getAllMatch(params.loadSize, position, summonerId))

        return LoadResult.Page(
            data = loadData,
            prevKey = if (position == 0) null else position - 1,
            nextKey = if (position == loadData.size) null else position + 1
        )
    }
}