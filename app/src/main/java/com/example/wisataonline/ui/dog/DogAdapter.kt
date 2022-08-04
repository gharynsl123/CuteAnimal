package com.example.wisataonline.ui.dog

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.wisataonline.data.response.DogResponseItem
import com.example.wisataonline.databinding.RowItemListBinding

class DogAdapter : RecyclerView.Adapter<DogAdapter.MyDogHolder>() {

    private var listDog = ArrayList<DogResponseItem>()

    inner class MyDogHolder(val binding: RowItemListBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = MyDogHolder(
        RowItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: MyDogHolder, position: Int) {
        val dataDog = listDog[position]

        holder.binding.apply { Glide.with(imgList).load(dataDog.url).into(imgList) }
    }

    override fun getItemCount(): Int = listDog.size

}