package com.idmdragon.githublist.ui.adapter

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.idmdragon.githublist.databinding.ItemUserBinding
import com.idmdragon.githublist.domain.model.User


class ListAdapter : PagingDataAdapter<User, ListAdapter.ViewHolder>(
    object : DiffUtil.ItemCallback<User>() {
        override fun areItemsTheSame(oldItem: User, newItem: User): Boolean =
            oldItem.userId == newItem.userId

        override fun areContentsTheSame(oldItem: User, newItem: User): Boolean =
            oldItem.userId == newItem.userId
    }
) {

    var onUserClickListener: ((String) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListAdapter.ViewHolder {
        val itemBinding =
            ItemUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: ListAdapter.ViewHolder, position: Int) {
        getItem(position)?.let { holder.bind(it) }
    }

    inner class ViewHolder(private val binding: ItemUserBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: User) {
            with(binding) {
                tvName.text = item.username
                tvRepos.text = item.repoUrl
                tvId.text = item.userId.toString()
                Glide.with(itemView.context)
                    .load(item.avatarUrl)
                    .placeholder(ColorDrawable(Color.WHITE))
                    .into(ivProfile)

                root.setOnClickListener {
                    onUserClickListener?.invoke(item.username)
                }
            }
        }
    }
}