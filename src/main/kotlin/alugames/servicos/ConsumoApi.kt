package alugames.servicos

import alugames.modelos.*
import alugames.utilitario.criaGamer
import alugames.utilitario.criaJogo
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse

class ConsumoApi {
    private fun consomeDados(endereco: String): String{

        val client = HttpClient.newHttpClient()
        val request = HttpRequest.newBuilder()
            .uri(URI.create(endereco))
            .build()

        val response = client
            .send(request, HttpResponse.BodyHandlers.ofString())

        return response.body()

    }
    fun buscaJogo(id:String):InfoJogo{
        val endereco = "https://www.cheapshark.com/api/1.0/games?id=$id"
        val json = consomeDados(endereco)

        val gson = Gson()
        val infoJogo = gson.fromJson(json, InfoJogo::class.java)

        return infoJogo
    }

    fun buscaGamer(): List<Gamer> {
        val endereco = "https://raw.githubusercontent.com/jeniblodev/arquivosJson/main/gamers.json"
        val json = consomeDados(endereco)

        val gson = Gson()
        val tipoGamer = object: TypeToken<List<InfoGamerJson>>() {}.type
        val listaGamer:List<InfoGamerJson> = gson.fromJson(json, tipoGamer)
        val listaGamerConvertida = listaGamer.map{ InfoGamerJson -> InfoGamerJson.criaGamer() }
        return listaGamerConvertida
    }

    fun buscaJogoJson(): List<Jogo>{
        val endereco = "https://raw.githubusercontent.com/jeniblodev/arquivosJson/main/jogos.json"
        val json = consomeDados(endereco)

        val gson = Gson()
        val tipoJogoJson = object: TypeToken<List<InfoJogosJson>>() {}.type
        val listaJogos:List<InfoJogosJson> = gson.fromJson(json, tipoJogoJson)

        val listaJogosConvertidos = listaJogos.map { infoJogosJson -> infoJogosJson.criaJogo() }

        return listaJogosConvertidos
    }

}