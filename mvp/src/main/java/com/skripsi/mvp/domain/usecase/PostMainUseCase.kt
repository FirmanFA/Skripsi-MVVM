package com.skripsi.mvp.domain.usecase

import androidx.lifecycle.viewmodel.CreationExtras
import com.skripsi.mvp.repository.MainRepository

class PostMainUseCase(private val mainRepository: MainRepository) : PostMain() {

    override fun execute(params: CreationExtras.Empty?) =
        mainRepository.postMain()
}