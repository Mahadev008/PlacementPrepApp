package com.example.PlacementPrepApp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase


class ExpActivity : AppCompatActivity() {

    private lateinit var etEmpName: EditText
    private lateinit var etEmpDesignation: EditText
    private lateinit var etEmpComments: EditText
    private lateinit var etEmpPhone: EditText
    private lateinit var etEmpmail: EditText
    private lateinit var btnSaveData: Button

    private lateinit var dbRef: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exp)


        val seedata = findViewById<Button>(R.id.btnSee);

        seedata.setOnClickListener{
            val intent = Intent(this, RetrieveActivity::class.java)
            startActivity(intent)
        }

        etEmpName = findViewById(R.id.etEmpName)
        etEmpDesignation = findViewById(R.id.etEmpDesignation)
        etEmpComments = findViewById(R.id.etEmpComments)
        etEmpPhone = findViewById(R.id.etPhone)
        etEmpmail = findViewById(R.id.etmail)
        btnSaveData = findViewById(R.id.btnSave)

        dbRef = FirebaseDatabase.getInstance().getReference("Employees")

        btnSaveData.setOnClickListener {
            saveEmployeeData()
        }
    }

    private fun saveEmployeeData() {

        //getting values
        val empName = etEmpName.text.toString()
        val empDesignation = etEmpDesignation.text.toString()
        val empComments = etEmpComments.text.toString()
        val empPhone = etEmpPhone.text.toString()
        val empmail = etEmpmail.text.toString()

        if (empName.isEmpty()) {
            etEmpName.error = "Please Enter Name"
        }
        if (empDesignation.isEmpty()) {
            etEmpDesignation.error = "Please Enter Your Designation with the Organization's Name"
        }
        if (empComments.isEmpty()) {
            etEmpComments.error = "Please leave your Comments!"
        }
        if (empPhone.isEmpty()) {
            etEmpPhone.error = "Please Enter Valid Phone Number"
        }
        if (empmail.isEmpty()) {
            etEmpmail.error = "Please Enter Mailid"
        }

        val empId = dbRef.push().key!!

        val employee = EmployeeModel(empId, empName, empDesignation, empmail, empPhone, empComments)

        dbRef.child(empId).setValue(employee)
            .addOnCompleteListener {
                Toast.makeText(this, "Changes Saved successfully", Toast.LENGTH_LONG).show()

                etEmpName.text.clear()
                etEmpDesignation.text.clear()
                etEmpmail.text.clear()
                etEmpPhone.text.clear()
                etEmpComments.text.clear()


            }.addOnFailureListener { err ->
                Toast.makeText(this, "Error ${err.message}", Toast.LENGTH_LONG).show()
            }

    }

}