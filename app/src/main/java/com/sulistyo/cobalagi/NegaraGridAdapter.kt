package com.sulistyo.cobalagi

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.grid_item.view.*

class NegaraGridAdapter(val contex: Context, val mData: List<Negara>) :
    RecyclerView.Adapter<NegaraGridAdapter.Holder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val itemView: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.grid_item, parent, false)

        return Holder(itemView)
    }

    override fun getItemCount(): Int = mData.size


    override fun onBindViewHolder(holder: Holder, position: Int) {

        Glide.with(contex).load(mData.get(position).bendera)
            .into(holder.bendera)

    }

    class Holder(view: View) : RecyclerView.ViewHolder(view) {

        val bendera = view.benderaGrid

    }

}