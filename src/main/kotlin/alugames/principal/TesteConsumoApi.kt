import alugames.servicos.ConsumoApi

fun main(){
    val consumo = ConsumoApi()
    val listaGamers = consumo.buscaGamer()

    println(listaGamers)
}