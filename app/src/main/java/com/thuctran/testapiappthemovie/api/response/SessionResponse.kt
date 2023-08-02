package com.thuctran.testapiappthemovie.api.response

import com.google.gson.annotations.SerializedName

class SessionResponse : java.io.Serializable {
    //implement Serializable vì đây là đối tượng giúp chuyển đổi các trạng của object (giá trị các thuộc tính) thành các byte sao cho chuỗi byte này có thể
    // chuyển đổi ngược lại thành 1 ĐT

    @SerializedName("success")              //khai báo như vậy để match với tên TT dữ liệu lấy được trong postman
    var success:Boolean? = null
    @SerializedName("session_id")
    var sessionID:String? = null


    override fun toString(): String {       //in LoginResponse thành chuỗi
        return "LoginResponse{" +
                "success=$success"+
                ", session_id=$sessionID$" + '\''+
                ", " +
                '}'
    }
}