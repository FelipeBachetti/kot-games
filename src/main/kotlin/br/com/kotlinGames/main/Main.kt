package org.example.br.com.kotlinGames.main

import br.com.kotlinGames.models.Gamer
import br.com.kotlinGames.servicos.UseAPI
import com.google.gson.Gson
import org.example.br.com.kotlinGames.models.Game
import org.example.br.com.kotlinGames.models.GameInfo
import java.util.*

fun main() {
    val scan  = Scanner(System.`in`)
    val gamer = Gamer.createGamer(scan)
    println("Cadastro concluído com sucesso. Dados do gamer:")
    println(gamer)

    do{
        print("\nDigite um codigo de jogo: ")
        val search = scan.nextLine()

        val searchAPI = UseAPI()
        val json = searchAPI.searchGame(search)
        val gson = Gson()

        var myGame: Game? = null

        val result = runCatching {
            val myGameInfo = gson.fromJson(json, GameInfo::class.java)
            myGame = Game(myGameInfo.info.title, myGameInfo.info.thumb)
        }

        result.onFailure {
            println("Jogo inexistente")
        }

        result.onSuccess {
            print("\nAdicionar descricao? (s/n)")
            val addDesc = scan.nextLine()
            if (addDesc.equals("s", true)){
                print("\nDescricao:")
                val desc = scan.nextLine()
                myGame?.description = desc
            }else{
                myGame?.description = myGame?.title
            }
            println(myGame)

            gamer.searchedGames.add(myGame)
        }

        print("Deseja buscar um novo jogo? (s/n) ")
        val op = scan.nextLine()
    }while (op.equals("s", true))

    gamer.searchedGames.sortBy {
        it?.title
    }
    println("Jogos buscados:")
    gamer.searchedGames.forEach{
        println("Titulo: ${it?.title}")
    }
    println("Busca finalizada com sucesso")

}