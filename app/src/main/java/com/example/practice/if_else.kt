package com.example.practice

fun main(){

    //if-else statement

    print("Please enter a number: ")

    var num : Any = readln()!!.toInt()

    if(num.toString().toInt() % 2 == 0){
        println("$num is even")
    } else {
        println("$num is odd")
    }

    //if-else if ladder statement

    print("Please enter your age: ")

    var age : Int = readln()!!.toInt()
    if (age < 13){
        println("You are a child")
    } else if (age < 19){
        println("You are a teenager")
    } else {
        if (age < 50){
            println(("You are an adult"))
        } else{
            println("You are a senior")
        }
    }

    //nested if statement

    println("Please enter 3 numbers : ")
    var num1: Int = readln()!!.toInt()
    var num2: Int = readln()!!.toInt()
    var num3: Int = readln()!!.toInt()
    var largestNum : Int

    if (num1 >= num2) {
        if (num1 >= num3) {
            largestNum = num1
        } else {
            largestNum = num3
        }
    } else {
        if (num2 >= num3) {
            largestNum = num2
        } else {
            largestNum = num3
        }
    }

    println("The largest number is $largestNum")

    // when statement

    print("Please enter a month number of year :  ")
    var monthNumber : Int = readln()!!.toInt()
    var month : String
    when(monthNumber)
    {
        1 -> month = "January"
        2 -> month = "February"
        3 -> month = "March"
        4 -> month = "April"
        5 -> month = "May"
        6 -> month = "June"
        7 -> month = "July"
        8 -> month = "August"
        9 -> month = "September"
        10 -> month = "October"
        11 -> month = "November"
        12 -> month = "December"
        else -> month = "Invalid month choice"
    }
    println(month)
}


