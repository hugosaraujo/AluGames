package alugames.modelos

data class Aluguel(val gamer: Gamer, val jogo: Jogo, val periodo: Periodo ){
    val preocoAluguel = jogo.preco * periodo.emDias
    override fun toString(): String {
        return "Jogo ${jogo.titulo}, no aluguel de R$ $preocoAluguel, pago por ${gamer.nome} "
    }
}
