package alugames.modelos

class PlanoAssinatura(
    tipo: String,
    val mensalidade: Double,
    val jogosIncluidos: Int): Plano(tipo) {
}