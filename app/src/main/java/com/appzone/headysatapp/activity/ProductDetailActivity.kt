package com.appzone.headysatapp.activity

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.appzone.headysatapp.R
import com.appzone.headysatapp.adapter.ColorAdapter
import com.appzone.headysatapp.adapter.SizeAdapter
import com.appzone.headysatapp.config.*
import com.appzone.headysatapp.dataManager.response.ProductListModel
import kotlinx.android.synthetic.main.activity_product_detail.*
import kotlinx.android.synthetic.main.content_product_detail.*
import java.util.*
import kotlin.collections.ArrayList


class ProductDetailActivity : BaseActivity() {

    private lateinit var sizeAdapter: SizeAdapter
    private lateinit var colorAdapter: ColorAdapter
    private var selectedSize: String = ""
    private var selectedColor: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_detail)

        initView()
    }

    private fun initView() {

        title = getProductName()

        setSupportActionBar(toolbar)

        try {
            selectedSize = getProductDetail().variants.get(0).size.toString()
            selectedColor = getProductDetail().variants.get(0).color.toString()
            tvProductPrice.text = "Rs. " + getProductDetail().variants.get(0).price.toString()
        } catch (e: IndexOutOfBoundsException) {
            e.printStackTrace()
        } catch (e: Exception) {
            e.printStackTrace()
        }

        var sizeList = ArrayList<String>()
        for (i in 0 until getProductDetail().variants.size) {
            sizeList.add(getProductDetail().variants.get(i).size.toString())
        }

        var sizeFinalList = sizeList
        var uniqueGas = HashSet<String>(sizeFinalList)

        val list = ArrayList<String>(uniqueGas)
        list.sort()

        sizeAdapter = SizeAdapter(this, list)

        val mLayoutManagerHorizonral = LinearLayoutManager(this)
        mLayoutManagerHorizonral.orientation = GridLayoutManager.HORIZONTAL
        rvSize.layoutManager = mLayoutManagerHorizonral
        rvSize.itemAnimator = DefaultItemAnimator()
        rvSize.addItemDecoration(
            ItemOffsetDecoration(
                this,
                com.appzone.headysatapp.R.dimen.dimen_5_dp
            )
        )
        rvSize.adapter = sizeAdapter

        rvSize.addOnItemTouchListener(
            RecyclerItemClickListener(this,
                rvSize, object : RecyclerItemClickListener.OnItemClickListener {
                    override fun onItemClick(view: View, position: Int) {
                        Log.d("Size ", list.get(position))
                        sizeAdapter.selectSize(position)

                        selectedSize = list.get(position)

                        for (i in 0 until getProductDetail().variants.size) {
                            if (list.get(position).toString() ==
                                getProductDetail().variants.get(i).size.toString()
                            ) {
                                if (selectedColor == getProductDetail().variants.get(i).color) {
                                    tvProductPrice.text =
                                        "Rs. " + getProductDetail().variants.get(i).price.toString()
                                }
                            }
                        }
                    }

                    override fun onLongItemClick(view: View, position: Int) {

                    }
                })
        )

        var colorList = ArrayList<String>()
        for (i in 0 until getProductDetail().variants.size) {
            colorList.add(getProductDetail().variants.get(i).color)
        }

        var colorFinalList = colorList
        var uniqueColor = HashSet<String>(colorFinalList)

        val listColor = ArrayList<String>(uniqueColor)
        listColor.sort()

        colorAdapter = ColorAdapter(this, listColor)

        val mLayoutManagerHorizonral1 = LinearLayoutManager(this)
        mLayoutManagerHorizonral1.orientation = GridLayoutManager.HORIZONTAL
        rvColors.layoutManager = mLayoutManagerHorizonral1
        rvColors.itemAnimator = DefaultItemAnimator()
        rvColors.addItemDecoration(
            ItemOffsetDecoration(
                this,
                com.appzone.headysatapp.R.dimen.dimen_5_dp
            )
        )
        rvColors.adapter = colorAdapter

        rvColors.addOnItemTouchListener(
            RecyclerItemClickListener(this,
                rvColors, object : RecyclerItemClickListener.OnItemClickListener {
                    override fun onItemClick(view: View, position: Int) {

                        colorAdapter.selectSize(position)

                        selectedColor = listColor.get(position)

                        for (i in 0 until getProductDetail().variants.size) {
                            if (listColor.get(position) == getProductDetail().variants.get(i).color) {
                                if (selectedSize == getProductDetail().variants.get(i).size.toString()) {
                                    tvProductPrice.text =
                                        "Rs. " + getProductDetail().variants.get(i).price.toString()
                                }
                            }
                        }
                    }

                    override fun onLongItemClick(view: View, position: Int) {

                    }
                })
        )
    }


    private fun getProductName(): String {
        return getSerializableIntentValue(this, Constant.KEY_INTENT_PRODUCT_NAME) as String
    }

    /**
     * This method will fetch the product detail from the another activity
     */
    private fun getProductDetail(): ProductListModel {
        return getSerializableIntentValue(
            this,
            Constant.KEY_INTENT_PRODUCT_DETAIL
        ) as ProductListModel
    }
}
