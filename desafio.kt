// [Template no Kotlin Playground](https://pl.kotl.in/WcteahpyN)

enum class Nivel { BASICO, INTERMEDIARIO, AVANCADO }

data class Usuario(val nome: String, var idade: Int){
	override fun toString(): String	{
		return "Usuário: $nome que tem $idade anos"
    }
}

data class ConteudoEducacional(val nome: String, var duracao: Number, var nivel: Nivel){
	override fun toString(): String {
        return "Conteúdo: $nome com duração de $duracao horas e nível $nivel"
    }
}

class Formacao(val nome: String, var nivel: Nivel) {

    val inscritos = mutableListOf<Usuario>()
    val conteudos = mutableListOf<ConteudoEducacional>()
    
    infix fun matricular(usuario: Usuario): Unit {
        inscritos.add(usuario)
    }
    
    fun matricularVariosUsuarios(vararg usuarios: Usuario): Unit {
        usuarios.forEach {inscritos.add(it)}
    }
    
    infix fun adicionarConteudo(conteudo: ConteudoEducacional){
		conteudos.add(conteudo)
    }
    
    fun listarInscritos(): Unit {
        println("--------------------")
        println("Usuários Cadastrados")
        inscritos.forEach { println(it) }
        println("--------------------")
    }
    
    fun listarConteudos(): Unit {
        println("Conteúdos Cadastrados")
		conteudos.forEach { println(it) }
        println("--------------------")
    }
    
    override fun toString(): String {
        println("--------------------")
		return "Formacão de nome: $nome e nível $nivel"
    }
}

fun main() {
    val formacao: Formacao = Formacao(nome="Kotlin Developer", nivel=Nivel.INTERMEDIARIO)
    println(formacao.toString())
    formacao matricular Usuario("fulano", 20)
    formacao matricular Usuario("beltrano", 25)
    formacao.matricularVariosUsuarios(Usuario("cicrano", 21), Usuario("outro", 20))
    formacao adicionarConteudo ConteudoEducacional(nome="Kotlin Básico", duracao=2, nivel=Nivel.BASICO)
    formacao adicionarConteudo ConteudoEducacional(nome="Kotlin Avançado", duracao=4, nivel=Nivel.AVANCADO)
    formacao.listarInscritos()
    formacao.listarConteudos()
}
