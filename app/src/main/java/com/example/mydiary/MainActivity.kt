package com.example.mydiary

import android.content.Intent
import android.os.Bundle
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mydiary.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), BlogListener {
    lateinit var binding: ActivityMainBinding
    private val adapter = BlogAdapter(this)
    private var blogLauncher: ActivityResultLauncher<Intent>? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getBlog()
        blogLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            if (it.resultCode == RESULT_OK) {
                adapter.addBlog(it.data?.getSerializableExtra("blog") as Blog)
            }
        }
    }

    private fun getBlog() {
        binding.apply {
            rvMain.layoutManager = LinearLayoutManager(this@MainActivity)
            rvMain.adapter = adapter
            addBlog.setOnClickListener {
                blogLauncher?.launch(
                    Intent(
                        this@MainActivity,
                        BlogActivity::class.java
                    )
                )
            }
        }
    }

    override fun onClickToBlog(blog: Blog) {
        startActivity(Intent(this, ContentActivity::class.java)
            .apply {
                putExtra("content", blog)
            })
    }


}