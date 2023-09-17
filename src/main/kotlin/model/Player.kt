package model

class Player(nome: String, pontos: Int, baralho: List<Carta>, monstro: List<Monstro>? = null, equipamento: List<Equipamento>? = null) {
    val nome: String
    val pontos: Int
    val baralho: List<Carta>
    var monstro: List<Monstro>? = null
    var equipamento: List<Equipamento>? = null

    init {
        this.nome = nome
        this.pontos = pontos
        this.baralho = baralho
        this.monstro = monstro
        this.equipamento = equipamento
    }

    override fun toString(): String {
        return "$nome - $pontos - $monstro - $equipamento"
    }
}