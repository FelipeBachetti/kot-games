package org.example.br.com.kotlinGames.models

import br.com.kotlinGames.models.infoSharkAPI

data class GameInfo(val info: infoSharkAPI) {
    override fun toString(): String{
        return info.toString()
    }
}