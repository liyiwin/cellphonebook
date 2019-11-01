package com.example.cellphonebook

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(private var contacts: MutableList<Contact>):RecyclerView.Adapter<MyAdapter.ViewHolder>() {

   private var inner :MutableList<Contact> = ArrayList()

    init {
        inner =contacts
    }


    override fun onBindViewHolder(holder: MyAdapter.ViewHolder, position: Int) {
        holder.tv_name.text =  inner[position].name
        holder.tv_phone.text = inner[position].phone
        holder.img_delete.setOnClickListener {
            inner.removeAt(position)
            notifyDataSetChanged()
        }


       }

    override fun getItemCount(): Int {
    return   inner.size   }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter.ViewHolder {

        val view = LayoutInflater
                                 .from(parent.context)
                                 .inflate(R.layout.adapter_row,parent,false)

        return ViewHolder(view)



         }


    inner class ViewHolder(view:View):RecyclerView.ViewHolder(view){

        val tv_name = view.findViewById<TextView>(R.id.tv_name)
        val tv_phone =view.findViewById<TextView>(R.id.tv_phone)
        val img_delete = view.findViewById<ImageView>(R.id.img_delete)

    }
}