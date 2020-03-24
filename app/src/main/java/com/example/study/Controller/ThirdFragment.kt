package com.example.study.Controller

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.study.Controller.Third.AFragment
import com.example.study.Controller.Third.BFragment
import com.example.study.Controller.Third.CFragment
import com.example.study.R
import com.example.study.Model.ThirdViewModel
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.third_fragment.*


class ThirdFragment : Fragment() {

    companion object {
        fun newInstance() = ThirdFragment()
    }

    private lateinit var viewModel: ThirdViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.third_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(ThirdViewModel::class.java)

        viewpager.adapter = object : FragmentStateAdapter(this){
            override fun getItemCount() = 3

            override fun createFragment(position: Int)=
                when(position){
                  0 -> AFragment()
                  1 -> BFragment()
                  else -> CFragment()
              }
        }


        TabLayoutMediator(tablayout,viewpager){
            tab, position ->
            when(position){
                0 -> tab.text = "1"
                1 -> tab.text = "2"
                else -> tab.text = "3"
            }
        }.attach()


    }

}
