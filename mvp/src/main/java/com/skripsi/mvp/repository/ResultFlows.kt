package com.skripsi.mvp.repository

import com.skripsi.mvp.data.api.model.GetNewsResponse
import com.skripsi.mvp.data.api.model.MovieResponse
import kotlinx.coroutines.flow.Flow
import com.skripsi.mvp.domain.Resource
import retrofit2.Response

typealias StringFlow = Flow<Resource<String>>
typealias MovieFlow = Flow<Resource<Response<MovieResponse>>>
typealias NewsFlow = Flow<Resource<Response<GetNewsResponse>>>