package com.example.PlacementPrepApp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener


class RetrieveActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var tvLoadingData: TextView
    private lateinit var usersArrayList: ArrayList<Users>
    private lateinit var database: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_retrieve)
        recyclerView = findViewById(R.id.recyclerview)
        recyclerView.layoutManager = LinearLayoutManager(this)

        usersArrayList = arrayListOf()
        database = FirebaseDatabase.getInstance().getReference("Employees")
        database.addValueEventListener(object :ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()){
                    for(datasnapshot in snapshot.children){
                        val user =datasnapshot.getValue(Users::class.java)
                        if(!usersArrayList.contains(user))
                            usersArrayList.add(user!!)
                    }
                }
                recyclerView.adapter = MyAdapter(usersArrayList)
            }
            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(this@RetrieveActivity,error.toString(), Toast.LENGTH_SHORT).show()
            }

        })
    }
}