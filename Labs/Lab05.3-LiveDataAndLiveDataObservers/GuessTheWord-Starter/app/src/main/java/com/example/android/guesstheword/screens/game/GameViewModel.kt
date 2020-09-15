package com.example.android.guesstheword.screens.game

import android.os.CountDownTimer
import android.text.format.DateUtils
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel

class GameViewModel: ViewModel() {
    // static(final) constants
    companion object {
        // Time when the game is over
        private const val DONE = 0L

        // Countdown time interval
        private const val ONE_SECOND = 1000L

        // Total time for the game
        private const val COUNTDOWN_TIME = 60_000L
    }

    // Countdown Time
    private val _currentTime = MutableLiveData<Long>()
    val currentTime: LiveData<Long>
        get() = _currentTime

    // "MM:SS" format
    val currentTimeString = Transformations.map(currentTime) { time ->
        // do not include long-running(heavy) tasks
        // since this lambda(closure) functino is executed on the main thread
        DateUtils.formatElapsedTime(time)
    }

    private val timer: CountDownTimer

    // MutableLiveData = can be observed
    // The current word
    private var _word = MutableLiveData<String>()
    val word: LiveData<String>
        get() = _word

    // The current score
    private var _score = MutableLiveData<Int>()
    val score: LiveData<Int>
        get() = _score

    private var _eventGameFinished = MutableLiveData<Boolean>()
    val eventGameFinished: LiveData<Boolean>
        get() = _eventGameFinished

    // The list of words - the front of the list is the next word to guess
    private lateinit var wordList: MutableList<String>


    init {
        _word.value = ""
        _score.value = 0
        _eventGameFinished.value = false
        // create an instance of the subclass of CountDownTimer
        // anonymous class
        timer = object : CountDownTimer(COUNTDOWN_TIME, ONE_SECOND) {
            override fun onTick(p0: Long) {
                // call back method / every 2nd arg this called
                _currentTime.value = p0 / ONE_SECOND
            }

            override fun onFinish() {
                _currentTime.value = DONE
                onGameFinished()
            }
        }
        timer.start()

        resetList()
        nextWord()
        Log.i("GameViewModel", "GameViewModel is created!")
    }

    fun onGameFinished() {
        _eventGameFinished.value = true
    }

    fun onGameFinishedCompelete() {
        _eventGameFinished.value = false
    }

    /**
     * Resets the list of words and randomizes the order
     */
    private fun resetList() {
        wordList = mutableListOf(
                "queen",
                "hospital",
                "basketball",
                "cat",
                "change",
                "snail",
                "soup",
                "calendar",
                "sad",
                "desk",
                "guitar",
                "home",
                "railway",
                "zebra",
                "jelly",
                "car",
                "crow",
                "trade",
                "bag",
                "roll",
                "bubble"
        )
        wordList.shuffle()
    }

    /**
     * Moves to the next word in the list
     */
    private fun nextWord() {
        if (wordList.isNotEmpty()) {
            _word.value = wordList.removeAt(0)
        } else {
//        if (!wordList.isEmpty()) {
            //Select and remove a word from the list
            resetList()
        }
    }



    /** Methods for buttons presses **/

    fun onSkip() {
        // update the Livedata
        _score.value = (_score.value)?.minus(1)
        nextWord()
    }

    fun onCorrect() {
        // update the Livedata
        _score.value = (_score.value)?.plus(1)
        nextWord()
    }


    // called right before this viewModel destroyed
    override fun onCleared() {
        super.onCleared()
        Log.i("GameViewModel", "GameViewModel is destroyed!")
        // to avoid memory leaks
        timer.cancel()
    }
}