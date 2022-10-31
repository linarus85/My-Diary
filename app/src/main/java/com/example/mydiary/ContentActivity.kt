package com.example.mydiary

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.mydiary.databinding.ActivityContentBinding

class ContentActivity : AppCompatActivity() {
    lateinit var binding: ActivityContentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityContentBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()
        val content = intent.getSerializableExtra("content") as Blog
        binding.apply {
            imageViewBlogContent.setImageResource(content.imageId)
            tvTitle.text = content.title
            tvDescription.text = content.description
        }
    }
}
