package com.example.taipeizoodemo

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_main.view.*

class MainAdapter(private var onItemClickListener: OnItemClickListener?) : RecyclerView.Adapter<MainAdapter.ViewHolder>() {

    private var data = emptyList<MainItem>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(parent)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(data[position])
        holder.itemView.setOnClickListener { onItemClickListener?.onItemClick(position) }
    }

    fun setData(data: List<MainItem>) {
        this.data = data
        notifyDataSetChanged()
    }

    inner class ViewHolder(parent: ViewGroup) :
        RecyclerView.ViewHolder(parent.inflate(R.layout.item_main)) {

        fun bind(item: MainItem) {
            Glide.with(itemView.context).load(item.imageUrl).into(itemView.thumbnail)
            itemView.title.text = item.title
            itemView.subtitle.text = item.subTitle
            itemView.info.text = item.info.takeIf { it.isNotEmpty() } ?: itemView.resources.getString(R.string.no_close_info)
        }
    }
}