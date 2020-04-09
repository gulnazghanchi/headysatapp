package com.appzone.headysatapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.appzone.headysatapp.R
import java.util.*

class SizeAdapter(private var context: Context, variantList: ArrayList<String>) :
    RecyclerView.Adapter<SizeAdapter.MyViewHolder>() {

    private var variantList: ArrayList<String> = variantList
    private var pos: Int = 0

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var tvSize: AppCompatTextView = view.findViewById(R.id.tvSize)
    }

    init {
        setHasStableIds(true)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var itemView: View =
            LayoutInflater.from(parent!!.context).inflate(R.layout.row_size_list, parent, false)

        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        var size: String = variantList.get(position)

        holder!!.tvSize.text = size

        if (pos == position) {
            holder!!.tvSize.setTextColor(ContextCompat.getColor(context, R.color.white))
            holder!!.tvSize.background =
                ContextCompat.getDrawable(context, R.drawable.size_round_border_selected)
        } else {
            holder!!.tvSize.setTextColor(ContextCompat.getColor(context, R.color.colorAccent))
            holder!!.tvSize.background =
                ContextCompat.getDrawable(context, R.drawable.size_round_border_unselected)
        }

    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun getItemCount(): Int {
        return variantList.size
    }

    public fun selectSize(pos: Int) {
        this.pos = pos
        notifyDataSetChanged()
    }
}