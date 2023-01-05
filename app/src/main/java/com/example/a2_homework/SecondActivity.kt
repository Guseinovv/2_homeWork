package com.example.a2_homework

import android.view.LayoutInflater
import com.example.a2_homework.databinding.ActivitySecondBinding

class SecondActivity : BaseActivity<ActivitySecondBinding>() {
    private lateinit var adapter: Adapter
    private var images = arrayListOf<Model>()
    override fun inflateViewBinding(inflater: LayoutInflater): ActivitySecondBinding {
        return ActivitySecondBinding.inflate(layoutInflater)
    }

    override fun imageSend() {
        images = intent.getSerializableExtra("key") as ArrayList<Model>
        adapter = Adapter(images, this::onClick)
        binding.selectedRecycler.adapter = adapter
    }

    private fun onClick(model: Model) {

    }

    override fun initView() {
    }

    override fun loadImage() {
    }
}