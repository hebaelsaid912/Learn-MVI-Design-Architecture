package com.example.android.learnmvidesignarchitecture

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.lifecycleScope
import com.example.android.learnmvidesignarchitecture.databinding.ActivityMainBinding
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    private val viewModel: AddNumberViewModel by lazy {
        ViewModelProvider(this).get(AddNumberViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        render()
        binding.addNumBtn.setOnClickListener {
            lifecycleScope.launch {
                viewModel.intentChannel.send(MainIntent.addNumber)
            }

        }
    }

    private fun render() {
        lifecycleScope.launchWhenStarted {
            viewModel.state.collect{
                when(it){
                    is MainViewState.Idle -> binding.numerTv.text = "Idle"
                    is MainViewState.numResult -> binding.numerTv.text = it.num.toString()
                    is MainViewState.Error -> binding.numerTv.text = it.result
                }
            }
        }
    }
}