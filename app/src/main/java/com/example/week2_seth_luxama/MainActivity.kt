package com.example.week2_seth_luxama

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.TextView
import android.widget.RelativeLayout

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val button1= findViewById<ImageView>(R.id.imageView)
        var Layout1 = findViewById<LinearLayout>(R.id.linear)
        var screen = findViewById<RelativeLayout>(R.id.main)
        var questionplace=findViewById<TextView>(R.id.textView)


        fun xam(){
            if (Layout1.visibility == View.VISIBLE){
                Layout1.visibility=View.INVISIBLE
                button1.setImageResource(R.drawable.myec_foreground)

            }else{
                Layout1.visibility=View.VISIBLE
                button1.setImageResource(R.drawable.myeo_foreground)
            }
        }

        button1.setOnClickListener (){
            xam()
        }

        fun checkAnswer(correctView: TextView, clickedView: TextView, allOptions: List<TextView>) {
            // Reset tout
//            allOptions.forEach { it.setBackgroundResource(R.drawable.texde) }
            //fel paka klike anko
            allOptions.forEach { it.isClickable = false }
            if (clickedView == correctView) {
                // Correct answer

                clickedView.setBackgroundResource(R.drawable.correctb)


            } else {
                // Move repons
                clickedView.setBackgroundResource(R.drawable.incorrectb)
                correctView.setBackgroundResource(R.drawable.correctb)

            }
        }

        val option1 = findViewById<TextView>(R.id.textView2)
        val option2 = findViewById<TextView>(R.id.textView3)
        val option3 = findViewById<TextView>(R.id.textView4)

        val allOptions = listOf(option1, option2, option3)

// korek repns
        val correctAnswer = option3

        option1.setOnClickListener {
            checkAnswer(correctAnswer, option1, allOptions) }
        option2.setOnClickListener {
            checkAnswer(correctAnswer, option2, allOptions) }
        option3.setOnClickListener {
            checkAnswer(correctAnswer, option3, allOptions) }

        questionplace.setOnClickListener {
            allOptions.forEach {
                it.setBackgroundResource(R.drawable.texde)
                it.isClickable = true   // Reactivate options again
            }
        }

    }
}