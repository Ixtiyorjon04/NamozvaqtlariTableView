package uz.gita.namozvaqtlari.data.local.dao

import androidx.room.Insert

interface BaseDao<T> {

    @Insert
    suspend fun insert(data: List<T>)

}