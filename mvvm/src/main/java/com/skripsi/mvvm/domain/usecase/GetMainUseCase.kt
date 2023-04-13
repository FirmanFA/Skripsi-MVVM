package com.skripsi.mvvm.domain.usecase

import kotlinx.coroutines.Dispatchers
import com.skripsi.mvvm.repository.MainRepository


class GetMainUseCase(private val mainRepository: MainRepository) : GetMain(Dispatchers.Main) {

    override fun execute(params: String?) =
        mainRepository.getMain()
}