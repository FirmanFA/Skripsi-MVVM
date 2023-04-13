package com.skripsi.mvi.repository

import com.skripsi.mvi.data.api.model.GetNewsResponse
import com.skripsi.mvi.data.api.model.MovieResponse
import kotlinx.coroutines.flow.Flow
import com.skripsi.mvi.domain.Resource
import retrofit2.Response

typealias StringFlow = Flow<Resource<String>>
typealias MovieFlow = Flow<Resource<Response<MovieResponse>>>
typealias NewsFlow = Flow<Resource<Response<GetNewsResponse>>>