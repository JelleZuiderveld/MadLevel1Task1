package com.example.madlevel1task1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.madlevel1task1.databinding.ActivityHigherLowerBinding
import kotlinx.android.synthetic.main.activity_higher_lower.*

class HigherLowerActivity : AppCompatActivity() {

    private lateinit var binding : ActivityHigherLowerBinding
    private var currentThrow: Int = 1
    private var lastThrow: Int = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHigherLowerBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initViews()
    }

    private fun initViews(){
        binding.btnHigher.setOnClickListener { onHigherClick() }
        binding.btnLower.setOnClickListener { onLowerClick() }
        binding.btnEqual.setOnClickListener { onEqualClick() }
        updateUI()
    }

    private fun updateUI(){
        binding.lastThrow.text = getString(R.string.last_throw,lastThrow)

        when(currentThrow){
            1 -> binding.dice.setImageResource(R.drawable.dice1)
            2 -> binding.dice.setImageResource(R.drawable.dice2)
            3 -> binding.dice.setImageResource(R.drawable.dice3)
            4 -> binding.dice.setImageResource(R.drawable.dice4)
            5 -> binding.dice.setImageResource(R.drawable.dice5)
            6 -> binding.dice.setImageResource(R.drawable.dice6)
        }
    }

    private fun rollDice(){
        lastThrow = currentThrow
        currentThrow = (1..6).random()
        updateUI()
    }

    private fun onHigherClick(){
        rollDice()
        if(currentThrow > lastThrow){
            onAnswerCorrect()
        }else{
            onAnswerIncorrect()
        }
    }

    private fun onLowerClick(){
        rollDice()
        if(currentThrow < lastThrow){
            onAnswerCorrect()
        }else{
            onAnswerIncorrect()
        }
    }

    private fun onEqualClick(){
        rollDice()
        if(currentThrow == lastThrow){
            onAnswerCorrect()
        }else{
            onAnswerIncorrect()
        }
    }

    private fun onAnswerCorrect(){
        Toast.makeText(this, getString(R.string.correct), Toast.LENGTH_SHORT).show()
    }

    private fun onAnswerIncorrect(){
        Toast.makeText(this, getString(R.string.incorrect), Toast.LENGTH_SHORT).show()
    }

}

