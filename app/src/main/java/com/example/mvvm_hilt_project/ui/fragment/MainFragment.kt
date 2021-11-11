package com.example.mvvm_hilt_project.ui.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.mvvm_hilt_project.databinding.FragmentMainBinding
import com.example.mvvm_hilt_project.model.Blog
import com.example.mvvm_hilt_project.ui.MainStateEvent
import com.example.mvvm_hilt_project.ui.MainViewModel
import com.example.mvvm_hilt_project.util.DataState
import dagger.hilt.android.AndroidEntryPoint
import java.lang.StringBuilder
import javax.inject.Inject

@AndroidEntryPoint
class MainFragment
constructor(
    private val someString: String,
):Fragment(){
    lateinit var binding: FragmentMainBinding

    private val viewModel : MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding= FragmentMainBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("TAG","Here is some String :$someString")
        subscribeObserver()
        viewModel.setStateEvent(MainStateEvent.GetBlogEvents)
    }
    private fun subscribeObserver(){
        viewModel.dataState.observe(viewLifecycleOwner, Observer { dataState ->
            when(dataState){
                is DataState.Success<List<Blog>> ->{
                    displayProgress(false)
                    appendBlogTitle(dataState.data)
                }
                is DataState.Error ->{
                    displayProgress(false)
                    displayError(dataState.exception.message)
                }
                is DataState.Loading ->{
                    displayProgress(true)
                }
            }
        })
    }

    private fun displayError(message :String?){
        if (message!=null){
            binding.text.text=message
        }else{
            binding.text.text="Unknown Error"
        }
    }

    private fun displayProgress(isDisplayed: Boolean){
       binding.pg.visibility=if (isDisplayed) View.VISIBLE else View.INVISIBLE
    }

    private fun appendBlogTitle(blogs :List<Blog>){
        val sb= StringBuilder()
        for(blog in blogs){
            sb.append(blog.title+"\n")
        }
        binding.text.text=sb.toString()
    }

}