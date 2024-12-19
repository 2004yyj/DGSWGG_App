package kr.hs.dgsw.data.database.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import kr.hs.dgsw.data.database.dao.SearchDao
import kr.hs.dgsw.data.entity.SearchData

class SearchPagingSource(
    private val dao: SearchDao
): PagingSource<Int, SearchData>() {
    override fun getRefreshKey(state: PagingState<Int, SearchData>): Int? {
        return state.anchorPosition?.let { anchorPos ->
            state.closestPageToPosition(anchorPos)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPos)?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, SearchData> {
        val position = params.key ?: 0
        val loadData = dao.getAll(params.loadSize, position)

        return LoadResult.Page(
            data = loadData,
            prevKey = if (position == 0) null else position - 1,
            nextKey = if (position == loadData.size) null else position + 1
        )
    }
}