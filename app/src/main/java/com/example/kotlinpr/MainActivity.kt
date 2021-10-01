package com.example.kotlinpr

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.SnapHelper
import com.example.kotlinpr.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    private val adapter = PlantAdapter()
    private var editLauncher: ActivityResultLauncher<Intent>? = null
    private val faqFragment = FAQFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        binding.bottomNavig.selectedItemId = R.id.local_florist
        binding.bottomNavig.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.add_flower ->{
                    editLauncher?.launch(Intent(this@MainActivity, EditActivity::class.java))
                }
                R.id.local_florist ->{

                }
                R.id.question_answer -> {
//                    supportFragmentManager
//                        .beginTransaction()
//                        .replace(R.id.rcView, FAQFragment.newInstance())
//                        .commit()
                }

            }
            true
        }
        init()
        editLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            if (it.resultCode == RESULT_OK){
                adapter.addPlant(it.data?.getSerializableExtra("plant") as Plant)
            }
        }
    }

    private fun init() = with(binding) {
        rcView.layoutManager = LinearLayoutManager(this@MainActivity,
            LinearLayoutManager.HORIZONTAL, false)
        rcView.adapter = adapter


        val snapHelper: SnapHelper = LinearSnapHelper()
        snapHelper.attachToRecyclerView(rcView)
    }








}