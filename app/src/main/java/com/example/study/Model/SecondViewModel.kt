package com.example.study.Model

import android.app.Application
import android.os.AsyncTask
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.study.DB.Dao.WordsDao
import com.example.study.DB.DataBase.WordsDatabase
import com.example.study.DB.Entity.Words
import com.example.study.MyApplication

class SecondViewModel(application: Application) : AndroidViewModel(application) {
    var application = MyApplication()
    var wordsDatabase: WordsDatabase? = WordsDatabase.getINSTANCE(application)
    var wordsDao: WordsDao
    private var words :LiveData<List<Words>>? = null

    init {
        wordsDao = wordsDatabase!!.getWordDao()
        words = wordsDao.getAllWords()
    }




    class InsertAsyncTask(private val dao: WordsDao) :
        AsyncTask<Words, Void?, Void?>() {
        override fun doInBackground(vararg params: Words): Void? {
            dao.insert(*params)
            return null
        }
    }

    class UpdateAsyncTask(private val dao: WordsDao) :
        AsyncTask<Words, Void, Void>() {
        override fun doInBackground(vararg params: Words): Void? {
            dao.update(*params)
            return null
        }
    }

    class DeleteAllAsyncTask(private val dao: WordsDao) : AsyncTask<Void, Void, Void>() {
        override fun doInBackground(vararg params: Void?): Void? {
            dao.deleteAll()
            return null
        }
    }

    class DeleteAsyncTask (private val dao: WordsDao):AsyncTask<String,Void,Void>(){
        override fun doInBackground(vararg params: String): Void? {
            dao.delete(*params)
            return null
        }

    }


}
