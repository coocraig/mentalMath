package com.example.mentalmath

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.mentalmath.databinding.FragmentProblemBinding
import com.example.mentalmath.databinding.FragmentResultsBinding
import com.example.mentalmath.model.MathViewModel


class ResultsFragment : Fragment() {
            private var _binding: FragmentResultsBinding? = null

            private val binding get() = _binding!!

            private val sharedViewModel: MathViewModel by activityViewModels()

            override fun onCreate(savedInstanceState: Bundle?) {
                super.onCreate(savedInstanceState)
            }

            override fun onCreateView(
                inflater: LayoutInflater, container: ViewGroup?,
                savedInstanceState: Bundle?
            ): View? {
                _binding = FragmentResultsBinding.inflate(inflater, container, false)
                val root = binding.root
                sharedViewModel.updatePoints()
                return root
            }

            override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
                super.onViewCreated(view, savedInstanceState)
                binding.apply {
                    viewModel = sharedViewModel
                    resultsFragment = this@ResultsFragment
                }
            }

            override fun onDestroyView() {
                super.onDestroyView()
                _binding = null
            }

            fun backAgain()
            {
                findNavController().navigate(R.id.action_resultsFragment_to_problemFragment)
            }

        }