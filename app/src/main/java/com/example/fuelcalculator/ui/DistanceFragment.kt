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
import com.example.fuelcalculator.databinding.FragmentDistanceBinding
import com.example.fuelcalculator.viewModel.GasCalculatorViewModel

class DistanceFragment : Fragment() {

    private var _binding: FragmentDistanceBinding? = null
    private val binding get() = _binding!!

    private val viewModel: GasCalculatorViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDistanceBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setDistance()
        backButton()
    }

    private fun setDistance(){
        binding.btnNext.setOnClickListener {
            val distanceInput = binding.edtDistance.text.toString().toFloatOrNull()
            if (distanceInput != null){
                viewModel.setDistance(distanceInput)
                viewModel.calculateTotal()
                findNavController().navigate(R.id.action_distance_to_result)
            } else{
                Toast.makeText(requireContext(), R.string.ex_distance_toast, Toast.LENGTH_SHORT).show()
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