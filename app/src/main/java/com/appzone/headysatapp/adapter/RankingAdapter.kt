package com.appzone.headysatapp.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.appzone.headysatapp.R
import com.appzone.headysatapp.config.ItemOffsetDecoration
import com.appzone.headysatapp.dataManager.response.CategoryListModel
import com.appzone.headysatapp.dataManager.response.ProductListModel
import com.appzone.headysatapp.dataManager.response.RankingListModel
import java.util.*

class RankingAdapter(
    private var context: Context,
    rankingList: ArrayList<RankingListModel>,
    categoryList: ArrayList<CategoryListModel>
) :
    RecyclerView.Adapter<RankingAdapter.MyViewHolder>() {

    private var rankingList: ArrayList<RankingListModel> = rankingList
    private lateinit var rankingProductAdapter: RankingProductAdapter
    private var categoryList = categoryList

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var tvRankingName: AppCompatTextView = view.findViewById(R.id.tvRankingName)
        var rvRankingProducts: RecyclerView = view.findViewById(R.id.rvRankingProducts)
    }

    init {
        setHasStableIds(true)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var itemView: View =
            LayoutInflater.from(parent!!.context).inflate(R.layout.row_ranking_list, parent, false)

        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        var ranking: RankingListModel = rankingList.get(position)

        holder!!.tvRankingName.text = ranking.ranking

        var listProduct = ArrayList<ProductListModel>()
        var listViewCount = ArrayList<String>()

        for (k in 0 until ranking.products.size) {
            for (i in 0 until categoryList.size) {
                for (j in 0 until categoryList.get(i).products.size) {
                    if (ranking.products.get(k).id == categoryList.get(i).products.get(j).id) {
                        Log.d("ProductName", categoryList.get(i).products.get(j).name)
                        listProduct.add(categoryList.get(i).products.get(j))
                        if (ranking.ranking.toLowerCase().contains("view"))
                            listViewCount.add("View: " + ranking.products.get(k).view_count)
                        if (ranking.ranking.toLowerCase().contains("order"))
                            listViewCount.add("Ordered: " + ranking.products.get(k).order_count)
                        if (ranking.ranking.toLowerCase().contains("share"))
                            listViewCount.add("Shares: " + ranking.products.get(k).shares)
                    }
                }
            }
        }

        Log.d("List", listProduct.toString())

        rankingProductAdapter = RankingProductAdapter(context, listProduct, listViewCount)

        val mLayoutManagerHorizonral = LinearLayoutManager(context)
        mLayoutManagerHorizonral.orientation = GridLayoutManager.HORIZONTAL
        holder!!.rvRankingProducts.layoutManager = mLayoutManagerHorizonral
        holder!!.rvRankingProducts.itemAnimator = DefaultItemAnimator()
        holder!!.rvRankingProducts.addItemDecoration(
            ItemOffsetDecoration(
                context,
                R.dimen.dimen_5_dp
            )
        )
        holder!!.rvRankingProducts.adapter = rankingProductAdapter

    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun getItemCount(): Int {
        return rankingList.size
    }
}