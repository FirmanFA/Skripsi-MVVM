package com.skripsi.mvvm.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.skripsi.mvvm.databinding.ActivityMainBinding
import com.skripsi.mvvm.domain.Resource
import com.skripsi.mvvm.ext.collectIn
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModel()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.getCnnNews()
        viewModel.getBccNews()
        viewModel.getEspnNews()

        viewModel.cnnNews.collectIn(this) {
            when (it) {
                is Resource.Failure -> {
                    Toast.makeText(
                        this,
                        it.e.localizedMessage,
                        Toast.LENGTH_SHORT
                    ).show()
                }
                is Resource.Pending -> Toast.makeText(this, "pending", Toast.LENGTH_SHORT).show()
                is Resource.Success -> {
                    val adapter = it.data?.body()?.articles?.let { it1 -> MainAdapter(it1) }

                    binding.rvNewsCnn.adapter = adapter

                }
            }
        }

        viewModel.bbcNews.collectIn(this) {
            when (it) {
                is Resource.Failure -> {
                    Toast.makeText(
                        this,
                        it.e.localizedMessage,
                        Toast.LENGTH_SHORT
                    ).show()
                    Log.d("failed", it.e.localizedMessage?.toString() ?: "")
                }
                is Resource.Pending -> Toast.makeText(this, "pending", Toast.LENGTH_SHORT).show()
                is Resource.Success -> {
//                    binding.tvTesting.text = it.data?.body()?.articles.toString()

                    val adapter = it.data?.body()?.articles?.let { it1 -> MainAdapter(it1) }

                    binding.rvNewsBbc.adapter = adapter

                }
            }
        }

        viewModel.espnNews.collectIn(this) {
            when (it) {
                is Resource.Failure -> {
                    Toast.makeText(
                        this,
                        it.e.localizedMessage,
                        Toast.LENGTH_SHORT
                    ).show()
                    Log.d("failed", it.e.localizedMessage?.toString() ?: "")
                }
                is Resource.Pending -> Toast.makeText(this, "pending", Toast.LENGTH_SHORT).show()
                is Resource.Success -> {

                    val adapter = it.data?.body()?.articles?.let { it1 -> MainAdapter(it1) }

                    binding.rvNewsEspn.adapter = adapter

                }
            }
        }

    }
}