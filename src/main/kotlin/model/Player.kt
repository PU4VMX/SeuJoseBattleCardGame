package model

// Declaração da classe Player, que representa um jogador com atributos.
class Player(nome: String, pontos: Int, baralho: List<Carta>, monstro: MutableList<Monstro>) {
    // Declaração das propriedades da classe Player.
    val nome: String
    var pontos: Int
    var baralho: List<Carta>

    // Bloco de inicialização (executado quando uma instância de Player é criada).
    init {
        // Atribui o valor do argumento "nome" à propriedade "nome".
        this.nome = nome
        // Atribui o valor do argumento "pontos" à propriedade "pontos".
        this.pontos = pontos
        // Atribui o valor do argumento "baralho" à propriedade "baralho".
        this.baralho = baralho
    }

    // Sobrescreve o método toString() para retornar uma representação de string do Player.
    override fun toString(): String {
        // Formata os atributos do jogador como uma string e retorna.
        return "$nome - $pontos - $baralho"
    }
}