package com.example.fuelcalculator.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.fuelcalculator.R
import com.example.fuelcalculator.databinding.FragmentGasPriceBinding
import com.example.fuelcalculator.viewModel.GasCalculatorViewModel

class GasPriceFragment : Fragment() {

    private var _binding: FragmentGasPriceBinding? = null
    private val binding get() = _binding!!

    private val viewModel: GasCalculatorViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGasPriceBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setGasPrice()
        backButton()
    }

    private fun setGasPrice() {
        binding.btnNext.setOnClickListener {

            val gasPriceInput = binding.edtGasPrice.text.toString().toFloatOrNull()

            if (gasPriceInput != null) {
                viewModel.setGasPrice(gasPriceInput)
                findNavController().navigate(R.id.action_gas_to_consumption)
            } else {
                Toast.makeText(requireContext(), R.string.ex_gas_price_toast, Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }

    private fun backButton(){
        binding.ivBack.setOnClickListener {
            findNavController().popBackStack()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
