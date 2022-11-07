package com.example.mentalmath

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.mentalmath.databinding.FragmentBeginningBinding
import com.example.mentalmath.databinding.FragmentProblemBinding
import com.example.mentalmath.model.MathViewModel


class ProblemFragment : Fragment() {
    private var _binding: FragmentProblemBinding? = null

    private val binding get() = _binding!!

    private val sharedViewModel: MathViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentProblemBinding.inflate(inflater, container, false)
        val root = binding.root
        sharedViewModel.setNumbers(sharedViewModel.range.value)
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            viewModel = sharedViewModel
            problemFragment = this@ProblemFragment
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}