package com.example.a31.FindStudentFragment

import android.R.bool
import android.R.string
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.a31.R




class FindStudentFragment : Fragment() {

    companion object {
        fun newInstance() = FindStudentFragment()
    }

    private lateinit var viewModel: FindStudentViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_find_student, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(FindStudentViewModel::class.java)
        // TODO: Use the ViewModel
    }

}