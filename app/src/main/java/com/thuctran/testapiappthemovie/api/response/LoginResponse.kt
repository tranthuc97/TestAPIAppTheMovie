package com.thuctran.testapiappthemovie.api.response

import com.google.gson.annotations.SerializedName

class LoginResponse : java.io.Serializable {
    //implement Serializable vì đây là đối tượng giúp chuyển đổi các trạng của object (giá trị các thuộc tính) thành các byte sao cho chuỗi byte này có thể
    // chuyển đổi ngược lại thành 1 ĐT

    @SerializedName("success")              //khai báo như vậy để match với tên TT dữ liệu lấy được trong postman
    var success:Boolean? = null
    @SerializedName("expires_at")
    var expiresAt:String? = null
    @SerializedName("request_token")
    var requestToken:String? = null

    override fun toString(): String {       //in LoginResponse thành chuỗi
        return "LoginResponse{" +
                "success=$success"+
                ", expiresAt=$expiresAt$" + '\''+
                ", requestToken=$requestToken"+ '\''+
                '}'
    }
}