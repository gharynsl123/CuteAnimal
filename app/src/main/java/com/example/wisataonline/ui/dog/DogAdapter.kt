package com.example.wisataonline.ui.dog

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.wisataonline.R
import com.example.wisataonline.data.response.DogResponseItem
import com.example.wisataonline.databinding.RowItemListBinding

class DogAdapter(private val listDog: List<DogResponseItem>) :
    RecyclerView.Adapter<DogAdapter.MyDogHolder>() {

    inner class MyDogHolder(val binding: RowItemListBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = MyDogHolder(
        RowItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: MyDogHolder, position: Int) {
        val dataDog = listDog[position]

        holder.binding.apply {
            Glide.with(imgList.context)
                .load(dataDog.url)
                .placeholder(R.drawable.dog_active)
                .into(imgList)
        }
    }

    override fun getItemCount(): Int = listDog.size

}