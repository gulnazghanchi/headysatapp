package com.appzone.headysatapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.appzone.headysatapp.R
import com.appzone.headysatapp.dataManager.response.CategoryListModel
import java.util.*

class CategoryAdapter(private var context: Context, categoryList: ArrayList<CategoryListModel>) :
    RecyclerView.Adapter<CategoryAdapter.MyViewHolder>() {

    private var categoryList: ArrayList<CategoryListModel> = categoryList

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var tvCategoryName: AppCompatTextView = view.findViewById(R.id.tvCategoryName)
    }

    init {
        setHasStableIds(true)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var itemView: View =
            LayoutInflater.from(parent!!.context).inflate(R.layout.row_category_list, parent, false)

        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        var device: CategoryListModel = categoryList.get(position)

        holder!!.tvCategoryName.text = device.name

    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun getItemCount(): Int {
        return categoryList.size
    }
}