package com.sergnfitness.presentation.login

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.sergnfitness.data.repository.UserRepositoryImpl
import com.sergnfitness.data.storage.SharedPresImplStorage
import com.sergnfitness.domain.usecase.GetUserSharedPreferenceUseCase
import com.sergnfitness.domain.usecase.SaveUserSharedPreferenceUseCase

class LoginFragmentViewModelFactory(context: Context): ViewModelProvider.Factory {

    private val userRepository: UserRepositoryImpl by lazy(LazyThreadSafetyMode.NONE) {
        UserRepositoryImpl(sharedPresInterfaceStorage = SharedPresImplStorage(context = context))
    }
    private val saveUserSharedPreferenceUseCase by lazy (LazyThreadSafetyMode.NONE) {
        SaveUserSharedPreferenceUseCase(userRepository = userRepository)
    }
    private val getUserSharedPreferenceUseCase by lazy (LazyThreadSafetyMode.NONE) {
        GetUserSharedPreferenceUseCase(userRepository = userRepository)
    }

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return LoginFragmentViewModel(
            getUserSharedPreferenceUseCase = getUserSharedPreferenceUseCase,
            saveUserSharedPreferenceUseCase = saveUserSharedPreferenceUseCase,
        ) as T
    }

}