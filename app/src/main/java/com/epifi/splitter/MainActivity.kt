package com.epifi.splitter

import android.graphics.drawable.Drawable
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {
    lateinit var EtBillAmount : EditText
    lateinit var EtPeopleAmount: EditText
    lateinit var Btn5Percent: Button
    lateinit var Btn10Percent: Button
    lateinit var Btn15Percent: Button
    lateinit var Btn25Percent: Button
    lateinit var Btn50Percent: Button
    lateinit var BtnCustomPercent: Button
    lateinit var TvAmountOfTip: TextView
    lateinit var TvAmountPerPerson: TextView
    var BillAmount : Double = 00.0
    var currentNumberPeople : Int= 0
    var currentAmountTipPerPerson : Double=0.0
    var currentAmountPerPerson : Double=0.0
    var currentPercentTip : Int = 0
    var currentButtonPressed:Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()
        initButtonsListeners()
        checkButtonIsPressed()






        //Checks if edit texts has changed
        EtBillAmount.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {}

            override fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {}

            override fun afterTextChanged(editable: Editable) {
                if (EtBillAmount.text.isEmpty()){

                }else{
                    BillAmount = EtBillAmount.text.toString().toDouble()
                    calcs()
                }




            }
        })
        EtPeopleAmount.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {}

            override fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {}

            override fun afterTextChanged(editable: Editable) {
                if (EtPeopleAmount.text.isEmpty()){

                }else{
                    currentNumberPeople = EtPeopleAmount.text.toString().toInt()
                    calcs()
                }
            }
        })





        //Buttons Listeners
        Btn5Percent.setOnClickListener {
            currentPercentTip = 5
            currentButtonPressed = 1
            checkButtonIsPressed()
            calcs()
        }
        Btn10Percent.setOnClickListener {
            currentPercentTip = 10
            currentButtonPressed = 2
            checkButtonIsPressed()
            calcs()

        }
        Btn15Percent.setOnClickListener {
            currentPercentTip = 15
            currentButtonPressed = 3
            checkButtonIsPressed()
            calcs()

        }
        Btn25Percent.setOnClickListener {
            currentPercentTip = 25
            currentButtonPressed = 4
            checkButtonIsPressed()
            calcs()

        }
        Btn50Percent.setOnClickListener {
            currentPercentTip = 50
            currentButtonPressed = 5
            checkButtonIsPressed()
            calcs()

        }
        BtnCustomPercent.setOnClickListener {
            Toast.makeText(this,"COMING SOON",Toast.LENGTH_SHORT).show()
            currentButtonPressed = 6
            checkButtonIsPressed()
            calcs()

        }


    }
    fun init(){
        EtBillAmount = findViewById(R.id.EtBillAmount)
        EtPeopleAmount = findViewById(R.id.EtPeopleAmount)
        Btn5Percent = findViewById(R.id.Btn5Percent)
        Btn10Percent = findViewById(R.id.Btn10Percent)
        Btn15Percent = findViewById(R.id.Btn15Percent)
        Btn25Percent = findViewById(R.id.Btn25Percent)
        Btn50Percent = findViewById(R.id.Btn50Percent)
        BtnCustomPercent = findViewById(R.id.BtnCustom)
        TvAmountOfTip = findViewById(R.id.TvAmountOfTip)
        TvAmountPerPerson = findViewById(R.id.TvAmountPerPerson)


    }
    fun initButtonsListeners(){
        Btn5Percent.setOnClickListener {
           currentPercentTip = 5
           currentButtonPressed = 1
        }
        Btn10Percent.setOnClickListener {
            currentPercentTip = 10
            currentButtonPressed = 2

        }
        Btn15Percent.setOnClickListener {
            currentPercentTip = 15
            currentButtonPressed = 3

        }
        Btn25Percent.setOnClickListener {
            currentPercentTip = 25
            currentButtonPressed = 4

        }
        Btn50Percent.setOnClickListener {
            currentPercentTip = 50
            currentButtonPressed = 5

        }
        BtnCustomPercent.setOnClickListener {
            Toast.makeText(this,"COMING SOON",Toast.LENGTH_SHORT).show()
            currentButtonPressed = 6

        }
    }





    fun checkButtonIsPressed(){
        if (currentButtonPressed==1){
            Btn5Percent.setBackgroundResource(R.drawable.btn_tip_percentage_selected)
            Btn10Percent.setBackgroundResource(R.drawable.btn_tip_percentage)
            Btn15Percent.setBackgroundResource(R.drawable.btn_tip_percentage)
            Btn25Percent.setBackgroundResource(R.drawable.btn_tip_percentage)
            Btn50Percent.setBackgroundResource(R.drawable.btn_tip_percentage)
        }else if (currentButtonPressed==2){
            Btn5Percent.setBackgroundResource(R.drawable.btn_tip_percentage)
            Btn10Percent.setBackgroundResource(R.drawable.btn_tip_percentage_selected)
            Btn15Percent.setBackgroundResource(R.drawable.btn_tip_percentage)
            Btn25Percent.setBackgroundResource(R.drawable.btn_tip_percentage)
            Btn50Percent.setBackgroundResource(R.drawable.btn_tip_percentage)
        }else if (currentButtonPressed==3){
            Btn5Percent.setBackgroundResource(R.drawable.btn_tip_percentage)
            Btn10Percent.setBackgroundResource(R.drawable.btn_tip_percentage)
            Btn15Percent.setBackgroundResource(R.drawable.btn_tip_percentage_selected)
            Btn25Percent.setBackgroundResource(R.drawable.btn_tip_percentage)
            Btn50Percent.setBackgroundResource(R.drawable.btn_tip_percentage)
        }else if (currentButtonPressed==4){
            Btn5Percent.setBackgroundResource(R.drawable.btn_tip_percentage)
            Btn10Percent.setBackgroundResource(R.drawable.btn_tip_percentage)
            Btn15Percent.setBackgroundResource(R.drawable.btn_tip_percentage)
            Btn25Percent.setBackgroundResource(R.drawable.btn_tip_percentage_selected)
            Btn50Percent.setBackgroundResource(R.drawable.btn_tip_percentage)
        }
        else if (currentButtonPressed==5){
            Btn5Percent.setBackgroundResource(R.drawable.btn_tip_percentage)
            Btn10Percent.setBackgroundResource(R.drawable.btn_tip_percentage)
            Btn15Percent.setBackgroundResource(R.drawable.btn_tip_percentage)
            Btn25Percent.setBackgroundResource(R.drawable.btn_tip_percentage)
            Btn50Percent.setBackgroundResource(R.drawable.btn_tip_percentage_selected)
        }else if (currentButtonPressed==6){
            Btn5Percent.setBackgroundResource(R.drawable.btn_tip_percentage)
            Btn10Percent.setBackgroundResource(R.drawable.btn_tip_percentage)
            Btn15Percent.setBackgroundResource(R.drawable.btn_tip_percentage)
            Btn25Percent.setBackgroundResource(R.drawable.btn_tip_percentage)
            Btn50Percent.setBackgroundResource(R.drawable.btn_tip_percentage)

        }

    }
    fun calcs(){
        if (currentNumberPeople==0||BillAmount==0.0){

        }else{
            val dec = DecimalFormat("#.##")
            currentAmountTipPerPerson = BillAmount/100*currentPercentTip
            currentAmountPerPerson = BillAmount/currentNumberPeople+currentAmountTipPerPerson
            TvAmountOfTip.text = String.format("%.2f",currentAmountTipPerPerson)
            TvAmountPerPerson.text = String.format("%.2f",currentAmountPerPerson)
        }

    }

}
