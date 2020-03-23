package com.example.study.Controller

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.example.study.Model.FirstViewModel
import com.example.study.R
import kotlinx.android.synthetic.main.first_fragment.*


class FirstFragment : Fragment() {

    companion object {
        fun newInstance() = FirstFragment()
    }

    private lateinit var viewModel: FirstViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.first_fragment, container, false)
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(requireActivity()).get(FirstViewModel::class.java)
        viewModel.getLikes_number()!!.observe(this, Observer { number.text = viewModel.getLikes_number()!!.value.toString()})
        like.setOnClickListener(View.OnClickListener {
            viewModel.addLike(1)
        })
        dislike.setOnClickListener(View.OnClickListener {
            viewModel.addLike(-1)
        })
    }

}
