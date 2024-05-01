package alugames.principal

import alugames.modelos.Gamer
import java.util.*

fun main(){
    val gamer = Gamer("Olivia", "olivia@oxford.com")
    val gamer1 = Gamer("Billie", "billie@provedor.com", "09/04/1994", "@billie")

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