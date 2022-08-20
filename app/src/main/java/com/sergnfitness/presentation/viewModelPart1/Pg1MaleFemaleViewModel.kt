package com.sergnfitness.presentation.viewModelPart1

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sergnfitness.domain.models.user.User
import com.sergnfitness.domain.usecase.GetUserSharedPreferenceUseCase
import com.sergnfitness.domain.usecase.SaveUserSharedPreferenceUseCase

class Pg1MaleFemaleViewModel(
    private val getUserSharedPreferenceUseCase: GetUserSharedPreferenceUseCase,
    private val saveUserSharedPreferenceUseCase: SaveUserSharedPreferenceUseCase,
): ViewModel() {

 //   private val userRepository: UserRepositoryImpl by lazy(LazyThreadSafetyMode.NONE) { UserRepositoryImpl(userStorage = SharedPrefUserStorage(requireContext().applicationContext)) }
//    private val getUserNameUseCase by lazy(LazyThreadSafetyMode.NONE) { GetUserNameUseCase(userRepository = userRepository) }
//    private val getIdSharedPreference = GetIdSharedPreference()
//    private val saveUserNameUseCase by lazy(LazyThreadSafetyMode.NONE) { SaveUserNameUseCase(userRepository = userRepository) }

    private val _resultLive = MutableLiveData<String>()
    val resultLive: LiveData<String> = _resultLive

    fun save(textv:String){

//        val params = SaveUserNameParam(email = textv.toString(),
//            idUser = 5)//User(5, "fulname", textv.toString(), "123", 5))
        val params = User(id = 5, fullName = textv.toString(), email = "em@il" , password = "123", fitness_id = 25)
val result: Boolean = saveUserSharedPreferenceUseCase.execute(params)
//        val result: Boolean = saveUserNameUseCase.execute(param = params)
        _resultLive.value =  "Save $textv = $result"

    }
    fun load(){
        val userName: User = getUserSharedPreferenceUseCase.execute()

        val result:String = "Save ${userName.email} = ${userName.password} = ${userName.id} = ${userName.fullName}"
        _resultLive.value = result
    }

}