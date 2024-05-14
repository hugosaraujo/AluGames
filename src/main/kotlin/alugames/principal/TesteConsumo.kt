package alugames.principal

import alugames.modelos.Periodo
import alugames.modelos.PlanoAssinatura
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
    val spiderMan = listaJogosJson[13]
    val codWarzone = listaJogosJson[8]


    val periodoJogo1 = Periodo(LocalDate.now(), LocalDate.now().plusDays(3))
    val periodoJogo2 = Periodo(LocalDate.now(), LocalDate.now().plusDays(7))
    val periodoJogo3 = Periodo(LocalDate.now(), LocalDate.now().plusDays(5))

    gamerCaroline.alugaJogo(godOfWar, periodoJogo1)
    gamerCaroline.alugaJogo(spiderMan, periodoJogo2)
    gamerCaroline.alugaJogo(codWarzone, periodoJogo3)

    val gamerCamila = listaGamers[5]
    gamerCamila.plano = PlanoAssinatura("PRATA", 9.90)
    gamerCamila.alugaJogo(godOfWar, periodoJogo1)
    gamerCamila.alugaJogo(spiderMan, periodoJogo2)
    gamerCamila.alugaJogo(codWarzone, periodoJogo3)
    gamerCamila.alugaJogo(codWarzone, periodoJogo3)

    gamerCamila.recomendar(10)
    gamerCamila.recomendar(6)
    gamerCamila.recomendar(8)

    println(gamerCamila)

}