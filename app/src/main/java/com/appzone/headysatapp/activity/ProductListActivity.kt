package com.appzone.headysatapp.activity

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.GridLayoutManager
import com.appzone.headysatapp.R
import com.appzone.headysatapp.adapter.ProductAdapter
import com.appzone.headysatapp.config.*
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

        rvProduct.addOnItemTouchListener(
            RecyclerItemClickListener(this,
                rvProduct, object : RecyclerItemClickListener.OnItemClickListener {
                    override fun onItemClick(view: View, position: Int) {
                        var bundle = Bundle()
                        bundle.putString(
                            Constant.KEY_INTENT_PRODUCT_NAME, getProductData().get(position).name
                        )
                        bundle.putSerializable(
                            Constant.KEY_INTENT_PRODUCT_DETAIL,
                            getProductData().get(position)
                        )
                        launchWithData(ProductDetailActivity::class.java, bundle)
                    }

                    override fun onLongItemClick(view: View, position: Int) {

                    }
                })
        )


    }

    private fun getCategoryName(): String {
        return getSerializableIntentValue(this, Constant.KEY_INTENT_CATEGORY_NAME) as String
    }

    /**
     * This method will fetch the product list details from the another activity
     */
    private fun getProductData(): ArrayList<ProductListModel> {
        return getSerializableIntentValue(
            this,
            Constant.KEY_INTENT_PRODUCT_LIST
        ) as ArrayList<ProductListModel>
    }

}
