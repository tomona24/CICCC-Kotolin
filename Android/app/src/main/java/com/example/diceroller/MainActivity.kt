package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // alt + enter : auto import
//        val rollBtn: Button = findViewById(R.id.roll_btn)
//        rollBtn.setOnClickListener{
//            rollDice()
//        }
    }

//    private fun rollDice() {
//        val resultText: TextView = findViewById(R.id.result_text)
//        val randomInt = (1..6).random()
//        resultText.text = randomInt.toString()
//        Toast.makeText(this, "button clicked!", Toast.LENGTH_SHORT).show()
//        // this means "MainActivity"
//    }

    fun onRollButtonClicked(view: View) {
//        rollDice()
        val diceImage: ImageView = findViewById(R.id.dice_image)
        val randInt = (1..6).random()
        var drawableRes = when (randInt) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            6 -> R.drawable.dice_6
            else -> R.drawable.dice_6
        }
        diceImage.setImageResource(drawableRes)
        Toast.makeText(this, "button clicked!", Toast.LENGTH_SHORT).show()
    }
}