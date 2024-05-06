import alugames.servicos.ConsumoApi

fun main(){
    val consumo = ConsumoApi()
    //val listaGamers = consumo.buscaGamer()
    val listaJogosJson = consumo.buscaJogoJson()

    //println(listaGamers)
    println(listaJogosJson)
}