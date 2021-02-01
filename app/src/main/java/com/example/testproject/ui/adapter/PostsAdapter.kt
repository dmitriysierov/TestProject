package com.example.testproject.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.testproject.data.model.response.PostResponseItem
import com.example.testproject.databinding.ItemPostsBinding


class PostsAdapter : ListAdapter<PostResponseItem, PostsAdapter.PostsViewHolder>(DIFFER) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = PostsViewHolder(
        ItemPostsBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
    )

    override fun onBindViewHolder(holder: PostsViewHolder, position: Int) {
        getItem(position)?.let { holder.bind(it) }
    }

    inner class PostsViewHolder(private val binding: ItemPostsBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(postResponseItem: PostResponseItem) {
            binding.post = postResponseItem
        }
    }

    companion object {
        private val DIFFER = object : DiffUtil.ItemCallback<PostResponseItem>() {
            override fun areItemsTheSame(
                oldItem: PostResponseItem,
                newItem: PostResponseItem
            ) = oldItem.id == newItem.id

            override fun areContentsTheSame(
                oldItem: PostResponseItem,
                newItem: PostResponseItem
            ) = oldItem == newItem
        }
    }
}