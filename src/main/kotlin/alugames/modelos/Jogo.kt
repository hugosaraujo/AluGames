package alugames.modelos

data class Jogo( val titulo:String, val capa:String ) {

    var preco:Double? = 0.0
    var descricao:String? = null

    constructor(titulo:String, capa:String, preco: Double, descricao: String):
            this(titulo, capa ){
        this.preco = preco
        this.descricao = descricao
    }

    override fun toString(): String {
        return "(Jogo -> Titulo: $titulo, Preco: $preco, Descricao: $descricao )"
    }
}