package alugames.modelos

data class Gamer(var nome:String, var email:String) {
    var dataNascimento: String? = null
    var usuario: String? = null
    var idInterno: String? = null

    constructor(
        nome: String,
        email: String,
        dataNascimeto: String,
        usuario: String
    ) :
            this(nome, email) {
        this.dataNascimento = dataNascimeto
        this.usuario = usuario
    }

    override fun toString(): String {
        return """
            Usuário: $usuario, 
            Nome: $nome
            email: $email
        """.trimIndent()
    }
}