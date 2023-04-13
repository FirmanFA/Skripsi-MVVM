package com.skripsi.mvi.domain.usecase

import androidx.lifecycle.viewmodel.CreationExtras
import com.skripsi.mvi.repository.MainRepository

class PostMainUseCase(private val mainRepository: MainRepository) : PostMain() {

    override fun execute(params: CreationExtras.Empty?) =
        mainRepository.postMain()
}