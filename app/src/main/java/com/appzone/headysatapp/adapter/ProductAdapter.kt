package com.appzone.headysatapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.appzone.headysatapp.R
import com.appzone.headysatapp.dataManager.response.ProductListModel
import java.util.*

class ProductAdapter(private var context: Context, productList: ArrayList<ProductListModel>) :
    RecyclerView.Adapter<ProductAdapter.MyViewHolder>() {

    private var productList: ArrayList<ProductListModel> = productList

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var tvProductName: AppCompatTextView = view.findViewById(R.id.tvProductName)
    }

    init {
        setHasStableIds(true)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var itemView: View =
            LayoutInflater.from(parent!!.context).inflate(R.layout.row_product_list, parent, false)

        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        var device: ProductListModel = productList.get(position)

        holder!!.tvProductName.text = device.name

    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun getItemCount(): Int {
        return productList.size
    }
}