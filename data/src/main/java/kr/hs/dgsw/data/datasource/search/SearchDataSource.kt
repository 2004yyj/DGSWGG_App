package kr.hs.dgsw.data.datasource.search

import androidx.paging.PagingData
import androidx.paging.map
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kr.hs.dgsw.data.database.cache.SearchCache
import kr.hs.dgsw.data.entity.SearchData
import kr.hs.dgsw.data.mapper.toData
import kr.hs.dgsw.data.mapper.toEntity
import kr.hs.dgsw.domain.entity.Search
import javax.inject.Inject

class SearchDataSource @Inject constructor(
    private val cache: SearchCache
) {
    fun getAll(size: Int): Flow<PagingData<Search>> {
        return cache.getAll(size).map { pagingData ->
            pagingData.map { it.toEntity() }
        }
    }

    suspend fun insertSearch(search: Search) {
        cache.insertSearch(search.toData())
    }

    suspend fun deleteAllSearch() {
        cache.deleteAllSearch()
    }

    suspend fun deleteSearch(id: Long) {
        cache.deleteSearch(id)
    }
}