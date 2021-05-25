package com.example.todays_cafe

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.layout_intro_pager_item.view.*


class MyIntroPagerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val itemBg = itemView.pager_item_bg
    private val itemFrame = itemView.pager_item_frame
    private val itemContent = itemView.pager_item_text

    fun bindWithView(pageItem: PageItem){
        itemBg.setBackgroundResource(pageItem.imageSrc)
        itemFrame.setBackgroundResource(pageItem.frame)
        itemContent.text = pageItem.content
    }
}