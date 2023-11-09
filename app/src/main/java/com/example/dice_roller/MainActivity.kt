package com.example.dice_roller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import android.widget.ImageView
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import splashScreenandroid12.mainViewmodel
import androidx.activity.viewModels
import java.util.Random

class MainActivity : AppCompatActivity() {

    private val viewModel:mainViewmodel by viewModels()



    lateinit var diceImage: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen().apply {
            setKeepOnScreenCondition{
                viewModel.isLoading.value
            }
        }

        setContentView(R.layout.activity_main)

        val rollButton:Button = findViewById(R.id.roll_button)
        rollButton.text="Lets roll"
        rollButton.setOnClickListener{
            rollDice()
            
        }
        diceImage = findViewById(R.id.dice_image) // if we write this piece of code inside the rollDice()
        // then findViewById() will be called a lot of times ( whenever
        // we call the function rollDice i.e whenever we execute rollButton.setOnClickListener
        // program control will execute findViewById function increasing the time complexity
    }

    public fun rollDice() {

        val randomInt=Random().nextInt(6)+1

        val drawableResource=when(randomInt) // what ever number generated then that numbered dice
            // image will be viewed in the app
        {
            1->R.drawable.dice_1
            2->R.drawable.dice_2
            3->R.drawable.dice_3
            4->R.drawable.dice_4
            5->R.drawable.dice_5
            6->R.drawable.dice_6
            else -> {
                print("invalid number generated")
                R.drawable.dice_1 // Provide a default drawable resource here
            }
        }
        //val diceImage:ImageView=fieldViewById(R.id.dice_image)
        diceImage.setImageResource(drawableResource)
    }
}

