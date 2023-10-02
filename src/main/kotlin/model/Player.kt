package model

class Player(nome: String, pontos: Int, baralho: List<Carta>, monstro: MutableList<Monstro>) {
    val nome: String
    var pontos: Int
    var baralho: List<Carta>

    init {
        this.nome = nome
        this.pontos = pontos
        this.baralho = baralho
    }

    override fun toString(): String {
        return "$nome - $pontos - $baralho"
    }
}