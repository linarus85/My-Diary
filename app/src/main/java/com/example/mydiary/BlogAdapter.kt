package com.example.mydiary

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mydiary.databinding.BlogItemBinding

class BlogAdapter(val blogListener: BlogListener) : RecyclerView.Adapter<BlogAdapter.Holder>() {
    val blogList = ArrayList<Blog>()


    class Holder(view: View) : RecyclerView.ViewHolder(view) {
        val binding = BlogItemBinding.bind(view)
        fun bind(blog: Blog, blogListener: BlogListener) = with(binding) {
            imageViewBlogItem.setImageResource(blog.imageId)
            textViewTitleItem.text = blog.title
            itemView.setOnClickListener {
                blogListener.onClickToBlog(blog)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.blog_item, parent, false)
        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(blogList[position], blogListener)
    }

    override fun getItemCount(): Int = blogList.size

    fun addBlog(blog: Blog) {
        blogList.add(blog)
        notifyDataSetChanged()
    }
}