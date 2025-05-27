package org.example.br.com.kotlinGames.models

data class Game(val title:String,val cover: String){
    var description:String? = null
    override fun toString(): String {
        return "$title\n$cover\n$description"
    }
}