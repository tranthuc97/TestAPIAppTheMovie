package com.thuctran.testapiappthemovie.view.fragment

import android.util.Log
import androidx.fragment.app.viewModels
import com.thuctran.sampleprojectforall.viewmodel.CommonVM
import com.thuctran.testapiappthemovie.CommonUtils
import com.thuctran.testapiappthemovie.databinding.FragmentSplashBinding

class SplashFragment : BaseFragment<FragmentSplashBinding>() {
    var TAG: String = SplashFragment::class.java.name
    override val viewModel by viewModels<CommonVM>()     //phải khai báo như thế này thì mới sd được viewmodel trong Flagment


    override fun initViewBinding(): FragmentSplashBinding {
        return FragmentSplashBinding.inflate(layoutInflater)
    }

    override fun initViews() {
        //2s sau chạy sang MainFragment
        Log.i(TAG, "chạy được đến Login")
        android.os.Handler().postDelayed({
            if (CommonUtils.INSTANCE.getPrefs(LoginFragment().KEY_SESSION_ID) == null) {
                callBack1?.showFragment(LoginFragment().TAG, null, false)       //nếu chưa có sessionID thì nhẩy vào màn hình đăng nhập
            } else {
                callBack1?.showFragment(ListFragment.TAG, null, false)      //có sessionID rồi thì nhảy vào list luôn
            }
        }, 2000)

    }
}