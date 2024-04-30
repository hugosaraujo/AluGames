package alugames.modelos

import kotlin.random.Random

class Gamer(var nome:String, var email:String) {
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

    init {
        if(nome.isNullOrBlank()){
            throw IllegalArgumentException("Nome é nulo ou está em branco")
        }
        email = validaEmail()
    }

    private fun criaIdInterno(){
        val numero = Random.nextInt(1000)
        val tag = String.format("%04d", numero)

        idInterno = "$usuario#$tag"
    }

    private fun validaEmail():String{
        val regex = Regex("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$")

        if(regex.matches(email)){
            return email
        } else {
            throw IllegalArgumentException("Email inválido")
        }
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