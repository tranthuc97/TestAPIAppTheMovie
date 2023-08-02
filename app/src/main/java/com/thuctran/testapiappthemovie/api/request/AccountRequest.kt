package com.thuctran.testapiappthemovie.api.request

import com.google.gson.annotations.SerializedName

class AccountRequest(userName: String, passWord: String, requestToken: String) {

    @SerializedName("username")              //khai báo như vậy để match với tên TT dữ liệu lấy được trong postman
    private var username:String? = userName
    @SerializedName("password")
    private var password:String? = passWord
    @SerializedName("request_token")
    private var requestToken:String? = requestToken

}