package alugames.modelos

class PlanoAssinatura(
    tipo: String,
    val mensalidade: Double): Plano(tipo) {
    private val jogosIncluidos = 3
    override fun obterValor(aluguel: Aluguel): Double {
        val totalJogosNoMes = aluguel.gamer.jogosDoMes(aluguel.periodo.dataInicial.monthValue).size
        return if (totalJogosNoMes < jogosIncluidos) {
            0.0
        } else {
            super.obterValor(aluguel)
        }
    }

}