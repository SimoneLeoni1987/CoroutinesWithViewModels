package com.example.coroutine_on_viewmodels

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.coroutine_on_viewmodels.databinding.FragmentSecondBinding

class SecondFragment: Fragment() {

    lateinit var tv: TextView
    val viewModel by viewModels<SecondViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding : FragmentSecondBinding = FragmentSecondBinding.inflate(layoutInflater)
        tv = binding.textView
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        lifecycleScope.launchWhenCreated {
            viewModel.load()
        }
    }
}