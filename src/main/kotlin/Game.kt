package org.example

data class Game(val title:String,val cover: String){
    var description = ""
    override fun toString(): String {
        return "$title\n$cover\n$description"
    }
}