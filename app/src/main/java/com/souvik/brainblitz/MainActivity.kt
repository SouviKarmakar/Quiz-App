package com.souvik.brainblitz

import android.annotation.SuppressLint
import android.content.Intent


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast


class MainActivity : AppCompatActivity() {
    @SuppressLint("WrongViewCast", "MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etName: EditText = findViewById(R.id.et_name)
        val goButton: Button = findViewById(R.id.goBtn)


        goButton.setOnClickListener {

            if (etName.text.isEmpty()){
                Toast.makeText(this, "Please Enter your Name", Toast.LENGTH_SHORT).show()
            }else{
                val intent = Intent(this,QuestionsActivity:: class.java)
                intent.putExtra(Constants.USER_NAME, etName.text.toString())
                startActivity(intent)
                finish()
            }
        }




    }
}