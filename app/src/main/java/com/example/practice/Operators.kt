package com.example.practice

fun main() {
    arithmeticOperator()
    assignmentOperator()
    unaryOperator()
    equalityOperator()
    relationalOperator()
    conditionalOperator()
    rangeto()
}

fun arithmeticOperator() {
    var num1: Double = 10.5
    var num2: Double = 5.0
    var result: Double = 0.0

    result = num1 + num2
    println("num1 + num2 is $result")
    result = num1 - num2
    println("num1 - num2 is $result")
    result = num1 * num2
    println("num1 * num2 is $result")
    result = num1 / num2
    println("num1 / num2 is $result")
    result = num1 % num2
    println("num1 % num2 is $result")
}

fun assignmentOperator(){
    var x : Int = 20
    var y : Int = 10
    var z : Int = 0

    z = x + y
    println("z = x + y = $z")
    z += x
    println("z += x = $z")
    z -= x
    println("z -= x = $z")
    z *= x
    println("z *= x = $z")
    z /= x
    println("z /= x = $z")
    z %= x
    println("z %= x = $z")
}

fun unaryOperator(){
    var number : Double = 7.5
    var isCheck : Boolean = true;
    println("+number = ${+number}")
    println("-number = ${-number}")
    println("++number = ${++number}")
    println("--number = ${-number}")
    println("!isCheck = ${!isCheck}")
    println("---")
    var result:Double = 4.7
    println("result :$result")

    println("result++ :" + result++)
}

fun equalityOperator(){
    println("Equality Operator")
    var a : Int = 5
    var b : Int = 5

    println("a == b : " + (a == b))
    println("a != b : " + (a != b))
}


fun relationalOperator(){
    println("Relational Operator")
    var a : Int = 5
    var b : Int = 4

    println("a < b : " + (a < b))
    println("a > b : " + (a > b))
    println("a >= b : " + (a >= b))
    println("a <= b : " + (a <= b))
}

fun conditionalOperator(){
    var num1 : Int = 5
    var num2 : Int = 10
    var num3 : Int = 15
    var result : Boolean = false

    result = (num1 > num2) && (num3 > num2)
    println(result)

    result = (num1 > num2) || (num3 > num2)
    println(result)
}

//rangeTo() Function and "in" operator

fun rangeto(){
    var myCharRange = 'a'.rangeTo(  'j')
    var testCharRange = 'a'..'j'

    var check = 'Z' in testCharRange
    println("mycharRange has Z : $check")
    println(myCharRange)
    println(testCharRange)
}

