package com.example.testproject.movielist

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.testproject.R
import com.example.testproject.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect

@AndroidEntryPoint
class MovieListActivity : AppCompatActivity(R.layout.activity_main) {

    private val binding by viewBinding(ActivityMainBinding::bind)

    private val viewModel by viewModels<MovieListViewModel>()

    private val adapter = MovieAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.moviesRecyclerView.adapter = adapter
        setupViewModelSubscription()
    }

    private fun setupViewModelSubscription() {
        lifecycleScope.launchWhenStarted {
            viewModel.isLoading.collect {
                binding.progressBar.isVisible = it
            }
        }
        lifecycleScope.launchWhenStarted {
            viewModel.error.collect {
                Toast.makeText(this@MovieListActivity, it, Toast.LENGTH_SHORT).show()
            }
        }
        lifecycleScope.launchWhenStarted {
            viewModel.movies.collect {
                adapter.submitList(it)
            }
        }
    }

}