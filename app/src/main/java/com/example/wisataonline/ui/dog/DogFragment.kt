package com.example.wisataonline.ui.dog

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.wisataonline.databinding.FragmentDogBinding
import com.example.wisataonline.ui.AnimalViewModel

class DogFragment : Fragment() {

    private var _binding: FragmentDogBinding? = null
    private val binding get() = _binding as FragmentDogBinding

    private var _viewModel: AnimalViewModel? = null
    private val viewModel get() = _viewModel as AnimalViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDogBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _viewModel = activity?.let { ViewModelProvider(it) }?.get(AnimalViewModel::class.java)

        binding.apply {
            rvDog.layoutManager = GridLayoutManager(activity, 2)
            rvDog.adapter = DogAdapter()
        }

        viewModel.apply {
            getDataCatAndDog()
            dogResponse.observe(viewLifecycleOwner) { DogAdapter() }
            isLoading.observe(viewLifecycleOwner) { showLoading(it) }
            isError.observe(viewLifecycleOwner) { showError(it) }
        }
    }

    private fun showError(error: Throwable?) {
        Log.e("DogFragment", "showError: $error")
    }

    private fun showLoading(isLoading: Boolean?) {
        if (isLoading == true) {
            binding.apply {
                rvDog.visibility = View.INVISIBLE
                progressMain.visibility = View.VISIBLE
            }
        } else {
            binding.apply {
                rvDog.visibility = View.VISIBLE
                progressMain.visibility = View.INVISIBLE
            }
        }
    }

}