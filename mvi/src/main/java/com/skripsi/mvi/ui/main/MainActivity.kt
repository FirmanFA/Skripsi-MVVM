package com.skripsi.mvi.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.skripsi.mvi.databinding.ActivityMainBinding
import com.skripsi.mvi.ext.collectIn
import com.skripsi.mvi.ui.model.NewsUiState
import com.skripsi.mvi.ui.model.base.LoadUiState
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModel()
    private lateinit var binding: ActivityMainBinding
    private var oldNews = ""
    private var currentNews = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        viewModel.getLatestNews()

        viewModel.loadLatestNews()

        viewModel.loadUiStateFlow.collectIn(this){
            when(it){
                is LoadUiState.Error -> {}
                is LoadUiState.Loading -> {

                    Toast.makeText(this, "pending", Toast.LENGTH_SHORT).show()

                }
                is LoadUiState.ShowMainView -> {

                }
            }
        }

        viewModel.uiStateFlow.collectIn(this){
            when(val data = it.newsUiState){
                is NewsUiState.Error -> {

                }
                is NewsUiState.Loading -> {

                }
                is NewsUiState.Success -> {
                    binding.tvTesting.text = data.news.body()?.articles.toString()
                }
            }
        }

//        viewModel.getDiscoveryMovie().collectIn(this) {
//            when (it) {
//                is Resource.Failure -> {
//                    TODO("Do something with the view when get error")
//                }
//                is Resource.Pending -> {
//                    TODO("Do something with the view when content loading")
//                }
//                is Resource.Success -> {
//                    TODO("Do something with the view when data retrieved successfully")
//                }
//            }
//        }

//        viewModel.latestNewsUiState.collectIn(this) {
//            when (it) {
//                is NewsUiState.Error -> {
//                    /*Do something with the view when get error*/
//                }
//                is NewsUiState.Loading -> {
//                    /*Do something with the view when content loading*/
//                }
//                is NewsUiState.Success -> {
//                    /*Do something with the view when data retrieved successfully*/
//                }
//            }
//        }

//        viewModel.latestNewsUiState.collectIn(this) {
//            when (it) {
//                is NewsUiState.Error -> {
//                    Toast.makeText(
//                        this,
//                        it.exception.localizedMessage,
//                        Toast.LENGTH_SHORT
//                    ).show()
//                }
//                is NewsUiState.Loading -> {
//                    Toast.makeText(this, "pending", Toast.LENGTH_SHORT).show()
//                }
//                is NewsUiState.Success -> {
//                    binding.tvTesting.text = it.movie.body()?.articles.toString()
//                }
//            }
//        }

    }
}