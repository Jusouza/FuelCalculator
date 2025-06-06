package com.example.fuelcalculator.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.fuelcalculator.R
import com.example.fuelcalculator.databinding.FragmentResultBinding
import com.example.fuelcalculator.viewModel.GasCalculatorViewModel

class ResultFragment : Fragment() {

    private var _binding: FragmentResultBinding? = null
    private val binding get() = _binding!!

    private val viewModel: GasCalculatorViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentResultBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        backButton()
        showResult()
        newCalculation()
    }

    private fun showResult() {
        viewModel.gasPrice.observe(viewLifecycleOwner) { price ->
            binding.tvPriceValue.text = "$price"
        }

        viewModel.carConsumption.observe(viewLifecycleOwner) { consumption ->
            binding.tvConsumptionValue.text = "$consumption"
        }

        viewModel.travelDistance.observe(viewLifecycleOwner) { distance ->
            binding.tvKmValue.text = "$distance"
        }

        viewModel.totalCost.observe(viewLifecycleOwner) { total ->
            if (total != null) {
                binding.tvTotal.text = getString(R.string.format_total, total)
            }
        }
    }

    private fun backButton() {
        binding.ivBack.setOnClickListener {
            findNavController().popBackStack()
        }
    }

    private fun newCalculation() {
        binding.btnNewCalculation.setOnClickListener {
            findNavController().navigate(R.id.action_result_to_start)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}