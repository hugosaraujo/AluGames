package alugames.utilitario

import alugames.modelos.InfoJogosJson
import alugames.modelos.Jogo

fun InfoJogosJson.criaJogo(): Jogo {
    return Jogo(this.titulo, this.capa, this.preco, this.descricao)
}