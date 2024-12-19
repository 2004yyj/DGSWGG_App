package kr.hs.dgsw.data.database.cache

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kr.hs.dgsw.data.database.base.BaseCache
import kr.hs.dgsw.data.database.dao.SearchDao
import kr.hs.dgsw.data.database.paging.SearchPagingSource
import kr.hs.dgsw.data.entity.SearchData
import javax.inject.Inject

class SearchCache @Inject constructor(
    override val dao: SearchDao
) : BaseCache<SearchDao> {
    fun getAll(
        size: Int,
    ): Flow<PagingData<SearchData>> {
        return Pager(
            config = PagingConfig(
                pageSize = size,
                initialLoadSize = size,
                enablePlaceholders = false
            ), pagingSourceFactory = { SearchPagingSource(dao) }
        ).flow
    }

    suspend fun insertSearch(searchData: SearchData) {
        return dao.insertSearch(searchData)
    }

    suspend fun deleteAllSearch() {
        return dao.deleteAllSearch()
    }

    suspend fun deleteSearch(id: Long) {
        return dao.deleteSearch(id)
    }
}