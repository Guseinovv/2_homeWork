package com.example.a2_homework

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.a2_homework.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val list = arrayListOf<Model>()

    private val listSelect = arrayListOf<Model>()

    private lateinit var adapter: Adapter

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        loadImage()
        initView()
        imageSend()
    }

    fun imageSend() {
        list.add(Model(R.drawable.img_italy, true))
        list.add(Model(R.drawable.img_imperial_japan, true))
        list.add(Model(R.drawable.img_third_reich, true))
        list.add(Model(R.drawable.img_imperial_japan, true))
        list.add(Model(R.drawable.img_italy, true))
        list.add(Model(R.drawable.img_italy, true))
        list.add(Model(R.drawable.img_imperial_japan, true))
        list.add(Model(R.drawable.img_third_reich, true))
        list.add(Model(R.drawable.img_imperial_japan, true))
        list.add(Model(R.drawable.img_italy, true))
    }

    private fun initView() {

        adapter = Adapter(list, this::onClick)
        binding.recyclerview.adapter = adapter
    }

    private fun onClick(imageModel: Model) {
        imageModel.select = !imageModel.select
        if (imageModel.select) {
            listSelect.add(imageModel)
        } else {
            listSelect.remove(imageModel)
        }
    }

    fun loadImage() {
        binding.btnSend.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("key", listSelect)
            startActivity(intent)
        }


    }
}