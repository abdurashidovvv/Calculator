package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var canAddOperation=true
    private var canAddDecimal=true
    var tJavob:Double=.0;
    var number1:Double=.0
    var number2:Double=.0
    var addOperation=true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        allClear.setOnClickListener {
            workingsTV.text=""
            resultsTV.text=""
            canAddDecimal=true
            canAddOperation=true
        }

        btn_1.setOnClickListener {
            resultsTV.append("1")
        }
        btn_2.setOnClickListener {
            resultsTV.append("2")
        }
        btn_3.setOnClickListener {
            resultsTV.append("3")
        }
        btn_4.setOnClickListener {
            resultsTV.append("4")
        }
        btn_5.setOnClickListener {
            resultsTV.append("5")
        }
        btn_6.setOnClickListener {
            resultsTV.append("6")
        }
        btn_7.setOnClickListener {
            resultsTV.append("7")
        }
        btn_8.setOnClickListener {
            resultsTV.append("8")
        }
        btn_9.setOnClickListener {
            resultsTV.append("9")
        }
        btn_0.setOnClickListener {
            resultsTV.append("0")
        }
        btn_empty.setOnClickListener {
            Toast.makeText(this, "Created by: Abdurashidov", Toast.LENGTH_SHORT).show()
        }

        btn_decimal.setOnClickListener {
            if (canAddDecimal){
                resultsTV.append(".")
                canAddDecimal=false
            }
        }

        add.setOnClickListener {
            if (resultsTV.text.isEmpty() && workingsTV.text.isEmpty()){
                canAddOperation=false
            }else if (workingsTV.text.isEmpty()){
                canAddOperation=true
                if (canAddOperation && resultsTV.text.isNotEmpty()){
                    actionOperation("+")
                    workingsTV.append(resultsTV.text.toString()+"+")
                    number1=resultsTV.text.toString().toDouble()
                    resultsTV.text=""
                    canAddDecimal=true
                    canAddOperation=false
                }else{
                    if (resultsTV.text.isEmpty()){
                        var txt=workingsTV.text
                        txt=txt.subSequence(0, txt.length-1)
                        workingsTV.text=txt
                        actionOperation("+")
                        workingsTV.append("+")
                    }
                }
            }
        }

        multiple.setOnClickListener {
            if (resultsTV.text.isEmpty() && workingsTV.text.isEmpty()){
                canAddOperation=false
            }else if (workingsTV.text.isEmpty()){
                canAddOperation=true
                if (canAddOperation && resultsTV.text.isNotEmpty()){
                    actionOperation("*")
                    workingsTV.append(resultsTV.text.toString()+"×")
                    number1=resultsTV.text.toString().toDouble()
                    resultsTV.text=""
                    canAddDecimal=true
                    canAddOperation=false
                }else{
                    if (resultsTV.text.isEmpty()){
                        var txt=workingsTV.text
                        txt=txt.subSequence(0, txt.length-1)
                        workingsTV.text=txt
                        actionOperation("*")
                        workingsTV.append("×")
                    }
                }
            }
        }

        subscribe.setOnClickListener {
            if (resultsTV.text.isEmpty() && workingsTV.text.isEmpty()){
                canAddOperation=false
            }else if (workingsTV.text.isEmpty()){
                canAddOperation=true
                if (canAddOperation && resultsTV.text.isNotEmpty()){
                    actionOperation("-")
                    workingsTV.append(resultsTV.text.toString()+"-")
                    number1=resultsTV.text.toString().toDouble()
                    resultsTV.text=""
                    canAddDecimal=true
                    canAddOperation=false
                }else{
                    if (resultsTV.text.isEmpty()){
                        var txt=workingsTV.text
                        txt=txt.subSequence(0, txt.length-1)
                        workingsTV.text=txt
                        actionOperation("-")
                        workingsTV.append("-")
                    }
                }
            }
        }

        divide.setOnClickListener {
            if (resultsTV.text.isEmpty() && workingsTV.text.isEmpty()){
                canAddOperation=false
            }else if (workingsTV.text.isEmpty()){
                canAddOperation=true
                if (canAddOperation && resultsTV.text.isNotEmpty()){
                    actionOperation("/")
                    workingsTV.append(resultsTV.text.toString()+"÷")
                    number1=resultsTV.text.toString().toDouble()
                    resultsTV.text=""
                    canAddDecimal=true
                    canAddOperation=false
                }else{
                    if (resultsTV.text.isEmpty()){
                        var txt=workingsTV.text
                        txt=txt.subSequence(0, txt.length-1)
                        workingsTV.text=txt
                        actionOperation("/")
                        workingsTV.append("÷")
                    }
                }
            }
        }

        clear.setOnClickListener {
            clear()
        }

        equals.setOnClickListener {
            if (workingsTV.text.isNotEmpty()){
                if (workingsTV.text.last()=='+'){
                    getResult("+")
                }
                if (workingsTV.text.last()=='-'){
                    getResult("-")
                }
                if (workingsTV.text.last()=='×'){
                    getResult("*")
                }
                if (workingsTV.text.last()=='÷'){
                    getResult("/")
                }
                workingsTV.text=""
                canAddOperation=true
            }
        }
    }

    fun actionOperation(amal:String){
        when(amal){
            "+"->{
                tJavob=number1+number2
            }

            "*"->{
                tJavob=number1*number2
            }

            "-"->{
                tJavob=number1-number2
            }

            "/"->{
                tJavob=number1/number2
            }
        }
    }

    fun getResult(amal: String){
        number2=resultsTV.text.toString().toDouble()
        when(amal){
            "+"->{
                tJavob=number1+number2
            }

            "*"->{
                tJavob=number1*number2
            }

            "-"->{
                tJavob=number1-number2
            }

            "/"->{
                tJavob=number1/number2
            }
        }
        resultsTV.text="$tJavob"
    }

    fun clear(){
        var text1=workingsTV.text
        var text2=resultsTV.text
        if (text2.isNotEmpty()){
            text2=text2.subSequence(0, text2.length-1)
            resultsTV.text=text2
        }else if (text1.isNotEmpty()){
            text1=text1.subSequence(0, text1.length-1)
            canAddOperation=true
            workingsTV.text=""
            resultsTV.text=text1
        }
        checkDisplay()
    }

    fun checkDisplay(){
        if (resultsTV.text.isEmpty() && workingsTV.text.isEmpty()){
            canAddOperation= false
        }
    }
}