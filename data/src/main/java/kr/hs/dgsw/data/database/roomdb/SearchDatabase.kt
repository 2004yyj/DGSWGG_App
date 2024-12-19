package kr.hs.dgsw.data.database.roomdb

import androidx.room.Database
import kr.hs.dgsw.data.database.base.BaseDatabase
import kr.hs.dgsw.data.database.dao.SearchDao
import kr.hs.dgsw.data.entity.SearchData

@Database(entities = [SearchData::class], version = 1, exportSchema = false)
abstract class SearchDatabase: BaseDatabase<SearchDao>() {
}