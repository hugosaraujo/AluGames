import alugames.modelos.Periodo
import alugames.servicos.ConsumoApi
import java.time.LocalDate

fun main(){
    val consumo = ConsumoApi()
    val listaGamers = consumo.buscaGamer()
    val listaJogosJson = consumo.buscaJogoJson()

    //println(listaGamers)
    //println(listaJogosJson)

    val gamerCaroline = listaGamers.get(3)
    val jogo1 = listaJogosJson.get(7)

    val periodo = Periodo(LocalDate.now(), LocalDate.now().plusDays(3))
    val aluguel = gamerCaroline.alugaJogo(jogo1, periodo)
    println(aluguel)
}