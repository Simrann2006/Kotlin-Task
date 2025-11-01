package com.example.practice

fun main(args: Array<String>){
    var age = arrayOf(18,19,20)
    println(age)
    println("The first element of age is ${age[0]}")
    println("The second element of age is ${age[1]}")
    println("The third element of age is ${age[2]}")

    println("****************************")

    var name = arrayOf("Saniya","Sonu","Aabriti")
    name[1] = "simran"
    println("The first element of name is ${name[0]}")
    println("The second element of name is ${name[1]}")
    println("The third element of name is ${name[2]}")

    println(name.size)
}