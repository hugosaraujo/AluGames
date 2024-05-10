package alugames.modelos

data class Aluguel(val gamer: Gamer, val jogo: Jogo, val periodo: Periodo ){
    private val preocoAluguel = jogo.preco * periodo.emDias
    override fun toString(): String {
        return "Jogo ${jogo.titulo}, no aluguel de R$ %.2f, pago por ${gamer.nome}".format(preocoAluguel)
    }
}
