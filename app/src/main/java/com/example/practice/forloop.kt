package com.example.practice

fun main(){
    for (x in 1 .. 9){
        println(x)
    }

    var sum1 : Int = 0
    for (y in 0 .. 5){
        println(y)
        sum1 += y
    }
    println("Sum: $sum1")

    var sum2 : Int = 0
    for (z in 0 .. 10){
        if (z % 2 == 0){
            println(z)
            sum2 += z
        }
    }
    println("The sum of even number is $sum2")

    var vehicle = arrayListOf<String>("Tata","Kia","Hyundia","MG")
    for(i in vehicle.indices){
        println("The value in $i index is: ${vehicle[i]}")
    }

    //for each loop
    var vehicles = arrayListOf<String>("Tata","Kia","Hyundia","MG")

    vehicles.forEach {
        println(it)
    }
}