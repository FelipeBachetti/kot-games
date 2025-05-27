package br.com.kotlinGames.servicos

import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse

class UseAPI {
    fun searchGame(id:String): String {
        val address = "https://www.cheapshark.com/api/1.0/games?id=$id"
        val client: HttpClient = HttpClient.newHttpClient()
        val request = HttpRequest.newBuilder()
            .uri(URI.create(address))
            .build()
        val response = client.send(request, HttpResponse.BodyHandlers.ofString())

        val json = response.body()

        return json
    }
}