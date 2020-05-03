package com.roque.rueda.soralgorithms.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.roque.rueda.soralgorithms.databinding.MainFragmentBinding

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private val viewModel: MainViewModel by viewModels()
    private var _bindingView: MainFragmentBinding? = null
    private val bindingView get() = _bindingView!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _bindingView = MainFragmentBinding.inflate(inflater, container, false)
        return bindingView.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _bindingView = null
    }

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?
    ) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.lines.observe(viewLifecycleOwner, Observer { renderLines(it) })
        viewModel.calculateRandomArray()
    }

    private fun renderLines(newArray: IntArray?) {
        val array = newArray ?: return
        bindingView.lineArrayView.linesToDraw = array
    }
}
