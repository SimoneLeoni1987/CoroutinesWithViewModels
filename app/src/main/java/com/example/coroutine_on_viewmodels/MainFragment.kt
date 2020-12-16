package com.example.coroutine_on_viewmodels

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.coroutine_on_viewmodels.databinding.FragmentMainBinding

class MainFragment: Fragment() {

    lateinit var tv: TextView
    lateinit var btn: Button
    private val viewModel by viewModels<MainViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding : FragmentMainBinding = FragmentMainBinding.inflate(layoutInflater)
        tv = binding.textView
        btn = binding.button
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.text.observe(viewLifecycleOwner, {
            tv.text = it
        })

        btn.setOnClickListener {
            findNavController().navigate(
                    R.id.action_mainFragment_to_secondFragment
            )
        }
    }
}