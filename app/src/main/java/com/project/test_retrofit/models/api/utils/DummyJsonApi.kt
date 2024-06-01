package com.project.test_retrofit.models.api.utils

import com.project.test_retrofit.models.api.product.CategoriesItem
import com.project.test_retrofit.models.api.product.Product
import com.project.test_retrofit.models.api.product.Products
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.QueryMap

interface DummyJsonApi {

    //region GET products: https://dummyjson.com/docs/products

    //get products
    @GET("products")
    suspend fun getProducts() : Response<Products>

    //get products and add filter by using a map
    //example :
    //
    //limit : limit=10
    //skip : skip=5
    //select : title,price
    //
    //sortBy : sortBy=title // should be field name : title , price , id
    //order : order=asc // "desc" or "asc"
    @GET("products")
    suspend fun getProducts(
       @QueryMap options: Map<String, String>
    ): Response<Products>

    //get product by id
    @GET("products/{id}")
    suspend fun getProduct(
        @Path("id") id : Int
    ) : Response<Product>

    //search
    @GET("products/search")
    suspend fun searchProducts(
        @Query("q") query : String
    ) : Response<Products>

    //get all product categories
    @GET("products/categories")
    suspend fun getCategories() : Response<List<CategoriesItem>>

    //get products category list
    @GET("products/category-list")
    suspend fun getCategoriesList() : Response<List<String>>

    //get products by category
    @GET("products/category/{category}")
    suspend fun getProductsByCategory(
        @Path("category") category : String
    ) : Response<Products>

    //add & update & delete wont work in this api

    //endregion
}