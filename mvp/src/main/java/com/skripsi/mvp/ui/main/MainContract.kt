package com.skripsi.mvp.ui.main

import com.skripsi.mvp.data.api.model.GetNewsResponse
import com.skripsi.mvp.domain.Resource
import kotlinx.coroutines.flow.StateFlow
import retrofit2.Response

interface MainContract {

    interface View {
        fun showCnnNews(resourceData : Resource<Response<GetNewsResponse>>)
        fun showBBCNews(resourceData : Resource<Response<GetNewsResponse>>)
        fun showESPNNews(resourceData : Resource<Response<GetNewsResponse>>)
    }

    interface Presenter {
        fun fetchCnnNews(): StateFlow<Resource<Response<GetNewsResponse>>>
        fun fetchBBCNews(): StateFlow<Resource<Response<GetNewsResponse>>>
        fun fetchESPNNews(): StateFlow<Resource<Response<GetNewsResponse>>>
    }

}