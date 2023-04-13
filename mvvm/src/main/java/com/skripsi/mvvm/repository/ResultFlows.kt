package com.skripsi.mvvm.repository

import com.skripsi.mvvm.data.api.model.GetNewsResponse
import com.skripsi.mvvm.data.api.model.MovieResponse
import kotlinx.coroutines.flow.Flow
import com.skripsi.mvvm.domain.Resource
import retrofit2.Response

typealias StringFlow = Flow<Resource<String>>
typealias MovieFlow = Flow<Resource<Response<MovieResponse>>>
typealias NewsFlow = Flow<Resource<Response<GetNewsResponse>>>