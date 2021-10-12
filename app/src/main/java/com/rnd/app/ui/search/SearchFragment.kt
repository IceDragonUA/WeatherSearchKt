package com.rnd.app.ui.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.rnd.app.databinding.FragmentSearchBinding
import com.rnd.app.extension.root
import com.rnd.app.ui.main.toolbar.SearchViewListener

class SearchFragment : Fragment(), SearchViewListener {

    private var binding: FragmentSearchBinding? = null
    private val rootView get() = binding!!.root

    private val viewModel: SearchViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSearchBinding.inflate(inflater, container, false)
        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activity?.root()?.initSearchListeners(this@SearchFragment)
        viewModel.items.observe(viewLifecycleOwner, {
            binding?.list?.setItems(it)
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    override fun searchQuery(text: String) {
        viewModel.search(text)
    }
}
