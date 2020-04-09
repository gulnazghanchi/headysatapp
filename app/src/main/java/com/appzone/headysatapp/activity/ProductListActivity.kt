package com.appzone.headysatapp.activity

import android.os.Bundle
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.GridLayoutManager
import com.appzone.headysatapp.R
import com.appzone.headysatapp.adapter.ProductAdapter
import com.appzone.headysatapp.config.BaseActivity
import com.appzone.headysatapp.config.Constant
import com.appzone.headysatapp.config.ItemOffsetDecoration
import com.appzone.headysatapp.config.getSerializableIntentValue
import com.appzone.headysatapp.dataManager.response.ProductListModel
import kotlinx.android.synthetic.main.activity_product_list.*

class ProductListActivity : BaseActivity() {

    private lateinit var productAdapter: ProductAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_list)

        initView()
    }

    private fun initView() {

        tvTitleProductCategoryList.text = getCategoryName()

        productAdapter = ProductAdapter(this, getProductData())

        val mLayoutManagerHorizonral = GridLayoutManager(this, 3)
        mLayoutManagerHorizonral.orientation = GridLayoutManager.VERTICAL
        rvProduct.layoutManager = mLayoutManagerHorizonral
        rvProduct.itemAnimator = DefaultItemAnimator()
        rvProduct.addItemDecoration(
            ItemOffsetDecoration(
                this,
                R.dimen.dimen_5_dp
            )
        )
        rvProduct.adapter = productAdapter


    }

    private fun getCategoryName(): String {
        return getSerializableIntentValue(this, Constant.KEY_INTENT_CATEGORY_NAME) as String
    }

    /**
     * This method will fetch the gateway details from the another activity
     */
    private fun getProductData(): ArrayList<ProductListModel> {
        return getSerializableIntentValue(
            this,
            Constant.KEY_INTENT_PRODUCT_DETAILS
        ) as ArrayList<ProductListModel>
    }

}
