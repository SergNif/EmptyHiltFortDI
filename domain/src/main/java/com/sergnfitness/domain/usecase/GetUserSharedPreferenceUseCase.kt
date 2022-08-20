package com.sergnfitness.domain.usecase

import com.sergnfitness.domain.models.user.User
import com.sergnfitness.domain.repository.UserRepository

class GetUserSharedPreferenceUseCase(private val userRepository: UserRepository) {
    val TAG = "GetUserSharedPreference"
    fun execute():User{
        val user:User = userRepository.getUser()
        return user
    }
}