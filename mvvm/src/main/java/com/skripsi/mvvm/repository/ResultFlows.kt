package com.skripsi.mvvm.repository

import com.skripsi.mvvm.data.api.model.GetNewsResponse
import kotlinx.coroutines.flow.Flow
import com.skripsi.mvvm.domain.Resource
import retrofit2.Response

typealias NewsFlow = Flow<Resource<Response<GetNewsResponse>>>