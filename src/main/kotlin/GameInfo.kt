package org.example

data class GameInfo(val info:infoSharkAPI) {
    override fun toString(): String{
        return info.toString()
    }
}