package com.example.practice

fun main() {
    printHello()
    dataTypes()
    typeConversion()
    stringOperations()
}

fun printHello() {
    println("Hello world")
}

// Data types
fun dataTypes() {
    var a: Boolean = true
    var b: Char = 'R'
    var c: Byte = 12
    var d: Short = -356
    var e: Int = 43543
    var f: Long = -51321354L
    var g: Float = 5.6451344F
    var h: Double = 7.325987

    println(a)
    println(b)
    println(c)
    println(d)
    println(e)
    println(f)
    println(g)
    println(h)
}

// Type conversion
fun typeConversion() {
    var x: Double = 123.456
    var y: Int = x.toInt()
    var z : Byte = y.toByte()

    println(x)
    println(y)
    println(z)
}

// String operations
fun stringOperations() {
    var a: String = "Hello world"
    var b: Int = a.length
    var c: Boolean = a.equals("Hello world")
    var username: String = " softwarica "

    println(username.trim())
    println(a)
    println(b)
    println(a.isEmpty())
    println(a.lowercase())
    println(a.uppercase())
    println(c)
    println(a.plus(", How are you?"))
}
