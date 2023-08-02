package com.thuctran.testapiappthemovie.api

import com.thuctran.testapiappthemovie.api.request.AccountRequest
import com.thuctran.testapiappthemovie.api.request.RequestTokenReq
import com.thuctran.testapiappthemovie.api.response.LoginResponse
import com.thuctran.testapiappthemovie.api.response.MovieRes
import com.thuctran.testapiappthemovie.api.response.SessionResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST

const val API_KEY: String = "9d668d908fd4f22e43f042fca07b8cd9"      //trong interface, khai báo hằng số phải khai báo cost val bên ngoài
interface API {

    @GET("authentication/token/new")       //định nghĩa TYPE, lấy từ phần subPath + queries param (endPoint)
    @Headers("Authorization:Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI5ZDY2OGQ5MDhmZDRmMjJlNDNmMDQyZmNhMDdiOGNkOSIsInN1YiI6IjY0YTBmYTQxZDUxOTFmMDBmZjhiZjYxMCIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.AiFwl1nQkl8Qd13t6HJKhNOmKNMLTAjId7NbfdY6ekI")           //định nghĩa Headers, lấy từ postman, cái này cũng để match dữ liệu ok
    fun getLogin():Call<LoginResponse>          //đây là khai báo PT, trả về Call<LoginResponse>, tức là trả về respon của thằng Login

    @POST("authentication/token/validate_with_login")
    @Headers("Authorization:Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI5ZDY2OGQ5MDhmZDRmMjJlNDNmMDQyZmNhMDdiOGNkOSIsInN1YiI6IjY0YTBmYTQxZDUxOTFmMDBmZjhiZjYxMCIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.AiFwl1nQkl8Qd13t6HJKhNOmKNMLTAjId7NbfdY6ekI")
    fun createSession(@Body acc:AccountRequest):Call<LoginResponse>         //PT Call từ một bản tin request đến một bản tin response tương ứng, POST mới có body của thằng Request
                                                                            // hiểu là 1 PT có body của thằng Request, sau đó sẽ call đến một thằng Response tương ứng
    @POST("authentication/session/new")
    @Headers("Authorization:Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI5ZDY2OGQ5MDhmZDRmMjJlNDNmMDQyZmNhMDdiOGNkOSIsInN1YiI6IjY0YTBmYTQxZDUxOTFmMDBmZjhiZjYxMCIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.AiFwl1nQkl8Qd13t6HJKhNOmKNMLTAjId7NbfdY6ekI")
                                                                            fun createSessionID(@Body tokenReq:RequestTokenReq):Call<SessionResponse>

    @GET("discover/movie?include_adult=false&include_video=false&language=en-US&page=1&sort_by=popularity.desc")
    @Headers("Authorization:Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI5ZDY2OGQ5MDhmZDRmMjJlNDNmMDQyZmNhMDdiOGNkOSIsInN1YiI6IjY0YTBmYTQxZDUxOTFmMDBmZjhiZjYxMCIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.AiFwl1nQkl8Qd13t6HJKhNOmKNMLTAjId7NbfdY6ekI")
    fun getListMovies(): Call<MovieRes>


}