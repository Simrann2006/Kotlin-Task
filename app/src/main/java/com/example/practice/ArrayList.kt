package com.example.practice

fun main(){
    var age1 = ArrayList<Int>()
    age1.add(18)
    age1.add(1,19)
    age1.add(19)

    var age2 = arrayListOf<Int>(18,19,20)

    var name = arrayListOf<String>("simran","sonu","saniya")
    name.add("aabriti")
    name.add(4,"sita")

    name.remove("sonu")
    name.removeAt((0))

    println(name)

    var mixArrayList = arrayListOf<Any>("hello",5,2.0)
    println(mixArrayList[0])
    println(mixArrayList[1])
    println(mixArrayList[2])
}