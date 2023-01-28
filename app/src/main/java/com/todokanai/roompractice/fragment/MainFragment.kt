package com.todokanai.roompractice.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.asLiveData
import com.todokanai.roompractice.R
import com.todokanai.roompractice.databinding.FragmentMainBinding
import com.todokanai.roompractice.room.User
import com.todokanai.roompractice.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : Fragment() {

    private lateinit var binding : FragmentMainBinding
    private val viewModel : MainViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_main,container,false)
        Log.d("MainFragment","onCreateView")

        val insertBtn = binding.insertBtn
        val getBtn = binding.getBtn
        val logBtn = binding.logBtn
        val inputText = binding.inputTest.text
        val firstUser = binding.firstUser
        val allUser = binding.allUser




        viewModel.firstVal.observe(viewLifecycleOwner) {
            // Log.d("oikura","fistVal: $it")
            if (it != null) {
                firstUser.text = it.toString()
            } else {
                firstUser.text = "null found"
            }
        }

            viewModel.allUser.asLiveData().observe(viewLifecycleOwner){
                if(it!=null) {
                    allUser.text = it.toString()
                }
            }

        insertBtn.setOnClickListener { viewModel.insert(User(inputText.toString().toLong(),1)) }
        getBtn.setOnClickListener { viewModel.deleteAll() }
        logBtn.setOnClickListener { viewModel.testFunction()}

        /*
        viewModel.testValue.observe(viewLifecycleOwner){
            if(it==null){
                println("null found")
            } else {
                println("$it")
            }
        }

         */


        return binding.root
    }
}