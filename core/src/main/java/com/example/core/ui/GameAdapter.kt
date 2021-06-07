package com.example.core.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.core.R
import com.example.core.databinding.ItemListGameBinding
import com.example.core.domain.model.Game

class GameAdapter : RecyclerView.Adapter<GameAdapter.ListViewHolder>() {

    private var listData = ArrayList<Game>()
    var onItemClick: ((Game) -> Unit)? = null

    fun setData(newListData: List<Game>) {
        if (newListData == null ) return
        listData.clear()
        listData.addAll(newListData)
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameAdapter.ListViewHolder {
        return ListViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_list_game, parent, false))
    }

    override fun onBindViewHolder(holder: GameAdapter.ListViewHolder, position: Int) {
        val data = listData[position]
        holder.bind(data)
    }

    override fun getItemCount(): Int {
        return listData.size
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val binding = ItemListGameBinding.bind(itemView)

        fun bind(data: Game) {
            with(binding) {
                Glide.with(itemView.context)
                    .load(data.background_image)
                    .into(ivBackgroundImage)

                tvName.text = data.name
                tvReleased.text = data.released
            }
        }

        init {
            binding.root.setOnClickListener {
                onItemClick?.invoke(listData[adapterPosition])
            }
        }

    }

}