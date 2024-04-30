package alugames.modelos

import kotlin.random.Random

data class Gamer(var nome:String, var email:String) {
    var dataNascimento: String? = null
    var usuario: String? = null
        set(value){
            field = value
            if(idInterno.isNullOrBlank()){
                criaIdInterno()
            }
        }
    var idInterno: String? = null
        private set

    constructor(
        nome: String,
        email: String,
        dataNascimeto: String,
        usuario: String
    ) : this(nome, email) {
        this.dataNascimento = dataNascimeto
        this.usuario = usuario
        criaIdInterno()
    }

    fun criaIdInterno(){
        val numero = Random.nextInt(1000)
        val tag = String.format("%04d", numero)

        idInterno = "$usuario#$tag"
    }

    override fun toString(): String {
        return """
            Usuário: $usuario, 
            Nome: $nome
            email: $email
            idInterno: $idInterno
        """.trimIndent()
    }
}