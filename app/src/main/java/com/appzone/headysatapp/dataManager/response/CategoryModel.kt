package com.appzone.headysatapp.dataManager.response

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class CategoryModel(
    @SerializedName("categories") val categories: ArrayList<CategoryListModel>,
    @SerializedName("rankings") val rankings: ArrayList<RankingListModel>
)

data class CategoryListModel(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("products") val products: ArrayList<ProductListModel>,
    @SerializedName("child_categories") val child_categories: ArrayList<Int>
)

data class ProductListModel(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("date_added") val date_added: String,
    @SerializedName("variants") val variants: ArrayList<VariantModel>,
    @SerializedName("tax") val tax: TaxModel
) : Serializable

data class VariantModel(
    @SerializedName("id") val id: Int,
    @SerializedName("color") val color: String,
    @SerializedName("size") val size: Int,
    @SerializedName("price") val price: Int
): Serializable

data class TaxModel(
    @SerializedName("name") val name: String,
    @SerializedName("value") val value: Double
): Serializable

data class RankingListModel(
    @SerializedName("ranking") val ranking: String,
    @SerializedName("products") val products: ArrayList<RankingProductListModel>
)

data class RankingProductListModel(
    @SerializedName("id") val id: Int,
    @SerializedName("view_count") val view_count: Int,
    @SerializedName("order_count") val order_count: Int,
    @SerializedName("shares") val shares: Int
)