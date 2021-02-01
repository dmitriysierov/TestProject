package com.example.testproject.ui.activity.main.fragment

import com.example.testproject.R
import com.example.testproject.data.model.NetworkResponse
import com.example.testproject.databinding.FragmentPostsListBinding
import com.example.testproject.ui.adapter.PostsAdapter
import com.example.testproject.ui.base.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class PostFragment : BaseFragment<FragmentPostsListBinding>(R.layout.fragment_posts_list) {

    private val viewModel by viewModel<PostViewModel>()

    private var listAdapter: PostsAdapter? = null

    override fun initUI() {
        initRvAdapter()
        viewModel.getPosts()
    }

    override fun initObservers() {
        viewModel.getPostsData().observe(viewLifecycleOwner, {
            when (it) {
                is NetworkResponse.Loading -> showProgressDialog(it.state)
                is NetworkResponse.Success -> listAdapter?.submitList(it.data)
                is NetworkResponse.Failure -> it.exception.message?.let { exception -> showToast(exception) }
                is NetworkResponse.Error -> showToast(it.message)
            }
        })
    }

    override fun onDestroyView() {
        listAdapter = null
        super.onDestroyView()
    }

    private fun initRvAdapter() {
        listAdapter = PostsAdapter()
        binding.rvPostsList.adapter = listAdapter
    }


}