package com.example.colorquiz

import android.graphics.Color


class ColorName (val name: String, val color: Int)


class Quiz (){
    private val quizList: Array<ColorName>
    lateinit var correctColor : ColorName
    lateinit var falseColor : ColorName

    init {
        val cyan = ColorName(name = "Cyan", color = Color.CYAN)
        val blue: ColorName = ColorName(name = "Blue", color = Color.BLUE)
        val yellow: ColorName = ColorName(name = "Yellow", color = Color.YELLOW)
        val red: ColorName = ColorName(name = "Red", color = Color.RED)
        val green: ColorName = ColorName(name = "Green", color = Color.GREEN)
        val magenta: ColorName = ColorName(name = "Magenta", color = Color.MAGENTA)
        val lgray: ColorName = ColorName(name="Light Gray", color = Color.LTGRAY)
        val dkgray: ColorName = ColorName(name="Dark Gray", color = Color.DKGRAY)
        val black: ColorName = ColorName(name="Black", color = Color.BLACK)
        quizList= arrayOf(cyan, blue, yellow, red, green, magenta, lgray, dkgray, black)
    }

    fun makeNewQuiz() {
        val correctNum = (0..8).random()
        var falseNum = (0..8).random()
        while (correctNum == falseNum) {
            falseNum = (0..8).random()
        }
        correctColor = quizList[correctNum]
        falseColor = quizList[falseNum]
    }
}