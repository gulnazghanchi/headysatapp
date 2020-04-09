package com.appzone.headysatapp.activity

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.appzone.headysatapp.R
import com.appzone.headysatapp.adapter.CategoryAdapter
import com.appzone.headysatapp.adapter.RankingAdapter
import com.appzone.headysatapp.config.*
import com.appzone.headysatapp.dataManager.response.CategoryModel
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_category_list.*

class CategoryListActivity : BaseActivity() {

    private lateinit var categoryAdapter: CategoryAdapter
    private lateinit var categoryModel: CategoryModel
    private lateinit var rankingAdapter: RankingAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category_list)

        initView()

    }

    private fun initView() {

        categoryModel = Gson().fromJson(Constant.JSON, CategoryModel::class.java)

        categoryAdapter = CategoryAdapter(this, categoryModel.categories)

        rankingAdapter = RankingAdapter(this, categoryModel.rankings, categoryModel.categories)

        val mLayoutManagerHorizonral = LinearLayoutManager(this)
        mLayoutManagerHorizonral.orientation = GridLayoutManager.HORIZONTAL
        rvCategory.layoutManager = mLayoutManagerHorizonral
        rvCategory.itemAnimator = DefaultItemAnimator()
        rvCategory.addItemDecoration(
            ItemOffsetDecoration(
                this,
                R.dimen.dimen_5_dp
            )
        )
        rvCategory.adapter = categoryAdapter

        rvCategory.addOnItemTouchListener(
            RecyclerItemClickListener(this,
                rvCategory, object : RecyclerItemClickListener.OnItemClickListener {
                    override fun onItemClick(view: View, position: Int) {
                        var bundle = Bundle()
                        bundle.putString(
                            Constant.KEY_INTENT_CATEGORY_NAME,
                            categoryModel.categories.get(position).name
                        )
                        bundle.putSerializable(
                            Constant.KEY_INTENT_PRODUCT_LIST,
                            categoryModel.categories.get(position).products
                        )
                        launchWithData(ProductListActivity::class.java, bundle)
                    }

                    override fun onLongItemClick(view: View, position: Int) {

                    }
                })
        )

        val mLayoutManagerHorizonral1 = LinearLayoutManager(this)
        mLayoutManagerHorizonral1.orientation = GridLayoutManager.VERTICAL
        rvRanking.layoutManager = mLayoutManagerHorizonral1
        rvRanking.itemAnimator = DefaultItemAnimator()
        rvRanking.addItemDecoration(
            ItemOffsetDecoration(
                this,
                R.dimen.dimen_5_dp
            )
        )
        rvRanking.adapter = rankingAdapter
    }
}
