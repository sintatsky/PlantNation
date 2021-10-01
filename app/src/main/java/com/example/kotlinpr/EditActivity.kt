package com.example.kotlinpr

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlinpr.databinding.ActivityEditBinding

class EditActivity : AppCompatActivity() {
    lateinit var binding: ActivityEditBinding
    private var indexImage: Int = 0
    private var imageId = R.drawable.plant1
    private val imageIdList = listOf(
        R.drawable.plant1,
        R.drawable.plant2,
        R.drawable.plant3,
        R.drawable.plant4,
        R.drawable.plant5,
        R.drawable.plant6,
        R.drawable.plant7,
        R.drawable.plant8,
        R.drawable.plant9
    )



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        initButtons()
    }


    private fun initButtons() = with(binding) {
        buttonNextImage.setOnClickListener {
            indexImage++
            if (indexImage > imageIdList.size - 1) indexImage = 0
            imageId = imageIdList[indexImage]
            imageView.setImageResource(imageId)

        }
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        binding.apply {
            when (item.itemId) {
                android.R.id.home -> finish()
                R.id.upload -> {

                }
                R.id.save -> {
                    val plant = Plant(imageId, edTitle.text.toString(), edDisc.text.toString())
                    val editIntent = Intent().apply {
                        putExtra("plant", plant)
                    }
                    setResult(RESULT_OK, editIntent)
                    finish()

                    //  Toast.makeText(this, "Save", Toast.LENGTH_SHORT).show()
                }
                R.id.delete -> {
                   // Toast.makeText(this, "Delete", Toast.LENGTH_SHORT).show()
                }
            }
            return true
        }

    }
}