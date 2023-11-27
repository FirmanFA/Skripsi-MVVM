package com.skripsi.mvp.repository

import com.skripsi.mvp.data.api.model.GetNewsResponse
import com.skripsi.mvp.domain.Resource
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

typealias NewsFlow = Flow<Resource<Response<GetNewsResponse>>>