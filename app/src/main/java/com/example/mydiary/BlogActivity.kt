package com.example.mydiary

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.example.mydiary.database.AppDatabase
import com.example.mydiary.database.BlogEntity
import com.example.mydiary.databinding.ActivityBlogBinding

class BlogActivity : AppCompatActivity() {
    private lateinit var binding: ActivityBlogBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBlogBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.title = ""
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.blog_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val db = AppDatabase.create(this)
        if (item.itemId == R.id.menu_add_blog) {
            binding.apply {
                val blog = Blog(
                    R.drawable.images,
                    editTextTitle.text.toString(),
                    editTextDescription.text.toString()
                )
                val intent = Intent().apply {
                    putExtra("blog", blog)
                }
                setResult(RESULT_OK, intent)
                finish()
                val saveBlog = BlogEntity(
                    null,
                    editTextTitle.text.toString(),
                    editTextDescription.text.toString()
                )
                Thread{
                    db.blogDao().insert(saveBlog)
                }.start()
            }
        }
        return true
    }

}