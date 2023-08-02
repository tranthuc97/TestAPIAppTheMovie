package com.thuctran.testapiappthemovie.api.request

import com.google.gson.annotations.SerializedName

class RequestTokenReq (//khai báo như vậy để match với tên TT dữ liệu lấy được trong postman
    @SerializedName("request_token")
    var requestToken: String
) {
}