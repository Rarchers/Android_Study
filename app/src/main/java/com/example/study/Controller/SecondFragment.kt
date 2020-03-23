package com.example.study.Controller

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.study.DB.Entity.Words
import com.example.study.Model.SecondViewModel
import com.example.study.R
import kotlinx.android.synthetic.main.second_fragment.*


class SecondFragment : Fragment() {


    companion object {
        fun newInstance() = SecondFragment()
    }

    private lateinit var viewModel: SecondViewModel
    lateinit var words:LiveData<List<Words>>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.second_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(SecondViewModel::class.java)
        words = viewModel.wordsDao.getAllWords()
        words.observe(this, Observer {
            val stringBuilder = StringBuilder()
            for(i in it){
                stringBuilder.append(i.id)
                stringBuilder.append(" : ")
                stringBuilder.append(i.word)
                stringBuilder.append(" = ")
                stringBuilder.append(i.meaning)
                stringBuilder.append("\n")
            }
            datainfo.text = stringBuilder.toString()
        })

        Insert.setOnClickListener(View.OnClickListener {
            val words = Words("Google","谷歌")
            val words1 = Words("hello","你好")
            val words2 = Words("world","世界")
            SecondViewModel.InsertAsyncTask(viewModel.wordsDao).execute(words,words1,words2)
        })
        Update.setOnClickListener(View.OnClickListener {
            val words = Words("hello","世界")
            words.id = 5
            SecondViewModel.UpdateAsyncTask(viewModel.wordsDao).execute(words)
        })

        Clear.setOnClickListener(View.OnClickListener {
            SecondViewModel.DeleteAllAsyncTask(viewModel.wordsDao).execute()
        })

        Delete.setOnClickListener(View.OnClickListener {
            val words = Words("Google","谷歌")
            SecondViewModel.DeleteAsyncTask(viewModel.wordsDao).execute(words.word)
        })


    }




}
