package alugames.modelos

data class Aluguel(val gamer: Gamer,
                   val jogo: Jogo){
    override fun toString(): String {
        return "Jogo ${jogo.titulo} alugado por ${gamer.nome}"
    }
}
