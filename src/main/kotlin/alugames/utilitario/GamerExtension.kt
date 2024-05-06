package alugames.utilitario

import alugames.modelos.Gamer
import alugames.modelos.InfoGamerJson

fun InfoGamerJson.criaGamer(): Gamer {
    return Gamer(this.nome, this.email, this.dataNascimento, this.usuario)
}