package com.example.colorquiz

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    val quiz = Quiz()
    lateinit var correctColor: ColorName
    lateinit var correctView: View
    var score: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        correctView = makeNewQuiz()
    }

    fun onClickView(view: View) {
        val result = checkAnswer(view)
        changeScore(result)
        correctView = makeNewQuiz()

    }

    fun makeNewQuiz(): View{
        quiz.makeNewQuiz()
        correctColor = quiz.correctColor


        val color1View: View = findViewById(R.id.color_view1)
        val color2View: View = findViewById(R.id.color_view2)
        val cViewList = arrayOf(color1View, color2View)
        val colorLabel: TextView = findViewById(R.id.color_text)

        colorLabel.text = correctColor.name
        val correctNum = (0..1).random()
        cViewList[correctNum].setBackgroundColor(correctColor.color)
        if (correctNum == 0) {
            cViewList[1].setBackgroundColor(quiz.falseColor.color)
        } else {
            cViewList[0].setBackgroundColor(quiz.falseColor.color)
        }
        return cViewList[correctNum]
    }

    fun checkAnswer(view: View) : Boolean{
        if (view == correctView) {
            return true
        }
            return false
    }

    fun changeScore(result: Boolean) {
        val scoreLabel: TextView = findViewById(R.id.score_num_label)
        var word: String
        if (result) {
            score += 1
            word = "Right!"
        } else {
            score -= 1
            word = "Wrong!"
        }
        scoreLabel.text = score.toString()
        Toast.makeText(this, word, Toast.LENGTH_SHORT).show()
    }


}