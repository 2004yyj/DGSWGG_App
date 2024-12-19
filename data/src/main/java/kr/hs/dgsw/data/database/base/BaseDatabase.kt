package kr.hs.dgsw.data.database.base

import androidx.room.RoomDatabase

abstract class BaseDatabase<Dao>: RoomDatabase() {
    abstract val dao: Dao
}