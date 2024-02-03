package com.example.meandroid51.ui.fragments.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.meandroid51.data.model.UserInfo

import com.example.meandroid51.databinding.FragmentInfoBinding


class UserInfoFragment : Fragment() {
    private var _binding: FragmentInfoBinding? = null
    private val binding get() = _binding!!



    private lateinit var viewModel: UserInfoViewModel


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentInfoBinding.inflate(inflater,container, false)
        val view = binding.root

        viewModel = ViewModelProvider(this)[UserInfoViewModel::class.java]

        viewModel.
        userInfoLiveData.observe(viewLifecycleOwner){ userInfo ->
            updateUI(userInfo)
        }
        return view

    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
private fun updateUI (userInfo: UserInfo){
    binding.textViewUsername.text = userInfo.username
    binding.textViewAge.text = userInfo.age.toString()
    binding.textViewEmail.text = userInfo.email
    binding.textViewPassword.text = userInfo.password
}
}





