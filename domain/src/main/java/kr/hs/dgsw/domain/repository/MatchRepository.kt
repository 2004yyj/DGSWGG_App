package kr.hs.dgsw.domain.repository

import kotlinx.coroutines.flow.Flow

interface MatchRepository {
    fun <T> getAllMatch(size: Int, summonerId: String): Flow<T>
}