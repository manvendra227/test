package com.example.stree

import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.listitem.view.*

class Adapter(private val activity: MainActivity) : RecyclerView.Adapter<Adapter.MyViewHolder>() {

    private var list: List<Products>? = null

    fun setDataList(list: List<Products>?) {
        this.list = list
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.listitem, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(list?.get(position)!!, activity)
    }

    override fun getItemCount(): Int {
        return if (list == null) 0
        else list?.size!!
    }

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val desc = view.desc
        private val price = view.price
        private val image = view.image
        private val rating = view.rating
        private val spec = view.specs
        private val card = view.card

        fun bind(data: Products, activity: MainActivity) {

            desc.text = data.description
            price.text = "\u20B9${data.price.toString()}"
            rating.text = data.rating.toString()
            spec.text = data.brand

            Glide.with(activity)
                .load(Uri.parse(data.thumbnail))
                .into(image)

            card.setOnClickListener{
                Toast.makeText(activity,"Clicked ID number ${data.id}",Toast.LENGTH_SHORT).show()
            }
        }
    }
}