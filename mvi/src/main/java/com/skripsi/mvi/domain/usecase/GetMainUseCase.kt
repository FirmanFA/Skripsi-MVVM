package com.skripsi.mvi.domain.usecase

import kotlinx.coroutines.Dispatchers
import com.skripsi.mvi.repository.MainRepository


class GetMainUseCase(private val mainRepository: MainRepository) : GetMain(Dispatchers.Main) {

    override fun execute(params: String?) =
        mainRepository.getMain()
}