package com.skripsi.mvp.ui.main

import com.skripsi.mvp.data.api.model.GetNewsResponse
import com.skripsi.mvp.domain.Resource
import kotlinx.coroutines.flow.StateFlow
import retrofit2.Response

interface MainContract {

    interface View {
        fun showLatestNews(resourceData : Resource<Response<GetNewsResponse>>)
    }

    interface Presenter {
        fun fetchLatestNews(): StateFlow<Resource<Response<GetNewsResponse>>>
    }

}