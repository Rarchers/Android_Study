package com.example.study.DB.Entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Words {
    @PrimaryKey(autoGenerate = true)
    var id:Int = 0

    @ColumnInfo(name = "word")
    var word:String = ""
    @ColumnInfo(name = "chinese")
    var meaning:String = ""

    constructor(word: String, meaning: String) {
        this.word = word
        this.meaning = meaning
    }


}