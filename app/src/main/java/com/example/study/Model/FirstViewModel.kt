package com.example.study.Model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class FirstViewModel : ViewModel() {
    private var likes_number: MutableLiveData<Int>? = null

    fun getLikes_number(): MutableLiveData<Int>? {
        if (likes_number == null) {
            likes_number = MutableLiveData()
            likes_number!!.value = 0
        }
        return likes_number
    }


    fun addLike(value: Int) {
        likes_number!!.value = likes_number!!.value!! + value
    }
}
