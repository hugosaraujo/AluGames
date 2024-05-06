import alugames.servicos.ConsumoApi

fun main(){
    val consumo = ConsumoApi()
    //val listaGamers = consumo.buscaGamer()
    val testaJogo = consumo.buscaJogo("151")

    //println(listaGamers)
    println(testaJogo)
}