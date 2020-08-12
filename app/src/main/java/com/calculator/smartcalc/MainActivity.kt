package com.calculator.smartcalc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.math.BigDecimal
import java.math.RoundingMode

class MainActivity : AppCompatActivity() {
    //initialize the value for set method
    var act = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        img_add.setOnClickListener(){
            this.act = 1
        }

        img_subs.setOnClickListener(){
            this.act = 2
        }

        img_multi.setOnClickListener(){
            this.act = 3
        }

        img_divi.setOnClickListener(){
            this.act = 4
        }

        btn_submit.setOnClickListener(){
            if(this.act == 1){
                add()
            }
           if(this.act == 2){
                subtract()
            }
            if(this.act == 3){
                multiply()
            }
            if(this.act == 4){
                divide()
            }
            if(this.act == 0){
                val toast = Toast.makeText(applicationContext, "please select one operation",Toast.LENGTH_SHORT)
                toast.show()
            }

        }

        btn_reset.setOnClickListener(){
            reset()
        }
    }

    // input validation
    fun InputIsNotEmpty() : Boolean{
        var inputValue = true;

        if(number1.text.toString().trim().isEmpty()){
            number1.error = "Required input number"
            inputValue = false
        }
        if(number2.text.toString().trim().isEmpty()){
            number2.error = "Required input number"
            inputValue = false
        }


        return inputValue
    }

    //add function
    fun add(){
        if(InputIsNotEmpty()){
            val input1 = number1.text.toString().trim().toBigDecimal()
            val input2 = number2.text.toString().trim().toBigDecimal()
            output.text = input1.toString() + " + " + input2.toString() + " = " +input1.add(input2).toString()
        }
    }

    //subtract function
    fun subtract(){
        if(InputIsNotEmpty()){
            val input1 = number1.text.toString().trim().toBigDecimal()
            val input2 = number2.text.toString().trim().toBigDecimal()
            output.text = input1.toString() + " - " + input2.toString() + " = " +input1.subtract(input2).toString().toBigDecimal()
        }
    }

    //multiply function
    fun multiply(){
        if(InputIsNotEmpty()){
            val input1 = number1.text.toString().trim().toBigDecimal()
            val input2 = number2.text.toString().trim().toBigDecimal()
            output.text = input1.toString() + " x " + input2.toString() + " = " +input1.multiply(input2).toString()
        }
    }

    //divide function
    fun divide(){
        if(InputIsNotEmpty()){
            val input1 = number1.text.toString().trim().toBigDecimal()
            val input2 = number2.text.toString().trim().toBigDecimal()
            if(input2.compareTo(BigDecimal.ZERO)==0){
                number2.error = "Invalid input"
            }
            else{
                output.text = input1.toString() + " / " + input2.toString() + " = " +input1.divide(input2, 2, RoundingMode.HALF_UP).toString()
            }
        }
    }

    //reset to the initial state
    fun reset(){
        number1.setText("")
        number2.setText("")
        output.text = " "
        this.act = 0
    }
}