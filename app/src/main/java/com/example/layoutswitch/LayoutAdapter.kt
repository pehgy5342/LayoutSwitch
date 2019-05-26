package com.example.layoutswitch

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.two_item.view.*
import kotlinx.android.synthetic.main.one_item.view.*

class LayoutAdapter(val mylist: ArrayList<LayoutData>, val layoutManager: GridLayoutManager) :
    RecyclerView.Adapter<LayoutAdapter.CustomHolder>() {


    companion object {

        val oneLayout = 1
        val twoLayout = 2


    }

    override fun getItemViewType(position: Int): Int {


        val spanCount = layoutManager.spanCount
        return when (spanCount) {

            1 -> oneLayout
            else -> twoLayout
        }


    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomHolder {

        val view_one = LayoutInflater.from(parent.context).inflate(R.layout.one_item, parent, false)
        val view_two = LayoutInflater.from(parent.context).inflate(R.layout.two_item, parent, false)

         when (viewType) {


            oneLayout -> {
                return CustomHolder(view_one, viewType)
            }


            else -> {
                return CustomHolder(view_two, viewType)
            }


        }


    }

    override fun getItemCount(): Int = mylist.size

    override fun onBindViewHolder(holder: CustomHolder, position: Int) {

        holder.bind(mylist[position])


    }


    inner class CustomHolder(itemView: View, var viewType: Int) : RecyclerView.ViewHolder(itemView) {

        var oName = itemView.tv_linear
        var oImage = itemView.iv_linear
        var like = itemView.tv_likeNum
        var comment = itemView.tv_commentNum

        var tImage = itemView.iv_grid
        var tName = itemView.tv_grid

        fun bind(data: LayoutData) {

            when (viewType) {
                oneLayout -> {
                    oName.text = data.name
                    Glide.with(itemView.context).load(data.image).into(this.oImage)
                    like.text = data.like
                    comment.text = data.comment
                }

                twoLayout -> {

                    Glide.with(itemView.context).load(data.image).into(this.tImage)
                    tName.text = data.name


                }
            }

        }


    }


}