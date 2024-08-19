package com.base.base_source.ui.chrome


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.base.base_source.databinding.ItemSearchTrendBinding

data class SearchTrendData(
    val item: String
)

class ChromeAdapter(private val searchTrendList: List<SearchTrendData>) :
    RecyclerView.Adapter<ChromeAdapter.ChromeViewHolder>() {

    inner class ChromeViewHolder(private val binding: ItemSearchTrendBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(searchTrendData: SearchTrendData) {
            binding.trendText.text = searchTrendData.item;
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChromeViewHolder {
        val binding = ItemSearchTrendBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ChromeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ChromeViewHolder, position: Int) {
        holder.bind(searchTrendList[position])
    }

    override fun getItemCount(): Int {
        return searchTrendList.size
    }
}
