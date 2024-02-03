package com.example.meandroid51.ui.fragments.edit

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.meandroid51.R
import com.example.meandroid51.databinding.FragmentEditBinding

class EditFragment : Fragment() {
    private var _binding:FragmentEditBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: EditFragmentViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentEditBinding.inflate(inflater,container, false)
        val view = binding.root

        viewModel = ViewModelProvider(this)[EditFragmentViewModel::class.java]
        viewModel.initialize(requireContext())
        viewModel.LoadUserInfo()

        binding.buttonSaveChanges.setOnClickListener{
            val newUsername = binding.editTextNewUsername.text.toString()
            val newAge = binding.editTextNewAge.text.toString().toInt()
            val newEmail = binding.editTextNewEmail.text.toString()
            val newPassword = binding.editTextNewPassword.text.toString()

            viewModel.siveChanges(newUsername , newAge, newEmail, newPassword)
            findNavController().navigateUp()
        }
        return view
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}