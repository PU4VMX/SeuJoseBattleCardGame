package model

class Tabuleiro(player: Player, monstro: Monstro? = null) {
    val player: Player
    var monstro: List<Monstro>

    init {
        this.player = player
        this.monstro = listOf(monstro!!)
    }

    override fun toString(): String {
        return "$monstro - $player"
    }
}