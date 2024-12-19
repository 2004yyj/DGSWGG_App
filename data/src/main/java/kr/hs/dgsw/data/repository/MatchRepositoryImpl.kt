package kr.hs.dgsw.data.repository

import kotlinx.coroutines.flow.Flow
import kr.hs.dgsw.data.datasource.match.MatchDataSource
import kr.hs.dgsw.domain.repository.MatchRepository
import javax.inject.Inject

class MatchRepositoryImpl @Inject constructor(
    private val matchDataSource: MatchDataSource
): MatchRepository {
    override fun <T> getAllMatch(size: Int, summonerId: String): Flow<T> {
        return matchDataSource.getAllMatch(size, summonerId) as Flow<T>
    }
}