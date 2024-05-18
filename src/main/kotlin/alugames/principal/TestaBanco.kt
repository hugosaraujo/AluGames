package alugames.principal

import alugames.dados.Banco

fun main() {
    val conexao = Banco.obterConexao()
    print(conexao)
}