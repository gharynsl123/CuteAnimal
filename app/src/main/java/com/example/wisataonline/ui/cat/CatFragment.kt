package com.example.wisataonline.ui.cat

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.wisataonline.data.CatResponseItem
import com.example.wisataonline.databinding.FragmentCatBinding
import com.example.wisataonline.ui.AnimalViewModel

class CatFragment : Fragment() {
    private var _binding: FragmentCatBinding? = null
    private val binding get() = _binding as FragmentCatBinding

    private var _viewModel: AnimalViewModel? = null
    private val viewModel get() = _viewModel as AnimalViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCatBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _viewModel = activity?.let { ViewModelProvider(it) }?.get(AnimalViewModel::class.java)



        viewModel.apply {
            getDataCat()
            catResponse.observe(viewLifecycleOwner) {
                showData(it)
            }
            isLoading.observe(viewLifecycleOwner) { showLoading(it) }
            isError.observe(viewLifecycleOwner) { showError(it) }
        }

    }

    private fun showData(data: List<CatResponseItem>?) {
        binding.apply {
            data?.let {
                rvCat.layoutManager = GridLayoutManager(activity, 2)
                rvCat.adapter = CatAdapter(data)
            }
        }
    }

    private fun showLoading(isLoading: Boolean?) {
        if (isLoading == true) {
            binding.rvCat.visibility = View.INVISIBLE
            binding.progressMain.visibility = View.VISIBLE

        } else {
            binding.rvCat.visibility = View.VISIBLE
            binding.progressMain.visibility = View.INVISIBLE

        }
    }

    private fun showError(error: Throwable?) {
        Log.e("CatFragment", "showError: $error")
    }


}