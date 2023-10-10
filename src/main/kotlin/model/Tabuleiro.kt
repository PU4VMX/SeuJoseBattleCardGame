package model

// Declaração da classe Tabuleiro, que representa um tabuleiro de jogo com um jogador e um monstro (opcional).
class Tabuleiro(player: Player, monstro: Monstro? = null) {
    // Declaração das propriedades da classe Tabuleiro.
    val player: Player
    var monstro: List<Monstro>

    // Bloco de inicialização (executado quando uma instância de Tabuleiro é criada).
    init {
        // Atribui o valor do argumento "player" à propriedade "player".
        this.player = player
        // Cria uma lista contendo o monstro (ou uma lista vazia se o argumento "monstro" for nulo).
        this.monstro = listOf(monstro!!)
    }

    // Sobrescreve o método toString() para retornar uma representação de string do Tabuleiro.
    override fun toString(): String {
        // Formata os atributos do tabuleiro como uma string e retorna.
        return "$monstro - $player"
    }
}