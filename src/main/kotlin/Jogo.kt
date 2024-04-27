class Jogo(
    val titulo:String,
    val capa:String ) {

    val descricao = ""

    override fun toString(): String {
        return """
            Jogo
            Título: $titulo
            Capa: $capa
            Descricao: $descricao
        """.trimIndent()
    }
}