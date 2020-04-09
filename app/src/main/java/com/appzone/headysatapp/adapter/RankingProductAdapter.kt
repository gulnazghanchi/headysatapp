package com.appzone.headysatapp.adapter

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.appzone.headysatapp.R
import com.appzone.headysatapp.activity.ProductDetailActivity
import com.appzone.headysatapp.config.Constant
import com.appzone.headysatapp.dataManager.response.ProductListModel
import java.util.*

class RankingProductAdapter(
    private var context: Context,
    productList: ArrayList<ProductListModel>, viewCount: ArrayList<String>
) :
    RecyclerView.Adapter<RankingProductAdapter.MyViewHolder>() {

    private var productList: ArrayList<ProductListModel> = productList
    private var viewCount = viewCount

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var tvProductName: AppCompatTextView = view.findViewById(R.id.tvProductName)
        var tvProductInfo: AppCompatTextView = view.findViewById(R.id.tvProductInfo)
    }

    init {
        setHasStableIds(true)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var itemView: View =
            LayoutInflater.from(parent!!.context)
                .inflate(R.layout.row_ranking_product_list, parent, false)

        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        var rankingProduct: ProductListModel = productList.get(position)

        holder!!.tvProductName.text = rankingProduct.name
        holder!!.tvProductInfo.text = viewCount.get(position)

        holder.itemView.setOnClickListener {
            var bundle = Bundle()
            bundle.putString(Constant.KEY_INTENT_PRODUCT_NAME, rankingProduct.name)
            bundle.putSerializable(Constant.KEY_INTENT_PRODUCT_DETAIL, rankingProduct)
            var intent = Intent(context, ProductDetailActivity::class.java)
            intent.putExtra(Constant.KEY_BUNDLE, bundle)
            context.startActivity(intent)
        }

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