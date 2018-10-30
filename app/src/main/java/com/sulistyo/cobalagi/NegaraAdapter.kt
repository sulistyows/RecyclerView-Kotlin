package com.sulistyo.cobalagi

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.list_item.view.*

class NegaraAdapter(val contex: Context, val mData: List<Negara>) : RecyclerView.Adapter<NegaraAdapter.Holder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val itemView: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item, parent, false)

        return Holder(itemView)
    }

    override fun getItemCount(): Int = mData.size


    override fun onBindViewHolder(holder: Holder, position: Int) {

        holder.negara.text = mData.get(position).negara
        Glide.with(contex).load(mData.get(position).bendera)
            .into(holder.bendera)

    }

    class Holder(view: View) : RecyclerView.ViewHolder(view) {

        val negara = view.negara
        val bendera = view.bendera

    }

}