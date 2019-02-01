package com.idealorb.tracketv.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.idealorb.tracketv.R
import com.idealorb.tracketv.model.TvShow

class TvShowAdapter(private var moviesList: List<TvShow?>?) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    interface OnClickTvShowListener {
        fun onClickTvShow(tvShow: TvShow)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val context = parent.context
        val itemView = LayoutInflater.from(context)
                .inflate(R.layout.tv_list_item, parent, false)
        return TvShowViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val movieObject = moviesList?.get(position)
        Log.d(TAG, "Tv Show Name: ${movieObject?.name}")
        (holder as TvShowViewHolder).bindView(movieObject)
    }

    fun updateTvShowData(tvShows: List<TvShow?>?){
        DiffUtil.calculateDiff(TvShowDiffCallback(tvShows, moviesList), false).dispatchUpdatesTo(this)
        moviesList = tvShows
        Log.d("TvShowAdapter", "updateTvShowData called")
    }

    override fun getItemCount(): Int {
        Log.d(TAG, "Tv Show List size: ${moviesList!!.size}")
        return moviesList!!.size
    }



    companion object {
        private val TAG = TvShowAdapter::class.java.simpleName
        const val TYPE_HEADER = 0
        const val TYPE_ITEM = 1
    }

}