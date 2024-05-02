package alugames.principal

import alugames.modelos.Gamer
import alugames.utilitario.transformarEmIadade
import java.util.*

fun main(){
    val gamer = Gamer("Olivia", "olivia@oxford.com")
    val gamer1 = Gamer("Billie", "billie@provedor.com", "09/04/1994", "@billie")

    val leitura = Scanner(System.`in`)
    val testaGamer = Gamer.criarGamer(leitura)
    println(testaGamer)
    println("Idade do usuario: ${testaGamer.dataNascimento?.transformarEmIadade()}" )
    //println(gamer)
    //println(gamer1)

    gamer.let {
        it.dataNascimento = "19/09/2002"
        it.usuario = "@olivia"
    }

    //println(gamer)

    gamer.let {
        it.usuario = "Olivia"
    }

    //println(gamer)
}