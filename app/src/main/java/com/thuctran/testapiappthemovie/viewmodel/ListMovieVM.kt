package com.thuctran.testapiappthemovie.viewmodel

import android.util.Log
import com.thuctran.sampleprojectforall.viewmodel.BaseViewModel
import com.thuctran.testapiappthemovie.api.response.LoginResponse
import com.thuctran.testapiappthemovie.api.response.MovieRes


class ListMovieVM : BaseViewModel() {
    companion object {
        var TAG:String = ListMovieVM::class.java.name
         var KEY_API_LIST_MOVIE: String = "KEY_API_LIST_MOVIE)"
    }
    fun getListMovies(){
        Log.i(TAG,"getListMovies...")
        getAPI().getListMovies().enqueue(initHandleResponse(KEY_API_LIST_MOVIE))         //gọi xử lý đến initHandleResponse trong thằng Base ViewModel
    }

}