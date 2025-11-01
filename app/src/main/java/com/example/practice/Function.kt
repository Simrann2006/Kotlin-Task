package com.example.practice

fun main() {

    //no return type
    fun show(a: Int, b: Int): Unit {
        println("You entered $a and $b")
    }

    //return type
    fun add(a: Int, b: Int): Int {
        var sum = 0
        sum = a + b
        return sum
    }

    fun findMinimumNum(a: Int, b: Int): Int {
        var minimum = 0
        if (a > b) {
            minimum = b
        } else {
            minimum = a
        }
        return minimum
    }
    println("Enter first number : ")
    var a : Int = readln()!!.toInt()
    println("Enter second number: ")
    var b : Int = readln()!!.toInt()

    show(a,b)
    var sum = add(a, b)
    println("Sum of the two entered number is $sum")
    var minimum = findMinimumNum(a,b)
    println("Smallest better $a and $b is $minimum")

}
