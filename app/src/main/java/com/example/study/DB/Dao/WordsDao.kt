package com.example.study.DB.Dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.study.DB.Entity.Words

@Dao
interface WordsDao {
    @Insert
    fun insert(vararg words: Words)

    @Update
    fun update(vararg words: Words)

    @Query("DELETE FROM Words WHERE word = (:string)")
    fun delete(vararg string: String)

    @Query("DELETE FROM Words")
    fun deleteAll()

    @Query("SELECT *FROM Words ORDER BY ID DESC")
    fun getAllWords():LiveData<List<Words>>

}