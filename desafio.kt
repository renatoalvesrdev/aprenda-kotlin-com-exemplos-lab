// [Template no Kotlin Playground](https://pl.kotl.in/WcteahpyN)

enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

class Usuario(val nome: String)  // Adicionando a propriedade 'nome' ao construtor

data class ConteudoEducacional(var nome: String, val duracao: Int = 60)

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>) {

    val inscritos = mutableListOf<Usuario>()
    
    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)
    }

    fun desmatricular(usuario: Usuario) {
        inscritos.remove(usuario)
        println("${usuario.nome} foi desmatriculado da formação $nome")
    }

    fun calcularDuracaoTotal(): Int {
        var duracaoTotal = 0
        for (conteudo in conteudos) {
            duracaoTotal += conteudo.duracao
        }
        return duracaoTotal
    }
}

fun main() {
    // Criar alguns conteúdos educacionais
    val conteudo1 = ConteudoEducacional("Introdução à Programação", 90)
    val conteudo2 = ConteudoEducacional("Estruturas de Dados", 120)
    val conteudo3 = ConteudoEducacional("Algoritmos Avançados", 150)
    
    // Associar níveis aos conteúdos educacionais
    val nivelConteudoMap = mapOf(
        conteudo1 to Nivel.BASICO,
        conteudo2 to Nivel.INTERMEDIARIO,
        conteudo3 to Nivel.DIFICIL
    )
    
    // Criar uma formação e adicionar os conteúdos educacionais
    val formacao = Formacao("Ciência da Computação", listOf(conteudo1, conteudo2, conteudo3))

    // Criar alguns usuários
    val usuario1 = Usuario("Alice")
    val usuario2 = Usuario("Bob")
    val usuario3 = Usuario("Carol")

    // Matricular os usuários na formação
    formacao.matricular(usuario1)
    formacao.matricular(usuario2)
    formacao.matricular(usuario3)

    // Imprimir os inscritos na formação com seus nomes
    println("Inscritos na formação ${formacao.nome}:")
    for (inscrito in formacao.inscritos) {
        println("- ${inscrito.nome}")
    }
    
    // Imprimir o nível ao lado do conteúdo educacional
    println("Nível dos conteúdos educacionais:")
    for (conteudo in formacao.conteudos) {
        val nivel = nivelConteudoMap[conteudo]
        println("- ${conteudo.nome} -> Duração: ${conteudo.duracao} minutos  (Nível: $nivel)")
    }

    // Calcular a duração total dos conteúdos
    val duracaoTotal = formacao.calcularDuracaoTotal()
    println("Duração total da formação ${formacao.nome}: $duracaoTotal minutos")
   
    // Desmatricular um usuário
    formacao.desmatricular(usuario2)
}
