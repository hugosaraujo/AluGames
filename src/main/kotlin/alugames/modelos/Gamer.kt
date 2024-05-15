package alugames.modelos

import java.util.*
import kotlin.random.Random

class Gamer(var nome:String, var email:String):Recomendavel {
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
    var plano: Plano = PlanoAvulso("BRONZE")
    val listaJogos = mutableListOf<Jogo?>()
    val jogosAlugados = mutableListOf<Aluguel>()
    private val listaNotas = mutableListOf<Int>()
    val jogosRecomendados = mutableListOf<Jogo>()
    override val media: Double
        get() = listaNotas.average()

    override fun recomendar(nota: Int) {
        if(nota < 1 || nota > 10) {
            println("Não é possível atribuir essa nota ao usuário!!!")
            println("Tente uma nota entre 1 e 10.")
        } else {
            println("Nota registrada com sucesso")
            listaNotas.add(nota)
        }
    }

    fun recomendarJogos(jogo: Jogo, nota: Int){
        jogo.recomendar(nota)
        jogosRecomendados.add(jogo)
    }

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
            reputação: $media
             
        """.trimIndent()

    }

    fun alugaJogo(jogo: Jogo, periodo: Periodo): Aluguel{
        val aluguel = Aluguel(this, jogo, periodo)
        jogosAlugados.add(aluguel)

        return aluguel
    }
    fun jogosDoMes(mes: Int): List<Jogo>{
        return jogosAlugados
            .filter { aluguel ->  aluguel.periodo.dataInicial.monthValue == mes}
            .map { aluguel ->  aluguel.jogo}
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