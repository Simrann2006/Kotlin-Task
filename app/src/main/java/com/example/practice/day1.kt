package com.example.practice

fun main(){
    print("hello")
    println("world")

    var name : String = "simran"  //mutable
    val age : Int = 18            //immutable
    val terms : Boolean = false
    val weight : Double = 0.0

    print("My name is $name and age is $age")
    print("My name is ${name.uppercase()} and age is $age") //to access other properties
}