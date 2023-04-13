package com.skripsi.mvvm.domain.usecase

import androidx.lifecycle.viewmodel.CreationExtras
import com.skripsi.mvvm.repository.MainRepository

class PostMainUseCase(private val mainRepository: MainRepository) : PostMain() {

    override fun execute(params: CreationExtras.Empty?) =
        mainRepository.postMain()
}