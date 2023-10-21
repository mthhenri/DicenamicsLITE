package com.example.app.appLite.conteudo.pastas

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.app.R

class PastasFragment : Fragment() {

    companion object {
        fun newInstance() = PastasFragment()
    }

    private lateinit var viewModel: PastasViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_pastas, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(PastasViewModel::class.java)
        // TODO: Use the ViewModel
    }

}