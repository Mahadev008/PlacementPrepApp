package com.example.PlacementPrepApp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.PlacementPrepApp.databinding.ActivityHomeBinding
import com.google.firebase.auth.FirebaseAuth

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val btn_choosecompany = findViewById<Button>(R.id.btn_choosecompany);

        btn_choosecompany.setOnClickListener{
            val intent = Intent(this, ChooseActivity::class.java)
            startActivity(intent)
        }
        val btn_experience = findViewById<Button>(R.id.btn_experience)

        btn_experience.setOnClickListener {
            val intent = Intent(this, ExpActivity::class.java)
            startActivity(intent)
        }

//  Auth
        auth = FirebaseAuth.getInstance()

        binding.btnLogout.setOnClickListener {
            auth.signOut()
            Intent(this, LoginActivity::class.java).also {
                it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(it)
                Toast.makeText(this, "Logout Successfully!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}