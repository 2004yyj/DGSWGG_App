package kr.hs.dgsw.domain.repository

import kotlinx.coroutines.flow.Flow
import kr.hs.dgsw.domain.entity.Search

interface SearchRepository {
    fun <T> getAll(size: Int): Flow<T>
    suspend fun insertSearch(search: Search)
    suspend fun deleteAllSearch()
    suspend fun deleteSearch(id: Long)
}