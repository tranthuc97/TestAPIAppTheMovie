package com.thuctran.testapiappthemovie.api.response

import com.google.gson.annotations.SerializedName

class MovieRes : java.io.Serializable {
    @SerializedName("page")
    var page:Int? = null
    @SerializedName("results")
    var results:MutableList<Result>? = null     //danh sách phim
    @SerializedName("total_pages")
    var totalPages:Int? = null
    @SerializedName("total_results")
    var totalResults:Int? = null

    companion object{
        //tạo ra class Result chứa tập các phần tử bên trong
        class Result : java.io.Serializable{
            @SerializedName("adult")
            var adult:Boolean? = null
            @SerializedName("backdrop_path")
            var backdropPath:String? = null
            @SerializedName("id")
            var id:Int? = null
            @SerializedName("original_title")
            var title:String? = null
            @SerializedName("overview")
            var overview:String? = null
            @SerializedName("poster_path")
            var posterPath:String? = null
            @SerializedName("release_date")
            var releaseDate:String? = null
        }
    }

}