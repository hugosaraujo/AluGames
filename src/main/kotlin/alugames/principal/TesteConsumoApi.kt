package alugames.principal

import alugames.modelos.Periodo
import alugames.servicos.ConsumoApi
import java.time.LocalDate

fun main(){
    val consumo = ConsumoApi()
    val listaGamers = consumo.buscaGamer()
    val listaJogosJson = consumo.buscaJogoJson()

    //println(listaGamers)
    //println(listaJogosJson)

    val gamerCaroline = listaGamers[3]
    val godOfWar = listaJogosJson[7]
//    val spiderMan = listaJogosJson.get(13)
//    val codWarzone = listaJogosJson.get(8)


    val periodo = Periodo(LocalDate.now(), LocalDate.now().plusDays(3))
    val aluguel = gamerCaroline.alugaJogo(godOfWar, periodo)
    println(aluguel)
}