package com.example.practice

import kotlin.random.Random

fun main(){
    var i : Int = 0;
    while (i < 5){
        println(i)
        i++
    }

    var k = 1
    var fact = 1
    while (k < 6){
        fact *= k
        println("$k! = $fact")
        k++
    }

    // infinite loop

    var number = Random.nextInt(0, 10000)
    println("Please enter any number from 0 to 10000: - ")
    while (2>1){
        var userGuess:Int = readln()!!.toInt()
        if(userGuess == number){
            println("congratulations!!!!, you won")
            break
        }else if(userGuess<number){
            println("Increase your guess")
        }else{
            println("Decrease your guess")
        }
    }

    // do-while loop
    var num =1
    do {
        println(num)
        num++
    } while (num <= 15)
}