package com.example.wisataonline.ui.cat

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.wisataonline.data.CatResponseItem
import com.example.wisataonline.databinding.RowItemListBinding

class CatAdapter : RecyclerView.Adapter<CatAdapter.MyCatHolder>() {

    private var listCat = ArrayList<CatResponseItem>()

    class MyCatHolder(val binding: RowItemListBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = MyCatHolder(
        RowItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )


    override fun onBindViewHolder(holder: MyCatHolder, position: Int) {
        val dataCat = listCat[position]
        holder.binding.apply { Glide.with(imgList).load(dataCat.url).into(imgList) }
    }

    override fun getItemCount(): Int = listCat.size
}