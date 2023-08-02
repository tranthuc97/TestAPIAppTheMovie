package com.thuctran.testapiappthemovie

interface OnMainCallBack {
    fun callBack(key:String,data:Any?){}
    fun showFragment(tag:String,data: Any?,isBacked:Boolean){}
    fun closeApp(){}

    fun apiSuccess(key:String,data:Any)   {}      //callback khi call api thành công, data ở đây chính là cái body
    fun apiError(key:String, code:Int, data:Any)       {} //callback khi call api thất bại, data ở đây có thể là thông báo lỗi hoặc errorBody
}