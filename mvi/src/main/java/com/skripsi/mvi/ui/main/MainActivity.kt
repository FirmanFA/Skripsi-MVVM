package com.skripsi.mvi.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import com.skripsi.mvi.databinding.ActivityMainBinding
import com.skripsi.mvi.ext.collectIn
import com.skripsi.mvi.ui.model.NewsIntents
import com.skripsi.mvi.ui.model.NewsUiState
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModel()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        lifecycleScope.launch {

            viewModel.newsChannel.send(NewsIntents.LatestESPNNews)
            viewModel.newsChannel.send(NewsIntents.LatestCnnNews)
            viewModel.newsChannel.send(NewsIntents.LatestBBCNews)

        }



        viewModel.cnnNewsState.collectIn(this) {
            when (it) {
                is NewsUiState.Success -> {
                    val adapter =
                        it.newsData.body()?.articles?.let { it1 -> MainAdapter(it1) }

                    binding.rvNewsCnn.adapter = adapter
                }
                is NewsUiState.Error -> {
                    Toast.makeText(
                        this@MainActivity,
                        it.errorMsg,
                        Toast.LENGTH_SHORT
                    ).show()
                }
                is NewsUiState.Loading -> {
                    Toast.makeText(this@MainActivity, "pending", Toast.LENGTH_SHORT).show()
                }
            }
        }

        viewModel.bbcNewsState.collectIn(this) {
            when (it) {
                is NewsUiState.Success -> {
                    val adapter =
                        it.newsData.body()?.articles?.let { it1 -> MainAdapter(it1) }

                    binding.rvNewsBbc.adapter = adapter
                }
                is NewsUiState.Error -> {
                    Toast.makeText(
                        this@MainActivity,
                        it.errorMsg,
                        Toast.LENGTH_SHORT
                    ).show()
                }
                is NewsUiState.Loading -> {
                    Toast.makeText(this@MainActivity, "pending", Toast.LENGTH_SHORT).show()
                }
            }
        }

        viewModel.espnNewsState.collectIn(this) {
            when (it) {
                is NewsUiState.Success -> {
                    val adapter =
                        it.newsData.body()?.articles?.let { it1 -> MainAdapter(it1) }

                    binding.rvNewsEspn.adapter = adapter
                }
                is NewsUiState.Error -> {
                    Toast.makeText(
                        this@MainActivity,
                        it.errorMsg,
                        Toast.LENGTH_SHORT
                    ).show()
                }
                is NewsUiState.Loading -> {
                    Toast.makeText(this@MainActivity, "pending", Toast.LENGTH_SHORT).show()
                }
            }
        }

    }
}