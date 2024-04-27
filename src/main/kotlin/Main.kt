import com.google.gson.Gson
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse.BodyHandlers
import java.util.Scanner

fun main() {
    val leitura = Scanner(System.`in`)

    print("Digite o código de um jogo para buscar: ")
    val buscaId = leitura.nextLine()

    val endereco = "https://www.cheapshark.com/api/1.0/games?id=$buscaId"

    val client = HttpClient.newHttpClient()
    val request = HttpRequest.newBuilder()
        .uri(URI.create(endereco))
        .build()

    val response = client
        .send(request, BodyHandlers.ofString())

    val json = response.body()

    val gson = Gson()
    val infoJogo = gson.fromJson(json, InfoJogo::class.java)
    var meuJogo:Jogo? = null

    val resultadoBusca = runCatching {
        meuJogo = Jogo(
            infoJogo.info.title,
            infoJogo.info.thumb)
    }

    resultadoBusca.onFailure {
        println("Jogo inexistente. Tente buscar por outro jogo")
    }

    resultadoBusca.onSuccess {
        print("Deseja criar uma descrição personalizada? (S/N)")
        val opcao = leitura.nextLine()
        if(opcao.equals("s", true)){
            print("Insira a descrição personalizada: ")
            val descricaoPersonalizada = leitura.nextLine()
            meuJogo?.descricao = descricaoPersonalizada
        } else {
            meuJogo?.descricao = meuJogo?.titulo
        }
    }

    println(meuJogo)
}