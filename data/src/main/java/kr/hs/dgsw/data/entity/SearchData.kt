package kr.hs.dgsw.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "search")
data class SearchData(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Long,

    @ColumnInfo(name = "profile_icon_id")
    val profileIconId: Int,

    @ColumnInfo(name = "summoner_name")
    val summonerName: String
)