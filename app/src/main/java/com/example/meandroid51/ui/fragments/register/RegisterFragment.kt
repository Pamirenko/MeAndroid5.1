package com.example.meandroid51.ui.fragments.register

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.meandroid51.R
import com.example.meandroid51.databinding.FragmentRegisterBinding
import com.example.meandroid51.ui.fragments.home.UserInfoViewModel

class RegisterFragment : Fragment() {
    private var _binding: FragmentRegisterBinding? = null
    private val binding get() = _binding!!


    private lateinit var viewModel: RegisterViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRegisterBinding.inflate(inflater, container, false)
        val view = binding.root
        viewModel = ViewModelProvider(this)[RegisterViewModel::class.java]
        viewModel.initiaLize(requireContext())
        binding.registerFragment.setOnClickListener{


            val username = binding.editTextUsername.text.toString()
            val age = binding.editTextAge.text.toString().toInt()
            val email = binding.editTextEmail.text.toString()
            val password = binding.editTextPassword.text.toString()

            viewModel.registerUser(username, age, email, password)
            findNavController().navigate(R.id.action_registerFragment_to_userInfoFragment)
        }

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}