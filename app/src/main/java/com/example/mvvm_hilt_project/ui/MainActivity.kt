package com.example.mvvm_hilt_project.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mvvm_hilt_project.R
import com.example.mvvm_hilt_project.databinding.ActivityMainBinding
import com.example.mvvm_hilt_project.ui.fragment.MainFragment
import com.example.mvvm_hilt_project.ui.fragment.MainFragmentFactory
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi
import javax.inject.Inject

@ExperimentalCoroutinesApi
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }


}