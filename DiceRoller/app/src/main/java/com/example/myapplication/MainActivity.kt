package com.example.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

/*
This activity alows a user to roll a die and view the result on screen
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener { rollDice() }

        rollDice()
    }

    /*
    Roll a die and update the screen with the result
     */
    private fun rollDice() {
        //Create a new Dice object
        val dice = Dice(6)
        val roll = dice.roll()

        //Find the image view in the layout
        val diceImage: ImageView = findViewById(R.id.imageView)

        //Set which image of a die to use based on the random roll
        val drawableResource = when(roll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        //Set the image view to be the chosen die image
        diceImage.setImageResource(drawableResource)
        diceImage.contentDescription = roll.toString()

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