package com.caren.intentsdemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.app.Activity

import androidx.activity.result.ActivityResultCallback

import androidx.activity.result.contract.ActivityResultContracts

import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts.StartActivityForResult


const val INTENT_DATA_NAME = "data"

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.button).setOnClickListener {
            // Take us to SecondActivity
            val i = Intent(this@MainActivity, SecondActivity::class.java)

            // Get the string in the editText
            val userInputtedText = findViewById<EditText>(R.id.editText).text.toString()

            // Pass the string in the intent to SecondActivity
            i.putExtra(INTENT_DATA_NAME, userInputtedText)

            // Call this when we don't expect result back
//            startActivity(i)

            // Call this when we expect result back from SecondActivity
            resultLauncher.launch(i)
        }
    }

    var resultLauncher = registerForActivityResult(StartActivityForResult()) { result ->
        // Code that's called when we come back from SecondActivity
        if (result.resultCode == Activity.RESULT_OK) {
            val data: Intent? = result.data
            val userInputtedStringFromSecondActivity =
                data?.getStringExtra("newUserInputtedString")

            findViewById<EditText>(R.id.editText).setText(userInputtedStringFromSecondActivity)

        }
    }
}