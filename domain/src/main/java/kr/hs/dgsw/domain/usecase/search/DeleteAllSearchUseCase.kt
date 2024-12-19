package kr.hs.dgsw.domain.usecase.search

import kr.hs.dgsw.domain.base.BaseSuspendUseCase
import kr.hs.dgsw.domain.repository.SearchRepository

class DeleteAllSearchUseCase(
    private val searchRepository: SearchRepository
): BaseSuspendUseCase<Unit> {
    override suspend fun buildSuspendUseCase() {
        return searchRepository.deleteAllSearch()
    }
}