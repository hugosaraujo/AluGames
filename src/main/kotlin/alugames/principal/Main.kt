package alugames.principal

import alugames.modelos.Gamer
import alugames.modelos.Jogo
import alugames.servicos.ConsumoApi
import java.util.*

fun main() {
    val leitura = Scanner(System.`in`)

    val gamer = Gamer.criarGamer(leitura)
    println(gamer)

    do {

        print("Digite o código de um jogo para buscar: ")
        val buscaId = leitura.nextLine()

        val buscaApi = ConsumoApi()
        val infoJogo = buscaApi.buscaJogo(buscaId);

        var meuJogo: Jogo? = null

        val busca = runCatching {
            meuJogo = Jogo(
                infoJogo.info.title,
                infoJogo.info.thumb
            )
        }

        busca.onFailure {
            println("Jogo inexistente. Tente buscar por outro jogo")
        }

        busca.onSuccess {
            print("Deseja criar uma descrição personalizada? (S/N) ")
            val opcao = leitura.nextLine()
            if(opcao.equals("s", true)){
                print("Insira a descrição personalizada: ")
                val descricaoPersonalizada = leitura.nextLine()
                meuJogo?.descricao = descricaoPersonalizada
            } else {
                meuJogo?.descricao = meuJogo?.titulo
            }

            gamer.listaJogos.add(meuJogo)
        }

        print("Deseja buscar um novo jogo? (S/N) ")
        val opcaoBusca = leitura.nextLine()
    } while(opcaoBusca.equals("s", true))
    println(gamer.listaJogos)

    println("Finalizando o programa!")
}