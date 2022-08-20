package com.sergnfitness.presentation.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.sergnfitness.emptyhilt.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

//    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
    lateinit var binding: ActivityMainBinding
    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        viewModel = ViewModelProvider(this, MainViewModelFactory(this)).get(MainViewModel::class.java)


//        val logFragment: LoginFragment = LoginFragment()
//        val fragment: Fragment? = supportFragmentManager.findFragmentByTag(logFragment::class.java.simpleName)
//
//        if (fragment != logFragment){
//        supportFragmentManager.beginTransaction()
//            .add(LoginFragment,"Fragment Login",LoginFragment,LoginFragment::class.java.simpleName)
//
    }
}