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
    val spiderMan = listaJogosJson.get(13)
    val codWarzone = listaJogosJson.get(8)


    val periodoJogo1 = Periodo(LocalDate.now(), LocalDate.now().plusDays(3))
    val periodoJogo2 = Periodo(LocalDate.now(), LocalDate.now().plusDays(7))
    val periodoJogo3 = Periodo(LocalDate.now(), LocalDate.now().plusDays(5))

    val aluguel = gamerCaroline.alugaJogo(godOfWar, periodoJogo1)
    val aluguel2 = gamerCaroline.alugaJogo(spiderMan, periodoJogo2)
    val aluguel3 = gamerCaroline.alugaJogo(codWarzone, periodoJogo3)

    println(gamerCaroline.jogosAlugados)
}