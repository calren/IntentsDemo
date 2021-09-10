package com.caren.intentsdemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        // Get data passed to us from MainActivity
        val dataFromMainActivity = intent.getStringExtra(INTENT_DATA_NAME)

        // Set the textview to the data passed from MainActivity
        findViewById<TextView>(R.id.textView).text = dataFromMainActivity

        // Set the editText to the data passed from MainActivity
        findViewById<EditText>(R.id.editTextSecondActivity).setText(dataFromMainActivity)

        findViewById<Button>(R.id.button2).setOnClickListener {

            // Get the string inputted in editText
            val newUserInputtedString =
                findViewById<EditText>(R.id.editTextSecondActivity).text.toString()

            // Store the editText string in an intent
            val i = Intent()
            i.putExtra("newUserInputtedString", newUserInputtedString)
            // Pass the intent back to MainActivity
            setResult(RESULT_OK, i)

            // Exit / finish this activity
            finish()
        }
    }
}