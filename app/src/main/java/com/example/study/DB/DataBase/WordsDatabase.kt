package com.example.study.DB.DataBase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.study.DB.Dao.WordsDao
import com.example.study.DB.Entity.Words
import com.example.study.MyApplication

@Database(entities = [Words::class], version = 1, exportSchema = false)
abstract class WordsDatabase:RoomDatabase() {

    companion object {
        private var INSTANCE:WordsDatabase? = null
        @Synchronized
        fun getINSTANCE(context: Context):WordsDatabase?{
            if (INSTANCE == null){
                INSTANCE =
                    Room.databaseBuilder(context, WordsDatabase::class.java, "words_database")
                        .build()
            }
            return INSTANCE
        }
    }

//    companion object {
//
//        val instance = Single.sin
//
//    }
//
//    private object Single {
//
//        val sin :WordsDatabase= Room.databaseBuilder(
//            MyApplication.instance(),
//            WordsDatabase::class.java,
//            "words_database.db"
//        )
//            .allowMainThreadQueries()
//            .build()
//    }



    abstract fun getWordDao():WordsDao
}