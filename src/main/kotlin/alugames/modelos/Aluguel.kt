package alugames.modelos

import alugames.utilitario.formatoDecimalComDoisNumeros

data class Aluguel(val gamer: Gamer, val jogo: Jogo, val periodo: Periodo ){
    private val precoAluguel = gamer.plano.obterValor(this).formatoDecimalComDoisNumeros()
    override fun toString(): String {
        return "Jogo ${jogo.titulo}, no aluguel de R$ ${precoAluguel} , pago por ${gamer.nome}"
    }
}
