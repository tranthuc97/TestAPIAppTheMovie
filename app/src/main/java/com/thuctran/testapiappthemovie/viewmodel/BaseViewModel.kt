package com.thuctran.sampleprojectforall.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.thuctran.testapiappthemovie.OnMainCallBack
import com.thuctran.testapiappthemovie.api.API
import com.thuctran.testapiappthemovie.viewmodel.LoginVM
import okhttp3.OkHttpClient
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

open class BaseViewModel : ViewModel() {
    private val BASE_URL:String = "https://api.themoviedb.org/3/"    //base_url lấy đến sau dấu / đầu tiên
    companion object {
        val TAG:String = BaseViewModel::class.java.name
    }
    protected var callBack:OnMainCallBack? = null
    var CALLBACK:OnMainCallBack? = null
        set(value) {
            field = value
            callBack = field
        }

    protected final fun getAPI():API{
        val rs: Retrofit = Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())     //đọc bằng GSon
            .client(OkHttpClient.Builder().callTimeout(30, TimeUnit.SECONDS).build())        //mạng có vấn đề thì cài đặt KH chờ 30s
            .build()
        return rs.create(API::class.java)            //ánh xạ API
    }

    protected fun <T> initHandleResponse(key:String): Callback<T> {     //dữ liệu đưa vào chưa biết là respon nào thì để là T
        return object : Callback<T> {        //object : Callback<LoginResponse>{} để implement các PT Callback
            override fun onResponse(call: Call<T>, response: Response<T>) {
                if(response.code() == 200 || response.code() == 201){
                    handleSuccess(key, response.body())      //nếu code là 200 hoặc 201 thì call thành công, in ra body
                }else{
                    handleFail(key, response.code(), response.errorBody())        //nếu không trùng code thì gọi đến PT này
                }
            }

            override fun onFailure(call: Call<T>, t: Throwable) {
                Log.i(TAG,"onFailure... "+t.message)    //nếu call thất bại thì hiện xem lỗi gì, t chính là lỗi, nguyên nhân có thể do mất mạng hoặc lỗi sever
                handleException(key,t)
            }
        }
    }

    protected open fun handleException(key: String, t: Throwable) {
        callBack!!.apiError(key,999,t.message!!)       //data chính là thông báo lỗi t.message
    }

    protected open fun handleFail(key: String, code:Int, responseBody: ResponseBody?) {
        Log.i(TAG, "handleFail: $code")        //call lỗi in ra code lỗi
        callBack!!.apiError(key,code,responseBody!!)        //data là cái responseBody (hay ở trên khai báo là errorBody)
    }

    protected open fun handleSuccess(key:String, body: Any?) {
        callBack!!.apiSuccess(key,body!!)       //data ở đây là cái body
    }
}