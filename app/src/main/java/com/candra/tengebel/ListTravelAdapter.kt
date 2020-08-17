package com.candra.tengebel


import android.media.browse.MediaBrowser
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class ListTravelAdapter(private val listTravel: ArrayList<Travel>) : RecyclerView.Adapter<ListTravelAdapter.ListViewHolder>() {

    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: Travel)
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        var tvAddress: TextView = itemView.findViewById(R.id.tv_item_adress)
        var imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ListViewHolder {
        val view: View = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_row_hero, viewGroup, false)

        return ListViewHolder(view)

    }

    override fun getItemCount(): Int {
        return listTravel.size
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val travel = listTravel[position]

        Glide.with(holder.itemView.context)
            .load(travel.photo)
            .apply(RequestOptions().override(80, 80))
            .into(holder.imgPhoto)

        holder.tvName.text = travel.name
        holder.tvAddress.text = travel.address

        holder.itemView.setOnClickListener { onItemClickCallback.onItemClicked(listTravel[holder.adapterPosition]) }


    }
}