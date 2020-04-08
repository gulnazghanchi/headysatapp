package com.appzone.headysatapp.activity

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.appzone.headysatapp.R
import com.appzone.headysatapp.adapter.CategoryAdapter
import com.appzone.headysatapp.config.*
import com.appzone.headysatapp.dataManager.response.CategoryModel
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_category_list.*

class CategoryListActivity : BaseActivity() {

    private lateinit var categoryAdapter: CategoryAdapter
    private lateinit var categoryModel: CategoryModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category_list)

        initView()

    }

    private fun initView() {

        setTitle(getString(R.string.category_activity_name))

        categoryModel = Gson().fromJson(Constant.JSON, CategoryModel::class.java)

        categoryAdapter = CategoryAdapter(this, categoryModel.categories)

        val mLayoutManagerHorizonral = LinearLayoutManager(this)
        mLayoutManagerHorizonral.orientation = GridLayoutManager.VERTICAL
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
                        bundle.putSerializable(
                            Constant.KEY_INTENT_PRODUCT_DETAILS,
                            categoryModel.categories.get(position).products
                        )
                        launchWithData(ProductListActivity::class.java, bundle)
                    }

                    override fun onLongItemClick(view: View, position: Int) {

                    }
                })
        )

    }
}
