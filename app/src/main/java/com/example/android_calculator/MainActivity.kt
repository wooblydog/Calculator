package com.example.android_calculator

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.android_calculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val num = findViewById<TextView>(R.id.calcInput)
        val AC: Button = binding.AC
        val sign: Button = binding.sign
        val division: Button = binding.division
        val percent: Button = binding.percent
        val num7: Button = binding.num7
        val num8: Button = binding.num8
        val num9: Button = binding.num9
        val multiplication: Button = binding.multiplication
        val num4: Button = binding.num4
        val num5: Button = binding.num5
        val num6: Button = binding.num6
        val subtraction: Button = binding.subtraction
        val num1: Button = binding.num1
        val num2: Button = binding.num2
        val num3: Button = binding.num3
        val summa: Button = binding.summa
        val num0: Button = binding.num0
        val dot: Button = binding.dot
        val answer: Button = binding.answer

        var preNum = 0f
        var calc = 0f
        var count = 0
        var clicked = false
        var dclicked=false
        var sclicked=false
        var mclicked= false
        var pclicked = false
        var rclicked = false
        var isCleared = false
        var signed = false


        answer.setOnClickListener {
            val num_text : String = num.text.toString()
            if( count == 0 ){
            }
            else if(dclicked) {
                calc = preNum / num_text.toFloat()
                dclicked = false
                num.text = calc.toString()
                clicked = true
                rclicked = true
            }
            else if(sclicked){
                calc = preNum - num_text.toFloat()
                num.setText(calc.toString())
                sclicked = false
                clicked = true
                rclicked = true
            }
            else if(mclicked == true){
                calc = preNum * num_text.toFloat()
                mclicked = false
                num.text = calc.toString()
                clicked = true
                rclicked = true
            }
            else if(pclicked){
                calc = preNum + num_text.toFloat()
                pclicked = false
                num.text = calc.toString()
                clicked = true
                rclicked = true
            }

        }

        AC.setOnClickListener{
            preNum=0f
            calc = 0f
            count = 0
            clicked = false
            dclicked=false
            sclicked=false
            mclicked= false
            pclicked = false
            signed = false
            num.text = ""
        }
        percent.setOnClickListener{
            if(num.text.toString() == ""){
            }
            else{
                val num_text: Float = num.text.toString().toFloat()
                val percentCalc = num_text / 100
                num.text = percentCalc.toString()
            }
        }

        division.setOnClickListener{
            count++
            val num_text : String = num.text.toString()
            if(count==1 && num_text == "") {
                count =0
            }
            else if(count==1 || rclicked){
                preNum = num_text.toFloat()
                dclicked = true
                clicked = true
                rclicked = false
            }
            else {
                if(isCleared == true) {
                    isCleared = false
                }

                dclicked = true
                if(pclicked == true){
                    calc = preNum +  num_text.toFloat()
                    pclicked = false
                }
                else if(mclicked == true){
                    calc = preNum *  num_text.toFloat()
                    mclicked = false
                }
                else if(sclicked == true){
                    calc = preNum -  num_text.toFloat()
                    sclicked = false
                }
                else if(dclicked){
                    calc = preNum /  num_text.toFloat()
                }
                else {
                    calc = preNum /  num_text.toFloat()
                    dclicked = false
                }
                count = 1
                preNum = calc
                num.setText(calc.toString())
                clicked = true
                rclicked = false
            }

        }
        multiplication.setOnClickListener{
            count++
            val num_text : String = num.text.toString()
            if(count==1 && num_text == "") {
                count =0
            }
            else if(count==1 || rclicked){
                preNum = num_text.toFloat()
                mclicked = true
                clicked = true
                rclicked = false
            }
            else {
                if(isCleared) {
                    isCleared = false
                }

                mclicked = true
                if(pclicked){
                    calc = preNum +  num_text.toFloat()
                    pclicked = false
                }
                else if(dclicked){
                    calc = preNum /  num_text.toFloat()
                    dclicked = false
                }
                else if(sclicked){
                    calc = preNum -  num_text.toFloat()
                    sclicked = false
                }
                else if(mclicked){
                    calc = preNum *  num_text.toFloat()
                }
                else {
                    calc = preNum *  num_text.toFloat()
                    mclicked = false
                }
                count = 1
                preNum = calc
                num.text = calc.toString()
                clicked = true
                rclicked = false
            }
        }
        subtraction.setOnClickListener{
            count++
            val num_text : String = num.text.toString()
            if(count==1 && num_text == "") {
                count = 0
                num.text = "-"
            }
            else if(count==1 || rclicked){
                preNum = num_text.toFloat()
                sclicked = true
                clicked = true
                rclicked = false
            }
            else {
                if(isCleared) {
                    isCleared = false
                }

                sclicked = true
                if(pclicked){
                    calc = preNum +  num_text.toFloat()
                    pclicked = false

                }
                else if(mclicked){
                    calc = preNum *  num_text.toFloat()
                    mclicked = false
                }
                else if(dclicked){
                    calc = preNum /  num_text.toFloat()
                    dclicked = false
                }
                else if(sclicked){
                    calc = preNum -  num_text.toFloat()
                }
                else {
                    calc = preNum -  num_text.toFloat()
                    sclicked = false
                }
                count = 1
                preNum = calc
                num.text = calc.toString()
                clicked = true
                rclicked = false
            }
        }
        summa.setOnClickListener{
            count++
            val num_text : String = num.text.toString()
            if(count==1 && num_text == "") {
                count =0
            }
            else if(count==1 || rclicked){
                preNum = num_text.toFloat()
                pclicked = true
                clicked = true
                rclicked = false
            }
            else {
                if(isCleared) {
                    isCleared = false
                }

                pclicked = true
                if(dclicked){
                    calc = preNum /  num_text.toFloat()
                    dclicked = false
                }
                else if(mclicked){
                    calc = preNum *  num_text.toFloat()
                    mclicked = false
                }
                else if(sclicked){
                    calc = preNum -  num_text.toFloat()
                    sclicked = false
                }
                else if(pclicked){
                    calc = preNum +  num_text.toFloat()
                }
                else {
                    calc = preNum +  num_text.toFloat()
                    pclicked = false
                }
                count = 1
                preNum = calc
                num.text = calc.toString()
                clicked = true
                rclicked = false
            }
        }
        sign.setOnClickListener {
            val nt:String = num.text.toString()
            fun isNegative(c: Char) = c in nt
            if(nt == ""){
                num.text = "-0"
            }
            else if(clicked){
                signed =  true
                if(!isNegative('-')) {
                    num.text = "Ошибка"
                }
                else {
                    num.setText(nt.replace("-",""))
                }
            }
            else if(!isNegative('-')) { 
                num.text = "-$nt"
            }
            else { 
                num.text = nt.replace("-","")
            }

        }
        val listener = View.OnClickListener { v ->
            if(clicked){
                if(signed) {
                    signed = false
                } else {
                    num.text = ""
                }
                clicked = false
            }
            val num_text : String = num.text.toString()
            if(num_text == "0"){
                when (v?.id) {
                    num1.id -> num.text = "1"
                    num2.id -> num.text = "2"
                    num3.id -> num.text = "3"
                    num4.id -> num.text = "4"
                    num5.id -> num.text = "5"
                    num6.id -> num.text = "6"
                    num7.id -> num.text = "7"
                    num8.id -> num.text = "8"
                    num9.id -> num.text = "9"
                    num0.id -> num.text = "0"
                }
            } else if(num_text == "-0"){
                when (v?.id) {
                    num1.id -> num.text = "-1"
                    num2.id -> num.text = "-2"
                    num3.id -> num.text = "-3"
                    num4.id -> num.text = "-4"
                    num5.id -> num.text = "-5"
                    num6.id -> num.text = "-6"
                    num7.id -> num.text = "-7"
                    num8.id -> num.text = "-8"
                    num9.id -> num.text = "-9"
                    num0.id -> num.text = "-0"
                }
            } else {
                when (v?.id) {
                    num1.id -> num.text = num_text + "1"
                    num2.id -> num.text = num_text + "2"
                    num3.id -> num.text = num_text + "3"
                    num4.id -> num.text = num_text + "4"
                    num5.id -> num.text = num_text + "5"
                    num6.id -> num.text = num_text + "6"
                    num7.id -> num.text = num_text + "7"
                    num8.id -> num.text = num_text + "8"
                    num9.id -> num.text = num_text + "9"
                    num0.id -> num.text = num_text + "0"
                }
            }
        }
        num1.setOnClickListener (listener)
        num2.setOnClickListener (listener)
        num3.setOnClickListener (listener)
        num4.setOnClickListener (listener)
        num5.setOnClickListener (listener)
        num6.setOnClickListener (listener)
        num7.setOnClickListener (listener)
        num8.setOnClickListener (listener)
        num9.setOnClickListener (listener)
        num0.setOnClickListener (listener)

        dot.setOnClickListener{
            if(clicked){
                num.text = ""
                clicked = false
            }
            val num_text : String = num.text.toString()
            fun isPoint(c: Char) = c in num_text
            if(!isPoint('.')) {
                num.text = "$num_text."
            }
            val nt : String = num.text.toString()
            if(nt.indexOf(".") == 0) {
                num.text = "0$nt"
            }
        }
    }

}