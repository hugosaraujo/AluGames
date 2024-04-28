package alugames.modelos

class Jogo(
    val titulo:String,
    val capa:String ) {

    var descricao:String? = null

    override fun toString(): String {
        return """
            Jogo
            Título: $titulo
            Capa: $capa
            Descricao: $descricao
        """.trimIndent()
    }
}