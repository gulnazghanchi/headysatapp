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

class ColorAdapter(private var context: Context, variantList: ArrayList<String>) :
    RecyclerView.Adapter<ColorAdapter.MyViewHolder>() {

    private var variantList: ArrayList<String> = variantList
    private var pos: Int = 0

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var tvColor: AppCompatTextView = view.findViewById(R.id.tvColor)
    }

    init {
        setHasStableIds(true)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var itemView: View =
            LayoutInflater.from(parent!!.context).inflate(R.layout.row_color_list, parent, false)

        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        var color: String = variantList.get(position)

        holder!!.tvColor.text = color

        if (pos == position) {
            if (color.toLowerCase().contains("red")) {
                holder.tvColor.background =
                    ContextCompat.getDrawable(context, R.drawable.red_color_round_border_selected)
                holder!!.tvColor.setTextColor(ContextCompat.getColor(context, R.color.white))
            } else if (color.toLowerCase().contains("blue")) {
                holder.tvColor.background =
                    ContextCompat.getDrawable(context, R.drawable.blue_color_round_border_selected)
                holder!!.tvColor.setTextColor(ContextCompat.getColor(context, R.color.white))
            } else if (color.toLowerCase().contains("white")) {
                holder.tvColor.background =
                    ContextCompat.getDrawable(context, R.drawable.white_color_round_border_selected)
                holder!!.tvColor.setTextColor(ContextCompat.getColor(context, R.color.white))
            } else if (color.toLowerCase().contains("black")) {
                holder.tvColor.background =
                    ContextCompat.getDrawable(context, R.drawable.white_color_round_border_selected)
                holder!!.tvColor.setTextColor(ContextCompat.getColor(context, R.color.white))
            } else if (color.toLowerCase().contains("yellow")) {
                holder.tvColor.background =
                    ContextCompat.getDrawable(
                        context,
                        R.drawable.yellow_color_round_border_selected
                    )
                holder!!.tvColor.setTextColor(ContextCompat.getColor(context, R.color.white))
            } else if (color.toLowerCase().contains("golden")) {
                holder.tvColor.background =
                    ContextCompat.getDrawable(
                        context,
                        R.drawable.golden_color_round_border_selected
                    )
                holder!!.tvColor.setTextColor(ContextCompat.getColor(context, R.color.white))
            } else if (color.toLowerCase().contains("silver")) {
                holder.tvColor.background =
                    ContextCompat.getDrawable(
                        context,
                        R.drawable.silver_color_round_border_selected
                    )
                holder!!.tvColor.setTextColor(ContextCompat.getColor(context, R.color.white))
            } else if (color.toLowerCase().contains("grey")) {
                holder.tvColor.background =
                    ContextCompat.getDrawable(context, R.drawable.grey_color_round_border_selected)
                holder!!.tvColor.setTextColor(ContextCompat.getColor(context, R.color.white))
            } else if (color.toLowerCase().contains("brown")) {
                holder.tvColor.background =
                    ContextCompat.getDrawable(context, R.drawable.grey_color_round_border_selected)
                holder!!.tvColor.setTextColor(ContextCompat.getColor(context, R.color.white))
            }
        } else {
            if (color.toLowerCase().contains("red")) {
                holder.tvColor.background =
                    ContextCompat.getDrawable(context, R.drawable.red_color_round_border_unselected)
                holder!!.tvColor.setTextColor(ContextCompat.getColor(context, R.color.red))
            } else if (color.toLowerCase().contains("blue")) {
                holder.tvColor.background =
                    ContextCompat.getDrawable(
                        context,
                        R.drawable.blue_color_round_border_unselected
                    )
                holder!!.tvColor.setTextColor(ContextCompat.getColor(context, R.color.blue))
            } else if (color.toLowerCase().contains("white")) {
                holder.tvColor.background =
                    ContextCompat.getDrawable(
                        context,
                        R.drawable.white_color_round_border_unselected
                    )
                holder!!.tvColor.setTextColor(ContextCompat.getColor(context, R.color.black))
            } else if (color.toLowerCase().contains("black")) {
                holder.tvColor.background =
                    ContextCompat.getDrawable(
                        context,
                        R.drawable.white_color_round_border_unselected
                    )
                holder!!.tvColor.setTextColor(ContextCompat.getColor(context, R.color.black))
            } else if (color.toLowerCase().contains("yellow")) {
                holder.tvColor.background =
                    ContextCompat.getDrawable(
                        context,
                        R.drawable.yellow_color_round_border_unselected
                    )
                holder!!.tvColor.setTextColor(ContextCompat.getColor(context, R.color.yellow))
            } else if (color.toLowerCase().contains("golden")) {
                holder.tvColor.background =
                    ContextCompat.getDrawable(
                        context,
                        R.drawable.golden_color_round_border_unselected
                    )
                holder!!.tvColor.setTextColor(ContextCompat.getColor(context, R.color.golden))
            } else if (color.toLowerCase().contains("silver")) {
                holder.tvColor.background =
                    ContextCompat.getDrawable(
                        context,
                        R.drawable.silver_color_round_border_unselected
                    )
                holder!!.tvColor.setTextColor(ContextCompat.getColor(context, R.color.silver))
            } else if (color.toLowerCase().contains("grey")) {
                holder.tvColor.background =
                    ContextCompat.getDrawable(
                        context,
                        R.drawable.grey_color_round_border_unselected
                    )
                holder!!.tvColor.setTextColor(ContextCompat.getColor(context, R.color.grey))
            } else if (color.toLowerCase().contains("brown")) {
                holder.tvColor.background =
                    ContextCompat.getDrawable(
                        context,
                        R.drawable.grey_color_round_border_unselected
                    )
                holder!!.tvColor.setTextColor(ContextCompat.getColor(context, R.color.grey))
            }
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