package com.example.PlacementPrepApp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.PlacementPrepApp.databinding.ActivityZohoBinding

class ZohoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityZohoBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityZohoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val btn_aptitude = findViewById<Button>(R.id.btn_aptitude);
        val btn_hrqns = findViewById<Button>(R.id.btn_hrqns);

        btn_aptitude.setOnClickListener{
            val intent = Intent(this, QuizQuestionsActivity::class.java)
            startActivity(intent)
        }
        btn_hrqns.setOnClickListener{
            val intent = Intent(this, HRQuestions::class.java)
            startActivity(intent)
        }
    }
}