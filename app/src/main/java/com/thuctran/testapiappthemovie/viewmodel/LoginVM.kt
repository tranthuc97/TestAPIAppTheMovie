package com.thuctran.testapiappthemovie.viewmodel

import android.util.Log
import com.thuctran.sampleprojectforall.viewmodel.BaseViewModel
import com.thuctran.testapiappthemovie.api.request.AccountRequest
import com.thuctran.testapiappthemovie.api.request.RequestTokenReq
import com.thuctran.testapiappthemovie.api.response.LoginResponse

class LoginVM : BaseViewModel() {
    companion object {
        private val TAG: String = LoginVM::class.java.name
         val KEY_API_CREATESESSION_ID: String = "KEY_API_CREATESESSION_ID"
        private val KEY_API_CREATESESSION: String = "KEY_API_CREATESESSION"      //phân biệt các API qua KEY
        private val KEY_API_LOGIN: String = "KEY_API_LOGIN"         //phân biệt các API qua KEY
    }


    private var userName:String? = null
    private var passWord:String? = null


    fun getLogin(userName:String,passWord:String) {
        Log.i(TAG,"get Login...")
        this.userName = userName        //nhập đầu vào userName, passWord ở ngay thằng Login
        this.passWord = passWord
        getAPI().getLogin().enqueue(initHandleResponse(KEY_API_LOGIN))          //gọi xử lý đến initHandleResponse trong thằng Base ViewModel
        //tạo PT Login, nếu login thành công thì chạy đến cái dưới, gặp lỗi sẽ nhờ thằng Fragment Tost lên thông báo Tài khoản hoặc mật khẩu ko phù hợp
    }

    private fun createSession(requestToken: String) {
        getAPI().createSession(AccountRequest(userName!!, passWord!!, requestToken)).enqueue(initHandleResponse(KEY_API_CREATESESSION))
        //nếu tài khoản mật khẩu phù hợp, chạy xuống createSession để tạo phiên đăng nhập với tk, mk và requestToken
    }

    fun createSessionID(requestToken: String) {
        getAPI().createSessionID(RequestTokenReq(requestToken)).enqueue(initHandleResponse(KEY_API_CREATESESSION_ID))
        //tạo được createSession sẽ tiến hành tạo createSessionID
    }

    override fun handleSuccess(key: String, body: Any?) {
        Log.i(TAG, "handleSuccess: $key")      //thành công in ra key
        Log.i(TAG, "handleSuccess: $body")      //thành công in ra body
        if(key == KEY_API_LOGIN){
            createSession((body as LoginResponse).requestToken!!)
        }else if(key == KEY_API_CREATESESSION){
            createSessionID((body as LoginResponse).requestToken!!)
        }else if(key == KEY_API_CREATESESSION_ID){
            callBack!!.apiSuccess(key,body!!)       //data ở đây là cái body
        }
    }

}