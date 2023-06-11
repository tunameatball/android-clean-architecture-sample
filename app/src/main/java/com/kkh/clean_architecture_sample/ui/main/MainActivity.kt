package com.kkh.clean_architecture_sample.ui.main

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.widget.SearchView.OnQueryTextListener
import com.kkh.clean_architecture_sample.base.BaseActivity
import com.kkh.clean_architecture_sample.base.BaseViewModel
import com.kkh.clean_architecture_sample.databinding.ActivityMainBinding

class MainActivity : BaseActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()

    override fun createActivity(): BaseViewModel {
        return viewModel
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.searchView.setOnQueryTextListener(object : OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return if (query?.isNotEmpty() == true) {
                    viewModel.getMovie(query)
                    false
                } else {
                    true
                }
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return true
            }
        })
    }
}