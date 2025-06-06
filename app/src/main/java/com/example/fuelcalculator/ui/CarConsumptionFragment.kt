package com.example.fuelcalculator.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.fuelcalculator.R
import com.example.fuelcalculator.databinding.FragmentCarConsumptionBinding
import com.example.fuelcalculator.viewModel.GasCalculatorViewModel

class CarConsumptionFragment : Fragment() {

    private var _binding: FragmentCarConsumptionBinding? = null
    private val binding get() = _binding!!

    private val viewModel: GasCalculatorViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentCarConsumptionBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        backButton()
       setCarConsumption()
    }

    private fun setCarConsumption(){
        binding.btnNext.setOnClickListener {
            val carConsumptionInput = binding.edtCarConsumption.text.toString().toFloatOrNull()

            if (carConsumptionInput != null) {
                viewModel.setCarConsumption(carConsumptionInput)
                findNavController().navigate(R.id.action_consumption_to_distance)
            } else {
                Toast.makeText(requireContext(), R.string.ex_car_consumption_toast, Toast.LENGTH_SHORT).show()
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