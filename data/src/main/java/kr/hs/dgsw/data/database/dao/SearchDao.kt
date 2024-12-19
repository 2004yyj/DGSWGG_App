package kr.hs.dgsw.data.database.dao

import androidx.room.*
import kr.hs.dgsw.data.entity.SearchData

@Dao
interface SearchDao {
    @Query("SELECT * FROM search ORDER BY id DESC LIMIT :size OFFSET :page * :size")
    suspend fun getAll(
        size: Int,
        page: Int
    ): List<SearchData>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSearch(searchData: SearchData)

    @Query("DELETE FROM search")
    suspend fun deleteAllSearch()

    @Query("DELETE FROM search WHERE id = :id")
    suspend fun deleteSearch(id: Long)
}