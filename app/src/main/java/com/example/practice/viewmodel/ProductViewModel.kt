package com.example.practice.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.practice.model.ProductModel
import com.example.practice.repository.ProductRepo

class ProductViewModel (val repo : ProductRepo) : ViewModel() {

    fun addProduct(
                   model: ProductModel,
                   callback: (Boolean, String) -> Unit
    ){
        repo.addProduct(model, callback)
    }

    fun editProduct(
                    model: ProductModel,
                    callback: (Boolean, String) -> Unit
    ){
        repo.editProduct(model,callback)
    }

    fun deleteProduct( productId: String, callback: (Boolean, String) -> Unit){
        repo.deleteProduct(productId,callback)
    }

    private val _products = MutableLiveData<ProductModel?>()
    val products : MutableLiveData<ProductModel?> get() = _products

    private val _allProducts = MutableLiveData<List<ProductModel>?>()
    val allProducts : MutableLiveData<List<ProductModel>?> get() = _allProducts

    private val _loading = MutableLiveData<Boolean>()
    val loading : MutableLiveData<Boolean> get() = _loading

    fun getProductById(productID:String){
        repo.getProductById(productID){
                success,msg,data->
            if(success){
                _products.postValue(data)
            }
        }
    }

    fun getAllProduct(){
        _loading.postValue(true)
        repo.getAllProduct{
                success,msg,data->
            if(success){
                _loading.postValue(false)
                _allProducts.postValue(data)
            }
        }
    }

    private val _allProductsCategory = MutableLiveData<List<ProductModel>?>()
    val allProductsCategory : MutableLiveData<List<ProductModel>?> get() = _allProductsCategory

    fun getProductByCategory(categoryId:String){
        repo.getProductByCategory(categoryId){
                success,msg,data->
            if(success){
                _allProductsCategory.postValue(data)
            }
        }
    }
}