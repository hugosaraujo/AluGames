package alugames.modelos

import java.util.*
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
    var listaJogos = mutableListOf<Jogo?>()

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

//    init {
//        if(nome.isBlank()){
//            throw IllegalArgumentException("Nome é nulo ou está em branco")
//        }
//        email = validaEmail()
//    }

    private fun criaIdInterno(){
        val numero = Random.nextInt(1000)
        val tag = String.format("%04d", numero)

        idInterno = "$nome#$tag"
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
             
        """.trimIndent()

    }

    fun alugaJogo(jogo: Jogo): Aluguel{
        return Aluguel(this, jogo)
    }

    companion object{
        fun criarGamer(leitura: Scanner):Gamer{
            println("Bora fazer o seu cadastro!")
            print("Digite o seu nome: ")
            val nome = leitura.nextLine()
            print("Digite um email válido: ")
            val email = leitura.nextLine()
            print("Deseja fazer o cadastro completo? (S/N) ")
            val opcaoCadastroCompleto = leitura.nextLine()

            if (opcaoCadastroCompleto.equals("s", true)){
                print("Digite a sua data de nascimento (DD/MM/AAAA): ")
                val nascimento = leitura.nextLine()
                print("Digite seu nome de usuario: ")
                val usuario = leitura.nextLine()

                return Gamer(nome, email, nascimento, usuario)
            } else {
                return Gamer(nome, email)
            }
        }
    }
}