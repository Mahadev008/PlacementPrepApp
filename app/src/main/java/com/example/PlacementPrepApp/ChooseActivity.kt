package com.example.PlacementPrepApp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.PlacementPrepApp.databinding.ActivityChooseBinding

class ChooseActivity : AppCompatActivity() {

    private lateinit var binding: ActivityChooseBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityChooseBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val btn_zoho = findViewById<Button>(R.id.btn_zoho);

        btn_zoho.setOnClickListener{
            val intent = Intent(this, ZohoActivity::class.java)
            startActivity(intent)
        }
    }
}