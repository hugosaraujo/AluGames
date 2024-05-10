package alugames.modelos

data class Aluguel(val gamer: Gamer, val jogo: Jogo, val periodo: Periodo ){
    private val precoAluguel = gamer.plano.obterValor(this)
    override fun toString(): String {
        return "Jogo ${jogo.titulo}, no aluguel de R$ %.2f, pago por ${gamer.nome}".format(precoAluguel)
    }
}
