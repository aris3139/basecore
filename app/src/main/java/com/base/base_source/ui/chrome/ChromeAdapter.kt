package com.base.base_source.ui.chrome


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.base.base_source.R
import com.base.base_source.data.entities.SearchItem
import com.base.base_source.databinding.ItemSearchTrendBinding

class ChromeAdapter(
    private val searchTrendList: List<SearchItem>,
    private val isSearch: Boolean,
    private val itemClickListener: OnItemClickListener
) : RecyclerView.Adapter<ChromeAdapter.ChromeViewHolder>() {

    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }

    inner class ChromeViewHolder(private val binding: ItemSearchTrendBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            binding.root.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    itemClickListener.onItemClick(position)
                }
            }
        }

        fun bind(searchTrendData: SearchItem) {
            if (isSearch) {
                binding.trendIcon.setImageResource(R.drawable.search_24px)
            } else {
                binding.trendIcon.setImageResource(R.drawable.trending_icon)
            }
            binding.trendText.text = searchTrendData.title
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChromeViewHolder {
        val binding =
            ItemSearchTrendBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ChromeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ChromeViewHolder, position: Int) {
        holder.bind(searchTrendList[position])
    }

    override fun getItemCount(): Int {
        return searchTrendList.size
    }
}
