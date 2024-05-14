package alugames.modelos

class PlanoAssinatura(
    tipo: String,
    val mensalidade: Double): Plano(tipo) {
    private val jogosIncluidos = 3
    private val percentualDeDescontoReputacao = 0.15
    override fun obterValor(aluguel: Aluguel): Double {
        val totalJogosNoMes = aluguel.gamer.jogosDoMes(aluguel.periodo.dataInicial.monthValue).size
        return if (totalJogosNoMes < jogosIncluidos) {
            0.0
        } else {
            var valorOriginal = super.obterValor(aluguel)
            if(aluguel.gamer.media > 8){
                valorOriginal -= valorOriginal * percentualDeDescontoReputacao
            }
            return valorOriginal
        }
    }

}