package alugames.servicos

import alugames.modelos.Gamer
import alugames.modelos.InfoGamerJson
import alugames.modelos.InfoJogo
import alugames.utilitario.criaGamer
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse

class ConsumoApi {
    fun buscaJogo(id:String):InfoJogo{

        val endereco = "https://www.cheapshark.com/api/1.0/games?id=$id"

        val client = HttpClient.newHttpClient()
        val request = HttpRequest.newBuilder()
            .uri(URI.create(endereco))
            .build()

        val response = client
            .send(request, HttpResponse.BodyHandlers.ofString())

        val json = response.body()

        val gson = Gson()
        val infoJogo = gson.fromJson(json, InfoJogo::class.java)

        return infoJogo
    }

    fun buscaGamer(): List<Gamer> {

        val endereco = "https://raw.githubusercontent.com/jeniblodev/arquivosJson/main/gamers.json"

        val client = HttpClient.newHttpClient()
        val request = HttpRequest.newBuilder()
            .uri(URI.create(endereco))
            .build()

        val response = client
            .send(request, HttpResponse.BodyHandlers.ofString())

        val json = response.body()

        val gson = Gson()
        val tipoGamer = object: TypeToken<List<InfoGamerJson>>() {}.type
        val listaGamer:List<InfoGamerJson> = gson.fromJson(json, tipoGamer)
        val listaGamerConvertida = listaGamer.map{ InfoGamerJson -> InfoGamerJson.criaGamer() }
        return listaGamerConvertida
    }
}