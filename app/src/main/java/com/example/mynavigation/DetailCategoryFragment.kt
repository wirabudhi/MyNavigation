package com.example.mynavigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.mynavigation.databinding.FragmentDetailCategoryBinding

class DetailCategoryFragment : Fragment() {

    // viewBinding
    private var _binding: FragmentDetailCategoryBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentDetailCategoryBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    // fun onViewCreated
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // get data from DetailCategoryFragmentArgs
        val dataName = DetailCategoryFragmentArgs.fromBundle(arguments as Bundle).name
        val dataDescription = DetailCategoryFragmentArgs.fromBundle(arguments as Bundle).stock

        // set data to textview
        binding.tvCategoryName.text = dataName
        binding.tvCategoryDescription.text = "Stock : $dataDescription"

        // binding btnProfile setOnClickListener
        binding.btnProfile.setOnClickListener (
            // navigate to HomeFragment
            Navigation.createNavigateOnClickListener(R.id.action_detailCategoryFragment_to_homeFragment)
        )
    }

    // onDestroy
    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}