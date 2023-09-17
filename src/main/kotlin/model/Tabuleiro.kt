package model

class Tabuleiro(monstro: Monstro, player: Player) {
    val monstro: Monstro
    val player: Player

    init {
        this.monstro = monstro
        this.player = player
    }

    override fun toString(): String {
        return "$monstro - $player"
    }
}