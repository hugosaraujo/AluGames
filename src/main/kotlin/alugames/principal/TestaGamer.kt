package alugames.principal

import alugames.modelos.Gamer

fun main(){
    val gamer = Gamer("Olivia", "olivia@oxford.com")
    val gamer1 = Gamer("Billie", "billie@provedor.com", "09/04/1994", "@billie")

    println(gamer)
    println(gamer1)

    gamer.let {
        it.dataNascimento = "19/09/2002"
        it.idInterno = "@olivia1F"
        it.usuario = "@olivia"
    }

    println(gamer)
}