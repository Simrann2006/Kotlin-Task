package com.example.practice

fun main(){
    map()
    immutablemap()
    mutablemap()
    dictionary()
}

fun map(){
    val countriesCapitals = mapOf(
        "Nepal" to "Kathmandu",
        "China" to "Beijing",
        "India" to "New Delhi"
    )

    println("All keys : ${countriesCapitals.keys}")
    println("All values : ${countriesCapitals.values}")

    println("Capital of Nepal is : ${countriesCapitals["Nepal"]}")
}

//Immutable Map
fun immutablemap(){
    val studentsMarks = mapOf(
        "simran" to 75,
        "sonu" to 60,
        "saniya" to 65,
        "aabriti" to 70,
    )

    println("Enter student name: ")
    val input : String = readln().lowercase()
    println(studentsMarks[input])
}

//Mutable Map
fun mutablemap(){
    val studentsMarks = mutableMapOf(
        "simran" to 75,
        "sonu" to 60,
        "saniya" to 65,
        "aabriti" to 70,
    )

    studentsMarks["simran"] = 50
    studentsMarks.put("sita",45)
    println("Enter student name: ")
    val input : String = readln().lowercase()
    println(studentsMarks[input])
}

// Create a Dictionary app using mapOf() function where user will type a word and your program should return the meaning of that word.

fun dictionary(){
    val words = mapOf(
        "brave" to "not afraid of danger",
        "calm" to "quiet and peaceful",
        "bright" to "giving a lot of light or very smart",
        "lazy" to "not wanting to work or move"
    )

    println("Enter a word: ")
    val input : String = readln().lowercase()

    if (input in words){
        println("Meaning:  ${words[input]}")
    }
    else {
        println("Sorry, that word is not in the dictionary")
    }
}