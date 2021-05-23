package com.example.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

/*
This activity alows a user to roll a die and view the result on screen
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val roll_button: Button = findViewById(R.id.button)
        roll_button.setOnClickListener { rollDice() }
    }

    /*
    Roll a die and update the screen with the result
     */
    private fun rollDice() {
        //Create a new Dice object
        val dice = Dice(6)
        val roll = dice.roll()
        val resultTextView: TextView = findViewById(R.id.textView)
        resultTextView.text = roll.toString()
    }
}

/*
This class represents the die, numSides is the number of sides on the die
 */
class Dice(private val numSides: Int) {
    /*
    Function to roll the die
     */
    fun roll(): Int {
        return (1..numSides).random()
    }
}