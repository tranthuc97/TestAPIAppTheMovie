package com.thuctran.testapiappthemovie.view.fragment

import android.content.Intent
import android.net.Uri
import android.util.Log
import androidx.fragment.app.viewModels
import com.thuctran.sampleprojectforall.viewmodel.CommonVM
import com.thuctran.testapiappthemovie.CommonUtils
import com.thuctran.testapiappthemovie.api.response.SessionResponse
import com.thuctran.testapiappthemovie.databinding.FragmentLoginBinding
import com.thuctran.testapiappthemovie.viewmodel.LoginVM

class LoginFragment : BaseFragment<FragmentLoginBinding>() {
    val KEY_SESSION_ID: String = "KEY_SESSION_ID"
    var TAG: String = LoginFragment::class.java.name
    override val viewModel by viewModels<LoginVM>()     //phải khai báo như thế này thì mới sd được viewmodel trong Flagment


    override fun initViewBinding(): FragmentLoginBinding {
        return FragmentLoginBinding.inflate(layoutInflater)
    }

    override fun initViews() {
        binding!!.btLogin.setOnClickListener{
            viewModel.getLogin(binding!!.edtUserName.text.toString(),binding!!.edtPassword.text.toString())     //tiến hành call API login
        }

        binding!!.tvRegister.setOnClickListener{
            openRegisterLink()
        }
    }

    private fun openRegisterLink() {
        var link:String = "https://www.themoviedb.org/resend-email-verification"        //link dẫn đến trang đăng kí tk trên web themovie
        var intent = Intent(Intent.ACTION_VIEW)     //sử dụng intent để truy cập link web
        intent.data = Uri.parse(link)
        startActivity(intent)
    }

    override fun apiError(key: String, code: Int, data: Any) {
        if(code == 401){
            showNotify("Tài khoản hoặc mật khẩu ko phù hợp ")
        }else{
            showNotify("Error: $code, $data")
        }
    }

    override fun apiSuccess(key: String, data: Any) {
        if(key==LoginVM.KEY_API_CREATESESSION_ID){
            var res:SessionResponse = data as SessionResponse       //data ở đây chính là cái body, lưu vào savePrefs
            CommonUtils.INSTANCE.savePrefs(KEY_SESSION_ID,res.sessionID!!)      //lưu sessionID
            showNotify("Login thành công...")
            callBack1!!.showFragment(ListFragment.TAG,null,false)
        }
    }


}