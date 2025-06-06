package com.example.fuelcalculator.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.fuelcalculator.R
import com.example.fuelcalculator.databinding.FragmentStartCalculatorBinding
import com.example.fuelcalculator.viewModel.GasCalculatorViewModel

class StartCalculatorFragment : Fragment() {

    private var _binding: FragmentStartCalculatorBinding? = null
    private val binding get() = _binding!!

    private val viewModel: GasCalculatorViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentStartCalculatorBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.reset()

        binding.btnStart.setOnClickListener {
            findNavController().navigate(R.id.action_start_to_gas)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}