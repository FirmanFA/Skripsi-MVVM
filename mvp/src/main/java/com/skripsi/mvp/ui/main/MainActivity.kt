package com.skripsi.mvp.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.skripsi.mvp.data.api.model.GetNewsResponse
import com.skripsi.mvp.databinding.ActivityMainBinding
import com.skripsi.mvp.domain.Resource
import com.skripsi.mvp.ext.collectIn
import org.koin.androidx.viewmodel.ext.android.viewModel
import retrofit2.Response

class MainActivity : AppCompatActivity(), MainContract.View {

    private lateinit var binding: ActivityMainBinding
    private val mainPresenter: MainPresenter by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mainPresenter.fetchCnnNews().collectIn(this ){
            showCnnNews(it)
        }
        mainPresenter.fetchBBCNews().collectIn(this ){
            showBBCNews(it)
        }
        mainPresenter.fetchESPNNews().collectIn(this ){
            showESPNNews(it)
        }

    }

    override fun showCnnNews(resourceData: Resource<Response<GetNewsResponse>>) {
        when (resourceData) {
            is Resource.Failure -> {
                Toast.makeText(
                    this,
                    resourceData.e.localizedMessage,
                    Toast.LENGTH_SHORT
                ).show()
            }
            is Resource.Pending -> Toast.makeText(this, "pending", Toast.LENGTH_SHORT).show()
            is Resource.Success -> {
                val adapter = resourceData.data?.body()?.articles?.let { it1 -> MainAdapter(it1) }

                binding.rvNewsCnn.adapter = adapter
            }
        }
    }

    override fun showBBCNews(resourceData: Resource<Response<GetNewsResponse>>) {
        when (resourceData) {
            is Resource.Failure -> {
                Toast.makeText(
                    this,
                    resourceData.e.localizedMessage,
                    Toast.LENGTH_SHORT
                ).show()
            }
            is Resource.Pending -> Toast.makeText(this, "pending", Toast.LENGTH_SHORT).show()
            is Resource.Success -> {
                val adapter = resourceData.data?.body()?.articles?.let { it1 -> MainAdapter(it1) }

                binding.rvNewsBbc.adapter = adapter
            }
        }
    }

    override fun showESPNNews(resourceData: Resource<Response<GetNewsResponse>>) {
        when (resourceData) {
            is Resource.Failure -> {
                Toast.makeText(
                    this,
                    resourceData.e.localizedMessage,
                    Toast.LENGTH_SHORT
                ).show()
            }
            is Resource.Pending -> Toast.makeText(this, "pending", Toast.LENGTH_SHORT).show()
            is Resource.Success -> {
                val adapter = resourceData.data?.body()?.articles?.let { it1 -> MainAdapter(it1) }

                binding.rvNewsEspn.adapter = adapter
            }
        }
    }
}