package com.thuctran.testapiappthemovie.view.fragment

import androidx.fragment.app.viewModels
import com.thuctran.sampleprojectforall.view.adapter.RecyclerViewAdapter
import com.thuctran.sampleprojectforall.viewmodel.CommonVM
import com.thuctran.testapiappthemovie.R
import com.thuctran.testapiappthemovie.api.response.MovieRes
import com.thuctran.testapiappthemovie.databinding.FragmentListBinding
import com.thuctran.testapiappthemovie.viewmodel.ListMovieVM

class ListFragment : BaseFragment<FragmentListBinding>(){
    companion object {
        val TAG: String = ListFragment::class.java.name
    }
    override val viewModel by viewModels<ListMovieVM>()      //phải khai báo như thế này thì mới sd được viewmodel trong Flagment

    override fun initViewBinding(): FragmentListBinding {
        return FragmentListBinding.inflate(layoutInflater)
    }

    override fun initViews() {
        viewModel.getListMovies()      //call API list
    }

    override fun apiSuccess(key: String, data: Any) {
        val movieRes:MovieRes = data as MovieRes    //lấy thằng MovieRes ra
        if(movieRes.results == null || movieRes.results!!.isEmpty()) showNotify(getString(R.string.txt_list_movie_is_empty))

        val adapter = RecyclerViewAdapter(context1!!,movieRes)
        binding!!.rvList.adapter = adapter
    }
}