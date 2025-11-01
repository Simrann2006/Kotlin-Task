package com.example.practice

fun main(){
    displayLits()
    immutableList()
    mutableList()
}
fun displayLits(){
    val numbers : List<String> = listOf("one","two","three","four")

    println("Number of elements: ${numbers.size}")
    println("Third elemnt: ${numbers.get(2)}")
    println("Fourth element: ${numbers[3]}")
    println("Index of emelemt \"two\" ${numbers.indexOf("two")}")
}

//ImM=mutable List
fun immutableList(){
    val lst = listOf("one","two","three")
    println("Mutable list")
    for(i in lst.indices)
        println(lst[i])
}

//Mutable List
fun mutableList(){
    val mutableLst = mutableListOf("one","two","three")
    mutableLst.add("four")
    println("Immutable list")
    for(i in mutableLst.indices){
        println(mutableLst[i])
    }
}