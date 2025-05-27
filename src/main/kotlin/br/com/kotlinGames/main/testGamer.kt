package br.com.kotlinGames.main

import br.com.kotlinGames.models.Gamer

fun main() {
    val myGamer0 = Gamer("Felipe", "Felipebachetti@gmail.com")
    println(myGamer0)

    val myGamer1 = Gamer("John", "john@gmail.com", "19/02/2000", "xxxGamerxxx")
    println(myGamer1)

    myGamer0.let{
        it.dateOfBirth = "27/12/2002"
        it.user = "Blackmore"
    }.also{
        println(myGamer0.identifier)
    }
}