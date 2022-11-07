package com.example.mentalmath

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.mentalmath.databinding.ActivityMainBinding.inflate
import com.example.mentalmath.databinding.FragmentBeginningBinding
import com.example.mentalmath.model.MathViewModel


class BeginningFragment : Fragment() {
    private var _binding: FragmentBeginningBinding? = null

    private val binding get() = _binding!!

    private val sharedViewModel: MathViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentBeginningBinding.inflate(inflater, container, false)
        val root = binding.root
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            viewModel = sharedViewModel
            beginningFragment = this@BeginningFragment
        }

        binding.easyButton.setOnClickListener{
            sharedViewModel.setRange("easy")
            findNavController().navigate(R.id.action_beginningFragment_to_problemFragment)
        }

        binding.mediumButton.setOnClickListener{
            sharedViewModel.setRange("medium")
            findNavController().navigate(R.id.action_beginningFragment_to_problemFragment)
        }

        binding.hardButton.setOnClickListener{
            sharedViewModel.setRange("hard")
            findNavController().navigate(R.id.action_beginningFragment_to_problemFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun beginGame() {
        findNavController().navigate(R.id.action_beginningFragment_to_problemFragment)
    }

}