package alugames.modelos

import alugames.utilitario.formatoDecimalComDoisNumeros
import com.google.gson.annotations.Expose

data class Jogo(
    @Expose val titulo:String,
    @Expose val capa:String ):Recomendavel {

    var preco:Double = 0.0
    var descricao:String? = null
    val listaDeNotas = mutableListOf<Int>()
    override val media: Double
        get() = listaDeNotas.average().formatoDecimalComDoisNumeros()

    override fun recomendar(nota: Int) {
        if(nota < 1 || nota > 10) {
            println("Não é possível atribuir essa nota ao usuário!!!")
            println("Tente uma nota entre 1 e 10.")
        } else {
            println("Nota registrada com sucesso")
            listaDeNotas.add(nota)
        }
    }

    constructor(titulo:String, capa:String, preco: Double, descricao: String):
            this(titulo, capa ){
        this.preco = preco
        this.descricao = descricao
    }

    override fun toString(): String {
        return "(Jogo -> Titulo: $titulo, Preco: $preco, Descricao: $descricao, Reputação: $media)"
    }
}