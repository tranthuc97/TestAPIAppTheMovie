package com.thuctran.sampleprojectforall.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.thuctran.testapiappthemovie.R
import com.thuctran.testapiappthemovie.api.response.MovieRes

import com.thuctran.testapiappthemovie.model.ClassModel

class RecyclerViewAdapter(private var context: Context, private var movieRes:MovieRes) : RecyclerView.Adapter<RecyclerViewAdapter.ClassHolder>() {

    //từ item_view trong res/layout ta ánh xạ thành ClassHolder(inflate)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClassHolder {
        val view:View =LayoutInflater.from(context).inflate(R.layout.item_film, parent,false)
        return ClassHolder(view)
    }

    //PT định nghĩa số lượng item để đúc
    override fun getItemCount(): Int {
        return movieRes.results!!.size
    }

    //ClassHolder lấy ở thằng class bên dưới, đây là PT đưa vào số lượng itemdata, để nhét dữ liệu tương ứng của từng data vào từng ClassHolder
    override fun onBindViewHolder(holder: ClassHolder, position: Int) {
        val data: MovieRes.Companion.Result = movieRes.results!![position] //thay Any bằng tên Model tương ứng
        //ta có thể lấy dữ liệu của từng Model ở vị trí position

        holder.tvDetail?.text = data.overview       //set dữ liệu của các TT theo data
        holder.tvTitle?.text = data.title
        holder.tvDate?.text = data.releaseDate
        Glide.with(context).load(data.posterPath).into(holder.ivPost!!)     //dùng Glide để đọc ảnh từ link
    }

    //Holder ở đây có nghĩa là đồ đựng
    inner class ClassHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        //tại đây có thể khai báo từng ĐT View tương ứng của thằng itemView. VD: var tvStoryName:TextView = itemView.findViewById(R.id.tv_story_name)
        //muốn setOnclick cho từng ĐT View khai báo thì phải đặt trong khố init
        var tvTitle:TextView?= null     //khai báo các TT của layout
        var tvDetail:TextView?= null
        var tvDate:TextView?= null
        var ivPost:ImageView? = null
        init {
            tvTitle = itemView.findViewById(R.id.tvTitleFilm)
            tvDetail = itemView.findViewById(R.id.tvDetailFilm)
            tvDate = itemView.findViewById(R.id.tvDateFilm)
            ivPost = itemView.findViewById(R.id.ivAvatarFilm)
        }

    }

}