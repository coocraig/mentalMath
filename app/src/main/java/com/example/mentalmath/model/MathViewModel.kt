package com.example.mentalmath.model

import android.view.MenuItem
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel



class MathViewModel : ViewModel() {
    private final val easyRange = (2..10)
    private final val mediumRange = (11..100)
    private final val hardRange = (101..999)

    //range to be used for the random number
    private val _range = MutableLiveData<IntRange?>((1..999))
    val range: LiveData<IntRange?> = _range

    //The larger number (number on top)
    private val _largeNumber = MutableLiveData<Int?>()
    val largeNumber: LiveData<Int?> = _largeNumber

    //The larger number (number on bottom)
    private val _smallNumber = MutableLiveData<Int?>()
    val smallNumber: LiveData<Int?> = _smallNumber

    //The answer given
    private val _answer = MutableLiveData<String?>()
    val answer: LiveData<String?> = _answer

    //The string for if the answer is correct or incorrect
    private val _resultText = MutableLiveData<String?>()
    val resultText: LiveData<String?> = _resultText

    //The string for if the answer is correct or incorrect
    private val _pointsResultText = MutableLiveData<String?>()
    val pointsResultText: LiveData<String?> = _pointsResultText

    //Score for the game (hopefully initializes with 0 as a value)
    private val _score = MutableLiveData<Int?>(0)
    val score: LiveData<Int?> = _score

    fun setRange(diff: String) {
        if(diff.equals("easy")){
            _range.value = easyRange
        }
        if(diff.equals("medium")){
            _range.value = mediumRange
        }
        if(diff.equals("hard")){
            _range.value = hardRange
        }
    }


    //Randomly sets the numbers
    fun setNumbers(largeRange: IntRange?) {
        _smallNumber.value = (2..9).random()
        _largeNumber.value = largeRange?.random()
    }

    fun setAnswer(response: String){
        _answer.value = response
    }

    fun updatePoints() {
        if(_answer.value?.toInt() == _largeNumber.value!! * _smallNumber.value!!)
        {
            _score.value = 10 + _score.value!!
            _resultText.value = "CORRECT!"
            _pointsResultText.value = "+10 POINTS"
        } else {
            _resultText.value = "WRONG!"
            _pointsResultText.value = "+0 POINTS"
        }
    }


}